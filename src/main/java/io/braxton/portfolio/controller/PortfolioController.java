package io.braxton.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PortfolioController {


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
