package com.codegym.quanlythuvien.model;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ISBN")
    @NotNull
    @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$", message = "ISBN 13 numbers start with only 978 or 979.")
    private String isbn;

    @Column(name = "book_name")
    @NotBlank
    private String name;

    @Column(name = "author")
    @NotBlank
    private String author;

    @Column(name = "status")
    private Boolean status  ;

    @Column(name = "borrow_date")
    private String borrowDate;

    @Column(name = "return_date")
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "catagory_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Book() {
    }

    public Book(String isbn, String name, String author, Boolean status, String borrowDate, String returnDate) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
