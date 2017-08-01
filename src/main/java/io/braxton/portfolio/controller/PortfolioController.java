package io.braxton.portfolio.controller;

import io.braxton.portfolio.models.Project;
import io.braxton.portfolio.repository.ProjectRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PortfolioController {


    @Autowired
    private ProjectRepositoryImpl repo;

    @RequestMapping("/admin")
    public String admin(Model model){ //add <---model model alt enter and stuff
        List<Project> allProjects = repo.findAll();
        model.addAttribute("projects", allProjects);
        return "admin";
    }

    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public String createProject(@RequestParam("title") String title,
                              @RequestParam("language") String language,
                              @RequestParam("description") String description) {
        repo.add(title, language , description);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deleteProject", method = RequestMethod.POST)
    public String deleteProject(@RequestParam("id") long id){
        repo.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/contact")
    public String contact(Model model) {
        return "contact";
    }

    @RequestMapping("/blog")
    public String blog(Model model) {
        return "blog";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        return "about";
    }
}
