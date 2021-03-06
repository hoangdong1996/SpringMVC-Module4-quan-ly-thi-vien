package com.codegym.quanlythuvien.service.impl;

import com.codegym.quanlythuvien.model.Role;
import com.codegym.quanlythuvien.model.User;
import com.codegym.quanlythuvien.repository.UserRepository;
import com.codegym.quanlythuvien.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Override
//    public User save(User user) {
//        User user1 = new User();
//        user1.setFirstName(user.getFirstName());
//        user1.setLastName(user.getLastName());
//        user1.setEmail(user.getEmail());
//        user1.setPassword(passwordEncoder.encode(user.getPassword()));
//        user1.setRoles(Arrays.asList(new Role("ROLE_USER")));
//        return userRepository.save(user1);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new org.springframework.security.core.userdetails.User
                (username, user.getPassword(), enabled,accountNonExpired, credentialsNonExpired, accountNonLocked,user.getAuthorities());
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}
