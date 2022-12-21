// 630510622_ธนกฤต
import java.util.Scanner;
public class Lab01_3_630510622 {
    public static void main(String[] args) {
        int Kombucha,sum,r,newbottle,NEXT,count=1;
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter N: ");
        Kombucha = sn.nextInt();// input ขวดที่ซื้อตอนแรก
        sum = Kombucha; // ตัวแปรไว้เก็บขวดที่กินทั้งหมด
        newbottle = Kombucha/5; // ขวดที่เอาไปแลกมาใหม่
        r = Kombucha % 5; // ขวดที่ไม่พอแลกใหม่(เศษ)
        NEXT = ((Kombucha/5)*2)+(Kombucha%5); // ตัวแปรไว้เช็คว่าแลกต่อได้มั้ย
        //System.out.printf("sum[%d] = %d\n", count, sum);
        while(NEXT >= 5){
            sum += newbottle*2;
            //count += 1;
            //System.out.printf("sum[%d] = %d\n", count, sum);
            newbottle = (NEXT/5);
            r = NEXT % 5;
            NEXT = ((newbottle)*2) + r;
        }
        sum += newbottle*2;
        System.out.printf("Total number of drinking bottles = %d ", sum);
        System.out.printf("The remaining empty bottles = %d \n", NEXT);
    }
    
}
