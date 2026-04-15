package org.example.dao;

import org.example.database.DataBaseConnection;
import org.example.model.Proveedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    public void insertarProveedor(Proveedor proveedor){
        String sql = "INSERT INTO proveedores(nombre_proveedor, contacto, suministra) VALUES(?,?,?)";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getContacto());
            ps.setString(3, proveedor.getSuministra());

            ps.executeUpdate();
            ps.close();
            System.out.println("Proveedor insertado!");


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Proveedor> consultarProveedores(){
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";

        try {
            Connection conn = DataBaseConnection.conectar();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
                Proveedor proveedor = new Proveedor(
                        rs.getInt("id_proveedor"),
                        rs.getString("nombre_proveedor"),
                        rs.getString("contacto"),
                        rs.getString("suministra")
                );
                proveedores.add(proveedor);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return proveedores;

    }
    public void actualizarProveedor(int id, String nombre, String contacto, String suministtra){
        String sql = "UPDATE proveedores SET nombre_proveedor = ?, contacto = ?, suministra = ? WHERE id_proveedor = ?";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, contacto);
            ps.setString(3, suministtra);
            ps.setInt(4, id);

            ps.executeUpdate();
            ps.close();

            System.out.println("Proveedor actualizado!");

        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }
    public void eliminarProveedor(int id){
        String sql = "DELETE FROM proveedores WHERE id_proveedor = ?";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();

            System.out.println("Proveedor eliminado!");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
