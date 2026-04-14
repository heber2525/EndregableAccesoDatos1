package org.example.service;

import org.example.dao.VentasDAO;
import org.example.model.Venta;

import java.util.List;
import java.util.Scanner;

public class VentasService {

    public void mostrarMenuVentas(Scanner sc, VentasDAO ventasDao){

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
                    int total = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa el id del empleado que realizo la venta");
                    int idEmpleado = sc.nextInt();
                    sc.nextLine();
                    ventasDao.instertarVenta(new Venta(fecha, total, idEmpleado));
                    break;
                case 3:
                    System.out.println("ID venta a actualizar");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa la nueva fecha");
                    fecha = sc.nextLine();
                    System.out.println("Ingresa el nuevo total");
                    total = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa el id del empleado que realizo la venta");
                    idEmpleado = sc.nextInt();
                    sc.nextLine();
                    ventasDao.actualizarVenta(id, fecha, total, idEmpleado);
                    break;
                case 4:
                    System.out.println("Ingresa el id de la venta a eliminar");
                    int idElliminar = sc.nextInt();
                    sc.nextLine();
                    ventasDao.eliminarVenta(idElliminar);
                    break;
            }

        }while (opcion != 0);

    }


}
