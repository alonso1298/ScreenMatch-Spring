package com.aluracursos.screenmatch.principal;

import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);

    public void muestraElMenu(){
        System.out.println("Porfavor escribe el nombre de la serie que deseas buscar");
        String nombreSerie = teclado.nextLine();
    }

}
