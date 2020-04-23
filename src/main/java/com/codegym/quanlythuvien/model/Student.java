//package com.codegym.quanlythuvien.model;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "students")
//public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "student_id")
//    private Long id;
//
//    @Column(name = "student_name")
//    private String name;
//
//    @Column(name = "school")
//    private String school;
//
////    @ManyToMany(cascade = CascadeType.ALL)
////    @JoinTable(name = "borrow_book",
////            joinColumns = @JoinColumn(name = "ISBN", referencedColumnName = "ISBN"),
////            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
////    private List<Book> books;
//
//    public Student() {
//    }
//
//    public  Student(String name, String school){
//        this.name = name;
//        this.school = school;
//    }
////    public List<Book> getBooks() {
////        return books;
////    }
////
////    public void setBooks(List<Book> books) {
////        this.books = books;
////    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSchool() {
//        return school;
//    }
//
//    public void setSchool(String school) {
//        this.school = school;
//    }
//}
