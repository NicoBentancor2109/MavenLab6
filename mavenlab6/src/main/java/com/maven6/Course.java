package com.maven6;
public class Course {
    private String title;
    private int duration;
    private String professor;

    // Constructor con todos los datos
    public Course(String title, int duration, String professor) {
        this.title = title;
        this.duration = duration;
        this.professor = professor != null && !professor.isEmpty() ? professor : "Unassigned";
    }

    // Constructor solo con título y duración
    public Course(String title, int duration) {
        this(title, duration, null);
    }

    // Métodos getters y setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration >= 0) {
            this.duration = duration;
        } else {
            throw new IllegalArgumentException("La duración no puede ser negativa.");
        }
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor != null && !professor.isEmpty() ? professor : "Unassigned";
    }

    public String showInformation() {
        return "Course: " + title + ", Duration: " + duration + " hours, Professor: " + professor;
    }
}
    
