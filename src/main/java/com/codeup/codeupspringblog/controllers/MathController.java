package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    // url = /add/3/and/4   response = 7
    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public String adding(@PathVariable int x, @PathVariable int y) {
        return String.valueOf(x + y) + "!";
    }

    @GetMapping("/subtract/{x}/and/{y}")
    @ResponseBody
    public String subtracting(@PathVariable int x, @PathVariable int y) {
        return String.valueOf( y - x );
        }


    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public String multiplying(@PathVariable int x, @PathVariable int y) {
        return String.valueOf(x * y);
    }

    @GetMapping("/divide/{x}/by/{y}")
    @ResponseBody
    public String dividing(@PathVariable int x, @PathVariable int y) {
        return String.valueOf(y / x);
    }


    }



