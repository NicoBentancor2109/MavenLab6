package com.maven6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OnlineCourseTest {

    @Test
    void testPlatformAssignment() {
        OnlineCourse onlineCourse = new OnlineCourse("Programación", 30, "Profesor A", "Bios");
        
        // Verifica que la plataforma no sea nula
        assertNotNull(onlineCourse.getPlatform(), "La plataforma no debe ser nula.");
        
        // Verifica que la plataforma sea la esperada
        assertTrue("Bios".equals(onlineCourse.getPlatform()), "La plataforma debería ser Bios.");
    }

    @Test
    void testShowInformation() {
        OnlineCourse onlineCourse = new OnlineCourse("Programación", 30, "Profesor A", "Bios");
        String expected = "[Online] Course: Programación, Duration: 30 hours, Professor: Profesor A - Platform: Bios";
        
        // Verifica que la información mostrada no sea nula
        assertNotNull(onlineCourse.showInformation(), "La información no debe ser nula.");
        
        // Verifica que el formato de showInformation() sea el correcto
        assertTrue(expected.equals(onlineCourse.showInformation()), "El formato de showInformation() es incorrecto.");
    }
}    

