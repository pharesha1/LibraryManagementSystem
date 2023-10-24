package com.example.librarymanagementsystem.dao;

import com.example.librarymanagementsystem.model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron, Integer> {

}
