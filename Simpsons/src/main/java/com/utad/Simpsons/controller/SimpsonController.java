package com.utad.Simpsons.controller;

import com.utad.Simpsons.model.Simpson;
import com.utad.Simpsons.service.SimpsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/simpsons")
public class SimpsonController {

    private final SimpsonService simpsonService;

    @Autowired
    public SimpsonController(SimpsonService simpsonService) {
        this.simpsonService = simpsonService;
    }

    @GetMapping
    public ResponseEntity<List<Simpson>> getAll() {
        List<Simpson> list = simpsonService.getCocktails();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Simpson> getOne(@PathVariable Long id) {
       Simpson simpson = simpsonService.getSimpsonById(id);
        return new ResponseEntity<>(simpson, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Simpson> createSimpson(@RequestBody Simpson simpson) {
        Simpson createdSimpson = simpsonService.save(simpson);
        return ResponseEntity.ok(createdSimpson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Simpson> updateCocktail(@PathVariable Long id, @RequestBody Simpson simpson) {
        Simpson updatedCocktail = simpsonService.updateSimpson(id, simpson);
        return new ResponseEntity<>(updatedCocktail, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCocktail(@PathVariable Long id) {
        simpsonService.deleteCocktail(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
