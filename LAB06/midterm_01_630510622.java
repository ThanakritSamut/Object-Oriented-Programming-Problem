// 630510622_ธนกฤต
import java.util.Scanner;
import java.util.Arrays;

class Triangle{
    private String Name_Triangle;
    private Double Base;
    private Double Height;

    public Triangle(String n,double h,double b){
        System.out.printf("The Area of TriangleA: %s = %.1f",n,(float)1/2*h*b);
    }
    
    public void setData(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input Name of Triangle: ");
        Name_Triangle = input.next();
        System.out.print("Input Height: ");
        Height = input.nextDouble();
        System.out.print("Input Base: ");
        Base = input.nextDouble();
    }
    
    public void calArea(){
        System.out.printf("The Area of Triangle: %s = %.1f",Name_Triangle,(float)1/2*Height*Base);
    }
}

public class midterm_01_630510622 {
    public static void main(String[] args) {
        System.out.print("Hello from 1st constructor\n");
        Triangle b = new Triangle("TriangleA",2,4);
        System.out.print("\n\n");
        System.out.print("Hello from 2st constructor\n");
        b.setData();
        b.calArea();
    }
    
}
