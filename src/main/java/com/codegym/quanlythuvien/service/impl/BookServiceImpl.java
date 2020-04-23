package com.codegym.quanlythuvien.service.impl;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Library;
import com.codegym.quanlythuvien.repository.BookRepository;
import com.codegym.quanlythuvien.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

//    @Override
//    public List<Book> findAllByLibraries(Library library) {
//        return bookRepository.findAllByLibraries(library);
//    }
}
