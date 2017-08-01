package io.braxton.portfolio.interfaces;

import io.braxton.portfolio.models.Project;
import java.util.List;

public interface ProjectRepository {
    List<Project> findAll();
    void add(String title, String language, String description);
    void delete(long id);
}
