import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
public class LanguageController {
//stopped here. Trying to implement the popularity function, must retrieve list of languages first, place in
    //categorization, then continue. Test if retreiveLanguages method works or not
    //Passes an array list of all languages saved in file
/*public ArrayList<LanguageModel> retrieveLanguages() {
    ArrayList<LanguageModel> languages = new ArrayList<>();
    File file = new File("Languages.csv");

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 4) {
                LanguageModel Lang = new LanguageModel(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
                languages.add(Lang);
            } else {
                // Handle the case where the line doesn't have enough elements
                System.out.println("Invalid line in the CSV file: " + line);
            }
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
    return languages;
}
*/
public ArrayList<LanguageModel> retrieveLanguages() {
    ArrayList<LanguageModel> languages = new ArrayList<>();
    File file = new File("Languages.csv");

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length > 3) { //was 0
                // Extract information from CSV line
                String name = parts[0];
                String region = parts[1];
                String description = parts[2];
                int popularity = Integer.parseInt(parts[3]);

                // Create LanguageModel object
                LanguageModel language = new LanguageModel(name, region, description, popularity);

                // Process proficiency levels if available
                if (parts.length > 4) {
                    for (int i = 4; i < parts.length; i++) {
                        String[] proficiencyParts = parts[i].split(":");
                        if (proficiencyParts.length == 2) {
                            String proficiencyKey = proficiencyParts[0];
                            String proficiencyValue = proficiencyParts[1];
                            language.addProficiencyLevel(proficiencyKey, proficiencyValue);
                        }
                    }
                }

                // Add the LanguageModel to the list
                languages.add(language);
            }
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace(); // Handle exceptions appropriately in your application
    }
    return languages;
}

    public LanguageModel createLanguageFromFields(JPanel panel, JTextField nameField, JTextField regionField,
                                                  JTextField descriptionField, JTextField popularityField,
                                                  Map<String, JTextField> proficiencyLevelFields) {
        int result = JOptionPane.showConfirmDialog(null, panel, "Create Language",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String region = regionField.getText();
            String description = descriptionField.getText();
            int popularity = Integer.parseInt(popularityField.getText());

            LanguageModel language = new LanguageModel(name, region, description, popularity);

            // Add proficiency levels
            for (Map.Entry<String, JTextField> entry : proficiencyLevelFields.entrySet()) {
                String proficiencyLevel = entry.getKey();
                String proficiencyDescription = entry.getValue().getText();
                language.addProficiencyLevel(proficiencyLevel, proficiencyDescription);
            }

            return language;
        }

        return null;
    }

    public void saveLanguageToFile(LanguageModel language) {
        File file = new File("Languages.csv");

        // Check if the language already exists in the CSV file
        if (!languageExistsInFile(language.getName(), file)) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
                // Append the language information to the CSV file
                writer.println(languageToCsvString(language));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Language already exists in the file: " + language.getName());
        }
    }

    private boolean languageExistsInFile(String languageName, File file) {
        // Check if the file exists; if not, create it
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception as needed
                return false;
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(languageName)) {
                    return true; // Language already exists in the file
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
        return false;
    }

    private String languageToCsvString(LanguageModel language) {
        // Create a CSV representation of the language
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append(language.getName()).append(",");
        csvBuilder.append(language.getRegion()).append(",");
        csvBuilder.append(language.getDescription()).append(",");
        csvBuilder.append(language.getPopularity()).append(",");

        // Add proficiency levels
        for (Map.Entry<String, String> entry : language.getProficiencyLevelDescriptions().entrySet()) {
            csvBuilder.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
        }

        // Add a newline character at the end
        csvBuilder.append("\n");

        return csvBuilder.toString();
    }


}
