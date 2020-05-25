package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private BookService bookService;
    @GetMapping("/")
    public String root(Model model) {
        Long count = bookService.countBook();
        model.addAttribute("count",count);
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login1";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/home";
    }
}
