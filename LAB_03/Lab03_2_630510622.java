// 630510622_ธนกฤต
import java.util.Scanner;
class Parking{
    private char type;
    private int parking_times;
    private double cost;
    public void setData(){
        Scanner inVar = new Scanner(System.in);
        System.out.print("Enter vehicle type: ");
        type = Character.toLowerCase(inVar.nextLine().charAt(0));
        System.out.print("Enter minute: ");
        parking_times = inVar.nextInt();
    }
    public void Calcost(){
        if(type == 'c'){
            if(parking_times > 0 && parking_times <= 60){
                cost = parking_times*1;
            }
            else if(parking_times <= 120){
                cost = 60+((parking_times-60)*0.75);
            }
            else if(parking_times <= 240){
                cost = 105+((parking_times-120)*0.50);
            }
            else{// parking_times >= 241
                cost = 165+((parking_times-240)*0.25);//60(1) + 45(2) + 60(3,4)
            }

        }
        else{
            cost = parking_times%60;
            if(cost == 0){
                cost = (parking_times/60)*5;
            }
            else{
                cost = ((parking_times/60)+1)*5;
            }

        }

    }
    public void printResult(){
        System.out.printf("Cost = %.2f baht(s)\n",cost);
    }
}



public class Lab03_2_630510622 {
    public static void main(String[] args) {
        Parking p = new Parking();
        for(int i = 1 ; i <= 2 ; i++){
            System.out.printf("Enter data for vehicle parking#%d\n",i);
            p.setData();
            p.Calcost();
            p.printResult();
        }
    }   
}
