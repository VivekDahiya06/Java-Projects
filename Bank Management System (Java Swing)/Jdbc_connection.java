package Java_Projects.Bank_Management_System;
import java.sql.*;
public class Jdbc_connection {
    Connection conn;
    Statement str;
    PreparedStatement pstm;
    //String query;
    Jdbc_connection(){
        String url="jdbc:mysql://localhost:3306/B_M_S";
        String password="30022160";
        String username="root";
        try{
            conn= DriverManager.getConnection(url,username,password);
            str=conn.createStatement();
            //pstm= conn.prepareStatement(query);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
