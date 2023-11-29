import java.util.ArrayList;
import java.util.List;

public class CourseModel {
    private String name;
    private String proficiencyLevel;
    private List<String> books;
    private List<String> videos;
    private List<String> exercises;

    public CourseModel(String name, String proficiencyLevel) {
        this.name = name;
        this.proficiencyLevel = proficiencyLevel;
        this.books = new ArrayList<>();
        this.videos = new ArrayList<>();
        this.exercises = new ArrayList<>();
    }

    public void addBook(String book) {
        books.add(book);
    }

    public void addVideo(String video) {
        videos.add(video);
    }

    public void addExercise(String exercise) {
        exercises.add(exercise);
    }

    public List<String> getBooks() {
        return books;
    }

    public List<String> getVideos() {
        return videos;
    }

    public List<String> getExercises() {
        return exercises;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public String getProficiencyLevelDesc(String proficiencyLevel, LanguageModel lang) {
        return lang.getProficiencyLevelDescription(proficiencyLevel);
    }
}
