package pl.wrryy.dao;

import org.springframework.stereotype.Component;
import pl.wrryy.entity.Author;
import pl.wrryy.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AuthorDao  {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Author author){
        entityManager.persist(author);
    }
    public void edit(Author author){entityManager.merge(author);
    }
    public void delete(Author author){
        entityManager.remove(entityManager.contains(author) ?
                author: entityManager.merge(author));
    }
    public Author getById(int id){
        return entityManager.find(Author.class, id);
    }
    public List<Author> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Author a");
        return (List<Author>) query.getResultList();
    }

}
