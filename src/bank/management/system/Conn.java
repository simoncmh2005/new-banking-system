package bank.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","123456");
            s = c.createStatement();
        }catch(SQLException e){
            System.out.println("Connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
