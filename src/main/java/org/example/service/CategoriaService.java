package org.example.service;

import org.example.dao.CategoriaDAO;
import org.example.model.Categoria;

import java.util.List;
import java.util.Scanner;

public class CategoriaService {

    public void mostrarMenuCategoria(Scanner sc, CategoriaDAO categoriaDao){

        int opcion;

        do {
            System.out.println("\n--------- Gestión de Categorias ---------");
            System.out.println("1. Listar Categorias");
            System.out.println("2. Insertar Categoria");
            System.out.println("3. Actualizar Categoria");
            System.out.println("4. Eliminar Categoria");
            System.out.println("0. Volver al Menú Principal");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    List<Categoria> categorias = categoriaDao.consultarCategorias();
                    categorias.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Nombre de la categoria: ");
                    String nombre = sc.nextLine();
                    categoriaDao.insertarCategoria(new Categoria(nombre));
                    break;
                case 3:
                    System.out.println("ID de la categoria a actualizar");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el nuevo nombre");
                    nombre = sc.nextLine();
                    categoriaDao.actualizarCategoria(id, nombre);
                    break;
                case 4:
                    System.out.println("ID de la categoria a eliminar");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    categoriaDao.eliminarCategoria(idEliminar);
                    break;
            }

        }while (opcion !=0);

    }
}
