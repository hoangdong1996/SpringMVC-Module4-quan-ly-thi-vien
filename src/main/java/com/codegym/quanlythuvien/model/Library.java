package com.codegym.quanlythuvien.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "libraries")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "library_id")
    private Long id;

    @Column(name = "library_name")
    private String name;

    @Column(name = "library_info")
    private String info;

    @OneToMany(targetEntity = Librarian.class, fetch = FetchType.EAGER)
    private List<Librarian> librarians;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_in_library",
            joinColumns = @JoinColumn(name = "ISBN", referencedColumnName = "ISBN"),
            inverseJoinColumns = @JoinColumn(name = "library_id", referencedColumnName = "library_id"))
    private List<Book> books;

    public Library(){}

    public Library(String name, String info){
        this.name = name;
        this.info = info;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(List<Librarian> librarians) {
        this.librarians = librarians;
    }
}
