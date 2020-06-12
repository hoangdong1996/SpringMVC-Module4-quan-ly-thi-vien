package com.codegym.quanlythuvien.service.impl;

import com.codegym.quanlythuvien.model.Library;
import com.codegym.quanlythuvien.repository.LibraryRepository;
import com.codegym.quanlythuvien.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public List<Library> findAll() {
        return (List<Library>) libraryRepository.findAll();
    }

    @Override
    public Optional<Library> findById(Long id) {
        return libraryRepository.findById(id);
    }

    @Override
    public void save(Library library) {
        libraryRepository.save(library);
    }

    @Override
    public void remove(Long id) {
        libraryRepository.deleteById(id);
    }


    @Override
    public List<Library> findAllByName(String name) {
        return libraryRepository.findAllByNameContaining(name);
    }

    @Override
    public long countLibrary() {
        return libraryRepository.count();
    }

}
