package org.example.model;

public class Venta {
    private int id;
    private String fecha;
    private double total;
    private int id_empleado;

    public Venta(){};

    public Venta(int id, String fecha, double total, int id_empleado) {
        this.id =id;
        this.fecha = fecha;
        this.total = total;
        this.id_empleado = id_empleado;

    }
    public Venta( String fecha, double total, int id_empleado) {
        this.fecha = fecha;
        this.total = total;
        this.id_empleado = id_empleado;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Fecha: " + fecha + " - Total: " + total + "€ - Emp: " + id_empleado;
    }
}
