package Java_Projects.Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Transactions_PinChange{
    Transactions_PinChange(String pin_number){

        //Declaring objects for all the components

        JFrame frame=new JFrame("Pin Change");
        JButton change=new JButton("Change");
        JButton back=new JButton("Back");
        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Vivek Dahiya\\Downloads\\atm.jpg");
        Image image=imageIcon.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label1=new JLabel(imageIcon1);
        JLabel label2=new JLabel("CHANGE YOUR PIN");
        JLabel label3=new JLabel("New Pin: ");
        JLabel label4=new JLabel("Re-Enter New Pin: ");
        JTextField textField1=new JTextField();
        JTextField textField2=new JTextField();

        //Setting Properties for all the components

        label2.setForeground(Color.WHITE);
        label3.setForeground(Color.WHITE);
        label4.setForeground(Color.WHITE);
        change.setForeground(Color.white);
        back.setForeground(Color.white);
        change.setBackground(new Color(187, 32, 229, 255));
        back.setBackground(new Color(187, 32, 229, 255));
        label2.setFont(new Font("System",Font.BOLD,21));
        label3.setFont(new Font("System",Font.BOLD,16));
        label4.setFont(new Font("System",Font.BOLD,16));
        textField1.setFont(new Font("Railway",Font.BOLD,16));
        textField2.setFont(new Font("Railway",Font.BOLD,16));

        //Setting up ActionListener for all Buttons

        ActionListener ab=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==back){
                    frame.setVisible(false);
                    new Transactions(pin_number);
                }
                else{
                    try{
                        String new_pin=textField1.getText();
                        String re_pin=textField2.getText();
                        String query1="Update deposit set pin = '"+re_pin+"' where pin= '"+pin_number+"'";
                        String query2="Update login set pin = '"+re_pin+"' where pin= '"+pin_number+"'";
                        String query3="Update sign_3 set pin = '"+re_pin+"' where pin= '"+pin_number+"'";
                        if(new_pin.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Please enter PIN !!");
                        }
                        else if(re_pin.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Please re-enter new PIN !!");
                        }
                        else if(!new_pin.equals(re_pin)){
                            JOptionPane.showMessageDialog(null,"Entered PIN does not match !!");
                        }
                        else{
                            Jdbc_connection jdbc=new Jdbc_connection();
                            jdbc.str.executeUpdate(query1);
                            jdbc.str.executeUpdate(query2);
                            jdbc.str.executeUpdate(query3);
                            JOptionPane.showMessageDialog(null,"PIN Changed Successfully !!");
                            jdbc.conn.close();
                            frame.setVisible(false);
                            new Transactions(re_pin);
                        }
                    }
                    catch (Exception ae){
                        System.out.println(ae);
                    }
                }
            }
    };

        //Adding ActionListener to each Button

        change.addActionListener(ab);
        back.addActionListener(ab);

        //Setting Bounds for all the components

        label1.setBounds(0,0,800,800);label2.setBounds(200,255,500,35);
        label3.setBounds(140,320,180,25);label4.setBounds(140,360,180,25);
        textField1.setBounds(315,320,145,25);textField2.setBounds(315,360,145,25);
        change.setBounds(312,425,150,30);back.setBounds(312,460,150,30);

        //Adding all components to the frame

        label1.add(label2);label1.add(label3);
        label1.add(label4);label1.add(textField1);
        label1.add(textField2);label1.add(change);
        label1.add(back);frame.add(label1);

        //Setting up Properties for the frame

        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
    public static void main(String[] args) {new Transactions_PinChange("");}}