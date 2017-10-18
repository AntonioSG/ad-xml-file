/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ad.xmlfile.test;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author asillero
 */
public class Coche implements Serializable {

    private String matricula;
    private String marca;
    private String modelo;
    private Date fechaMatricula;
    private String color;

    public Coche(String matricula, String marca, String modelo, Date fechaMatricula, String color) {
        if (matricula == null) {
            throw new IllegalStateException("Matricula no puede ser null");
        }
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaMatricula = fechaMatricula;
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula == null) {
            throw new IllegalStateException("Matricula no puede ser null");
        }
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coche other = (Coche) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }
@Override
    public String toString() {
        return matricula+" "+marca+" "+modelo+" "+color+" "+fechaMatricula;
    }
}
