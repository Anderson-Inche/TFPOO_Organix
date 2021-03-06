/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String nombre;
    private String apellido;
    private String idDocumento;
    private String direccion;
    private String email;
    private String password;
    private String nivel_permiso;
    public Usuario(){
        
    }
    public Usuario(int idUsuario, String nombreUsuario, String nombre, String apellido, String idDocumento, String direccion, String email, String password, String nivel_permiso) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idDocumento = idDocumento;
        this.direccion = direccion;
        this.email = email;
        this.password = password;
        this.nivel_permiso = nivel_permiso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNivel_permiso() {
        return nivel_permiso;
    }

    public void setNivel_permiso(String nivel_permiso) {
        this.nivel_permiso = nivel_permiso;
    }
    
    public String toString(){
        return this.nombreUsuario;
    }
}
