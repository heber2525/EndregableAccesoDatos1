package org.example.dao;

import org.example.database.DataBaseConnection;
import org.example.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public void insertarProducto(Producto producto){
        String sql = "INSERT INTO productos(nombre_producto, precio, stock, id_categoria, id_proveedor) VALUES (?,?,?,?,?)";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setInt(4, producto.getId_categoria());
            ps.setInt(5, producto.getId_proveedor());

            ps.executeUpdate();
            ps.close();

            System.out.println("Producto agregado");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Producto> consultarProductos(){
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try {
            Connection conn = DataBaseConnection.conectar();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
                Producto producto = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre_producto"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getInt("id_categoria"),
                        rs.getInt("id_proveedor")
                );
                productos.add(producto);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return productos;

    }
    public void actualizarProducto(int id, String nombre, double precio, int stock, int id_categoria, int id_proveedor){
        String sql = "UPDATE productos SET nombre_producto = ?, precio = ?, stock = ?, id_categoria = ?, id_proveedor = ? WHERE id_producto = ?";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, stock);
            ps.setInt(4, id_categoria);
            ps.setInt(5, id_proveedor);
            ps.setInt(6, id);

            ps.executeUpdate();
            ps.close();

            System.out.println("Producto actualizado");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void eliminarProducto(int id){
        String sql = "DELETE FROM productos WHERE id_producto = ?";

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
