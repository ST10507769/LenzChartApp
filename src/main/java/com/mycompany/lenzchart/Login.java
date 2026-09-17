/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lenzchart;

public class Login {
    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;
    
    public boolean checkUserName(String username){
        // must contain an underscore and no more than 5 charecters
        return username.contains("_")&& username.length()<=5;
    }
    
    public boolean checkPasswordComplexity(String password){
        // The password must at least have 8 chars, 1 capital, 1 number, 1 special character
        String regex ="^(?=.*[A-Z])(?=.[0-9])(?=.*[^a-zA-Z0-9]).{8,}$";
        return password.matches(regex);
    }
    
    public boolean checkCellPhoneNumber(String cellPhone){
        //The number mus contai +27 and being followed by 9 digits to show that you are south african
        String regex = "^\\+27[0-9]{9}$";
        return cellPhone.matches(regex);
        
    }
    
    public String registerUser(String username, String password, String cellPhoe, String firstName, String lastName){
        if (checkUserName(username)){
            return "Username is not correctly written; plase make sure that your username contains an underscore and not more than 5 characters.";
            
        }
        if (checkPasswordComplexity(password)){
            return "Password is not correctly written, plase make sure that your password contains at least 8 charecters, a capital letter, a number, and a special cahrecter. ";
        }
        String cellPhone = null;
        if (checkCellPhoneNumber(cellPhone)){
            return "Cell phone number is incorrect or it does not contain the south african code";
        }
        
        //If all the the information passes, store the details
        this.storedUsername = username;
        this.storedPassword = password;
        this.firstName = firstName;
        this.lastName = lastName;
        
        return "Username successful.Password successful.Cell phone number successful.User registered successfully";
        
    }
    
    public boolean loginUser(String username, String password){
        return username.equals(this.storedUsername) && password.equals(this.storedPassword);
        
    }
    
    public String returnLoginStatus(boolean loginStatus){
        if (loginStatus){
            return "Welcome" + firstName + lastName + "it is nice to have you again.";
            
        } else{
            return "Username or Password incorrect, please try again in 10 years";
        }
    }
    
}
