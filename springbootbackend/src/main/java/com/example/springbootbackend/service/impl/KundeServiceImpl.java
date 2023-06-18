package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Kunde;
import com.example.springbootbackend.repository.KundeRepository;
import com.example.springbootbackend.service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KundeServiceImpl implements KundeService {

    private KundeRepository kundeRepository;

    @Autowired
    public KundeServiceImpl(KundeRepository kundeRepository) {
        this.kundeRepository = kundeRepository;
    }

    @Override
    public Kunde saveKunde(Kunde theKunde) {
        return kundeRepository.save(theKunde);
    }

    @Override
    public List<Kunde> getAllKunde() {
        return kundeRepository.findAll();
    }

    @Override
    public Kunde getKundeById(long theId) {
        Optional<Kunde> kunde = kundeRepository.findById(theId);

        if (kunde.isPresent()) {
            return kunde.get();
        } else {
            throw new ResourceNotFoundException("Kunde", "Id" , theId);
        }
    }

    @Override
    public Kunde updateKunde(Kunde theKunde, long theId) {
        Kunde existingKunde = kundeRepository.findById(theId).orElseThrow(
                () -> new ResourceNotFoundException("Kunde", "Id" ,theId)
        );
        existingKunde.setFirstName(theKunde.getFirstName());
        existingKunde.setLastName(theKunde.getLastName());
        existingKunde.setAdresse(theKunde.getAdresse());
        existingKunde.setTelNummer(theKunde.getTelNummer());

        kundeRepository.save(existingKunde);
        return existingKunde;
    }

    @Override
    public void deleteKunde(long theId) {
        kundeRepository.findById(theId).orElseThrow(
                () -> new ResourceNotFoundException("Kunde", "Id", theId)
        );

        kundeRepository.deleteById(theId);

    }
}
