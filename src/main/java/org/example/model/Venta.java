package org.example.model;

public class Venta {
    private int id;
    private String fecha;
    private int total;
    private int id_empleado;

    public Venta(){};

    public Venta(int id, String fecha, int id_empleado, int total) {
        this.id =id;
        this.fecha = fecha;
        this.id_empleado = id_empleado;
        this.total = total;
    }
    public Venta( String fecha, int id_empleado, int total) {
        this.fecha = fecha;
        this.id_empleado = id_empleado;
        this.total = total;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
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
        return "Venta{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", total=" + total +
                ", id_empleado=" + id_empleado +
                '}';
    }
}
