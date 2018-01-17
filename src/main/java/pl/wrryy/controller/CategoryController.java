package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wrryy.dao.CategoryDao;
import pl.wrryy.entity.Category;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;
    private static final String ENT = "category";
    private static final String REDIRECT = "redirect:/"+ENT+"/all";

    @ModelAttribute("cats")
    public List<Category> list(){
        return categoryDao.getAll();
    }

    @RequestMapping(ENT+"/all")
    private String print(Model model) {
        model.addAttribute(ENT, categoryDao.getAll());
        return ENT + "/all";
    }
    @RequestMapping(value = ENT+"/add", method = RequestMethod.GET)
    private String add(Model model){
        model.addAttribute(ENT, new Category());
        return ENT+"/add";
    }
    @RequestMapping(value = ENT+"/add", method = RequestMethod.POST)
    private String add(@ModelAttribute Category category) {
        categoryDao.save(category);
        return REDIRECT;
    }
    @RequestMapping(value = ENT+"/edit/{id}", method = RequestMethod.GET)
    private String edit(Model model, @PathVariable int id){
        model.addAttribute(ENT, categoryDao.getById(id));
        return ENT+"/edit";
    }
    @RequestMapping(value = ENT+"/edit", method = RequestMethod.POST)
    private String edit(@ModelAttribute Category category){
        categoryDao.edit(category);
        return REDIRECT;
    }
    @RequestMapping(ENT+"/delete/{id}")
    private String delete(Model model, @PathVariable int id){
        categoryDao.delete(categoryDao.getById(id));
        return REDIRECT;
    }


}
