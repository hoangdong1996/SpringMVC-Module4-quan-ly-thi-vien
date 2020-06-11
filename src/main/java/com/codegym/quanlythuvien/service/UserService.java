package com.codegym.quanlythuvien.service;

import com.codegym.quanlythuvien.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    User findByUserName(String username);
}
