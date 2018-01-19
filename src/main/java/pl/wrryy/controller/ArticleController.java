
package pl.wrryy.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wrryy.dao.*;
import pl.wrryy.entity.Article;
import pl.wrryy.entity.Author;
import pl.wrryy.entity.Category;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleRepository dao;
    @Autowired
    private AuthorRepository authorDao;
    @Autowired
    private CategoryRepository categoryDao;

    private static final String ENT = "article";
    private static final String REDIRECT = "redirect:/" + ENT + "/all";

    @ModelAttribute("cats")
    public List<Category> listC() {
        return categoryDao.findAll();
    }
    @ModelAttribute("authors")
    public List<Author> listA() {
        return authorDao.findAll();
    }

    @RequestMapping("/all")
    private String print(Model model) {
        model.addAttribute(ENT, dao.findAll());
        return ENT + "/all";
    }

    @RequestMapping("/{name}")
    private String printByCategory(Model model, @PathVariable String name) {
        Category category = categoryDao.findCategoryByNameEquals(name);
        model.addAttribute(ENT, dao.findArticlesByCategoryEqualsOrderByCreatedDesc(category));
        return ENT + "/all";
    }

    @GetMapping(value = "/add")
    private String add(Model model) {
        model.addAttribute(ENT, new Article());
        return ENT + "/add";
    }

    @PostMapping(value = "/add")
    private String add(@Valid Article entity, BindingResult result) {
        if (result.hasErrors()) {
            return ENT + "/add";
        } else {
            dao.save(entity);
            return REDIRECT;
        }
    }

    @GetMapping(value = "/edit/{id}")
    private String edit(Model model, @PathVariable int id) {
        model.addAttribute(ENT, dao.findOne(id));
        return ENT + "/edit";
    }

    @PostMapping(value = "/edit")
    private String edit(@Valid Article entity, BindingResult result) {
        if (result.hasErrors()) {
            return ENT + "/edit";
        } else {
            dao.save(entity);
            return REDIRECT;
        }
    }


    @RequestMapping("/delete/{id}")
    private String delete(Model model, @PathVariable int id) {
        dao.delete(dao.findOne(id));
        return REDIRECT;
    }

}
