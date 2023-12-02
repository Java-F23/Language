import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//fix the system out stuff, they're useless
public class AdministratorController extends UserController{
    @Override //was usernameField
    boolean SignIn(JPanel panel, JTextField emailField, JPasswordField passwordField) {
        int result = JOptionPane.showConfirmDialog(null, panel, "Administrator Sign In",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String enteredEmail = emailField.getText();
            char[] enteredPasswordChars = passwordField.getPassword();
            String enteredPassword = new String(enteredPasswordChars);

            // Validate credentials by checking against a CSV file
            boolean validCredentials = checkCredentials(enteredEmail, enteredPassword);

            if (validCredentials) {
                System.out.println("Administrator sign-in successful!");
            } else {
                System.out.println("Invalid administrator credentials.");
            }

            // Clear the password field for security reasons
            passwordField.setText("");

            return validCredentials;
        }

        return false;
    }

    @Override
    void SignUp(JPanel panel, JTextField name, JTextField email, JTextField usernameField, JPasswordField passwordField) {
    String username;
    String password;
        int result = JOptionPane.showConfirmDialog(null, panel, "Administrator Sign Up",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            username = usernameField.getText();
            char[] newPasswordChars = passwordField.getPassword();
            password = new String(newPasswordChars);

            // Save new credentials to Admin.csv
            saveCredentials(name.getText(), email.getText(), username, password);

          //  System.out.println("Administrator sign-up successful!");

            // Clear the password field for security reasons
            passwordField.setText("");
        }
    }
@Override
    public void saveCredentials(String name, String email, String username, String password) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Admin.csv", true))) {
            writer.println(username + "," + password + "," + name + "," + email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String[]> retrieveCredentials(String email) {
        List<String[]> adminCredentialsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Admin.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && email.equals(parts[3])) {
                    adminCredentialsList.add(parts);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adminCredentialsList;
    }

    @Override
    String GetCredentials(String email) {
        List<String[]> adminCredentialsList = retrieveCredentials(email);

        if (!adminCredentialsList.isEmpty()) {
            String[] credentials = adminCredentialsList.get(0);
            String username = credentials[0];
            String password = credentials[1];
            String name = credentials.length > 2 ? credentials[2] : "";
            String stars = "";

            for(int i=0; i < password.length(); i++)
                stars = stars + "*";

            return "Administrator Credentials:\nUsername: " + username + "\nPassword: " + stars + "\nName: " + name;
        } else {
            return "Administrator not found for the provided email.";
        }
    }
    public boolean checkCredentials(String enteredEmail, String enteredPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Admin.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && enteredEmail.equals(parts[3]) && enteredPassword.equals(parts[1])) {
                    // Additional fields: parts[2] is 'name' and parts[3] is 'email'
                   /* String name = parts.length > 2 ? parts[2] : "";
                    String email = parts.length > 3 ? parts[3] : "";
                    System.out.println("Administrator Name: " + name);
                    System.out.println("Administrator Email: " + email);*/
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
