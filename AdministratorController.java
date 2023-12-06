import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorController extends UserController{
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
    public boolean checkCredentials(String enteredEmail, String enteredPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Admin.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && enteredEmail.equals(parts[3]) && enteredPassword.equals(parts[1])) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
