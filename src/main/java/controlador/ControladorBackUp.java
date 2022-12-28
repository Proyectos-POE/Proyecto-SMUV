package controlador;

import Vista.VentanaBackUp;
import Vista.VentanaMedico;
import Vista.VentanaMenu;
import modelo.Empresa;
import modelo.Fecha;
import modelo.Hora;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class ControladorBackUp
{

    private final Empresa servicioMedicoUV;
    private final VentanaBackUp ventanaBackUp;
    public ControladorBackUp(Empresa auxServicioMedicoUV,VentanaBackUp auxVentanaBackUp)
    {
        this.servicioMedicoUV = auxServicioMedicoUV;
        this.ventanaBackUp = auxVentanaBackUp;

        this.ventanaBackUp.addBtnRestaurarListener(new BtnRestaurarListener());
        this.ventanaBackUp.addBtnBackUpListener(new BtnBackUpListener());
        this.ventanaBackUp.addBtnAtrasListener(new BtnAtrasListener());
    }

    private void vaciarDaos()
    {
        servicioMedicoUV.getAfiliados().clear();
        servicioMedicoUV.getServicios().clear();
        servicioMedicoUV.getConsultorios().clear();
        servicioMedicoUV.getMedicos().clear();
        servicioMedicoUV.getCitas().clear();
    }

    private void realizarBackUp()
    {
        Fecha auxFecha = new Fecha(LocalDate.now());
        Hora auxHora = new Hora(LocalTime.now());
        if(servicioMedicoUV.crearBackup(auxFecha, auxHora))
        {
            ventanaBackUp.mostrarMensaje("Backup realizado con exito\n Guardado en la carpeta backup del proyecto");
        }
        else
        {
            ventanaBackUp.mostrarMensaje("Backup realizado sin exito");
        }
    }

    class BtnBackUpListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">REALIZAR</p><p style=\"text-align:center\">BACK UP</p></html>"))
            {
                int respuesta;
                respuesta = JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea realizar el backUp?", "BackUp",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(respuesta == JOptionPane.YES_OPTION)
                {
                    realizarBackUp();
                }
            }
        }
    }

    private void cargarBackup()
    {
        File archivo = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de zip", "zip");
        fileChooser.setFileFilter(filtro);

        int seleccion= fileChooser.showOpenDialog(ventanaBackUp);
        if(seleccion != JFileChooser.CANCEL_OPTION)
        {
            archivo = fileChooser.getSelectedFile();
        }

        if (archivo != null)
        {
            int respuesta;
            respuesta = JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea restaurar este archivo?", "BackUp",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(respuesta == JOptionPane.YES_OPTION)
            {
                if (servicioMedicoUV.cargarBackup(archivo))
                {
                    vaciarDaos();
                    if (!servicioMedicoUV.recuperarDatos())
                    {
                        ventanaBackUp.mostrarMensaje("Error a recuperar los datos. Hace falta informacion. Porfavor cargue otro backUp");
                    }
                    ventanaBackUp.mostrarMensaje("Carga del Backup realizado con exito");
                }
                else
                {
                    ventanaBackUp.mostrarMensaje("Carga del Backup realizado sin exito");
                }
            }
            else
            {
                ventanaBackUp.mostrarMensaje("Restauración canceladad");
            }
        }
    }

    class BtnRestaurarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("<html><p style=\"text-align:center\">REALIZAR</p><p style=\"text-align:center\">RESTAURACIÓN</p></html>"))
            {
                cargarBackup();
            }
        }
    }

    private void volverMenuPrincipal()
    {
        ventanaBackUp.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu();
        ControladorMenu controladorMenu = new ControladorMenu(servicioMedicoUV, ventanaMenu);
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

}