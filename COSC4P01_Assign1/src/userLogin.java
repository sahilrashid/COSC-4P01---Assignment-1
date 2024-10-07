/* This class COSC 4P01
   @author Sahil Rashid
   @Student ID: 6954739
   Assignment #1 - User Login System

   This class handles the core logic for the login system by  validating user credentials, tracking failed login
   attempts, and locking out users after a set number of incorrect login attempts.
 */


//class definition for userLogin
public class userLogin {

    //valid username and password
    private final String validUsername = "user1";
    private final String validPassword = "password123";

    //track failed login attempts
    private int failedAttempts = 0;

    //maximum allowed failed attempts
    private static final int MAX_ATTEMPTS = 3;

    //login method to check username and password
    public boolean login(String username, String password) {

        //check if username or password is null or empty
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            //invalid input
            return false;
        }

        //check if failed attempts reached max
        if (failedAttempts >= MAX_ATTEMPTS) {
            //user locked out
            return false;
        }

        //check if the username and password are valid
        if (username.equals(validUsername) && password.equals(validPassword)) {
            //reset failed attempts
            failedAttempts = 0;
            //login successful
            return true;
        } else {
            //increment failed attempts
            failedAttempts++;
            //login failed
            return false;
        }
    }
}
