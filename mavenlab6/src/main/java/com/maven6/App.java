package com.maven6;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int cantidad = solicitarCantidadCursos();
        Course[] cursos = new Course[cantidad];

        for (int i = 0; i < cantidad; i++) {
            cursos[i] = registrarCurso(i + 1);
        }

        mostrarInformacionCursos(cursos);
        scanner.close();
    }

    private static int solicitarCantidadCursos() {
        System.out.print("Ingrese la cantidad de cursos a registrar: ");
        return scanner.nextInt();
    }

    private static Course registrarCurso(int numeroCurso) {
        scanner.nextLine();  
        System.out.println("Curso #" + numeroCurso);
        
        System.out.print("Tipo (Online o On Site): ");
        String tipo = scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Duración (hs): ");
        int duracion = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Profesor (opcional): ");
        String profesor = scanner.nextLine();

        if (tipo.equalsIgnoreCase("Online")) {
            System.out.print("Plataforma: ");
            String plataforma = scanner.nextLine();
            return new OnlineCourse(titulo, duracion, profesor, plataforma);
        } else if (tipo.equalsIgnoreCase("On Site")) {
            System.out.print("Aula: ");
            String aula = scanner.nextLine();
            System.out.print("Cupo máximo: ");
            int cupoMaximo = scanner.nextInt();
            scanner.nextLine(); 
            return new OnSiteCourse(titulo, duracion, profesor, aula, cupoMaximo);
        } else {
            System.out.println("Tipo de curso no válido. Se registrará como Online por defecto.");
            return new OnlineCourse(titulo, duracion, profesor, "No especificada");
        }
    }

    private static void mostrarInformacionCursos(Course[] cursos) {
        System.out.println("--- Información de cursos registrados ---");
        for (Course curso : cursos) {
            System.out.println(curso.showInformation());
        }
    }
}
