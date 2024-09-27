package com.github.curriculeon.controllers;

import com.github.curriculeon.services.BakerService;
import com.github.curriculeon.models.Baker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bakers")

public class BakerController {
   // private BakerService service;


    private final BakerService service;
    public BakerController(BakerService service)
    {
        this.service = service;
    }

    @RequestMapping(value = "/test-create", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Baker>> testcreate() {
        return new ResponseEntity<>(service.testCreate(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Baker>> index()
    {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    //public ResponseEntity<Baker> show(Long id) {
    @GetMapping(value = "/{id}")
    public ResponseEntity<Baker> show(@PathVariable Long id)
    {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    //public ResponseEntity<Baker> create(Baker baker) {
    @PostMapping(value = "/")
    public ResponseEntity<Baker> create(@RequestBody Baker baker)
    {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Baker> update(Long id, Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    //public ResponseEntity<Boolean> destroy(Long id) {
    @DeleteMapping( value = "/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id)
    {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
