package com.codegym.quanlythuvien.service;

import com.codegym.quanlythuvien.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService extends UserDetailsService {
    Optional<User> findById(Long id);

    List<User> findAll();

    void save(User user);

    void remove(Long id);
}
