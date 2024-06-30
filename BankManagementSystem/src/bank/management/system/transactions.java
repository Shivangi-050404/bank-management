package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transactions extends JFrame implements ActionListener {
String pinnumber;
    JButton deposit,withdrawl,minstae,pinchange,fastcash,balanceenq,exit;
    transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Please Select Your Transactions");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);  //this will add directly to the frame but not above the text
         //using image.add  then it will be added above it

         deposit=new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

         fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

         minstae=new JButton("Mini Statement");
        minstae.setBounds(355,450,150,30);
        minstae.addActionListener(this);
        image.add(minstae);

         pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

         balanceenq=new JButton("Balance Enquiry");
        balanceenq.setBounds(355,485,150,30);
        balanceenq.addActionListener(this);
        image.add(balanceenq);

        exit=new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); //uppar jo top mei white aa rha tha vo chala jayega
        setVisible(true);


    }

    public static void main(String[] args) {
        new transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==exit)
           System.exit(0);
       else if(e.getSource()==deposit){
           setVisible(false);
           new Deposit(pinnumber).setVisible(true);
       }
       else if(e.getSource()==withdrawl){
           setVisible(false);
           new Withdrawl(pinnumber).setVisible(true);
       }
       else if(e.getSource()==fastcash){
           setVisible(false);
           new Fastcash(pinnumber).setVisible(true);
       }
       else if (e.getSource()==pinchange){
           setVisible(false);
           new Pinchange(pinnumber).setVisible(true);
       }
       else if(e.getSource()==balanceenq){
           setVisible(false);
           new Balanceenq(pinnumber).setVisible(true);
       }else if(e.getSource()==minstae){

           new Ministatement(pinnumber).setVisible(true);
       }
    }
}
