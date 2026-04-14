package org.example;

import org.example.dao.EmpleadoDAO;
import org.example.model.Empleado;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EmpleadoDAO empleadoDao = new EmpleadoDAO();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("---------Menú Cafeteria---------");
            System.out.println("1.Insertar Empleado");
            System.out.println("2.Listar Empleados");
            System.out.println("3.Actualizar Empleados");
            System.out.println("4.Eliminar Empleado");
            System.out.println("0.Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    List<Empleado> empleados = empleadoDao.consultarEmpleados();
                    empleados.forEach((Empleado empleado) -> System.out.println(empleado));
                    break;
                case 2:
                    System.out.println("Ingresa el nombre del empleado");
                    String nombre = sc.nextLine();
                    System.out.println("Ingresa el puesto que ocupa el empleado");
                    String puesto = sc.nextLine();
                    empleadoDao.insertarEmpleado(new Empleado(nombre, puesto));
                    break;
                case 3:
                    System.out.println("Ingresa el id del empleado");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Cual es el nuevo nombre");
                    String nombreEmpleado = sc.next();
                    System.out.println("Cual es el nuevo puesto del empleado");
                    String nuevoPuesto = sc.nextLine();
                    empleadoDao.actualizarEmpleado(id, nombreEmpleado, nuevoPuesto);
                    break;
                case 4:
                    System.out.println("Ingresa el id del empleado que desea eliminar");
                    int empleadoEliminar = sc.nextInt();
                    sc.nextLine();
                    empleadoDao.eliminarEmpleado(empleadoEliminar);
                    break;
            }

        }while (opcion != 0 );


    }
}