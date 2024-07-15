package Java_Projects.Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions {
    Transactions(String pin){
        //Making Objects of all Components of the Frame
        JFrame frame=new JFrame();
        JButton button1=new JButton("Deposit");
        JButton button2=new JButton("Cash Withdrawl");
        JButton button3=new JButton("Fast Cash");
        JButton button4=new JButton("Mini Statement");
        JButton button5=new JButton("Pin Change");
        JButton button6=new JButton("Balance Enquiry");
        JButton button7=new JButton("Exit");
        ImageIcon imageIcon1=new ImageIcon("C:\\Users\\Vivek Dahiya\\Downloads\\atm.jpg");
        Image image1=imageIcon1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(image1);
        JLabel label1=new JLabel(imageIcon2);
        JLabel label2=new JLabel("Please select your Transaction");
        //Properties of all Components
        label2.setForeground(Color.white);
        label2.setFont(new Font("System",Font.BOLD,16));
        button1.setBackground(new Color(187, 32, 229, 255));
        button1.setForeground(Color.white);
        button2.setBackground(new Color(187, 32, 229, 255));
        button2.setForeground(Color.white);
        button3.setBackground(new Color(187, 32, 229, 255));
        button3.setForeground(Color.white);
        button4.setBackground(new Color(187, 32, 229, 255));
        button4.setForeground(Color.white);
        button5.setBackground(new Color(187, 32, 229, 255));
        button5.setForeground(Color.white);
        button6.setBackground(new Color(187, 32, 229, 255));
        button6.setForeground(Color.white);
        button7.setBackground(new Color(187, 32, 229, 255));
        button7.setForeground(Color.white);
        ActionListener ab=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button7){
                    frame.setVisible(false);
                    new Login();
                }
                else if(e.getSource()==button1){
                    frame.setVisible(false);
                    new Transactions_Deposit(pin);
                }
                else if(e.getSource()==button2){
                    frame.setVisible(false);
                    new Transactions_Withdraw(pin);
                }
                else if(e.getSource()==button3){
                    frame.setVisible(false);
                    new Transactions_FastCash(pin);
                }
                else if(e.getSource()==button5){
                    frame.setVisible(false);
                    new Transactions_PinChange(pin);
                }
                else if(e.getSource()==button6){
                    frame.setVisible(false);
                    new Transactions_BalanceEnquiry(pin);
                }
                else{
                    frame.setVisible(false);
                    new Transactions_MiniStatement(pin);
                }
            }
        };
        button7.addActionListener(ab);
        button1.addActionListener(ab);
        button2.addActionListener(ab);
        button3.addActionListener(ab);
        button4.addActionListener(ab);
        button5.addActionListener(ab);
        button6.addActionListener(ab);
        //Setting Bounds of all Components
        label1.setBounds(0,0,800,800);
        label2.setBounds(180,250,700,35);
        button1.setBounds(140,373,130,25);
        button2.setBounds(330,373,130,25);
        button3.setBounds(140,403,130,25);
        button4.setBounds(330,403,130,25);
        button5.setBounds(140,433,130,25);
        button6.setBounds(330,433,130,25);
        button7.setBounds(330,463,130,25);
        //Adding all Components to the farme
        label1.add(label2);
        label1.add(button1);label1.add(button2);label1.add(button3);
        label1.add(button4);label1.add(button5);label1.add(button6);
        label1.add(button7);
        frame.add(label1);
        // Managing Frame
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Transactions("");
    }}