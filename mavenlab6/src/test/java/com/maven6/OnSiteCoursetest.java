package com.maven6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class)
public class OnSiteCoursetest {

    @BeforeAll
    static void initAll() {
        System.out.println("Iniciando todos los tests de OnSiteCourse...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Finalizando todos los tests de OnSiteCourse...");
    }

    @BeforeEach
    void init() {
        System.out.println("Iniciando un nuevo test...");
        new OnSiteCourse("Java Script", 35, "Profesor C", "Sala 28", 20);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Limpiando la instancia de OnSiteCourse...");
    }

    @Test
    @Order(1)
    @DisplayName("Test de Asignación de Aula")
    void testRoomAssignment() {
        OnSiteCourse onSiteCourse = new OnSiteCourse("Testing", 40, "Profesor A", "Sala 25", 30);
        
        // Verifica que el aula se asigne correctamente
        assertNotNull(onSiteCourse.getRoom(), "El aula no debe ser nula.");
        assertEquals("Sala 25", onSiteCourse.getRoom(), "El aula debería ser Sala 25.");
    }

   @ParameterizedTest
    @EmptySource
    @Order(2)
    @DisplayName("Test con valores vacíos para el título del curso")
    void testEmptyTitle(String title) {
        OnSiteCourse onSiteCourse = new OnSiteCourse(title, 35, "Profesor C", "Sala 28", 20);
        assertEquals("Unassigned", onSiteCourse.getProfessor(), "El profesor debería ser 'Unassigned' si el título está vacío.");
    }

    @Test
    @Order(3)
    @DisplayName("Test de showInformation")
    void testShowInformation() {
        OnSiteCourse onSiteCourse = new OnSiteCourse("Java Script", 35, "Profesor C", "Sala 28", 20);
        String expected = "[On-Site] Course: Java Script, Duration: 35 hours, Professor: Profesor C - Room: Sala 28 - Max Quota: 20";
        
        // Verifica que la información mostrada no sea nula
        assertNotNull(onSiteCourse.showInformation(), "La información no debe ser nula.");
        
        // Verifica que el formato de showInformation() contenga toda la información correctamente
        assertEquals(expected, onSiteCourse.showInformation(), "El formato de showInformation() es incorrecto.");
    }
}