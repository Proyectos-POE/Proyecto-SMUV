package org.main;

import Vista.*;
import controlador.ControladorConsultorio;
import controlador.ControladorMedico;
import controlador.ControladorMenu;
import modelo.Conexion;
import modelo.Empresa;
import modelo.Medico;

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