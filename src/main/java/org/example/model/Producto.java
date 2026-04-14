package org.example.model;

public class Producto {
    private int id;
    private String nombre;
    private int stock;
    private int id_categoria;
    private int id_proveedor;

    public Producto(){};

    public Producto(int id, String nombre, int stock, int id_categoria, int id_proveedor) {
        this.id =id;
        this.nombre = nombre;
        this.stock = stock;
        this.id_categoria = id_categoria;
        this.id_proveedor = id_proveedor;

    }
    public Producto(String nombre, int stock, int id_categoria, int id_proveedor) {

        this.nombre = nombre;
        this.stock = stock;
        this.id_categoria = id_categoria;
        this.id_proveedor = id_proveedor;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String producto) {
        this.nombre = producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }


    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", producto='" + nombre + '\'' +
                ", stock=" + stock +
                ", id_categoria=" + id_categoria +
                ", id_proveedor=" + id_proveedor +
                '}';
    }
}
