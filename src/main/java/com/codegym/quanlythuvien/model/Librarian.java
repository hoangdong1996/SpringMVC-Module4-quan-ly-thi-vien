package com.codegym.quanlythuvien.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "libraries")
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "librarian_name")
    private String name;

    @Column(name = "librarian_info")
    private String info;

    @Column(name = "librarian_password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    public Librarian() {
    }

    public Librarian(String name, String info, String password) {
        this.name = name;
        this.info = info;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Library getLibrary() {
//        return library;
//    }
//
//    public void setLibrary(Library library) {
//        this.library = library;
//    }
}
