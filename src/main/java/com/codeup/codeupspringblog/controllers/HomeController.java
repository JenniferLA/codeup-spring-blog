package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
//    @GetMapping("/")
//    //returning a page instead of a string:
//    @ResponseBody
//    public String landingPage() {
//        return "This is the landing page!";
//        //returning a page instead of a string:
////        return "home";
//    }


    // Modified to return a view instead of a string:
    // import org.springframework.stereotype.Controller;
    //import org.springframework.web.bind.annotation.GetMapping;
    //
    //@Controller
//    public class HomeController {

    @GetMapping("/home")
    public String welcome() {
        return "home";
        //    }
        //}
    }
}