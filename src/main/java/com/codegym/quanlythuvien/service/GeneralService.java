package com.codegym.quanlythuvien.service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface GeneralService<E> {
    Optional<E> findById(Long id);

    List<E> findAll();

    void save(E e);

    void remove(Long id);
}
