package com.aluracursos.screenmatch.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import org.springframework.stereotype.Component;

@Component
public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "http://www.omdbapi.com/?t="; // final indica que es una constante
    private final String API_KEY = "&apikey=517489d5";
    ConvierteDatos conversor = new ConvierteDatos();

    public void muestraElMenu(){
        System.out.println("Porfavor escribe el nombre de la serie que deseas buscar");
        // Busca los datos generales de las series
        String nombreSerie = teclado.nextLine();
		String json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
		DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println(datos);

        // Busca los datos de todas las temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
		for (int i = 1; i <= datos.totalTemporadas(); i++) {
			json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
			DatosTemporadas datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
			temporadas.add(datosTemporadas);
		}
        // temporadas.forEach(System.out::println);

        // Mostrar solo el titulo de los episodios para las temporadas
        
        // for (int i = 0; i < datos.totalTemporadas(); i++) {
        //     List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
        //     for (int j = 0; j < episodiosTemporada.size(); j++) {
        //         System.out.println(episodiosTemporada.get(j).titulo());
        //     }
        // }
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        // Convertir todas las informaciones a una lista de tipo DatosEpisodio

        List<DatosEpisodio> datosEpisodios = temporadas.stream()
            .flatMap(t -> t.episodios().stream())
            .collect(Collectors.toList());

        // Top 5 episodios 
        System.out.println("Top 5 episodios");
        datosEpisodios.stream()
            .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
            .peek(e -> System.out.println("Primer filtro (N/A)" + e))
            .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
            .peek(e -> System.out.println("Segundo filtro oredenación (M>m)" + e))
            .map(e -> e.titulo().toUpperCase())
            .peek(e -> System.out.println("Tercer filtro MAYUSCULAS (m>M)" + e))
            .limit(5)
            .forEach(System.out::println);

        // Convirtiendo los datos a una lista de tipo Episodio
        List<Episodio> episodios = temporadas.stream()
            .flatMap(t -> t.episodios().stream()
                .map(d -> new Episodio(t.numero(), d)))
            .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        // Busqueda de episodios apartir de x año
        System.out.println("Indica el año apartir del cual deseas ver los episodios");
        int fecha = teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodios.stream()
            .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
            .forEach(e -> System.out.println(
                "Temporada " + e.getTemporada() + 
                    " Episodio " + e.getTitulo() +
                    " Fecha de lanzamiento " + e.getFechaDeLanzamiento().format(dtf)
            ));
    }
}
