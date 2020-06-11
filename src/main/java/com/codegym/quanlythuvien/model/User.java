package com.codegym.quanlythuvien.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;
    private Set<UsersRoles> usersRoleses = new HashSet<UsersRoles>(0);

    public User() {
    }

    public User(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, List<GrantedAuthority> authorities) {
    }

    public User(final String username, final String password, final Boolean enabled,
                final Set<UsersRoles> usersRoleses) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.usersRoleses = usersRoleses;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    @Column(name = "username", unique = true, length = 45)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT(1)")
    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(final Boolean enabled) {
        this.enabled = enabled;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    public Set<UsersRoles> getUsersRoleses() {
        return this.usersRoleses;
    }

    public void setUsersRoleses(final Set<UsersRoles> usersRoleses) {
        this.usersRoleses = usersRoleses;
    }

    @Transient
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (UsersRoles usersRoles : this.usersRoleses) {
            authorities.add(new SimpleGrantedAuthority(usersRoles.getRole().getName()));
        }
        return authorities;
    }
}
