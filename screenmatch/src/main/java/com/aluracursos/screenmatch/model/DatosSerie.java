package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Va a ignorar aquellos campos que no mapeamos dentro de la clase
public record DatosSerie(
    @JsonAlias("Title") String titulo, // @JsonAlias("Title") espesifica que en la API viene como Title y solo permite leer 
    @JsonAlias("totalSeasons") Integer totalTemporadas, 
    @JsonAlias("imdbRating") String evaluacion)
    { 

}
