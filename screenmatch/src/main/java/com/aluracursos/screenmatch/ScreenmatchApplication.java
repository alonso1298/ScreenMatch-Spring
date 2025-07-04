package com.aluracursos.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aluracursos.screenmatch.service.ConsumoAPI;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI = new ConsumoAPI();
		// String json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=malcolm+in+the+middle&apikey=517489d5");
		String json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=malcolm+in+the+middle&apikey=517489d5");
		
		System.out.println(json);
	}

}
