import java.util.Scanner;

public class sest {

    public static void main(String[] args) {

        System.out.print("Enter your name:"); 
        Scanner scan = new Scanner(System.in);
        String name="";

        name+=scan.next();
        scan.close();

        System.out.println("Your name is :"+name); 

    }
}