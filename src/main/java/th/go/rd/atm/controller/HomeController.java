package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String getHomePage() {
        //return home.html
        return "home";
    }

    @RequestMapping("/calarea")
    public String showArea(Model model) {
        double result, width, height;
        width = 5;
        height = 10;
        result = width * height;
        model.addAttribute("result",result);
        return "calarea";
    }
}

