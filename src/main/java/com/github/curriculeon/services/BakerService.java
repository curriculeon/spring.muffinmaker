package com.github.curriculeon.services;

import com.github.curriculeon.repositories.BakerRepository;
import com.github.curriculeon.models.Baker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BakerService {
    private BakerRepository repository;

    @Autowired
    public BakerService(BakerRepository repository) {
        this.repository = repository;
    }

    public Iterable<Baker> index() {
        return repository.findAll();
    }

    public Baker show(Long id) {
        return repository.findById(id).get();
    }

    public Baker create(Baker baker) {
        return repository.save(baker);
    }

    public Baker update(Long id, Baker newBakerData) {
        Baker originalBaker = repository.findById(id).get();
        originalBaker.setName(newBakerData.getName());
        originalBaker.setSpecialty(newBakerData.getSpecialty());
        return repository.save(originalBaker);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
