/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import BDaccess.HTTPSUtils;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author juanc
 */
public class Control implements HTTPSUtils.OnResponseListener{

    List<Barrera> barreras = new LinkedList<>();
    List<Usuario> usuarios = new LinkedList<>();
    List<Voltaje> voltajes = new LinkedList<>();
    private HTTPSUtils hTTPSUtils;

    public Control() {
        hTTPSUtils = new HTTPSUtils();
    }

    public List<Barrera> getBarreras() {
        return barreras;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setBarreras(List<Barrera> barreras) {
        this.barreras = barreras;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Voltaje> getVoltajes() {
        return voltajes;
    }

    public void setVolatje(List<Voltaje> voltajes) {
        this.voltajes = voltajes;
    }
    
    

    public Barrera buscarBarrera(Barrera b) {
        for (Barrera barrera : barreras) {
            if (barrera.equals(b)) {
                return barrera;
            }
        }
        return null;
    }
    
    public void agregarVoltaje(Voltaje v){
        voltajes.add(v);
    }
    
    public Voltaje buscarVoltaje(int voltaje){
        for (Voltaje vol : voltajes) {
            if(vol.getVolt() == voltaje){
                return vol;
            }
        }
        return null;
    }

//    public Usuario buscarUsuario(Usuario u) {
//        for (Usuario usuario : usuarios) {
//            if (usuarios.equals(u)) {
//                return usuario;
//            }
//        }
//        return null;
//    }
    public void agregarBarrera(Barrera b) {
        barreras.add(b);
    }

    public void agregarUsuario(Usuario u) throws Exception {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(u.getNombre())) {
                throw new Exception("El usuario ingresado ya se encuentra registrado.");
            }
        }
        usuarios.add(u);

    }

    public Usuario buscarUsuario(String nombre, String contrasena) throws Exception {
        for (Usuario usuario : usuarios) {
            if ((usuario.getNombre().equals(nombre)) && (usuario.getcontrasena().equals(contrasena))) {
                return usuario;
            }
        }
        throw new Exception("Usuario o contraseña incorrecta");
    }

    public void eliminarBarrera(Barrera b) {
        barreras.remove(b);
    }

    //(1/n*n)*LN((n+n)/(1+n))
    public double calculoPlomo(Barrera b){
        double x = 0;
        Voltaje v = buscarVoltaje(b.getVoltaje());
        double expo1 = Math.pow(b.getBp(), (v.getPlomo().getGamma()*(-1)));
        double expo2 = v.getPlomo().getBeta() / v.getPlomo().getAlfa();
        x = ((1/(v.getPlomo().getAlfa())*v.getPlomo().getGamma())
                *
                (Math.log((expo1+expo2)/(1+expo2))));
        return x;
    }
    public double calculoConcreto(Barrera b){
        double x = 0;
        Voltaje v = buscarVoltaje(b.getVoltaje());
        double expo1 = Math.pow(b.getBp(), (v.getConcreto().getGamma()*(-1)));
        double expo2 = v.getConcreto().getBeta() / v.getConcreto().getAlfa();
        x = ((1/(v.getConcreto().getAlfa())*v.getConcreto().getGamma())
                *
                (Math.log((expo1+expo2)/(1+expo2))));
        return x;
    }
    public double calculoAcero(Barrera b){
        double x = 0;
        Voltaje v = buscarVoltaje(b.getVoltaje());
        double expo1 = Math.pow(b.getBp(), (v.getAcero().getGamma()*(-1)));
        double expo2 = v.getAcero().getBeta() / v.getAcero().getAlfa();
        x = ((1/(v.getAcero().getAlfa())*v.getAcero().getGamma())
                *
                (Math.log((expo1+expo2)/(1+expo2))));
        return x;
    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch(callbackID){
            case 1: break;
        }
    }
    public void login(){
        
    }
    
    public void cargarDatos(){
            agregarVoltaje(new Voltaje(50, new Material(8.801, 2.73E+01, 0.2957), new Material(0.09032, 0.1712, 0.2324), new Material(1.817, 4.84, 0.4021)));
            agregarVoltaje(new Voltaje(60, new Material(6.951, 1.49E+01, 4.20E-01), new Material(6.25E-02, 1.69E-01, 2.73E-01), new Material(1.18E+00, 4.219, 4.57E-01)));
            agregarVoltaje(new Voltaje(70, new Material(5.369, 23.49, 0.5881), new Material(0.05087, 0.1696, 0.3847), new Material(0.7149, 3.798, 0.5378)));
            agregarVoltaje(new Voltaje(80, new Material(4.040, 2.17E+01, 7.19E-01), new Material(4.58E-02, 1.55E-01, 4.93E-01), new Material(4.92E-01, 3.428, 6.43E-01)));
            agregarVoltaje(new Voltaje(90, new Material(3.067, 18.83, 0.7726), new Material(0.04228, 0.1137, 0.469), new Material(0.3971, 2.913, 0.7204)));
            agregarVoltaje(new Voltaje(100, new Material(2.500, 1.53E+01, 7.56E-01), new Material(3.93E-02, 8.57E-02, 4.27E-01), new Material(3.42E-01, 2.42, 7.65E-01)));
    }
}
