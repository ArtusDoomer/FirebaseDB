package com.vcornejo.firebasedb;

public class MainModel {
    String Nombre, Marca, Imagen;
    int Año, Precio;

    public MainModel() {
    }

    public MainModel(String nombre, String marca, String imagen, int año, int precio) {
        Nombre = nombre;
        Marca = marca;
        Imagen = imagen;
        Año = año;
        Precio = precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int año) {
        Año = año;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }
}
