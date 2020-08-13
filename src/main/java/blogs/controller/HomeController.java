package blogs.controller;

import blogs.model.Post;
import blogs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    public HomeController(){
        System.out.println("***HOME CONTROLLER***");
    }
    @Autowired
    PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "index";
    }
}
