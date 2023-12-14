package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.dao.PostDao;
import com.codeup.codeupspringblog.models.Post;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// the controller file is the right place to place all these routes
@Controller
@RequestMapping("/posts")
public class PostController {
    private Post post1 = new Post(1, "Post 1", "hello, hello, hello");
    private  Post post2 = new Post(2, "Post 2", "blah blah blah");
    private Post post3 = new Post(3, "Post 3", "yada yada yada");

    // Arrays.asList(1, 2, 3)
    private List<Post> posts = new ArrayList<>(List.of(post1, post2, post3));

    // add injection for POST repository(postdao)
    // every time a postController gets created, a postDao should be a part of it
    private final PostDao postDao;
    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }

//    @GetMapping({"/posts")
//    @ResponseBody
//    public String getAllPosts() {
//        return "index";
//    }

    // hardcoded array list to be displayed
//    @GetMapping("/posts/{id}")
////    @ResponseBody
//    Post post = new Post();
//    public String getPostDetail(@PathVariable long id) {
//        return "show";
//    }

//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    Post post = new Post();
//    public String getPostDetail(@PathVariable long id) {
//        return "show";
//    }



    @GetMapping("/{id}")
    public String getPostDetail(@PathVariable long id, Model model) {
        model.addAttribute("post", post1);
        return "/posts/show";
    }

//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String getCreatePage() {
//        return "view the form for creating a post";
//    }

    @GetMapping("/create")
    public String getCreatePage() {
        return "/posts/create";
    }

//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String submitPost() {
//        return "create a new post";
//    }

    @PostMapping("/create")
    public String submitPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
//    Post post = new Post(99, title, body);
//    posts.add(post);
    // now save to it to DB
        Post post = new Post(title, body);
        postDao.save(post);


    return "redirect:/posts";
    }
}


// Another alternative is to add @REBody ("/posts"
    // @Controller
    // @RequestMapping("/posts)
//public class PostController {
//    @GetMapping("/posts")
//    @ResponseBody
//    public String getAllPosts() {
//        return "posts index page";
//    }
//
//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String getPostDetail(@PathVariable long id) {
//        return "view an individual post";
//    }
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String getCreatePage() {
//        return "view the form for creating a post";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String submitPost() {
//        return "create a new post";
//    }
//
//}
