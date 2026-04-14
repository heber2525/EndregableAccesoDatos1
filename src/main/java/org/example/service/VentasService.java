package org.example.service;

import org.example.dao.EmpleadoDAO;
import org.example.dao.VentasDAO;
import org.example.model.Empleado;
import org.example.model.Venta;

import java.util.List;
import java.util.Scanner;

public class VentasService {

    public void mostrarMenuVentas(Scanner sc, VentasDAO ventasDao, EmpleadoDAO empleadoDAO){

        int opcion;

        do {
            System.out.println("\n--------- Gestión de Ventas ---------");
            System.out.println("1. Listar Ventas");
            System.out.println("2. Insertar Ventas");
            System.out.println("3. Actualizar Ventas");
            System.out.println("4. Eliminar Ventas");
            System.out.println("0. Volver al Menú Principal");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    List<Venta> ventas = ventasDao.consultarVentas();
                    ventas.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Ingresa la fecha de la venta");
                    String fecha = sc.nextLine();
                    System.out.println("Ingresa el total de la venta");
                    double total = sc.nextDouble();
                    sc.nextLine();
                    List <Empleado> empleados = empleadoDAO.consultarEmpleados();
                    if(empleados.isEmpty()){
                        System.out.println("No hay empleados");
                        return;
                    }
                    System.out.println("Ingresa el ID del empleado");
                    empleados.forEach(System.out::println);
                    int idEmpleado = sc.nextInt();
                    sc.nextLine();
                    ventasDao.instertarVenta(new Venta(fecha, total, idEmpleado));
                    break;
                case 3:
                    List <Venta> ventaActualizar = ventasDao.consultarVentas();
                    if(ventaActualizar.isEmpty()){
                        System.out.println("No hay ninguna venta");
                        return;
                    }
                    System.out.println("Ingrese el ID de la venta a actualizar");
                    ventaActualizar.forEach(System.out::println);
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa la nueva fecha");
                    fecha = sc.nextLine();
                    System.out.println("Ingresa el nuevo total");
                    total = sc.nextDouble();
                    sc.nextLine();
                    List <Empleado> empleadoActualizar = empleadoDAO.consultarEmpleados();
                    if(empleadoActualizar.isEmpty()){
                        System.out.println("No hay ningun empleado");
                        return;
                    }
                    System.out.println("Ingresa el id del empleado que realizo la venta");
                    empleadoActualizar.forEach(System.out::println);
                    idEmpleado = sc.nextInt();
                    sc.nextLine();
                    ventasDao.actualizarVenta(id, fecha, total, idEmpleado);
                    break;
                case 4:
                    List <Venta> ventaEliminar = ventasDao.consultarVentas();
                    if(ventaEliminar.isEmpty()){
                        System.out.println("No hay ninguna venta");
                        return;
                    }
                    System.out.println("Ingresa el id de la venta a eliminar");
                    ventaEliminar.forEach(System.out::println);
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    ventasDao.eliminarVenta(idEliminar);
                    break;
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
                    break;
            }

        }while (opcion != 0);

    }


}
