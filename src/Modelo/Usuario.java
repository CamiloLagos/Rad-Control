/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Vasquez10
 */
public class Usuario {
    private String nombre;
    private String contrasena;
    private String licencia = null;
    private String serial;

    public Usuario(String nombre, String contrasena) throws Exception {
        if(nombre == null || "".equals(nombre.trim())){
            throw new Exception("El nombre del usuario no puede estar vacio.");
        }
        if(contrasena == null || "".equals(contrasena.trim())){
            throw new Exception("La contrasena del usuario no puede estar vacia.");
        }
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcontrasena() {
        return contrasena;
    }

    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contrase\u00f1a=" + contrasena + ", licencia=" + licencia + '}';
    }
    
    public String toJson() {
        String json = "{" + "\"nombre\": \"" + nombre + "\"," + "\"contrasena\": \"" + contrasena + "\","
				+ "\"serial\": \"" + serial + "\"" + "}";
        return json;
    }
    
    
}
