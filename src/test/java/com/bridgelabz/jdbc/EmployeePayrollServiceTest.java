package com.bridgelabz.jdbc;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class EmployeePayrollServiceTest {

    //Test Case To Check If Database Connection IS Properly Established Or Not
    @Test
    public void EmployeePayrollDataRetrievedDFromDB_MatchEmployeeCount() throws SQLException {
        EmployeePayrollDBService databaseConnection = new EmployeePayrollDBService();
        databaseConnection.getConnection();
    }

    //Test Case To Check Whether Data Is Properly Retrieved Or Not From Database
    @Test
    public void retrieveDataFromDB() {
        EmployeePayrollService employeePayrollService=new EmployeePayrollService();
        List<EmployeeData> employee = employeePayrollService.retrieveData();
        Assert.assertEquals(5, employee.size());
    }

    //Test Case To Check Whether Salary Is Updated Or Not In Database
    @Test
    public void updateSalaryFromDB() {
        EmployeePayrollService employeePayrollService=new EmployeePayrollService();
        List<EmployeeData> employee = employeePayrollService.retrieveData();
        employeePayrollService.updateSalary();

    }
    //Test Case To Retrieve Data Between Mentioned Range
    @Test
    public void retrieveData_betweenRange() {
        EmployeePayrollService employeePayRollService=new EmployeePayrollService();
        employeePayRollService.retrieveData_inBetween_Range();
    }
    //Test Case To find Sum Of Basic pay
    @Test
    public void find_SumOf_basicPay() {
        EmployeePayrollService employeePayRollService=new EmployeePayrollService();
        Map<String, Double> emp_sum_salary = employeePayRollService.sumOf_BasicPay_Based_on_gender();
        System.out.println(emp_sum_salary);
    }
    //Test Case To Check If employee Is Properly Added To Database Or No
    @Test
    public void add_new_employee() {
        EmployeePayrollService employeePayRollService=new EmployeePayrollService();
        employeePayRollService.retrieveData();
        employeePayRollService.add_new_employee_to_the_Database("Raunak","M",520000.00, LocalDate.now());
    }
}