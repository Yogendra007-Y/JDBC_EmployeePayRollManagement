package com.bridgelabz.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {
    List< EmployeeData> list=new ArrayList<>();

    public List<EmployeeData> retrieveData()
    {
        String sql="select * from  employee_payroll";
        try {
            Connection connection = EmployeePayrollDBService.getConnection();
            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery(sql);
            while( result.next())
            {
                int id=result.getInt("id");
                String name=result.getString("name");
                String gender=result.getString("gender");
                double basic_pay=result.getDouble("basic_pay");
                LocalDate start=result.getDate("start").toLocalDate();
                list.add(new EmployeeData(id,name,gender,basic_pay,start));
                System.out.println(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}