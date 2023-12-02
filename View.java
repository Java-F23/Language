import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//Note: Back button, frames are not resizable, and pages should close after we open a new page, or at least
//disappear from view.
//Display welcome page
//Home page:
//      //First chooses to sign in or sign up as Admin/Learner
//First Page:
//     Title, a number of buttons (search buttons, view all (tabular view)
//All other pages operated based on whether it's a user or an admin (they're all functions).
//A user can search by language, an admin can only view all languages.
//An Admin can view a list of learner names, their favorite courses, their completed and in progress courses
//and courses coming up
//An Admin can view the learner details, but cannot view the learners' passwords
//A user can view their favorite courses, their past, in progress, and future courses
//a User can (maybe) unfavorite a course

public class View extends JFrame {
    private JTextField LangNameField;
    private JTextField regionField;
    private JTextField descriptionField;
    private JTextField popularityField;
    private JTextField newProficiencyLevelsList;
    private JButton saveLanguageButton;

    private JTextField textField;
    private JButton viewAllButton;
    private JButton popularityButton;
    private JButton proficiencyButton;
    private JButton languageButton;
    private JButton languageProficiencyButton;
    private JButton regionButton;
    private JTextField nameField;
    private JPanel buttonPanel;
    private JPanel optionsPanel;
    private JTextField emailField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton signUpButton;
    private JTextField minPopularityField;
    private JTextField maxPopularityField;
    private JButton searchByRangeButton;
    private JButton searchByValueButton;


    View() {
        initializeComponents();
    }

    private void initializeComponents() {
        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create buttons for sign in and sign up
        signInButton = new JButton("Sign In");
        signUpButton = new JButton("Sign Up");

        // Add action listeners to the sign in and sign up buttons
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sign In button clicked");
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sign Up button clicked");
            }
        });

        // Create a panel for the buttons
        optionsPanel = new JPanel();
        optionsPanel.add(signInButton);
        optionsPanel.add(signUpButton);

        // Add the panel to the frame
        getContentPane().add(optionsPanel);
    }

    public void displaySignInSignUpOptions() {
        // Show the options panel in a custom dialog
        JDialog dialog = new JDialog(this, "Options", true);
        dialog.getContentPane().add(optionsPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        // Return the buttons
     /*   ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(signInButton);
        buttons.add(signUpButton);

        return buttons;*/
    }

    public JButton getSignInButton() {
        return signInButton;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view = new View();
                view.PopularityOptionsPage();
                view.setVisible(true);
            }
        });
    }

    public JButton displayWelcomeMessage() {
        // Create a JPanel for the content panel
        JPanel contentPanel = new JPanel();
        // Create a label for the welcome message
        JLabel welcomeLabel = new JLabel("Welcome to the Application!");
        // Create an OK button
        JButton okButton = new JButton("OK");
        // Add action listener to the OK button
        // Add components to the content panel
        contentPanel.add(welcomeLabel);
        contentPanel.add(okButton);
        // Set layout manager for the content panel (you can customize it based on your needs)
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        // Set up the frame
        setTitle("Welcome to Polyglot!");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        // Set the content pane
        setContentPane(contentPanel);
        // Make the frame visible
        setVisible(true);
        return okButton;
    }

    public ArrayList<JButton> openHomePage() {
        // Create a JPanel for the content panel
        JPanel contentPanel = new JPanel();

        // Create a label for the title
        JLabel titleLabel = new JLabel("Polyglot");

        // Create buttons for Admin and Learner
        JButton adminButton = new JButton("Admin");
        JButton learnerButton = new JButton("Learner");

        // Add action listeners to the Admin and Learner buttons
        // Add components to the content panel
        contentPanel.add(titleLabel);
        contentPanel.add(adminButton);
        contentPanel.add(learnerButton);

        // Set layout manager for the content panel
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Set up the frame
        setTitle("Polyglot - Home Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the content pane
        setContentPane(contentPanel);

        // Make the frame visible
        setVisible(true);
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(adminButton);
        buttons.add(learnerButton);
        return buttons;
    }

    public JPanel getOptionsPanel() {
        return optionsPanel;
    }

    //First Admin page:
    public void openAdminPage() {
        JFrame adminPage = new JFrame("Admin Page");
        adminPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminPage.setSize(400, 300);
        adminPage.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton viewLearnersStatsButton = new JButton("View Learners' Stats");
        JButton addLanguageButton = new JButton("Add Language");
        JButton addCourseButton = new JButton("Add Course");
        JButton addMaterialsButton = new JButton("Add Materials");
        JButton modifyMaterialsButton = new JButton("Modify Materials");
        JButton removeLanguageButton = new JButton("Remove Language");
        JButton removeCourseButton = new JButton("Remove Course");

        buttonPanel.add(viewLearnersStatsButton);
        buttonPanel.add(addLanguageButton);
        buttonPanel.add(addCourseButton);
        buttonPanel.add(addMaterialsButton);
        buttonPanel.add(modifyMaterialsButton);
        buttonPanel.add(removeLanguageButton);
        buttonPanel.add(removeCourseButton);

        adminPage.add(buttonPanel, BorderLayout.CENTER);
        adminPage.setVisible(true);
    }

    public JButton getViewLearnersStatsButton() {
        // Return the specific button
        return (JButton) buttonPanel.getComponent(0); // Adjust index based on button order
    }

    public JButton getAddLanguageButton() {
        // Return the specific button
        return (JButton) buttonPanel.getComponent(1); // Adjust index based on button order
    }

    public JButton getAddCourseButton() {
        // Return the specific button
        return (JButton) buttonPanel.getComponent(2); // Adjust index based on button order
    }

    public JButton getAddMaterialsButton() {
        // Return the specific button
        return (JButton) buttonPanel.getComponent(3); // Adjust index based on button order
    }

    public JButton getModifyMaterialsButton() {
        // Return the specific button
        return (JButton) buttonPanel.getComponent(4); // Adjust index based on button order
    }

    public JButton getRemoveLanguageButton() {
        // Return the specific button
        return (JButton) buttonPanel.getComponent(5); // Adjust index based on button order
    }

    public JButton getRemoveCourseButton() {
        // Return the specific button
        return (JButton) buttonPanel.getComponent(6); // Adjust index based on button order
    }

    public void AdminAddLanguagePage(){
        JFrame searchPage = new JFrame("Add New Language");
        searchPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchPage.setSize(400, 300);
        searchPage.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        // Create text fields
        LangNameField = new JTextField();
        regionField = new JTextField();
        descriptionField = new JTextField();
        popularityField = new JTextField();
        newProficiencyLevelsList = new JTextField();

        // Create labels for text fields
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(LangNameField);
        inputPanel.add(new JLabel("Region:"));
        inputPanel.add(regionField);
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Popularity:"));
        inputPanel.add(popularityField);
        inputPanel.add(new JLabel("ProficiencyLevels: (comma separated)"));
        inputPanel.add(newProficiencyLevelsList);

        // Create search button
        saveLanguageButton = new JButton("Save");
        inputPanel.add(saveLanguageButton);

        searchPage.add(inputPanel, BorderLayout.CENTER);
        searchPage.setVisible(true);
    }

    public JTextField getNewProficiencyLevelsList() {
        return newProficiencyLevelsList;
    }

    public JTextField getLangNameField() {
        return LangNameField;
    }

    public JTextField getRegionField() {
        return regionField;
    }

    public JTextField getDescriptionField() {
        return descriptionField;
    }

    public JTextField getPopularityField() {
        return popularityField;
    }

    public JButton getSaveLanguageButton() {
        return saveLanguageButton;
    }

    public void displaySuccessMessage() {
        JOptionPane.showMessageDialog(this,
                "Added successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public JButton openSignInPage() {
        JFrame signInPage;
        signInPage = new JFrame("Sign In");
        signInPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signInPage.setSize(300, 200);
        signInPage.setLayout(new BorderLayout());

        JPanel signInPanel = new JPanel();
        signInPanel.setLayout(new GridLayout(3, 2));

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();


        signInPanel.add(emailLabel);
        signInPanel.add(emailField);
        signInPanel.add(passwordLabel);
        signInPanel.add(passwordField);

        JButton okButton;
        // OK Button
        okButton = new JButton("OK");
        signInPanel.add(new JLabel()); // Empty label for spacing
        signInPanel.add(okButton);

        // Action listener for OK button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // You can perform actions on OK button click here
                signInPage.dispose(); // Close the sign-up frame
            }
        });

        signInPage.add(signInPanel, BorderLayout.CENTER);
        signInPage.setVisible(true);
        return okButton;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getEmailField() {
        // Return the email text field
        return emailField;
    }

    public JPasswordField getPasswordField() {
        // Return the password text field
        return passwordField;
    }

    public JButton openSignUpPage() {
        JFrame signUpFrame;
        signUpFrame = new JFrame("Sign Up");
        signUpFrame.setSize(400, 200);
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel signUpPanel = new JPanel();
        signUpPanel.setLayout(new GridLayout(5, 2));

        // Name
        signUpPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        signUpPanel.add(nameField);

        // Email
        signUpPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        signUpPanel.add(emailField);

        // Username
        signUpPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        signUpPanel.add(usernameField);

        // Password
        signUpPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        signUpPanel.add(passwordField);
        JButton okButton;
        // OK Button
        okButton = new JButton("OK");
        signUpPanel.add(new JLabel()); // Empty label for spacing
        signUpPanel.add(okButton);

        // Action listener for OK button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // You can perform actions on OK button click here
                signUpFrame.dispose(); // Close the sign-up frame
            }
        });

        signUpFrame.add(signUpPanel);
        signUpFrame.setVisible(true);

        return okButton;
    }

    public void openLearnerPage() {
        JFrame learnPage = new JFrame("Learner Page");
        learnPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        learnPage.setSize(400, 300);
        learnPage.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        viewAllButton = new JButton("View All");
        popularityButton = new JButton("Popularity");
        proficiencyButton = new JButton("Proficiency");
        languageButton = new JButton("Language");
        languageProficiencyButton = new JButton("Language Proficiency");
        regionButton = new JButton("Region");

        buttonPanel.add(viewAllButton);
        buttonPanel.add(popularityButton);
        buttonPanel.add(proficiencyButton);
        buttonPanel.add(languageButton);
        buttonPanel.add(languageProficiencyButton);
        buttonPanel.add(regionButton);

        learnPage.add(buttonPanel, BorderLayout.CENTER);
        learnPage.setVisible(true);
    }

    public JButton getViewAllButton() {
        return viewAllButton;
    }

    public JButton getPopularityButton() {
        return popularityButton;
    }

    public JButton getProficiencyButton() {
        return proficiencyButton;
    }

    public JButton getLanguageButton() {
        return languageButton;
    }

    public JButton getLanguageProficiencyButton() {
        return languageProficiencyButton;
    }

    public JButton getRegionButton() {
        return regionButton;
    }

    public void PopularityOptionsPage() {
        setTitle("Popularity Options");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Create a panel for the options
        JPanel optionsPanel = new JPanel(new FlowLayout());

        // Create input fields for the range
        minPopularityField = new JTextField(5);
        maxPopularityField = new JTextField(5);

        // Create the "Search By Range" button
        searchByRangeButton = new JButton("Search By Range");

        // Add input fields, the "Search By Range" button, and result table to the options panel
        optionsPanel.add(new JLabel("Min Popularity: "));
        optionsPanel.add(minPopularityField);
        optionsPanel.add(new JLabel("Max Popularity: "));
        optionsPanel.add(maxPopularityField);
        optionsPanel.add(searchByRangeButton);

        setContentPane(optionsPanel);
        setVisible(true);
    }

    public JButton getSearchByRangeButton() {
        return searchByRangeButton;
    }

    public void setPopTable(List<LanguageModel> L) {
        // Create a table to display the results
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Language", "Popularity"}, 0);
        // JTable resultTable = new JTable(tableModel);
        JTable resultTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Display the results in the table
        tableModel.setRowCount(0); // Clear existing table data
        for (LanguageModel language : L) {
            tableModel.addRow(new Object[]{language.getName(), language.getPopularity()});
        }

        resultTable.setEnabled(false);

        // Add input fields, the "Search By Range" button, and result table to the options panel
        JPanel optionsPanel = new JPanel(new FlowLayout());

        optionsPanel.add(new JScrollPane(resultTable));

        setContentPane(optionsPanel);
    }

    public JTextField getMinPopularityField() {
        return minPopularityField;
    }

    public JTextField getMaxPopularityField() {
        return maxPopularityField;
    }

    public void LearnerViewAllPage(LanguageCatModel cat) {
        setTitle("View All Page");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        List<LanguageModel> available = cat.getAvailableLanguages();

        // Create a panel for the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Create a title label
        JLabel titleLabel = new JLabel("Languages and courses available:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel);

        // Create a scroll pane for the content
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        contentPanel.setAutoscrolls(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
        setContentPane(scrollPane);

        for (LanguageModel language : available) {
            JLabel languageLabel = new JLabel(language.getName());
            JLabel descriptionLabel = new JLabel(language.getDescription());
            JLabel proficiencyLabel = new JLabel("Proficiency levels:");
            contentPanel.add(languageLabel);
            contentPanel.add(descriptionLabel);
            contentPanel.add(proficiencyLabel);

            for (String proficiencyLevel : language.getProficiencyLevels()) {
                JLabel proficiencyLevelLabel = new JLabel("-" + proficiencyLevel);
                contentPanel.add(proficiencyLevelLabel);
            }
        }

        setVisible(true);
    }

    public void ProficiencyLevelOptionsPage(){

    setTitle("Proficiency Level Options");

    setSize(600,500);

    setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.insets =new

    Insets(5,5,5,5);
        panel.setBackground(Color.WHITE);

    JLabel label = new JLabel("Enter Proficiency Level:"); //(comma-separated)
    constraints.gridx =0;
    constraints.gridy =0;
    constraints.gridwidth =2;
        panel.add(label,constraints);

        textField = new JTextField(20);
    constraints.gridx =0;
    constraints.gridy =1;
    constraints.gridwidth =2;
        panel.add(textField,constraints);

    searchByValueButton = new JButton("Search");
    constraints.gridx =0;
    constraints.gridy =2;
    constraints.gridwidth =1;
        panel.add(searchByValueButton,constraints);

        setContentPane(panel);
        setVisible(true);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void showProfResults(LanguageCatModel categorization, JTextField textField) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        JTextArea resultTextArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 5; //2
        panel.add(scrollPane, constraints);
        String input = textField.getText();
        ArrayList<String> proficiencyLevels = new ArrayList<String>();
        proficiencyLevels.add(input);

        List<LanguageModel> filteredLanguages = categorization.filterByProficiencyLevels(proficiencyLevels);

        if (filteredLanguages.isEmpty()) {
            if (input.isEmpty())
                resultTextArea.setText("Please enter a proficiency level");
            else
                resultTextArea.setText("No languages found for the specified proficiency level.");
        } else {
            StringBuilder resultText = new StringBuilder("Filtered Languages:\n");
            for (LanguageModel language : filteredLanguages) {
                resultText.append(language.getName()).append(" - ").append(language.getDescription()).append("\n");
            }
            resultTextArea.setText(resultText.toString());
        }
        setContentPane(panel);

        setVisible(true);
    }

    public JButton getSearchByValueButton()
    {
        return searchByValueButton;
    }
}
