package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dao.PatronRepository;
import com.example.librarymanagementsystem.model.Patron;
import com.example.librarymanagementsystem.service.interfaces.PatronService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronServiceImpl implements PatronService {
    private PatronRepository patronRepository;

    public PatronServiceImpl(PatronRepository thePatronRepository) {
        this.patronRepository = thePatronRepository;
    }

    @Override
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @Override
    public Patron getPatronById(int id) {
        Optional<Patron> result = patronRepository.findById(id);

        Patron dbPatron = null;
        if (result.isPresent()){
            dbPatron=result.get();
        }else{
            throw new RuntimeException("Could not find patron by Id: " + id);
        }

        return dbPatron;
    }
    @Override
    @Transactional
    public Patron savePatron(Patron thePatron) {
        return patronRepository.save(thePatron);
    }

    @Override
    @Transactional
    public void deletePatron(int id) {
        patronRepository.deleteById(id);
    }
}
