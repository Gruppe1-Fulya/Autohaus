package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Kunde;

import java.util.List;

public interface KundeService {

    Kunde saveKunde(Kunde theKunde);

    List<Kunde> getAllKunde();

    Kunde getKundeById(long theId);

    Kunde updateKunde(Kunde theKunde, long theId);

    void deleteKunde(long theId);
}
