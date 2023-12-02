import java.util.ArrayList;

public class LanguageCatController {
    private static final int MAX_LANGUAGES = 100; // Maximum number of languages (adjust as needed)
    private LanguageModel[] availableLanguages;
    private int languageCount;
    public LanguageCatController() {
        availableLanguages = new LanguageModel[MAX_LANGUAGES];
        languageCount = 0;
    }

    public LanguageModel[] filterByPopularityRange(int minPopularity, int maxPopularity) {
        LanguageModel[] filteredLanguages = new LanguageModel[MAX_LANGUAGES];
        int filteredCount = 0;

        for (int i = 0; i < languageCount; i++) {
            LanguageModel language = availableLanguages[i];
            if (language.getPopularity() >= minPopularity && language.getPopularity() <= maxPopularity) {
                filteredLanguages[filteredCount] = language;
                filteredCount++;
            }
        }
        LanguageModel[] result = new LanguageModel[filteredCount];
        System.arraycopy(filteredLanguages, 0, result, 0, filteredCount);
        return result;
    }

    public int GetCount()
    {
        return languageCount;
    }

    // Method to add a language to the categorization
    public void addLanguage(LanguageModel language) {
        if (languageCount < MAX_LANGUAGES) {
            availableLanguages[languageCount] = language;
            languageCount++;
        }
    }

    public void removeLanguage(LanguageModel language)
    {
        LanguageModel[] arr_new = new LanguageModel[availableLanguages.length-1];
        int i = 0;
        for(LanguageModel l : availableLanguages)
        {
            if(l != language)
                arr_new[i] = l;
            i++;
        }
        availableLanguages = arr_new;
    }

    // Method to get all available languages
    public LanguageModel[] getAvailableLanguages() {
        LanguageModel[] result = new LanguageModel[languageCount];
        System.arraycopy(availableLanguages, 0, result, 0, languageCount);
        return result;
    }

    // Method to display languages with descriptions
    public void displayLanguagesWithDescriptions() {
        for (int i = 0; i < languageCount; i++) {
            LanguageModel language = availableLanguages[i];
            System.out.println("Language: " + language.getName());
            System.out.println("Description: " + language.getDescription());
            System.out.println();
        }
    }

    // Filter languages by region
    public LanguageModel[] filterByRegion(String region) {
        LanguageModel[] filteredLanguages = new LanguageModel[MAX_LANGUAGES];
        int filteredCount = 0;

        for (int i = 0; i < languageCount; i++) {
            LanguageModel language = availableLanguages[i];
            if (region == null || language.getRegion().equals(region)) {
                filteredLanguages[filteredCount] = language;
                filteredCount++;
            }
        }

        LanguageModel[] result = new LanguageModel[filteredCount];
        System.arraycopy(filteredLanguages, 0, result, 0, filteredCount);
        return result;
    }

    // Filter languages by proficiency levels
    public LanguageModel[] filterByProficiencyLevels(ArrayList<String> proficiencyLevels) {
        LanguageModel[] filteredLanguages = new LanguageModel[MAX_LANGUAGES];
        int filteredCount = 0;

        for (int i = 0; i < languageCount; i++) {
            LanguageModel language = availableLanguages[i];
            if (proficiencyLevels == null || proficiencyLevels.isEmpty() || language.getProficiencyLevels().containsAll(proficiencyLevels)) {
                filteredLanguages[filteredCount] = language;
                filteredCount++;
            }
        }

        LanguageModel[] result = new LanguageModel[filteredCount];
        System.arraycopy(filteredLanguages, 0, result, 0, filteredCount);
        return result;
    }

    public LanguageModel[] getLanguagesByRegion(String region) {
        LanguageModel[] filteredLanguages = new LanguageModel[MAX_LANGUAGES];
        int filteredCount = 0;

        for (int i = 0; i < languageCount; i++) {
            LanguageModel language = availableLanguages[i];
            if (region == null || language.getRegion().equals(region)) {
                filteredLanguages[filteredCount] = language;
                filteredCount++;
            }
        }

        LanguageModel[] result = new LanguageModel[filteredCount];
        System.arraycopy(filteredLanguages, 0, result, 0, filteredCount);
        return result;
    }

    public LanguageModel[] filterByLanguage(String languageName) {
        LanguageModel[] filteredLanguages = new LanguageModel[MAX_LANGUAGES];
        int filteredCount = 0;

        for (int i = 0; i < languageCount; i++) {
            LanguageModel language = availableLanguages[i];
            if (languageName != null && language.getName().equalsIgnoreCase(languageName)) {
                filteredLanguages[filteredCount] = language;
                filteredCount++;
            }
        }

        LanguageModel[] result = new LanguageModel[filteredCount];
        System.arraycopy(filteredLanguages, 0, result, 0, filteredCount);
        return result;
    }

    public LanguageModel[] filterByLanguageAndProficiency(String languageName, String proficiencyLevel) {
        LanguageModel[] filteredLanguages = new LanguageModel[MAX_LANGUAGES];
        int filteredCount = 0;

        for (int i = 0; i < languageCount; i++) {
            LanguageModel language = availableLanguages[i];
            if (languageName != null && language.getName().equalsIgnoreCase(languageName) &&
                    proficiencyLevel != null && language.getProficiencyLevels().contains(proficiencyLevel)) {
                filteredLanguages[filteredCount] = language;
                filteredCount++;
            }
        }

        LanguageModel[] result = new LanguageModel[filteredCount];
        System.arraycopy(filteredLanguages, 0, result, 0, filteredCount);
        return result;
    }

}
