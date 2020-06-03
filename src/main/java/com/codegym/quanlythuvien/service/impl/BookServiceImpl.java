package com.codegym.quanlythuvien.service.impl;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Library;
import com.codegym.quanlythuvien.repository.BookRepository;
import com.codegym.quanlythuvien.repository.LibraryRepository;
import com.codegym.quanlythuvien.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryRepository libraryRepository;

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

    @Override
    public List<Book> findAllByLibrary(Optional<Library> library) {
        return bookRepository.findAllByLibrary(library);
    }

    @Override
    public List<Book> findAllByBorrowDateNotNull() {
        return bookRepository.findAllByBorrowDateNotNull();
    }

    @Override
    public List<Book> findALlByBorrowDateNotNullAndLibrary(Optional<Library> library) {
        return bookRepository.findAllByBorrowDateNotNullAndLibrary(library);
    }

    @Override
    public Long countBook() {
        return bookRepository.count();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> findAllByNameContaining(String name, Pageable pageable) {
        return bookRepository.findAllByNameContaining(name, pageable);
    }


//    @Override
//    public List<Book> findAllByLibraries(Library library) {
//        return bookRepository.findAllByLibraries(library);
//    }
}
