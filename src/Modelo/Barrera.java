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
public class Barrera {

    //Atributos 
    private String Nombre;
    private int Voltaje;
    private int ImagenesxSemana;
    private String TipoBarrera;
    private String AreaProteger;
    private String DisenioDeArea;
    private float Distancia;
    //Atributos calculados
    private double factorDeTransmision = 0;
    private float cargaDeTrabajo = 0;
    private float factorDeUso = 0;
    private float factorDeOcupacion = 0;
    private float dosisDeLimiteDeDisenio = 0;
    private double bp = 0;
    private double acero = 0;
    private double plomo = 0;
    private double concreto = 0;

    public Barrera(String Nombre, int Voltaje, int ImagenesxSemana, String TipoBarrera, String AreaProteger, String DisenioDeArea, float Distancia) {
        this.Nombre = Nombre;
        this.Voltaje = Voltaje;
        this.ImagenesxSemana = ImagenesxSemana;
        this.TipoBarrera = TipoBarrera;
        this.AreaProteger = AreaProteger;
        this.DisenioDeArea = DisenioDeArea;
        this.Distancia = Distancia;
        switch (this.Voltaje) {
            case 50:
                factorDeTransmision = 0.06;
                break;
            case 70:
                factorDeTransmision = 0.08;
                break;
            case 90:
                factorDeTransmision = 0.1;
                break;
        }
        if (this.TipoBarrera.equals("Barrera primaria")) {
            factorDeUso = (float) 0.2;
        } else if (this.TipoBarrera.equals("Barrera secundaria")) {
            factorDeUso = (float) 0.4;
        }
        if (this.DisenioDeArea.equals("Controlada")) {
            this.dosisDeLimiteDeDisenio = (float) 0.1;
        } else {
            this.dosisDeLimiteDeDisenio = (float) 0.02;
        }
        switch (this.AreaProteger) {
            case "Administrativa":
                factorDeOcupacion = 1;
                break;
            case "Casa":
                factorDeOcupacion = 1;
                break;
            case "Pasillo":
                factorDeOcupacion = (float) 0.2;
                break;
            case "Baño público":
                factorDeOcupacion = (float) 0.2;
                break;
            case "Baño personal":
                factorDeOcupacion = (float) 0.2;
                break;
            case "Almacen":
                factorDeOcupacion = (float) 0.025;
                break;
            case "Vestier":
                factorDeOcupacion = (float) 0.025;
                break;
            case "Anden":
                factorDeOcupacion = (float) 0.025;
                break;
            case "Jardín":
                factorDeOcupacion = (float) 0.025;
                break;
            case "Calle":
                factorDeOcupacion = (float) 0.025;
                break;
            case "Asensor":
                factorDeOcupacion = (float) 0.025;
                break;
            case "Closet":
                factorDeOcupacion = (float) 0.025;
                break;
            case "Sala de espera":
                factorDeOcupacion = (float) 0.05;
                break;
        }

        switch (this.ImagenesxSemana) {
            case 100:
                switch (this.Voltaje) {
                    case 50:
                        cargaDeTrabajo = 14;
                        break;
                    case 70:
                        cargaDeTrabajo = (float) 7.5;
                        break;
                    default:
                        cargaDeTrabajo = (float) 4.2;
                        break;
                }
                break;
            case 200:
                switch (this.Voltaje) {
                    case 50:
                        cargaDeTrabajo = 28;
                        break;
                    case 70:
                        cargaDeTrabajo = 15;
                        break;
                    default:
                        cargaDeTrabajo = (float) 8.3;
                        break;
                }
                break;
            case 300:
                switch (this.Voltaje) {
                    case 50:
                        cargaDeTrabajo = 43;
                        break;
                    case 70:
                        cargaDeTrabajo = 23;
                        break;
                    default:
                        cargaDeTrabajo = 13;
                        break;
                }
                break;
        }
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getVoltaje() {
        return Voltaje;
    }

    public void setVoltaje(int Voltaje) {
        this.Voltaje = Voltaje;
    }

    public int getImagenesxSemana() {
        return ImagenesxSemana;
    }

    public void setImagenesxSemana(int ImagenesxSemana) {
        this.ImagenesxSemana = ImagenesxSemana;
    }

    public String getTipoBarrera() {
        return TipoBarrera;
    }

    public void setTipoBarrera(String TipoBarrera) {
        this.TipoBarrera = TipoBarrera;
    }

    public String getAreaProteger() {
        return AreaProteger;
    }

    public void setAreaProteger(String AreaProteger) {
        this.AreaProteger = AreaProteger;
    }

    public String getDisenioDeArea() {
        return DisenioDeArea;
    }

    public void setDisenioDeArea(String DisenioDeArea) {
        this.DisenioDeArea = DisenioDeArea;
    }

    public float getDistancia() {
        return Distancia;
    }

    public void setDistancia(float Distancia) {
        this.Distancia = Distancia;
    }

    public double getFactorDeTransmision() {
        return factorDeTransmision;
    }

    public void setFactorDeTransmision(double factorDeTransmision) {
        this.factorDeTransmision = factorDeTransmision;
    }

    public float getCargaDeTrabajo() {
        return cargaDeTrabajo;
    }

    public void setCargaDeTrabajo(float cargaDeTrabajo) {
        this.cargaDeTrabajo = cargaDeTrabajo;
    }

    public float getFactorDeUso() {
        return factorDeUso;
    }

    public void setFactorDeUso(float factorDeUso) {
        this.factorDeUso = factorDeUso;
    }

    public float getFactorDeOcupacion() {
        return factorDeOcupacion;
    }

    public void setFactorDeOcupacion(float factorDeOcupacion) {
        this.factorDeOcupacion = factorDeOcupacion;
    }

    public float getdosisDeLimiteDeDisenio() {
        return dosisDeLimiteDeDisenio;
    }

    public void setdosisDeLimiteDeDisenio(float dosisDeLimiteDeDisenio) {
        this.dosisDeLimiteDeDisenio = dosisDeLimiteDeDisenio;
    }

    public double getBp() {
        return bp;
    }

    public void setBp(double bp) {
        this.bp = bp;
    }

    public double getAcero() {
        return acero;
    }

    public void setAcero(double acero) {
        this.acero = acero;
    }

    public double getPlomo() {
        return plomo;
    }

    public void setPlomo(double plomo) {
        this.plomo = plomo;
    }

    public double getConcreto() {
        return concreto;
    }

    public void setConcreto(double concreto) {
        this.concreto = concreto;
    }

    @Override
    public String toString() {
        return "                     Barrera " + "\n" + " \n Nombre: " + Nombre + " \n Tipo de Barrera: " + TipoBarrera + " \n Área a Proteger: " + AreaProteger + " \n Diseño para Área: " + DisenioDeArea + " \n Imágenes por semana: " + ImagenesxSemana + " \n Voltaje[KV]: " + Voltaje + " \n Distancia(d)[m]: " + String.format("%.2f", Distancia) + " \n Factor De Transmision(T): " + String.format("%.2f", factorDeTransmision) + " \n Carga De Trabajo(W)[mAmin/sem]: " + String.format("%.2f", cargaDeTrabajo) + " \n Factor De Uso(U): " + String.format("%.2f", factorDeUso) + " \n Factor De Ocupacion: " + String.format("%.2f", factorDeOcupacion) + " \n Dosis Limite De Diseño(P)[mGy/sem]: " + String.format("%.2f", dosisDeLimiteDeDisenio) + " \n Bp(x,m,Vt): " + String.format("%.2f", bp) + "\n \n                    Espesor: " + " \n \n x(B,m,Vt)Acero[mm]: " + String.format("%.2f", acero) + " \n \n x(B,m,Vt)Plomo[mm]: " + String.format("%.2f", plomo) + " \n \n x(B,m,Vt)Concreto[mm]: " + String.format("%.2f", concreto) ;
    }
    
    public String toString2(){
        return "Nombre de barrera: " + Nombre;
    }
    
   

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Barrera other = (Barrera) obj;
        if (this.Voltaje != other.Voltaje) {
            return false;
        }
        if (this.ImagenesxSemana != other.ImagenesxSemana) {
            return false;
        }
        if (this.AreaProteger != other.AreaProteger) {
            return false;
        }
        if (this.DisenioDeArea != other.DisenioDeArea) {
            return false;
        }
        if (Float.floatToIntBits(this.Distancia) != Float.floatToIntBits(other.Distancia)) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.TipoBarrera, other.TipoBarrera)) {
            return false;
        }
        return true;
    }
    
    public void bp(){
        double x = 0;
        x = (dosisDeLimiteDeDisenio * (this.Distancia * (this.Distancia)))
                / ((cargaDeTrabajo * cargaDeTrabajo) * factorDeUso * factorDeTransmision * factorDeOcupacion);
        this.bp = x;
    }

}
