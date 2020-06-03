package com.codegym.quanlythuvien.service;

import com.codegym.quanlythuvien.model.Library;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LibraryService extends GeneralService<Library> {
    List<Library> findAllByName(String name);
}
