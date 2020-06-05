package com.codegym.quanlythuvien.service;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Librarian;
import com.codegym.quanlythuvien.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface BookService extends GeneralService<Book> {
    List<Book> findAllByLibrary(Optional<Library> library);

    List<Book> findAllByBorrowDateNotNull();

    List<Book> findALlByBorrowDateNotNullAndLibrary(Optional<Library> library);

    List<Book> findAllByNameAndLibrary(String name, Optional<Library> library);

    List<Book> findAllByBorrowDateNull();

    Long countBook();

    Page<Book> findAll(Pageable pageable);

    Page<Book> findAllByNameContaining(String name, Pageable pageable);
}
