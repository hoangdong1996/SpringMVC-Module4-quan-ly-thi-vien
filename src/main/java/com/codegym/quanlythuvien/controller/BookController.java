package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Category;
import com.codegym.quanlythuvien.model.Library;
import com.codegym.quanlythuvien.service.BookService;
import com.codegym.quanlythuvien.service.CategoryService;
import com.codegym.quanlythuvien.service.LibraryService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class BookController implements WebMvcConfigurer {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LibraryService libraryService;

    @RequestMapping("/books")
    public String listBook(@RequestParam("searchBook") Optional<String> s, Model model, @PageableDefault(size = 5) Pageable pageable) {
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
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "book/add-book";
        }
        book.setStatus(false);
        bookService.save(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/delete-book/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.remove(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "/view-book/{id}", method = RequestMethod.GET)
    public String viewBook(@PathVariable("id") Long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        model.addAttribute("book", book);
        return "a";
    }


    @RequestMapping(value = "/borrow-book/{id}", method = RequestMethod.GET)
    public String borrowBook(@PathVariable("id") Optional<Long> id, Model model) {
        if (id.isPresent()) {
            Optional<Book> book = bookService.findById(id.get());
            model.addAttribute("book", book);
        } else {
            model.addAttribute("book", new Book());
        }
        return "library/borrow-book";
    }

    @RequestMapping(value = "save-borrow-book", method = RequestMethod.POST)
    public String saveBorrowBook(Book book) {
        book.setStatus(true);
        bookService.save(book);
        return "redirect:/libraries";
    }

    @RequestMapping(value = "/list-borrow-book/{id}", method = RequestMethod.GET)
    public String listBorrowBook(@PathVariable("id") Optional<Long> id, Model model) {
        Optional<Library> library = libraryService.findById(id.get());
        List<Book> books = bookService.findALlByBorrowDateNotNullAndLibrary(library);
        model.addAttribute("books", books);
        return "library/list-borrow-book";
    }

    @RequestMapping(value = "/return-book/{id}", method = RequestMethod.GET)
    public String returnBook(@PathVariable("id") Optional<Long> id, Book book) {
        Optional<Book> book1 = bookService.findById(id.get());

        book.setAuthor(book1.get().getAuthor());
        book.setIsbn(book1.get().getIsbn());
        book.setName(book1.get().getName());
        book.setCategory(book1.get().getCategory());
        book.setLibrary(book1.get().getLibrary());

        book.setStatus(false);
        book.setStudent(null);
        book.setBorrowDate(null);
        book.setReturnDate(null);

        bookService.save(book);
        return "redirect:/list-borrow-book/{id}";
    }


    @RequestMapping(value = "/add-book-library/{id}")
    public String addBookInLibrary(@PathVariable("id") Long id, Model model) {
        Optional<Library> library = libraryService.findById(id);
        model.addAttribute("library", library);
        model.addAttribute("book", new Book());
        return "library/add-book-library";
    }

    @RequestMapping(value = "/save-book-library/{id}", method = RequestMethod.POST)
    public String saveBookInLibrary(Book book, @PathVariable Long id) {
        Optional<Library> library = libraryService.findById(id);
        if (library.isPresent()) {
            book.setLibrary(library.get());
        }
        bookService.save(book);
        return "redirect:/views-library/{id}";
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
