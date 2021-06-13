/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

public class Reserva {
    private int idReserva;
    private Ciudad ciudad;
    private Usuario usuario;
    private Date dayReserva;
    private Date daydayLlegada;
    private boolean flagAnulado;
    private Date dayVencimiento;

    public Reserva(int idReserva, Ciudad ciudad, Usuario usuario, Date dayReserva, Date daydayLlegada, boolean flagAnulado, Date dayVencimiento) {
        this.idReserva = idReserva;
        this.ciudad = ciudad;
        this.usuario = usuario;
        this.dayReserva = dayReserva;
        this.daydayLlegada = daydayLlegada;
        this.flagAnulado = flagAnulado;
        this.dayVencimiento = dayVencimiento;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDayReserva() {
        return dayReserva;
    }

    public void setDayReserva(Date dayReserva) {
        this.dayReserva = dayReserva;
    }

    public Date getDaydayLlegada() {
        return daydayLlegada;
    }

    public void setDaydayLlegada(Date daydayLlegada) {
        this.daydayLlegada = daydayLlegada;
    }

    public boolean isFlagAnulado() {
        return flagAnulado;
    }

    public void setFlagAnulado(boolean flagAnulado) {
        this.flagAnulado = flagAnulado;
    }

    public Date getDayVencimiento() {
        return dayVencimiento;
    }

    public void setDayVencimiento(Date dayVencimiento) {
        this.dayVencimiento = dayVencimiento;
    }
}
