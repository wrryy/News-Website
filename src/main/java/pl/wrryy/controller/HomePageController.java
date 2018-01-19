package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wrryy.dao.ArticleRepository;
import pl.wrryy.dao.CategoryRepository;
import pl.wrryy.entity.Category;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private ArticleRepository articleDao;
    @Autowired
    private CategoryRepository categoryDao;

    @ModelAttribute("cats")
    public List<Category> listC() {
        return categoryDao.findAll();
    }

    @RequestMapping({"/home","/"})
    public String printArticles(Model model) {
        model.addAttribute("top5", articleDao.findAll().subList(0, 4));
        return "home";
    }
    @RequestMapping("/articles/{category}")
    public String printArticlesByCategory(Model model, @PathVariable String category){
//        List<Article> list = articleDao.getByCategory(categoryDao.getByName(category));
//        model.addAttribute("articles", list);
        return "articles";
    }

}
