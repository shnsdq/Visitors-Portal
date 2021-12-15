/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;


public class DbConn {
    
    public static Connection connectDb()
    {
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/get_pass?user=root&password=ram");
           return conn;
       }
       catch(ClassNotFoundException | SQLException e)
       {
           System.out.print(e);
           return null;
       }
    }
}
