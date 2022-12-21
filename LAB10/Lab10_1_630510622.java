// 630510622 ธนกฤต
import java.util.Scanner;

abstract class Student{
    protected String name; //ชื่อนักเรียน
    protected int midtermScore; // คะแนนมิดเทอม
    protected int finalScore; // คะแนนไฟนอล

    public void setInfo(){ // กำหนดข้อมูล
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter name: ");
        name = input.nextLine(); //รับชื่อ
        System.out.printf("Enter midterm score: ");
        midtermScore = input.nextInt(); // รับคะแนนมิดเทอม
        System.out.printf("Enter final score: ");
        finalScore = input.nextInt(); // รับคะแนนไฟนอล
    }

    public String getName(){ //แสดงผลชื่อ
        return name;
    }

    public int getMidtermScore(){ //แสดงผลคะแนนมิดเทอม
        return midtermScore;
    }

    public int getFinalScore(){ //แสดงผลคะแนนไฟนอล
        return finalScore;
    }

    public abstract char calGrade(int totalScore);
}

class Undergraduate_Student extends Student{ //ป.ตรี
    private int projectScore; //คะแนนโปรเจค

    public void setProjectScore(){ // กำหนด projectScore
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter project score: ");
        projectScore = input.nextInt();
    }

    public int getProjectScore(){ //แสดงผลคะแนนโปรเจค
        return projectScore;
    }
    //Override
    public char calGrade(int totalScore){ // คำนวณหาเกรดที่ควรได้รับ
        return (totalScore >= 50 && projectScore >= 50)?'S' : 'U';
    }
}

class Graduate_Student extends Student{
    private int publicationNo;

    public void setPublicationNo(){ //กำหนดงานวิจัย
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter number of publications: "); //รับจำนวนงานวิจับ
        publicationNo = input.nextInt();
    }

    public int getPublicationNo(){ //แสดงผลจำนวนงานวิจัย
        return publicationNo;
    }
    
    //Override
    public char calGrade(int totalScore){ // คำนวณเกรดที่ควรได้รับ
        return (totalScore >= 60 && publicationNo >= 2)?'S' : 'U';
    }
}

public class Lab10_1_630510622{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Student[] std = new Student[100];
        int id = 0; //id ประจำของนักศึกษา #index
        char choice; // ระดับของปริญญา

        do{
            System.out.print("Enter undergraduate student or graduate student (u/g):"); // u = ป.ตรี g = ป.โท
            choice = input.nextLine().charAt(0);
            if(choice == 'u'){
                std[id] = new Undergraduate_Student();
                std[id].setInfo();//เก็บข้อมูล
                ((Undergraduate_Student)std[id]).setProjectScore();//เก็บคะแนนโปรเจค
                id++;
            }
            else if (choice == 'g'){
                std[id] = new Graduate_Student();
                std[id].setInfo();//เก็บข้อมูล
                ((Graduate_Student)std[id]).setPublicationNo();//เก็บจำนวนงานวิจัย
                id++;
            }
            else{
                System.out.println("Invalid Type of Student"); //ไม่เจอนักศึกษา
            }
            System.out.print("Enter another (y/n) ?");//รับข้อมูลต่อ yes / no
            choice = input.nextLine().charAt(0);
        }while(choice == 'y');//ทำต่อ

        reportGrade(std,id); //medthod ภายนอก รายงานผลเกรดของแต่ละคนและสรุปผลจำนวนเกรด
    }

    public static void reportGrade(Student[] std, int n){
        System.out.printf("\nGrade Report\n");
        System.out.printf("= = = = = = = = = = =\n");

        int num_S = 0;
        for(int i = 0 ; i < n; i++){//แสดงผลชื่อ และ ข้อมูลต่างๆของแต่ละคน
            System.out.printf("%s ",std[i].getName());
            int mid = std[i].getMidtermScore();
            int fn = std[i].getFinalScore();
            int totalScore = mid + fn;
            System.out.printf("gets grade ");

            char grade;
            if(std[i] instanceof Undergraduate_Student){
                grade = std[i].calGrade(totalScore);
            }
            else{
                grade = std[i].calGrade(totalScore);
            }
            System.out.printf("%c.\n",grade);

            if(grade == 'S')
            num_S++;
        }

        System.out.printf("Total: Grade U = %d\tGrade S = %d\n",n-num_S, num_S); //สรุปผลเกรด
    }

}