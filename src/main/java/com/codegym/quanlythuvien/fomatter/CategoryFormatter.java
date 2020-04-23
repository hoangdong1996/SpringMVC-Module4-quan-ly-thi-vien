package com.codegym.quanlythuvien.fomatter;

import com.codegym.quanlythuvien.model.Category;
import com.codegym.quanlythuvien.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class CategoryFormatter implements Formatter<Optional<Category>> {
    private CategoryService categoryService;

    @Autowired
    public CategoryFormatter(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Optional<Category> parse(String text, Locale locale) throws ParseException {
        return categoryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Optional<Category> object, Locale locale) {
        return "[" + object.get().getId() + ", " +object.get().getName() + "]";
    }

}
