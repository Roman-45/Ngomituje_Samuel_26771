/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exception;

/**
 *
 * @author ngomi
 */
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {
        Scanner one = new Scanner(System.in);

        // 1. IOException Example with User Input
        System.out.print("Enter the filename to read: ");
        String filename = one.nextLine();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            System.out.println("File opened successfully.");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }

        // 2. FileNotFoundException Example with User Input
        System.out.print("Enter the filename to open: ");
        String fileToOpen = one.nextLine();
        try {
            FileInputStream file = new FileInputStream(fileToOpen);
            System.out.println("File opened successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }

        // 3. EOFException Example with User Input
        System.out.print("Enter the filename to read until EOF: ");
        String eofFile = one.nextLine();
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(eofFile));
            while (true) {
                dis.readUTF(); // This will throw EOFException when end of file is reached
            }
        } catch (EOFException e) {
            System.out.println("EOFException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }

        // 4. SQLException Example with User Input
        System.out.print("Enter the database URL: ");
        String dbUrl = one.nextLine();
        System.out.print("Enter the database username: ");
        String dbUser = one.nextLine();
        System.out.print("Enter the database password: ");
        String dbPassword = one.nextLine();
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }

        // 5. ClassNotFoundException Example with User Input
        System.out.print("Enter the class name to load: ");
        String className = one.nextLine();
        try {
            Class.forName(className);
            System.out.println("Class loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }

        // 6. ArithmeticException Example with User Input
        System.out.print("Enter two numbers to divide (format: numerator denominator): ");
        int numerator = one.nextInt();
        int denominator = one.nextInt();
        try {
            int result = numerator / denominator; // This might throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }

        // 7. NullPointerException Example with User Input
        System.out.print("Enter a string (or 'null' to simulate NullPointerException): ");
        one.nextLine(); // Consume the newline
        String str = one.nextLine();
        if (str.equals("null")) {
            str = null;
        }
        try {
            System.out.println("String length: " + str.length()); // This might throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }

        
    } 
    //NEVER STOP LEARNING
}
