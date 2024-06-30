package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class signuptwo extends JFrame implements ActionListener{
    String formno;
    JTextField nameTextField;
     JTextField pan;JTextField adhar;
    JButton next;
    JComboBox religion,category,education,occupation,income;
    JRadioButton ayes,ano,eyes,eno;

    signuptwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("New Account Application Form -Page 2");



        JLabel additionaldetails=new JLabel("Page 2:Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);//tabhi kaam karta h jab set layout is null
        add(additionaldetails);

        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);//tabhi kaam karta h jab set layout is null
        add(name);

        //for drop down
        String[] valReligion={"Hindu","Muslim","Sikh","Christian","Other"};
         religion =new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);//tabhi kaam karta h jab set layout is null
        add(fname);

        String [] valcategory={"General","OBC","SC","ST","Other"};
         category =new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);//tabhi kaam karta h jab set layout is null
        add(dob);

        String[] valincome={"Null","< 50 k","< 1 lac","< 2.5 lac","< 5 lac","< 9 lac",">= 9 lac"};
         income =new JComboBox(valincome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);//tabhi kaam karta h jab set layout is null
        add(gender);


        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);//tabhi kaam karta h jab set layout is null
        add(email);

        String[] valeducation={"Non Graduate","Graduation","Post-Graduation","Doctrate","Other"};
         education =new JComboBox(valeducation);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);



        JLabel ms=new JLabel("Occupation:");
        ms.setFont(new Font("Raleway",Font.BOLD,20));
        ms.setBounds(100,390,200,30);//tabhi kaam karta h jab set layout is null
        add(ms);

        String[] valoccupation={"Unemployed","Doctor","BusinessMan","Homemaker","Worker","Self Employed","Student","Retired"};
         occupation =new JComboBox(valoccupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);



        JLabel address=new JLabel("Pan No.:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);//tabhi kaam karta h jab set layout is null
        add(address);

        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city=new JLabel("Adhar No:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);//tabhi kaam karta h jab set layout is null
        add(city);

        adhar=new JTextField();
        adhar.setFont(new Font("Raleway",Font.BOLD,14));
        adhar.setBounds(300,490,400,30);
        add(adhar);

        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);//tabhi kaam karta h jab set layout is null
        add(state);

        ayes=new JRadioButton("Yes");
        ayes.setBounds(300,540,100,30);
        ayes.setBackground(Color.WHITE);
        add(ayes);

        ano=new JRadioButton("No");
        ano.setBounds(450,540,100,30);
        ano.setBackground(Color.WHITE);
        add(ano);

        ButtonGroup senior=new ButtonGroup();
        senior.add(ayes);
        senior.add(ano);



        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);//tabhi kaam karta h jab set layout is null
        add(pincode);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup exist=new ButtonGroup();
        exist.add(eyes);
        exist.add(eno);




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
        new signuptwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //String formno=""+random; //long value//now this get converted to string
        String sreligion=(String)religion.getSelectedItem();//we will get value from text field
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;

        if(ayes.isSelected()){
            seniorcitizen="Yes";
        }else if(ano.isSelected()){
            seniorcitizen="No";
        }

        String existing=null;
        if(eyes.isSelected())
            existing="Yes";
        else if(eno.isSelected())
           existing="No";


        String sadhar=adhar.getText();
        String span=pan.getText();


        try{

                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+existing+"','"+seniorcitizen+"')";
                c.s.executeUpdate(query);// we have done database connectivity
         //signup 3 vala
            setVisible(false);
            new signup3(formno).setVisible(true);

        }
        catch(Exception ae){
            System.out.println(ae);
        }
    }
}
