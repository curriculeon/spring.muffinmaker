package com.github.curriculeon.controllers;

import com.github.curriculeon.models.Muffin;
import com.github.curriculeon.services.MuffinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@RequestMapping(value = "/muffins")
@RestController
public class MuffinController {
    private MuffinService service;
    @Autowired
    public MuffinController(MuffinService service) {
        this.service = service;
    }
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<Muffin> create(@RequestBody Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public ResponseEntity<Muffin> update(@PathVariable Long id, Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }
    @RequestMapping(value = "destroy",method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
