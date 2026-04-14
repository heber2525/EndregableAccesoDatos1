package org.example.dao;

import org.example.database.DataBaseConnection;
import org.example.model.Empleado;
import org.example.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public void insertarProducto(Producto producto){
        String sql = "INSERT INTO Productos(nombre, stock, id_categoria, id_proveedor) VALUES (?,?,?,?)";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getStock());
            ps.setInt(3, producto.getId_categoria());
            ps.setInt(4, producto.getId_proveedor());

            ps.executeUpdate();
            ps.close();

            System.out.println("Producto agregado");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Producto> consultarProducto(){
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Productos";

        try {
            Connection conn = DataBaseConnection.conectar();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
                Producto producto = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("stock"),
                        rs.getInt(" id_categoria"),
                        rs.getInt(" id_proveedor")
                );
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return productos;

    }
    public void actualizarProducto(int id, String nombre, int stock, int id_categoria, int id_proveedor){
        String sql = "UPDATE Productos SET nombre = ?, stock = ?, id_categoria = ?, id_proveedor = ? WHERE id = ?";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setInt(2, stock);
            ps.setInt(3, id_categoria);
            ps.setInt(4, id_proveedor);
            ps.setInt(5, id);

            ps.executeUpdate();
            ps.close();

            System.out.println("Producto actualizado");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void eliminarProducto(int id){
        String sql = "DELETE FROM Producto WHERE id = ?";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();

            System.out.println("Producto eliminado!");


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
