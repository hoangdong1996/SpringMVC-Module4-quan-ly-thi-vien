package com.codegym.quanlythuvien.fomatter;

import com.codegym.quanlythuvien.model.Category;
import com.codegym.quanlythuvien.model.Library;
import com.codegym.quanlythuvien.service.LibrarianService;
import com.codegym.quanlythuvien.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class LibraryFormatter implements Formatter<Optional<Library>> {
    private LibraryService libraryService;

    @Autowired
    public LibraryFormatter(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Override
    public Optional<Library> parse(String text, Locale locale) throws ParseException {
        return libraryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Optional<Library> object, Locale locale) {
        return "[" + object.get().getId() + ", " + object.get().getName() + "]";
    }
}
