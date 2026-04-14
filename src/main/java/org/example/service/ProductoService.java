package org.example.service;

import org.example.dao.ProductoDAO;
import org.example.model.Producto;

import java.util.List;
import java.util.Scanner;

public class ProductoService {

    public void mostrarMenuProducto(Scanner sc, ProductoDAO productoDao){

        int opcion;

        do {
            System.out.println("\n--------- Gestión de Productos ---------");
            System.out.println("1. Listar Productos");
            System.out.println("2. Insertar Producto");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("0. Volver al Menú Principal");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    List<Producto> productos = productoDao.consultarProductos();
                    productos.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Nombre del producto");
                    String nombre = sc.nextLine();
                    System.out.println("Que cantidad");
                    int stock = sc.nextInt();
                    sc.nextLine();
                    System.out.println("A que categoría pertenece");
                    int id_categoria = sc.nextInt();
                    sc.nextLine();
                    System.out.println("A que proveedor pertenece");
                    int id_proveedor = sc.nextInt();
                    sc.nextLine();
                    productoDao.insertarProducto(new Producto(nombre, stock, id_categoria, id_proveedor));
                    break;
                case 3:
                    System.out.println("ID del Producto que quieres acualizar");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa el nombre del producto");
                    nombre = sc.nextLine();
                    System.out.println("Cuanto es el nuevo stock");
                    stock = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Cual es el id de la categoria");
                    id_categoria = sc.nextInt();
                    sc.nextLine();
                    System.out.println(("Cual es el id del proveedor"));
                    id_proveedor = sc.nextInt();
                    sc.nextLine();
                    productoDao.actualizarProducto(id,nombre, stock, id_categoria, id_proveedor);
                    break;
                case 4:
                    System.out.println("Id del producto a eliminar");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    productoDao.eliminarProducto(idEliminar);
                    break;
            }

        }while (opcion !=0);


    }
}
