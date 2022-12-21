//630510622_ธนกฤต
import java.util.Scanner;

class Employee{ // Base Class องค์ประกอบหลักของพนักงานทุกคน
    protected String id;//ไอดีของพนักงาน
    protected String name;//ชื่อของพนักงาน
    //รายชื่อของพนักงานถูกออกแบบ ให้ไม่เกิน 15 ตัวอักษร (รวมช่องว่างระหว่างชื่อและสกุล)
    public void setInfo(){//กำหนดองค์ประกอบหลัก
        Scanner input = new Scanner(System.in);
        System.out.print("\nInput id: ");
        id = input.next();
        System.out.print("Input name: ");
        name = input.nextLine();
        name += input.nextLine();
    }

    public String getId(){//ส่งไอดีพนักงาน
        return id;
    }

    public String getName(){//ส่งชื่อพนักงาน
        return name;
    }
}
class Monthly_Employee extends Employee{//พนักงานรายเดือน
    private int salary;//เงินเดือน
    private int overtimePeriod;//คาบการทำงานล่วงเวลา
    private int overtimeWage;//ค่าทำงานล่วงเวลา
    Scanner input = new Scanner(System.in);
    public void setInfo_Monthly(){//เก็บข้อมูล เงินเดือน คาบทำงานล่วงเวลา
        System.out.print("Input salary: ");
        salary = input.nextInt();
        System.out.print("Input overtime period: ");
        overtimePeriod = input.nextInt();
    }

    public int getSalary(){//ส่งจำนวนเงินเดือน
        return salary;
    }

    public void calMonthlyWage(){//ค่าทำงานล่วงเวลา
        overtimeWage = overtimePeriod*200;
    }

    public int getOvertimeWage(){//ส่งค่าทำงานล่วงเวลา
        return overtimeWage;
    }

}

class Commission_Employee extends Employee{//ค่าคอม.ของพนักงาน
    protected int commission;//ค่านายหน้า
    protected int totalSale;//ผลรวมการขายทั้งหมด
    protected int percentOfCommRate;//เปอร์เซ็นค่าคอม.
    protected int monthlyWage;//เงินค่าจ้างรายเดือน
    Scanner input = new Scanner(System.in);
    
    public void setInfo_Commission(){//เก็บข้อมูล ผลรวมการขาย เปอร์เซ็นค่าคอม.
        System.out.print("Input total sale: ");
        totalSale = input.nextInt();
        System.out.print("Input percent of commission rate: ");
        percentOfCommRate = input.nextInt();
    }

    public void calCommission(){//คำนวณค่าคอม.
        commission = (int)(totalSale * ((float)percentOfCommRate / 100));
    }

    public int getCommission(){//ส่งค่าคอม.
        return commission;
    }
}

class Weekly_Employee extends Commission_Employee{//พนักงานรายอาทิตย์
    private int weeklyRate;//เรทรายสัปดาห์
    private int weeklyWeek;//จำนวนสัปดาห์ในการทำงาน
    Scanner input = new Scanner(System.in);
    
    public void setInfo_Weekly(){//เก็บข้อมูล เรทรายสัปดาห์ และ จำนวนสัปดาห์การทำงาน
        System.out.print("Input weekly rate: ");
        weeklyRate = input.nextInt();
        System.out.print("Input working week: ");
        weeklyWeek = input.nextInt();
    }

    public void calMonthlyWage(){//คำนวณค่าจ้าง
        monthlyWage = weeklyRate*weeklyWeek;
    }

    public int getMonthlyWage(){//ส่งค่าจ้าง
        return monthlyWage;
    }
}

class Daily_Employee extends Commission_Employee{//พนักงายรายวัน
    private int dailyRate;//เรทรายวัน
    private int workingDay;//จำนวนวันทำงานใน1เดือน

    public void setInfo_Daily(){//เก็บข้อมูล เรทรายวัน และ จำนวนการทำงานใน1เดือน
        System.out.print("Input daily rate: ");
        dailyRate = input.nextInt();
        System.out.print("Input working day: ");
        workingDay = input.nextInt();
    }

    public void calMonthlyWage(){//คำนวณค่าจ้าง
        monthlyWage = dailyRate * workingDay;
    }

    public int getMonthlyWage(){//ส่งค่าจ้าง
        return monthlyWage;
    }
}

public class Lab07_2_630510622 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input Number of monthly employees: ");//จำนวนพนักงานรายเดือน
        int N_month = input.nextInt();//เก็บในตัวแปร N_month
        System.out.println();
        Monthly_Employee[] m = new Monthly_Employee[N_month];
        int ei_m = 0;//employee index month
        for(int i = 0; i < N_month ; i ++){
            System.out.printf("Input person #%d",i+1);
            //เรียกใช้ method สำหรับเก็บข้อมูล และ คำนวณค่าจ้าง
            m[ei_m] = new Monthly_Employee();
            m[ei_m].setInfo();
            m[ei_m].setInfo_Monthly();
            m[ei_m].calMonthlyWage();
            ei_m++;
            System.out.println();
        }

        System.out.print("\n\n");

        System.out.print("Input Number of weekly employees: ");//จำนวนพนักงานรายอาทิตย์
        int N_week = input.nextInt();//เก็บไว้ในตัวแปร N_week
        Weekly_Employee[] w = new Weekly_Employee[N_week];
        int ei_w = 0;//employee index week
        System.out.println();
        for(int j = 0 ; j < N_week ; j++){
            System.out.printf("Input person #%d",j+1);
            //เรียกใช้ method สำหรับเก็บข้อมูล และ คำนวณค่าจ้าง
            w[ei_w] = new Weekly_Employee();
            w[ei_w].setInfo();
            w[ei_w].setInfo_Commission();
            w[ei_w].setInfo_Weekly();
            w[ei_w].calCommission();
            w[ei_w].calMonthlyWage();
            ei_w++;
            System.out.println();
        }

        System.out.print("\n\n");

        System.out.print("Input Number of daily employees: ");//จำนวนพนักงานรายวัน
        int N_day = input.nextInt();//เก็บไว้ในตัวแปร N_day
        Daily_Employee[] d = new Daily_Employee[N_day];
        int ei_d = 0;//employee index day
        System.out.println();
        for(int k = 0 ; k < N_day ; k++){
            System.out.printf("Input person #%d",k+1);
            //เรียกใช้ method สำหรับเก็บข้อมูล และ คำนวณค่าจ้าง
            d[ei_d] = new Daily_Employee();
            d[ei_d].setInfo();
            d[ei_d].setInfo_Commission();
            d[ei_d].setInfo_Daily();
            d[ei_d].calCommission();
            d[ei_d].calMonthlyWage();
            ei_d++;
            System.out.println();
        }
        System.out.print("\t\t\t\t\tABC Company\n");
        //เรียกใช้ ฟังก์ชันสำหรับแสดงผลออกมาในรูปแบบของตาราง ของพนักงานในแต่ละแบบ
        if(ei_m != 0)printAllMonthly_Employee(m, ei_m);
        if(ei_w != 0)printAllWeekly_Employee(w, ei_w);
        if(ei_d != 0)printAllDaily_Employee(d, ei_d);
    }

    public static void printAllMonthly_Employee(Monthly_Employee[] m, int n) {//แสดงข้อมูลทั้งหมดของพนักงานรายเดือน
        System.out.println("\tMonthly Employees");
        System.out.println("\tID\t\t\tName\t\tSalary\t\tOvertime wage   Total");
        String ID,Name;
        int Salary,OvertimeWage,Total,All_Salary = 0,All_OvertimeWage = 0,All_Total = 0;
        for(int i = 0 ; i < n ; i++){
            ID = m[i].getId();
            Name = m[i].getName();
            Salary = m[i].getSalary();
            OvertimeWage = m[i].getOvertimeWage();
            Total = Salary + OvertimeWage;
            All_Salary += Salary;//เงินเดือนรวมกันทั้งหมดของพนักงาน
            All_OvertimeWage += OvertimeWage;//ค่าทำงานล่วงเวลาทั้งหมดของพนักงาน
            All_Total += Total;//จำนวนเงินทั้งหมด
            System.out.printf("\t%s\t\t\t%s\t%d\t\t%d\t\t%d\n",ID,Name,Salary,OvertimeWage,Total);
        }
        System.out.printf("\tTotal\t\t\t\t\t%d\t\t%d\t\t%d",All_Salary,All_OvertimeWage,All_Total);
        System.out.println();
        System.out.println();
    }
    public static void printAllWeekly_Employee(Weekly_Employee[] w, int n){//แสดงข้อมูลทั้งหมดของพนักงานรายอาทิตย์
        System.out.println("\tWeekly Employees");
        System.out.println("\tID\t\t\tName\t\tCommission\tMonthly wage   Total");
        String ID,Name;
        int Commission,Monthly_wage,Total,All_Commission = 0,All_Monthly_wage = 0,All_Total = 0;
        for(int i = 0 ;i < n ; i++){
            ID = w[i].getId();
            Name = w[i].getName();
            Commission = w[i].getCommission();
            Monthly_wage = w[i].getMonthlyWage();
            Total = Commission + Monthly_wage;
            All_Commission += Commission;//ค่าคอม.ทั้งหมดของพนักงาน
            All_Monthly_wage += Monthly_wage;//ค่าจ้างทั้งหมดของพนักงาน
            All_Total += Total;//จำนวนเงินทั้งหมด
            System.out.printf("\t%s\t\t\t%s\t%d\t\t%d\t\t%d\n",ID,Name,Commission,Monthly_wage,Total);
        }
        System.out.printf("\tTotal\t\t\t\t\t%d\t\t%d\t\t%d",All_Commission,All_Monthly_wage,All_Total);
        System.out.println();
        System.out.println();
    }
    public static void printAllDaily_Employee(Daily_Employee[] d, int n){//แสดงข้อมูลทั้งหมดของพนักงานรายวัน
        System.out.println("\tDaily Employees");
        System.out.println("\tID\t\t\tName\t\tCommission\tMonthly wage    Total");
        String ID,Name;
        int Commission,Monthly_wage,Total,All_Commission = 0,All_Monthly_wage = 0,All_Total = 0;
        for(int i = 0 ;i < n ; i++){
            ID = d[i].getId();
            Name = d[i].getName();
            Commission = d[i].getCommission();
            Monthly_wage = d[i].getMonthlyWage();
            Total = Commission + Monthly_wage;
            All_Commission += Commission;//ค่าคอม.ทั้งหมดของพนักงาน
            All_Monthly_wage += Monthly_wage;//ค่าจ้างทั้งหมดของพนักงาน
            All_Total += Total;//จำนวนเงินทั้งหมด
            System.out.printf("\t%s\t\t\t%s\t%d\t\t%d\t\t%d\n",ID,Name,Commission,Monthly_wage,Total);
        }
        System.out.printf("\tTotal\t\t\t\t\t%d\t\t%d\t\t%d",All_Commission,All_Monthly_wage,All_Total);
        System.out.println();
    }
}

