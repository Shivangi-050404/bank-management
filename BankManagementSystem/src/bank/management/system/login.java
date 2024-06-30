package bank.management.system;
import javax.swing.*;//from extended package of java therefore javax
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static java.awt.Font.BOLD;

public class login extends JFrame implements ActionListener {//class of swing package(jframe)
    JButton login;JButton clear;
    JButton signup;
    JTextField cardTextField;
    JPasswordField pinTextField;//this will make password invisible

    login(){//constructor
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//giving location of the image
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//scaling the image i1
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);// we cannot directly paste the image we need to use jlabel
        label.setBounds(70,10,100,100);//by default layout is centre
        add(label);//adding the image by passing object label
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno=new JLabel("CARD NO.");
        cardno.setFont(new Font("Raleway",BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway",BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);

         pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

         login=new JButton("SIGN IN");
        login.setBounds(300,270,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

         clear=new JButton("CLEAR");
        clear.setBounds(430,270,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

         signup=new JButton("SIGN UP");
        signup.setBounds(300,320,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,400);//this will give size of frame
        setVisible(true);
        setLocation(350,200);
    }

//top left se frame khulta h to change location we use set location

    public static void main(String[] args) {
        new login();//object of class
    }

    @Override
    public void actionPerformed(ActionEvent e) {//button pr click karne ke baad karna kya h yeh bataiyega hame
     if(e.getSource()==clear){
     cardTextField.setText("");
     pinTextField.setText("");
     }else if(e.getSource()==login){
         Conn conn=new Conn();
         String cardnumber=cardTextField.getText();
         String pinnumber=pinTextField.getText();
         String query="select * from login where cardno= '"+cardnumber+"' and pin_no= '"+pinnumber+"'";
         try{
            ResultSet rs=conn.s.executeQuery(query); //sara data result set ke andar store karva diya h
         //checking if data is present or not
             if(rs.next()){
                 setVisible(false);
                 new transactions(pinnumber).setVisible(true);
             }
             else {
                 JOptionPane.showMessageDialog(null,"Incorrect Card Number Or Pin ");
             }
         }
         catch(Exception ae){
             System.out.println(ae);
         }

     }else if(e.getSource()==signup){
      setVisible(false);// closing the current window and opening the new window of signup
      new signupone().setVisible(true);
     }
    }
}
