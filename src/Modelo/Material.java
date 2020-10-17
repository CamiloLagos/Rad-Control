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
public class Material {
    private double alfa;
    private double Beta;
    private double Gamma;

    public Material(double alfa, double Beta, double Gamma) {
        this.alfa = alfa;
        this.Beta = Beta;
        this.Gamma = Gamma;
    }

    public double getAlfa() {
        return alfa;
    }

    public void setAlfa(double alfa) {
        this.alfa = alfa;
    }

    public double getBeta() {
        return Beta;
    }

    public void setBeta(double Beta) {
        this.Beta = Beta;
    }

    public double getGamma() {
        return Gamma;
    }

    public void setGamma(double Gamma) {
        this.Gamma = Gamma;
    }
    
    
}
