package projectpartone;

import java.util.Scanner;

public class ProjectPartOne {
    String storedUsername;
    String storedPassword;
    String FirstName;
    String LastName;
    String PhoneNumber;
    
   // Username check 
   //Username should meet given requirements
   //Should contain an underscore
   //Not longer than five characters
    
    boolean checkUsername (String username){
        return username.contains("_") && username.length() <=5;
    }
    
    // Password check
    //Should meet the complexity rules
    //Should be at least eight characters long
    //Should contain a capital letter
    //Should contain a number
    //Should contain a special character
    boolean checkPasswordComplexity (String Password){
    if (Password.length() >= 8 && Password.matches(".*\\d.*") && Password.matches(".*[A-Z].*") && Password.matches(".*[^a-zA-Z0-9].*")){
        return true;
    }else{
        System.out.println("Password must be at least 8 characters and include a capital letter, number, and contain a special character");
        return false;
    }
    }
    
    // Phone number check
    //Sould meet the requirements
    //Contains an international code
    //Number should be ten characters long
    boolean checkCellPhoneNumber (String PhoneNumber){
        return PhoneNumber.matches("^\\+27[0-9]{9}$");
    }
     
    //Register user
    String registerUser (String username, String password, String PhoneNumber){
        if (!checkUsername(username)){
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special characteer";
        }
        if (!checkCellPhoneNumber(PhoneNumber)){
            return "Cell phone number incorrectly formatted or does not contain international code";
        }
        storedUsername = username;
        storedPassword = password;
        return "User successfully registered.";
    }
    
    // Login check
    boolean loginUser(String username, String password){
        return username.matches(storedUsername) && password.matches(storedPassword);        
    }
    
    // Login status message
    String returnLoginStatus(boolean loginStatus){
        if (loginStatus){
            return "Welcome " +FirstName + " " + LastName + ", it is great to see you again.";
        }else {
            return "Username or password incorrect, please try again.";
        }
    }
    
    // Main Method
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       ProjectPartOne app = new ProjectPartOne();
       
       // Get user details
        System.out.println("Enter first name: ");
        app.FirstName = input.nextLine();
        System.out.println("Enter LastName: ");
        app.LastName = input.nextLine();
        System.out.println("Enter username: ");
        String username = input.nextLine();
        System.out.println("Enter password: ");
        String password = input.nextLine();
        System.out.println("Enter phone number (+27...): ");
        String phone = input.nextLine();
        
    // Register
       String registerMessage = app.registerUser(username, password, phone);
        System.out.println(registerMessage);
        
    // Login
        System.out.println("\n--- LOGIN ---");
        System.out.println("Enter username: ");
        String loginUser = input.nextLine();
        System.out.println("Enter password: ");
        String loginPass = input.nextLine();
    boolean login = app.loginUser(loginUser, loginPass);
        System.out.println(app.returnLoginStatus(login));
    }
    
}
