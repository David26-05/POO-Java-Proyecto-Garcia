/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.david.proyecto.servicio;
import com.david.proyecto.modelo.Tarea;
import java.util.List;

/**
 * Contrato para el servicio de gestión de tareas
 */
/**
 *
 * @author WILLIANS
 */
public interface InterfazServicioTarea {
    void agregarTarea(Tarea tarea);
    void eliminarTarea(String id);
    void marcarTareaCompletada(String id);
    List<Tarea> obtenerTodasTareas();
    List<Tarea> obtenerTareasPorMateria(String materia);
    List<Tarea> obtenerTareasPendientes();
}
