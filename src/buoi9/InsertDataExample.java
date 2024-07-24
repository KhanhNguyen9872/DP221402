package buoi9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. Kết nối CSDL
         String url = "jdbc:mysql://localhost:3306/db221402";
        String user = "root";
        String password = "12345678";
        Connection connection = null;
        Statement statement = null;
        int rowCount = 0;
        //1. Kết nối đến CSDL db221402
        //nạp driver cho app
        Class.forName("com.mysql.cj.jdbc.Driver");

        //tạo kết nối
       connection = DriverManager.getConnection(url, user, password);
        //2. thực thi sql
        String sql = "Insert into Salary_Grade (Grade, High_Salary, Low_Salary) " +
        "values (2, 20000, 10000) ";
        statement = connection.createStatement();
        rowCount = statement.executeUpdate(sql);
        System.out.println("Row count affected: " + rowCount);
        
        connection.close();
    }

}