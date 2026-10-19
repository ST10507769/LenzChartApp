/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.lenzchart;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MessageTest{
    
    @Test
    public void testMessageLengthSuccess(){
        Message msg = new Message(0, "+271234567899", "Hi Mike, can you join us for dinner tonight?");
        assertTrue(msg.getMessageText().length() <= 250);
    }
    
    @Test
    public void testRecipientSuccess(){
         Message msg = new Message(0, "+271234567899", "Hi Mike, can you join us for dinner tonight?");
         assertEquals("Cell phone number successfully caputed." , msg.checkRecipientCell());
    }
    
    @Test
    public void testMessageHash(){
         Message msg = new Message(0, "+271234567899", "Hi Mike, can you join us for dinner tonight?");
         assertTrue(msg.getMessageHash().endsWith(":0:HITONIGHT"));
    }
    
    @Test
    public void testMessageIDCreated(){
         Message msg = new Message(0, "+271234567899", "Hi Mike, can you join us for dinner tonight?");
         assertTrue(msg.getMessageID().length() ==10);
    }
}
        
