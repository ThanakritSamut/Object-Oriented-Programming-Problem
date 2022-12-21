// 630510622_ธนกฤต
import java.util.Scanner;
import java.util.Arrays;
class Menu{
    public void setChoice(){
        System.out.println("**********");
        System.out.println("1.push");
        System.out.println("2.pop");
        System.out.println("3.show");
        System.out.println("4.exit");
        System.out.println("**********");
        System.out.print("Please select choice: ");
    }
    public int getChoice(){
        Scanner input = new Scanner(System.in);
        int Choice = input.nextInt();
        return Choice;
    }
}
class Stack{
    private int arr[];
    private int top;//ตำแหน่งล่าสุด
    private int capacity;//ความจุของช่อง
    private int data;//เก็บหมายเลข
    Scanner input = new Scanner(System.in);
    Stack(){
        arr = new int[5];
        capacity = 5;
        top = -1;
    }

    public void push(){//เพิ่มค่า
        if(isFull()){//call method isFull() เพื่อเช็คพื้นที่ว่าง
            System.out.println("Stack is full");
        }
        else{
            System.out.print("Enter data: ");
            data = input.nextInt();
            arr[top+1] = data;
            top += 1;
            //System.out.printf("top = %d",top);
        }
        System.out.println();
        System.out.println();
        
    }
    
    public int pop(){//นำค่าล่าสุดออก
        if(isEmpty()){
            System.out.println("stack is empty");
        }
        else{
            System.out.println("pop " + peek());
            System.out.println();
            System.out.println();
            return arr[top--];
        }
        return 0;
    }

    public void show(){//แสดงค่าทั้งหมด
        if(top == -1){
            System.out.print("stack is empty");
            System.out.println();
        }
        else{
            for(int i = 0 ; i <= top ; i++){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
        System.out.println();
    }
    public int peek()
    {
        if (!isEmpty()){
            return arr[top];
        }
        else{
            System.exit(1);
        }
        return -1;
    }
    public Boolean isEmpty(){
        return top == -1;
    }
    public Boolean isFull() {
        return top == capacity - 1;
    }
}
public class Lab05_3_630510622 {
    public static void main(String[] args) {
        int x;
        Menu c = new Menu();
        Stack s = new Stack();
        while(true){//วนจนกว่าจะinput 4
            c.setChoice();
            x = c.getChoice();
            if(x == 1){
                s.push();
            }
            else if(x == 2){
                s.pop();
            }
            else if(x == 3){
                s.show();
            }
            else{
                break;
            }
        }
        System.out.print("Bye bye");
    }
}
