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
    private Date dayLlegada;
    private String flagAnulado;
    private Date dayVencimiento;
    public Reserva(){
        
    }
    public Reserva(int idReserva, Ciudad ciudad, Usuario usuario, Date dayReserva, Date dayLlegada, String flagAnulado, Date dayVencimiento) {
        this.idReserva = idReserva;
        this.ciudad = ciudad;
        this.usuario = usuario;
        this.dayReserva = dayReserva;
        this.dayLlegada = dayLlegada;
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

    public Date getDayLlegada() {
        return dayLlegada;
    }

    public void setDayLlegada(Date dayLlegada) {
        this.dayLlegada = dayLlegada;
    }

    public String getFlagAnulado() {
        return flagAnulado;
    }

    public void setFlagAnulado(String flagAnulado) {
        this.flagAnulado = flagAnulado;
    }

    public Date getDayVencimiento() {
        return dayVencimiento;
    }

    public void setDayVencimiento(Date dayVencimiento) {
        this.dayVencimiento = dayVencimiento;
    }
    public String toString(){
        return ""+this.idReserva;
    }
   
}
