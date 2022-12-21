// 630510622_ธนกฤต
import java.util.Scanner;
//import java.lang.Math;
public class Lab02_3_630510622{
    public static void main(String[] args) {
        int num;
        boolean ans,ans1;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        num = input.nextInt();
        ans = checkOddEven(num);
        ans1 = checkPrime(num);
        if(ans == true && ans1 == true){//คู่,ไม่เป็นจำนวนเฉพาะ
            System.out.printf("%d is even number.\n",num);
            System.out.printf("%d is not prime number.",num);
        }
        else if(ans == false && ans1 == false){//คี่,จำนวนเฉพาะ
            System.out.printf("%d is odd number.\n",num);
            System.out.printf("%d is prime number.",num);
        }
        else if(ans == false && ans1 == true){//คี่ ไม่เป็นจำนวนเฉพาะ
            System.out.printf("%d is odd number.\n",num);
            System.out.printf("%d is not prime number.",num);
        }
        //ไม่มีจำนวนคู่ที่เป็นจำนวนเฉพาะ
    }
    public static boolean checkOddEven(int coe) {//
        if(coe % 2 == 0){//even
            return true;
        }
        else{//odd
            return false;
        }
    }
    public static boolean checkPrime(int prn) {// prn = prime or not
        int divide = 2;
        if(prn == 1 || prn == 2){
            return true;
        }
        //check prime or not prime
        while (divide <= Math.sqrt(prn)){//ตัวหารต้องไม่มากกว่า sqrt(num) จึงจะไม่เป็นจำนวนเฉพาะ
            if(prn % divide == 0){
                return true;
            }
            else if(divide == Math.sqrt(prn)){
                return false;
            }
            divide += 1;
        }
        return false; // กรณี sqrt(prn) มีค่าน้อยกว่า 2
    }
}