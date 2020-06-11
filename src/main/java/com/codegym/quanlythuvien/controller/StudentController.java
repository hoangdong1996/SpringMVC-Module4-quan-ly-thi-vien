package com.codegym.quanlythuvien.controller;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Student;
import com.codegym.quanlythuvien.service.StudentService;
import com.codegym.quanlythuvien.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/students")
    public String listStudent(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/list-student";
    }

    @RequestMapping(value = "/add-student")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student/add-student";
    }

    @RequestMapping(value = "/save-student", method = RequestMethod.POST)
    public String saveStudent(Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/edit-student/{id}")
    public String editStudent(@PathVariable("id") Optional<Long> id, Model model){
        if (id.isPresent()){
            Optional<Student> student = studentService.findById(id.get());
            model.addAttribute("student", student);
        } else {
            model.addAttribute("student", new Student());
        }
        return "student/edit-student";
    }

    @RequestMapping(value = "/delete-student/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.remove(id);
        return "redirect:/students";
    }
}
