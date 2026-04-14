package org.example.model;

public class Proveedor {
    private int id;
    private String nombre;
    private String contacto;
    private String suministra;

    public Proveedor(){};

    public Proveedor(int id, String nombre, String conctacto, String suministra) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = conctacto;
        this.suministra = suministra;
    }

    public Proveedor(String nombre, String conctacto, String suministra) {
        this.nombre = nombre;
        this.contacto = conctacto;
        this.suministra = suministra;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String conctacto) {
        this.contacto = conctacto;
    }

    public String getSuministra() {
        return suministra;
    }

    public void setSuministra(String suministra) {
        this.suministra = suministra;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", conctacto='" + contacto + '\'' +
                ", suministra='" + suministra + '\'' +
                '}';
    }
}
