package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.repository.UserRepository;
import com.codegym.quanlythuvien.service.BookService;
import com.codegym.quanlythuvien.service.LibraryService;
import com.codegym.quanlythuvien.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = { "/", "/login" })
    public String login(@RequestParam(required = false) String message, final Model model) {
        if (message != null && !message.isEmpty()) {
            if (message.equals("logout")) {
                model.addAttribute("message", "Logout!");
            }
            if (message.equals("error")) {
                model.addAttribute("message", "Login Failed!");
            }
        }
        return "login";
    }

//    @RequestMapping("/home")
//    public String homePage(Principal principal, Model model){
//        User user = userRepository.findByUsername(principal.getName());
//        model.addAttribute("user", user);
//
//        Long countBook = bookService.countBook();
//        model.addAttribute("countBook",countBook);
//
//        Long countLibrary = libraryService.countLibrary();
//        model.addAttribute("countLibrary",countLibrary);
//        return "home";
//    }

    @RequestMapping("/home")
    public String welcome(){
        return "welcome";
    }
    @RequestMapping("/admin")
    public String admin(Model model) {
        Long countBook = bookService.countBook();
        model.addAttribute("countBook",countBook);

        Long countLibrary = libraryService.countLibrary();
        model.addAttribute("countLibrary",countLibrary);

        Long countStudent = studentService.countStudent();
        model.addAttribute("countStudent", countStudent);
        return "pageAdmin";
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }
}
