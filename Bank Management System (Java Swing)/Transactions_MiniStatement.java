package Java_Projects.Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class Transactions_MiniStatement {
    Transactions_MiniStatement(String pin_number){

        //Declaring objects for all the components

        JFrame frame=new JFrame("Mini Statement");
        JLabel label2=new JLabel("Bank of India");
        JLabel label3=new JLabel();
        JLabel label4=new JLabel();
        JLabel label5=new JLabel();
        JLabel label6=new JLabel("Mini Statements : ");
        JButton back=new JButton("Back");

        //Getting card number for the account

        try{
            String qurey="select*from login where pin='"+pin_number+"'";
            Jdbc_connection jdbc=new Jdbc_connection();
            ResultSet rs=jdbc.str.executeQuery(qurey);
            while(rs.next()){
                label3.setText("Card Number : "+rs.getString("Card_number").substring(0,4)+"xxxxxxxx"+rs.getString("Card_number").substring(12));
            }
            jdbc.conn.close();
        }
        catch(Exception ae){
            System.out.println(ae);
        }

        //Calculating net balance and Mini-statements for recent transactions

        int balance=0;
        try{
            String qurey="select*from deposit where pin='"+pin_number+"'";
            Jdbc_connection jdbc=new Jdbc_connection();
            ResultSet rs=jdbc.str.executeQuery(qurey);
            while(rs.next()){
                label4.setText(label4.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><br><html>" );
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
                label5.setText("Your current account balance is : "+balance);
            }
            jdbc.conn.close();
        }
        catch(Exception ae){
            System.out.println(ae);
        }

        //Setting up properties of all the components

        back.setForeground(Color.WHITE);
        back.setBackground(new Color(187, 32, 229, 255));
        label2.setFont(new Font("System",Font.BOLD,30));
        label6.setFont(new Font("System",Font.BOLD,22));

        //Setting up ActionListener for all Buttons

        ActionListener ab=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new Transactions(pin_number);
            }
        };

        //Adding ActionListener to each Button

        back.addActionListener(ab);

        //Setting Bounds for all the components

        label2.setBounds(310,70,200,35);label3.setBounds(20,200,300,20);
        label4.setBounds(20,350,400,200);label5.setBounds(550,200,300,20);
        label6.setBounds(20,300,200,20);back.setBounds(320,680,150,30);

        //Adding all components to the frame

        frame.add(label2);frame.add(label3);
        frame.add(label4);frame.add(label5);
        frame.add(label6);frame.add(back);

        //Setting up Properties for the frame

        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
    public static void main(String[] args) {new Transactions_MiniStatement("");}}