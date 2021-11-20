package com.bridgelabz.jdbc;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

public class EmployeePayrollServiceTest {

    @Test
    public void EmployeePayrollDataRetrievedDFromDB_MatchEmployeeCount() throws SQLException {
        EmployeePayrollDBService databaseConnection = new EmployeePayrollDBService();
        databaseConnection.getConnection();
    }

    @Test
    public void retrieveDataFromDB()
    {
        EmployeePayrollService employeePayRollService=new EmployeePayrollService();
        List<EmployeeData> employee = employeePayRollService.retrieveData();
        Assert.assertEquals(5, employee.size());
    }

}