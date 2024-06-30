package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    String pinnumber;
    JButton deposit,withdrawl,minstae,pinchange,fastcash,balanceenq,exit;
    Fastcash(String pinumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Select Withdrawl amount");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);  //this will add directly to the frame but not above the text
        //using image.add  then it will be added above it

        deposit=new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl=new JButton("Rs 500");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        minstae=new JButton("Rs 2000");
        minstae.setBounds(355,450,150,30);
        minstae.addActionListener(this);
        image.add(minstae);

        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenq=new JButton("Rs 10000");
        balanceenq.setBounds(355,485,150,30);
        balanceenq.addActionListener(this);
        image.add(balanceenq);

        exit=new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);



        setSize(900,900);
        setLocation(300,0);
       // setUndecorated(true); //uppar jo top mei white aa rha tha vo chala jayega
        setVisible(true);


    }

    public static void main(String[] args) {
        new Fastcash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit) {

            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }else{
            String amount=((JButton)e.getSource()).getText().substring(3);  //Rs 500
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select *from bank where pin= '"+pinnumber+"'");
               int balance=0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance+=(Integer.parseInt(rs.getString("amount")));
                   }else{
                       balance-=(Integer.parseInt(rs.getString("amount")));
                   }
               }
               if(e.getSource()!=exit && balance < Integer.parseInt("amount")){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
               }
               Date date=new Date();
               String query="insert into bank values ('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
               c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Rs "+amount+"Withdrawn Successfully");
            setVisible(false);
            new transactions(pinnumber).setVisible(true);

            }catch (Exception ae){
                System.out.println(ae);
            }
        }
    }
}
