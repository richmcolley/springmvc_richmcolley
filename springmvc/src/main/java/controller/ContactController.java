package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.User;

@Controller
public class ContactController {
    

    @RequestMapping("/contact")
    public String showForm(){
        return "contact";
    }

    // @PostMapping(path = "/processForm")
    // public String handleForm(@RequestParam("email") String userEmail, @RequestParam("userName") String userName, 
    //                         @RequestParam("password") String password, Model model ){
    //     System.out.println(userEmail);
    //     System.out.println(userName);
    //     System.out.println(password);

    //     User user =new User();
    //     user.setEmail(userEmail);
    //     user.setUserName(userName);
    //     user.setPassword(password);

    //     model.addAttribute(user);
    //     //model.addAttribute("userName", userName);
    //     //model.addAttribute("email", userEmail);
    //     return "success";

    // }

    @PostMapping(path = "/processForm")
    public String handleForm(@ModelAttribute User user, Model model ){
        return "success";

    }


}
