/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payroll;

/**
 * A class that represents part-time employees.
 * Part-time employees receive an additional 10% of their wage for benefits.
 * Updated as per ICE5 to include improved design and documentation.
 * @author dancye
 * modified by Baldeen 2 December  2024
 */
public class PartTimeEmployee extends Employee {

    /**
     * Constructor for PartTimeEmployee.
     * 
     * @param givenName  Name of the part-time employee.
     * @param givenHours Hours worked by the part-time employee.
     * @param givenWage  Hourly wage of the part-time employee.
     */
    public PartTimeEmployee(String givenName, double givenHours, double givenWage) {
        super(givenName, givenHours, givenWage);
    }

    /**
     * Part-time employees get an extra 10% of their base pay 
     * as a benefit bonus.
     * 
     * @return The total pay, including the 10% benefit bonus.
     */
    @Override
    public double calculatePay() {
        // Base pay calculation
        double extra = (getHours() * getHourlyWage()) * 0.1;
        return (getHours() * getHourlyWage()) + extra;
    }

    /**
     * Prints a payment statement for the part-time employee.
     * Updated to align with ICE5 instructions for clarity and format consistency.
     * 
     * @return A formatted string with payment details.
     */
    @Override
    public String printStatement() {
        return "**************************************************************\n"
                + "Part-Time Employee: " + getName() + " is owed: $"
                + String.format("%.2f", calculatePay()) + " (Includes 10% benefits)\n"
                + "**************************************************************";
    }
}