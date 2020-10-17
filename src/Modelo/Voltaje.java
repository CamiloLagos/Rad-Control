/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author juanc
 */
public class Voltaje {
    private int volt;
    private Material plomo;
    private Material Concreto;
    private Material Acero;

    public Voltaje(int volt, Material plomo, Material Concreto, Material Acero) {
        this.volt = volt;
        this.plomo = plomo;
        this.Concreto = Concreto;
        this.Acero = Acero;
    }

    public int getVolt() {
        return volt;
    }

    public void setVolt(int volt) {
        this.volt = volt;
    }

    public Material getPlomo() {
        return plomo;
    }

    public void setPlomo(Material plomo) {
        this.plomo = plomo;
    }

    public Material getConcreto() {
        return Concreto;
    }

    public void setConcreto(Material Concreto) {
        this.Concreto = Concreto;
    }

    public Material getAcero() {
        return Acero;
    }

    public void setAcero(Material Acero) {
        this.Acero = Acero;
    }

    @Override
    public String toString() {
        return "Voltaje{" + "volt=" + volt + ", plomo=" + plomo + ", Concreto=" + Concreto + ", Acero=" + Acero + '}';
    }
    
    
}
