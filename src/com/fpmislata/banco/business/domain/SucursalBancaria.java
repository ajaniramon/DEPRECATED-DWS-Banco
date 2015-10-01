/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

/**
 *
 * @author alumno
 */
public class SucursalBancaria {
    int idSucursalBancaria;
    String nombre;
    String direccion;
    int telefono;
    String director;
    EntidadBancaria entidadBancaria;

    public SucursalBancaria(int idSucursalBancaria, String nombre, String direccion, int telefono, String director, EntidadBancaria entidadBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.director = director;
        this.entidadBancaria = entidadBancaria;
    }

    public SucursalBancaria(String nombre, String direccion, int telefono, String director, EntidadBancaria entidadBancaria) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.director = director;
        this.entidadBancaria = entidadBancaria;
    }

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }

    @Override
    public String toString() {
        return "SucursalBancaria{" + "idSucursalBancaria=" + idSucursalBancaria + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", director=" + director + ", entidadBancaria=" + entidadBancaria + '}';
    }
    
}
