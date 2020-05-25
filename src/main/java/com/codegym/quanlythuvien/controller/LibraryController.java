package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Library;
import com.codegym.quanlythuvien.model.Student;
import com.codegym.quanlythuvien.service.BookService;
import com.codegym.quanlythuvien.service.LibraryService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/libraries")
    public String listLibrary(Model model) {
        List<Library> libraries = libraryService.findAll();
        model.addAttribute("libraries", libraries);
        return "library/list-library";
    }

    @RequestMapping(value = "/add-library")
    public String addLibrary(Model model) {
        model.addAttribute("library", new Library());
        return "library/add-library";
    }

    @RequestMapping(value = "save-library", method = RequestMethod.POST)
    public String saveLibrary(Library library) {
        libraryService.save(library);
        return "redirect:/libraries";
    }


    @RequestMapping(value = "views-library/{id}")
    public String viewsLibrary(@PathVariable("id") Long id, Model model) {
        Optional<Library> library = libraryService.findById(id);
        List<Book> books = bookService.findAllByLibrary(library);
        model.addAttribute("library", library);
        model.addAttribute("books", books);
        return "library/views-library";
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

    @RequestMapping(value = "save-borrow-book"  , method = RequestMethod.POST)
    public String saveBook(Book book) {
        bookService.save(book);
        return "redirect:/libraries";
    }

    @RequestMapping("/list-borrow-book")
    public String listBorrowBook(Model model) {
        List<Book> books = bookService.findAllByBorrowDateNotNull();
        model.addAttribute("books", books);
        return "library/list-borrow-book";
    }

    @RequestMapping(value = "/return-book/{id}", method = RequestMethod.GET)
    public String returnBook(@PathVariable("id") Optional<Long> id, Book book) {
        Optional<Book> book1 = bookService.findById(id.get());

        book.setAuthor(book1.get().getAuthor());
        book.setIsbn(book1.get().getIsbn());
        book.setName(book1.get().getName());
        book.setStatus(book1.get().getStatus());
        book.setCategory(book1.get().getCategory());
        book.setLibrary(book1.get().getLibrary());

        book.setStudent(null);
        book.setBorrowDate(null);
        book.setReturnDate(null);

        bookService.save(book);
        return "redirect:/list-borrow-book";
    }

    @ModelAttribute("books")
    public List<Book> books() {
        return bookService.findAll();
    }
}

