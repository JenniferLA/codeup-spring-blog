package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

// this tells Spring to care about this as Controller
@Controller

public class HelloController {

    // Create a method
//    private int counter = 0;
//    private int counter;
    private int counter = 0;

    @GetMapping("/counter/{counterInit}")
    @ResponseBody
    public String initCounter(@PathVariable int counterInit) {
        // set counter to whatever we want
        counter = counterInit;
        return "counter reset to " + counter;
    }

    @GetMapping("/increment")
    @ResponseBody
    public String incrementCounter() {
        counter++;
        return "counter is now " + counter;
    }

    // the method as a whole is sparse
//    @GetMapping("/hello") //get request to this end point "/hello" then it executes the return
    // could also use requestmapping
    // beneficial if /hello has multiple
    // @RequestMapping(method=RequestMethod.GET, name = "/hello")
    @ResponseBody
    @GetMapping(path = "/hello", produces = "application/json")
    public String hello() { //this will be sent to the requestor as the response body
//        return "Hello from Spring!";
        return """
                {
                    "message" : "hello json from spring"
                }    
                """;
    }
@GetMapping(path = "/hello-msg", produces = "application/json")
@ResponseBody
public String helloMessage() {
    return String.format("hello from JSON! %s", LocalDateTime.now());
}

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

// @GetMapping(path = "/hello/{personName}")
    // @ResponseBody
//    public String hello (@PathVariable String personName){ //this will be sent to the requestor as the response body
////        return "Hello " + personName;
//        return """
//                {
//                    "message" : "hello json from spring"
//                }
//                """;
//    }
//@GetMapping(path = "/hello-msg/{personName}", produces = "application/json")
//@ResponseBody
//public String helloMessage() {
//    return String.format("hello from JSON! %s", LocalDateTime.now());
//}


}


