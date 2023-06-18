package com.example.springbootbackend.controller;

import com.example.springbootbackend.model.Mitarbeiter;
import com.example.springbootbackend.service.MitarbeiterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mitarbeiter")
public class MitarbeiterController {
    private MitarbeiterService mitarbeiterService;

    public MitarbeiterController(MitarbeiterService mitarbeiterService) {
        super();
        this.mitarbeiterService = mitarbeiterService;
    }

    @PostMapping()
    public ResponseEntity<Mitarbeiter> saveMitarbeiter(@RequestBody Mitarbeiter mitarbeiter){
        return new ResponseEntity<Mitarbeiter>(mitarbeiterService.saveMitarbeiter(mitarbeiter), HttpStatus.CREATED);

    }

    @GetMapping
    public List<Mitarbeiter> getAllMitarbeiter(){
        return mitarbeiterService.getAllMitarbeiter();

    }
    @GetMapping("{id}")
    public ResponseEntity<Mitarbeiter> getMitarbeiterById(@PathVariable("id") long mitarbeiterId){
        return new ResponseEntity<Mitarbeiter>(mitarbeiterService.getMitarbeiterById(mitarbeiterId), HttpStatus.OK);

    }
    @PutMapping("{id}")
    public ResponseEntity<Mitarbeiter> updateMitarbeiter(@PathVariable("id") long id, @RequestBody Mitarbeiter mitarbeiter){
        return new ResponseEntity<Mitarbeiter>(mitarbeiterService.updateMitarbeiter(mitarbeiter,id), HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMitarbeiter(@PathVariable("id") long id){
        mitarbeiterService.deleteMitarbeiter(id);

        return new ResponseEntity<String>("Mitarbeiter hat erfolgreich gelöscht!.", HttpStatus.OK);

    }







}
