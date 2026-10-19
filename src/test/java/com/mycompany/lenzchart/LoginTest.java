/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.lenzchart;

import com.mycompany.lenzchart.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    
 Login login = new login();
 
@Test
public void testUsernameCorrectlyFormatted(){
    assertTrue(login.checkUserName("kyl_1"));
}  
@Test
public void testUsernameIncorrectlyFormatted(){
    assertFalse(login.checkUserName("kyl_e!!!!!!!!!!"));
}
@Test
public void testPasswordMeetsComplexity(){
    assertTrue(login.checkPasswordComplexity("ch&&sec@ke99!"));
}
@Test
public void testPasswordDoesNotMeetComplexity(){
    assertFalse(login.checkPasswordComplexity("password"));
}
@Test
public void testCellPhoneCorrectlyFormatted(){
    assertTrue(login.checkCellPhoneNumber("+27 123456789"));
}
@Test
public void testCellPhoneIncorrectlyFormatted(){
    assertFalse(login.checkCellPhoneNumber("1234567898"));
}
  @Test
    public void testLoginSuccessful() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
    @Test
    public void testLoginFailed() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.loginUser("kyl_1", "wrongpassword"));
    }

    private static class login extends Login {

        public login() {
        }
    }
}