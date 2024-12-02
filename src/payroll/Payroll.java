/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payroll;

import java.util.Scanner; // Ensure this is at the top of your file

/**
 * A class that models the Payroll Application.
 * We are modeling this as an Object so we must think of
 * what would represent both the state and the behaviour of
 * the Payroll class.
 * Used as the starting code for ICE 5 in SYST 17796, 2018
 * @author: Liz Dancy
 * modified by Baldeen 2 Decemeber 2024
 */
public class Payroll {
    private Employee employees[] = new Employee[100]; // Array to hold Employee objects
    private int numEmployees = 0; // Counter for the number of employees added

    /**
     * A main method where we create an instance of the Payroll and then call the
     * private run method on it. We also catch our Exceptions here from the Employee
     * class.
     */
    public static void main(String[] args) {
        try {
            Payroll app = new Payroll();
            app.run();
        } catch (NumberFormatException e) {
            System.out.println("A number format is incorrect: " + e.getMessage() 
                + ". Please ensure hours and wage are entered as numbers and not words.");
        } catch (Exception e) {
            System.out.println("An exception was caught while trying to process employees: " + e.getMessage());
        }
    } // end main method

    /**
     * A private run method that prompts the user for input and adds each Employee
     * to the array. Finally, we call the print method to print out the payroll for
     * each employee and the total.
     */
    private void run() {
        Scanner sc = new Scanner(System.in); // Ensure Scanner is recognized
        boolean shouldContinue = true; // To keep track of whether the user wants to continue
        System.out.println("Welcome to the Payroll Application.");

        while (shouldContinue) {
            System.out.println("Please enter the Employee's name: ");
            String name = sc.nextLine();
            System.out.println("Please enter the Employee's number of hours worked as a number: ");
            int numHours = Integer.parseInt(sc.nextLine());
            System.out.println("Please enter the Employee's hourly wage: ");
            double wage = Double.parseDouble(sc.nextLine());

            System.out.println("Is this employee a manager? Type 'yes' or 'no':");
            String isManager = sc.nextLine();

            if (isManager.equalsIgnoreCase("yes")) {
                System.out.println("Please enter a bonus for the manager: ");
                double bonus = Double.parseDouble(sc.nextLine());
                Manager manager = new Manager(name, numHours, wage);
                manager.setBonus(bonus);
                employees[numEmployees] = manager;
            } else {
                System.out.println("Is this employee part-time? Type 'yes' or 'no':");
                String isPartTime = sc.nextLine();
                if (isPartTime.equalsIgnoreCase("yes")) {
                    PartTimeEmployee partTimeEmployee = new PartTimeEmployee(name, numHours, wage);
                    employees[numEmployees] = partTimeEmployee;
                } else {
                    Employee employee = new Employee(name, numHours, wage);
                    employees[numEmployees] = employee;
                }
            }

            numEmployees++;

            System.out.println("Would you like to enter another employee? (yes or no):");
            String yesOrNo = sc.nextLine();
            shouldContinue = yesOrNo.equalsIgnoreCase("yes");
        } // End of input loop

        printPayroll();
    }

    /**
     * Prints the payroll details for all employees and calculates the total pay.
     */
    private void printPayroll() {
        double totalPaid = 0;

        System.out.println("\nPayroll Summary:");
        System.out.println("**************************************************************");

        for (int i = 0; i < numEmployees; i++) {
            Employee emp = employees[i];
            System.out.println(emp.printStatement());
            totalPaid += emp.calculatePay();
        }

        System.out.println("**************************************************************");
        System.out.printf("The total amount to be paid to all employees is: $%.2f\n", totalPaid);
    }
}