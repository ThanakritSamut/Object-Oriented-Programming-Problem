// 630510622_ธนกฤต
import java.util.Scanner;
import java.util.Arrays;
public class Lab02_2_630510622 {
    public static void main(String[] args) {
        int n,p1,p2;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N: ");
        n = input.nextInt();
        int [] temp = new int[n+7];//[n+1] เพราะใช้ในบรรทัดที่ 18
        int [] point1 = new int[n+7];//[n+7] เพราะ ดักกรณ๊ที่ user input < 6
        //ถ้า user input < 6 จะทำให้ Index out of bounds บริเวณบรรทัดที่26-32 แล้วแต่ว่าIndex เกินบรรทัดไหน
        for(int i = 1 ; i <= n ; i++){//รับค่า
            System.out.printf("Enter point#%d:" + " " ,i);
            p1 = input.nextInt();
            p2 = input.nextInt();
            temp = checkQuandrant(p1, p2,n);//เก็บค่าหลักจากประมวลผลเสร็จ
            //System.out.print(temp[1] + "\n");
            for(int j = 0 ; j < n+6 ; j++){//เช็ตตัวแปรtemp มาใส่ในpoint1
                // ทุกครั้งที่เมดท็อตส่งค่ากลับมา จะรีเทิร์นแค่1จุด เมือเมดท็อตทำงานอีกครั้ง จะประกาศตัวแปรใหม่ ทำให้arraysทุกช่อง มีค่า = 0
                if(temp[j] == 1){
                    point1[j] += 1;
                }
            }
        }
        System.out.printf("Number of points in Qaudrant1 = %d\n",point1[1]);
        System.out.printf("Number of points in Qaudrant2 = %d\n",point1[2]);
        System.out.printf("Number of points in Qaudrant3 = %d\n",point1[3]);
        System.out.printf("Number of points in Qaudrant4 = %d\n",point1[4]);
        System.out.printf("Number of points on X axis = %d\n",point1[5]);
        System.out.printf("Number of points on Y axis = %d\n",point1[6]);
        System.out.printf("Number of points on origin point = %d\n",point1[0]);
    }
    public static int[] checkQuandrant(int p1, int p2,int n){
        int [] count = new int[n+6];// ส่งค่า n เพราะ count[n] จะต้องสอดคล้องกับ temp[n]
        if(p1 > 0 && p2 > 0){//Q1
            count[1] += 1;
        }
        else if(p1 < 0 & p2 > 0){//Q2
            count[2] += 1;
        }
        else if(p1 < 0 && p2 < 0){//Q3
            count[3] += 1;
        }
        else if(p1 > 0 && p2 < 0){//Q4
            count[4] += 1;
        }
        else if((p1 == 0 && p2 > 0) || (p1 == 0 && p2 < 0)){//จุดบนแกน X
            count[5] += 1;
        }
        else if((p1 > 0 && p2 == 0) || p1 < 0 && p2 == 0){//จุดบนแกน Y
            count[6] += 1;
        }
        else {// p1 = 0 p2 = 0 Origin point!
            count[0] += 1;
        }
        return count;
    }
}