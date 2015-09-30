/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

import java.util.Date;

/**
 *
 * @author alumno
 */
public class EntidadBancaria {

    int idEntidadBancaria;
    String nombre;
    int codigoEntidad;
    Date fechaCreacion;
    String direccion;
    String cif;

    public EntidadBancaria(int idEntidadBancaria, String nombre, int codigoEntidad, Date fechaCreacion, String direccion, String cif) {
        this.idEntidadBancaria = idEntidadBancaria;
        this.nombre = nombre;
        this.codigoEntidad = codigoEntidad;
        this.fechaCreacion = fechaCreacion;
        this.direccion = direccion;
        this.cif = cif;
    }

    @Override
    public String toString() {
        return "EntidadBancaria{" + "idEntidadBancaria=" + idEntidadBancaria + ", nombre=" + nombre + ", codigoEntidad=" + codigoEntidad + ", fechaCreacion=" + fechaCreacion + ", direccion=" + direccion + ", cif=" + cif + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(int codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public EntidadBancaria(String nombre, int codigoEntidad, Date fechaCreacion, String direccion, String cif) {
        this.nombre = nombre;
        this.codigoEntidad = codigoEntidad;
        this.fechaCreacion = fechaCreacion;
        this.direccion = direccion;
        this.cif = cif;
    }

    public EntidadBancaria() {

    }

}
