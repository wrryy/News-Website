package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.wrryy.dao.AuthorDao;
import pl.wrryy.dao.CategoryDao;
import pl.wrryy.entity.Author;
import pl.wrryy.entity.Category;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorDao dao;
    @Autowired
    private CategoryDao categoryDao;

    private static final String ENT = "author";
    private static final String REDIRECT = "redirect:/author/all";

    @ModelAttribute("cats")
    public List<Category> list(){
        return categoryDao.getAll();
    }

    @RequestMapping("/all")
    private String print(Model model) {
        model.addAttribute(ENT, dao.getAll());
        return ENT+"/all";
    }
    @RequestMapping(value ="/add", method = RequestMethod.GET)
    private String add(Model model){
        model.addAttribute(ENT, new Author());
        return ENT+"/add";
    }
    @RequestMapping(value ="/add", method = RequestMethod.POST)
    private String add(@ModelAttribute Author author) {
        dao.save(author);
        return REDIRECT;
    }
    @RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
    private String edit(Model model, @PathVariable int id){
        model.addAttribute(ENT, dao.getById(id));
        return ENT+"/edit";
    }
    @RequestMapping(value ="/edit", method = RequestMethod.POST)
    private String edit(@ModelAttribute Author author){
        dao.edit(author);
        return REDIRECT;
    }
    @RequestMapping("/delete/{id}")
    private String delete(Model model, @PathVariable int id){
        dao.delete(dao.getById(id));
        return REDIRECT;
    }
}
