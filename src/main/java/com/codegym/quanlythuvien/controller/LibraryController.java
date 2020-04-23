package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.model.Library;
import com.codegym.quanlythuvien.service.BookService;
import com.codegym.quanlythuvien.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

//    @Autowired
//    private BookService bookService;

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
    public String saveLibrary(Library library){
        libraryService.save(library);
        return "redirect:/libraries";
    }

//    @RequestMapping(value ="/add-book-in-library")
//    public String addBookInLibrary(Model model){
//        List<Library> libraries = libraryService.findAll();
//        model.addAttribute("libraries", libraries);
//        return "library/add-book";
//    }
//
//    @RequestMapping(value = "/add-book-in-library" , method = RequestMethod.POST)
//    public String addSave(
//            @ModelAttribute("libraries") Library library ,
//            @RequestParam(value = "book" , required = false) Long[] book, Model model) {
//        if (book != null) {
//            Book book1 = null;
//            for (int i = 0; i < book.length; i++) {
//                if (bookService.findById(book[i]).isPresent()) {
//                    book1 = new Book();
//                    book1.setId(book[i]);
//                    library.getBooks().add(book1);
//                }
//            }
//            for (int i = 0; i < library.getBooks().size(); i++) {
//                System.out.println(library.getBooks().get(i));
//            }
//        }
//        return "library/add-book";
//    }
//
//    @ModelAttribute("books")
//    public List<Book> books(){
//        return bookService.findAll();
//    }
}
