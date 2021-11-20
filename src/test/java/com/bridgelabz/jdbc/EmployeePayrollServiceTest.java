package com.bridgelabz.jdbc;

import org.junit.Test;

import java.sql.SQLException;

public class EmployeePayrollServiceTest {
    @Test
    public void EmployeePayrollDataRetrievedDFromDB_MatchEmployeeCount() throws SQLException {
        EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
        employeePayrollDBService.getConnection();
    }


}