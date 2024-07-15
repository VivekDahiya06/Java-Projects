package Java_Projects.Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Transactions_FastCash {
    Transactions_FastCash(String pin_number){

        //Declaring objects for all the components

        JFrame frame=new JFrame("FastCash");
        JButton Rs100=new JButton("Rs 100");
        JButton Rs500=new JButton("Rs 500");
        JButton Rs1000=new JButton("Rs 1000");
        JButton Rs2000=new JButton("Rs 2000");
        JButton Rs5000=new JButton("Rs 5000");
        JButton Rs10000=new JButton("Rs 10000");
        JButton back=new JButton("Back");
        JLabel label1=new JLabel("Select Withdrawl Amount");
        ImageIcon imageicon1=new ImageIcon("C:\\Users\\Vivek Dahiya\\Downloads\\atm.jpg");
        Image image1=imageicon1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon imageicon2=new ImageIcon(image1);
        JLabel label2=new JLabel(imageicon2);

        //Setting properties of all the components

        Rs100.setForeground(Color.WHITE);
        Rs500.setForeground(Color.WHITE);
        Rs1000.setForeground(Color.WHITE);
        Rs2000.setForeground(Color.WHITE);
        Rs5000.setForeground(Color.WHITE);
        Rs10000.setForeground(Color.WHITE);
        label1.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);
        Rs100.setBackground(new Color(187, 32, 229, 255));
        Rs500.setBackground(new Color(187, 32, 229, 255));
        Rs1000.setBackground(new Color(187, 32, 229, 255));
        Rs2000.setBackground(new Color(187, 32, 229, 255));
        Rs5000.setBackground(new Color(187, 32, 229, 255));
        Rs10000.setBackground(new Color(187, 32, 229, 255));
        back.setBackground(new Color(187, 32, 229, 255));
        label1.setFont(new Font("System",Font.BOLD,20));

        //Setting up ActionListener for all Buttons

        ActionListener ab=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==back){
                    frame.setVisible(false);
                    new Transactions(pin_number);
                }
                else{
                    String amount= ((JButton)e.getSource()).getText().substring(3);//gives amount written on button
                    Jdbc_connection jdbc=new Jdbc_connection();
                    String type="Withdraw";
                    Date date=new Date();
                    String query="insert into deposit values('"+pin_number+"','"+amount+"','"+type+"','"+date+"')";
                    try{
                        ResultSet rs=jdbc.str.executeQuery("select*from deposit where pin='"+pin_number+"'");
                        int balance=0;
                        while(rs.next()){
                            if(rs.getString("type").equals("Deposit")){
                                balance+=Integer.parseInt(rs.getString("amount"));
                            }
                            else{
                                balance-=Integer.parseInt(rs.getString("amount"));
                            }
                        }
                        //^<-This block of code is used to determine the balance of account
                        if(balance<Integer.parseInt(amount)){
                            JOptionPane.showMessageDialog(null,"Balance "+balance+" \nInsufficient Balance");
                        }
                        else{
                            jdbc.str.executeUpdate(query);
                            JOptionPane.showMessageDialog(null,"Rs "+amount+" have been Withdrawl");
                            jdbc.conn.close();
                        }
                    }
                    catch(Exception ae){
                        System.out.println(ae);
                    }
                }
            }
        };

        //Adding ActionListener to each Button

        Rs100.addActionListener(ab);Rs500.addActionListener(ab);
        Rs1000.addActionListener(ab);Rs2000.addActionListener(ab);
        Rs5000.addActionListener(ab);Rs10000.addActionListener(ab);
        back.addActionListener(ab);

        //Setting Bounds for all the components

        label1.setBounds(180,250,700,35);label2.setBounds(0,0,800,800);
        Rs100.setBounds(140,373,130,25);Rs500.setBounds(330,373,130,25);
        Rs1000.setBounds(140,403,130,25);Rs2000.setBounds(330,403,130,25);
        Rs5000.setBounds(140,433,130,25);Rs10000.setBounds(330,433,130,25);
        back.setBounds(330,463,130,25);

        //Adding all components to the frame

        label2.add(Rs100);label2.add(Rs500);label2.add(Rs1000);label2.add(Rs2000);
        label2.add(Rs5000);label2.add(Rs10000);label2.add(back);label2.add(label1);
        frame.add(label2);

        //Setting up Properties for the frame

        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
    public static void main(String[] args) {new Transactions_FastCash("");}}