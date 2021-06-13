/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
public class Pedido {
    private int idPedido;
    private Reserva reserva;
    private Producto producto;
    private double quantityPeso;

    public Pedido(int idPedido, Reserva reserva, Producto producto, double quantityPeso) {
        this.idPedido = idPedido;
        this.reserva = reserva;
        this.producto = producto;
        this.quantityPeso = quantityPeso;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getQuantityPeso() {
        return quantityPeso;
    }

    public void setQuantityPeso(double quantityPeso) {
        this.quantityPeso = quantityPeso;
    }
}
