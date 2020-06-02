package com.codegym.quanlythuvien;

import com.codegym.quanlythuvien.model.User;
import com.codegym.quanlythuvien.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class QuanLyThuVienApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuanLyThuVienApplication.class, args);
    }

}
