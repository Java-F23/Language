import javax.swing.*;
import java.util.List;

abstract class UserController {
    abstract boolean SignIn(JPanel panel, JTextField usernameField, JPasswordField passwordField);
    abstract void SignUp(JPanel panel, JTextField name, JTextField email, JTextField usernameField, JPasswordField passwordField);
    abstract String GetCredentials(String email);

    abstract List<String[]> retrieveCredentials(String email);

    abstract void saveCredentials(String name, String email, String username, String password);
}

