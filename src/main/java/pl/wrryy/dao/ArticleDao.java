package pl.wrryy.dao;

import org.springframework.stereotype.Component;
import pl.wrryy.entity.Article;
import pl.wrryy.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Article article){
        entityManager.persist(article);
    }
    public void edit(Article article){
        entityManager.merge(article);
    }
    public void delete(Article article){
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }
    public Article getById(int id){
        return entityManager.find(Article.class, id);
    }

    public List<Article> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Article a order by a.created desc");
        return (List<Article>) query.getResultList();
    }
    public List<Article> getByCategory(String name) {
        Category category = new CategoryDao().getByName(name);
        Query query = entityManager.createQuery("SELECT a FROM Article a where a.category=:category order by a.created desc");
        query.setParameter("category", category);
        return (List<Article>) query.getResultList();
    }
}
