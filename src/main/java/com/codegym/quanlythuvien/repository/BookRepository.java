package com.codegym.quanlythuvien.repository;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Librarian;
import com.codegym.quanlythuvien.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    List<Book> findAllByLibrary(Optional<Library> library);

    List<Book> findAllByBorrowDateNotNull();

    List<Book> findAllByNameContainingAndLibrary(String name, Optional<Library> library);

    List<Book> findAllByBorrowDateNotNullAndLibrary(Optional<Library> library);

    List<Book> findAllByBorrowDateNull();

    Page<Book> findAllByNameContaining(String name, Pageable pageable);

    long count();
}
