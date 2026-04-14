package org.example.service;

import org.example.dao.ProveedorDAO;
import org.example.model.Proveedor;

import java.util.List;
import java.util.Scanner;

public class ProveedoresService {
    public void mostrarMenuProveedorer(Scanner sc, ProveedorDAO proveedorDAO){

        int opcion;

        do {
            System.out.println("\n--------- Gestión de Proveedores ---------");
            System.out.println("1. Listar Proveedores");
            System.out.println("2. Insertar Proveedor");
            System.out.println("3. Actualizar Proveedor");
            System.out.println("4. Eliminar Proveedor");
            System.out.println("0. Volver al Menú Principal");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    List<Proveedor> proveedores = proveedorDAO.consultarProveedores();
                    proveedores.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Nombre del proveedor");
                    String nombre = sc.nextLine();
                    System.out.println("Contacto del proveedor");
                    String contacto = sc.nextLine();
                    System.out.println("Que producto suministra");
                    String suministra = sc.nextLine();
                    proveedorDAO.instertarProveedor(new Proveedor(nombre, contacto, suministra));
                    break;
                case 3:
                    System.out.println("ID del proveedor a actualizar:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa nombre");
                    nombre = sc.nextLine();
                    System.out.println("Ingresa contacto");
                    contacto = sc.nextLine();
                    System.out.println("Que producto suministra");
                    suministra = sc.nextLine();
                    proveedorDAO.actualizarProveedor(id, nombre, contacto, suministra);
                    break;
                case 4:
                    System.out.println("ID del proveedor a eliminar");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    proveedorDAO.eliminarProveedor(idEliminar);
                    break;
            }
        }while (opcion != 0);



    }
}
