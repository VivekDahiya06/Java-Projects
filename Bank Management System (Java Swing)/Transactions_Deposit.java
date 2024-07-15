package Java_Projects.Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Transactions_Deposit {
    Transactions_Deposit(String pin_number){

        //Declaring objects for all the components

        JFrame f=new JFrame("Deposit");
        JButton button1=new JButton("Deposit");
        JButton button2=new JButton("Back");
        ImageIcon imageIcon1=new ImageIcon("C:\\Users\\Vivek Dahiya\\Downloads\\atm.jpg");
        Image image1=imageIcon1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(image1);
        JLabel label1=new JLabel(imageIcon2);
        JLabel label2=new JLabel("Enter the amount you want to deposit :");
        JTextField textField1=new JTextField();

        //Setting properties of all components

        label2.setForeground(Color.white);
        button1.setForeground(Color.white);
        button2.setForeground(Color.white);
        label2.setFont(new Font("System",Font.BOLD,14));
        textField1.setFont(new Font("System",Font.BOLD,14));
        button1.setBackground(new Color(187, 32, 229, 255));
        button2.setBackground(new Color(187,32,229,255));

        //Setting up ActionListener for all Buttons

        ActionListener ab=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==button1){
                    String amount=textField1.getText();
                    Date date= new Date();
                    String type="Deposit";
                    if(amount.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please enter an amount you want to deposit !!!");
                    }
                    else{
                        Jdbc_connection jdbc=new Jdbc_connection();
                        String query="insert into deposit values('"+pin_number+"','"+amount+"','"+type+"','"+date+"')";
                        try{
                            jdbc.str=jdbc.conn.createStatement();
                            jdbc.str.executeUpdate(query);
                            JOptionPane.showMessageDialog(null,"Your amount have been deposited !!!");
                            jdbc.conn.close();
                        }
                        catch (Exception ae){
                            System.out.println(ae);
                        }
                    }
                }
                else{
                    f.setVisible(false);
                    new Transactions(pin_number);
                }
            }
        };

        //Adding ActionListener to each Button

        button1.addActionListener(ab);
        button2.addActionListener(ab);

        //Setting Bounds for all the components

        label1.setBounds(0,0,800,800);label2.setBounds(160,280,400,20);
        button1.setBounds(338,410,120,35);button2.setBounds(338,450,120,35);
        textField1.setBounds(160,320,270,23);

        //Adding all components to the frame

        label1.add(label2);label1.add(button1);
        label1.add(button2);label1.add(textField1);
        f.add(label1);

        //Setting up Properties for the frame

        f.setSize(800,800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setUndecorated(true);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new Transactions_Deposit("");
    }}