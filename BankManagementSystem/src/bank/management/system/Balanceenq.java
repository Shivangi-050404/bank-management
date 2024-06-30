package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balanceenq extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    Balanceenq(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

       //yeh sab constructor ke under likh rhe h because i want ki jaise hi window open ho
        //vaise hi balance dikh jaye isliye mei within constructor likh rhe h

        Conn c=new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select *from bank where pin= '" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amonu"));
                }
            }
        }catch(Exception ae){
                System.out.println(ae);
            }

        JLabel text=new JLabel("Yor current Account Balance is : "+ balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); //uppar jo top mei white aa rha tha vo chala jayega
        setVisible(true);
    }

    public static void main(String[] args) {
        new Balanceenq("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new transactions(pinnumber).setVisible(true);
    }
}
