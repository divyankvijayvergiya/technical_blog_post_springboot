package blogs.controller;

import blogs.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getAllPosts(Model model) {
        ArrayList<Post> postArrayList = new ArrayList<>();
        Post post = new Post();
        post.setTitle("Post1");
        post.setBody("Post body 1");
        post.setDate(new Date());

        Post post1 = new Post();
        post1.setTitle("Post2");
        post1.setBody("Post body 2");
        post1.setDate(new Date());

        Post post3 = new Post();
        post3.setTitle("Post3");
        post3.setBody("Post body 3");
        post3.setDate(new Date());

        postArrayList.add(post);
        postArrayList.add(post1);
        postArrayList.add(post3);
        model.addAttribute("posts", postArrayList);
        return "index";
    }
}
