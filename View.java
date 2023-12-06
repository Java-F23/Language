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
//a User can (maybe) un-favorite a course

public class View extends JFrame {
    private JTextField videoField;
    private JTextField bookField;
    private JButton RemoveButtonRemoveCourse;
    private JTextField languageField_AddCourse;
    private JTextField nameField_AddCourse;
    private JTextField courseDescriptionField;
    private JButton saveButtonAddCourse;
    private JComboBox regionComboBox_Region;
    private JButton searchButton_Region;
    private JTextArea resultTextArea_Region;
    private JTextArea resultTextArea_LangProf;
    private JTextField languageNameField_LangProf;
    private JTextField proficiencyLevelField_LangProf;
    private JButton searchButton_LangProf;
    private JTextField LanguageSearchInput;
    private JButton searchByLanguageButton;
    private ArrayList<JButton> EnrollButtons;
    private ArrayList<JButton> FavButtons;
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
    private JButton ViewLearnerProfile;
    private JButton logOut;

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
        /*signInButton.addActionListener(new ActionListener() {
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
        });*/

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
/*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            view.PopularityOptionsPage();
            view.setVisible(true);
        });
    }*/

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

    public void displayFailSignInMessage() {
        JOptionPane.showMessageDialog(this,
                "Failed to sign in. Please check credentials, or Sign Up first.",
                "Failed to Sign In",
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
        okButton.addActionListener(e -> {
            // You can perform actions on OK button click here
            signInPage.dispose(); // Close the sign-up frame
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
        okButton.addActionListener(e -> {
            // You can perform actions on OK button click here
            signUpFrame.dispose(); // Close the sign-up frame
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
        ViewLearnerProfile = new JButton("View Profile");
        viewAllButton = new JButton("View All");
        popularityButton = new JButton("Popularity");
        proficiencyButton = new JButton("Proficiency");
        languageButton = new JButton("Language");
        languageProficiencyButton = new JButton("Language Proficiency");
        regionButton = new JButton("Region");

        buttonPanel.add(ViewLearnerProfile);
        buttonPanel.add(viewAllButton);
        buttonPanel.add(popularityButton);
        buttonPanel.add(proficiencyButton);
        buttonPanel.add(languageButton);
        buttonPanel.add(languageProficiencyButton);
        buttonPanel.add(regionButton);
       // buttonPanel.add(logOut);

        learnPage.add(buttonPanel, BorderLayout.CENTER);
        learnPage.setVisible(true);
    }
    public JButton getViewLearnerProfile() {
        return ViewLearnerProfile;
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

    public void setLanguageTable(List<LanguageModel> languageList) {
        // Create a table to display the results
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[]{"Language", "Region", "Description", "Proficiency Levels", "Popularity"}, 0);

        JTable resultTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Display the results in the table
        for (LanguageModel language : languageList) {
            JButton languageButton = new JButton(language.getName());
            languageButton.addActionListener(e -> {
                // Open EnrollmentDialog when a language button is clicked
                EnrollmentDialog enrollmentDialog = new EnrollmentDialog(View.this, language.getName());
                enrollmentDialog.setVisible(true);
            });

            // Add a row to the table with language information
            tableModel.addRow(new Object[]{
                    languageButton.getText(), // Extract text from the button
                    language.getRegion(),
                    language.getDescription(),
                    String.join(", ", language.getProficiencyLevels()), // Assuming proficiency levels are a list
                    language.getPopularity()
            });
        }

        // Add input fields, the result table, and enrollment buttons to the options panel
        JPanel optionsPanel = new JPanel(new FlowLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel bottomPanelFav = new JPanel(new FlowLayout(FlowLayout.LEFT));

        EnrollButtons = new ArrayList<>();
        FavButtons = new ArrayList<>();

        for(int i=0; i< languageList.size(); i++) {
            JButton o = new JButton ("Enroll into " + languageList.get(i).getName());
            bottomPanel.add(o);
            EnrollButtons.add(o);
            JButton f = new JButton("Add to Favorites: " + languageList.get(i).getName());
            System.out.println(languageList.get(i).getName());
            bottomPanelFav.add(f);
            FavButtons.add(f);
        }

        optionsPanel.add(new JScrollPane(resultTable));

        // Add the main content panel and the bottom button panel to the frame
        optionsPanel.add(bottomPanel, BorderLayout.SOUTH);
        optionsPanel.add(new JLabel());
        optionsPanel.add(bottomPanelFav, BorderLayout.SOUTH);


        // Set the frame content pane to the options panel
        setContentPane(optionsPanel);
    }

    public ArrayList<JButton> getEnrollButtons()
    {
        return EnrollButtons;
    }

    public ArrayList<JButton> getFavButtons() {
        return FavButtons;
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

        // Create a list of LanguageModel objects for the setLanguageTable function
        List<LanguageModel> languageList = new ArrayList<>();

        for (LanguageModel language : available) {
            String profLevels = "";
            for(String l : language.getProficiencyLevels())
            {
                profLevels = profLevels + l + ",";
            }

            // Add a button for each language to the language list
            if(!profLevels.isEmpty())
            languageList.add(new LanguageModel(language.getName(), language.getRegion(), language.getDescription(), language.getPopularity(), profLevels.substring(0, profLevels.length() - 1)));
            else
                languageList.add(new LanguageModel(language.getName(), language.getRegion(), language.getDescription(), language.getPopularity()));

            // Add the language button to the content panel
            contentPanel.add(languageButton);
        }

        // Use the setLanguageTable function to display the languages in a table
        setLanguageTable(languageList);

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
        ArrayList<String> proficiencyLevels = new ArrayList<>();
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


    public void LanguageOptionsPage(LanguageCatModel categorization) {
        setTitle("Language Options");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel("Enter Language Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(label, constraints);

        LanguageSearchInput = new JTextField(20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(LanguageSearchInput, constraints);

        searchByLanguageButton = new JButton("Search");  //By Language
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(searchByLanguageButton, constraints);

        JTextArea resultTextArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(scrollPane, constraints);

        searchByLanguageButton.addActionListener(e -> {
            String input = LanguageSearchInput.getText();

            List<LanguageModel> filteredLanguages = categorization.filterByLanguage(input);

            if (filteredLanguages.size() == 0) {
                if(input.isEmpty())
                    resultTextArea.setText("Please enter a language:");
                else
                    resultTextArea.setText("No languages found for the specified name.");
            } else {
                StringBuilder resultText = new StringBuilder("Filtered Languages:\n");
                for (LanguageModel language : filteredLanguages) {
                    resultText.append(language.getName()).append("\n");
                    resultText.append("Proficiency Levels and Descriptions:\n");
                    for (String level : language.getProficiencyLevels()) {
                        resultText.append(level).append("- \n").append(language.getProficiencyLevelDescription(level)).append("\n");
                    }
                }
                resultTextArea.setText(resultText.toString());
            }
        });

        setContentPane(panel);
        setVisible(true);
    }

    public JTextField getLanguageSearchInput() {
        return LanguageSearchInput;
    }

    public JButton getSearchByLanguageButton() {
        return searchByLanguageButton;
    }

    public void ShowLangProfSearchPage()
    {
            setTitle("Language and Proficiency Level Search");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            // Create components
            JLabel titleLabel = new JLabel("Enter Language and Proficiency Level");
            languageNameField_LangProf = new JTextField(20);
            proficiencyLevelField_LangProf = new JTextField(20);
            searchButton_LangProf = new JButton("Search");
            resultTextArea_LangProf = new JTextArea(10, 30);
        resultTextArea_LangProf.setEditable(false); // Make the text area read-only

            // Create a panel for the content
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BorderLayout());

            // Create a panel for input fields
            JPanel inputPanel = new JPanel(new GridLayout(3, 2));
            inputPanel.add(new JLabel("Language Name:"));
            inputPanel.add(languageNameField_LangProf);
            inputPanel.add(new JLabel("Proficiency Level:"));
            inputPanel.add(proficiencyLevelField_LangProf);
            inputPanel.add(new JLabel()); // Empty label for spacing
            inputPanel.add(searchButton_LangProf);

            // Create a scroll pane for the result text area
            JScrollPane scrollPane = new JScrollPane(resultTextArea_LangProf);

            // Add components to the content panel
            contentPanel.add(titleLabel, BorderLayout.NORTH);
            contentPanel.add(inputPanel, BorderLayout.CENTER);
            contentPanel.add(scrollPane, BorderLayout.SOUTH);

            // Add content panel to the frame
            setContentPane(contentPanel);
            setVisible(true);
    }

    public JTextArea getResultTextArea_LangProf (){
        return resultTextArea_LangProf;
    }

    public JButton getSearchButton_LangProf() {
        return searchButton_LangProf;
    }

    public JTextField getLanguageNameField_LangProf() {
        return languageNameField_LangProf;
    }

    public JTextField getProficiencyLevelField_LangProf() {
        return proficiencyLevelField_LangProf;
    }

    public void SearchByRegion(LanguageCatModel categorization) {
        setTitle("Search By Region");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Create components
        JLabel titleLabel = new JLabel("Select a Region or Enter a Region Name");
        regionComboBox_Region = new JComboBox<>(getAvailableRegions(categorization));
        searchButton_Region = new JButton("Search");
        resultTextArea_Region = new JTextArea(10, 30);
        resultTextArea_Region.setEditable(false); // Make the text area read-only

        // Create a panel for the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Create a panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Select a Region:"));
        inputPanel.add(regionComboBox_Region);
        inputPanel.add(new JLabel("Or Enter a Region Name:"));
        inputPanel.add(searchButton_Region);

        // Create a scroll pane for the result text area
        JScrollPane scrollPane = new JScrollPane(resultTextArea_Region);

        // Add components to the content panel
        contentPanel.add(titleLabel, BorderLayout.NORTH);
        contentPanel.add(inputPanel, BorderLayout.CENTER);
        contentPanel.add(scrollPane, BorderLayout.SOUTH);

        // Add content panel to the frame
        setContentPane(contentPanel);

        // Add an action listener to the search button
        searchButton_Region.addActionListener(e -> {
            String enteredRegion = (String) regionComboBox_Region.getSelectedItem();
            if (enteredRegion == null) {
                enteredRegion = "";
            }

            List<LanguageModel> result = categorization.getLanguagesByRegion(enteredRegion);

            // Display the result in the text area
            resultTextArea_Region.setText("Search Results:\n");
            if (result.size() == 0) {
                resultTextArea_Region.append("No matching languages found.");
            } else {
                for (LanguageModel language : result) {
                    resultTextArea_Region.append("Language Name: " + language.getName() + "\n");
                    resultTextArea_Region.append("Region: " + language.getRegion() + "\n");
                    resultTextArea_Region.append("\n");
                }
            }
        });

        setVisible(true);
    }

    private String[] getAvailableRegions(LanguageCatModel categorization) {
        ArrayList<String> regionList = new ArrayList<>();

        // Iterate through the available languages
        for (LanguageModel language : categorization.getAvailableLanguages()) {
            String region = language.getRegion();

            // Check if the region is not already in the list
            if (!regionList.contains(region)) {
                regionList.add(region);
            }
        }

        // Convert the ArrayList to an array of unique regions
        return regionList.toArray(new String[0]);
    }

    public JButton getSearchButton_Region() {
        return searchButton_Region;
    }

    public JComboBox getRegionComboBox_Region() {
        return regionComboBox_Region;
    }

    public JTextArea getResultTextArea_Region() {
        return resultTextArea_Region;
    }

    public void displayAddCourseMenu() {
        JFrame adminMenu = new JFrame("Admin Menu");
        adminMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminMenu.setSize(400, 300);
        adminMenu.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        // Create text fields
        languageField_AddCourse = new JTextField();
        nameField_AddCourse = new JTextField();
        courseDescriptionField = new JTextField();

        // Create labels for text fields
        inputPanel.add(new JLabel("Language:"));
        inputPanel.add(languageField_AddCourse);
        inputPanel.add(new JLabel("Course Name:"));
        inputPanel.add(nameField_AddCourse);
        inputPanel.add(new JLabel("Course Description:"));
        inputPanel.add(courseDescriptionField);

        // Create save button
        saveButtonAddCourse = new JButton("Save");

        inputPanel.add(saveButtonAddCourse);

        adminMenu.add(inputPanel, BorderLayout.CENTER);
        adminMenu.setVisible(true);
    }

    public JButton getSaveButtonAddCourse() {
        return saveButtonAddCourse;
    }

    public JTextField getCourseDescriptionField() {
        return courseDescriptionField;
    }

    public JTextField getLanguageField_AddCourse(){
        return languageField_AddCourse;
    }
    public JTextField getNameField_AddCourse() {
        return nameField_AddCourse;
    }
    public void displayFailMessage() {
        JOptionPane.showMessageDialog(this,
                "Course not added. Please create the language first, then try again",
                "Failed",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayRemovedMessage() {
        JOptionPane.showMessageDialog(this,
                "Successfully Removed!",
                "Removed",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayLogOutMessage() {
        JOptionPane.showMessageDialog(this,
                "You've successfully logged out!",
                "Logged Out",
                JOptionPane.INFORMATION_MESSAGE);
    }


    public void displayRemoveCourseMenu() {
        JFrame adminMenu = new JFrame("Admin Menu");
        adminMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminMenu.setSize(400, 300);
        adminMenu.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        // Create text fields
        languageField_AddCourse = new JTextField();
        nameField_AddCourse = new JTextField();

        // Create labels for text fields
        inputPanel.add(new JLabel("Language:"));
        inputPanel.add(languageField_AddCourse);
        inputPanel.add(new JLabel("Course Name:"));
        inputPanel.add(nameField_AddCourse);

        // Create remove button
        RemoveButtonRemoveCourse = new JButton("Remove");

        inputPanel.add(RemoveButtonRemoveCourse);

        adminMenu.add(inputPanel, BorderLayout.CENTER);
        adminMenu.setVisible(true);
    }

    public JButton getRemoveButtonRemoveCourse() {
        return RemoveButtonRemoveCourse;
    }

    public void displayRemoveLanguageMenu() {
        JFrame adminMenu = new JFrame("Admin Menu");
        adminMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminMenu.setSize(400, 300);
        adminMenu.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        // Create text fields
        languageField_AddCourse = new JTextField();

        // Create labels for text fields
        inputPanel.add(new JLabel("Language:"));
        inputPanel.add(languageField_AddCourse);

        // Create remove button
        RemoveButtonRemoveCourse = new JButton("Remove");

        inputPanel.add(RemoveButtonRemoveCourse);

        adminMenu.add(inputPanel, BorderLayout.CENTER);
        adminMenu.setVisible(true);
    }

    public void displayMaterialMenu() {
        setTitle("Material Menu");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        // Create text fields
        languageField_AddCourse = new JTextField();
        videoField = new JTextField();
        bookField = new JTextField();

        // Create labels for text fields
        inputPanel.add(new JLabel("Language:"));
        inputPanel.add(languageField_AddCourse);
        inputPanel.add(new JLabel("Video:"));
        inputPanel.add(videoField);
        inputPanel.add(new JLabel("Book:"));
        inputPanel.add(bookField);

        // Create save button
        saveLanguageButton = new JButton("Save");

        inputPanel.add(new JLabel()); // Empty label for spacing
        inputPanel.add(saveLanguageButton);

        add(inputPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public JTextField getBookField() {
        return bookField;
    }

    public JTextField getVideoField() {
        return videoField;
    }

    public void displayLearnerInformation(String name, String email, String username, List<String> enrolledCourses, List<String> favoriteCourses) {
        setTitle("Learner Information");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JLabel NameLabel = new JLabel("Name: " + name);
        JLabel emailLabel = new JLabel("Email: " + email);
        JLabel usernameLabel = new JLabel("Username: " + username);

        contentPanel.add(NameLabel);
        contentPanel.add(emailLabel);
        contentPanel.add(usernameLabel);

        JLabel enrolledCoursesLabel = new JLabel("Enrolled Courses:");
        contentPanel.add(enrolledCoursesLabel);

        for (String course : enrolledCourses) {
            JLabel courseLabel = new JLabel("- " + course);
            contentPanel.add(courseLabel);
        }

        JLabel favoriteCoursesLabel = new JLabel("Favorite Courses:");
        contentPanel.add(favoriteCoursesLabel);

        for (String course : favoriteCourses) {
            JLabel courseLabel = new JLabel("- " + course);
            contentPanel.add(courseLabel);
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        setContentPane(scrollPane);
        setVisible(true);
    }
    public void openSelectLearnerMenu(List<String> learnerEmails) {
        JFrame selectLearnerFrame = new JFrame("Select Learner");
        selectLearnerFrame.setSize(400, 300);
        selectLearnerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Select a Learner:");
        panel.add(titleLabel);

        for (String learnerEmail : learnerEmails) {
            JButton learnerButton = new JButton(learnerEmail);
            learnerButton.addActionListener(e -> {
                // Perform actions when a learner is selected
                // You can add more logic here
                System.out.println("Selected Learner: " + learnerEmail);
                LearnerController L = new LearnerController();
                L.retrieveCredentials(learnerEmail);
                displayLearnerInformation(L.getLearnerName(), L.getLearnerEmail(), L.getLearnerUsername(), L.getEnrollmentsByEmail(learnerEmail) , L.getFavoritesByEmail(learnerEmail));
               // selectLearnerFrame.dispose();  // Close the frame after selection
            });
            panel.add(learnerButton);
        }

        selectLearnerFrame.add(panel);
        selectLearnerFrame.setLocationRelativeTo(null);
        selectLearnerFrame.setVisible(true);
    }

}
