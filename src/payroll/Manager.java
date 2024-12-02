/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payroll;
/**
 * A Manager is an Employee. This class shows 
 * the inheritance relationship discussed in class.
 * Updated as per ICE5 for better design and functionality.
 * @author Liz Dancy, 2018
 * modified by Baldeen 2 December 2024
 */
public class Manager extends Employee {
    private double bonus; // the amount of bonus they should receive

    // Constructor for Manager with all required arguments
    public Manager(String name, double hours, double wage) {
        super(name, hours, wage); // Pass the required arguments to the Employee constructor
        this.bonus = 0; // Default bonus
    }

    // Constructor for Manager with only name
    public Manager(String name) {
        super(name, 0, 0); // Default hours and wage to 0
        this.bonus = 0;
    }

    // Accessors and mutators for bonus
    public void setBonus(double bonusAmount) {
        bonus = bonusAmount;
    }

    public double getBonus() {
        return bonus;
    }

    // Override the calculatePay method
    public double calculatePay() {
        return (getHours() * getHourlyWage()) + bonus;
    }

    // Print statement for Manager
    public String printStatement() {
        return "Manager: " + getName() + " is owed: $" + calculatePay() + "\n**************************************************************";
    }
}