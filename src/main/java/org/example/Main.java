package org.example;

import org.example.dao.*;
import org.example.model.Empleado;
import org.example.model.Proveedor;
import org.example.service.*;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        VentasDAO ventasDAO = new VentasDAO();

        CategoriaService categoriaService = new CategoriaService();
        EmpleadoService empleadoService = new EmpleadoService();
        ProductoService productoService = new ProductoService();
        ProveedoresService proveedoresService = new ProveedoresService();
        VentasService ventasService = new VentasService();

        int opcion;

        do {
            System.out.println("1.----Gestionar Empleados----");
            System.out.println("2.----Gestionar Productos----");
            System.out.println("3.----Gestionar Proveedores----");
            System.out.println("4.----Gestionar Categorías----");
            System.out.println("5.----Gestionar Ventas----");
            System.out.println("0.Salir");
            opcion = sc.nextInt();
            sc.nextLine();

                switch (opcion) {
                    case 1:
                        empleadoService.mostrarMenuEmpleado(sc, empleadoDAO);
                        break;
                    case 2:
                        productoService.mostrarMenuProducto(sc, productoDAO, categoriaDAO, proveedorDAO);
                        break;
                    case 3:
                        proveedoresService.mostrarMenuProveedorer(sc, proveedorDAO);
                        break;
                    case 4:
                        categoriaService.mostrarMenuCategoria(sc, categoriaDAO);
                        break;
                    case 5:
                        ventasService.mostrarMenuVentas(sc, ventasDAO, empleadoDAO);
                        break;
                    default:
                        System.out.println("Opción no válida, por favor intenta de nuevo.");
                        break;
                }
        }while (opcion != 0);










    }
}