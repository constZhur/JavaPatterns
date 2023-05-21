package patterns.practicies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import patterns.practicies.service.UserService;

@Controller
public class MainPageController {
    private final UserService userService;

    @Autowired
    public MainPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String mainPage(Model model){
        model.addAttribute("user", userService.getCurrentUser());
        return "index";
    }

}
