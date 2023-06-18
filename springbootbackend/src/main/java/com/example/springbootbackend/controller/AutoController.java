package com.example.springbootbackend.controller;


import com.example.springbootbackend.model.Auto;
import com.example.springbootbackend.service.AutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auto")
public class AutoController {

    private AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public List<Auto> getAllAuto(){
        return autoService.getAllAuto();
    }

    @GetMapping("{id}")
    public ResponseEntity<Auto> getAutoById(@PathVariable("id") long theId) {
        return new ResponseEntity<Auto>(autoService.getAutoById(theId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Auto> saveAuto(@RequestBody Auto auto) {
        return new ResponseEntity<Auto>(autoService.saveAuto(auto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Auto> updateAuto(@PathVariable("id") long id, @RequestBody Auto auto) {
        return new ResponseEntity<Auto>(autoService.updateAuto(auto, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAuto(@PathVariable("id") long id){
        autoService.deleteAutoById(id);
        return new ResponseEntity<String>("Auto hat erfolgreich geloscht!." , HttpStatus.OK);
    }
}
