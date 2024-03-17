package com.utad.Simpsons.service;

import com.utad.Simpsons.model.Simpson;
import com.utad.Simpsons.repository.SimpsonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SimpsonService {
    private final SimpsonRepository simpsonRepository;

    @Autowired
    public SimpsonService(SimpsonRepository simpsonRepository) {
        this.simpsonRepository = simpsonRepository;
    }
    public List<Simpson> getCocktails() {
        return simpsonRepository.findAll();
    }

    public Simpson getSimpsonById(Long id) {
        return simpsonRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Simpson not found with id: " + id));
    }

    public Simpson save(Simpson simpson){
        return simpsonRepository.save(simpson);
    }

    public Simpson createSimpson(String name, int age, String personality) {
        Simpson newSimpson = new Simpson();
        newSimpson.setName(name);
        newSimpson.setAge(age);
        newSimpson.setPersonality(personality);
        return simpsonRepository.save(newSimpson);
    }
    public Simpson updateSimpson(Long id, Simpson newSimpsonData) {
        Simpson existingSimpson = getSimpsonById(id);
        existingSimpson.setName(newSimpsonData.getName());
        existingSimpson.setAge(newSimpsonData.getAge());
        return simpsonRepository.save(existingSimpson);
    }

    public void deleteCocktail(Long id) {
        Simpson simpson = getSimpsonById(id);
        simpsonRepository.delete(simpson);
    }

}
