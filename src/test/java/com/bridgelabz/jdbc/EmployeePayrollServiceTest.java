package com.bridgelabz.jdbc;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

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

}