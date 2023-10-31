import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Part 3 Q 2
public class SignIn extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public SignIn() {
            setTitle("Sign In");
            setSize(400, 150);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(3, 2));

            // Labels
            JLabel emailLabel = new JLabel("Email:");
            JLabel passwordLabel = new JLabel("Password:");

            // Text fields and password field
            emailField = new JTextField(20);
            passwordField = new JPasswordField(20);
            passwordField.setEchoChar('\u2022'); // Unicode for bullet (black dot)

            // Add components to the frame
            add(emailLabel);
            add(emailField);
            add(passwordLabel);
            add(passwordField);

            // Create a button for sign-in
            JButton signInButton = new JButton("Sign In");
            add(signInButton);

            signInButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String email = emailField.getText();
                    char[] password = passwordField.getPassword();

                    // Check if the email and password exist in the CSV file
                    if (isSignInSuccessful(email, new String(password))) {
                        JOptionPane.showMessageDialog(null, "Sign in successful.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Sign in failed. Please check your credentials.");
                    }
                }
            });

            // Display the frame
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
    }

    private boolean isSignInSuccessful(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("user_data.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 4) {
                    String storedEmail = fields[0];
                    String storedPassword = fields[3];
                    if (email.equals(storedEmail) && password.equals(storedPassword)) {
                        return true; // Sign in successful
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading user data.");
        }
        return false; // Sign in failed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SignIn();
        });
    }
}
