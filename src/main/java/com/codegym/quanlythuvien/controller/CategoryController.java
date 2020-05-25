package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Category;
import com.codegym.quanlythuvien.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories")
    public String listCategory(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/list-category";
    }

    @RequestMapping(value = "/add-category")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category/add-category";
    }

    @RequestMapping(value = "/edit-category/{id}")
    public String editCategory(@PathVariable("id") Optional<Long> id, Model model) {
        if (id.isPresent()) {
            Optional<Category> category = categoryService.findById(id.get());
            model.addAttribute("category", category);
        } else {
            model.addAttribute("category", new Category());
        }
        return "category/edit-category";
    }

    @RequestMapping(value = "/save-category", method = RequestMethod.POST)
    public String saveCategory(Category category) {
        categoryService.save(category);
        return "redirect:/categories";
    }

    @RequestMapping(value = "/delete-category/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("id") Long id, Model model) {
        categoryService.remove(id);
        return "redirect:/categories";
    }
}
