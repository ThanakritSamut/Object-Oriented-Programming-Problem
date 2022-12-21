// 630510622_ธนกฤต
import java.util.Scanner;
public class Lab02_1_630510622{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);// object ไว้ input ชื่อ input
        char ch; // char -> เก็บอักขระตัวเดียว ไว้เลือกฟังก์ชัน
        int number;// เก็บจำนวนไว้ในตัวแปร number
        System.out.print("Enter the Alphabet: ");
        ch = input.nextLine().charAt(0);//เก็บเฉพาะอักขระตัวแรกของข้อความที่ input
        System.out.print("Enter Number: ");
        number = input.nextInt();// เก็บเลขไว้ในตัวแปร number
        while(number < 2 || number > 10){// เลขต้องอยู่่ระหว่าง 2-10 มิฉะนั้น ต้อง input ใหม่เรื่อยๆ
            System.out.print("Enter Number: ");
            number = input.nextInt();
        }
        if(ch == 'A' || ch == 'a'){//เรียกใช้เมท็อต A
            printStartA(number);
        }
        else if(ch == 'B' || ch == 'b'){//เรียกใช้เมท็อต B
            printStartB(number);
        }
        else{//แสดงข้อความ ถ้า ch ไม่ใช่ อักขระชนิด A หรือ B
            System.out.println("Good Bye");
        }
    }
    public static void printStartA(int n) {
        int row,col;
        for(row = n; row >= 1 ; row--){
            for(col = 1;col <= row; col++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    /*---> ***
            **
             * 
    ch = A or a , number = 3
    */
   public static void printStartB(int n) {
       int row,col,space;
       for(row = 1; row <= n ; row++ ){
           for(space = 1 ; space <= n-row ; space++){
               System.out.print(" ");
           }
            for(col = (n-row) ; col < n ; col++){
                System.out.print("*");
            }
            System.out.print("\n");
       }
    /* --->   *
             **
            *** 
    ch = B or b , number = 3
    */
    } 
}