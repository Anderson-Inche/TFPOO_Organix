/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author ANDERSON
 */
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private Date diaReabastecimiento;
    private int stock;
    private int cantidadReservada;
    private double precio;

    public Producto(int idProducto, String nombreProducto, Date diaReabastecimiento, int stock, int cantidadReservada, double precio) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.diaReabastecimiento = diaReabastecimiento;
        this.stock = stock;
        this.cantidadReservada = cantidadReservada;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Date getDiaReabastecimiento() {
        return diaReabastecimiento;
    }

    public void setDiaReabastecimiento(Date diaReabastecimiento) {
        this.diaReabastecimiento = diaReabastecimiento;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantidadReservada() {
        return cantidadReservada;
    }

    public void setCantidadReservada(int cantidadReservada) {
        this.cantidadReservada = cantidadReservada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
