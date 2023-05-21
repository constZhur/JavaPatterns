package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {
    @GetMapping("/home")
    public String printStudentInfo(){
        return "home";
    }
}
