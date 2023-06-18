package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Mitarbeiter;
import com.example.springbootbackend.repository.MitarbeiterRepository;
import com.example.springbootbackend.service.MitarbeiterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MitarbeiterServiceImpl implements MitarbeiterService {
    private MitarbeiterRepository mitarbeiterRepository;

    public MitarbeiterServiceImpl(MitarbeiterRepository mitarbeiterRepository) {
        super();
        this.mitarbeiterRepository = mitarbeiterRepository;
    }

    @Override
    public Mitarbeiter saveMitarbeiter(Mitarbeiter mitarbeiter) {

        return mitarbeiterRepository.save(mitarbeiter);
    }

    @Override
    public List<Mitarbeiter> getAllMitarbeiter() {
        return mitarbeiterRepository.findAll();
    }

    @Override
    public Mitarbeiter getMitarbeiterById(long id) {
        Optional<Mitarbeiter> mitarbeiter = mitarbeiterRepository.findById(id);
        if(mitarbeiter.isPresent()){
            return mitarbeiter.get();
        } else {
            throw new ResourceNotFoundException("Mitarbeiter", "Id", id);
        }
    }

    @Override
    public Mitarbeiter updateMitarbeiter(Mitarbeiter mitarbeiter, long id) {
        Mitarbeiter existingMitarbeiter = mitarbeiterRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Mitarbeiter", "Id", id));

        existingMitarbeiter.setFirstName(mitarbeiter.getFirstName());
        existingMitarbeiter.setLastName(mitarbeiter.getLastName());
        existingMitarbeiter.setPosition(mitarbeiter.getPosition());
        existingMitarbeiter.setLetzteVerkauf(mitarbeiter.getLetzteVerkauf());

        mitarbeiterRepository.save(existingMitarbeiter);
        return existingMitarbeiter;
    }

    @Override
    public void deleteMitarbeiter(long id) {
        mitarbeiterRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Mitarbeiter", "Id", id));

        mitarbeiterRepository.deleteById(id);
    }


}
