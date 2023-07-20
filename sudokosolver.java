import java.util.*;
public class sudokosolver {
    public static boolean solvesudoko(int sudoko[][],int row,int col){
        int nextrow=row;
        int nextcol=col+1;
        if(row==9){
            return true;
        }
        if(col+1==9){
            nextrow=row+1;
            nextcol=0;
        }
        if(sudoko[row][col]!=0){
            return solvesudoko(sudoko,nextrow,nextcol);
        }
        for(int place=1;place<=9;place++){
            if(issafe(sudoko,row,col,place)){
                sudoko[row][col]=place;
                if(solvesudoko(sudoko,nextrow,nextcol)){
                    return true;
                }
                sudoko[row][col]=0;
            }

        }
        return false;
    }
    public static boolean issafe(int sudoko[][],int row,int col,int place){
        //row
        for(int i=0;i<9;i++){
            if(sudoko[row][i]==place){
                return false;
            }
        }
        //column
        for(int i=0;i<9;i++){
            if(sudoko[i][col]==place){
                return false;
            }
        }
        //Grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoko[i][j]==place){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println("                 This is a sudoko solver                  ");
        System.out.println("enter the numbers(1 to 9) of a sudoko in row wise and enter 0 for spaces");
        int sudoko[][]=new int[9][9];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sudoko[i][j]=sc.nextInt();
            }
        }
        System.out.println("INPUT");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoko[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("OUTPUT");
        if(solvesudoko(sudoko,0,0)){
            System.out.println("solution exists");
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(sudoko[i][j]+" ");
                }
                System.out.println();
            }

        }else{
            System.out.println("solution doesnot exists");
        }


    }
    
}
