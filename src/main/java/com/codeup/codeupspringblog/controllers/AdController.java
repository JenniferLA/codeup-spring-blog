package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.dao.AdDao;
import com.codeup.codeupspringblog.dao.UserDao;
import com.codeup.codeupspringblog.models.Ad;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//
@AllArgsConstructor
@Controller
@RequestMapping("/ads")



public class AdController {
//    Ad ad = new Ad("Amazing new product!", "The everything thing will solve all your problems! It will clean your floors, wash your dishes, cook your dinner, and walk your dog!");
//    Ad ad2 = new Ad("Latest flying car", "This new flying car will take off above traffic and save you time on your morning commute! No pilot license required!");
//    Ad ad3 = new Ad("Sunshine in a bottle", "Captured sunlight in a convenient recyclable bottle for all your natural lighting needs!");
//    List<Ad> ads = new ArrayList<>(List.of(ad, ad2, ad3));

    // done this way bc Spring handles it for us so we don't have to do adDao() since we have an allargs constructor

    //dependency injection

    private AdDao adDao;
    private UserDao userDao;

    // javier's way:
    // public AdController(AdDao adDao){
    // this.adDao = adDao;
    // }



    @GetMapping(value =  {"", "/ads"})
    // alternative
    // @GetMapping("")
    // injects the stuff to view
    public String adIndex(Model model){
        List<Ad> ads = adDao.findAll();
        model.addAttribute("ads", ads);
        // specify the path to the html page
        return "/ads/index";
    }

    @GetMapping({"/{id}", "/{id}/"})
    public String showAd(@PathVariable long id, Model model) {

        //unwrap by using .get
        Ad ad;
        if (adDao.findById(id).isPresent()) {
            ad = adDao.findById(id).get();
        } else {
            ad = new Ad("Ad not found", "");
        }

        model.addAttribute("ad", ad);
        return "/ads/show";

        // inject it
//        model.addAttribute("ad", ad2);
//        return "/ads/show";
    }

    // ... ad objects, ad list, and other methods

    @GetMapping("/create")
    public String showCreateAdForm() {
        return "/ads/create";
    }

    @PostMapping("/create")
    //attribute and the NAME of the field in the annotation in html
    public String handleAdSubmission(@RequestParam(name="title") String title, @RequestParam(name = "description") String description) {
        // doc's way
        // Ad ad = new Ad(title, description);
        // ads.add(ad);
        // return "redirect:/ads";
        // don't forget redirects add trip time
//        ads.add(new Ad(title, description));

        Ad ad = new Ad(title, description);
        ad.setUser(userDao.findUserById(1L));
        adDao.save(ad);
        return "redirect:/ads";
    }
}

