package com.codegym.quanlythuvien.model;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "catagory_id")
    private Long id;

    @Column(name = "catagory_name")
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    private Book book;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
