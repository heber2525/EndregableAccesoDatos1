package org.example.service;

import org.example.dao.EmpleadoDAO;
import org.example.model.Empleado;
import java.util.List;
import java.util.Scanner;

public class EmpleadoService {

    public void mostrarMenuEmpleado(Scanner sc, EmpleadoDAO empleadoDao) {
        int opcion;

        do {
            System.out.println("\n--------- Gestión de Empleados ---------");
            System.out.println("1. Listar Empleados");
            System.out.println("2. Insertar Empleado");
            System.out.println("3. Actualizar Empleado");
            System.out.println("4. Eliminar Empleado");
            System.out.println("0. Volver al Menú Principal");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    List<Empleado> empleados = empleadoDao.consultarEmpleados();
                    empleados.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Nombre del empleado: ");
                    String nombre = sc.nextLine();
                    System.out.println("Puesto:");
                    String puesto = sc.nextLine();
                    empleadoDao.insertarEmpleado(new Empleado(nombre, puesto));
                    break;
                case 3:
                    System.out.println("ID del empleado a actualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nuevo nombre:");
                    String nuevoNombre = sc.nextLine();
                    System.out.println("Nuevo puesto:");
                    String nuevoPuesto = sc.nextLine();
                    empleadoDao.actualizarEmpleado(id, nuevoNombre, nuevoPuesto);
                    break;
                case 4:
                    System.out.println("ID del empleado a eliminar:");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    empleadoDao.eliminarEmpleado(idEliminar);
                    break;
            }
        } while (opcion != 0);
    }
}

