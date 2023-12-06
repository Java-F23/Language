import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Set;


public class LearnerController extends UserController {
    private String LearnerUsername;
    private String LearnerName;
    private String LearnerEmail;


    public void enrollments(String learnerEmail, List<String> enrollmentLanguages) {
        // Define the file path
        String filePath = "Enrollments.csv";

        // Check if the learner already exists in the file
        if (entryExists(learnerEmail, filePath)) {
            // If the learner exists, append the favorite languages to their row
            appendLanguagesToRow_enrol(learnerEmail, enrollmentLanguages, filePath);
        } else {
            // If the learner doesn't exist, add a new entry for them
            addNewEntry_enrol(learnerEmail, enrollmentLanguages, filePath);
        }
    }

    private void appendLanguagesToRow_enrol(String learnerEmail, List<String> languages, String filePath) {
        // Append the languages to the learner's row
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("temp.csv"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(learnerEmail)) {
                    // Append the existing languages to the row
                    writer.write(learnerEmail + ",");
                    for (int i = 1; i < parts.length; i++) {
                        writer.write(parts[i] + ",");
                    }

                    // Append the new languages to the row (if they don't already exist)
                    for (String language : languages) {
                        if (!Arrays.asList(parts).contains(language)) {
                            writer.write(language + ",");
                        }
                    }

                    writer.newLine();
                } else {
                    // Copy the existing line to the temporary file
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
        }

        // Replace the original file with the temporary file
        replaceFile("temp.csv", filePath);
    }


    private void addNewEntry_enrol(String learnerEmail, List<String> languages, String filePath) {
        // Add a new entry for the learner
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(learnerEmail + ",");
            for (String language : languages) {
                writer.write(language + ",");
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
        }
    }

    public void favorites(String learnerEmail, List<String> favoriteLanguages) {
        // Define the file path
        String filePath = "Favorites.csv";

        // Check if the learner already exists in the file
        if (entryExists(learnerEmail, filePath)) {
            // If the learner exists, append the favorite languages to their row
            appendLanguagesToRow(learnerEmail, favoriteLanguages, filePath);
        } else {
            // If the learner doesn't exist, add a new entry for them
            addNewEntry(learnerEmail, favoriteLanguages, filePath);
        }
    }

    private boolean entryExists(String learnerEmail, String filePath) {
        // Check if the learner exists in the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(learnerEmail)) {
                    return true; // Learner already exists in the file
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
        }
        return false; // Learner doesn't exist in the file
    }

    private void appendLanguagesToRow(String learnerEmail, List<String> languages, String filePath) {
        // Append the languages to the learner's row
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("temp.csv"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(learnerEmail)) {
                    // Append the existing languages to the row
                    writer.write(learnerEmail + ",");
                    for (int i = 1; i < parts.length; i++) {
                        writer.write(parts[i] + ",");
                    }

                    // Append the new languages to the row (if they don't already exist)
                    for (String language : languages) {
                        if (!Arrays.asList(parts).contains(language)) {
                            writer.write(language + ",");
                        }
                    }

                    writer.newLine();
                } else {
                    // Copy the existing line to the temporary file
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
        }

        // Replace the original file with the temporary file
        replaceFile("temp.csv", filePath);
    }


    private void addNewEntry(String learnerEmail, List<String> languages, String filePath) {
        // Add a new entry for the learner
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(learnerEmail + ",");
            for (String language : languages) {
                writer.write(language + ",");
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
        }
    }

    private void replaceFile(String sourcePath, String destinationPath) {
        // Replace the original file with the temporary file
        try {
            Files.move(Paths.get(sourcePath), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
        }
    }

/*
    public void enrollments(String learnerEmail, List<String> courses) {
        // Define the file path
        String filePath = "Enrollments.csv";

        // Check if the learner already exists in the file
        if (entryExists(learnerEmail, filePath)) {
            // If the learner exists, append the courses to their row
            appendCoursesToRow(learnerEmail, courses, filePath);
        } else {
            // If the learner doesn't exist, add a new entry for them
            addNewEntry(learnerEmail, courses, filePath);
        }
    }

    public void favorites(String learnerEmail, List<String> favoriteCourses) {
        // Define the file path
        String filePath = "Favorites.csv";

        // Check if the learner already exists in the file
        if (entryExists(learnerEmail, filePath)) {
            // If the learner exists, append the favorite courses to their row
            appendCoursesToRow(learnerEmail, favoriteCourses, filePath);
        } else {
            // If the learner doesn't exist, add a new entry for them
            addNewEntry(learnerEmail, favoriteCourses, filePath);
        }
    }

    public void enrollments(String learnerEmail, String course) {
        List<String> courses = new ArrayList<>();
        courses.add(course);
        processCourses(learnerEmail, courses, "Enrollments.csv");
    }

    public void favorites(String learnerEmail, String favoriteCourse) {
        List<String> favoriteCourses = new ArrayList<>();
        favoriteCourses.add(favoriteCourse);
        processCourses(learnerEmail, favoriteCourses, "Favorites.csv");
    }

    private void processCourses(String learnerEmail, List<String> courses, String filePath) {
        // Define the file path

        // Check if the learner already exists in the file
        if (entryExists(learnerEmail, filePath)) {
            // If the learner exists, append the courses to their row
            appendCoursesToRow(learnerEmail, courses, filePath);
        } else {
            // If the learner doesn't exist, add a new entry for them
            addNewEntry(learnerEmail, courses, filePath);
        }
    }

/*    private boolean entryExists(String learnerEmail, String filePath) {
        // Check if the learner exists in the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(learnerEmail)) {
                    return true; // Learner already exists in the file
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
        }
        return false; // Learner doesn't exist in the file
    }*/
    /*
private boolean entryExists(String learnerEmail, String filePath) {
    // Check if the learner exists in the file
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length > 0 && parts[0].equals(learnerEmail)) {
                return true; // Learner already exists in the file
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception (e.g., log an error message or show an alert)
    }
    return false; // Learner doesn't exist in the file
}

    /*
    private void appendCoursesToRow(String learnerEmail, List<String> courses, String filePath) {
        // Append the courses to the learner's row
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("temp.csv"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(learnerEmail)) {
                    // Append the new courses to the existing row
                    for (String course : courses) {
                        writer.write(course + ",");
                    }
                    writer.newLine();
                } else {
                    // Copy the existing line to the temporary file
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
        }

        // Replace the original file with the temporary file
        replaceFile("temp.csv", filePath);
    }*/
    /*
private void appendCoursesToRow(String learnerEmail, List<String> courses, String filePath) {
    // Append the courses to the learner's row
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
         BufferedWriter writer = new BufferedWriter(new FileWriter("temp.csv", true))) {

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length > 0 && parts[0].equals(learnerEmail)) {
                // Append the new courses to the existing row
                for (String course : courses) {
                    writer.write("," + course);  // Use "," as a delimiter and append the new course
                }
                writer.newLine();
            } else {
                // Copy the existing line to the temporary file
                writer.write(line);
                writer.newLine();
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception (e.g., log an error message or show an alert)
    }

    // Replace the original file with the temporary file
    replaceFile("temp.csv", filePath);
}


    private void addNewEntry(String learnerEmail, List<String> courses, String filePath) {
        // Add a new entry for the learner
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(learnerEmail + ",");
            for (String course : courses) {
                writer.write(course + ",");
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
        }
    }

    private void replaceFile(String sourcePath, String destinationPath) {
        // Replace the original file with the temporary file
        try {
            Files.move(Paths.get(sourcePath), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
        }
    }
*/
    private List<String> readFavorites() {
        List<String> favorites = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Favorites.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                favorites.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return favorites;
    }

    private void saveFavorites(List<String> favorites) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Favorites.csv"))) {
            for (String favorite : favorites) {
                writer.println(favorite);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
            String storedPassword = credentials[3];
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
                    LearnerUsername = parts[2];
                    LearnerName = parts[0];
                    LearnerEmail = parts[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return learnerCredentialsList;
    }

    public String getLearnerEmail() {
        return LearnerEmail;
    }

    public String getLearnerName() {
        return LearnerName;
    }

    public String getLearnerUsername() {
        return LearnerUsername;
    }

    private static final String FAVORITES_FILE_PATH = "Favorites.csv";
    private static final String ENROLLMENTS_FILE_PATH = "Enrollments.csv";

    public List<String> getFavoritesByEmail(String learnerEmail) {
        return readCoursesByEmail(learnerEmail, FAVORITES_FILE_PATH);
    }

    public List<String> getEnrollmentsByEmail(String learnerEmail) {
        return readCoursesByEmail(learnerEmail, ENROLLMENTS_FILE_PATH);
    }

    private List<String> readCoursesByEmail(String learnerEmail, String filePath) {
        List<String> courses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(learnerEmail)) {
                    // Found the learner's entry
                    for (int i = 1; i < parts.length; i++) {
                        courses.add(parts[i]);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
        }

        return courses;
    }

    public List<String> getAllLearnerEmails() {
        List<String> learnerEmails = new ArrayList<>();

        // Add emails from Favorites.csv
        learnerEmails.addAll(getEmailsFromFile(FAVORITES_FILE_PATH));

        // Add emails from Enrollments.csv
        learnerEmails.addAll(getEmailsFromFile(ENROLLMENTS_FILE_PATH));

        // Remove duplicates
        learnerEmails = new ArrayList<>(Set.copyOf(learnerEmails));

        return learnerEmails;
    }

    private List<String> getEmailsFromFile(String filePath) {
        List<String> emails = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    emails.add(parts[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
        }

        return emails;
    }
}
