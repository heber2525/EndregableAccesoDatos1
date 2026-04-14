package org.example.dao;

import org.example.database.DataBaseConnection;
import org.example.model.Categoria;
import org.example.model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public void insertarCategoria(Categoria categoria){
        String sql = "INSERT INTO categorias(nombre_categoria) VALUES(?)";

        try {
            Connection conn = DataBaseConnection.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, categoria.getNombre());
            ps.executeUpdate();
            ps.close();

            System.out.println("Categoria añadida");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Categoria> consultarCategorias(){
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categorias";

        try {
            Connection conn = DataBaseConnection.conectar();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
             Categoria categoria = new Categoria(
                     rs.getInt("id_categoria"),
                     rs.getString("nombre_categoria")
             );
             categorias.add(categoria);

            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return categorias;
    }

    public void actualizarCategoria(int id, String nombre){
        String sql = "UPDATE categorias SET nombre_categoria = ? WHERE id_categoria = ?";

        try {
            Connection conn = DataBaseConnection.conectar();
           PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setInt(2, id);

            ps.executeUpdate();
            ps.close();

            System.out.println("Categoria actualizada");


        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
    public void eliminarCategoria(int id ){
        String sql = "DELETE FROM categorias WHERE id_categoria = ?";

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
