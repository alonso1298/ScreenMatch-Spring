package com.aluracursos.screenmatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.respository.SerieRepository;

@RestController
public class SerieController {
    @Autowired
    private SerieRepository repository;

    @GetMapping("/series")
    public List<Serie> obtenerTodasLasSeries(){
        return repository.findAll();
    }
}
