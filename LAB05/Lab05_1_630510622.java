//630510625_ธนกฤต
import java.util.Scanner;
import java.util.Arrays;
class Subject{
    private char grade;
    private int credit;
    private int totalpoint;

    public void setData(int i){
        Scanner input = new Scanner(System.in);
        System.out.println("\nSubject #" + i);
        System.out.print("Input Grade: ");
        grade = input.nextLine().charAt(0);
        System.out.print("Input Credit: ");
        credit = input.nextInt();
    }

    public int getGradePoint(){
        switch(grade){
            case 'A' : return (4);
            case 'B' : return (3);
            case 'C' : return (2);
            case 'D' : return (1);
            case 'F' : default : return(0);
        }
    }
    public void calTotalPoint(){
        totalpoint = getGradePoint()*credit;
    }
    public int getCredit(){
        return credit;
    }

    public int getTotalPoint(){
        return totalpoint;
    }

    public void printData(int i){
        System.out.printf("Subject%d\t\t  %c\t\t%d\t\t %d\t\t%d\n",i,grade,getGradePoint(),credit,totalpoint);
    }
}

public class Lab05_1_630510622{
    public static void main(String[] args) {
        int i,N;
        int sumCredit = 0 , sumTotalPoint = 0;
        float gpa;

        Scanner input = new Scanner(System.in);
        System.out.print("input N: ");
        N = input.nextInt();
        Subject []subj = new Subject[N];

        for (i = 0 ; i < N ; i++){
            subj[i] = new Subject();
            subj[i].setData(i+1);
            subj[i].calTotalPoint();
            sumCredit += subj[i].getCredit();
            sumTotalPoint += subj[i].getTotalPoint();
        }
        gpa = (float)sumTotalPoint/sumCredit;
        System.out.println("\t\t\t  Grade\t\tGradePoint\t Credit\t  TotalPoint\t");
        for(i = 0 ; i < N ; i++){
            subj[i].printData(i+1);
        }
        System.out.println("Total   \t\t\t\t\t\t" + sumCredit+"\t\t" + sumTotalPoint);

        System.out.println("GPA = "+gpa);
        
    }
}