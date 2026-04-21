package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollCalculator {
    public static void main(String[] args) {
        try {
            BufferedReader employeeRecords = new BufferedReader(new FileReader("employees.csv"));
            String line;

            while((line = employeeRecords.readLine()) != null ){
                String[] employeeInfo = line.split("\\|");

                int employeeID = Integer.parseInt(employeeInfo[0]);
                String employeeName = employeeInfo[1];
                double hoursWorked = Double.parseDouble(employeeInfo[2]);
                double payRate = Double.parseDouble(employeeInfo[3]);
                Employee newEmployee = new Employee(employeeID, employeeName, hoursWorked, payRate);
                System.out.printf("[ Employee ID: %d | Employee Name: %s | Gross Pay: $%.2f ]%n", newEmployee.getEmployeeID(), newEmployee.getName(), newEmployee.getGrossPay());
            }
        } catch (Exception e) {
            System.out.println("Invalid File.");
        }

    }
}
