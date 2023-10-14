import java.util.ArrayList;

public class LanguageCategorization {
    private static final int MAX_LANGUAGES = 100; // Maximum number of languages (adjust as needed)
    private Language[] availableLanguages;
    private int languageCount;

    public LanguageCategorization() {
        availableLanguages = new Language[MAX_LANGUAGES];
        languageCount = 0;
    }

    public int GetCount()
    {
        return languageCount;
    }

    // Method to add a language to the categorization
    public void addLanguage(Language language) {
        if (languageCount < MAX_LANGUAGES) {
            availableLanguages[languageCount] = language;
            languageCount++;
        }
    }

    // Method to get all available languages
    public Language[] getAvailableLanguages() {
        Language[] result = new Language[languageCount];
        System.arraycopy(availableLanguages, 0, result, 0, languageCount);
        return result;
    }

    // Method to display languages with descriptions
    public void displayLanguagesWithDescriptions() {
        for (int i = 0; i < languageCount; i++) {
            Language language = availableLanguages[i];
            System.out.println("Language: " + language.getName());
            System.out.println("Description: " + language.getDescription());
            System.out.println();
        }
    }

    // Filter languages by region
    public Language[] filterByRegion(String region) {
        Language[] filteredLanguages = new Language[MAX_LANGUAGES];
        int filteredCount = 0;

        for (int i = 0; i < languageCount; i++) {
            Language language = availableLanguages[i];
            if (region == null || language.getRegion().equals(region)) {
                filteredLanguages[filteredCount] = language;
                filteredCount++;
            }
        }

        Language[] result = new Language[filteredCount];
        System.arraycopy(filteredLanguages, 0, result, 0, filteredCount);
        return result;
    }

    // Filter languages by proficiency levels
    public Language[] filterByProficiencyLevels(ArrayList<String> proficiencyLevels) {
        Language[] filteredLanguages = new Language[MAX_LANGUAGES];
        int filteredCount = 0;

        for (int i = 0; i < languageCount; i++) {
            Language language = availableLanguages[i];
            if (proficiencyLevels == null || proficiencyLevels.isEmpty() || language.getProficiencyLevels().containsAll(proficiencyLevels)) {
                filteredLanguages[filteredCount] = language;
                filteredCount++;
            }
        }

        Language[] result = new Language[filteredCount];
        System.arraycopy(filteredLanguages, 0, result, 0, filteredCount);
        return result;
    }

    // Filter languages by popularity range
    public Language[] filterByPopularityRange(int minPopularity, int maxPopularity) {
        Language[] filteredLanguages = new Language[MAX_LANGUAGES];
        int filteredCount = 0;

        for (int i = 0; i < languageCount; i++) {
            Language language = availableLanguages[i];
            if (language.getPopularity() >= minPopularity && language.getPopularity() <= maxPopularity) {
                filteredLanguages[filteredCount] = language;
                filteredCount++;
            }
        }

        Language[] result = new Language[filteredCount];
        System.arraycopy(filteredLanguages, 0, result, 0, filteredCount);
        return result;
    }

    // Display language name, proficiency levels, and descriptions
    public void displayLanguageProficiencyDescriptions(String languageName) {
        for (int i = 0; i < languageCount; i++) {
            if (availableLanguages[i].getName().equals(languageName)) {
                Language language = availableLanguages[i];
                System.out.println("Language: " + language.getName());
                System.out.println("Proficiency Levels and Descriptions:");
                for (String proficiencyLevel : language.getProficiencyLevels()) {
                    String description = language.getProficiencyLevelDescription(proficiencyLevel);
                    System.out.println("- Proficiency Level: " + proficiencyLevel);
                    System.out.println("  Description: " + description);
                }
                System.out.println();
                return; // Exit once the language is found
            }
        }
        System.out.println("Language not found: " + languageName);
    }

    public Language[] getLanguagesByRegion(String region) {
        Language[] filteredLanguages = new Language[MAX_LANGUAGES];
        int filteredCount = 0;

        for (int i = 0; i < languageCount; i++) {
            Language language = availableLanguages[i];
            if (region == null || language.getRegion().equals(region)) {
                filteredLanguages[filteredCount] = language;
                filteredCount++;
            }
        }

        Language[] result = new Language[filteredCount];
        System.arraycopy(filteredLanguages, 0, result, 0, filteredCount);
        return result;
    }

    public ArrayList<Language> filterByLanguage(String languageName) {
        ArrayList<Language> filteredLanguages = new ArrayList<>();
        for (Language language : availableLanguages) {
            if (language.getName().equalsIgnoreCase(languageName)) {
                filteredLanguages.add(language);
            }
        }
        return filteredLanguages;
    }

    public ArrayList<Language> filterByLanguageAndProficiency(String languageName, String proficiencyLevel) {
        ArrayList<Language> filteredLanguages = new ArrayList<>();
        for (Language language : availableLanguages) {
            if (language.getName().equalsIgnoreCase(languageName)) {
                if (language.getProficiencyLevels().contains(proficiencyLevel)) {
                    filteredLanguages.add(language);
                }
            }
        }
        return filteredLanguages;
    }

}
