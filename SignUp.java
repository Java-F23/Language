/*import javax.swing.*;
import java.awt.*;

public class SignUp extends JFrame {
    private JTextField emailField, mobileField, roleField;
    private JPasswordField passwordField;

    public SignUp() {
        setTitle("Sign Up");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Labels
        JLabel emailLabel = new JLabel("Email:");
        JLabel mobileLabel = new JLabel("Mobile:");
        JLabel roleLabel = new JLabel("Role:");
        JLabel passwordLabel = new JLabel("Password:");

        // Text fields and password field
        emailField = new JTextField(20);
        mobileField = new JTextField(20);
        roleField = new JTextField(20);
        passwordField = new JPasswordField(20);

        // Set the echo character for the password field to display black dots
        passwordField.setEchoChar('\u2022'); // Unicode for bullet (black dot)

        // Add components to the frame
        add(emailLabel);
        add(emailField);
        add(mobileLabel);
        add(mobileField);
        add(roleLabel);
        add(roleField);
        add(passwordLabel);
        add(passwordField);

        // Create a button for submission, and add an action listener if needed

        // Display the frame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SignUp();
        });
    }
}
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
//Part 1 q2
public class SignUp extends JFrame {
    private JTextField emailField, mobileField, roleField;
    private JPasswordField passwordField;

    public SignUp() {
            setTitle("Sign Up");
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(6, 2));

            // Labels
            JLabel emailLabel = new JLabel("Email:");
            JLabel mobileLabel = new JLabel("Mobile:");
            JLabel roleLabel = new JLabel("Role:");
            JLabel passwordLabel = new JLabel("Password:");

            // Text fields and password field
            emailField = new JTextField(20);
            mobileField = new JTextField(20);
            roleField = new JTextField(20);
            passwordField = new JPasswordField(20);
            passwordField.setEchoChar('\u2022'); // Unicode for bullet (black dot)

            // Add components to the frame
            add(emailLabel);
            add(emailField);
            add(mobileLabel);
            add(mobileField);
            add(roleLabel);
            add(roleField);
            add(passwordLabel);
            add(passwordField);

            JButton generatePasswordButton = new JButton("Generate Random Password");
            add(generatePasswordButton);

            generatePasswordButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String randomPassword = generateRandomPassword();
                    passwordField.setText(randomPassword);
                }
            });

            // Create a button for submission
            JButton signUpButton = new JButton("Sign Up");
            add(signUpButton);

            signUpButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String email = emailField.getText();
                    String mobile = mobileField.getText();
                    String role = roleField.getText();
                    char[] password = passwordField.getPassword();

                    // Check if all fields are filled
                    if (email.isEmpty() || mobile.isEmpty() || role.isEmpty() || password.length == 0) {
                        JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                    } else {
                        // Save the information to a CSV file
                        saveToCSV(email, mobile, role, new String(password));
                        JOptionPane.showMessageDialog(null, "Sign up successful.");
                    }
                }
            });

            // Display the frame
            pack();
            setLocationRelativeTo(null);
            setVisible(true);

    }

    private String generateRandomPassword() {
        int passwordLength = 10; // You can adjust the length as needed
        String validCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+=-";
        StringBuilder password = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(validCharacters.length());
            char randomChar = validCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }

    private void saveToCSV(String email, String mobile, String role, String password) {
        try (FileWriter writer = new FileWriter("user_data.csv", true)) {
            writer.append(email);
            writer.append(',');
            writer.append(mobile);
            writer.append(',');
            writer.append(role);
            writer.append(',');
            writer.append(password);
            writer.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving data to CSV.");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SignUp();
        });
    }
}
