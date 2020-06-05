package com.codegym.quanlythuvien.service.impl;

import com.codegym.quanlythuvien.model.Librarian;
import com.codegym.quanlythuvien.repository.LibrarianRepository;
import com.codegym.quanlythuvien.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianServiceImpl implements LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;

    @Override
    public Optional<Librarian> findById(Long id) {
        return librarianRepository.findById(id);
    }

    @Override
    public List<Librarian> findAll() {
        return (List<Librarian>) librarianRepository.findAll();
    }

    @Override
    public void save(Librarian librarian) {
        librarianRepository.save(librarian);
    }

    @Override
    public void remove(Long id) {
        librarianRepository.deleteById(id);
    }
}
