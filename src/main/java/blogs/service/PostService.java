package blogs.service;

import blogs.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    public PostService() {
        System.out.println("***Post Service***");
    }

    public ArrayList<Post> getAllPosts() {
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
        return postArrayList;
    }

    public ArrayList<Post> getOnePost() {
        ArrayList<Post> postArrayList = new ArrayList<>();
        Post post = new Post();
        post.setTitle("This is your post");
        post.setBody("This is your post. It has some valid content");
        post.setDate(new Date());
        postArrayList.add(post);
        return postArrayList;
    }
}
