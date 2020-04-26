package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Student;
import com.codegym.quanlythuvien.service.StudentService;
import com.codegym.quanlythuvien.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/students")
    public String listStudent(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/list-student";
    }
    @RequestMapping(value = "/add-student")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "student/add-student";
    }

    @RequestMapping(value = "/save-student", method = RequestMethod.POST)
    public String saveStudent(Student student){
        studentService.save(student);
        return "redirect:";
    }
}
