/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Main class
package com.mycompany.lenzchart;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            Login loginSystem = new Login();

            System.out.println("=========================================");
            System.out.println("      Welcome to Lenz Chart App         ");
            System.out.println("=========================================");

            // --- PART 1: REGISTRATION ---
            System.out.println("\n--- Registration ---");
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            String username, password, cellPhone;
            String registrationMessage;

            while (true) {
                System.out.print("Enter Username (must contain '_' and max 5 chars): ");
                username = scanner.nextLine();
                System.out.print("Enter Password (min 8 chars, 1 capital, 1 number, 1 special): ");
                password = scanner.nextLine();
                System.out.print("Enter SA Cell Phone (e.g., +27838968976): ");
                cellPhone = scanner.nextLine();

                registrationMessage = loginSystem.registerUser(username, password, cellPhone, firstName, lastName);
                System.out.println(registrationMessage);

                if (registrationMessage.contains("User registered successfully.")) {
                    break; 
                }
                System.out.println("\nPlease try again.\n");
            }

            // --- PART 1: LOGIN ---
            System.out.println("\n--- Login ---");
            boolean loggedIn = false;
            
            while (!loggedIn) {
                System.out.print("Enter Username: ");
                String loginUser = scanner.nextLine();
                System.out.print("Enter Password: ");
                String loginPass = scanner.nextLine();

                // Check if login was successful
                loggedIn = loginSystem.loginUser(loginUser, loginPass);
                
                // Print the result immediately
                System.out.println(loginSystem.returnLoginStatus(loggedIn));
            }

            // --- PART 2: QUICKCHAT MENU ---
            System.out.println("\nWelcome to QuickChat.");
            boolean running = true;
            
            while (running) {
                System.out.println("\n--- Menu ---");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                System.out.print("Choose an option: ");
                
                int menuChoice = scanner.nextInt();
                scanner.nextLine(); 

                switch (menuChoice) {
                    case 1:
                        System.out.print("How many messages do you wish to enter? ");
                        int numMessages = scanner.nextInt();
                        scanner.nextLine(); 

                        for (int i = 0; i < numMessages; i++) {
                            System.out.println("\n--- Message " + (i + 1) + " ---");
                            System.out.print("Enter Recipient Cell Number: ");
                            String recipient = scanner.nextLine();
                            System.out.print("Enter Message (max 250 chars): ");
                            String messageText = scanner.nextLine();

                            if (messageText.length() > 250) {
                                System.out.println("Please enter a message of less than 250 characters.");
                                i--; 
                                continue;
                            }

                            Message msg = new Message(i, recipient, messageText);
                            String recipientCheck = msg.checkRecipientCell();
                            System.out.println(recipientCheck);
                            
                            if (!recipientCheck.contains("successfully")) {
                                i--; 
                                continue;
                            }

                            System.out.println("Message ready to send.");
                            
                            System.out.println("1) Send Message");
                            System.out.println("2) Disregard Message");
                            System.out.println("3) Store Message to send later");
                            System.out.print("Choose action: ");
                            int actionChoice = scanner.nextInt();
                            scanner.nextLine(); 

                            String actionResult = msg.SentMessage(actionChoice);
                            System.out.println(actionResult);

                            System.out.println("\n--- Message Details ---");
                            System.out.println("Message ID: " + msg.getMessageID());
                            System.out.println("Message Hash: " + msg.getMessageHash());
                            System.out.println("Recipient: " + recipient);
                            System.out.println("Message: " + msg.getMessageText());
                            System.out.println("-----------------------");
                        }
                        break;

                    case 2:
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        System.out.println("Total messages sent: " + Message.totalMessages);
                        running = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } 
    } 
}