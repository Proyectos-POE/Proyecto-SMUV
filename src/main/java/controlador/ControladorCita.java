
package controlador;

import modelo.*;
import Vista.VentanaAfiliado;
import Vista.VentanaCita;
import Vista.VentanaMenu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * MESSI
 */
public class ControladorCita
{
    private Empresa servicioMedicoUV;
    private VentanaCita ventanaCita;

    public ControladorCita (Empresa auxServicioMedicoUV, VentanaCita auxVentanaCita)
    {
        this.servicioMedicoUV = auxServicioMedicoUV;
        this.ventanaCita = auxVentanaCita;

        ventanaCita.setVisible(true);
        ventanaCita.setLocationRelativeTo(null);

        /*this.ventanaAfiliado.addBtnAgregarListener(new ControladorAfiliado.AgregarAfiliadoListener());
        this.ventanaAfiliado.addBtnBuscarEditarListener(new ControladorAfiliado.BuscarEditarListener());
        this.ventanaAfiliado.addBtnEditarListener(new ControladorAfiliado.EditarAfiliadoListener());
        this.ventanaAfiliado.addBtnBuscarEliminarListener(new ControladorAfiliado.BuscarEliminarListener());
        this.ventanaAfiliado.addBtnEliminarListener(new ControladorAfiliado.EliminarAfiliadoListener());
        this.ventanaAfiliado.addBtnActualizarListener(new ControladorAfiliado.ListarAfiliadoListener());
        this.ventanaAfiliado.addBtnAtrasListener(new ControladorAfiliado.AtrasAfiliadoListener());
        this.ventanaAfiliado.addBtnCancelarEditarListener(new ControladorAfiliado.CancelarEditarListener());
        this.ventanaAfiliado.addBtnCancelarEliminarListener(new ControladorAfiliado.CancelarEliminarListener());*/
        this.ventanaCita.addBoxAfiliadoAgregarListener(new SeleccionarAfiliadoListener());
        this.ventanaCita.addBoxServicioAgregarListener(new SeleccionarServicioListener());

        rellenarAfiliadosAgregar(servicioMedicoUV.getAfiliados());
        rellenarServiciosAgregar(servicioMedicoUV.getServicios());
    }

    class SeleccionarAfiliadoListener implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent e)
        {
            Afiliado auxAfiliado = (Afiliado) e.getItem();
            ventanaCita.setEnabledServicioAgregar(false);
            if(e.getStateChange()== ItemEvent.SELECTED)
            {
                if(auxAfiliado.getNombre()!=null)
                {
                    ventanaCita.setEnabledServicioAgregar(true);
                }
                System.out.print(auxAfiliado.getNombre());
            }
        }
    }

    public void rellenarAfiliadosAgregar(ArrayList<Afiliado> array)
    {
        for(int i = 0; i < array.size();i++)
        {
            ventanaCita.limpiarDatosAgregar();
            ventanaCita.rellenarBoxAfiliadosAgregar(array.get(i));

        }
    }
    class SeleccionarServicioListener implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent e)
        {
            Servicio auxServicio = (Servicio) e.getItem();
            if(e.getStateChange()== ItemEvent.SELECTED)
            {
                    /*if(auxServicio.getNombre()!=null)
                    {
                        ventanaCita.noEnabledAfiliado();
                    }*/
                System.out.print(auxServicio.getNombre());
            }
        }
    }

    public void rellenarServiciosAgregar(ArrayList<Servicio> array)
    {
        for(int i = 0; i < array.size(); i++)
        {
            ventanaCita.limpiarDatosAgregar();
            ventanaCita.rellenarBoxServiciosAgregar(array.get(i));
        }
    }


    class BuscarEliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Cita auxCita;
            int auxCitaId;

            if(e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                try
                {
                    auxCitaId = Integer.parseInt(ventanaCita.getIdEliminar());
                    auxCita = servicioMedicoUV.getCita(auxCitaId);
                    if(auxCita!=null)
                    {
                        ventanaCita.manejarTextFieldIdElimnar(false);
                        ventanaCita.setTxtAfiliadoEliminar(auxCita.getAfiliado().toString());
                        ventanaCita.setTxtServicioEliminar(auxCita.getServicio().toString());
                        ventanaCita.setTxtMedicoEliminar(auxCita.getMedico().toString());
                        ventanaCita.setTxtFechaEliminar(auxCita.getFecha().toString());
                        ventanaCita.setTxtHoraEliminar(auxCita.getHora().toString());
                        ventanaCita.manejarBtnCancelarEliminar(true);
                    }
                    else
                    {
                        ventanaCita.mostrarMensaje("Cita no encontrada");
                        ventanaCita.setIdEliminar("");
                    }
                }
                catch (Exception ex)
                {
                    ventanaCita.mostrarMensaje("Ingrese enteros en el campo ID");
                }
            }
        }
    }

    class CancelarEliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                ventanaCita.manejarTextFieldIdElimnar(true);
                ventanaCita.limpiarDatosEliminar();
                ventanaCita.desactivarControlesEliminar();
                ventanaCita.manejarBtnCancelarEliminar(false);
            }
        }
    }
    class EliminarServicioListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("ELIMINAR"))
            {
                eliminarServicio();
            }
        }
    }

    public void eliminarServicio()
    {
        Cita auxCita;
        int auxCitaId;

        try
        {
            auxCitaId = Integer.parseInt(ventanaCita.getIdEliminar());
            auxCita = servicioMedicoUV.getCita(auxCitaId);
            if (auxCita != null)
            {
                if(servicioMedicoUV.eliminarCita(auxCita))
                {
                    ventanaCita.mostrarMensaje("Cita eliminada con exito");
                    ventanaCita.limpiarDatosEliminar();
                    ventanaCita.setIdEliminar("");
                    ventanaCita.manejarTextFieldIdElimnar(true);
                    ventanaCita.manejarBtnCancelarEliminar(false);
                }
            }
        }
        catch (Exception ex)
        {
            ventanaCita.mostrarMensaje("Ingrese un Entero en el campo ID");
            ventanaCita.setIdEliminar("");
        }
    }
}

