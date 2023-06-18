package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Mitarbeiter;

import java.util.List;

public interface MitarbeiterService {
    Mitarbeiter saveMitarbeiter(Mitarbeiter mitarbeiter);
    List<Mitarbeiter> getAllMitarbeiter();
    Mitarbeiter getMitarbeiterById(long id);
    Mitarbeiter updateMitarbeiter(Mitarbeiter mitarbeiter, long id);
    void deleteMitarbeiter(long id);
}
