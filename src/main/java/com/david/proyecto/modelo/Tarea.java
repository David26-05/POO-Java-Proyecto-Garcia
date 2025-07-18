/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.david.proyecto.modelo;
import java.time.LocalDate;

/**
 * Representa una tarea académica con sus atributos básicos
 */
/**
 *
 * @author WILLIANS
 */
public class Tarea {
     private String id;
    private String nombre;
    private String materia;
    private LocalDate fechaEntrega;
    private boolean completada;
    private int prioridad; // 1-5 donde 5 es máxima prioridad

    public Tarea(String id, String nombre, String materia, LocalDate fechaEntrega, int prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.materia = materia;
        this.fechaEntrega = fechaEntrega;
        this.prioridad = prioridad;
        this.completada = false;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMateria() {
        return materia;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void marcarCompletada() {
        this.completada = true;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s | Entrega: %s | Prioridad: %d | %s",
                id, nombre, materia, fechaEntrega, prioridad,
                completada ? "COMPLETADA" : "PENDIENTE");
    }
}
