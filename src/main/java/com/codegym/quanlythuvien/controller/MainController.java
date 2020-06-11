package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private BookService bookService;

//    @GetMapping("/")
//    public String root(Model model) {
//        Long count = bookService.countBook();
//        model.addAttribute("count", count);
//        return "index";
//    }
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
    @RequestMapping("/user")
    public String user() {
        return "index";
    }
    @RequestMapping("/admin")
    public String admin() {
        return "index";
    }
    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }
}
