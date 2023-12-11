package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    // url = /add/3/and/4   response = 7
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2) {
        return String.valueOf(num1 + num2) + "!";
        // another alternative
        // return "" + (num1 + num2);
        // another alternative is changing signature to int
    }

    @GetMapping("/subtract/{x}/and/{y}")
    @ResponseBody
    public String subtract(@PathVariable int x, @PathVariable int y) {
        return String.valueOf( y - x );
        }


    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public String multiply(@PathVariable int x, @PathVariable int y) {
        return String.valueOf(x * y);
    }

    @GetMapping("/divide/{x}/by/{y}")
    @ResponseBody
    public String divide(@PathVariable double x, @PathVariable double y) {
        return "" + (x / y);
        // able to cast it as a double as well
//        return "" + ((double) x / y);
    }


    }



