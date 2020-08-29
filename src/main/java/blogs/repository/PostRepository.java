package blogs.repository;

import blogs.model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public List<Post> getAllPosts() {
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<Post> query = entityManager.createQuery("select p from Post p", Post.class);
        List<Post> resultList = query.getResultList();
        return resultList;
    }

    public Post getLatestPost(){
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Post.class, 3);
    }
}
