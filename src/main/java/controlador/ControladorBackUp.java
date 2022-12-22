package controlador;

import Vista.VentanaBackUp;
import Vista.VentanaMedico;
import Vista.VentanaMenu;
import modelo.Empresa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBackUp
{

    private Empresa servicioMedicoUV;
    private VentanaBackUp ventanaBackUp;
    public ControladorBackUp(Empresa auxServicioMedicoUV,VentanaBackUp auxVentanaBackUp)
    {
        this.servicioMedicoUV = auxServicioMedicoUV;
        this.ventanaBackUp = auxVentanaBackUp;

        this.ventanaBackUp.addBtnRestaurarListener(new BtnRestaurarListener());
        this.ventanaBackUp.addBtnBackUpListener(new BtnBackUpListener());
        this.ventanaBackUp.addBtnAtrasListener(new BtnAtrasListener());
    }

    class BtnRestaurarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("\"<html><p style=\\\"text-align:center\\\">REALIZAR</p><p style=\\\"text-align:center\\\">RESTAURACIÓN</p></html>\""))
            {

            }
        }
    }

    class BtnBackUpListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">REALIZAR</p><p style=\"text-align:center\">BACK UP</p></html>"))
            {

            }
        }
    }

    class BtnAtrasListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("ATRAS"))
            {
                volverMenuPrincipal();
            }
        }
    }

    private void volverMenuPrincipal()
    {
        ventanaBackUp.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu();
        ControladorMenu controladorMenu = new ControladorMenu(servicioMedicoUV, ventanaMenu);
    }

}
