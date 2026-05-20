package IteratorsExceptionUnitTestingFileManipulation;

class InvalidUserException extends Exception{
    public InvalidUserException(String message){
        super(message);
    }
}

public class Validator {
    public void validateAge(int age) throws InvalidUserException {
        if (age < 0){
            throw new InvalidUserException("Age cannot be negative");
        }
        if (age < 18){
            throw new InvalidUserException("Age must be 18 or above");
        }
    }

    public void validateUsername(String username) throws InvalidUserException{
        if (username == null){
            throw new InvalidUserException("Username cannot be empty");
        }
        String tusername = username.trim();
        if (tusername.length() < 5){
            throw new InvalidUserException("Username must be at least 5 characters long");
        }
        if (username.contains(" ")){
            throw new InvalidUserException("Username cannot contain spaces");
        }
    }

    public void validateEmail(String email) throws InvalidUserException{
        if (email == null){
            throw new InvalidUserException("Email cannot be empty");
        }
        if (!email.contains("@")){
            throw new InvalidUserException("Email must contain @");
        }

        int index = email.indexOf("@");
        String nextIndex = email.substring(index + 1);
        if (!nextIndex.contains(".")){
            throw new InvalidUserException("Email must contain dot after @");
        }
    }

    public void validateUser(String username, String email, int age) throws InvalidUserException{
        validateUsername(username);
        validateEmail(email);
        validateAge(age);
        System.out.println("User is valid.");
    }

    public static void main(String[] args) {
        Validator validator = new Validator();
        // 1. Valid user
        System.out.println("--- Testing valid user ---");
        try {
            validator.validateUser("amina123", "amina@example.com", 21);
        } catch (InvalidUserException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // 2. Invalid user: username too short
        System.out.println("\n--- Testing invalid user (username too short) ---");
        try {
            validator.validateUser("ali", "ali@example.com", 20);
        } catch (InvalidUserException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // 3. Invalid user: username contains spaces
        System.out.println("\n--- Testing invalid user (username contains spaces) ---");
        try {
            validator.validateUser("sara 22", "sara@example.com", 19);
        } catch (InvalidUserException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // 4. Invalid user: email missing dot after @, and age under 18
        System.out.println("\n--- Testing invalid user (email missing dot after @ and age < 18) ---");
        try {
            validator.validateUser("kerim99", "kerimexample.com", 17);
        } catch (InvalidUserException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
