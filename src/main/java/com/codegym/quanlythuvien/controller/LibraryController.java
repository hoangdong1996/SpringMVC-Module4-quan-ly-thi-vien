package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Library;
import com.codegym.quanlythuvien.service.BookService;
import com.codegym.quanlythuvien.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/libraries")
    public String listLibrary(@RequestParam("searchLibrary") Optional<String> nameLibrary, Model model) {
        List<Library> libraries;
        if (nameLibrary.isPresent())
        {
             libraries = libraryService.findAllByName(nameLibrary.get());
        } else {
            libraries = libraryService.findAll();
        }
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

    @RequestMapping(value = "/delete-library/{id}")
    public String deleteLibrary(@PathVariable("id") Long id){
        libraryService.remove(id);
        return "redirect:/libraries";
    }

    @RequestMapping(value = "/edit-library/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Optional<Long> id, Model model) {
        if (id.isPresent()) {
            Optional<Library> library = libraryService.findById(id.get());
            model.addAttribute("library", library);
        } else {
            model.addAttribute("library", new Library());
        }
        return "library/edit-library";
    }

    @RequestMapping(value = "views-library/{id}")
    public String viewsLibrary(@PathVariable("id") Long id,@RequestParam("searchBook") Optional<String> nameBook, Model model) {
       List<Book> books;
        Optional<Library> library = libraryService.findById(id);
        if (nameBook.isPresent()){
            books = bookService.findAllByNameAndLibrary(nameBook.get(), library);
        } else {
            books = bookService.findAllByLibrary(library);
        }
        model.addAttribute("library", library);
        model.addAttribute("books", books);
        return "library/views-library";
    }


    @ModelAttribute("books")
    public List<Book> books() {
        return bookService.findAll();
    }
}

