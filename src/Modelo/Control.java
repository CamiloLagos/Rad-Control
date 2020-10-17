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
    
}
