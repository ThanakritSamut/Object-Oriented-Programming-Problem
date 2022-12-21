// 630510622_ธนกฤต
import java.util.Scanner;

class std_w{//standard weight
    private String name;
    private int height;
    private int weight;
    private char sex;
    
    public std_w(String n,int h, int w, char s){
        name = n;
        height = h;
        weight = w;
        sex = s;
    }
    public String getName(){
        return name;
    }

    public int getHeight(){
        return height;
    }

    public int getWeight(){
        return weight;
    }

    public char getSex(){
        return sex;
    }

    public int std_wM(){
        height = height-100;
        return height;
    }

    public int std_wF(){
        height = height-110;
        return height;
    }
}
public class Lab06_2_630510622 {
    public static void main(String[] args) {
        std_w [] w = new std_w[2];
        std_w [] m = new std_w[1];//เก็บข้อมูลคนแรก
        std_w [] f = new std_w[1];//เก็บข้อมูลคนสอง
        Scanner input = new Scanner(System.in);
        String name;
        int height;
        int weight;
        char sex;
        for(int i = 0 ; i <= 1 ; i++){//รับข้อมูลใส่ใน w[i]
            System.out.printf("Input data for person #%d\n",i+1);
            System.out.print("Input name: ");
            name = input.next();
            System.out.print("Input height: ");
            height = input.nextInt();
            System.out.print("Input weight: ");
            weight = input.nextInt();
            System.out.print("Input sex: ");
            sex = input.next().charAt(0);
            w[i] = new std_w(name, height, weight, sex);
            System.out.println();
        }
        csw(w,m,f);//check standard weight
    }
    
    public static void csw(std_w w[], std_w m[], std_w f[]){
        m[0] = w[0];//คนแรก
        f[0] = w[1];//คนสอง
        int w_male = 0;
        int w_female = 0;
        for(int i = 0; i < 2; i++){
            if(w[i].getSex() == 'M' || w[i].getSex() == 'm'){
                w_male = m[0].std_wM();//ผช ดึงข้อมูลของ ผช มา
            }
            else{
                w_female = f[0].std_wF();//ผญ ดึงข้อมูลของ ผญ มา
            }
        }
        if(Math.abs(w_male - w[0].getWeight()) == Math.abs(w_female - w[1].getWeight())){//std_w ของทั้งสองเท่ากัน
            System.out.print("The weight of both of them are close to the standard weight equally");
        }
        else if(Math.abs(w_male - w[0].getWeight()) < Math.abs(w_female - w[1].getWeight())){//std_w ของคนแรกดีกว่าคนสอง
            System.out.printf("Weight of %s is closer to standard weight than %s\n",w[0].getName(),w[1].getName());
        }
        else{//std_w ของคนสองดีกว่าคนแรก
            System.out.printf("Weight of %s is closer to standard weight than %s\n",w[1].getName(),w[0].getName());
        }
    }
    
}
