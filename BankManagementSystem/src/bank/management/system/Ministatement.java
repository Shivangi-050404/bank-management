package bank.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Ministatement extends JFrame{
    String pinnumber;
    Ministatement(String pinnumber){
        this.pinnumber=pinnumber;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel total=new JLabel();
        total.setBounds(20,400,300,20);
        add(total);

        try{
       int balance=0;
            Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from login where pin_no='"+pinnumber+"'");
           while(rs.next()){
               card.setText("Card Number: "+rs.getString("cardno").substring(0,4)+"XXXXXXXX"+rs.getString("cardno").substring(12));  // card no. aa gaya h hamare paas aa gaya h
               if (rs.getString("type").equals("Deposit")) {
                   balance += Integer.parseInt(rs.getString("amount"));
               } else {
                   balance -= Integer.parseInt(rs.getString("amonut"));
               }
           }

           total.setText("Your current account balance is: "+balance);

        }catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
           //html tag can be used in java
                //we are using &nbsp to give spaces
                //setText do overriting but we want to append things
                //imp close html and br tag
                //br tag breaks
            }

        }catch(Exception ae){
            System.out.println(ae);
        }




        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);


    }
    public static void main(String[] args) {
        new Ministatement("");
    }
}
