package pl.wrryy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wrryy.dao.CategoryRepository;
import pl.wrryy.entity.Category;

import java.util.List;
@RequestMapping("/category")
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryDao;
    private static final String ENT = "category";
    private static final String REDIRECT = "redirect:/"+ENT+"/all";

    @ModelAttribute("cats")
    public List<Category> list(){
        return categoryDao.findAll();
    }

    @RequestMapping("/all")
    private String print(Model model) {
        model.addAttribute(ENT, categoryDao.findAll());
        return ENT + "/all";
    }
    @GetMapping("/add")
    private String add(Model model){
        model.addAttribute(ENT, new Category());
        return ENT+"/add";
    }
    @PostMapping(value = ENT+"/add")
    private String add(@ModelAttribute Category category) {
        categoryDao.save(category);
        return REDIRECT;
    }
    @GetMapping("/edit/{id}")
    private String edit(Model model, @PathVariable int id){
        model.addAttribute(ENT, categoryDao.findOne(id));
        return ENT+"/edit";
    }
    @PostMapping("/edit")
    private String edit(@ModelAttribute Category category){
        categoryDao.save(category);
        return REDIRECT;
    }
    @RequestMapping("/delete/{id}")
    private String delete(Model model, @PathVariable int id){
        categoryDao.delete(categoryDao.findOne(id));
        return REDIRECT;
    }


}
