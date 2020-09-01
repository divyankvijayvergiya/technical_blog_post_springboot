package blogs.controller;

import blogs.model.Categories;
import blogs.model.Post;
import blogs.model.User;
import blogs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("posts")
    public String getUserPosts(Model model) {
        List<Post> postArrayList = postService.getAllPosts();
        model.addAttribute("posts", postArrayList);
        return "posts";
    }

    @RequestMapping("posts/newpost")
    public String newPost() {
        return "posts/create";
    }

    @RequestMapping(value = "posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost, HttpSession session) {
        User user = (User)session.getAttribute("loggedUser");
        newPost.setUser(user);

        if(newPost.getSpringBlog()!=null){
            Categories springBlogCategories = new Categories();
            springBlogCategories.setCategory(newPost.getSpringBlog());
            newPost.getCategories().add(springBlogCategories);
        }

        if(newPost.getJavaBlog()!=null){
            Categories javaBlogCategories = new Categories();
            javaBlogCategories.setCategory(newPost.getJavaBlog());
            newPost.getCategories().add(javaBlogCategories);
        }
        postService.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.GET)
    public String editPost(@RequestParam(name = "postId") Integer postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.PUT)
    public String editPostSubmit(@RequestParam(name = "postId") Integer postId, Post post, HttpSession session) {
        post.setId(postId);
        User user = (User)session.getAttribute("loggedUser");
        post.setUser(user);
        postService.updatePost(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/deletePost", method = RequestMethod.DELETE)
    public String deletePost(@RequestParam(name = "postId") Integer postId) {
        postService.deletePost(postId);
        return "redirect:/posts";
    }

}
