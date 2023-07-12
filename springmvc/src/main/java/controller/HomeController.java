package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {

    @RequestMapping("/home")
    public String Home(Model model){
        System.out.println("Home URL");
        model.addAttribute("Name", "Rohit Shahi");
        model.addAttribute("id", 1234);
        return "index";
    }

    @RequestMapping("/about")
    public String About(){
        System.out.println("Home URL");
        return "about";
    }

    @RequestMapping("/help")
    public ModelAndView Help(){
        System.out.println("Home URL");
        ModelAndView mnv = new ModelAndView();
        mnv.addObject("Name", "Rohit Shahi");
        mnv.addObject("id", 1234);

        mnv.setViewName("help");

        return mnv;
    }
    
}
