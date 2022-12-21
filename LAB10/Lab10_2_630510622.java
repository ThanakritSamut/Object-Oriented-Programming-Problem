// 630510622 ธนกฤต
import java.util.Scanner;
abstract class Shape2Dim{ 
    protected int N; // Size ของรูป
    public void setN(int n){
        N = n;
    }
}

class Rhombus extends Shape2Dim{ // สี่เหลี่ยมขนมเปียกปูน
    Rhombus(){
        N = 0;
    }
    
    void draw(){ // ทำการวาดตามไซส์ (N)
        if(N > 0){
            int j,i;
            String fsq = "%" + N + "c\n";
            String fsq2;
            System.out.printf(fsq,'*');
            for(i = 1; i < N ; i++){
                fsq2 = "%" + (N-i)+"c%"+(2*i)+"c\n";
                System.out.printf(fsq2,'*','*');
            }

            for(i = N-2; i >= 1; i--){
                fsq2 = "%" + (N-i)+"c%"+(2*i)+"c\n";
                System.out.printf(fsq2,'*','*');
            }
            System.out.printf(fsq,'*');
        }
    }
}

class Square extends Shape2Dim{ //สีเหลี่ยมจตุรัส
    Square(){
        N = 0;
    }
    void draw(){// ทำการวาดตามไซส์ (N)
        if(N > 0){
            int i,j;
            for(i = 1 ; i <= N ; i++){
                if(i == 1 || i == N){
                    for(j = 1 ; j <= N ;j++){
                        System.out.print("*");
                    }
                }
                else{
                    for(j = 1;j <= N ;j++){
                        if(j == 1 || j == N){
                            System.out.print("*");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
class Triangle extends Shape2Dim{ // สามเหลี่ยม
    Triangle(){
        N = 0;
    }
    void draw(){ // ทำการวาดตามไซส์ (N)
        if(N > 0){
            int j,i;
            String fsq = "%" + N + "c\n";
            String fsq2;
            System.out.printf(fsq,'*');
            for(i = 1; i < N-1 ; i++){
                fsq2 = "%" + (N-i)+"c%"+(2*i)+"c\n";
                System.out.printf(fsq2,'*','*');
            }
            for(i = 1 ; i <= N ; i++){
                System.out.print("* ");
            }
            System.out.println();
       }
    }
}
public class Lab10_2_630510622 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Shape2Dim[] shp = new Shape2Dim[100];
        char Type; // เก็บชนิดของรูปภาพ
        int Size; // เก็บขนาดของรูปภาพ
        System.out.print("Input M: "); //จำนวนรูป
        int M = input.nextInt();
        for(int i = 0 ; i < M ; i++){
            System.out.print("Input type (R S or T) and Size: "); //เลือก ชนิดของรูปและขนาด
            Type = input.next().charAt(0);
            Size = input.nextInt();
            if(Type == 'R'){ // R = สี่เหลี่ยมขนมเปียกปูน
                shp[i] = new Rhombus();
                shp[i].setN(Size);
                //((Rhombus)shp[i]).draw();
            }
            else if(Type == 'S'){ // S = สี่เหลี่ยมจตุรัส
                shp[i] = new Square();
                shp[i].setN(Size);
                //((Square)shp[i]).draw();
            }
            else{ // T = สามเหลี่ยม
                shp[i] = new Triangle();
                shp[i].setN(Size);
                //((Triangle)shp[i]).draw();
            }

        }
        //แสดงผลรูปภาพตามลำดับ -> Rhombus, Square, Triangle
        System.out.print("Rhombus\n");
        System.out.println();
        for(int i = 0; i < M; i++){
            if(shp[i] instanceof Rhombus){
                ((Rhombus)shp[i]).draw();
                System.out.println();
            }
        }
        System.out.print("Square\n");
        System.out.println();
        for(int i = 0; i < M; i++){
            if(shp[i] instanceof Square){
                ((Square)shp[i]).draw();
                System.out.println();
            }
        }
        System.out.print("Triangle\n");
        System.out.println();
        for(int i = 0; i < M; i++){
            if(shp[i] instanceof Triangle){
                ((Triangle)shp[i]).draw();
                System.out.println();
            }
        }
    }
    
}
