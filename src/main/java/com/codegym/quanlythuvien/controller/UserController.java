package com.codegym.quanlythuvien.controller;
import com.codegym.quanlythuvien.model.User;
import com.codegym.quanlythuvien.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;



@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
//        userValidator.validate(userForm, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "add-user";
//        }
//        userService.save(userForm);
//        return "redirect:";
//    }
}
