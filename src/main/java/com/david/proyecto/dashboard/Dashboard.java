/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.david.proyecto.dashboard;

import com.david.proyecto.modelo.Tarea;
import com.david.proyecto.servicio.InterfazServicioTarea;
import com.david.proyecto.servicio.ImplemenServicio;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
/**
 * Dashboard principal para la gestión de tareas académicas.
 * Permite interactuar con el usuario mediante una interfaz de consola.
 */
/**
 *
 * @author WILLIANS
 */
public class Dashboard {
 private final InterfazServicioTarea servicio;
    private final Scanner scanner;
    private final DateTimeFormatter dateFormatter;

    public Dashboard() {
        this.servicio = new ImplemenServicio();
        this.scanner = new Scanner(System.in);
        this.dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        mostrarBienvenida();
        cargarDatosIniciales();
    }

    /**
     * Muestra el mensaje de bienvenida y estado inicial del sistema
     */
    private void mostrarBienvenida() {
        System.out.println("===========================================");
        System.out.println("  DASHBOARD DE GESTIÓN DE TAREAS ACADÉMICAS");
        System.out.println("===========================================");
        System.out.println("Sistema creado por: David García");
        System.out.println("Curso: Programación Orientada a Objetos");
        System.out.println("Versión: 1.0");
        System.out.println("\nEstado: Sistema inicializado correctamente");
        System.out.println("===========================================");
    }

    /**
     * Carga datos iniciales de ejemplo para demostración
     */
    private void cargarDatosIniciales() {
        servicio.agregarTarea(new Tarea("T1", "Proyecto POO", "Programación", 
                LocalDate.now().plusDays(7), 5));
        servicio.agregarTarea(new Tarea("T2", "Investigación BD", "Bases de Datos", 
                LocalDate.now().plusDays(3), 4));
    }

    /**
     * Inicia el dashboard mostrando el menú principal
     */
    public void iniciar() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEntero("Seleccione una opción: ");
            
            switch(opcion) {
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    listarTareas();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while(opcion != 3);
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\nMENÚ PRINCIPAL - GESTIÓN DE TAREAS");
        System.out.println("1. Agregar nueva tarea");
        System.out.println("2. Listar todas las tareas");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Listar tareas pendientes");
        System.out.println("5. Listar tareas por materia");
        System.out.println("6. Salir");
    }

    private void agregarTarea() {
        System.out.println("\nAGREGAR NUEVA TAREA");
        
        String id = leerCadena("ID de la tarea (ej. T1): ");
        String nombre = leerCadena("Nombre de la tarea: ");
        String materia = leerCadena("Materia: ");
        LocalDate fechaEntrega = leerFecha("Fecha de entrega (dd/mm/aaaa): ");
        int prioridad = leerEntero("Prioridad (1-5): ");
        
        Tarea nuevaTarea = new Tarea(id, nombre, materia, fechaEntrega, prioridad);
        servicio.agregarTarea(nuevaTarea);
        
        System.out.println("¡Tarea agregada exitosamente!");
    }

    private void listarTareas() {
        List<Tarea> tareas = servicio.obtenerTodasTareas();
        mostrarListadoTareas("LISTADO COMPLETO DE TAREAS", tareas);
    }

    // Resto de métodos implementados de forma similar...
    
    private int leerEntero(String mensaje) {
        while(true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido");
            }
        }
    }
    
    private String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    
    private LocalDate leerFecha(String mensaje) {
        while(true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(scanner.nextLine(), dateFormatter);
            } catch(Exception e) {
                System.out.println("Formato inválido. Use dd/mm/aaaa");
            }
        }
    }
    
    private void mostrarListadoTareas(String titulo, List<Tarea> tareas) {
        if(tareas.isEmpty()) {
            System.out.println("No hay tareas para mostrar");
            return;
        }
        
        System.out.println("\n" + titulo);
        System.out.println("----------------------------------------");
        tareas.forEach(System.out::println);
        System.out.println("Total: " + tareas.size() + " tareas");
    }
}
