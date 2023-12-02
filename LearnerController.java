import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LearnerController extends UserController {

    @Override
   public boolean SignIn(JPanel panel, JTextField emailField, JPasswordField passwordField) {
        int result = JOptionPane.showConfirmDialog(null, panel, "Learner Sign In",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String enteredEmail = emailField.getText();
            char[] enteredPasswordChars = passwordField.getPassword();
            String enteredPassword = new String(enteredPasswordChars);

            // Validate credentials (this is a simple example; you may want to check against a database)
            boolean validCredentials = validateLearnerCredentials(enteredEmail, enteredPassword);

            if (validCredentials) {
                System.out.println("Learner sign-in successful!");
            } else {
                System.out.println("Invalid learner credentials.");
            }

            // Clear the password field for security reasons
            passwordField.setText("");

            return validCredentials;
        }

        return false;
    }

    @Override
    public void SignUp(JPanel panel, JTextField name, JTextField emailField, JTextField usernameField, JPasswordField passwordField) {
        int result = JOptionPane.showConfirmDialog(null, panel, "Learner Sign Up",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String email = emailField.getText();
            char[] newPasswordChars = passwordField.getPassword();
            String password = new String(newPasswordChars);

            // Save new credentials to Learner.csv
            saveCredentials(name.getText(), email, usernameField.getText(), password);

           // System.out.println("Learner sign-up successful!");

            // Clear the password field for security reasons
            passwordField.setText("");
        }
    }

    @Override
    public String GetCredentials(String email) {
        List<String[]> learnerCredentialsList = retrieveCredentials(email);

        if (!learnerCredentialsList.isEmpty()) {
            String[] credentials = learnerCredentialsList.get(0);
            String username = credentials[0];
            String password = credentials[2];

            // Return learner credentials (for example, for display purposes)
            return "Learner Credentials:\nUsername: " + username + "\nPassword: " + password;
        } else {
            return "Learner Credentials not found for email: " + email;
        }
    }

    // Method to validate learner credentials
    public boolean validateLearnerCredentials(String email, String password) {
        List<String[]> learnerCredentialsList = retrieveCredentials(email);

        for (String[] credentials : learnerCredentialsList) {
            String storedPassword = credentials[1];
            if (password.equals(storedPassword)) {
                return true;
            }
        }
        return false;
    }

    // Method to save new learner credentials to Learner.csv
    @Override
    public void saveCredentials(String name, String email, String username, String password) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Learner.csv", true))) {
            writer.println(name + "," + email + "," + username + "," + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve learner credentials from Learner.csv by email
    @Override
    public List<String[]> retrieveCredentials(String email) {
        List<String[]> learnerCredentialsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Learner.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && email.equals(parts[1])) {
                    learnerCredentialsList.add(parts);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return learnerCredentialsList;
    }
}
