//630510622_ธนกฤต
import java.util.Scanner;

class Personnel{
    protected String first_name , last_name;//สำหรับเก็บ ชื่อ และ นามสกุล
    protected int age;//สำหรับเก็บอายุ

    public void setInfo(){//กำหนดองค์ประกอบหลัก
        Scanner input = new Scanner(System.in);
        System.out.print("Input first name: ");
        first_name = input.next();
        System.out.print("Input last name: ");
        last_name = input.next();
        System.out.print("Input age: ");
        age = input.nextInt();
    }
    
    public String getFirstName(){//ส่งชื่อจริง
        return first_name;
    }
    
    public String getlastName(){//ส่งนามสกุล
        return last_name;
    }
    
    public int getAge(){//ส่งอายุ
        return age;
    }
}

class Teacher extends Personnel{//เก็บข้อมูลต่างๆ สำหรับ "อาจารย์"
    private int salary;//เงินเดือน
    public void SetSalary(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input salary: ");
        salary = input.nextInt();
    }

    public int getSalary(){//ส่งเงินเดือน
        return salary;
    }
}

class Students extends Personnel{////เก็บข้อมูลต่างๆ สำหรับ "นักศึกษา"
    private int studenYear;//ปีที่เรียน
    public void setYear(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input study year: ");
        studenYear = input.nextInt();
    }

    public int getYear(){//ส่ง ปีที่เรียน
        return studenYear;
    }
}
public class Lab07_1_630510622{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input N: ");//จำนวนคน
        int N = input.nextInt();

        Students[] s = new Students[N];
        int si=0;
        Teacher[] t = new Teacher[N];
        int ti=0;
        float avg;

        for (int i=0;i<N;i++){
            System.out.printf("\nInput person #%d (Teacher or Students): ",i+1);
            char choice = input.next().charAt(0);
            if(choice == 's' || choice == 'S'){
                //เรียกใช้ method สำหรับเก็บข้อมูล "นักศึกษา"
                s[si] = new Students();
                s[si].setInfo();
                s[si].setYear();
                si++;
            }else{
                //เรียกใช้ method สำหรับเก็บข้อมูล "อาจารย์"
                t[ti] = new Teacher();
                t[ti].setInfo();
                t[ti].SetSalary();
                ti++;
            }
        }
        //เรียกใช้ ฟังก์ชันสำหรับแสดงผลออกมาในรูปแบบของตาราง ของ "อาจารย์" และ "นักศึกษา" 
        if(ti!=0)printAllTeachers(t,ti);
        //สำหรับคำนวณและพิมพ์ ค่าเฉลี่ยอายุของ "นักศึกษา" และ "อาจารย์"
        avg = calAndPrintAvgAge(s,si,t,ti);
        if(ti!=0)countTeacher(t,ti,avg);
    }

    public static void printAllStudents(Students[] s,int n){//แสดงข้อมูลทั้งหมดของ "นักศึกษา"
        System.out.println("Students");
        System.out.println("\tFirstname\tLastname\tAge\tStudy year");
        String fname, lname;
        int age, year;
        for(int i=0;i<n;i++){
            fname = s[i].getFirstName();
            lname = s[i].getlastName();
            age = s[i].getAge();
            year = s[i].getYear();
            System.out.printf("%d\t%s\t\t%s\t\t%d\t%d\n",i+1,fname,lname,age,year);
        }
        System.out.println();
    }

    public static void printAllTeachers(Teacher[] t,int n){//แสดงข้อมูลทั้งหมดของ "อาจารย์"
        System.out.println("Teachers");
        System.out.println("\tFirstname\tLastname\tAge\tSalary");
        String fname, lname;
        int age, salary;
        for(int i=0;i<n;i++){
            fname = t[i].getFirstName();
            lname = t[i].getlastName();
            age = t[i].getAge();
            salary = t[i].getSalary();
            System.out.printf("%d\t%s\t\t%s\t\t%d\t%d\n",i+1,fname,lname,age,salary);
        }
        System.out.println();
    }
    // คานวณและพิมพ์ ค่าเฉลี่ยอายุนักศึกษา และ ค่าเฉลี่ยอายุอาจารย์ 
    public static float calAndPrintAvgAge(Students[] s, int si, Teacher[] t, int ti){
        float avgStudentsAge, avgTeacherAge = 0f;
        int i;

        if(si!=0){
            int sumStudentsAge = 0;
            for(i=0;i<si;i++){
                sumStudentsAge += s[i].getAge();
            }
            avgStudentsAge = (float)sumStudentsAge/si;
            System.out.printf("Average of Students age = %.2f\n",avgStudentsAge);
        }

        if(ti!=0){
            int sumTeacherAge = 0;
            for(i=0;i<ti;i++){
                sumTeacherAge += t[i].getAge();
            }
            avgTeacherAge = (float)sumTeacherAge/ti;
            System.out.printf("Average of teacher age = %.2f\n",avgTeacherAge);
        }
        return avgTeacherAge;
    }

    public static void countTeacher(Teacher[] t, int n, float avg){//นับและพิมพ์จานวนอาจารย์ที่มีอายุต่ำกว่าค่าเฉลี่ยอายุอาจารย
        int numTBelowAge=0;

        for(int i=0;i<n;i++){
            if((float)t[i].getAge()<avg){
                numTBelowAge += 1;
            }
        }
        System.out.printf("Number of teachers who have age below average = %d\n",numTBelowAge);
    }
}