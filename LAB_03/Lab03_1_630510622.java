// 630510622_ธนกฤต
import java.util.Scanner;
class Human{
    private char gender;
    private float weight;
    private float height;
    private String Shape;
    public void setData(){
        Scanner inVar = new Scanner(System.in);
        do{
            System.out.print("Enter gender: ");
            gender = Character.toLowerCase(inVar.nextLine().charAt(0));    
        }while(gender != 'm' && gender != 'f' );
        System.out.print("Enter weight: ");
        weight = inVar.nextFloat();
        System.out.print("Enter height: ");
        height = inVar.nextFloat();
    }
    public void calShape(){
        if(gender == 'm'){
            if(weight <= (height - 100)){
                Shape = "Your Shape is OK";
            }
            else{
                Shape = "Your shape is not OK.";
            }
        }
        else{
            if(weight <= (height - 110)){
                Shape = "Your Shape is OK";
            }
            else{
                Shape = "Your shape is not OK.";
            }
        }

    }
    public void printResult(){
        System.out.print(Shape);
    }
}

public class Lab03_1_630510622 {
    public static void main(String[] args) {
        Human h = new Human(); // h = instance ของคลาส Human
        h.setData();
        h.calShape();
        h.printResult();
    }
}