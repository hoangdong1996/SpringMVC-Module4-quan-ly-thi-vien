package com.codegym.quanlythuvien.repository;

import com.codegym.quanlythuvien.model.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Long> {
    List<Library> findAllByNameContaining(String name);
    long count();
}
