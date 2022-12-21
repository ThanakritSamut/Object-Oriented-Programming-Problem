// 630510622_ธนกฤต
import java.util.Scanner;

class Drawning{
    void drawTriangle(int N){
        for (int row  = 1; row <= N ; row ++){
            for (int col = 1; col <= row ; col++){
                System.out.print("*");
            }// end col
            System.out.println();
        }// end row 
    }// end method

    void drawTriangle(int N,char X){
        for (int row = N ; row >= 1 ; row--){
            for(int col = 1; col <= row ; col++){
                System.out.print(X);
            }
            System.out.println();
        }
    }
}
public class Lab06_1_630510622{
    public static void main(String[] args) {
        Drawning mydDrawning = new Drawning();
        Scanner input = new Scanner(System.in);
        int N; char X;
        System.out.print("Enter N: ");
        N = input.nextInt();
        System.out.print("Enter X: ");
        X = input.next().charAt(0);
        mydDrawning.drawTriangle(N);
        mydDrawning.drawTriangle(N, X);
    }
}