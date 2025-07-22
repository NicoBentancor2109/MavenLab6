package com.maven6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OnSiteCourseTest {

    @Test
    void testRoomAssignment() {
        OnSiteCourse onSiteCourse = new OnSiteCourse("Testing", 40, "Profesor A", "Sala 25", 30);
        
        // Verifica que el aula se asigne correctamente
        assertNotNull(onSiteCourse.getRoom(), "El aula no debe ser nula.");
        assertEquals("Sala 25", onSiteCourse.getRoom(), "El aula debería ser Sala 25.");
    }

    @Test
    void testMaxQuotaAssignment() {
        OnSiteCourse onSiteCourse = new OnSiteCourse("Java Avanzado", 30, "Profesor B", "Sala 21", 25);
        
        // Verifica que el cupo máximo se asigne correctamente
        assertTrue(onSiteCourse.getMaxQuota() >= 0, "El cupo máximo no debe ser negativo.");
        assertEquals(25, onSiteCourse.getMaxQuota(), "El cupo máximo debería ser 20.");
    }

    @Test
    void testShowInformation() {
        OnSiteCourse onSiteCourse = new OnSiteCourse("Java Script", 35, "Profesor C", "Sala 28", 20);
        String expected = "[On-Site] Course: Java Script, Duration: 35 hours, Professor: Profesor C - Room: Sala 28 - Max Quota: 20";
        
        // Verifica que la información mostrada no sea nula
        assertNotNull(onSiteCourse.showInformation(), "La información no debe ser nula.");
        
        // Verifica que el formato de showInformation() contenga toda la información correctamente
        assertEquals(expected, onSiteCourse.showInformation(), "El formato de showInformation() es incorrecto.");
    }
}
