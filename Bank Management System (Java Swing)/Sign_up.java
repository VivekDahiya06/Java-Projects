package Java_Projects.Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
public class Sign_up {
    JFrame frame;
    int x,y,w,h,x1,y1,w1,h1,x2,y2,w2,h2,random;
    Sign_up(){
        x=650;y=30;w=200;h=80;
        x1=550;y1=50;w1=100;h1=35;
        x2=790;y2=680;w2=80;h2=30;
        // All elements of the Frame :
        Random r=new Random();
        random=r.nextInt(1000,9999);
        frame=new JFrame();
        JButton button1=new JButton("Next");
        JButton button2=new JButton("Back");
        JLabel label1 =new JLabel("APPLICATION FORM NO. "+random);
        JLabel label2=new JLabel("Page 1 : Personal Details");
        JLabel label3=new JLabel("Name : ");
        JLabel label4=new JLabel("Father's Name : ");
        JLabel label5=new JLabel("Date of Birth : ");
        JLabel label6=new JLabel("Gender : ");
        JLabel label7=new JLabel("Email Address : ");
        JLabel label8=new JLabel("Marital Status : ");
        JLabel label9=new JLabel("Address : ");
        JLabel label10=new JLabel("City : ");
        JLabel label11=new JLabel("State : ");
        JLabel label12=new JLabel("Pin Code : ");
        JTextField textField1=new JTextField();
        JTextField textField2=new JTextField();
        JTextField textField3=new JTextField();
        JTextField textField4=new JTextField();
        JTextField textField5=new JTextField();
        JTextField textField6=new JTextField();
        JTextField textField7=new JTextField();
        JRadioButton radioButton1=new JRadioButton("Male");
        JRadioButton radioButton2=new JRadioButton("Female");
        JRadioButton radioButton3=new JRadioButton("Other");
        JRadioButton radioButton4=new JRadioButton("Married");
        JRadioButton radioButton5=new JRadioButton("Unmarried");
        JDateChooser dateChooser=new JDateChooser();
        ButtonGroup buttonGroup1=new ButtonGroup();
        ButtonGroup buttonGroup2=new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);
        buttonGroup2.add(radioButton4);
        buttonGroup2.add(radioButton5);
        //Properties of components :
        label1.setFont(new Font("CornerStone",Font.BOLD,38));
        label2.setFont(new Font("CornerStone",Font.BOLD,20));
        label3.setFont(new Font("CornerStone",Font.BOLD,20));
        label4.setFont(new Font("CornerStone",Font.BOLD,20));
        label5.setFont(new Font("CornerStone",Font.BOLD,20));
        label6.setFont(new Font("CornerStone",Font.BOLD,20));
        label7.setFont(new Font("CornerStone",Font.BOLD,20));
        label8.setFont(new Font("CornerStone",Font.BOLD,20));
        label9.setFont(new Font("CornerStone",Font.BOLD,20));
        label10.setFont(new Font("CornerStone",Font.BOLD,20));
        label11.setFont(new Font("CornerStone",Font.BOLD,20));
        label12.setFont(new Font("CornerStone",Font.BOLD,20));
        radioButton1.setFont(new Font("CornerStone",Font.BOLD,20));
        radioButton2.setFont(new Font("CornerStone",Font.BOLD,20));
        radioButton3.setFont(new Font("CornerStone",Font.BOLD,20));
        radioButton4.setFont(new Font("CornerStone",Font.BOLD,20));
        radioButton5.setFont(new Font("CornerStone",Font.BOLD,20));
        dateChooser.setForeground(new Color(50,50,50));
        button1.setForeground(Color.white);
        button1.setBackground(Color.BLACK);
        button2.setForeground(Color.white);
        button2.setBackground(Color.BLACK);
        button1.setFont(new Font("CornerStone",Font.BOLD,20));
        button2.setFont(new Font("CornerStone",Font.BOLD,20));
        ActionListener ab=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(ae.getSource()==button1){
                String form_no=""+random; //here random is converted into string
                String Name=textField1.getText();
                String Father_name=textField2.getText();
                String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
                String Gender;
                if(radioButton1.isSelected()){
                    Gender=radioButton1.getText();
                }
                else if(radioButton2.isSelected()){
                    Gender=radioButton2.getText();
                }
                else{
                    Gender=radioButton3.getText();
                }
                String Email= textField3.getText();
                String Marital;
                if(radioButton4.isSelected()){
                    Marital=radioButton4.getText();
                }
                else{
                    Marital=radioButton5.getText();
                }
                String Address=textField4.getText();
                String City=textField5.getText();
                String State=textField6.getText();
                String Pin=textField7.getText();
                try{
                    Jdbc_connection jc=new Jdbc_connection();
                    String query="insert into Sign values('"+form_no+"','"+Name+"','"+Father_name+"','"+dob+"','"+Gender+"','"+Email+"','"+Marital+
                            "','"+Address+"','"+City+"','"+State+"','"+Pin+"')";
                    /*jc.query="insert into Bms values(?,?,?,?,?,?,?,?,?,?,?)";
                    jc.pstm.setString(1,form_no);
                    jc.pstm.setString(2,Name);
                    jc.pstm.setString(3,Father_name);
                    jc.pstm.setString(4,dob);
                    jc.pstm.setString(5,Gender);
                    jc.pstm.setString(6,Email);
                    jc.pstm.setString(7,Marital);
                    jc.pstm.setString(8,Address);
                    jc.pstm.setString(9,City);
                    jc.pstm.setString(10,State);
                    jc.pstm.setString(11,Pin);
                    jc.pstm.execute();*/
                    jc.str.execute(query);
                    JOptionPane.showMessageDialog(null,"Data Entered Successfully !!!");
                    jc.conn.close();
                    frame.setVisible(false);
                    new Sign_up_2(form_no);
                }
                catch (Exception e){
                    System.out.println(e);
                }}
                else{
                    frame.setVisible(false);
                    new Login();
                }
            }
        };
        button1.addActionListener(ab);
        button2.addActionListener(ab);
        //Bounds of each component :
        label1.setBounds(x-200,y,w+400,h-40);
        label2.setBounds(x,y+50,w+100,h-25);
        label3.setBounds(x1,y1+100,w1,h1); textField1.setBounds(x1+100,y1+100,w1+140,h1);
        label4.setBounds(x1-85,y1+150,w1+80,h1); textField2.setBounds(x1+100,y1+150,w1+140,h1);
        label5.setBounds(x1-70,y1+200,w1+80,h1); dateChooser.setBounds(x1+100,y1+200,w1+160,h1);
        label6.setBounds(x1-20,y1+250,w1+20,h1); radioButton1.setBounds(x1+100,y1+250,w1+20,h1); radioButton2.setBounds(x1+250,y1+250,w1+20,h1); radioButton3.setBounds(x1+400,y1+250,w1+20,h1);
        label7.setBounds(x1-85,y1+300,w1+80,h1); textField3.setBounds(x1+100,y1+300,w1+140,h1);
        label8.setBounds(x1-80,y1+350,w1+80,h1); radioButton4.setBounds(x1+100,y1+350,w1+20,h1); radioButton5.setBounds(x1+250,y1+350,w1+50,h1);
        label9.setBounds(x1-25,y1+400,w1+20,h1); textField4.setBounds(x1+100,y1+400,w1+140,h1);
        label10.setBounds(x1+15,y1+450,w1,h1); textField5.setBounds(x1+100,y1+450,w1+140,h1);
        label11.setBounds(x1+7,y1+500,w1,h1); textField6.setBounds(x1+100,y1+500,w1+140,h1);
        label12.setBounds(x1-28,y1+550,w1+30,h1); textField7.setBounds(x1+100,y1+550,w1+140,h1);
        button1.setBounds(x2+20,y2,w2,h2);button2.setBounds(x2-250,y2,w2+10,h2);
        //Adding components to the frame :
        frame.add(label1);frame.add(label2);frame.add(label3);frame.add(label4);frame.add(label5);
        frame.add(label6);frame.add(label7);frame.add(label8);frame.add(label9);frame.add(label10);
        frame.add(label11);frame.add(label12);
        frame.add(textField1);frame.add(textField2);frame.add(textField3);frame.add(textField4);
        frame.add(textField5);frame.add(textField6);frame.add(textField7);
        frame.add(radioButton1);frame.add(radioButton2);frame.add(radioButton3);
        frame.add(radioButton4);frame.add(radioButton5);
        frame.add(dateChooser);
        frame.add(button1);frame.add(button2);
        //Managing Frame :
        frame.setSize(2000,2000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Sign_up();
    }
}