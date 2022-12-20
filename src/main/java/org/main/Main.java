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
        Empresa e1 = new Empresa("Te amo bicho");
        VentanaMenu p1 = new VentanaMenu();
        ControladorMenu cm1 = new ControladorMenu(e1,p1);
    }
}