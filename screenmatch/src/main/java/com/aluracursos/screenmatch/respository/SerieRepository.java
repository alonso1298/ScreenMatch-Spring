package com.aluracursos.screenmatch.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluracursos.screenmatch.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    
}
