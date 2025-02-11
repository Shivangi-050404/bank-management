package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class signupone extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField;
    JTextField fnameTextField;JTextField emailTextField; JTextField cityTextField;JTextField stateTextField;JTextField addressTextField;JTextField pinTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser date;
    signupone(){
        setLayout(null);//it will bring in centre
        Random rand=new Random();
         random=Math.abs((rand.nextLong()%9000L)+1000L);
        JLabel formno=new JLabel("Application Form Number: "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);//tabhi kaam karta h jab set layout is null
        add(formno);

        JLabel personaldetails=new JLabel("Page 1:Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,80,400,30);//tabhi kaam karta h jab set layout is null
        add(personaldetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);//tabhi kaam karta h jab set layout is null
        add(name);

         nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);//tabhi kaam karta h jab set layout is null
        add(fname);

         fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        JLabel dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);//tabhi kaam karta h jab set layout is null
        add(dob);

        date=new JDateChooser();
        date.setBounds(300,240,200,30);
        add(date);



        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);//tabhi kaam karta h jab set layout is null
        add(gender);

         male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

         female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email=new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);//tabhi kaam karta h jab set layout is null
        add(email);

         emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel ms=new JLabel("Marital Status:");
        ms.setFont(new Font("Raleway",Font.BOLD,20));
        ms.setBounds(100,390,200,30);//tabhi kaam karta h jab set layout is null
        add(ms);

         married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

         unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

         other=new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup msgroup=new ButtonGroup();
        msgroup.add(married);
       msgroup.add(unmarried);
       msgroup.add(other);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);//tabhi kaam karta h jab set layout is null
        add(address);

         addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);//tabhi kaam karta h jab set layout is null
        add(city);

         cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);//tabhi kaam karta h jab set layout is null
        add(state);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);//tabhi kaam karta h jab set layout is null
        add(pincode);

         pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);

         next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);

        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }


    public static void main(String[] args) {
        new signupone();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno=""+random; //long value//now this get converted to string
        String name=nameTextField.getText();//we will get value from text field
        String fname=fnameTextField.getText();
        String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();//getUi vala return text field therefore type casting
        String gender=null;
        if(male.isSelected()){
            gender="male";
        }else if(female.isSelected()){
            gender="female";
        }
        String email=emailTextField.getText();
        String ms=null;
        if(married.isSelected())
            ms="married";
        else if(unmarried.isSelected())
          ms="unmarried";
        else if(other.isSelected())
            ms="other";

        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pincode=pinTextField.getText();

        try{
       if(name.equals("")){
           JOptionPane.showMessageDialog(null,"Name is Required");
           //this feature will help to show a pop up message
           // we also need to add at next button action listener//see above
       }else{
           Conn c=new Conn();
           String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+ms+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
          c.s.executeUpdate(query);// we have done database connectivity

           setVisible(false);
           new signuptwo(formno).setVisible(true);

       }
        }
        catch(Exception ae){
            System.out.println(ae);
        }
    }
}
