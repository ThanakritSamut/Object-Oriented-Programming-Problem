// 630510622_ธนกฤต
import java.util.Scanner;
public class Lab01_1_630510622
{
        public static void main(String[] args) {
        int A,B,C, ans=0;
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter A:");
        A = sn.nextInt();
        System.out.print("Enter B:");
        B = sn.nextInt();
        System.out.print("Enter C:");
        C = sn.nextInt();

        System.out.printf("%d %d ", A, B);

        ans = (A * A) + (B * B);
        while(ans <= C){
            System.out.printf("%d ", ans);
            A = B;
            B = ans;
            ans = (A * A) + (B * B);
            }
        }
        
    }
