//630510625_ธนกฤต
import java.util.Scanner;

class Course{
    private int n_student;//จำนวนคน
    private String s_name;//ตัวแปรสำหรับเก็บชื่อ
    private int n_sub;//จำนวนวิชาของแต่ละคน
    private String [][] Course = new String [50][50];//เก็บชื่อและวิชาของแต่ละคน
    private String sub_for_search;//วิชาที่ต้องการเช็ค
    private int [] max_sub = new int [50];//วิชาที่มากที่สุดของแต่ละคน
    public void setData(){
        Scanner input = new Scanner (System.in);
        String all_course;//ตัวแปรสำหรับเก็บวิชาทั้งหมดต่อ1คน
        System.out.print("Input number of students: ");
        n_student = input.nextInt();
        for(int i = 0 ; i < n_student ; i++){
            System.out.print("Student name: ");
            s_name = input.next();
            System.out.print("Number of subject: ");
            n_sub = input.nextInt();
            if(max_sub[i] < n_sub){//เก็บค่าวิชามากสุดเพื่อลดการทำงานของloop
                max_sub[i] = n_sub;
            }
            System.out.print("Course list: ");
            for(int j = 0; j < n_sub ; j++){//เก็บแต่ละวิชาไว้ในarrays 2 มิติ
                all_course = input.next();
                Course[i][j+1] = all_course;
            }
            Course[i][0] = s_name;//Course[i][0] สำหรับเก็บชื่อของ student
        }
        System.out.print("Input subject for searching: ");
        sub_for_search = input.next();//input วิชาที่ต้องการเช็ค
    

    }
    public void printResult(){
        //Check who enroll the same coruse
        int num,num_;//ตัวแปรสำหรับเปลี่ยน ชนิดข้อมูลให้เป็นint เพื่อนำมาเปรียบเทียบกัน
        //System.out.print(max_sub);
        for(int i = 0 ; i < n_student ; i++){
            for(int j = 0 ; j < max_sub[i] ; j++){//วน loop ตาม max_sub ของแต่ละคน
                num = Integer.parseInt(Course[i][j+1]);//เปลี่ยนชนิดข้อมูลเป็น int
                //System.out.printf("num[%s][%s]: %s \n",i,j+1,num);
                num_ = Integer.parseInt(sub_for_search);//เปลี่ยนชนิดข้อมูลเป็น int
                if(num == num_){//เปรียบเทียบเพื่อแสดงชื่อคนที่ลงเรียนวิชาเดียวกัน
                    System.out.println(Course[i][0]);
                }
            }
        }
    }
}
public class Lab04_3_630510622{  
    public static void main(String args[]){
        Course c = new Course();
        c.setData();
        c.printResult();
    }
}