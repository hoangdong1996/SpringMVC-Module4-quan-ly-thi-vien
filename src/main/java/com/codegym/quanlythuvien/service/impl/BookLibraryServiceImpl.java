package com.codegym.quanlythuvien.service.impl;

import com.codegym.quanlythuvien.model.BookInLibrary.BookLibrary;
import com.codegym.quanlythuvien.repository.BookLibraryRepository;
import com.codegym.quanlythuvien.service.BookLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookLibraryServiceImpl implements BookLibraryService {
    @Autowired
    BookLibraryRepository bookLibraryRepository;

    @Override
    public Optional<BookLibrary> findById(Long id) {
        return bookLibraryRepository.findById(id);
    }

    @Override
    public List<BookLibrary> findAll() {
        return (List<BookLibrary>) bookLibraryRepository.findAll();
    }

    @Override
    public void save(BookLibrary bookLibrary) {
        bookLibraryRepository.save(bookLibrary);
    }

    @Override
    public void remove(Long id) {
        bookLibraryRepository.deleteById(id);
    }
}
