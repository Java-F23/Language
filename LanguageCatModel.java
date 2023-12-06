import java.util.ArrayList;
import java.util.List;

public class LanguageCatModel { //LanguageCategorization Model
    private List<LanguageModel> availableLanguages;

    public LanguageCatModel() {
        availableLanguages = new ArrayList<>();
    }

    // Method to get all available languages
    public List<LanguageModel> getAvailableLanguages() {
        return new ArrayList<>(availableLanguages);
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

    public void setAvailableLanguages(List<LanguageModel> L){
        availableLanguages = L;
    }

}
