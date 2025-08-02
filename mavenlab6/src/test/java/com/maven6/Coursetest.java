package com.maven6;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

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
     @Tag("smoke")
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
    @Tag("smoke")
    void testConstructorWithoutProfessor(String title, int duration) {
        Course course = new Course(title, duration);
        assertEquals("Unassigned", course.getProfessor(), "El profesor debería ser 'Unassigned'.");
    }

    @Test
    @DisplayName("Test de showInformation")
    @Tag("regression")
    void testShowInformation() {
        Course course = new Course("Programación", 30, "Profesor A");
        String expected = "Course: Programación, Duration: 30 hours, Professor: Profesor A";
        
        // Verifica que el método showInformation() devuelva el texto esperado
        assertEquals(expected, course.showInformation(), "El formato de showInformation() es incorrecto.");
    }
        
    @ParameterizedTest
    @MethodSource("provideCoursetest")  // Usar MethodSource
    @DisplayName("Test de showInformation con múltiples datos")
    @Tag("regression")  // Agregar etiqueta para pruebas de regresión
   void testShowInformationWithMethodSource(String title, int duration, String professor, String expected) {
        Course course = new Course(title, duration, professor);
        assertEquals(expected, course.showInformation(), "El formato de showInformation() es incorrecto.");
    }

    // Método que proporciona los datos para el test
    static Stream<Arguments> provideCoursetest() {
        return Stream.of(
            Arguments.of("Programación", 30, "Profesor A", "Course: Programación, Duration: 30 hours, Professor: Profesor A"),
            Arguments.of("Testing", 20, null, "Course: Testing, Duration: 20 hours, Professor: Unassigned")
        );
    }
}
