
package controlador;

import modelo.Afiliado;
import modelo.Empresa;
import Vista.VentanaAfiliado;
import Vista.VentanaMenu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Consultorio;
import modelo.Documento;
import modelo.Medico;
import modelo.Servicio;
/**
 *
 * MESSI
 */
public class ControladorAfiliado
{
    private Empresa servicioMedicoUV;
    private VentanaAfiliado ventanaAfiliado;
    
    public ControladorAfiliado (Empresa auxServicioMedicoUV, VentanaAfiliado auxVentanaAfiliado)
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
    
    public Object[][] dataAfiliados(ArrayList<Afiliado> auxAfiliados)
    {
       Object[][] dataAfiliados;
       dataAfiliados = new Object[auxAfiliados.size()][6];
       
       for(int fila=0; fila < dataAfiliados.length; fila++)
       {
           int auxId;
           auxId = auxAfiliados.get(fila).getId();
           
           String auxNombre;
           auxNombre = auxAfiliados.get(fila).getNombre();
           
           String auxTipoDocumento;
           auxTipoDocumento = auxAfiliados.get(fila).getDocumento().getTipoDocumento();
           
           Long auxDocumento;
           auxDocumento = auxAfiliados.get(fila).getDocumento().getNumeroDocumento();
           
           String auxCorreo;
           auxCorreo = auxAfiliados.get(fila).getCorreo();
           
           Long auxTelefono;
           auxTelefono = auxAfiliados.get(fila).getTelefono();
           
           dataAfiliados[fila][0] = auxId;
           dataAfiliados[fila][1] = auxNombre;
           dataAfiliados[fila][2] = auxTipoDocumento;
           dataAfiliados[fila][3] = auxDocumento;
           dataAfiliados[fila][4] = auxCorreo;
           dataAfiliados[fila][5] = auxTelefono;
       }
       return dataAfiliados;
    }
    
    private void AgregarAfiliado()
    {
        String auxNombre;
        String auxCorreo;
        long auxTelefono;
        
        auxNombre = ventanaAfiliado.getTxtNombreAgregar();
        auxCorreo = ventanaAfiliado.getTxtCorreoAgregar();
        
        
        try
        {
            Documento auxDocumento = new Documento(ventanaAfiliado.getBoxTipoDocumentoAgregar(), Long.parseLong(ventanaAfiliado.getTxtDocumentoAgregar()));
            auxTelefono = Long.parseLong(ventanaAfiliado.getTxtTelefonoAgregar());

            if(Long.parseLong(ventanaAfiliado.getTxtDocumentoAgregar())>=100000 && auxTelefono>=100000)
            {
                if (comprobarDatosAfiliado(auxNombre, auxDocumento, auxCorreo, auxTelefono))
                {
                    Afiliado auxAfiliado = new Afiliado(auxNombre, auxDocumento, auxCorreo, auxTelefono);
                    if (servicioMedicoUV.agregarAfiliado(auxAfiliado))
                    {
                        ventanaAfiliado.mostrarMensaje("Afiliado agregado con éxito" + mostrarDatos(auxAfiliado));
                        servicioMedicoUV.escribirAfiliados();
                        ventanaAfiliado.limpiarDatosAgregar();
                    }
                    else
                    {
                        ventanaAfiliado.mostrarMensaje("No se pudo agregar el afiliado");
                        ventanaAfiliado.limpiarDatosAgregar();
                    }
                }
            }
            else
            {
                ventanaAfiliado.mostrarMensaje("Ingrese un numero de documento y de telefono valido");
            }
        }
        catch(NumberFormatException ex)
        {
            ventanaAfiliado.mostrarMensaje("Ingrese números en los campos de documento y teléfono");
        }
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
    
    private void editarAfiliado()
    {
        String auxNombre;
        Afiliado auxAfiliado;
        Documento auxDocumento;
        String auxTipoDocumento;
        long auxNumDocumento;
        String auxCorreo;
        long auxTelefono;

        if (ventanaAfiliado.getIdEditar().length() < 0)
        {
            auxAfiliado = servicioMedicoUV.getAfiliado(Integer.parseInt(ventanaAfiliado.getIdEditar()));
            if (auxAfiliado != null)
            {

                    auxNombre = ventanaAfiliado.getTxtNombreEditar();
                    auxCorreo = ventanaAfiliado.getTxtCorreoEditar();
                    auxAfiliado.setDocumento(null);
                    auxTipoDocumento = ventanaAfiliado.getBoxTipoDocumentoEditar();

                    try {
                        auxNumDocumento = Long.parseLong(ventanaAfiliado.getTxtDocumentoEditar());
                        auxTelefono = Long.parseLong(ventanaAfiliado.getTxtTelefonoEditar());
                        auxDocumento = new Documento(auxTipoDocumento, auxNumDocumento);

                        if (auxNumDocumento >= 100000 && auxTelefono >= 100000) {
                            if (comprobarDatosAfiliado(auxNombre, auxDocumento, auxCorreo, auxTelefono)) {
                                auxAfiliado.setDocumento(auxDocumento);
                                if (servicioMedicoUV.actualizarAfiliado(auxAfiliado)) {
                                    auxAfiliado.setNombre(auxNombre);
                                    auxAfiliado.setCorreo(auxCorreo);
                                    auxAfiliado.setTelefono(auxTelefono);
                                    servicioMedicoUV.escribirAfiliados();
                                    ventanaAfiliado.mostrarMensaje("Afiliado editado con éxito" + mostrarDatos(auxAfiliado));
                                    ventanaAfiliado.manejarTextFieldIdEditar(true);
                                    ventanaAfiliado.setIdEditar("");
                                    ventanaAfiliado.limpiarDatosEditar();
                                    ventanaAfiliado.desactivarControlesEditar();
                                    ventanaAfiliado.manejarBtnCancelarEditar(false);
                                } else {
                                    ventanaAfiliado.mostrarMensaje("No se pudo editar el afiliado");
                                    ventanaAfiliado.limpiarDatosEditar();
                                    ventanaAfiliado.setIdEditar("");
                                }
                            }
                        } else {
                            ventanaAfiliado.mostrarMensaje("Ingrese un numero de documento y de telefono valido");
                        }
                    } catch (NumberFormatException ex) {
                        ventanaAfiliado.mostrarMensaje("Ingrese números en los campos de documento y teléfono");
                    }
                }
            else
            {
                ventanaAfiliado.mostrarMensaje("Afiliado no encontrado");
                ventanaAfiliado.activarControlesEditar();
                ventanaAfiliado.limpiarDatosEditar();
                ventanaAfiliado.setIdEditar("");
                ventanaAfiliado.manejarTextFieldIdEditar(true);
                ventanaAfiliado.desactivarControlesEditar();
                ventanaAfiliado.manejarBtnCancelarEditar(false);
            }
        }
        else
        {
            ventanaAfiliado.mostrarMensaje("Ingrese un Entero en el campo ID");
        }
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
    
    class BuscarEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            Afiliado auxAfiliado;
            int auxNumeroId;
            
            if(e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                try
                {
                    auxNumeroId = Integer.parseInt(ventanaAfiliado.getIdEditar());
                    auxAfiliado = servicioMedicoUV.getAfiliado(auxNumeroId);
                    
                    if(auxAfiliado!=null)
                    {
                        ventanaAfiliado.manejarTextFieldIdEditar(false);
                        ventanaAfiliado.activarControlesEditar();
                        ventanaAfiliado.setTxtNombreEditar(auxAfiliado.getNombre());
                        ventanaAfiliado.setTxtDocumentoEditar(String.valueOf(auxAfiliado.getDocumento().getNumeroDocumento()));
                        ventanaAfiliado.setBoxTipoDocumentoEditar(auxAfiliado.getDocumento());
                        ventanaAfiliado.setTxtTelefonoEditar(String.valueOf(auxAfiliado.getTelefono()));
                        ventanaAfiliado.setTxtCorreoEditar(auxAfiliado.getCorreo());
                        ventanaAfiliado.manejarBtnCancelarEditar(true);
                    }
                    else
                    {
                        ventanaAfiliado.mostrarMensaje("Afiliado no encontrado");
                        ventanaAfiliado.setIdEditar("");
                        ventanaAfiliado.limpiarDatosEditar();
                        ventanaAfiliado.desactivarControlesEditar();
                        ventanaAfiliado.manejarTextFieldIdEditar(true);
                        ventanaAfiliado.manejarBtnCancelarEditar(false);
                    }
                }
                catch(Exception ex)
                {
                    ventanaAfiliado.mostrarMensaje("Ingrese un Entero en el campo ID");
                }
            }
        }   
    }
    
    class CancelarEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            Afiliado auxAfiliado;
            
            if(e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                auxAfiliado = servicioMedicoUV.getAfiliado(Integer.parseInt(ventanaAfiliado.getIdEditar()));
                
                if(auxAfiliado!=null)
                {
                    ventanaAfiliado.manejarTextFieldIdEditar(true);
                    ventanaAfiliado.limpiarDatosEditar();
                    ventanaAfiliado.desactivarControlesEditar();
                    ventanaAfiliado.manejarBtnCancelarEditar(false);
                }
                else
                {
                    ventanaAfiliado.mostrarMensaje("No existe la ID seleccionada");
                    ventanaAfiliado.setIdEditar("");
                    ventanaAfiliado.limpiarDatosEditar();
                    ventanaAfiliado.desactivarControlesEditar();
                    ventanaAfiliado.manejarTextFieldIdEditar(true);
                    ventanaAfiliado.manejarBtnCancelarEditar(false);
                }
            }
        }   
    }
    
    private void eliminarAfiliado()
    {
        Afiliado auxAfiliado;
        int auxIdAfiliado;
        
        try
        {
            auxIdAfiliado = Integer.parseInt(ventanaAfiliado.getIdEliminar());
            auxAfiliado = servicioMedicoUV.getAfiliado(auxIdAfiliado);
            
            if(auxAfiliado!=null)
            {
                if(servicioMedicoUV.eliminarAfiliado(auxAfiliado))
                {
                    ventanaAfiliado.mostrarMensaje("Afiliado eliminado con éxito");
                    servicioMedicoUV.escribirAfiliados();
                    ventanaAfiliado.limpiarDatosEliminar();
                    ventanaAfiliado.setIdEliminar("");
                    ventanaAfiliado.manejarTextFieldIdElimnar(true);
                    ventanaAfiliado.manejarBtnCancelarEliminar(false);
                }
            }
        }
        catch(Exception ex)
        {
            ventanaAfiliado.mostrarMensaje("Ingrese un entero en el campo ID");
            ventanaAfiliado.setIdEliminar("");
        }
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
    
    class BuscarEliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            Afiliado auxAfiliado;
            int auxNumeroId;
            
            if(e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                try
                {
                    auxNumeroId = Integer.parseInt(ventanaAfiliado.getIdEliminar());
                    auxAfiliado = servicioMedicoUV.getAfiliado(auxNumeroId);
                    
                    if(auxAfiliado!=null)
                    {
                        ventanaAfiliado.manejarTextFieldIdElimnar(false);
                        ventanaAfiliado.activarControlesEliminar();
                        ventanaAfiliado.setTxtNombreEliminar(auxAfiliado.getNombre());
                        ventanaAfiliado.setTxtDocumentoEliminar(String.valueOf(auxAfiliado.getDocumento().getNumeroDocumento()));
                        ventanaAfiliado.setTxtTipoDocumentoEliminar(auxAfiliado.getDocumento().getTipoDocumento());
                        ventanaAfiliado.setTxtCorreoEliminar(auxAfiliado.getCorreo());
                        ventanaAfiliado.setTxtTelefonoEliminar(String.valueOf(auxAfiliado.getTelefono()));
                        ventanaAfiliado.desactivarControlesEliminar();
                        ventanaAfiliado.manejarBtnCancelarEliminar(true);
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
                }
            }
        }       
    }
    
    class CancelarEliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                ventanaAfiliado.manejarTextFieldIdElimnar(true);
                ventanaAfiliado.limpiarDatosEliminar();
                ventanaAfiliado.desactivarControlesEliminar();
                ventanaAfiliado.manejarBtnCancelarEliminar(false);
            }
        }        
    }
    
    private void listarAfiliados()
    {
        ArrayList<Afiliado> auxAfiliados;
        Object[][] auxDataAfiliado;
        String[] nombresColumnas = {"ID", "NOMBRE", "T. DOCUMENTO", "# DOCUMENTO", "CORREO", "TELEFONO"};
        auxAfiliados = servicioMedicoUV.getAfiliados();
        
        if(!auxAfiliados.isEmpty())
        {
            ventanaAfiliado.crearTabla(dataAfiliados(auxAfiliados), nombresColumnas);
        }
        else
        {
            ventanaAfiliado.crearTabla(dataAfiliados(auxAfiliados), nombresColumnas);
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
    
    
    public Boolean comprobarDatosAfiliado(String nombre, Documento documento, String correo, Long telefono)
    {
        Boolean DatosValidos = false;
        ArrayList<Afiliado> auxAfiliados;
        auxAfiliados = servicioMedicoUV.getAfiliados();
            if (nombre.length() != 0 && String.valueOf(documento.getNumeroDocumento()).length() != 0 && documento.getTipoDocumento()!=null && correo.length() != 0 && String.valueOf(telefono).length()!=0)
            {
                DatosValidos = true;
                for (Afiliado afiliado : auxAfiliados)
                {
                    if (afiliado.getDocumento()!=null && afiliado.getDocumento().getNumeroDocumento() == documento.getNumeroDocumento()) 
                    {
                        ventanaAfiliado.mostrarMensaje("Ya existe un afiliado con este documento");
                        DatosValidos = false;
                        break;
                    }
                }
            }
            else 
            {
                ventanaAfiliado.mostrarMensaje("Rellene todos los campos");
            }
            return DatosValidos;
    }
    
    public String mostrarDatos(Afiliado afiliado)
    {
        String datos;
        String auxId = String.valueOf(afiliado.getId());
        String auxNombre = afiliado.getNombre();
        String auxDocumento = String.valueOf(afiliado.getDocumento().getNumeroDocumento());
        String auxTipoDocu = afiliado.getDocumento().getTipoDocumento();
        String auxCorreo = afiliado.getCorreo();
        String auxTelefono = String.valueOf(afiliado.getTelefono());

        datos = "\n"+"ID: "+auxId+"\n"+"Nombre: "+auxNombre+"\n"+"# documento: "+auxDocumento+"\n"+"Tipo Documento: "+auxTipoDocu+"\n"+"Correo: "+auxCorreo+"\n"+"Telefono: "+auxTelefono;

        return datos;
    }
}

