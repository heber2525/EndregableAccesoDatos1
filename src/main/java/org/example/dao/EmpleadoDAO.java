package org.example.dao;

import org.example.database.DataBaseConnection;
import org.example.model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public void insertarEmpleado(Empleado empleado){
        String sql = "INSERT INTO empleados(nombre, puesto) VALUES (?,?)";
        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getPuesto());

            ps.executeUpdate();
            ps.close();

            System.out.println("Nuevo empleado insertado");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Empleado> consultarEmpleados(){
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";

        try {
            Connection conn = DataBaseConnection.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Empleado empleado = new Empleado(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("puesto")
                );
                empleados.add(empleado);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return empleados;
    }
    public void actualizarEmpleado(int id, String nombre, String puesto ){
        String sql = "UPDATE empleados SET nombre = ?, puesto = ? WHERE id = ?";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);


            ps.setString(1, nombre);
            ps.setString(2,puesto);
            ps.setInt(3, id);

            ps.executeUpdate();
            ps.close();

            System.out.println("Empleado actualizado");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void eliminarEmpleado(int id){
        String sql = "DELETE FROM empleados WHERE id = ?";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
