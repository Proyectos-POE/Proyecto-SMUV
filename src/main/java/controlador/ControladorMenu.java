package controlador;
import Vista.*;
import modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">AFILIADO</p></html>"))
            {
                ventanaMenu.dispose();
                VentanaAfiliado ventanaAfiliado = new VentanaAfiliado();
                ControladorAfiliado controladorAfiliado = new ControladorAfiliado(servicioMedicoUV, ventanaAfiliado);
            }
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">CONSULTORIO</p></html>"))
            {
                ventanaMenu.dispose();
                VentanaConsultorio ventanaConsultorio = new VentanaConsultorio();
                ControladorConsultorio controladorConsultorio = new ControladorConsultorio(servicioMedicoUV, ventanaConsultorio);
            }
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">CITAS</p></html>"))
            {
                ventanaMenu.dispose();
                VentanaCita ventanaCita = new VentanaCita();
                ControladorCita controladorCita = new ControladorCita(servicioMedicoUV, ventanaCita);
            }
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">MEDICOS</p></html>"))
            {
                ventanaMenu.dispose();
                VentanaMedico ventanaMedico = new VentanaMedico();
                ControladorMedico controladorMedico = new ControladorMedico(servicioMedicoUV, ventanaMedico);
            }
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">SERVICIOS</p></html>"))
            {
                ventanaMenu.dispose();
                VentanaServicio ventanaServicio = new VentanaServicio();
                ControladorServicio controladorServicio = new ControladorServicio(servicioMedicoUV, ventanaServicio);
            }
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">BACKUP Y</p><p style=\"text-align:center\">RESTAURAR</p></html>"))
            {
                ventanaMenu.dispose();
                VentanaBackUp ventanaBackUp = new VentanaBackUp();
                ControladorBackUp controladorBackUp = new ControladorBackUp(servicioMedicoUV, ventanaBackUp);
            }
        }
    }
}
