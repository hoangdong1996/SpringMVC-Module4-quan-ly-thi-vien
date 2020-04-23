package com.codegym.quanlythuvien.model;

import com.codegym.quanlythuvien.model.BookInLibrary.BookLibrary;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "book_name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "catagory_id")
    private Category category;

//    @OneToMany(mappedBy = "books")
//    private List<BookLibrary> bookLibraries ;

    public Book() {
    }

    public Book(String isbn, String name, String author, String status) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.status = status;
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
