package io.braxton.portfolio.models;

public class Project {
    private long id;
    private String title;
    private String language;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project(long id, String title, String language, String description) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.description = description;
    }
}

