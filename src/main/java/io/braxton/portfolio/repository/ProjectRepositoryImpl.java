package io.braxton.portfolio.repository;

import io.braxton.portfolio.interfaces.ProjectRepository;
import io.braxton.portfolio.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Project> findAll() {
        return jdbcTemplate.query("SELECT * FROM project", new ProjectMapper());
    }

    @Override
    public void add(String title, String language, String description) {
        jdbcTemplate.update("INSERT INTO project (title, language, description) VALUES(?,?,?)", title, language, description);
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM project WHERE id = ?", id);
    }


    private static class ProjectMapper implements RowMapper<Project> {
        @Override
        public Project mapRow(ResultSet resultSet, int i) throws SQLException {
            Project project = new Project
                    (resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("language"),
                    resultSet.getString("description"));
            return project;
        }
    }
}
