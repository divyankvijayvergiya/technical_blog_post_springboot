package blogs.service;

import blogs.model.Post;
import blogs.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostService() {
        System.out.println("***Post Service***");
    }

    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }

    public Post getOnePost() {
        return postRepository.getLatestPost();
    }

    public void createPost(Post newPost) {
        newPost.setDate(new Date());
        postRepository.createPost(newPost);
        System.out.println("New Post: " + newPost);
    }

    public Post getPost(Integer postId) {
        return postRepository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        postRepository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId){
      postRepository.deletePost(postId);
    }
}
