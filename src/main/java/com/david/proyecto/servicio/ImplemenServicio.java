/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.david.proyecto.servicio;
import com.david.proyecto.modelo.Tarea;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación concreta del servicio de tareas académicas
 */
/**
 *
 * @author WILLIANS
 */
public class ImplemenServicio implements InterfazServicioTarea{
    private final List<Tarea> tareas = new ArrayList<>();

    @Override
    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    @Override
    public void eliminarTarea(String id) {
        tareas.removeIf(t -> t.getId().equals(id));
    }

    @Override
    public void marcarTareaCompletada(String id) {
        tareas.stream()
              .filter(t -> t.getId().equals(id))
              .findFirst()
              .ifPresent(Tarea::marcarCompletada);
    }

    @Override
    public List<Tarea> obtenerTodasTareas() {
        return new ArrayList<>(tareas);
    }

    @Override
    public List<Tarea> obtenerTareasPorMateria(String materia) {
        return tareas.stream()
                     .filter(t -> t.getMateria().equalsIgnoreCase(materia))
                     .collect(Collectors.toList());
    }

    @Override
    public List<Tarea> obtenerTareasPendientes() {
        return tareas.stream()
                     .filter(t -> !t.isCompletada())
                     .collect(Collectors.toList());
    }
}
