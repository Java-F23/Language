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

    public void removeLanguage(Language language)
    {
        Language[] arr_new = new Language[availableLanguages.length-1];
        int i = 0;
        for(Language l : availableLanguages)
        {
            if(l != language)
                arr_new[i] = l;
            i++;
        }
        availableLanguages = arr_new;
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

    public Language[] filterByLanguage(String languageName) {
        Language[] filteredLanguages = new Language[MAX_LANGUAGES];
        int filteredCount = 0;

        for (int i = 0; i < languageCount; i++) {
            Language language = availableLanguages[i];
            if (languageName != null && language.getName().equalsIgnoreCase(languageName)) {
                filteredLanguages[filteredCount] = language;
                filteredCount++;
            }
        }

        Language[] result = new Language[filteredCount];
        System.arraycopy(filteredLanguages, 0, result, 0, filteredCount);
        return result;
    }

    public Language[] filterByLanguageAndProficiency(String languageName, String proficiencyLevel) {
        Language[] filteredLanguages = new Language[MAX_LANGUAGES];
        int filteredCount = 0;

        for (int i = 0; i < languageCount; i++) {
            Language language = availableLanguages[i];
            if (languageName != null && language.getName().equalsIgnoreCase(languageName) &&
                    proficiencyLevel != null && language.getProficiencyLevels().contains(proficiencyLevel)) {
                filteredLanguages[filteredCount] = language;
                filteredCount++;
            }
        }

        Language[] result = new Language[filteredCount];
        System.arraycopy(filteredLanguages, 0, result, 0, filteredCount);
        return result;
    }
}
