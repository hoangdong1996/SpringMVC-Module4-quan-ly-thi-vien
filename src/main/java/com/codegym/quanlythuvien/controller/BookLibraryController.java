package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Library;
import com.codegym.quanlythuvien.service.BookService;
import com.codegym.quanlythuvien.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookLibraryController {
    @Autowired
    private BookService bookService;

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "/add-book-in-library", method = RequestMethod.POST)
    public String addSave(
            @ModelAttribute("libraries") Library library,
            @RequestParam(value = "book", required = false) Long[] book, Model model) {
        System.out.println(book);
//        if (book != null) {
//            Book book1 = null;
//            for (int i = 0; i < book.length; i++) {
//                if (bookService.findById(book[i]).isPresent()) {
//                    book1 = new Book();
//                    book1.setId(book[i]);
//                    library.g;
//                }
//            }
////            for (int i = 0; i < library.getBooks().size(); i++) {
////                System.out.println(library.getBooks().get(i));
////            }
//        }
        return "book-in-library/add-book";
    }

    @RequestMapping(value ="/add-book-in-library")
    public String addBookInLibrary(Model model){
        List<Library> libraries = libraryService.findAll();
        model.addAttribute("libraries", libraries);
        return "book-in-library/add-book";
    }
    @ModelAttribute("books")
    public List<Book> listBook() {
        return bookService.findAll();
    }
}
