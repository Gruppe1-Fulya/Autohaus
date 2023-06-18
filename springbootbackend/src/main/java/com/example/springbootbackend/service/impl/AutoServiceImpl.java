package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Auto;
import com.example.springbootbackend.repository.AutoRepository;
import com.example.springbootbackend.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoServiceImpl implements AutoService {

    private AutoRepository autoRepository;

    @Autowired
    public AutoServiceImpl(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public List<Auto> getAllAuto() {
        return autoRepository.findAll();
    }

    @Override
    public Auto getAutoById(long theId) {
        Optional<Auto> auto = autoRepository.findById(theId);
        if (auto.isPresent()){
            return auto.get();
        } else {
            throw new ResourceNotFoundException("Auto", "Id", theId);
        }

    }

    // ?????? Buradan emin degilim ne yapabiliriz.
    // Yapmak istedigim sey marka ve model bilgileri girilerek
    // bi arac listesi cikartmak.
    @Override
    public List<Auto> getAutoByMarkeModel(String marke, String model) {

        return null;
    }

    @Override
    public Auto saveAuto(Auto theAuto) {
        return autoRepository.save(theAuto);
    }

    @Override
    public Auto updateAuto(Auto theAuto, long theId) {
        Auto existingAuto = autoRepository.findById(theId).orElseThrow(
                () -> new ResourceNotFoundException("Auto", "Id", theId)
        );

        existingAuto.setMarke(theAuto.getMarke());
        existingAuto.setModell(theAuto.getModell());
        existingAuto.setZustand(theAuto.getModell());

        autoRepository.save(existingAuto);
        return existingAuto;
    }

    @Override
    public void deleteAutoById(long theId) {
        autoRepository.findById(theId).orElseThrow(
                () -> new ResourceNotFoundException("Auto", "Id", theId)
        );
        autoRepository.deleteById(theId);
    }
}
