import java.util.ArrayList;
import java.util.List;

public class LanguageCatModel { //LanguageCategorization Model
    private static final int MAX_LANGUAGES = 100; // Maximum number of languages (adjust as needed)
    private List<LanguageModel> availableLanguages;

    public LanguageCatModel() {
        availableLanguages = new ArrayList<>();
    }

    public int getLanguageCount() {
        return availableLanguages.size();
    }

    // Method to add a language to the categorization
    public void addLanguage(LanguageModel language) {
        if (availableLanguages.size() < MAX_LANGUAGES) {
            availableLanguages.add(language);
        }
    }

    public void removeLanguage(LanguageModel language) {
        availableLanguages.remove(language);
    }

    // Method to get all available languages
    public List<LanguageModel> getAvailableLanguages() {
        return new ArrayList<>(availableLanguages);
    }

    // Method to display languages with descriptions
    public void displayLanguagesWithDescriptions() {
        for (LanguageModel language : availableLanguages) {
            System.out.println("Language: " + language.getName());
            System.out.println("Description: " + language.getDescription());
            System.out.println();
        }
    }

    // Filter languages by region
    public List<LanguageModel> filterByRegion(String region) {
        List<LanguageModel> filteredLanguages = new ArrayList<>();

        for (LanguageModel language : availableLanguages) {
            if (region == null || language.getRegion().equalsIgnoreCase(region)) {
                filteredLanguages.add(language);
            }
        }

        return filteredLanguages;
    }

    // Filter languages by proficiency levels
    public List<LanguageModel> filterByProficiencyLevels(List<String> proficiencyLevels) {
        List<LanguageModel> filteredLanguages = new ArrayList<>();

        for (LanguageModel language : availableLanguages) {
            if (proficiencyLevels == null || proficiencyLevels.isEmpty() || language.getProficiencyLevels().containsAll(proficiencyLevels)) {
                filteredLanguages.add(language);
            }
        }

        return filteredLanguages;
    }

    // Filter languages by popularity range
    public List<LanguageModel> filterByPopularityRange(int minPopularity, int maxPopularity) {
        List<LanguageModel> filteredLanguages = new ArrayList<>();

        for (LanguageModel language : availableLanguages) {
            if (language.getPopularity() >= minPopularity && language.getPopularity() <= maxPopularity) {
                filteredLanguages.add(language);
            }
        }

        return filteredLanguages;
    }

    public List<LanguageModel> getLanguagesByRegion(String region) {
        List<LanguageModel> filteredLanguages = new ArrayList<>();

        for (LanguageModel language : availableLanguages) {
            if (region == null || language.getRegion().equalsIgnoreCase(region)) {
                filteredLanguages.add(language);
            }
        }

        return filteredLanguages;
    }

    public List<LanguageModel> filterByLanguage(String languageName) {
        List<LanguageModel> filteredLanguages = new ArrayList<>();

        for (LanguageModel language : availableLanguages) {
            if (languageName != null && language.getName().equalsIgnoreCase(languageName)) {
                filteredLanguages.add(language);
            }
        }

        return filteredLanguages;
    }

    public List<LanguageModel> filterByLanguageAndProficiency(String languageName, String proficiencyLevel) {
        List<LanguageModel> filteredLanguages = new ArrayList<>();

        for (LanguageModel language : availableLanguages) {
            if (languageName != null && language.getName().equalsIgnoreCase(languageName) &&
                    proficiencyLevel != null && language.getProficiencyLevels().contains(proficiencyLevel)) {
                filteredLanguages.add(language);
            }
        }

        return filteredLanguages;
    }
}
