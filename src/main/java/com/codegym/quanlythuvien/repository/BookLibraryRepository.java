package com.codegym.quanlythuvien.repository;

import com.codegym.quanlythuvien.model.BookInLibrary.BookLibrary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface BookLibraryRepository extends CrudRepository<BookLibrary, Long> {
}
