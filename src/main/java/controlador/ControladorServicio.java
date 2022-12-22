
package controlador;

import Vista.VentanaMenu;
import modelo.Servicio;
import modelo.Empresa;
import Vista.VentanaServicio;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Medico;

/**
 *
 * MESSI
 */
public class ControladorServicio 
{
    private Empresa servicioMedicoUV;
    private VentanaServicio ventanaServicio;
    
    public ControladorServicio(Empresa auxServicioMedicoUV, VentanaServicio auxVentanaServicio)
    {
        this.servicioMedicoUV = auxServicioMedicoUV;
        this.ventanaServicio = auxVentanaServicio;
       
        ventanaServicio.setVisible(true);
        ventanaServicio.setLocationRelativeTo(null);
        
        
        this.ventanaServicio.addBtnAgregarListener(new AgregarServicioListener());
        this.ventanaServicio.addBtnBuscarEditarListener(new BuscarEditarServicioListener());
        this.ventanaServicio.addBtnEditarListener(new EditarServicioListener());
        this.ventanaServicio.addBtnBuscarEliminarListener(new BuscarEliminarServicioListener());
        this.ventanaServicio.addBtnEliminarListener(new EliminarServicioListener());
        this.ventanaServicio.addBtnActualizarListener(new ListarServicioListener());
        this.ventanaServicio.addBtnAtrasListener(new AtrasServicioListener());
        this.ventanaServicio.addBtnCancelarEditarListener(new CancelarEditarListener());
        this.ventanaServicio.addBtnCancelarEliminarListener(new CancelarEliminarListener());
   
    }
    
    private Object[][] dataServicio(ArrayList <Servicio> auxServicios)
    {
       Object[][] dataServicio;
       dataServicio = new Object [auxServicios.size()][2];
       for(int fila=0; fila<dataServicio.length;fila++)
       {
           int auxID;
           auxID = auxServicios.get(fila).getId();
           
           String auxCualServicio;
           auxCualServicio = auxServicios.get(fila).getNombre();
           
           dataServicio[fila][0] = auxID;
           dataServicio[fila][1] = auxCualServicio;
       }
       return dataServicio;
    }
    
    private void listarServicio()
    {
        ArrayList <Servicio> auxServicios;
        Object[] auxDataServicio;
        String[] nombresColumnas = {"ID", "SERVICIO"};
        auxServicios = servicioMedicoUV.getServicios();
        if(!auxServicios.isEmpty())
        {
            ventanaServicio.crearTabla(dataServicio(auxServicios), nombresColumnas);
        }
        else
        {
            ventanaServicio.crearTabla(dataServicio(auxServicios), nombresColumnas);
            ventanaServicio.mostrarMensaje("No hay servicios listados");
        }
    }
    
    class ListarServicioListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("REFRESCAR"))
            {
                listarServicio();
            }
        }
    }
    
    private void agregarServicio()
    {
        String auxServicio;
        
        try
        {
            auxServicio = ventanaServicio.getTxtServicioAgregar();
            
            if(comprobarNombreServicios(auxServicio))
            {
                Servicio auxServicios = new Servicio(auxServicio);
                if(servicioMedicoUV.agregarServicio(auxServicios))
                {
                   ventanaServicio.mostrarMensaje("Servicio agregado con éxito"+mostrarDatos(auxServicios));
                   servicioMedicoUV.escribirServicios();
                   ventanaServicio.setTxtServicioAgregar("");
                }
                else
                {
                   ventanaServicio.mostrarMensaje("No se pudo agregar el servicio");
                   ventanaServicio.setTxtServicioAgregar(""); 
                }
            }
            else
            {
                ventanaServicio.setTxtServicioAgregar("");
            }
        }
        catch(NumberFormatException ex)
        {
            ventanaServicio.mostrarMensaje("Por favor escriba un servicio");
            ventanaServicio.setTxtServicioAgregar("");
        }
    }
    
    class AgregarServicioListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equalsIgnoreCase("AGREGAR"))
            {
                agregarServicio();
            }
        }
        
    }
    
    private void eliminarServicio()
    {
        Servicio auxServicio;
        String auxNumeroID;
        int intAuxNumeroID;
        
        try
        {   
            auxNumeroID = ventanaServicio.getIdEliminar();
            intAuxNumeroID = Integer.parseInt(auxNumeroID);
            auxServicio = servicioMedicoUV.getServicio(intAuxNumeroID);
            
            if(auxServicio != null)
            {
                if(!comprobarAsignacion(auxServicio))
                {
                    if(servicioMedicoUV.eliminarServicio(auxServicio))
                    {
                        ventanaServicio.mostrarMensaje("Servicio eliminado con éxito");
                        servicioMedicoUV.escribirConsultorios();
                        ventanaServicio.setTxtServicioEliminar("");
                        ventanaServicio.setIdEliminar("");
                        ventanaServicio.manejarBtnCancelarEliminar(false);
                        ventanaServicio.manejarTextFieldIdElimnar(true);
                    }
                    else
                    {
                        ventanaServicio.mostrarMensaje("No se pudo eliminar el servicio");
                        ventanaServicio.setTxtServicioEliminar("");
                        ventanaServicio.setIdEliminar("");
                        ventanaServicio.manejarBtnCancelarEliminar(false);
                        ventanaServicio.manejarTextFieldIdElimnar(true);
                    }
                }
                else
                {
                    ventanaServicio.mostrarMensaje("No puede eliminar un servicio asignado");
                }
            }
            else
            {
                ventanaServicio.mostrarMensaje("No se ha encontrado el servicio");
                ventanaServicio.setTxtServicioEliminar("");
                ventanaServicio.setIdEliminar("");
            }
          
        }
        catch(Exception ex)
        {
            ventanaServicio.mostrarMensaje("Por favor ingrese un número entero");
            ventanaServicio.setIdEliminar("");
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

    private void editarServicio()
    {
        Servicio auxServicio;
        String auxNumeroId;
        int intAuxNumeroId;
        String auxCualServicio;
        

        try
        {
            auxNumeroId = ventanaServicio.getIdEditar();
            intAuxNumeroId = Integer.parseInt(auxNumeroId);
            auxServicio = servicioMedicoUV.getServicio(intAuxNumeroId);
            if(auxServicio != null)
            {
                auxCualServicio = ventanaServicio.getTxtServicioEditar();
       
                if(comprobarNombreServicios(auxCualServicio))
                {
                    auxServicio.setNombre(auxCualServicio);

                    if(servicioMedicoUV.actualizarServicio(auxServicio))
                    {
                        ventanaServicio.mostrarMensaje("Servicio editado con exito");
                        ventanaServicio.manejarTextFieldIdEditar(true);
                        servicioMedicoUV.escribirServicios();
                        ventanaServicio.setTxtServicioEditar("");
                        ventanaServicio.setIdEditar("");
                        ventanaServicio.desactivarControlesEditar();
                        ventanaServicio.manejarBtnCancelarEditar(false);
                        if(comprobarAsignacion(auxServicio))
                        {
                            servicioMedicoUV.escribirMedicos();
                        }
                    }
                    else
                    {
                        ventanaServicio.mostrarMensaje("No se pudo editar el servicio");
                        ventanaServicio.setTxtServicioEditar("");
                        ventanaServicio.setIdEditar("");
                        
                    }
                }
                else
                {
                    ventanaServicio.setTxtServicioEditar("");
                    ventanaServicio.setIdEditar("");
                    ventanaServicio.desactivarControlesEditar();
                }
            }
            else
            {
                ventanaServicio.mostrarMensaje("Servicio no encontrado");
                ventanaServicio.setTxtServicioEditar("");
                ventanaServicio.setIdEditar("");
                ventanaServicio.desactivarControlesEditar();
            }
        }
        catch (Exception ex)
        {
            ventanaServicio.mostrarMensaje("Ingrese enteros en el campo ID");
            ventanaServicio.setTxtServicioEditar("");
            ventanaServicio.setIdEditar("");
            ventanaServicio.desactivarControlesEditar();
        }
    }
    class EditarServicioListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("EDITAR"))
            {
                editarServicio();
            }
        }
    }

    class BuscarEditarServicioListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Servicio auxServicio;
            String auxNumeroId;
            int intAuxNumeroId;

            if(e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                try
                {   
                    auxNumeroId = ventanaServicio.getIdEditar();
                    intAuxNumeroId = Integer.parseInt(auxNumeroId);
                    auxServicio = servicioMedicoUV.getServicio(intAuxNumeroId);
                    if(auxServicio != null)
                    {
                        ventanaServicio.setTxtServicioEditar(auxServicio.getNombre());
                        ventanaServicio.activarControlesEditar();
                        ventanaServicio.manejarTextFieldIdEditar(false);
                        ventanaServicio.manejarBtnCancelarEditar(true);
                        
                    }
                    else
                    {
                        ventanaServicio.mostrarMensaje("No se pudo encontrar el servicio");
                        ventanaServicio.setIdEditar("");
                        ventanaServicio.setTxtServicioEditar("");
                        ventanaServicio.manejarTextFieldIdEditar(true);
                        ventanaServicio.manejarBtnCancelarEditar(false);
                        ventanaServicio.desactivarControlesEditar();
                    }
                }

                catch (Exception ex)
                {
                    ventanaServicio.mostrarMensaje("Ingrese enteros en el campo ID");
                    ventanaServicio.setIdEditar("");
                }
            }

        }
    }

    class BuscarEliminarServicioListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Servicio auxServicio;
            String auxNumeroId;
            int intAuxNumeroId;

            if(e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                try
                {
                    auxNumeroId = ventanaServicio.getIdEliminar();
                    intAuxNumeroId = Integer.parseInt(auxNumeroId);
                    auxServicio = servicioMedicoUV.getServicio(intAuxNumeroId);
                    if(auxServicio != null)
                    {
                        ventanaServicio.manejarTextFieldIdElimnar(false);
                        ventanaServicio.activarControlesEliminar();
                        ventanaServicio.setTxtServicioEliminar(auxServicio.getNombre());
                        ventanaServicio.desactivarControlesEliminar();
                        ventanaServicio.manejarBtnCancelarEliminar(true);
                    }
                    else
                    {
                        ventanaServicio.mostrarMensaje("Servicio no encontrado");
                        ventanaServicio.setIdEliminar("");
                    }
                }
                catch (Exception ex)
                {
                    ventanaServicio.mostrarMensaje("Ingrese enteros en el campo ID");
                    ventanaServicio.setIdEliminar("");
                }
            }
        }
    }
    
    class AtrasServicioListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("ATRAS"))
            {
                volverMenuPrincipal();
            }
        }
    }
    
     private void volverMenuPrincipal()
    {
        ventanaServicio.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu();
        ControladorMenu controladorMenu = new ControladorMenu(servicioMedicoUV,ventanaMenu);
    }

    private boolean comprobarNombreServicios(String auxCualServicio)
    {
        Boolean datosValidos = true;
        ArrayList<Servicio> auxServicios;
        auxServicios = servicioMedicoUV.getServicios();
 
        if(!auxServicios.isEmpty())
        {
            for(Servicio servicio: auxServicios)
            {
                if(servicio.getNombre().equals(auxCualServicio))
                {
                    ventanaServicio.mostrarMensaje("Este servicio ya está agregado");
                    datosValidos = false;
                    break;
                }
            }
        }
        return datosValidos;
    }
    
    class CancelarEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                ventanaServicio.setIdEditar("");
                ventanaServicio.setTxtServicioEditar("");
                ventanaServicio.manejarTextFieldIdEditar(true);
                ventanaServicio.desactivarControlesEditar();
                ventanaServicio.manejarBtnCancelarEditar(false);
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
                ventanaServicio.setIdEliminar("");
                ventanaServicio.setTxtServicioEliminar("");
                ventanaServicio.manejarTextFieldIdElimnar(true);
                ventanaServicio.manejarBtnCancelarEliminar(false);
            }
        }
    }
    
    

    public boolean comprobarAsignacion(Servicio auxServicio)
    {
        boolean asignado = false;
        ArrayList <Medico> auxMedicos;
        auxMedicos = servicioMedicoUV.getMedicos();
        
        if (!auxMedicos.isEmpty())
        {
            for(Medico medico: auxMedicos)
            {
                if(medico.getEspecialidad().getId() == auxServicio.getId())
                {
                    asignado = true;
                    
                    break;
                }
            }
        }
        return asignado;
    }

    public String mostrarDatos(Servicio servicio)
    {
        String idServicio = String.valueOf(servicio.getId());
        String nombreServicio = String.valueOf(servicio.getNombre());

        String datos = "\nId: " + idServicio+"\nNombre: "+ nombreServicio;
        return datos;
    }
}
