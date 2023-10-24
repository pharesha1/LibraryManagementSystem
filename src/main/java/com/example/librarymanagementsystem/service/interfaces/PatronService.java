package com.example.librarymanagementsystem.service.interfaces;

import com.example.librarymanagementsystem.model.Patron;

import java.util.List;

public interface PatronService {
    List<Patron> getAllPatrons();
    Patron getPatronById(int id);
    Patron savePatron(Patron thePatron);
    void deletePatron(int id);
}
