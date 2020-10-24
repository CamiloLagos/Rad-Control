/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.Control;
import Modelo.Material;
import Vista.Principal;
import Modelo.Usuario;
import Modelo.Voltaje;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Control control = new Control();           
            control.agregarVoltaje(new Voltaje(50, new Material(8.801, 2.73E+01, 0.2957), new Material(0.09032, 0.1712, 0.2324), new Material(1.817, 4.84, 0.4021)));
            control.agregarVoltaje(new Voltaje(60, new Material(6.951, 1.49E+01, 4.20E-01), new Material(6.25E-02, 1.69E-01, 2.73E-01), new Material(1.18E+00, 4.219, 4.57E-01)));
            control.agregarVoltaje(new Voltaje(70, new Material(5.369, 23.49, 0.5881), new Material(0.05087, 0.1696, 0.3847), new Material(0.7149, 3.798, 0.5378)));
            control.agregarVoltaje(new Voltaje(80, new Material(4.040, 2.17E+01, 7.19E-01), new Material(4.58E-02, 1.55E-01, 4.93E-01), new Material(4.92E-01, 3.428, 6.43E-01)));
            control.agregarVoltaje(new Voltaje(90, new Material(3.067, 18.83, 0.7726), new Material(0.04228, 0.1137, 0.469), new Material(0.3971, 2.913, 0.7204)));
            control.agregarVoltaje(new Voltaje(100, new Material(2.500, 1.53E+01, 7.56E-01), new Material(3.93E-02, 8.57E-02, 4.27E-01), new Material(3.42E-01, 2.42, 7.65E-01)));
            Principal p = new Principal(control);
            p.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
