package com.aluracursos.screenmatch.model;

public enum Categoria {
    ACCION("Action"),
    ROMACE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    CRIMEN("Crime");

    private String categoriaOMDB;

    Categoria (String categoriaOmdb){
        this.categoriaOMDB = categoriaOmdb;
    }
}
