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
            control.agregarVoltaje(new Voltaje(70, new Material(5.369, 23.49, 0.5881), new Material(0.05087, 0.1696, 0.3847), new Material(0.7149, 3.798, 0.5378)));
            control.agregarVoltaje(new Voltaje(90, new Material(3.067, 18.83, 0.7726), new Material(0.04228, 0.1137, 0.469), new Material(0.3971, 2.913, 0.7204)));
            Principal p = new Principal(control);
            p.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
