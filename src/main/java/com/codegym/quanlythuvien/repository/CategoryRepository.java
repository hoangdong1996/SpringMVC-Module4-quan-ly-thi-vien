package com.codegym.quanlythuvien.repository;

import com.codegym.quanlythuvien.model.Book;
import com.codegym.quanlythuvien.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
