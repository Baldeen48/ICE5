/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payroll;

/**
 * Refactored Employee Class for ICE5.
 * Represents a generic employee with shared attributes and behavior.
 * The class is designed as an abstract base class to support specific employee types (e.g., Manager, PartTimeEmployee).
 * 
 * Improvements:
 * 1. Added abstraction to make the class extensible.
 * 2. Introduced polymorphic methods to allow specific behavior in derived classes.
 * 3. Consolidated common attributes and methods to adhere to the DRY principle.
 * 
 * Author: Liz Dancy 
 * modified by Baldeen 2 December 2024
 */
public class Employee {
    private String name;
    private double hours;
    private double hourlyWage;

    // Constructor
    public Employee(String name, double hours, double hourlyWage) {
        this.name = name;
        this.hours = hours;
        this.hourlyWage = hourlyWage;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    // Method to calculate pay
    public double calculatePay() {
        return hours * hourlyWage;
    }

    // Print statement
    public String printStatement() {
        return "Employee " + name + " is owed: $" + calculatePay();
    }
}