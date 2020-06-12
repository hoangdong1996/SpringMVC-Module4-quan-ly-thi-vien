package com.codegym.quanlythuvien.model;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    public Library() {
    }

    public Library(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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

}
