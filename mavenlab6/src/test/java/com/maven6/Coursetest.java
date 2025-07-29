package com.maven6;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Coursetest {

    @BeforeAll
    static void initAll() {
        System.out.println("Iniciando todos los tests de Course...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Finalizando todos los tests de Course...");
    }

    @BeforeEach
    void init() {
        System.out.println("Iniciando un nuevo test...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Limpiando la instancia de Course...");
    }

    @Test
    @DisplayName("Test del Constructor con Profesor")
    void testConstructorWithProfessor() {
        Course course = new Course("Programación", 30, "Profesor A");
        
        // Verifica que el título se guarde correctamente
        assertEquals("Programación", course.getTitle(), "El título debería ser 'Programación'.");
        
        // Verifica que la duración se guarde correctamente
        assertEquals(30, course.getDuration(), "La duración debería ser 30 horas.");
        
        // Verifica que el profesor se guarde correctamente
        assertEquals("Profesor A", course.getProfessor(), "El profesor debería ser 'Profesor A'.");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/course.csv", numLinesToSkip = 1)
    @DisplayName("Test del Constructor sin Profesor")
    void testConstructorWithoutProfessor(String title, int duration) {
        Course course = new Course(title, duration);
        assertEquals("Unassigned", course.getProfessor(), "El profesor debería ser 'Unassigned'.");
    }

    @Test
    @DisplayName("Test de showInformation")
    void testShowInformation() {
        Course course = new Course("Programación", 30, "Profesor A");
        String expected = "Course: Programación, Duration: 30 hours, Professor: Profesor A";
        
        // Verifica que el método showInformation() devuelva el texto esperado
        assertEquals(expected, course.showInformation(), "El formato de showInformation() es incorrecto.");
    }
}