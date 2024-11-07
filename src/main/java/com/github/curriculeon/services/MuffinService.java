package com.github.curriculeon.services;

import com.github.curriculeon.models.Muffin;
import com.github.curriculeon.repositories.MuffinRepository;
import org.springframework.stereotype.Service;

@Service
public class MuffinService {
    private MuffinRepository repository;

    public MuffinService(MuffinRepository repository) {
        this.repository = repository;
    }

    public Iterable<Muffin> index() {
        return repository.findAll();
    }

    public Muffin show(Long id) {
        return repository.findById(id).get();
    }

    public Muffin create(Muffin baker) {
        return repository.save(baker);
    }

    public Muffin update(Long id, Muffin newMuffinData) {
        Muffin originalMuffin = repository.findById(id).get();
        originalMuffin.setFlavor(newMuffinData.getFlavor());
        return repository.save(originalMuffin);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
