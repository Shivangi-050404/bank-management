package bank.management.system;
import java.sql.*; //java ko databases se connection
public class Conn {
    Connection c;
    Statement s;
 // 5 steps; most important:
 //registration
 //create connection
 //create statement
 //execute query
 //close connection
    //constructor//create connection
    //mysql is external so there are chances of error therefore we do exceptional handling
    public Conn(){
        try{
         //Class.forName(com.mysql.cj.jdbc.Driver);   we donot need to regiter for driver
         c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","1@JEEexam");
         s=c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}

