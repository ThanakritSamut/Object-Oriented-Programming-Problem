// 630510622_ธนกฤต
import java.util.Scanner;
import java.util.Arrays;

class Box{
    private String Name_Box;
    private Double Width;
    private Double Length;
    private Double Height;

    public Box(String n,double w,double l,double h){
        System.out.printf("The Volume of Box: %s = %.1f",n,w*l*h);
    }
    
    public void setData(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input Name of Box: ");
        Name_Box = input.next();
        System.out.print("Input Width: ");
        Width = input.nextDouble();
        System.out.print("Input Length: ");
        Length = input.nextDouble();
        System.out.print("Input Height: ");
        Height = input.nextDouble();
    }
    
    public void calVolume(){
        System.out.printf("The Volume of Box: %s = %.1f",Name_Box,Width*Length*Height);
    }
}

public class Lab05_2_630510622 {
    public static void main(String[] args) {
        System.out.print("Hello from 1st constructor\n");
        Box b = new Box("SizeA",14,20,6);
        System.out.print("\n\n");
        System.out.print("Hello from 2st constructor\n");
        b.setData();
        b.calVolume();
    }
    
}
