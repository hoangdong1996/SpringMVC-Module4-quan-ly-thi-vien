package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Category;
import com.codegym.quanlythuvien.service.BookService;
import com.codegym.quanlythuvien.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/books")
    public String listBook(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book/list-book";
    }

    @RequestMapping(value = "/add-book")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/add-book";
    }

    @RequestMapping(value = "/edit-book/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Optional<Long> id, Model model) {
        if (id.isPresent()) {
            Optional<Book> book = bookService.findById(id.get());
            model.addAttribute("book", book);
        } else {
            model.addAttribute("book", new Book());
        }
        return "book/edit-book";
    }

    @RequestMapping(value = "/save-book", method = RequestMethod.POST)
    public String saveBook(Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/delete-book/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookService.remove(id);
        return "redirect:/books";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }
}
