import javax.swing.*;
import java.util.List;

abstract class UserController {

    abstract List<String[]> retrieveCredentials(String email);

    abstract void saveCredentials(String name, String email, String username, String password);
}

