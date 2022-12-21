//630510622 ธนกฤต สมุทร
import java.util.Scanner;

class Queue<TYPE>{
    private int N;
    private final Object[] item; 
    private int front;
    private int rear;
    private int count;
    
    Queue(int x){ //constructer
        N = x;
        item = new Object[N];
        front = 0;
        rear = -1;
        count = 0;
    }
    
    public void enqueue(TYPE v){ //เพิ่มข้อมูลเข้าไปในอาเรย์
        if(rear < N-1){
            rear++;
            item[rear] = v;
            count++;
            System.out.println("OK");
    
        }
    }
    public void dequeue(){ //ลบข้อมูลออกจากอาเรย์
        if(isEmty() == false){
            System.out.println(item[front]);
            item[front] = null; 
            front++;
            count--;
        }
        else{
            System.out.println("Queue is empty.");
        }
    }
    
    public boolean isEmty(){ //สำหรับเช็คว่าอาเรย์ว่าง ?
        if(count == 0){
            return(true);
        }
        else{
            return(false);
        }
    }

    public boolean isFull(){ //สำหรับเช็คว่าอาเรย์เต็ม ?
        if(rear == N-1){
            return(true);
        }
        else{
            return(false);
        }
    }
    
    public void show(){ //แสดงข้อมูลทั้งหมดในอาเรย์
        if(isEmty() == true){ // ถ้าไม่มีข้อมูล แสดงข้อความ "Nothing to show."
            System.out.println("Nothing to show.");
        }else{
            for(int i=front;i<=rear;i++){ // แสดงข้อมูลใน arrays
                System.out.print(item[i] + " ");
            }
            System.out.println();
        }
    }
}

public class Lab11_2_630510622 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input N : ");
        int n = input.nextInt();
        System.out.print("Select int or char(i or c) : ");
        char c = input.next().charAt(0);
        int menuChoice;
        if(c == 'i'){ //loop menu
            Queue<Integer> dataList = new Queue(n);
            int value;
            do{ // แสดง options ที่เลือกได้ 1-4
                System.out.println();
                System.out.println("1) enqueue");
                System.out.println("2) dequeue");
                System.out.println("3) show");
                System.out.println("4) exit");
                System.out.print("Select choice : ");
                menuChoice = input.nextInt();
                if(menuChoice == 1){ // เพิ่มข้อมูล
                    if(dataList.isFull()){
                        System.out.println("Queue is full.");
                    }else{
                        System.out.print("Input data for enqueue : ");
                        value = input.nextInt();
                        dataList.enqueue(value);
                    }
                }
                else if(menuChoice == 2){ // ลบข้อมูล
                    dataList.dequeue();;
                }
                else if(menuChoice == 3){ // แสดงผลข้อมูลทั้งหมด
                    dataList.show();
                }
                else{ // ออกจาก option
                    System.out.println("Bye.");
                }
                System.out.println("*******************************************************");            
            }while(menuChoice != 4); // 4 = exist
        }
        else{ // c == 'c'
            Queue<Character> dataList = new Queue(n);
            char value;
            do{
                System.out.println();
                System.out.println("1) enqueue");
                System.out.println("2) dequeue");
                System.out.println("3) show");
                System.out.println("4) exit");
                System.out.print("Select choice : ");
                menuChoice = input.nextInt();
                if(menuChoice == 1){
                    if(dataList.isFull()){
                        System.out.println("Queue is full.");
                    }
                    else{
                        System.out.print("Input data for enqueue : ");
                        value = input.next().charAt(0);
                        dataList.enqueue(value);
                    }
                }
                else if(menuChoice == 2){
                    dataList.dequeue();
                }
                else if(menuChoice == 3){
                    dataList.show();
                }
                else{
                    System.out.println("Bye.");
                }
                System.out.println("*******************************************************");              
            }while(menuChoice != 4);
        
        }
    }
    
}
