package com.bridgelabz.jdbc;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeePayrollService {
    List< EmployeeData> list=new ArrayList<>();
    public static Connection connection;
    static {
        try {
            connection = EmployeePayrollDBService.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Method For Retrieving Employee Data From Database
    public List<EmployeeData> retrieveData()
    {
        String sql="select * from employee_payroll";
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
            }
            System.out.println("\n Retrieved Data Is:");
            System.out.println(list);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //Method For Updating Salary In Database
    public void updateSalary() {
        String sql="update employee_payroll set basic_pay=600000 where name='charlie'";
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("\n Updated Salary");
            System.out.println(list);
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    //Method For Updating Salary In Database using Prepared Statement
    public void updateUsing_PreparedStatement(String name){
        String sql = "update employee_payroll set basic_pay=800000 where name=? ";
        try {
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setString(1, name);
            int result = psmt.executeUpdate();
            System.out.println("\n Update Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Method To Retrieve Data From Database Between given Range
    public void retrieveData_inBetween_Range()
    {
        String sql = "select * from employee_payroll where start between cast('2018-03-12' as Date ) AND DATE(NOW())";
        List< EmployeeData> list=new ArrayList<>();
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while( result.next())
            {
                int id=result.getInt("id");
                String name=result.getString("name");
                String gender=result.getString("gender");
                double basic_pay=result.getDouble("basic_pay");
                LocalDate start=result.getDate("start").toLocalDate();
                list.add(new EmployeeData(id,name,gender,basic_pay,start));
            }
            System.out.println("\n Retrieved Data In Range Is:");
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Method To get Avg Salary Based On Gender
    public Map<String, Double> avg_BasePay_Base_on_gender() {
        String sql=" select gender, avg( basic_pay) as avg_basic_pay from employee_payroll group by gender";
        Map<String,Double> empAvg_salary = new HashMap<>();
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while( result.next())
            {
                String gender=result.getString("gender");
                double basic_pay=result.getDouble("avg_basic_pay");
                empAvg_salary.put(gender,basic_pay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  empAvg_salary;
    }

    //Method To get Sum Of Salary Based On Gender
    public Map<String, Double> sumOf_BasicPay_Based_on_gender() {
        String sql=" select gender, sum( basic_pay) as sum_basic_pay from employee_payroll group by gender";
        Map<String,Double> empSumOf_salary = new HashMap<>();
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while( result.next())
            {
                String gender=result.getString("gender");
                double basic_pay=result.getDouble("sum_basic_pay");
                empSumOf_salary.put(gender,basic_pay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  empSumOf_salary;
    }
}