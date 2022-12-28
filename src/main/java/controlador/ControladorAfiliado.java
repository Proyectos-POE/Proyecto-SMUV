package controlador;

import modelo.*;
import Vista.VentanaAfiliado;
import Vista.VentanaMenu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class ControladorAfiliado
{
    private final Empresa servicioMedicoUV;
    private final VentanaAfiliado ventanaAfiliado;
    
    public ControladorAfiliado(Empresa auxServicioMedicoUV, VentanaAfiliado auxVentanaAfiliado)
    {
        this.servicioMedicoUV = auxServicioMedicoUV;
        this.ventanaAfiliado = auxVentanaAfiliado;
        
        ventanaAfiliado.setNullBoxTipoDocumentoAgregar();
        ventanaAfiliado.setNullBoxTipoDocumentoEditar();
        ventanaAfiliado.setVisible(true);
        ventanaAfiliado.setLocationRelativeTo(null);
        
        this.ventanaAfiliado.addBtnAgregarListener(new AgregarAfiliadoListener());
        this.ventanaAfiliado.addBtnBuscarEditarListener(new BuscarEditarListener());
        this.ventanaAfiliado.addBtnEditarListener(new EditarAfiliadoListener());
        this.ventanaAfiliado.addBtnBuscarEliminarListener(new BuscarEliminarListener());
        this.ventanaAfiliado.addBtnEliminarListener(new EliminarAfiliadoListener());
        this.ventanaAfiliado.addBtnActualizarListener(new ListarAfiliadoListener());
        this.ventanaAfiliado.addBtnAtrasListener(new AtrasAfiliadoListener());
        this.ventanaAfiliado.addBtnCancelarEditarListener(new CancelarEditarListener());
        this.ventanaAfiliado.addBtnCancelarEliminarListener(new CancelarEliminarListener());
    }

    private boolean comprobarAsignacionCita(Afiliado auxAfiliado)
    {
        boolean auxAsignado = false;
        ArrayList <Cita> auxCitas;
        auxCitas = servicioMedicoUV.getCitas();

        if (!auxCitas.isEmpty())
        {
            for(Cita cita: auxCitas)
            {
                if(cita.getAfiliado().getId() == auxAfiliado.getId())
                {
                    auxAsignado = true;
                    break;
                }
            }
        }
        return auxAsignado;
    }

    public boolean comprobarDatosAfiliado(int auxId,String auxNombre, String auxTipoDocumento, long auxNumeroDocumento, String correo, long auxTelefono)
    {
        boolean auxDatosValidos = true;
        ArrayList<Afiliado> auxAfiliados;
        auxAfiliados = servicioMedicoUV.getAfiliados();

        if(auxNombre.length() != 0)
        {
            if(correo.length() != 0)
            {
                if(auxNumeroDocumento >= 100000)
                {
                    if(auxTelefono >= 100000)
                    {
                        if(auxTipoDocumento != null)
                        {
                            for (Afiliado afiliado : auxAfiliados)
                            {
                                if(afiliado.getDocumento().getNumeroDocumento() == auxNumeroDocumento && afiliado.getId() != auxId)
                                {
                                    ventanaAfiliado.mostrarMensaje("Ya existe un afiliado con este documento");
                                    auxDatosValidos = false;
                                    break;
                                }
                            }
                        }
                        else
                        {
                            ventanaAfiliado.mostrarMensaje("Escoja un tipo de documento");
                            auxDatosValidos = false;
                        }
                    }
                    else
                    {
                        ventanaAfiliado.mostrarMensaje("Ingrese un telefono valido (minimo 6 numeros)");
                        auxDatosValidos = false;
                    }
                }
                else
                {
                    ventanaAfiliado.mostrarMensaje("Ingrese un numero de documento valido (minimo 6 numeros)");
                    auxDatosValidos = false;
                }
            }
            else
            {
                ventanaAfiliado.mostrarMensaje("No se puede agregar un correo vacio");
                auxDatosValidos = false;
            }
        }
        else
        {
            ventanaAfiliado.mostrarMensaje("No se puede agregar un nombre vacio");
            auxDatosValidos = false;
        }

        return auxDatosValidos;
    }

    private String mostrarDatos(Afiliado auxAfiliado)
    {
        String datos;
        String auxId = String.valueOf(auxAfiliado.getId());
        String auxNombre = auxAfiliado.getNombre();
        String auxDocumento = String.valueOf(auxAfiliado.getDocumento().getNumeroDocumento());
        String auxTipoDocu = auxAfiliado.getDocumento().getTipoDocumento();
        String auxCorreo = auxAfiliado.getCorreo();
        String auxTelefono = String.valueOf(auxAfiliado.getTelefono());

        datos = "\n"+"ID: "+auxId+"\n"+"Nombre: "+auxNombre+"\n"+"# documento: "+auxDocumento+"\n"+"Tipo Documento: "+auxTipoDocu+"\n"+"Correo: "+auxCorreo+"\n"+"Telefono: "+auxTelefono;

        return datos;
    }

    private Object[][] tablaObjectAfiliados(ArrayList<Afiliado> auxAfiliados)
    {
       Object[][] dataAfiliados;
       dataAfiliados = new Object[auxAfiliados.size()][6];

       int auxId;
       String auxNombre;
       String auxTipoDocumento;
       long auxNumeroDocumento;
       String auxCorreo;
       long auxTelefono;

       for(int fila = 0; fila < dataAfiliados.length; fila++)
       {
           auxId = auxAfiliados.get(fila).getId();
           auxNombre = auxAfiliados.get(fila).getNombre();
           auxTipoDocumento = auxAfiliados.get(fila).getDocumento().getTipoDocumento();
           auxNumeroDocumento = auxAfiliados.get(fila).getDocumento().getNumeroDocumento();
           auxCorreo = auxAfiliados.get(fila).getCorreo();
           auxTelefono = auxAfiliados.get(fila).getTelefono();
           
           dataAfiliados[fila][0] = auxId;
           dataAfiliados[fila][1] = auxNombre;
           dataAfiliados[fila][2] = auxTipoDocumento;
           dataAfiliados[fila][3] = auxNumeroDocumento;
           dataAfiliados[fila][4] = auxCorreo;
           dataAfiliados[fila][5] = auxTelefono;
       }

       return dataAfiliados;
    }

    private void listarAfiliados()
    {
        ArrayList<Afiliado> auxAfiliados;
        Object[][] auxDataAfiliados;
        String[] nombresColumnas = {"ID", "NOMBRE", "T. DOCUMENTO", "# DOCUMENTO", "CORREO", "TELEFONO"};
        auxAfiliados = servicioMedicoUV.getAfiliados();
        auxDataAfiliados = tablaObjectAfiliados(auxAfiliados);
        ventanaAfiliado.crearTabla(auxDataAfiliados, nombresColumnas);
        if(auxAfiliados.isEmpty())
        {
            ventanaAfiliado.mostrarMensaje("No hay afiliados listados");
        }
    }

    class ListarAfiliadoListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("REFRESCAR"))
            {
                listarAfiliados();
            }
        }
    }

    private void AgregarAfiliado()
    {
        Afiliado auxAfiliado;
        String auxNombre;
        String auxTipoDocumento;
        long auxNumeroDocumento;
        Documento auxDocumento;
        String auxCorreo;
        long auxTelefono;

        try
        {
            auxNombre = ventanaAfiliado.getTxtNombreAgregar();
            auxCorreo = ventanaAfiliado.getTxtCorreoAgregar();
            auxTipoDocumento = ventanaAfiliado.getBoxTipoDocumentoAgregar();
            auxNumeroDocumento = Long.parseLong(ventanaAfiliado.getTxtDocumentoAgregar());
            auxTelefono = Long.parseLong(ventanaAfiliado.getTxtTelefonoAgregar());

            if (comprobarDatosAfiliado(0, auxNombre, auxTipoDocumento, auxNumeroDocumento, auxCorreo, auxTelefono))
            {
                auxDocumento = new Documento(auxTipoDocumento, auxNumeroDocumento);
                auxAfiliado = new Afiliado(auxNombre, auxDocumento, auxCorreo, auxTelefono);
                if (servicioMedicoUV.agregarAfiliado(auxAfiliado))
                {
                    ventanaAfiliado.mostrarMensaje("Afiliado agregado con éxito" + mostrarDatos(auxAfiliado));
                    servicioMedicoUV.escribirAfiliados();
                }
                else
                {
                    ventanaAfiliado.mostrarMensaje("No se pudo agregar el afiliado");
                }
            }
        }
        catch(NumberFormatException ex)
        {
            ventanaAfiliado.mostrarMensaje("Ingrese números enteros en los campos de documento y teléfono");
        }
        ventanaAfiliado.limpiarDatosAgregar();
    }

    class AgregarAfiliadoListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("AGREGAR"))
            {
                AgregarAfiliado();
            }
        }
    }

    private void buscarEditarAfiliado()
    {
        Afiliado auxAfiliado;
        int auxId;
        String auxNombre;
        String auxNumeroDocumento;
        Documento auxDocumento;
        String auxCorreo;
        String auxTelefono;

        try
        {
            auxId = Integer.parseInt(ventanaAfiliado.getIdEditar());
            auxAfiliado = servicioMedicoUV.getAfiliado(auxId);

            if(auxAfiliado != null)
            {
                auxNombre = auxAfiliado.getNombre();
                auxDocumento = auxAfiliado.getDocumento();
                auxNumeroDocumento = String.valueOf(auxDocumento.getNumeroDocumento());
                auxCorreo = auxAfiliado.getCorreo();
                auxTelefono = String.valueOf(auxAfiliado.getTelefono());

                ventanaAfiliado.activarControlesEditar();
                ventanaAfiliado.setTxtNombreEditar(auxNombre);
                ventanaAfiliado.setTxtDocumentoEditar(auxNumeroDocumento);
                ventanaAfiliado.setBoxTipoDocumentoEditar(auxDocumento);
                ventanaAfiliado.setTxtTelefonoEditar(auxTelefono);
                ventanaAfiliado.setTxtCorreoEditar(auxCorreo);
                ventanaAfiliado.manejarTextFieldIdEditar(false);
                ventanaAfiliado.manejarBtnCancelarEditar(true);
                ventanaAfiliado.manajerBtnEditar(true);
            }
            else
            {
                ventanaAfiliado.mostrarMensaje("Afiliado no encontrado");
                ventanaAfiliado.setIdEditar("");
            }
        }
        catch(Exception ex)
        {
            ventanaAfiliado.mostrarMensaje("Ingrese un Entero en el campo ID");
            ventanaAfiliado.setIdEditar("");
        }
    }

    class BuscarEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                buscarEditarAfiliado();
            }
        }
    }

    private void editarAfiliado()
    {
        Afiliado auxAfiliado;
        int auxId;
        String auxNombre;
        Documento auxDocumento;
        String auxTipoDocumento;
        long auxNumeroDocumento;
        String auxCorreo;
        long auxTelefono;

        auxId = Integer.parseInt(ventanaAfiliado.getIdEditar());
        auxAfiliado = servicioMedicoUV.getAfiliado(auxId);

        try
        {
            auxNombre = ventanaAfiliado.getTxtNombreEditar();
            auxTipoDocumento = ventanaAfiliado.getBoxTipoDocumentoEditar();
            auxNumeroDocumento = Long.parseLong(ventanaAfiliado.getTxtDocumentoEditar());
            auxTelefono = Long.parseLong(ventanaAfiliado.getTxtTelefonoEditar());
            auxCorreo = ventanaAfiliado.getTxtCorreoEditar();

            if(auxAfiliado != null)
            {
                if(comprobarDatosAfiliado(auxId ,auxNombre, auxTipoDocumento, auxNumeroDocumento, auxCorreo, auxTelefono))
                {
                    auxAfiliado.setNombre(auxNombre);
                    auxDocumento = auxAfiliado.getDocumento();
                    auxDocumento.setTipoDocumento(auxTipoDocumento);
                    auxDocumento.setNumeroDocumento(auxNumeroDocumento);
                    auxAfiliado.setCorreo(auxCorreo);
                    auxAfiliado.setTelefono(auxTelefono);
                    if(servicioMedicoUV.actualizarAfiliado(auxAfiliado))
                    {
                        ventanaAfiliado.mostrarMensaje("Afiliado editado con éxito" + mostrarDatos(auxAfiliado));
                        servicioMedicoUV.escribirAfiliados();
                        if(comprobarAsignacionCita(auxAfiliado))
                        {
                            servicioMedicoUV.escribirCitas();
                        }
                    }
                    else
                    {
                        ventanaAfiliado.mostrarMensaje("No se pudo editar el afiliado");
                    }
                }
            }
            else
            {
                ventanaAfiliado.mostrarMensaje("Afiliado no encontrado");
            }
        }
        catch (NumberFormatException ex)
        {
            ventanaAfiliado.mostrarMensaje("Ingrese números enteros en los campos de documento y teléfono");
        }
        ventanaAfiliado.manejarTextFieldIdEditar(true);
        ventanaAfiliado.manejarBtnCancelarEditar(false);
        ventanaAfiliado.manajerBtnEditar(false);
        ventanaAfiliado.setIdEditar("");
        ventanaAfiliado.limpiarDatosEditar();
        ventanaAfiliado.desactivarControlesEditar();
    }

    class EditarAfiliadoListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equalsIgnoreCase("EDITAR"))
            {
            editarAfiliado();
            }
        }
    }

    private void cancelarEditarAfiliado()
    {
        ventanaAfiliado.manejarTextFieldIdEditar(true);
        ventanaAfiliado.manejarBtnCancelarEditar(false);
        ventanaAfiliado.manajerBtnEditar(false);
        ventanaAfiliado.setIdEditar("");
        ventanaAfiliado.limpiarDatosEditar();
        ventanaAfiliado.desactivarControlesEditar();
    }

    class CancelarEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            cancelarEditarAfiliado();
        }
    }

    private void buscarEliminarAfiliado()
    {
        Afiliado auxAfiliado;
        int auxId;
        String auxNombre;
        Documento auxDocumento;
        String auxTipoDocumento;
        String auxNumeroDocumento;;
        String auxCorreo;
        String auxTelefono;

        try
        {
            auxId = Integer.parseInt(ventanaAfiliado.getIdEliminar());
            auxAfiliado = servicioMedicoUV.getAfiliado(auxId);

            if(auxAfiliado != null)
            {
                auxNombre = auxAfiliado.getNombre();
                auxDocumento = auxAfiliado.getDocumento();
                auxTipoDocumento = auxDocumento.getTipoDocumento();
                auxNumeroDocumento = String.valueOf(auxDocumento.getNumeroDocumento());
                auxCorreo = auxAfiliado.getCorreo();
                auxTelefono = String.valueOf(auxAfiliado.getTelefono());

                ventanaAfiliado.manejarTextFieldIdElimnar(false);
                ventanaAfiliado.activarControlesEliminar();
                ventanaAfiliado.setTxtNombreEliminar(auxNombre);
                ventanaAfiliado.setTxtDocumentoEliminar(auxNumeroDocumento);
                ventanaAfiliado.setTxtTipoDocumentoEliminar(auxTipoDocumento);
                ventanaAfiliado.setTxtCorreoEliminar(auxCorreo);
                ventanaAfiliado.setTxtTelefonoEliminar(auxTelefono);
                ventanaAfiliado.desactivarControlesEliminar();
                ventanaAfiliado.manejarBtnCancelarEliminar(true);
                ventanaAfiliado.manajerBtnEliminar(true);
            }
            else
            {
                ventanaAfiliado.mostrarMensaje("Afiliado no encontrado");
                ventanaAfiliado.setIdEditar("");
            }
        }
        catch(Exception ex)
        {
            ventanaAfiliado.mostrarMensaje("Ingrese un Entero en el campo ID");
            ventanaAfiliado.setIdEditar("");
        }
    }

    class BuscarEliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            buscarEliminarAfiliado();
        }
    }
    
    private void eliminarAfiliado()
    {
        Afiliado auxAfiliado;
        int auxId;

        auxId = Integer.parseInt(ventanaAfiliado.getIdEliminar());
        auxAfiliado = servicioMedicoUV.getAfiliado(auxId);

        if(auxAfiliado != null)
        {
            if(!comprobarAsignacionCita(auxAfiliado))
            {
                if(servicioMedicoUV.eliminarAfiliado(auxAfiliado))
                {
                    ventanaAfiliado.mostrarMensaje("Afiliado eliminado con éxito");
                    servicioMedicoUV.escribirAfiliados();
                }
                else
                {
                    ventanaAfiliado.mostrarMensaje("No se pudo eliminar el consultorio");
                }
            }
            else
            {
                ventanaAfiliado.mostrarMensaje("No se puede eliminar un afiliado que tiene asignado una cita");
            }
        }
        else
        {
            ventanaAfiliado.mostrarMensaje("Afiliado no encontrado");
        }
        ventanaAfiliado.limpiarDatosEliminar();
        ventanaAfiliado.setIdEliminar("");
        ventanaAfiliado.manejarTextFieldIdElimnar(true);
        ventanaAfiliado.manejarBtnCancelarEliminar(false);
        ventanaAfiliado.manajerBtnEliminar(false);
    }
    
    class EliminarAfiliadoListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equalsIgnoreCase("ELIMINAR"))
            {
                eliminarAfiliado();
            }
        }   
    }

    public void cancelarEliminarAfiliado()
    {
        ventanaAfiliado.limpiarDatosEliminar();
        ventanaAfiliado.setIdEliminar("");
        ventanaAfiliado.manejarTextFieldIdElimnar(true);
        ventanaAfiliado.manejarBtnCancelarEliminar(false);
        ventanaAfiliado.manajerBtnEliminar(false);
        ventanaAfiliado.desactivarControlesEliminar();
    }
    
    class CancelarEliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                cancelarEliminarAfiliado();
            }
        }        
    }

    private void volverMenuPrincipal()
    {
        ventanaAfiliado.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu();
        ControladorMenu controladorMenu = new ControladorMenu(servicioMedicoUV, ventanaMenu);
    }

    class AtrasAfiliadoListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("ATRAS"))
            {
                volverMenuPrincipal();
            }
        }
    }
}
