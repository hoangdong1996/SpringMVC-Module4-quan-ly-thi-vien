package com.codegym.quanlythuvien.model;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users_roles")
public class UsersRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Role role;
    private User user;

    public UsersRoles() {
    }

    public UsersRoles(Role role, User users) {
        this.role = role;
        this.user = users;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    public User getUsers() {
        return this.user;
    }

    public void setUsers(User users) {
        this.user = users;
    }
}
