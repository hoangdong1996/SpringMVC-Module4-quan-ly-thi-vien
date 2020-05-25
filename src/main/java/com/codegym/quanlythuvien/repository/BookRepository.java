package com.codegym.quanlythuvien.repository;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAllByLibrary(Optional<Library> library);
    List<Book> findAllByBorrowDateNotNull();
    long count();
}
