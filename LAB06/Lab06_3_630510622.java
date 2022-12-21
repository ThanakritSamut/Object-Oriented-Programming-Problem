// 630510622_ธนกฤต
import java.util.Scanner;

//สร้าง class Star
class Star{
    private int number;
    private String star_name;
    private int VoteScore;

    public Star(int no,String s_name,int score){//เก็บค่าที่รับเข้ามา
        number = no;
        star_name = s_name;
        VoteScore = score;
    }

    public int Star_No(){//สำหรับส่งหมายเลขดารา
        return number;
    }

    public String starName(){//สำหรับส่งชื่อดารา
        return star_name;
    }

    public int voteScore(){//สำหรับส่งคะแนนโหวต
        return VoteScore;
    }

    public void plusScore(){//สำหรับการเพิ่มคะแนนโหวต
        VoteScore += 1;
    }
}

class Voter{
    private String voter_name;
    private int M_Number;
    private int F_Number;

    //เก็บค่าที่ส่งเข้ามา
    public Voter(String Name,int MStar,int FStar){
        voter_name = Name;
        M_Number = MStar;
        F_Number = FStar;
    }

    public String getName(){//สำหรับส่งชื่อคนโหวต
        return voter_name;
    }

    public int getM_number(){//สำหรับส่งหมายเลขดาราชายที่โหวต
        return M_Number;
    }

    public int getF_number(){//สำหรับส่งหมายเลขดาราหญิงที่โหวต
        return F_Number;
    }
}

public class Lab06_3_630510622{
    public static void main(String[] args) {
        
        String Vote_name;
        int N;//เก็บจำนวนคนโหวต
        int mNumber;//เก็บหมายเลขดาราชาย
        int fNumber;//เก็บหมายเลขดาราหญิง
        Scanner input = new Scanner(System.in);
        Star [] M = {new Star(1,"Nadech",0), new Star(2,"Wier",0), new Star(3,"Mario",0)};
        //ดาราชาย4คน
        Star [] F = {new Star(1,"Aum",0), new Star(2,"Yaya",0), new Star(3,"Bella",0)};
        //ดาราหญิง4คน
        Star [] Winner =  new Star[2];//คะแนนโหวตเยอะสุด
        //รับจำนวนคนโหวต = N
        System.out.print("Input N: ");
        N = input.nextInt();
        Voter [] vote = new Voter[N];
        System.out.println();
        for(int i = 0 ; i < N ; i++){
            System.out.printf("Input vote #%d\n",i+1);//ลำดับคนโหวต
            System.out.print("Input name: ");//ชื่อคนที่โหวต
            Vote_name = input.next();
            System.out.print("Input number of actor and number of actress: ");
            mNumber = input.nextInt();
            fNumber = input.nextInt();
            //v[i] = เก็บชื่อผู้โหวตและหมายเลขดาราที่โหวต
            vote[i] = new Voter(Vote_name, mNumber , fNumber);
            System.out.println();
        }
        checkAndPrintVote(M, F, vote, Winner);
        printGoodLuck(vote, Winner);
    }
    public static void checkAndPrintVote(Star M[], Star F[], Voter v[], Star Winner[]){
        for(int i=0;i<v.length;i++){
            if(v[i].getM_number() == 1){
                M[0].plusScore();
            }
            else if(v[i].getM_number() == 2){
                M[1].plusScore();
            }
            else{
                M[2].plusScore();
            }
            //หญิง
            if(v[i].getF_number() == 1){
                F[0].plusScore();
            }
            else if(v[i].getF_number() == 2){
                F[1].plusScore();
            }
            else{
                F[2].plusScore();
            }
        }

        //สร้าง array Winner เพื่อไว้หาดาราที่มีผลโหวตมากที่สุด 
        Winner[0] = M[0];
        Winner[1] = F[0];

        //ไล่ array สรุปคะแนน
        for(int j=0;j<M.length;j++){
            if(M[j].voteScore() > Winner[0].voteScore()){
                Winner[0] = M[j];
            }
            if(F[j].voteScore() > Winner[1].voteScore()){
                Winner[1] = F[j];
            }
        }
        //ดาราที่ได้โหวตเยอะสุด
        System.out.println("Top star award (Actor) goes to " + Winner[0].starName());
        System.out.println("Top star award (Actress) goes to " + Winner[1].starName());
    }
    public static void printGoodLuck(Voter v[],Star Winner[]){
        System.out.print("Good luck voter -> ");
        //เช็คคนที่โหวตตรงกับหมายเลขผู้ชนะ
        for(int i=0; i<v.length; i++){
            if(v[i].getM_number() == Winner[0].Star_No()){
                if(v[i].getF_number() == Winner[1].Star_No()){
                    //ชื่อผู้โหวตที่เป็นผู้โชคดีทั้งหมด
                    System.out.print(v[i].getName() + " ");
                }
            }
        }
    }
}