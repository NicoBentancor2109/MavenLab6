package com.maven6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CourseTest {

      @Test
    void testConstructorWithProfessor() {
        Course course = new Course("Programación", 30, "Profesor A");
        
        // Verifica que el título se guarde correctamente
        assertEquals("Programación", course.getTitle(), "El título debería ser 'Programación'.");
        
        // Verifica que la duración se guarde correctamente
        assertEquals(30, course.getDuration(), "La duración debería ser 30 horas.");
        
        // Verifica que el profesor se guarde correctamente
        assertEquals("Profesor A", course.getProfessor(), "El profesor debería ser 'Profesor A'.");
    }

    @Test
    void testConstructorWithoutProfessor() {
        Course course = new Course("Programación", 30);
        
        // Verifica que el título se guarde correctamente
        assertEquals("Programación", course.getTitle(), "El título debería ser 'Programación'.");
        
        // Verifica que la duración se guarde correctamente
        assertEquals(30, course.getDuration(), "La duración debería ser 30 horas.");
        
        // Verifica que el profesor sea 'Unassigned'
        assertEquals("Unassigned", course.getProfessor(), "El profesor debería ser 'Unassigned'.");
    }

    @Test
    void testShowInformation() {
        Course course = new Course("Programación", 30, "Profesor A");
        String expected = "Course: Programación, Duration: 30 hours, Professor: Profesor A";
        
        // Verifica que el método showInformation() devuelva el texto esperado
        assertEquals(expected, course.showInformation(), "El formato de showInformation() es incorrecto.");
    }
}