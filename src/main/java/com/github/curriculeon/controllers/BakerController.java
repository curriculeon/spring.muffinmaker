package com.github.curriculeon.controllers;

import com.github.curriculeon.services.BakerService;
import com.github.curriculeon.models.Baker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@RequestMapping(value = "/bakers" )
@RestController
public class BakerController {
    private BakerService service;
    @Autowired
    public BakerController(BakerService service) {
        this.service = service;
    }
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Baker> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Baker> update(@PathVariable Long id, Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }
    @RequestMapping(value = "destroy", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
