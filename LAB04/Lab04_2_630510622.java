// 630510622_ธนกฤต
import java.util.Scanner;
class Text{
    private String text;//ไว้เก็บข้อความที่inputเข้ามา
    public void setData(){
        Scanner input = new Scanner (System.in);
        System.out.print("Input text: ");
        text = input.nextLine();
    }
    public void Process(){
        int stringLenght = text.length();//นับสตริง
        String NewString;
        String newtext = "";
        for(int i = 0; i < stringLenght ; i++){
            int charValue = text.charAt(i);
            //โจทย์ให้รับแต่พิมพ์เล็ก ไม่ต้องกลัว output ไม่เป็นอักษรภาษาอังกฤษ
            NewString = String.valueOf((char)(charValue + 3));
            newtext += NewString;
            if(i%3 == 2){//แทรกช่องว่างหลังอักขระครบ3
                newtext += " ";
            }
        }
        while(stringLenght%3 != 0){//แทรกหากในกลุ่มอักขระไม่ครบ3
            newtext += "#";
            stringLenght += 1;
        }
        text = newtext.toUpperCase();//เปลี่ยนเป็นพิมพ์ใหญ่
    }
    public void printResult(){
        System.out.println(text);
    }
}

public class Lab04_2_630510622 {
    public static void main(String[] args) {
        Text t = new Text();
        t.setData();
        t.Process();
        t.printResult();
    }
}
