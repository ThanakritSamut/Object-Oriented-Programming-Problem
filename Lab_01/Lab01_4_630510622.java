// 630510622_ธนกฤต
import java.util.Scanner;
import java.util.Arrays;
public class Lab01_4_630510622 {
    public static void main(String[] args) {
        int [] A = new int[5];
        int [] B = new int [5];
        int [] C = new int [10];
        Scanner sn = new Scanner(System.in);
        int i,j,number;
        for(i = 0; i <= 9 ; i++){//เอาเลขใส่array A and B
            if(i < 5){
                if(i == 0){
                    System.out.println("Enter Array A");
                }
                number = sn.nextInt();
                A[i] = number;
            }
            else{
                if(i == 5){              
                    System.out.println("Enter Array B");
                }
                number = sn.nextInt();
                B[i-5] = number;
            }
        }
        for(i = 0;i <= 4; i++){//ยัด array A and B เข้า C
            C[i] = A[i];
            C[i+5] = B[i];
        }
        Arrays.sort(C);//Sort น้อยไปมาก
        for(i = 0 ;i<= 9;i++){// แสดงผลแบบปกติ
            System.out.print(C[i] + " ");
        }
        System.out.print("\n");
        /*System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        System.out.println(Arrays.toString(C));*/
    }
}
