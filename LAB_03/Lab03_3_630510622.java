// 630510622_ธนกฤต
import java.util.Scanner;
class Student{
    private int Student_ID;
    private int Midterm_score;
    private int Final_score;
    private String Grade;
    private int all_score;
    public void setData(){
        Scanner inVar = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        Student_ID = inVar.nextInt();
        System.out.print("Enter midterm and final scores: ");
        Midterm_score = inVar.nextInt();
        Final_score = inVar.nextInt();
    }
    public void CalGrade(){
        all_score = Midterm_score + Final_score;
        if(all_score >= 85){
            Grade = "A";
        }
        else if(all_score >= 80){
            Grade = "B+";
        }
        else if(all_score >= 75){
            Grade = "B";
        }
        else if(all_score >= 60){
            Grade = "C+";
        }
        else if(all_score >= 55){
            Grade = "C";
        }
        else if(all_score >= 50){
            Grade = "D+";
        }
        else if(all_score >= 45){
            Grade = "D";
        }
        else{
            Grade = "F";
        }
    }
    public void printResult(int j){
        System.out.printf("%d %d   %d  %s\n",j,Student_ID,Midterm_score+Final_score,Grade);
    }


}

public class Lab03_3_630510622 {
    public static void main(String[] args) {
        int N;
        Scanner inVar = new Scanner(System.in);
        System.out.print("Enter N: ");
        N = inVar.nextInt();
        Student [] stu = new Student [N+1];
        for(int i = 1;i <= N ;i++){
            System.out.printf("Enter data for student #%d\n",i);
            stu[i] = new Student();
            stu[i].setData();
            stu[i].CalGrade();
        }
        for(int j = 1;j <= N ; j++){
            stu[j].printResult(j);
            
        }
    }
}
