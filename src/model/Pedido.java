package model;
public class Pedido {
    private int idPedido;
    private Reserva reserva;
    private Producto producto;
    private double quantityPeso;
    private double moneyPrecio;

    public Pedido(int idPedido, Reserva reserva, Producto producto, double quantityPeso, double moneyPrecio) {
        this.idPedido = idPedido;
        this.reserva = reserva;
        this.producto = producto;
        this.quantityPeso = quantityPeso;
        this.moneyPrecio = moneyPrecio;
    }

    public Pedido() {
        
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

    public double getMoneyPrecio() {
        return moneyPrecio;
    }

    public void setMoneyPrecio(double moneyPrecio) {
        this.moneyPrecio = moneyPrecio;
    }
}
