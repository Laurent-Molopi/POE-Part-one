/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author south
 */
public class LoginTestTest {

    private Login system;

    @BeforeEach
    public void setup() {
        system = new Login();
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        system.setUsername("kyl_1");
        assertTrue(system.checkusername(), "Username should be correctly formatted");
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        system.setUsername("kyle!!!!!!!");
        assertFalse(system.checkusername(), "Username should be incorrectly formatted");
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() {
        system.setPassword("Ch&&sec@ke99!");
        assertTrue(system.checkPasswordcomplexity(), "Password should meet complexity requirements");
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        system.setPassword("password");
        assertFalse(system.checkPasswordcomplexity(), "Password should not meet complexity requirements");
    }

    @Test
    public void testRegisterUserValidUsernameAndPassword() {
        system.setUsername("kyl_1");
        system.setPassword("Ch&&sec@ke99!");
        String registrationStatus = system.registerUser();
        assertEquals("Username successfully captured\nPassword successfully captured", registrationStatus, 
                     "The registration should be successful with valid username and password.");
    }

    @Test
    public void testRegisterUserInvalidUsername() {
        system.setUsername("kyle!!!!!!!");
        system.setPassword("Ch&&sec@ke99!");
        String registrationStatus = system.registerUser();
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", 
                     registrationStatus, 
                     "The registration should fail with an invalid username.");
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        system.setUsername("kyl_1");
        system.setPassword("password");
        String registrationStatus = system.registerUser();
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", 
                     registrationStatus, 
                     "The registration should fail with an invalid password.");
    }

    @Test
    public void testLoginSuccess() {
        system.CreatAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        boolean loginStatus = system.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(loginStatus, "Login should be successful with correct username and password.");
    }

    @Test
    public void testLoginFailure() {
        system.CreatAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        boolean loginStatus = system.loginUser("kyl_1", "wrongpassword");
        assertFalse(loginStatus, "Login should fail with incorrect password.");
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        system.CreatAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        boolean loginStatus = system.loginUser("kyl_1", "Ch&&sec@ke99!");
        String loginMessage = system.returnLoginStatus(loginStatus);
        assertEquals("Welcome John, Doe it is great to see you again.", loginMessage, "The login status message should indicate a successful login.");
    }

    @Test
    public void testReturnLoginStatusFailure() {
        system.CreatAccount("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        boolean loginStatus = system.loginUser("kyl_1", "wrongpassword");
        String loginMessage = system.returnLoginStatus(loginStatus);
        assertEquals("Username or password incorrect, please try again", loginMessage, "The login status message should indicate a failed login.");
    }
}