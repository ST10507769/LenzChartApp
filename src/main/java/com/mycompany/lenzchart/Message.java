/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lenzchart;

import java.util.ArrayList;
import java.util.Random;

public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    
    public static int totalMessages = 0;
    public static ArrayList<Message> allMessages = new ArrayList<>();

    public Message(int messageNumber, String recipient, String messageText) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateID();
        this.messageHash = createMessageHash();
    }

    private String generateID() {
        Random rand = new Random();
        long id = (long) (rand.nextDouble() * 1_000_000_0000L);
        return String.format("%010d", id);
    }

    public boolean checkMessageID() {
        return this.messageID.length() <= 10;
    }

    public String checkRecipientCell() {
        String regex = "^(\\+27|0)[0-9]{9,10}$";
        if (this.recipient.matches(regex)) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String createMessageHash() {
        String firstTwoID = this.messageID.substring(0, 2);
        String[] words = this.messageText.split(" ");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "").toUpperCase();
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "").toUpperCase();
        return firstTwoID + ":" + this.messageNumber + ":" + firstWord + lastWord;
    }

    public String SentMessage(int choice) {
        switch (choice) {
            case 1:
                totalMessages++;
                allMessages.add(this);
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message.";
            case 3:
                storeMessage(); 
                return "Message successfully stored.";
            default:
                return "Invalid option.";
        }
    }

    public void storeMessage() {
        try {
            java.io.FileWriter fw = new java.io.FileWriter("messages.json", true);
            java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
            String json = "{\n  \"id\": \"" + this.messageID + "\",\n  \"recipient\": \"" + this.recipient + "\",\n  \"message\": \"" + this.messageText + "\"\n}\n";
            bw.write(json);
            bw.close();
        } catch (Exception e) {
            System.out.println("Error storing message.");
        }
    }

    public String printMessages() {
        StringBuilder sb = new StringBuilder();
        for (Message m : allMessages) {
            sb.append("Message ID: ").append(m.messageID).append("\n");
            sb.append("Message Hash: ").append(m.messageHash).append("\n");
            sb.append("Recipient: ").append(m.recipient).append("\n");
            sb.append("Message: ").append(m.messageText).append("\n\n");
        }
        return sb.toString();
    }

    public int returnTotalMessages() { return totalMessages; }
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getMessageText() { return messageText; }
}