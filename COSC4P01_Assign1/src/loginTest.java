import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/* This class COSC 4P01
   @author Sahil Rashid
   @Student ID: 6954739
   Assignment #1 - User Login System

   This class uses JUnit to test successful logins, failed logins, user lockouts, and handling of empty or missing
   inputs in the userLogin system.

    This class uses concepts from the JUnit tutorial in the Samples and Tutorials module provided on Brightspace.
 */

//class for testing user login system
class loginTest {

    //instance of userLogin
    private userLogin loginSystem;

    //stores the current test name
    private String currentTestName;

    //setup method to initialize loginSystem before each test
    @BeforeEach
    void setup() {
        loginSystem = new userLogin();
        currentTestName = "";
    }

    //method to print test completion message after each test
    @AfterEach
    void afterTest() {
        System.out.println("Test " + currentTestName + " completed successfully.");
    }

    //test for successful login with valid credentials
    @Test
    void loginSuccessful() {
        currentTestName = "loginSuccessful";
        boolean result = loginSystem.login("user1", "password123");
        assertTrue(result, "Expected login to succeed with valid credentials");
    }

    //test for failed login due to incorrect credentials
    @Test
    void failedLoginIncorrectCredentials() {
        currentTestName = "failedLoginIncorrectCredentials";
        boolean result = loginSystem.login("invalidUser", "invalidPassword");
        assertFalse(result, "Expected login to fail with invalid credentials");
    }

    //test for user being locked out after 3 failed login attempts
    @Test
    void lockedAfterThreeFailedAttempts() {
        currentTestName = "lockedAfterThreeFailedAttempts";

        //simulate three failed login attempts
        loginSystem.login("validUser", "wrongPassword");
        loginSystem.login("validUser", "wrongPassword");
        loginSystem.login("validUser", "wrongPassword");

        //check if the user is locked out on the fourth attempt
        boolean result = loginSystem.login("validUser", "validPassword");
        assertFalse(result, "Expected login to fail due to account lockout after 3 failed attempts");
    }

    //test for null or empty credentials
    @Test
    void nullCredentials() {
        currentTestName = "nullCredentials";
        assertFalse(loginSystem.login("", "validPassword"), "Expected login to fail for empty username");
        assertFalse(loginSystem.login("validUser", ""), "Expected login to fail for empty password");
        assertFalse(loginSystem.login(null, "validPassword"), "Expected login to fail for null username");
        assertFalse(loginSystem.login("validUser", null), "Expected login to fail for null password");
    }
}
