package org.example.dao;

import org.example.database.DataBaseConnection;
import org.example.model.Venta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VentasDAO {

    public void instertarVenta(Venta venta){
        String sql = "INSERT INTO Ventas(fecha, total, id_empleado)";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, venta.getFecha());
            ps.setInt(2, venta.getTotal());
            ps.setInt(3, venta.getId_empleado());

            ps.executeUpdate();
            ps.close();

            System.out.println("Nueva venta!");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Venta> consultarVentas(){
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM Ventas";

        try {
            Connection conn = DataBaseConnection.conectar();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                Venta venta = new Venta(
                        rs.getInt("id"),
                        rs.getString("fecha"),
                        rs.getInt("total"),
                        rs.getInt("id_empleado")
                );
                ventas.add(venta);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return ventas;
    }

    public void actualizarVenta(int id, String fecha, int total, int id_empleado){
        String sql = "UPDATE Ventas SET fecha = ?, total = ?, id_empleado = ? WHERE id = ?";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, fecha);
            ps.setInt(2, total);
            ps.setInt(3, id_empleado);
            ps.setInt(4, id);

            ps.executeUpdate();
            ps.close();

            System.out.println("Proveedor actualizado");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void eliminarVenta(int id){
        String sql = "DELETE FROM  Ventas WHERE id =?";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();

            System.out.println("Venta eliminada!");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
