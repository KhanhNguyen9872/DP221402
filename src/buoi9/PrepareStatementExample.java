package buoi9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareStatementExample {
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
        String sql = "Select Emp_Id, Emp_No, Emp_Name, Dept_Id from Employee"
            + " where Emp_Name like ? and Dept_Id = ? ";

        // đối tượng java.sql.PreparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Set giá trị cho các tham số
        preparedStatement.setString(1, "%S");
        preparedStatement.setInt(2, 20);

        // dùng đối tượng preparedStatement để thực thi
        resultSet = preparedStatement.executeQuery();

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

        System.out.println();
        System.out.println("Set other parameters ..");
        
        // Tái sử dụng PreparedStatement.
        preparedStatement.setString(1, "KI%");
        preparedStatement.setInt(2,10);
        
        // dùng đối tượng preparedStatement để thực thi
        resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
            System.out.println(" ---- ");
            System.out.println("EmpId: " + resultSet.getInt("Emp_Id"));
            System.out.println("EmpNo: " + resultSet.getString(2));
            System.out.println("EmpName: " + resultSet.getString("Emp_Name"));
        };

        connection.close();
    };
};
