// 630510622_ธนกฤต
import java.util.Scanner;

class Matrix{
    private int size;// declare size of Matrix
    private int [][] data = new int [50][50];// arrays 2D
    boolean identityStatus;// check status of Identity matrix

    public void setSize(){// input size ; 5 -> size (5 x 5)
        Scanner input = new Scanner (System.in);
        System.out.print("Input size : ");
        size = input.nextInt();
    }
    public void setData(){
        int i,j;
        Scanner input = new Scanner(System.in);
        for(i = 0;i < size ; i++){//row
            for(j = 0; j < size ; j++){//col
                System.out.printf("Input number [%d][%d] : ",i,j);
                data[i][j] = input.nextInt();
            }
            System.out.println();
        }
    }
    public void CheckIdentity(){
        int i,j;
        identityStatus = true;
        for(i = 0;i < size && identityStatus;i++){
            for(j = 0;j < size && identityStatus;j++){
                if((i == j) &&(data[i][j] != 1)){// i == j for identity matrix
                    identityStatus = false;// != 1 -> not identity matrix
                }
                else if((i != j) && (data[i][j] != 0)){
                identityStatus = false;
                }
            }
        }
    }
    public void ShowIdentity(){// print status of identity matrix
        if(identityStatus){
            System.out.print("This matrix is identity matrix.");
        }
        else{
            System.out.print("This matrix is not identity matrix.");
        }// end showIdentity
    }
}
public class Lab04_1_630510622 {
    public static void main(String[] args) {
        Matrix m = new Matrix();
        // call sub-class
        m.setSize();
        m.setData();
        m.CheckIdentity();
        m.ShowIdentity();
    }
}