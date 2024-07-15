package Java_Projects.Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class Sign_up_3 {
    int x,y,w,h,x1,y1,w1,h1,x2,y2,w2,h2;
    String pin,cardno;
    Sign_up_3(String form){
        x=650;y=5;w=200;h=80;
        x1=450;y1=35;w1=100;h1=35;
        x2=790;y2=650;w2=80;h2=30;
        //Making Objects of all Components
        JFrame frame=new JFrame();
        JButton button1=new JButton("Submit");
        JButton button2=new JButton("Cancel");
        JLabel label1=new JLabel("Page 3 : Account Details");
        JLabel label2=new JLabel("Account Type");
        JLabel label3=new JLabel("Card Number");
        JLabel label4=new JLabel("XXXX-XXXX-XXXX-4132");
        JLabel label5=new JLabel("(Your 16 Digit Card Number)");
        JLabel label6=new JLabel("PIN :");
        JLabel label7=new JLabel("XXXX");
        JLabel label8=new JLabel("(Your 4 Digit PIN)");
        JLabel label9=new JLabel("Services Required :");
        JCheckBox checkBox1=new JCheckBox("ATM Card");
        JCheckBox checkBox2=new JCheckBox("Internet Banking");
        JCheckBox checkBox3=new JCheckBox("Mobile Banking");
        JCheckBox checkBox4=new JCheckBox("Email & SMS Alerts");
        JCheckBox checkBox5=new JCheckBox("Cheque Book");
        JCheckBox checkBox6=new JCheckBox("E-Statement");
        JCheckBox checkBox7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        JRadioButton radioButton1=new JRadioButton("Saving Account");
        JRadioButton radioButton2=new JRadioButton("Fixed Deposit Account");
        JRadioButton radioButton3=new JRadioButton("Current Account");
        JRadioButton radioButton4=new JRadioButton("Recurring Deposit Account");
        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        buttonGroup.add(radioButton4);
        //Properties of all Components
        label1.setFont(new Font("CornerStone",Font.BOLD,18));
        label2.setFont(new Font("CornerStone",Font.BOLD,18));
        label3.setFont(new Font("CornerStone",Font.BOLD,18));
        label4.setFont(new Font("CornerStone",Font.BOLD,18));
        label5.setFont(new Font("CornerStone",Font.BOLD,12));
        label6.setFont(new Font("CornerStone",Font.BOLD,18));
        label7.setFont(new Font("CornerStone",Font.BOLD,18));
        label8.setFont(new Font("CornerStone",Font.BOLD,12));
        label9.setFont(new Font("CornerStone",Font.BOLD,18));
        checkBox1.setFont(new Font("CornerStone",Font.BOLD,15));
        checkBox2.setFont(new Font("CornerStone",Font.BOLD,15));
        checkBox3.setFont(new Font("CornerStone",Font.BOLD,15));
        checkBox4.setFont(new Font("CornerStone",Font.BOLD,15));
        checkBox5.setFont(new Font("CornerStone",Font.BOLD,15));
        checkBox6.setFont(new Font("CornerStone",Font.BOLD,15));
        checkBox7.setFont(new Font("CornerStone",Font.BOLD,12));
        radioButton1.setFont(new Font("CornerStone",Font.BOLD,15));
        radioButton2.setFont(new Font("CornerStone",Font.BOLD,15));
        radioButton3.setFont(new Font("CornerStone",Font.BOLD,15));
        radioButton4.setFont(new Font("CornerStone",Font.BOLD,15));
        button1.setForeground(Color.white);
        button1.setBackground(Color.BLACK);
        button2.setForeground(Color.white);
        button2.setBackground(Color.BLACK);
        button1.setFont(new Font("CornerStone",Font.BOLD,20));
        button2.setFont(new Font("CornerStone",Font.BOLD,20));
        ActionListener ab=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(ae.getSource()==button1){
                    String account;
                    if(radioButton1.isSelected()){
                        account=radioButton1.getText();
                    }
                    else if(radioButton2.isSelected()){
                        account=radioButton2.getText();
                    }
                    else if(radioButton3.isSelected()){
                        account=radioButton3.getText();
                    }
                    else{
                        account=radioButton4.getText();
                    }
                    Random random=new Random();
                    String cardNumber=""+Math.abs(random.nextLong()%90000000L+5040936000000000L);
                    String pinNumber=""+Math.abs(random.nextLong()%9000L+1000L);
                    pin=pinNumber;
                    cardno=cardNumber;
                    String facility="";
                    if(checkBox1.isSelected()){
                        facility=facility+","+checkBox1.getText();
                    }
                    else if(checkBox2.isSelected()){
                        facility=facility+","+checkBox2.getText();
                    }
                    else if(checkBox3.isSelected()){
                        facility=facility+","+checkBox3.getText();
                    }
                    else if(checkBox4.isSelected()){
                        facility=facility+","+checkBox4.getText();
                    }
                    else if(checkBox5.isSelected()){
                        facility=facility+","+checkBox5.getText();
                    }
                    else if(checkBox6.isSelected()){
                        facility=facility+","+checkBox6.getText();
                    }
                    if(checkBox7.isSelected()){
                    try{
                    Jdbc_connection jc=new Jdbc_connection();
                    String query="insert into Sign_3 values('"+form+"','"+account+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query1="insert into login values('"+form+"','"+cardNumber+"','"+pinNumber+"')";
                    jc.str.execute(query);
                    jc.str.execute(query1);
                    JOptionPane.showMessageDialog(null,"Data Entered Successfully !!!");
                    jc.conn.close();
                    frame.setVisible(false);
                    new Login();

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }}
                    else{
                        JOptionPane.showMessageDialog(null,"Please Check the Acknowledge of the Data Entered !!!");
                    }
                }
                else{
                    frame.setVisible(false);
                    new Sign_up_2("");
                }
            }};
        button1.addActionListener(ab);
        button2.addActionListener(ab);
        //Setting Bounds of Each Component
        label1.setBounds(x,y+50,w+100,h-25);
        label2.setBounds(x1,y1+100,w1+100,h1);
        radioButton1.setBounds(x1+10,y1+150,w1+50,h1);radioButton2.setBounds(x1+250,y1+150,w1+100,h1);
        radioButton3.setBounds(x1+10,y1+200,w1+50,h1);radioButton4.setBounds(x1+250,y1+200,w1+150,h1);
        label3.setBounds(x1,y1+250,w1+100,h1);
        label4.setBounds(x1+250,y1+250,w1+250,h1);
        label5.setBounds(x1,y1+285,w1+100,h1-20);
        label6.setBounds(x1,y1+320,w1,h1);
        label7.setBounds(x1+250,y1+320,w1,h1);
        label8.setBounds(x1,y1+350,w1,h1-20);
        label9.setBounds(x1,y1+380,w1+150,h1);
        checkBox1.setBounds(x1,y1+430,w1,h1);
        checkBox2.setBounds(x1+200,y1+430,w1+50,h1);
        checkBox3.setBounds(x1,y1+480,w1+50,h1);
        checkBox4.setBounds(x1+200,y1+480,w1+100,h1);
        checkBox5.setBounds(x1,y1+530,w1+50,h1);checkBox6.setBounds(x1+200,y1+530,w1+50,h1);
        checkBox7.setBounds(x1,y1+600,w1+420,h1-20);
        button1.setBounds(x2-250,y2+30,w2+20,h2);button2.setBounds(x2+20,y2+30,w2+30,h2);
        //Adding Components to the Frame
        frame.add(label1);frame.add(label2);
        frame.add(radioButton1);frame.add(radioButton2);frame.add(radioButton3);frame.add(radioButton4);
        frame.add(label3);frame.add(label4);frame.add(label5);frame.add(label6);frame.add(label7);
        frame.add(label8);frame.add(label9);
        frame.add(checkBox1);frame.add(checkBox2);frame.add(checkBox3);frame.add(checkBox4);
        frame.add(checkBox5);frame.add(checkBox6);frame.add(checkBox7);
        frame.add(button1);frame.add(button2);
        //Managing Frame
        frame.setSize(2000,2000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Sign_up_3("");
    }
}