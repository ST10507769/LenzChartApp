/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Main class
package com.mycompany.lenzchart;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            Login loginSystem = new Login();
            // System output
            System.out.println("=========================");
            System.out.println("  Welcome to Lenz Chart  ");
            System.out.println("=========================");
            System.out.println("Registration");
            System.out.print("Enter first name");
            String firstName =scanner.nextLine();
            System.out.print("Enter last name");
            //Declaration
            String lastName;
            lastName = scanner.nextLine();
            String username, password, cellPhone;
            String registrationMessage;
            while (true){
                System.out.print("Enter your Username(must contain'_' and max of 5 chars)");
                username = scanner.nextLine();
                
                System.out.print("Please enter password");
                password = scanner.nextLine();
                
                System.out.print("Please enter your cell phone numver(e.g., +27123456789)");
                cellPhone = scanner.nextLine();
                
                registrationMessage = loginSystem.registerUser(username, password, cellPhone, firstName, lastName);
                System.out.println(registrationMessage);
                
                if (registrationMessage.contains("User registered successfully.")){
                    break;
                    // Exit loop if registration is successful
                    
                }
                System.out.println("Please try agian");
                
            }   // Login Phase
            System.out.println("Login");
            boolean isLoggedIn = false;
            while (isLoggedIn){
                System.out.print("Enter Username:");
                String loginUser = scanner.nextLine();
                
                System.out.print("Enter Password:");
                String loginPass = scanner.nextLine();
                
                isLoggedIn = loginSystem.loginUser(loginUser, loginPass);
                String loginStatus = loginSystem.returnLoginStatus(isLoggedIn);
                System.out.println(loginStatus);
                
                if (isLoggedIn){
                    System.out.println("Please try again.");
                }
            }   System.out.println("Thank you for using Lenz Chart. Goodbye");
        }
        
    }
    
}
