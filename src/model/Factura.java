package model;

import java.util.Date;

public class Factura {

    private int idFactura;
    private Reserva reserva;
    private double moneyPrecioFinal;
    private String numFactura;
    private String numSerie;
    private String flagCancelado;
    private Date dayFactura;
    public Factura() {

    }
    public Factura(int idFactura, Reserva reserva, double moneyPrecioFinal, String numFactura, String numSerie, String flagCancelado, Date dayFactura) {
        this.idFactura = idFactura;
        this.reserva = reserva;
        this.moneyPrecioFinal = moneyPrecioFinal;
        this.numFactura = numFactura;
        this.numSerie = numSerie;
        this.flagCancelado = flagCancelado;
        this.dayFactura = dayFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public double getMoneyPrecioFinal() {
        return moneyPrecioFinal;
    }

    public void setMoneyPrecioFinal(double moneyPrecioFinal) {
        this.moneyPrecioFinal = moneyPrecioFinal;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getFlagCancelado() {
        return flagCancelado;
    }

    public void setFlagCancelado(String flagCancelado) {
        this.flagCancelado = flagCancelado;
    }

    public Date getDayFactura() {
        return dayFactura;
    }

    public void setDayFactura(Date dayFactura) {
        this.dayFactura = dayFactura;
    }
}
