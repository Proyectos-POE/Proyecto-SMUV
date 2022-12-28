package org.main;

import Vista.*;
import controlador.ControladorConsultorio;
import controlador.ControladorMedico;
import controlador.ControladorMenu;
import modelo.Conexion;
import modelo.Empresa;
import modelo.Medico;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class Main
{
    public static void main(String[] args)
    {
        Empresa servicioMedicoUV = new Empresa("servicioMedicoUV");
        VentanaMenu ventanaMenu = new VentanaMenu();
        ControladorMenu controladorMenu = new ControladorMenu(servicioMedicoUV,ventanaMenu);
        controladorMenu.recuperarDatos();
    }
}