package controlador;

import Vista.VentanaMenu;
import modelo.Servicio;
import modelo.Empresa;
import Vista.VentanaServicio;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Medico;

/**
 *
 * MESSI
 */
public class ControladorServicio 
{
    private final Empresa servicioMedicoUV;
    private final VentanaServicio ventanaServicio;
    
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

    public boolean comprobarAsignacionMedico(Servicio auxServicio)
    {
        boolean auxAsignado = false;
        ArrayList <Medico> auxMedicos;
        auxMedicos = servicioMedicoUV.getMedicos();

        if (!auxMedicos.isEmpty())
        {
            for(Medico medico: auxMedicos)
            {
                if(medico.getEspecialidad().getId() == auxServicio.getId())
                {
                    auxAsignado = true;
                    break;
                }
            }
        }
        return auxAsignado;
    }

    private boolean comprobarNombreServicio(String auxNombre)
    {
        boolean auxNombreValido;
        auxNombreValido = true;
        ArrayList<Servicio> auxServicios;
        auxServicios = servicioMedicoUV.getServicios();

        if(!auxServicios.isEmpty())
        {
            for(Servicio servicio: auxServicios)
            {
                if(servicio.getNombre().trim().equalsIgnoreCase(auxNombre.trim()))
                {
                    ventanaServicio.mostrarMensaje("El servicio ya fue agregado. Por favor ingrese otros servicio");
                    auxNombreValido = false;
                    break;
                }
            }
        }
        return auxNombreValido;
    }

    public String mostrarDatos(Servicio servicio)
    {
        String datos;
        String idServicio = String.valueOf(servicio.getId());
        String nombreServicio = String.valueOf(servicio.getNombre());

        datos = "\nId: " + idServicio+"\nNombre: "+ nombreServicio;

        return datos;
    }

    private Object[][] tablaObjectServicio(ArrayList <Servicio> auxServicios)
    {
        Object[][] dataServicio;
        dataServicio = new Object [auxServicios.size()][2];

        int auxId;
        String auxCualServicio;

        for(int fila=0; fila<dataServicio.length;fila++)
        {
            auxId = auxServicios.get(fila).getId();
            auxCualServicio = auxServicios.get(fila).getNombre();

            dataServicio[fila][0] = auxId;
            dataServicio[fila][1] = auxCualServicio;
        }

        return dataServicio;
    }
    
    private void listarServicio()
    {
        ArrayList <Servicio> auxServicios;
        Object[][] auxDataServicios;
        String[] nombresColumnas = {"ID", "SERVICIO"};
        auxServicios = servicioMedicoUV.getServicios();
        auxDataServicios = tablaObjectServicio(auxServicios);
        ventanaServicio.crearTabla(auxDataServicios, nombresColumnas);
        if(auxServicios.isEmpty())
        {
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
        Servicio auxServicio;
        String auxNombre;

        if(ventanaServicio.getTxtServicioAgregar().length() > 0)
        {
            auxNombre = ventanaServicio.getTxtServicioAgregar();
            if(comprobarNombreServicio(auxNombre))
            {
                auxServicio = new Servicio(auxNombre);
                if (servicioMedicoUV.agregarServicio(auxServicio))
                {
                    ventanaServicio.mostrarMensaje("Servicio agregado con éxito" + mostrarDatos(auxServicio));
                    servicioMedicoUV.escribirServicios();
                }
                else
                {
                    ventanaServicio.mostrarMensaje("No se pudo agregar el servicio");
                }
            }
            ventanaServicio.setTxtServicioAgregar("");
        }
        else
        {
            ventanaServicio.mostrarMensaje("No se puede agregar un servicio vacio");
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

    private void buscarEditarServicio()
    {
        Servicio auxServicio;
        int auxId;
        String auxNombre;

        try
        {
            auxId = Integer.parseInt(ventanaServicio.getIdEditar());
            auxServicio = servicioMedicoUV.getServicio(auxId);

            if(auxServicio != null)
            {
                auxNombre = auxServicio.getNombre();
                ventanaServicio.setTxtServicioEditar(auxNombre);
                ventanaServicio.activarControlesEditar();
                ventanaServicio.manejarTextFieldIdEditar(false);
                ventanaServicio.manejarBtnCancelarEditar(true);
                ventanaServicio.manajerBtnEditar(true);
            }
            else
            {
                ventanaServicio.mostrarMensaje("Servicio no encontrado");
                ventanaServicio.setIdEditar("");
            }
        }
        catch (Exception ex)
        {
            ventanaServicio.mostrarMensaje("Ingrese un numero entero en el campo ID");
            ventanaServicio.setIdEditar("");
        }
    }

    class BuscarEditarServicioListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            buscarEditarServicio();
        }
    }

    private void editarServicio()
    {
        Servicio auxServicio;
        int intId;
        String auxNombre;

        intId = Integer.parseInt(ventanaServicio.getIdEditar());
        auxServicio = servicioMedicoUV.getServicio(intId);

        if(auxServicio != null)
        {
            if(comprobarAsignacionMedico(auxServicio))
            {
                if(ventanaServicio.getTxtServicioEditar().length() > 0)
                {
                    auxNombre = ventanaServicio.getTxtServicioEditar();
                    if(comprobarNombreServicio(auxNombre))
                    {
                        auxServicio.setNombre(auxNombre);
                        if(servicioMedicoUV.actualizarServicio(auxServicio))
                        {
                            ventanaServicio.mostrarMensaje("Servicio editado con exito");
                            servicioMedicoUV.escribirServicios();
                            if(comprobarAsignacionMedico(auxServicio))
                            {
                                servicioMedicoUV.escribirMedicos();
                            }
                        }
                        else
                        {
                            ventanaServicio.mostrarMensaje("No se pudo editar el servicio");
                        }
                    }
                }
                else
                {
                    ventanaServicio.mostrarMensaje("No se puede editar un servicio vacio");
                }
            }
            else
            {
                ventanaServicio.mostrarMensaje("No se puede editar un servicio asignado");
            }
        }
        else
        {
            ventanaServicio.mostrarMensaje("Servicio no encontrado");
        }
        ventanaServicio.desactivarControlesEditar();
        ventanaServicio.manejarTextFieldIdEditar(true);
        ventanaServicio.manejarBtnCancelarEditar(false);
        ventanaServicio.manajerBtnEditar(false);
        ventanaServicio.setTxtServicioEditar("");
        ventanaServicio.setIdEditar("");
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

    private void cancelarEditarServicio()
    {
        ventanaServicio.desactivarControlesEditar();
        ventanaServicio.manejarTextFieldIdEditar(true);
        ventanaServicio.manejarBtnCancelarEditar(false);
        ventanaServicio.manajerBtnEditar(false);
        ventanaServicio.setTxtServicioEditar("");
        ventanaServicio.setIdEditar("");
    }

    class CancelarEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                cancelarEditarServicio();
            }
        }
    }

    private void buscarEliminarServicio()
    {
        Servicio auxServicio;
        int auxId;
        String auxNombre;

        try
        {
            auxId = Integer.parseInt(ventanaServicio.getIdEliminar());
            auxServicio = servicioMedicoUV.getServicio(auxId);

            if(auxServicio != null)
            {
                auxNombre = auxServicio.getNombre();
                ventanaServicio.manejarTextFieldIdElimnar(false);
                ventanaServicio.activarControlesEliminar();
                ventanaServicio.setTxtServicioEliminar(auxNombre);
                ventanaServicio.desactivarControlesEliminar();
                ventanaServicio.manejarBtnCancelarEliminar(true);
                ventanaServicio.manajerBtnEliminar(true);
            }
            else
            {
                ventanaServicio.mostrarMensaje("Servicio no encontrado");
                ventanaServicio.setIdEliminar("");
            }
        }
        catch (Exception ex)
        {
            ventanaServicio.mostrarMensaje("Ingrese un Entero en el campo ID");
            ventanaServicio.setIdEliminar("");
        }
    }

    class BuscarEliminarServicioListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                buscarEliminarServicio();
            }
        }
    }
    
    private void eliminarServicio()
    {
        Servicio auxServicio;
        int auxId;

        auxId = Integer.parseInt(ventanaServicio.getIdEliminar());
        auxServicio = servicioMedicoUV.getServicio(auxId);

        if(auxServicio != null)
        {
            if(!comprobarAsignacionMedico(auxServicio))
            {
                if(servicioMedicoUV.eliminarServicio(auxServicio))
                {
                    ventanaServicio.mostrarMensaje("Servicio eliminado con éxito");
                    servicioMedicoUV.escribirConsultorios();
                }
                else
                {
                    ventanaServicio.mostrarMensaje("No se pudo eliminar el servicio");
                }
            }
            else
            {
                ventanaServicio.mostrarMensaje("No se puede eliminar un servicio asignado");
            }
        }
        else
        {
            ventanaServicio.mostrarMensaje("No se ha encontrado el servicio");
        }
        ventanaServicio.setTxtServicioEliminar("");
        ventanaServicio.setIdEliminar("");
        ventanaServicio.manejarBtnCancelarEliminar(false);
        ventanaServicio.manejarTextFieldIdElimnar(true);
        ventanaServicio.manajerBtnEliminar(false);
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

    private void cancelarEliminarServicio()
    {
        ventanaServicio.setTxtServicioEliminar("");
        ventanaServicio.setIdEliminar("");
        ventanaServicio.manejarBtnCancelarEliminar(false);
        ventanaServicio.manejarTextFieldIdElimnar(true);
        ventanaServicio.manajerBtnEliminar(false);
    }

    class CancelarEliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                cancelarEliminarServicio();
            }
        }
    }

    private void volverMenuPrincipal()
    {
        ventanaServicio.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu();
        ControladorMenu controladorMenu = new ControladorMenu(servicioMedicoUV,ventanaMenu);
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
}
