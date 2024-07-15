package Java_Projects.Bank_Management_System;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Transactions_Withdraw {
    Transactions_Withdraw(String pin_number){

        //Declaring objects for all the components

        JFrame frame=new JFrame("Withdraw");
        JButton withdraw=new JButton("Withdraw");
        JButton back=new JButton("Back");
        JLabel label1=new JLabel("Enter the amount you want to withdraw: ");
        JTextField textField1=new JTextField();
        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Vivek Dahiya\\Downloads\\atm.jpg");
        Image image= imageIcon.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(image);
        JLabel label2=new JLabel(imageIcon2);

        //Setting properties of all the components

        back.setForeground(Color.WHITE);
        withdraw.setForeground(Color.WHITE);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,14));
        textField1.setFont(new Font("System",Font.BOLD,14));
        back.setBackground(new Color(187, 32, 229, 255));
        withdraw.setBackground(new Color(187, 32, 229, 255));

        //Setting up ActionListener for all Buttons

        ActionListener ab= new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              if(e.getSource()==withdraw){
                  String withdraw_amount=textField1.getText();
                  Date date=new Date();
                  String type="Withdraw";
                  if(withdraw_amount.isEmpty()){
                      JOptionPane.showMessageDialog(null,"Please enter an amount you want to withdraw !!");
                  }
                  else{
                      Jdbc_connection jdbc=new Jdbc_connection();
                      String query="insert into deposit values('"+pin_number+"','"+withdraw_amount+"','"+type+"','"+date+"')";
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
                          if(balance<Integer.parseInt(withdraw_amount)){
                              JOptionPane.showMessageDialog(null,"Balance "+balance+" \nInsufficient Balance");
                          }
                          else{
                              jdbc.str.executeUpdate(query);
                              JOptionPane.showMessageDialog(null,"Rs "+withdraw_amount+" have been Withdrawl !!");
                              jdbc.conn.close();
                          }
                      }
                      catch (Exception ae){
                          System.out.println(ae);
                      }
                  }
              }
              else{
                  frame.setVisible(false);
                  new Transactions(pin_number);
              }
          }
        };

        //Adding ActionListener to each Button

        withdraw.addActionListener(ab);
        back.addActionListener(ab);

        //Setting Bounds for all the components

        label1.setBounds(160,280,400,20);label2.setBounds(0,0,800,800);
        textField1.setBounds(160,320,270,23);withdraw.setBounds(338,410,120,35);
        back.setBounds(338,450,120,35);

        //Adding all components to the frame

        label2.add(label1);label2.add(withdraw);
        label2.add(back);label2.add(textField1);
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
    public static void main(String[] args) {new Transactions_Withdraw("");}}