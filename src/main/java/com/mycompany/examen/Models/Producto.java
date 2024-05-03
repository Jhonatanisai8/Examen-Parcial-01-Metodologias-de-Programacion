package com.mycompany.examen.Models;

public class Producto {

    private int codigo;
    private String nombre;
    private String categoria;
    private float precio;
    private int stock;

    public Producto() {

    }

    public Producto(int codigo, String nombre, String categoria, float precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float stockValorado() {
        return this.precio * stock;
    }

    public String estadoStock() {
        String estado = "";
        if (stock >= 0 && stock < 100) {
            estado = "Escazes de Stock";
        }

        if (stock >= 100 && stock < 500) {
            estado = "Bajo Nivel";
        }

        if (stock >= 500 && stock < 1000) {
            estado = "Sufiente";
        }

        if (stock >= 1000) {
            estado = "Sobre Nivel";
        }
        return estado;
    }

    public float descuento() {
        float descuentoValor = 0;
        float descuento;
        if (categoria.equalsIgnoreCase("Embutidos") && stock >= 1000) {
            descuentoValor = stockValorado() * 0.10f;
            descuento = stockValorado() - descuentoValor;
        }

        if (categoria.equalsIgnoreCase("Carnes") && stock >= 1000) {
            descuentoValor = stockValorado() * 0.05f;
            descuento = stockValorado() - descuentoValor;
        }
        return descuentoValor;
    }

    public String mostrarDatos() {
        String mensaje = "Codigo : " + codigo
                + "\nNombre: " + nombre
                + "\nCategoria: " + categoria
                + "\nPrecio: " + precio
                + "\nStock: " + stock
                + "\nStock Valorado: " + stockValorado()
                + "\nEstado Stock: " + estadoStock()
                + "\nDescuento: " + descuento()
                + "\n Total" + (stockValorado() - descuento())
                + "\n";
        return mensaje;
    }

}
