import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Map;
public class LanguageController {
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

    public boolean updateLanguageCourseDescription(String languageName, String courseName, String courseDescription, String filePath) {
        ArrayList<String> langNames = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("temp.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(languageName)) {
                    langNames.add(languageName);
                    // Found the language, update or add the course description
                    StringBuilder updatedLine = new StringBuilder();
                    updatedLine.append(languageName).append(",");
                    for (int i = 1; i < parts.length; i++) {
                        String[] profLevel = parts[i].split(":");
                        if (profLevel.length == 2 && profLevel[0].equals(courseName)) {
                            // Update the existing course description
                            updatedLine.append(courseName).append(":").append(courseDescription).append(",");
                        } else {
                            updatedLine.append(parts[i]).append(",");
                        }
                    }

                    // If the course doesn't exist, add it
                    if (!containsCourse(parts, courseName)) {
                        updatedLine.append(courseName).append(":").append(courseDescription).append(",");
                    }

                    writer.write(updatedLine.toString());
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
            return false;
        }
        if(!langNames.contains(languageName))
            return false;
        // Replace the original file with the temporary file
        replaceFile("temp.csv", filePath);
        return true;
    }

    private boolean containsCourse(String[] parts, String courseName) {
        for (String part : parts) {
            String[] profLevel = part.split(":");
            if (profLevel.length == 2 && profLevel[0].equals(courseName)) {
                return true;
            }
        }
        return false;
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

    public boolean removeLanguageCourse(String languageName, String courseName, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("temp.csv"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(languageName)) {
                    // Found the language, remove the specified course and its description
                    StringBuilder updatedLine = new StringBuilder();
                    updatedLine.append(languageName).append(",");
                    for (int i = 1; i < parts.length; i++) {
                        String[] profLevel = parts[i].split(":");
                        if (profLevel.length == 2 && profLevel[0].equals(courseName)) {
                            // Skip the course and its description
                        } else {
                            updatedLine.append(parts[i]).append(",");
                        }
                    }

                    writer.write(updatedLine.toString());
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
            return false;
        }

        // Replace the original file with the temporary file
        replaceFile("temp.csv", filePath);
        return true;
    }

    public boolean removeLanguage(String languageName, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("temp.csv"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(languageName)) {
                    // Skip the line (language) to be removed
                } else {
                    // Copy the existing line to the temporary file
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
            return false;
        }

        // Replace the original file with the temporary file
        replaceFile("temp.csv", filePath);
        return true;
    }

    public boolean addVideoLink(String languageName, String videoLink, String videosFilePath, String languagesFilePath) {
        if (!languageExistsInFile(languageName, new File(languagesFilePath))) {
            // Language doesn't exist in the Languages file
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(videosFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("tempVideos.csv"))) {

            boolean languageFound = false;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(languageName)) {
                    // Append the new video link to the existing line
                    writer.write(line + "," + videoLink);
                    writer.newLine();
                    languageFound = true;
                } else {
                    // Copy the existing line to the temporary file
                    writer.write(line);
                    writer.newLine();
                }
            }

            // If the language was not found in the videos file, add a new entry
            if (!languageFound) {
                writer.write(languageName + "," + videoLink);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
            return false;
        }

        // Replace the original videos file with the temporary file
        replaceFile("tempVideos.csv", videosFilePath);

        return true;
    }

    public boolean addBookTitle(String languageName, String title, String booksFilePath, String languagesFilePath) {
        if (!languageExistsInFile(languageName, new File(languagesFilePath))) {
            // Language doesn't exist in the Languages file
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(booksFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("tempBooks.csv"))) {

            boolean languageFound = false;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(languageName)) {
                    // Append the new video link to the existing line
                    writer.write(line + "," + title);
                    writer.newLine();
                    languageFound = true;
                } else {
                    // Copy the existing line to the temporary file
                    writer.write(line);
                    writer.newLine();
                }
            }

            // If the language was not found in the videos file, add a new entry
            if (!languageFound) {
                writer.write(languageName + "," + title);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log an error message or show an alert)
            return false;
        }

        // Replace the original videos file with the temporary file
        replaceFile("tempBooks.csv", booksFilePath);

        return true;
    }
}
