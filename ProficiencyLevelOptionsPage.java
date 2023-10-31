/*import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProficiencyLevelOptionsPage extends JFrame {
    private ArrayList<JCheckBox> proficiencyLevelCheckboxes = new ArrayList<>();

    public ProficiencyLevelOptionsPage(LanguageCategorization categorization, ArrayList<String> proficiencyLevels) {
        setTitle("Search By Proficiency Level");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel for the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Create a table to display the results (set it as non-editable)
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Language", "Description"}, 0);
        JTable resultTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Add checkboxes for proficiency levels
        JPanel proficiencyLevelsPanel = new JPanel(new GridLayout(0, 1));
        for (String proficiencyLevel : proficiencyLevels) {
            JCheckBox checkBox = new JCheckBox(proficiencyLevel);
            proficiencyLevelsPanel.add(checkBox);
            proficiencyLevelCheckboxes.add(checkBox);
        }

        // Create the "Search By Proficiency Level" button
        JButton searchByProficiencyButton = new JButton("Search By Proficiency Level");

        // Add action listener to the "Search By Proficiency Level" button
        searchByProficiencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the "Search By Proficiency Level" button click
                ArrayList<String> selectedProficiencyLevels = new ArrayList<>();
                for (JCheckBox checkBox : proficiencyLevelCheckboxes) {
                    if (checkBox.isSelected()) {
                        selectedProficiencyLevels.add(checkBox.getText());
                    }
                }

                // Call the filterByProficiencyLevels method
                Language[] filteredLanguages = categorization.filterByProficiencyLevels(selectedProficiencyLevels);

                // Display the results in the table
                tableModel.setRowCount(0); // Clear existing table data
                for (Language language : filteredLanguages) {
                    tableModel.addRow(new Object[]{language.getName(), language.getDescription()});
                }
            }
        });

        // Set the table as non-editable
        resultTable.setEnabled(false);

        // Add input fields, the "Search By Proficiency Level" button, and result table to the content panel
        contentPanel.add(new JLabel("Select Proficiency Levels: "), BorderLayout.NORTH);
        contentPanel.add(proficiencyLevelsPanel, BorderLayout.CENTER);
        contentPanel.add(searchByProficiencyButton, BorderLayout.CENTER);
        contentPanel.add(new JScrollPane(resultTable), BorderLayout.SOUTH);

        setContentPane(contentPanel);
    }
}*/
/*
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProficiencyLevelOptionsPage extends JFrame {
    private JTextField proficiencyLevelsInput;

    public ProficiencyLevelOptionsPage(LanguageCategorization categorization) {
        setTitle("Search By Proficiency Level");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel for the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Create a table to display the results (set it as non-editable)
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Language", "Description"}, 0);
        JTable resultTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Create a text field for entering proficiency levels
        proficiencyLevelsInput = new JTextField();
        contentPanel.add(proficiencyLevelsInput, BorderLayout.NORTH);

        // Create the "Search By Proficiency Level" button
        JButton searchByProficiencyButton = new JButton("Search By Proficiency Level");

        // Add action listener to the "Search By Proficiency Level" button
        searchByProficiencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the "Search By Proficiency Level" button click
                String input = proficiencyLevelsInput.getText();
                String[] proficiencyLevels = input.split(","); // Split by comma or another delimiter

                // Call the filterByProficiencyLevels method
                Language[] filteredLanguages = categorization.filterByProficiencyLevels(proficiencyLevels);

                // Display the results in the table
                tableModel.setRowCount(0); // Clear existing table data
                for (Language language : filteredLanguages) {
                    tableModel.addRow(new Object[]{language.getName(), language.getDescription()});
                }
            }
        });

        // Set the table as non-editable
        resultTable.setEnabled(false);

        // Add input field, the "Search By Proficiency Level" button, and result table to the content panel
        contentPanel.add(searchByProficiencyButton, BorderLayout.CENTER);
        contentPanel.add(new JScrollPane(resultTable), BorderLayout.SOUTH);

        setContentPane(contentPanel);
    }
}
*/
/*
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProficiencyLevelOptionsPage extends JFrame {
    public ProficiencyLevelOptionsPage(LanguageCategorization categorization) {
        setTitle("Proficiency Level Options");
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel("Enter Proficiency Levels (comma-separated):");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(label, constraints);

        JTextField textField = new JTextField(20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(textField, constraints);
        //ByValue
        JButton searchButton = new JButton("Search"); //By Value");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(searchButton, constraints);
//ByValue
        JButton searchByRangeButton = new JButton("Search By Range");
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(searchByRangeButton, constraints);
        //ByValue
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                ArrayList<String> proficiencyLevels = new ArrayList<String>();
                proficiencyLevels.add(input);

                Language[] filteredLanguages = categorization.filterByProficiencyLevels(proficiencyLevels);

                if (filteredLanguages.length == 0) {
                    JOptionPane.showMessageDialog(null, "No languages found for the specified proficiency level.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Display the result in a tabular form on a different page
                    // ProficiencyLevelSearchResultPage resultPage = new ProficiencyLevelSearchResultPage(filteredLanguages);
                    //resultPage.setVisible(true);
                    DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Language", "Popularity"}, 0);
                    JTable resultTable = new JTable(tableModel) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };

                    ArrayList<TextObject> lang = new ArrayList<>();
                    Font font = new Font("Arial", Font.BOLD, 20);
                    constraints.gridy = 3;
                    int i=4;

                    for(Language language : filteredLanguages){
                        TextObject l = new TextObject(language.getName(), font, Color.BLACK, 35);
                        for(String prof : language.getProficiencyLevels()) {
                            TextObject P = new TextObject(prof, font, Color.BLACK, 20);
                            panel.add(P.createLabel());
                            constraints.gridy = i;
                        }
                        panel.add(l.createLabel(), constraints);
                        constraints.gridy = i;
                        i++;
                    }
                    tableModel.setRowCount(0); // Clear existing table data
                    for (Language language : filteredLanguages) {
                        tableModel.addRow(new Object[]{language.getName(), language.getPopularity()});
                    }//
                }
            }
        });
//why range??
        searchByRangeButton.addActionListener(new ActionListener() {//
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                ArrayList<String> proficiencyLevels = new ArrayList<String>();
                String[] levelsArray = input.split(",");

                for (String level : levelsArray) {
                    proficiencyLevels.add(level.trim());
                }

                Language[] filteredLanguages = categorization.filterByProficiencyLevels(proficiencyLevels);

                if (filteredLanguages.length == 0) {
                    JOptionPane.showMessageDialog(null, "No languages found for the specified proficiency levels.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Display the result in a tabular form on a different page
                   // ProficiencyLevelSearchResultPage resultPage = new ProficiencyLevelSearchResultPage(filteredLanguages);
                    //resultPage.setVisible(true);
                }
            }
        });

        setContentPane(panel);
    }
}
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProficiencyLevelOptionsPage extends JFrame {
    public ProficiencyLevelOptionsPage(LanguageCategorization categorization) {
        setTitle("Proficiency Level Options");
        setSize(600, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel("Enter Proficiency Levels (comma-separated):");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(label, constraints);

        /*
        JTextField textField = new JTextField(20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(textField, constraints);
*/
        JTextField textField = new JTextField(20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(textField, constraints);

        JButton searchByValueButton = new JButton("Search By Value");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(searchByValueButton, constraints);

        /*JButton searchByRangeButton = new JButton("Search By Range");
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(searchByRangeButton, constraints);*/

        JTextArea resultTextArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 5; //2
        panel.add(scrollPane, constraints);

        searchByValueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                ArrayList<String> proficiencyLevels = new ArrayList<String>();
                proficiencyLevels.add(input);

                Language[] filteredLanguages = categorization.filterByProficiencyLevels(proficiencyLevels);

                if (filteredLanguages.length == 0) {
                    resultTextArea.setText("No languages found for the specified proficiency level.");
                } else {
                    StringBuilder resultText = new StringBuilder("Filtered Languages:\n");
                    for (Language language : filteredLanguages) {
                        resultText.append(language.getName()).append(" - ").append(language.getDescription()).append("\n");
                    }
                    resultTextArea.setText(resultText.toString());
                }
            }
        });

      /*  searchByRangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                ArrayList<String> proficiencyLevels = new ArrayList<String>();
                String[] levelsArray = input.split(",");

                for (String level : levelsArray) {
                    proficiencyLevels.add(level.trim());
                }

                Language[] filteredLanguages = categorization.filterByProficiencyLevels(proficiencyLevels);

                if (filteredLanguages.length == 0) {
                    resultTextArea.setText("No languages found for the specified proficiency levels.");
                } else {
                    StringBuilder resultText = new StringBuilder("Filtered Languages:\n");
                    for (Language language : filteredLanguages) {
                        resultText.append(language.getName()).append(" - ").append(language.getDescription()).append("\n");
                    }
                    resultTextArea.setText(resultText.toString());
                }
            }
        });*/

        setContentPane(panel);
    }
}
