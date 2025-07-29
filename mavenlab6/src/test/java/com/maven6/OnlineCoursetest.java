package com.maven6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlineCoursetest {

    private OnlineCourse onlineCourse;

    @BeforeAll
    static void initAll() {
        System.out.println("Iniciando todos los tests de OnlineCourse...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Finalizando todos los tests de OnlineCourse...");
    }

    @BeforeEach
    void init() {
        System.out.println("Iniciando un nuevo test...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Limpiando la instancia de OnlineCourse...");
        onlineCourse = null;
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/OnlineCourse.csv", numLinesToSkip = 1)
    @DisplayName("Test de Asignación de Plataforma")
    void testPlatformAssignment(String title, int duration, String professor, String platform) {
        onlineCourse = new OnlineCourse(title, duration, professor, platform);
        assertNotNull(onlineCourse.getPlatform(), "La plataforma no debe ser nula.");
        assertTrue(platform.equals(onlineCourse.getPlatform()), "La plataforma debería ser " + platform + ".");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/OnlineCourse.csv", numLinesToSkip = 1)
    @DisplayName("Test de showInformation")
    void testShowInformation(String title, int duration, String professor, String platform) {
        onlineCourse = new OnlineCourse(title, duration, professor, platform);
        String expected = "[Online] Course: " + title + ", Duration: " + duration + " hours, Professor: " + professor + " - Platform: " + platform;
        assertNotNull(onlineCourse.showInformation(), "La información no debe ser nula.");
        
        // Verifica que el formato de showInformation() sea el correcto
        assertTrue(expected.equals(onlineCourse.showInformation()), "El formato de showInformation() es incorrecto.");
    }
}    

