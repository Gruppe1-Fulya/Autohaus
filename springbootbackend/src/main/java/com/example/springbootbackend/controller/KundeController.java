package com.example.springbootbackend.controller;

import com.example.springbootbackend.model.Kunde;
import com.example.springbootbackend.model.Mitarbeiter;
import com.example.springbootbackend.service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/kunde")
public class KundeController {

    private KundeService kundeService;

    @Autowired
    public KundeController(KundeService kundeService) {
        this.kundeService = kundeService;
    }

    @GetMapping
    public List<Kunde> getAllKunde() {
        return kundeService.getAllKunde();
    }

    @GetMapping("{id}")
    public ResponseEntity<Kunde> getKundeById(@PathVariable("id") long kundeId) {
        return new ResponseEntity<Kunde>(kundeService.getKundeById(kundeId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Kunde> updateKunde(@PathVariable("id") long id, @RequestBody Kunde kunde){
        return new ResponseEntity<Kunde>(kundeService.updateKunde(kunde,id), HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<Kunde> saveKunde(@RequestBody Kunde kunde){
        return new ResponseEntity<Kunde>(kundeService.saveKunde(kunde), HttpStatus.CREATED);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteKunde(@PathVariable("id") long id){
        kundeService.deleteKunde(id);

        return new ResponseEntity<String>("Kunde hat erfolgreich gelöscht!.", HttpStatus.OK);

    }

}
