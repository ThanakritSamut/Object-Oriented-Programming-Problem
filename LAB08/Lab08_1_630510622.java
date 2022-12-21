//630510622 ธนกฤต
import java.util.Scanner;

class Land{
    protected int landSize; // ขนาดที่ดิน
    Scanner input = new Scanner(System.in);
    public void setLandSize(){ // รับ Input ขนาดที่ดิน
        System.out.print("Enter land size: ");
        landSize = input.nextInt();
    }
}

class LandForHouse extends Land{
    protected int housePrice; // ราคาบ้าน
    private int saleStatus = 0; // สถานะ บ้านจับคู่กับที่ดิน 0:ยังไม่จับ 1:จับแล้ว
    Scanner input = new Scanner(System.in);
    public void setData(){// รับ input ราคาบ้าน
        System.out.print("Enter house price: ");
        housePrice = input.nextInt();
    }

    public int getHousePrice(){ // get ราคาบ้าน เพื่อนำไปคำนวณ
        saleStatus = 1;//เมื่อถูกเรียกใช้medthod นี้ แสดงว่าบ้านจับคู่กับ ที่ดินแล้ว
        return housePrice;
    }

    public int getSaleStatus(){//get สถานะบ้านเพื่อเช็คว่าบ้านหลังนี้มีที่ดินแล้วหรือยัง
        return saleStatus;
    }
}

class LandForSale extends LandForHouse{
    private String titleDeed; // หมายเลขโฉนดที่ดิน
    private int evaluatePrice; // ราคาที่ประเมิน
    private int saleStatus = 0; // สถานะการขาย 0:ไม่ขาย 1:ขาย
    private double salePrice; // ราคาขาย
    Scanner input = new Scanner(System.in);

    public void setData(){//รับ input ชื่อที่ดิน และ ราคาประเมิน
        System.out.print("Enter title deed: ");
        titleDeed = input.next();
        System.out.print("Enter Evaluate price: ");
        evaluatePrice = input.nextInt();
    }
    public void calSalePrice(int housePrice){ // สรุปราคาขาย
        salePrice = evaluatePrice + (0.1)*evaluatePrice + (0.05)*housePrice;
        //System.out.print("House price: " + housePrice);
        saleStatus = 1; // เมื่อเรียก medthod นี้ แสดงว่าที่ดินได้ถูกซื้อไปแล้ว สถานะ = 1
    }
    public int getSaleStatus(){// //get สถานะที่ดินเพื่อเช็คว่าที่ดินนี้มีบ้านแล้วหรือยัง
        return saleStatus;
    }
    public String getTitleDeed(){// get สำหรับจับคู่กับราคาที่ขายที่ดิน
        return titleDeed;
    }
    public double getSalePrice(){ // get สำหรับหาผลกำไร
        return salePrice;
    }
    
    public int getEvaluatePrice(){ // get สำหรับหาผลกำไร
        return evaluatePrice;
    }
}

public class Lab08_1_630510622 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of house: ");//จำนวนบ้านที่หาที่ดินทั้งหมด
        int num_house = input.nextInt();
        System.out.print("Enter number of lands: ");//จำนวนที่ดินทั้งหมด
        int num_land = input.nextInt();
        System.out.println();
        LandForHouse[] LH = new LandForHouse[num_house];
        int index_house = 0;
        for(int i = 0 ; i < num_house ; i++){//เก็บข้อมูลโดย call medthod
            System.out.printf("Enter Data for house #%d\n",i+1);
            LH[index_house] = new LandForHouse();
            LH[index_house].setLandSize();
            LH[index_house].setData();
            index_house++;
            System.out.println();
        }

        LandForSale[] LS = new LandForSale[num_land];
        int index_land = 0;
        for(int i = 0 ; i < num_land ; i++){//เก็บข้อมูลโดย call medthod
            System.out.printf("Enter Data for land #%d\n",i+1);
            LS[index_land] = new LandForSale();
            LS[index_land].setLandSize();
            LS[index_land].setData();
            index_land++;
            System.out.println();
        }
        //ฟังก์ชันนอก main สำหรับ จับคู่ บ้านกับที่ดิน, แสดงผลราคาขายแต่ละที่ดิน และ กำไรทั้งหมด
        printAllMatch(LH, index_house, LS, index_land);
    }
    
    public static void printAllMatch(LandForHouse[] LH, int index_house, LandForSale[] LS, int index_land){
        double SalePrice; // เงินที่ได้รับจากการขาย (ไม่หักราคาประเมิน)
        double profit = 0; // กำไร
        String Titledeed;// ชื่อที่ดิน
        
        System.out.print("Report for lands which can be sold\n");
                System.out.print("Title deed\tSale price\n");
                //ที่ดินไล่เช็คบ้าน **ถ้าที่บ้านไล่เช็คที่ดิน ลำดับการ input ของที่ดินจะไม่เรียงตาม output ตัวอย่าง**
        for(int j = 0 ; j < index_land ; j++){ // ที่ดิน
            for(int i = 0 ; i < index_house ; i++){ // บ้าน
                //ถ้าพื้นที่ ที่ดิน >= พื้นที่ บ้าน และ ที่ดินและบ้าน ถูกจับคู่แล้ว 
                if(LS[j].landSize >= LH[i].landSize && ((LS[j].getSaleStatus() == 0) && LH[i].getSaleStatus() == 0)){
                    LS[j].calSalePrice(LH[i].getHousePrice());//คำนวณราคาที่ดินที่ต้องจ่าย
                    //System.out.print(LS[j].getTitleDeed() + " : " + LS[j].getSalePrice());
                    SalePrice = LS[j].getSalePrice();//เก็บเงินได้ทั้งหมดที่ได้ สำหรับคำนวณกำไร
                    profit += (SalePrice - LS[j].getEvaluatePrice());//กำไร = เงินที่ได้ทั้งหมด - ราคาประเมิน
                    Titledeed = LS[j].getTitleDeed();//เก็บชื่อที่ดิน ไว้สำหรับแสดงผล
                    System.out.printf("%s\t\t%.2f",Titledeed,SalePrice); // แสดงผลชื่อที่ดิน และ เงินที่ได้รับจากการขาย
                    System.out.println();
                    break;//จับคู่ที่ดินและบ้านได้แล้ว ไม่ต้องจับต่อ -> ขึ้นไป for loop (line 107)
                }
            }
        }
        System.out.println();
        System.out.printf("Total profit = %.2f",profit); // สรุปผลกำไรในการขายที่ดินที่ขายออกทั้งหมด
    }
}