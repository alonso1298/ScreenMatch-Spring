package com.aluracursos.screenmatch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI = new ConsumoAPI();
		String json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=malcolm+in+the+middle&apikey=517489d5");
		// String json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=malcolm+in+the+middle&apikey=517489d5");
		// System.out.println(json);
		ConvierteDatos conversor = new ConvierteDatos();
		DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println(datos);
		json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=malcolm+in+the+middle&Season=1&episode=1&apikey=517489d5");
		DatosEpisodio episodios = conversor.obtenerDatos(json, DatosEpisodio.class);
		System.out.println(episodios);

		List<DatosTemporadas> temporadas = new ArrayList<>();

		for (int i = 1; i <= datos.totalTemporadas(); i++) {
			json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=malcolm+in+the+middle&Season="+i+"&apikey=517489d5");
			DatosTemporadas datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
			temporadas.add(datosTemporadas);
		}

		temporadas.forEach(System.out::println);
	}
}
