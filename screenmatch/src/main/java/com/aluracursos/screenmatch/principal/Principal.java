package com.aluracursos.screenmatch.principal;

import java.util.Scanner;

import com.aluracursos.screenmatch.service.ConsumoAPI;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "http://www.omdbapi.com/?t="; // final indica que es una constante
    private final String API_KEY = "&apikey=517489d5";

    public void muestraElMenu(){
        System.out.println("Porfavor escribe el nombre de la serie que deseas buscar");
        String nombreSerie = teclado.nextLine();
		String json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
    }

}
