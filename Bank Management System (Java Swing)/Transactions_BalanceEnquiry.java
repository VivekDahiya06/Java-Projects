package Java_Projects.Bank_Management_System;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
public class Transactions_BalanceEnquiry {
    String pin;
    Transactions_BalanceEnquiry(String pin_number){

        //Declaring objects for all the components

        this.pin=pin_number;
        JFrame frame=new JFrame("Balance Enquiry");
        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Vivek Dahiya\\Downloads\\atm.jpg");
        Image image=imageIcon.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label1=new JLabel(imageIcon1);
        JLabel label2=new JLabel("Current Balance : ");
        JLabel label3=new JLabel();
        JButton back=new JButton("Back");

        //Setting Up Properties Of all the components

        label2.setForeground(Color.WHITE);label2.setFont(new Font("System",Font.BOLD,21));
        label3.setForeground(Color.WHITE);label3.setFont(new Font("System",Font.BOLD,16));
        back.setForeground(Color.WHITE);back.setBackground(new Color(187, 32, 229, 255));

        //Calculating net balance for the account

        int balance=0;
        Jdbc_connection jdbc=new Jdbc_connection();
        try{
            String query="Select*from deposit where pin='"+pin+"'";
            ResultSet rs=jdbc.str.executeQuery(query);
            while (rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
            jdbc.conn.close();
        }
        catch (Exception ae){
            System.out.println(ae);
        }
        label3.setText("Rs "+balance);

        //Setting up ActionListener of the Buttons

        ActionListener ab= new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               frame.setVisible(false);
               new Transactions(pin_number);
            }
        };

        //Adding ActionListener to each Button

        back.addActionListener(ab);

        //Setting bounds for all the components

        label1.setBounds(0,0,800,800);label2.setBounds(140,360,180,25);
        label3.setBounds(325,360,145,25);back.setBounds(312,460,150,30);

        //Adding all components to the frame

        label1.add(back);label1.add(label2);
        label1.add(label3);frame.add(label1);

        //Setting up Properties for the frame

        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
    public static void main(String[] args) {new Transactions_BalanceEnquiry("");}}