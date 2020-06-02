package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Category;
import com.codegym.quanlythuvien.model.Library;
import com.codegym.quanlythuvien.service.BookService;
import com.codegym.quanlythuvien.service.CategoryService;
import com.codegym.quanlythuvien.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @Autowired
    private LibraryService libraryService;

    @RequestMapping("/books")
    public String listBook(@RequestParam("seachBook") Optional<String> s, Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<Book> books;
        if (s.isPresent()) {
            books = bookService.findAllByNameContaining(s.get(), pageable);
        } else {
            books = bookService.findAll(pageable);
        }
        model.addAttribute("books", books);
        return "book/list-book";
    }

    @RequestMapping(value = "/add-book")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/add-bookk";
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

    @RequestMapping(value = "/view-book/{id}", method = RequestMethod.GET)
    public String viewBook(@PathVariable("id") Long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        model.addAttribute("book", book);
        return "a";
    }

    @RequestMapping("/count")
    public String countBook(Model model) {
        Long count = bookService.countBook();
        model.addAttribute("count", count);
        return "index";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @ModelAttribute("libraries")
    public List<Library> libraries() {
        return libraryService.findAll();
    }
}
