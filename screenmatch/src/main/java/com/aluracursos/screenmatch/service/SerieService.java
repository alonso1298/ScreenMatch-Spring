package com.aluracursos.screenmatch.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.respository.SerieRepository;

@Service
public class SerieService {
    @Autowired
    private SerieRepository repository;
    
    public List<SerieDTO> obtenerTodasLasSeries(){
        return repository.findAll().stream()
            .map(s -> new SerieDTO(s.getTitulo(), s.getTotalTemporadas(), s.getEvaluacion(), s.getPoster(),
                s.getGenero(), s.getActores(), s.getSinopsis()))
            .collect(Collectors.toList());
    }
}