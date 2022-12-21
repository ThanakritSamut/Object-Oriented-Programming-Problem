// 630510622 ธนกฤต
import java.util.Scanner;

class OrderItem{
    Scanner input = new Scanner(System.in);
    private String foodName; // ชื่ออาหาร
    private int price; // ราคาอาหาร
    private int numDish; // จำนวนจานที่ต้องการสั่ง

    public void setData(){ // รับข้อมูลของท้งสามตัวแปร
        System.out.print("Enter food name: ");
        foodName = input.nextLine();
        System.out.print("Enter price: ");
        price = input.nextInt();
        System.out.print("Enter number of dishes: ");
        numDish = input.nextInt();
        System.out.print("*************************************************************");
    }

    public String getFoodName(){ // แสดงผล ชื่ออาหาร
        return foodName;
    }

    public int getPrice(){ // แสดงผล ราคาอาหาร
        return price;
    }

    public int getNumDish(){ // แสดงผล จำนวนจาน
        return numDish;
    }
}

class Order extends OrderItem{
    Scanner input = new Scanner(System.in);
    private String orderId; // ลำดับออเดอร์
    private String tableNo; // โต๊ะที่สั่ง
    private int numberOfItem = 0; // จำนวนชนิดของอาหาร
    private double totalPrice = 0; // ราคารวม
    private OrderItem [] item = new OrderItem[10]; // จำนวนอาหาร

    public void setData(){// รับข้อมูล ลำดับออเดอร์ โต๊ะ จำนวนชนิดของอาหาร
        System.out.print("Enter order ID: ");
        orderId = input.next();
        System.out.print("Enter Table No.: ");
        tableNo = input.next();
        System.out.print("Enter number of food items: ");
        numberOfItem = input.nextInt();
        System.out.print("*************************************************************\n");
    }

    public void addItem(){// นำรายการอาหาร สรุปลง item[i]
        for (int i = 0 ; i < numberOfItem ; i++){
            item[i] = new OrderItem();
            item[i].setData();
            System.out.println();
        }
    }

    public void showData(){ // แสดงผลข้อมูลรายการอาหารทั้งหมด ของ ออเดอร์นี้ และ โต๊ะนี้
        System.out.print("Order ID -" + orderId + "\tTable No. - " + tableNo + "\n");
        System.out.print("Food Name\tPrice/Dish(Baht) QTY\n");

        for(int i = 0; i < numberOfItem ; i++){ // แสดงผล ชื่ออาหารให้สอดคล้องกับ ราคา จำนวนจาน 
            System.out.printf("%s\t\t%s\t\t %s",item[i].getFoodName(),item[i].getPrice(),item[i].getNumDish());
            System.out.println();
        }
        for (int j = 0 ; j < numberOfItem ; j++){// สรุปราคาอาหารทั้งหมด
            totalPrice += (item[j].getPrice()) * (item[j].getNumDish());
        }
        System.out.printf("Total Price = %.0f Bath",totalPrice);
    }
}
public class Lab09_1_630510622 {
    public static void main(String[] args) {
        Order D = new Order();
        D.setData(); // เก็บข้อมูล
        D.addItem(); // รวมข้อมูล
        D.showData(); // แสดงผลข้อมูล
    }
}
