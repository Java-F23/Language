import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PopularityOptionsPage extends JFrame {
        public PopularityOptionsPage(LanguageCategorization categorization) {
            setTitle("Popularity Options");
            setSize(600, 400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            // Create a panel for the options
            JPanel optionsPanel = new JPanel(new FlowLayout());

            // Create input fields for the range
            JTextField minPopularityField = new JTextField(5);
            JTextField maxPopularityField = new JTextField(5);

            // Create the "Search By Range" button
            JButton searchByRangeButton = new JButton("Search By Range");

            // Create a table to display the results
            DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Language", "Popularity"}, 0);
           // JTable resultTable = new JTable(tableModel);
            JTable resultTable = new JTable(tableModel) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            // Add action listener to the "Search By Range" button
            searchByRangeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle the "Search By Range" button click
                    try {
                        int minPopularity = Integer.parseInt(minPopularityField.getText());
                        int maxPopularity = Integer.parseInt(maxPopularityField.getText());

                        // Call the filterByPopularityRange method
                        Language[] filteredLanguages = categorization.filterByPopularityRange(minPopularity, maxPopularity);

                        // Display the results in the table
                        tableModel.setRowCount(0); // Clear existing table data
                        for (Language language : filteredLanguages) {
                            tableModel.addRow(new Object[]{language.getName(), language.getPopularity()});
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter valid popularity values.");
                    }
                }
            });

            resultTable.setEnabled(false);

            // Add input fields, the "Search By Range" button, and result table to the options panel
            optionsPanel.add(new JLabel("Min Popularity: "));
            optionsPanel.add(minPopularityField);
            optionsPanel.add(new JLabel("Max Popularity: "));
            optionsPanel.add(maxPopularityField);
            optionsPanel.add(searchByRangeButton);
            optionsPanel.add(new JScrollPane(resultTable));

            setContentPane(optionsPanel);
        }
    }
