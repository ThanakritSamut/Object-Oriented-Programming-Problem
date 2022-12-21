// 630510622 ธนกฤต
import java.util.Scanner;

public class Lab11_1_630510622{
    public static final int N = 3;// จำนวนลูป 

    //medthod template
    public static <TYPE extends Comparable> TYPE getCenter(TYPE data[]){
        TYPE temp; // ตัวฝากค่า
        int i,j;
        //sorting
        for(i = 0; i < N ; i++){
            for(j = i+1; j < N ; j++){
                if(data[i].compareTo(data[j]) > 0){
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }

        return data[1]; // เลขตัวกลาง (Center)
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = 3; // ลูปสำหรับวนรับเลข
        Character [] cData = new Character[N]; //อักขระ 
        Integer [] iData = new Integer[N]; //เลขจำนวนเต็ม
        Float [] fData = new Float[N]; //ทศนิยม

        System.out.print("Enter 3 integer numbers\n"); // รับเลข 3 ตัว
        for(int i = 0 ; i < N ; i++){
            iData[i] = input.nextInt(); //เก็บข้อมูลใน arrays
        }

        System.out.print("Enter 3 characters\n"); // รับอักขระ 3 ตัว
        for(int i = 0 ; i < N ; i++){
            cData[i] = input.next().charAt(0); //เก็บข้อมูลใน arrays
        }

        System.out.print("Enter 3 float numbers\n");// รับเลขทศนิยม 3 ตัว
        for(int i = 0 ; i < N ; i++){
            fData[i] = input.nextFloat(); //เก็บข้อมูลใน arrays
        }
        
        System.out.println();

        // show data
        System.out.println(getCenter(iData));
        System.out.println(getCenter(cData));
        System.out.println(getCenter(fData));
    }
}