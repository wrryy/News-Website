package pl.wrryy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wrryy.entity.Article;
import pl.wrryy.entity.Category;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    public List<Article> findArticlesByCategoryEqualsOrderByCreatedDesc(Category category);
}
