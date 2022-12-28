package controlador;
import Vista.*;
import modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class ControladorMenu
{
    private final Empresa servicioMedicoUV;
    private final VentanaMenu ventanaMenu;

    public ControladorMenu(Empresa auxServicioMedicoUV, VentanaMenu auxVentanaMenu)
    {
        this.servicioMedicoUV = auxServicioMedicoUV;
        this.ventanaMenu = auxVentanaMenu;

        ventanaMenu.setVisible(true);
        ventanaMenu.setLocationRelativeTo(null);

        this.ventanaMenu.addBtnListener(new ButtonListener());
    }

    private void irVentanaAfiliado()
    {
        ventanaMenu.dispose();
        VentanaAfiliado ventanaAfiliado = new VentanaAfiliado();
        ControladorAfiliado controladorAfiliado = new ControladorAfiliado(servicioMedicoUV, ventanaAfiliado);
    }

    private void irVentanaServicio()
    {
        ventanaMenu.dispose();
        VentanaServicio ventanaServicio = new VentanaServicio();
        ControladorServicio controladorServicio = new ControladorServicio(servicioMedicoUV, ventanaServicio);
    }

    private void irVentanaConsultorio()
    {
        ventanaMenu.dispose();
        VentanaConsultorio ventanaConsultorio = new VentanaConsultorio();
        ControladorConsultorio controladorConsultorio = new ControladorConsultorio(servicioMedicoUV, ventanaConsultorio);
    }

    private void irVentanaMedico()
    {
        ventanaMenu.dispose();
        VentanaMedico ventanaMedico = new VentanaMedico();
        ControladorMedico controladorMedico = new ControladorMedico(servicioMedicoUV, ventanaMedico);
    }

    private void irVentanaCita()
    {
        ventanaMenu.dispose();
        VentanaCita ventanaCita = new VentanaCita();
        ControladorCita controladorCita = new ControladorCita(servicioMedicoUV, ventanaCita);
    }

    private void irVentanaBackUp()
    {
        ventanaMenu.dispose();
        VentanaBackUp ventanaBackUp = new VentanaBackUp();
        ControladorBackUp controladorBackUp = new ControladorBackUp(servicioMedicoUV, ventanaBackUp);
    }

    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">AFILIADO</p></html>"))
            {
                irVentanaAfiliado();
            }
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">CONSULTORIO</p></html>"))
            {
                irVentanaConsultorio();
            }
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">CITAS</p></html>"))
            {
                irVentanaCita();
            }
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">MEDICOS</p></html>"))
            {
                irVentanaMedico();
            }
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">SERVICIOS</p></html>"))
            {
                irVentanaServicio();
            }
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">BACKUP Y</p><p style=\"text-align:center\">RESTAURAR</p></html>"))
            {
                irVentanaBackUp();
            }
        }
    }

    public void recuperarDatos()
    {
        if(!servicioMedicoUV.recuperarDatos())
        {
            ventanaMenu.mostrarMensaje("Error a recuperar los datos. Hace falta informacion. Porfavor cargue el backUp mas reciente");
        }
    }
}
