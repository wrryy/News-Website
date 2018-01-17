package pl.wrryy.dao;

import org.springframework.stereotype.Component;
import pl.wrryy.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Component
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Category category){
        entityManager.persist(category);
    }
    public void edit(Category category){
        entityManager.merge(category);
    }
    public void delete(Category category){
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }
    public Category getById(int id){
        return entityManager.find(Category.class, id);
    }

    public List<Category> getAll() {
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        return (List<Category>) query.getResultList();
    }
    public Category getByName(String name) {
        Query query = entityManager.createQuery("SELECT c FROM Category c where c.name=:name");
        query.setParameter("name", name);
        return (Category) query.getResultList();
    }
}
