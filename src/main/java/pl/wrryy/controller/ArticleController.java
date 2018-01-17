package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.wrryy.dao.ArticleDao;
import pl.wrryy.dao.AuthorDao;
import pl.wrryy.dao.CategoryDao;
import pl.wrryy.entity.Article;
import pl.wrryy.entity.Category;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleDao dao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private CategoryDao categoryDao;

    private static final String ENT = "article";
    private static final String REDIRECT = "redirect:/"+ENT+"/all";

    @ModelAttribute("cats")
    public List<Category> list(){
        return categoryDao.getAll();
    }

    @RequestMapping("/all")
    private String print(Model model) {
        model.addAttribute(ENT, dao.getAll());
        return ENT+"/all";
    }
    @RequestMapping("/{name}")
    private String printByCategory(Model model, @PathVariable String name  ) {
        model.addAttribute(ENT, dao.getByCategory(name));
        return ENT + "/all";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    private String add(Model model){
        model.addAttribute(ENT, new Article());
        model.addAttribute("authors", authorDao.getAll());
        return ENT+"/add";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String add(@ModelAttribute Article entity) {
        dao.save(entity);
        return REDIRECT;
    }
    @RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
    private String edit(Model model, @PathVariable int id){
        model.addAttribute(ENT, dao.getById(id));
        return ENT+"/edit";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    private String edit(@ModelAttribute Article entity){
        dao.edit(entity);
        return REDIRECT;
    }
    @RequestMapping("/delete/{id}")
    private String delete(Model model, @PathVariable int id){
        dao.delete(dao.getById(id));
        return REDIRECT;
    }

}
