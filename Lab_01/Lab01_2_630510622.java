// 630510622_ธนกฤต
import java.util.Scanner;
import java.util.Arrays;
public class Lab01_2_630510622 {
    public static void main(String[] args) {
        int [] all_score = new int[99]; // เก็บข้อมูล
        Scanner sn = new Scanner(System.in);
        int max_ = 0,min_ = 0,num,count = 0;
        int i,less_avg = 0,sum = 0,avg = 0;
        System.out.println("Enter score between 1-100 or press 0 for stop");
        num = sn.nextInt();
        //System.out.printf("Num = %d \n", num);
        //System.out.printf("max_ = %d \n", max_);
        while(num != 0){// รับค่าวนไปเรื่อยๆจนเลขที่รับเป็น 0
            if(num > 100){
                System.out.println("Enter score again (between 1-100 or press 0 for stop)");
            }
            // บอกให้ผู้ใช้ใส่เลขใหม่
            else{// กระบวนการเก็บเลขไว้ใน arrays หาผลรวม นับจำนวนรอบเพื่อ avg
                all_score[count] = num;
                sum += all_score[count];
                count += 1;
            }
            num = sn.nextInt(); // รับค่าวนไป
        }
        Arrays.sort(all_score);//Sort น้อยไปมาก
        if(count != 0){
            max_ = all_score[98];
            min_ = all_score[99-count];
            avg = sum/count;
        }
        for(i = 98; i >= 99-count ; i--){
            if(all_score[i] < avg){
                less_avg += 1;
            }
        }
        System.out.printf("Maximum Score = %d \n", max_);
        System.out.printf("Minimum Score = %d \n", min_);
        System.out.printf("Average Score = %d \n", avg);
        System.out.printf("The number of students who scored below average score = %d \n", less_avg);
    }
    
}
