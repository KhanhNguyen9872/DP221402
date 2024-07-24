package buoi9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDataExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/db221402";
        String user = "root";
        String password = "12345678";
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        //1. kết nối
        // nạp driver cho app
        Class.forName("com.mysql.cj.jdbc.Driver");
    
        // tạo kết nối
        connection = DriverManager.getConnection(url, user, password);

        //2. thực thi câu sql
        String sql = "select Emp_Id, Emp_No, Emp_Name from Employee";

        // đối tượng java.sql.Statement
        statement = connection.createStatement();

        // dùng đối tượng statement để thực thi
        resultSet = statement.executeQuery(sql);

        // in danh sách nhân viên
        while (resultSet.next()) {
            int empId = resultSet.getInt(1);
            String empNo = resultSet.getString(2);
            String empName = resultSet.getString(3);
            System.out.println("-------------");
            System.out.println("EmpId: " + empId);
            System.out.println("EmpNo: " + empNo);
            System.out.println("EmpName: " + empName);
        };

        connection.close();
    }
}
