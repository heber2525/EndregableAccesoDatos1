package org.example.service;

import org.example.dao.CategoriaDAO;
import org.example.dao.ProductoDAO;
import org.example.dao.ProveedorDAO;
import org.example.model.Categoria;
import org.example.model.Producto;
import org.example.model.Proveedor;

import java.util.List;
import java.util.Scanner;

public class ProductoService {

    public void mostrarMenuProducto(Scanner sc, ProductoDAO productoDao, CategoriaDAO categoriaDao, ProveedorDAO proveedorDao){

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
                    System.out.println("Que precio");
                    double precio = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Que cantidad");
                    int stock = sc.nextInt();
                    sc.nextLine();
                    List <Categoria> categorias = categoriaDao.consultarCategorias();
                    if(categorias.isEmpty()){
                        System.out.println("Primero debe cargar una categoria");
                        return;
                    }
                    System.out.println("Estas son las categorias disponibles escoge el ID");
                    categorias.forEach(System.out::println);
                    int id_categoria = sc.nextInt();
                    sc.nextLine();
                    List <Proveedor> proveedor = proveedorDao.consultarProveedores();
                    if(proveedor.isEmpty()){
                        System.out.println("No hay ningun proveedor cargado");
                        return;
                    }
                    System.out.println("Escoge el ID del proveedor");
                    proveedor.forEach(System.out::println);
                    int id_proveedor = sc.nextInt();
                    sc.nextLine();
                    productoDao.insertarProducto(new Producto(nombre, precio, stock, id_categoria, id_proveedor));
                    break;
                case 3:
                    List <Producto> productoActualizar = productoDao.consultarProductos();
                    List <Categoria> categoriaActualizar = categoriaDao.consultarCategorias();
                    if(productoActualizar.isEmpty()){
                        System.out.println("No hay ningun producto disponible");
                        return;
                    }
                    System.out.println("Estos son los productos disponibles escriba el ID");
                    productoActualizar.forEach(System.out::println);
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa el nombre del producto");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese el nuevo precio");
                    precio = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Cuanto es el nuevo stock");
                    stock = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Estas son las categorias escoge el ID");
                    categoriaActualizar.forEach(System.out::println);
                    id_categoria = sc.nextInt();
                    sc.nextLine();
                    System.out.println(("Estos son los proveedores escoge el ID"));
                    id_proveedor = sc.nextInt();
                    sc.nextLine();
                    productoDao.actualizarProducto(id,nombre, precio, stock, id_categoria, id_proveedor);
                    break;
                case 4:
                    List <Producto> productoEliminar = productoDao.consultarProductos();
                    if(productoEliminar.isEmpty()){
                        System.out.println("No hay ningun producto disponible");
                        return;
                    }
                    System.out.println("Estos son los productos disponibles escoja el ID");
                    productoEliminar.forEach(System.out::println);
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    productoDao.eliminarProducto(idEliminar);
                    break;
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
                    break;
            }

        }while (opcion !=0);


    }
}
