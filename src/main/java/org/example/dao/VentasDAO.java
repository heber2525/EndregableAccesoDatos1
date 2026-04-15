package org.example.dao;

import org.example.database.DataBaseConnection;
import org.example.model.Venta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VentasDAO {

    public void insertarVenta(Venta venta){
        String sql = "INSERT INTO Ventas(fecha, total, id_empleado) VALUES (?, ?, ?)";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, venta.getFecha());
            ps.setDouble(2, venta.getTotal());
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
                        rs.getInt("id_venta"),
                        rs.getString("fecha"),
                        rs.getDouble("total"),
                        rs.getInt("id_empleado")
                );
                ventas.add(venta);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return ventas;
    }

    public void actualizarVenta(int id, String fecha, double total, int id_empleado){
        String sql = "UPDATE ventas SET fecha = ?, total = ?, id_empleado = ? WHERE id_venta = ?";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, fecha);
            ps.setDouble(2, total);
            ps.setInt(3, id_empleado);
            ps.setInt(4, id);

            ps.executeUpdate();
            ps.close();

            System.out.println("Venta actualizada");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void eliminarVenta(int id){
        String sql = "DELETE FROM ventas WHERE id_venta =?";

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
    public List <Venta> consultarVentasEmpleados(){
        List<Venta> rankingVentas = new ArrayList<>();
        String sql = "SELECT e.nombre, SUM(v.total) AS total_ventas FROM ventas v" +
                " JOIN empleados e ON v.id_empleado = e.id_empleado" +
                " GROUP BY e.nombre " +
                " ORDER BY total_ventas DESC";

        try {
            Connection conn = DataBaseConnection.conectar();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                Venta venta = new Venta();
                String nombre = rs.getString("nombre");
                double total = rs.getDouble("total_ventas");

                venta.setNombreEmpleado(nombre);
                venta.setTotal(total);

                rankingVentas.add(venta);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return rankingVentas;

    }
}
