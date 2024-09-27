package com.github.curriculeon.controllers;

import com.github.curriculeon.models.Muffin;
import com.github.curriculeon.services.MuffinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/muffins")
public class MuffinController {
   // private MuffinService service;
   private final MuffinService service;

    public MuffinController(MuffinService service)
    {
        this.service = service;
    }


    @GetMapping("/")
    public ResponseEntity<Iterable<Muffin>> index()
    {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    //public ResponseEntity<Muffin> show(Long id) {
    @GetMapping(value = "/{id}")
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    //public ResponseEntity<Muffin> create(Muffin baker) {
    @PostMapping(value = "/")
    public ResponseEntity<Muffin> create(@RequestBody Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Muffin> update(Long id, Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    //public ResponseEntity<Boolean> destroy(Long id) {
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
