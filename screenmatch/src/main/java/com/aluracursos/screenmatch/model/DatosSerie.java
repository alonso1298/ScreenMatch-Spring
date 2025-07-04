package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosSerie(
    @JsonAlias("Title") String titulo, // @JsonAlias("Title") espesifica que en la API viene como Title y solo permite leer 
    @JsonAlias("otalSeasons") Integer totalTemporadas, 
    @JsonAlias("imdbRating") String evaluacion)
    { 

}
