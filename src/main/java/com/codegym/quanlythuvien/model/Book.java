package com.codegym.quanlythuvien.model;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.List;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @Column(name = "ISBN", unique = false, nullable = false, length = 13)
    private Long id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "catagory_id", referencedColumnName = "catagory_id")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "borrow_book",
            joinColumns = @JoinColumn(name = "ISBN", referencedColumnName = "ISBN"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
    private List<Student> students;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_in_library",
            joinColumns = @JoinColumn(name = "ISBN", referencedColumnName = "ISBN"),
            inverseJoinColumns = @JoinColumn(name = "library_id", referencedColumnName = "library_id"))
    private List<Library> libraries;

    public Book(){}

    public Book(String name, String author, String status) {
        this.name = name;
        this.author = author;
        this.status = status;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
