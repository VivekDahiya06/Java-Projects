package Java_Projects.Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class Login {
    int x,y,w,h,x1,y1,w1,h1,x2,y2,w2,h2;
    Login(){
        x=650;y=50;w=120;h=35;
        x1=650;y1=150;w1=180;h1=h;
        x2=650;y2=450;w2=100;h2=h;

        //Declaring objects for all the components

        JFrame frame=new JFrame("BMS");
        JButton button1=new JButton("SIGN IN");
        JButton button2=new JButton("CLEAR");
        JButton button3=new JButton("SIGN UP");
        JButton button4=new JButton("CLOSE");
        JTextField textField1=new JTextField();
        JPasswordField passField2=new JPasswordField();
        ImageIcon image1=new ImageIcon("C:\\Users\\Vivek Dahiya\\Downloads\\logo.jpg");
        /*
        Image class is used the set the size of the image in the frame
        */
        Image image_1=image1.getImage().getScaledInstance(140,140, Image.SCALE_DEFAULT);
        /*
        Since Image class can not be directely used in the Labels like ImageIcon we convert it
        into ImageIcon and then is used in the Label to use in the Frame
        */
        ImageIcon img1=new ImageIcon(image_1);
        JLabel label1=new JLabel("Welcome To ATM ");
        JLabel label2=new JLabel("Card No : ");
        JLabel label3=new JLabel("Pin : ");
        JLabel label4=new JLabel(img1);

        //Setting Properties of all components

        label1.setFont(new Font("Osward",Font.BOLD,38));
        label2.setFont(new Font("Osward",Font.BOLD,20));
        label3.setFont(new Font("Osward",Font.BOLD,20));
        button1.setBackground(Color.BLACK);button1.setForeground(Color.white);
        button2.setBackground(Color.BLACK);button2.setForeground(Color.white);
        button3.setBackground(Color.BLACK);button3.setForeground(Color.white);
        button4.setBackground(Color.BLACK);button4.setForeground(Color.white);

        //Setting up ActionListener for all Buttons

        ActionListener ab=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button2){
                    textField1.setText("");
                    passField2.setText("");
                }
                else if(e.getSource()==button1){
                    try{
                    String card_no=textField1.getText();
                    String Pin=new String(passField2.getPassword());
                    Jdbc_connection jb=new Jdbc_connection();
                    String query="select*from login where Card_number='"+card_no+"' and Pin='"+Pin+"'";
                    ResultSet rs=jb.str.executeQuery(query);
                    if(rs.next()){
                        frame.setVisible(false);
                        new Transactions(Pin);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin !!!");
                    }
                    }
                    catch (Exception ae){
                        System.out.println(ae);
                    }

                }
                else if(e.getSource()==button3){
                    frame.setVisible(false);
                    new Sign_up();
                }
                else{
                    System.exit(0);
                }
            }
        };

        //Adding ActionListener to each Button

        button1.addActionListener(ab);button2.addActionListener(ab);
        button3.addActionListener(ab);button4.addActionListener(ab);

        //Setting bounds for all the components

        label1.setBounds(x,y,w+220,h);label2.setBounds(x1-55,y1,w1-60,h1); textField1.setBounds(x1+50,y1,w1+40,h1);
        label3.setBounds(x1-10,y1+50,w1-60,h1); passField2.setBounds(x1+50,y1+50,w1+40,h1);button1.setBounds(x1+50,y1+150,w2,h2);
        button2.setBounds(x1+180,y1+150,w2,h2);button3.setBounds(x1+55,y1+200,w2+120,h2);button4.setBounds(x1+55,y1+250,w2+120,h2);
        label4.setBounds(x-200,y-20,w,h+80);

        //Adding all components to the frame

        frame.add(label1);frame.add(label2);frame.add(label3);
        frame.add(button1);frame.add(button2);frame.add(button3);
        frame.add(button4);frame.add(textField1);frame.add(passField2);
        frame.add(label4);

        //Setting up Properties for the frame

        frame.setSize(2000,2000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        frame.setVisible(true);
    }
    public static void main(String[] args) {new Login();}}
