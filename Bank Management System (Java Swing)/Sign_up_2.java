package Java_Projects.Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Sign_up_2 {
    JFrame frame;
    int x,y,w,h,x1,y1,w1,h1,x2,y2,w2,h2;
    Sign_up_2(String form){
        x=650;y=30;w=200;h=80;
        x1=550;y1=50;w1=100;h1=35;
        x2=790;y2=650;w2=80;h2=30;
        //Making object of each component within the frame
        frame =new JFrame();
        JButton button1=new JButton("Next");
        JButton button2=new JButton("Back");
        JLabel label1=new JLabel("APPLICATION FORM NO. "+form);
        JLabel label2=new JLabel("Page 2 : Additional Details");
        JLabel label3=new JLabel("Religion :");
        JLabel label4=new JLabel("Catogery :");
        JLabel label5=new JLabel("Income :");
        JLabel label6=new JLabel("Educational Qualification :");
        JLabel label7=new JLabel("Occupation :");
        JLabel label8=new JLabel("PAN Number :");
        JLabel label9=new JLabel("Aadhar Number :");
        JLabel label10=new JLabel("Senior Citizen :");
        JLabel label11=new JLabel("Existing Account :");
        JComboBox<String> comboBox1=new JComboBox<>(new String[]{"Hindu","Muslim","Sikh","Christian","Other"});
        JComboBox<String> comboBox2=new JComboBox<>(new String[]{"General","OBC","SC","ST","Other"});
        JComboBox<String> comboBox3=new JComboBox<>(new String[]{"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"});
        JComboBox<String> comboBox4=new JComboBox<>(new String[]{"Non-Graduation","Graduate","Post-Graduate","Doctrate","Other"});
        JComboBox<String> comboBox5=new JComboBox<>(new String[]{"Salaried","Self-Employed","Business","Student","Retired","Other"});
        JTextField textField1=new JTextField();
        JTextField textField2=new JTextField();
        JRadioButton radioButton1=new JRadioButton("Yes");
        JRadioButton radioButton2=new JRadioButton("No");
        JRadioButton radioButton3=new JRadioButton("Yes");
        JRadioButton radioButton4=new JRadioButton("No");
        ButtonGroup buttonGroup1=new ButtonGroup();
        ButtonGroup buttonGroup2=new ButtonGroup();
        buttonGroup1.add(radioButton1);buttonGroup1.add(radioButton2);
        buttonGroup2.add(radioButton3);buttonGroup2.add(radioButton4);
        //Properties of all Components
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
        radioButton1.setFont(new Font("CornerStone",Font.BOLD,20));
        radioButton2.setFont(new Font("CornerStone",Font.BOLD,20));
        radioButton3.setFont(new Font("CornerStone",Font.BOLD,20));
        radioButton4.setFont(new Font("CornerStone",Font.BOLD,20));
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
                    String religion= (String) comboBox1.getSelectedItem();
                    String catogery= (String) comboBox2.getSelectedItem();
                    String income= (String) comboBox3.getSelectedItem();
                    String education= (String) comboBox4.getSelectedItem();
                    String occupation= (String) comboBox5.getSelectedItem();
                    String pan=textField1.getText();
                    String aadhar=textField2.getText();
                    String senior_citizen;
                    if(radioButton1.isSelected()){
                        senior_citizen="Yes";
                    }
                    else{
                        senior_citizen="No";
                    }
                    String existing_account;
                    if(radioButton3.isSelected()){
                        existing_account="Yes";
                    }
                    else{
                        existing_account="No";
                    }
                    try{
                        Jdbc_connection jb=new Jdbc_connection();
                        String query="insert into Sign_2 values('"+form+"','"+religion+"','"+catogery+"','"+income+"','"+education+"','"+occupation+"'," +
                                "'"+pan+"','"+aadhar+"','"+senior_citizen+"','"+existing_account+"')";
                        jb.str.execute(query);
                        JOptionPane.showMessageDialog(null,"Data Entered Successfully !!!");
                        jb.conn.close();
                        frame.setVisible(false);
                        new Sign_up_3(form);
                        //frame.setVisible(false);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }
                else{
                    frame.setVisible(false);
                    new Sign_up();
                }
            }
        };
        button1.addActionListener(ab);
        button2.addActionListener(ab);
        //Setting Bounds of each Component
        label1.setBounds(x-200,y,w+400,h-40);
        label2.setBounds(x,y+50,w+100,h-25);
        label3.setBounds(x1-20,y1+100,w1,h1); comboBox1.setBounds(x1+100,y1+100,w1+160,h1);
        label4.setBounds(x1-30,y1+150,w1+80,h1); comboBox2.setBounds(x1+100,y1+150,w1+160,h1);
        label5.setBounds(x1-13,y1+200,w1+80,h1); comboBox3.setBounds(x1+100,y1+200,w1+160,h1);
        label6.setBounds(x1-180,y1+250,w1+150,h1); comboBox4.setBounds(x1+100,y1+250,w1+160,h1);
        label7.setBounds(x1-52,y1+300,w1+80,h1); comboBox5.setBounds(x1+100,y1+300,w1+160,h1);
        label8.setBounds(x1-64,y1+350,w1+80,h1); textField1.setBounds(x1+100,y1+350,w1+160,h1);
        label9.setBounds(x1-92,y1+400,w1+90,h1); textField2.setBounds(x1+100,y1+400,w1+160,h1);
        label10.setBounds(x1-82,y1+450,w1+50,h1); radioButton1.setBounds(x1+100,y1+450,w1+20,h1); radioButton2.setBounds(x1+250,y1+450,w1+20,h1);
        label11.setBounds(x1-111,y1+500,w1+85,h1); radioButton3.setBounds(x1+100,y1+500,w1+20,h1); radioButton4.setBounds(x1+250,y1+500,w1+20,h1);
        button1.setBounds(x2+20,y2,w2,h2);button2.setBounds(x2-250,y2,w2+10,h2);
        //Adding Components to the frame
        frame.add(label1);frame.add(label2);frame.add(label3);frame.add(label4);frame.add(label5);
        frame.add(label6);frame.add(label7);frame.add(label8);frame.add(label9);frame.add(label10);frame.add(label11);
        frame.add(comboBox1);frame.add(comboBox2);frame.add(comboBox3);frame.add(comboBox4);frame.add(comboBox5);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(radioButton1);frame.add(radioButton2);frame.add(radioButton3);frame.add(radioButton4);
        frame.add(button1);
        frame.add(button2);
        //Managing Frame
        frame.setSize(2000,2000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {new Sign_up_2("");}}
