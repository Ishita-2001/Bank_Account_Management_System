
import java.sql.*;
import java.util.Scanner;
import java.util.Calendar;

public class BankAccount_project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("   Welcome to Bank Management System   ");
        System.out.println("------------------------------------------------------------------");
        System.out.print("Date: " + cal.get(Calendar.DATE) + "/" + months[cal.get(Calendar.MONTH)] + "/" + cal.get(Calendar.YEAR));
        System.out.println("\t\t\t\t\t\t\t Time: " + cal.get(Calendar.HOUR) + "/" + cal.get(Calendar.MINUTE) + "/" + cal.get(Calendar.SECOND));
        int status = 1;
        while(status==1)
        {
            System.out.println("\n 1. BankAccount       2. Branch       3. Loan");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1-> {
                    System.out.println("---------------------------------------------------------------------------------------------");
                    System.out.println("                 BankAccount               ");
                    System.out.println("---------------------------------------------------------------------------------------------");
                    int s1=1;
                    while(s1==1)
                    {
                        System.out.println("1. Add new entry \t 2. Existing Bank Accounts \t 3. Deletion of any record  ");
                        int c1=sc.nextInt();
                        switch(c1)
                        {
                            case 1-> Insertion(1);
                            case 2-> {
                                System.out.println("--------------------------------------------------");
                                System.out.println("Ac_number \t Ac_holder_fname \t Ac_holder_lname \t Gender \t DOB \t Mobile_number \t Address \t Ac_type \t Balance ");
                                System.out.println("--------------------------------------------------");
                                OracleConnect(1);
                            }
                            case 3-> Deletion(1);
                        }
                        System.out.println("If you want to go back to the BankAccount section press 1: \nIf you want to go back to the main menu press any other key:  ");
                        s1 = sc.nextInt();
                    }
                }
                case 2->
                        {
                            System.out.println("----------------------------------------------------------------------------------");
                            System.out.println("                 Branch              ");
                            System.out.println("----------------------------------------------------------------------------------");
                            int s2=1;
                            while(s2==1)
                            {
                                System.out.println("1. Add new entry \t 2. Existing Branch List \t 3. Deletion of any record ");
                                int c2=sc.nextInt();
                                switch(c2)
                                {
                                    case 1-> Insertion(2);
                                    case 2-> {
                                        System.out.println("--------------------------------------------");
                                        System.out.println("Branch name \t Branch city \t Assets");
                                        System.out.println("--------------------------------------------");
                                        OracleConnect(2);
                                    }
                                    case 3-> Deletion(2);
                                }
                                System.out.println("If you want to go back to the Branch section press 1: \nIf you want to go back to the main menu press any other key:  ");
                                s2= sc.nextInt();
                            }
                        }
                case 3->
                        {
                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println("                 Loan              ");
                            System.out.println("-------------------------------------------------------------------------");
                            int s3=1;
                            while(s3==1)
                            {
                                System.out.println("1. Add new entry \t 2. Existing Loan Information  \t 3. Deletion of any record ");
                                int c3=sc.nextInt();
                                switch(c3)
                                {
                                    case 1-> Insertion(3);
                                    case 2->
                                    {
                                        System.out.println("---------------------------------------------");
                                        System.out.println("Loan number \t Branch name \t Amount");
                                        System.out.println("---------------------------------------------");
                                        OracleConnect(3);
                                    }
                                    case 3-> Deletion(3);
                                }
                                System.out.println("If you want to go back to the Loan section press 1: \nIf you want to go back to the main menu press any other key:  ");
                                s3= sc.nextInt();
                            }
                        }
            }
            System.out.println("If you want to go back to the main menu press 1: \nIf you want to EXIT press any other key: ");
            status = sc.nextInt();
        }

    }
    public static void OracleConnect(int d) {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
            Statement stmt=con.createStatement();
            switch(d) {

                case 1 -> {
                    System.out.println("\n");
                    ResultSet rs1 = stmt.executeQuery("select * from BankAccount");
                    while (rs1.next())
                        System.out.println(rs1.getInt(1) + "    " + rs1.getString(2) + "    " + rs1.getString(3) + "    " + rs1.getString(4) + "    " + rs1.getString(5) + "    " + rs1.getString(6) + "    " + rs1.getString(7) + "    " + rs1.getString(8) + "    " + rs1.getInt(9));
                }
                case 2-> {
                    System.out.println("\n");
                    ResultSet rs2 = stmt.executeQuery("select * from Branch");
                    while (rs2.next())
                        System.out.println(rs2.getString(1) + "    " + rs2.getString(2) + "    " + rs2.getString(3));
                }
                case 3-> {
                System.out.println("\n");
                ResultSet rs3 = stmt.executeQuery("select * from Loan");
                while (rs3.next())
                    System.out.println(rs3.getString(1) + "    " + rs3.getString(2) + "    " + rs3.getString(3));
            } }
            con.close();
        }catch(Exception e){ System.out.println(e.getMessage());}

    }
    public static void Insertion(int i)
    {
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="system";
        String pass="Oracle";
        Scanner sc=new Scanner(System.in);
        String sql;
                switch(i) {
                    case 1 -> {
                        System.out.println("enter Ac_number");
                        int Ac_number = sc.nextInt();
                        System.out.println("enter Ac_holder_fname");
                        String Ac_holder_fname = sc.next();
                        System.out.println("enter Ac_holder_lname");
                        String Ac_holder_lname = sc.next();
                        System.out.println("enter Gender");
                String Gender = sc.next();
                System.out.println("enter Dob");
                String Dob = sc.next();
                System.out.println("enter Mobile_number");
                String Mobile_number = sc.next();
                System.out.println("enter Address");
                String Address = sc.next();
                System.out.println("enter Ac_type");
                String Ac_type = sc.next();
                System.out.println("enter Balance");
                int Balance = sc.nextInt();
                sql = "insert into BankAccount values(" + Ac_number + ",'" + Ac_holder_fname + "','" + Ac_holder_lname + "','" + Gender + "','" + Dob + "','" + Mobile_number +"','" + Address + "','" + Ac_type + "'," + Balance + ")";
            }
            case 2 -> {
                System.out.println("enter Branch name");
                String Branch_name = sc.next();
                System.out.println("enter Branch city");
                String Branch_city = sc.next();
                System.out.println("enter Assets");
                String Assets = sc.next();
                sql = "insert into Branch values('" + Branch_name + "','" + Branch_city + "','" + Assets + "')";
            }
            case 3 -> {
                System.out.println("enter Loan number");
                int Loan_number = sc.nextInt();
                System.out.println("enter Branch name");
                String Branch_name = sc.next();
                System.out.println("enter Amount");
                int Amount = sc.nextInt();
                sql = "insert into Loan values(" + Loan_number + ",'" + Branch_name + "'," + Amount + ")";

            }
            default -> throw new IllegalStateException("Unexpected value: " + i);
        }
        Connection con;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection(url,user,pass);
            Statement stmt=con.createStatement();
            int m=stmt.executeUpdate(sql);
            if(m==1)
                System.out.println("Inserted successfully:"+sql);
            else
                System.out.println("Insertion failed"+sql);
            con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static void Deletion(int s)
    {
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="system";
        String pass="Oracle";
        Scanner sc=new Scanner(System.in);
        String sql;
        switch(s) {
            case 1-> {

                System.out.println("enter Primary key of the row you want to delete");
                int Primary_key = sc.nextInt();
                System.out.println("enter column of the Primary_key");
                String column = sc.next();
                sql = "delete from BankAccount where " + column + "=" + Primary_key + " ";
            }
            case 2-> {
                System.out.println("enter Primary key of the row you want to delete");
                int Primary_key = sc.nextInt();
                System.out.println("enter column of the Primary_key");
                String column = sc.next();
                sql = "delete from Branch where " + column + "=" + Primary_key + " ";
            }
            case 3-> {
                System.out.println("enter Primary key of the row you want to delete");
                int Primary_key = sc.nextInt();
                System.out.println("enter column of the Primary_key");
                String column = sc.next();
                sql = "delete from Loan where " + column + "='" + Primary_key + "' ";
            }
            default -> throw new IllegalStateException("Unexpected value: " + s);
        }
        Connection con;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection(url,user,pass);
            Statement stmt=con.createStatement();
            int m=stmt.executeUpdate(sql);
            if(m==1)
                System.out.println("Deletion Sucessfully :"+sql);
            else
                System.out.println("Deletion failed"+sql);
            con.close();
        }
        catch(Exception exc)
        {
            System.out.println(exc.getMessage());
        }
    }
}



