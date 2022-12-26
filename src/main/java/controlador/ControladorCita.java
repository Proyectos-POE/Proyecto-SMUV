

package controlador;

import modelo.Afiliado;
import modelo.Empresa;
import Vista.VentanaCita;
import Vista.VentanaMenu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.*;
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
        
        rellenarAfiliadosAgregar(servicioMedicoUV.getAfiliados());
        rellenarServiciosAgregar(servicioMedicoUV.getServicios());
        ventanaCita.setEnabledMedicoAgregar(false);
        ventanaCita.setEnabledHoraAgregar(false);
        ventanaCita.setVisible(true);
        ventanaCita.setLocationRelativeTo(null);
        
        this.ventanaCita.addBtnAgregarListener(new AgregarCitaListener());
        this.ventanaCita.addBtnBuscarEditarListener(new BuscarEditarCitaListener());
        this.ventanaCita.addBtnEditarListener(new EditarCitaListener());
        this.ventanaCita.addBtnBuscarEliminarListener(new BuscarEliminarListener());
        this.ventanaCita.addBtnEliminarListener(new EliminarCitaListener());
        this.ventanaCita.addBtnActualizarListener(new ListarCitaListener());
        this.ventanaCita.addBtnAtrasListener(new AtrasCitaListener());
        this.ventanaCita.addBtnCancelarEditarListener(new CancelarEditarListener());
        this.ventanaCita.addBtnCancelarEliminarListener(new CancelarEliminarListener());
        this.ventanaCita.addBoxServicioAgregarListener(new SeleccionarServicioAgregarListener());
        this.ventanaCita.addBoxServicioEditarListener(new SeleccionarServicioEditarListener());
        this.ventanaCita.addBtnCancelarAgregarListener(new CancelarAgregarListener());
        this.ventanaCita.addBtnHoraAgregarListener(new AgregarHoraListener());      
    }
    
    public Boolean comprobarDatosCita(Afiliado afiliado, Medico medico, Servicio servicio, Fecha fecha, Hora hora)
    {
        Boolean DatosValidos = false;
        ArrayList<Cita> auxCitas;
        auxCitas = servicioMedicoUV.getCitas();
        
        if(afiliado.getNombre().length()!=0)
        {
            if(String.valueOf(servicio.getNombre()).length()!= 0)
            {
                if(medico.getNombre().length()!=0)
                {
                    if(String.valueOf(fecha.getFecha()).length()!=0)
                    {
                        if(hora.toString().length()!=0)
                        {
                            DatosValidos = true;
                            for(Cita cita: auxCitas)
                            {
                                if(hora.isAsignado())
                                {
                                    ventanaCita.mostrarMensaje("Ya existe una cita con este horario");
                                    DatosValidos = false;
                                    break;
                                }
                            }
                        }
                        else
                        {
                            ventanaCita.mostrarMensaje("Escoja una hora");
                        }
                    }
                    else
                    {
                        ventanaCita.mostrarMensaje("Agregue una fecha");
                    }
                }
                else
                {
                    ventanaCita.mostrarMensaje("Escoja un medico");
                }
            }
            else
            {
                ventanaCita.mostrarMensaje("Escoja un servicio");
            }
        }
        else
        {
            ventanaCita.mostrarMensaje("Escoja un afiliado");
        }
        return DatosValidos;
    }
    
    public String mostrarDatos(Cita cita)
    {
        String datos;
        String auxId = String.valueOf(cita.getId());
        String auxAfiliado = String.valueOf(cita.getAfiliado());
        String auxServicio = String.valueOf(cita.getServicio());
        String auxMedico = String.valueOf(cita.getMedico());
        String auxFecha = String.valueOf(cita.getFecha());
        String auxHora = String.valueOf(cita.getHora());
        
        datos = "\n"+"ID: "+auxId+"\n"+"Afiliado: "+auxAfiliado+"\n"+"Medico: "+auxMedico+"\n"+"Servicio: "+auxServicio+"\n"+"Fecha: "+auxFecha+"\n"+"Hora: "+auxHora;
        
        return datos;
    }
    
    public Object[][] tablaObjectCitas(ArrayList<Cita> auxCitas)
    {
        Object[][] dataCitas;
        dataCitas = new Object[auxCitas.size()][7];
        
        for(int fila=0; fila < dataCitas.length; fila++)
        {
            int auxId;
            auxId = auxCitas.get(fila).getId();
            
            Afiliado auxAfiliado;
            auxAfiliado = auxCitas.get(fila).getAfiliado();
            
            Medico auxMedico;
            auxMedico = auxCitas.get(fila).getMedico();
            
            Servicio auxServicio;
            auxServicio = auxCitas.get(fila).getServicio();
            
            Consultorio auxConsultorio;
            auxConsultorio = auxCitas.get(fila).getConsultorio();
            
            Fecha auxFecha;
            auxFecha = auxCitas.get(fila).getFecha();
            
            Hora auxHora;
            auxHora = auxCitas.get(fila).getHora();
            
            dataCitas[fila][0] = auxId;
            dataCitas[fila][1] = auxAfiliado;
            dataCitas[fila][2] = auxMedico;
            dataCitas[fila][3] = auxServicio;
            dataCitas[fila][4] = auxConsultorio;
            dataCitas[fila][5] = auxFecha;
            dataCitas[fila][6] = auxHora;
        }
        return dataCitas;
    }
    
    private void listarCitas()
    {
        ArrayList<Cita> auxCitas;
        Object[][] auxDataCita;
        String[] nombresColumnas = {"ID", "AFILIADO", "MEDICO", "SERVICIO", "CONSULTORIO", "FECHA", "HORA"};
        auxCitas = servicioMedicoUV.getCitas();
        
        if(!auxCitas.isEmpty())
        {
            ventanaCita.crearTabla(tablaObjectCitas(auxCitas), nombresColumnas);
        }
        else
        {
            ventanaCita.crearTabla(tablaObjectCitas(auxCitas), nombresColumnas);
            ventanaCita.mostrarMensaje("No hay afiliados listados");
        }
    }
    
    class ListarCitaListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equalsIgnoreCase("REFRESCAR"))
            {
                listarCitas();
            }
        }      
    }
    
    public void listarHorariosOcupados(Afiliado auxAfiliado, Medico auxMedico,Fecha auxFecha)
    {
        ArrayList<Cita> citas = servicioMedicoUV.getCitas();
        for(int i = 0; i < citas.size(); i++)
        {
            if (citas.get(i).getFecha().getFecha().isEqual(auxFecha.getFecha())&&(citas.get(i).getAfiliado().getId()==auxAfiliado.getId()||citas.get(i).getMedico().getId()==auxMedico.getId()))                
            {
                servicioMedicoUV.setAsignado(citas.get(i).getHora());
                System.out.println("a");
            }
        }
    }
    
    private void agregarCita()
    {
        Cita auxCita;
        Afiliado auxAfiliado;
        Servicio auxServicio;
        Medico auxMedico;
        Consultorio auxConsultorio;
        int auxFechaAnho;
        int auxFechaMes;
        int auxFechaDia;
        Hora auxHora;
        Fecha auxFecha;
        
        auxAfiliado = ventanaCita.getBoxAfiliadoAgregar();
        auxServicio = ventanaCita.getBoxServicioAgregar();
        auxMedico = ventanaCita.getBoxMedicoAgregar();
        auxConsultorio = auxMedico.getConsultorio();
        try
        {
            auxFechaAnho = Integer.parseInt(ventanaCita.getTxtFechaAnhoAgregar());
            auxFechaMes = Integer.parseInt(ventanaCita.getTxtFechaMesAgregar());
            auxFechaDia = Integer.parseInt(ventanaCita.getTxtFechaDiaAgregar());
            auxFecha = new Fecha(LocalDate.of(auxFechaAnho,auxFechaMes,auxFechaDia));
            auxHora = ventanaCita.getBoxHoraAgregar();
            auxCita = new Cita(auxAfiliado,auxMedico,auxConsultorio,auxServicio,auxFecha,auxHora);
                
            if(servicioMedicoUV.agregarCita(auxCita))
            {
                ventanaCita.mostrarMensaje("Cita agregada con exito:"+mostrarDatos(auxCita));
                ventanaCita.limpiarDatosAgregar();
                ventanaCita.setEnabledAfiliadoAgregar(true);
                ventanaCita.setEnabledServicioAgregar(true);
                ventanaCita.setEnabledFechaAnhoAgregar(true);
                ventanaCita.setEnabledFechaDiaAgregar(true);
                ventanaCita.setEnabledFechaMesAgregar(true);
                ventanaCita.setEnabledHoraAgregar(false);
                ventanaCita.vaciarBoxesAgregar();
                rellenarAfiliadosAgregar(servicioMedicoUV.getAfiliados());
                rellenarServiciosAgregar(servicioMedicoUV.getServicios());
                ventanaCita.setNullBoxServicioAgregar();
                ventanaCita.vaciarBoxServicioAgregar();
                rellenarServiciosAgregar(servicioMedicoUV.getServicios());
                ventanaCita.setEnabledMedicoAgregar(false);
                servicioMedicoUV.restablecerDisponibilidad();
            }
            else
            {
                ventanaCita.mostrarMensaje("No se pudo agregar la cita");
                ventanaCita.limpiarDatosAgregar();
            }
        }
        catch(Exception ex)
        {
            ventanaCita.mostrarMensaje("Ingrese enteros en el campo FECHA");
        }               
    }
    
    class AgregarCitaListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equalsIgnoreCase("AGREGAR"))
            {
                agregarCita();
            }
        } 
    }
    
    private void cancelarAgregarCita()
    {
        ventanaCita.limpiarDatosAgregar();
        ventanaCita.setEnabledAfiliadoAgregar(true);
        ventanaCita.setEnabledServicioAgregar(true);
        ventanaCita.setEnabledFechaAnhoAgregar(true);
        ventanaCita.setEnabledFechaDiaAgregar(true);
        ventanaCita.setEnabledFechaMesAgregar(true);
        ventanaCita.setEnabledHoraAgregar(false);
        ventanaCita.vaciarBoxesAgregar();
        rellenarAfiliadosAgregar(servicioMedicoUV.getAfiliados());
        rellenarServiciosAgregar(servicioMedicoUV.getServicios());
        ventanaCita.setNullBoxServicioAgregar();
        ventanaCita.vaciarBoxServicioAgregar();
        rellenarServiciosAgregar(servicioMedicoUV.getServicios());
        ventanaCita.setEnabledMedicoAgregar(false);
    }
    
    class CancelarAgregarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                cancelarAgregarCita();
            }        
        }  
    }
    
    private void agregarHoraCita()
    {
        int auxFechaAnho;
        int auxFechaMes;
        int auxFechaDia;
        Fecha auxFecha;
        Afiliado auxAfiliado;
        Medico auxMedico;
        Servicio auxServicio;

        try
        {
            auxAfiliado = ventanaCita.getBoxAfiliadoAgregar();
            auxMedico = ventanaCita.getBoxMedicoAgregar();
            auxServicio = ventanaCita.getBoxServicioAgregar();
            auxFechaAnho = Integer.parseInt(ventanaCita.getTxtFechaAnhoAgregar());
            auxFechaMes = Integer.parseInt(ventanaCita.getTxtFechaMesAgregar());
            auxFechaDia = Integer.parseInt(ventanaCita.getTxtFechaDiaAgregar());
            auxFecha = new Fecha(LocalDate.of(auxFechaAnho,auxFechaMes,auxFechaDia));

                if(!auxFecha.getFecha().isBefore(LocalDate.now())&&!auxFecha.getFecha().isEqual(LocalDate.now()))
                {
                    if(auxFecha.getFecha().isBefore(LocalDate.of(2025, 1, 1)))
                    {
                        if(auxAfiliado != null && auxMedico != null && auxServicio != null)
                        {
                            listarHorariosOcupados(auxAfiliado, auxMedico, auxFecha);
                            rellenarHorasAgregar(servicioMedicoUV.getHorario(false));
                            ventanaCita.setEnabledHoraAgregar(true);
                            ventanaCita.desactivarControlesAgregar();
                        }
                        else
                        {
                            ventanaCita.mostrarMensaje("Rellene los campos anteriores");
                        }
                    }
                    else
                    {
                        ventanaCita.mostrarMensaje("Solo se registran citas hasta 2025-1-1");
                    }
                }
                else
                {
                    ventanaCita.mostrarMensaje("Agregue una fecha posterior al día de hoy");
                }
        }
        catch(DateTimeException ex)
        {
            ventanaCita.mostrarMensaje("Agregue una fecha correcta");
        }
        catch(NumberFormatException ex)
        {
            ventanaCita.mostrarMensaje("Agregue una fecha");
        }
    }
    
    class AgregarHoraListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equalsIgnoreCase("HORA"))
            {
                agregarHoraCita();
            }
        }       
    }
    
    //Panel Editar

    private void buscarEditarCita()
    {
        Cita auxCita;
        Cita auxCita2;
        int auxNumeroId;
        int auxFechaAnho;
        int auxFechaMes;
        int auxFechaDia;
        
        auxNumeroId = Integer.parseInt(ventanaCita.getIdEditar());
        auxCita = servicioMedicoUV.getCita(auxNumeroId);
        auxCita2 = servicioMedicoUV.getCita(auxNumeroId);

        try
            {
            auxFechaAnho = auxCita2.getFecha().getFecha().getYear();
            auxFechaMes = auxCita2.getFecha().getFecha().getMonthValue();
            auxFechaDia = auxCita2.getFecha().getFecha().getDayOfMonth();


            if(auxCita != null)
            {
                ventanaCita.setEnabledAfiliadoEditar(false);
                ventanaCita.manejarTextFieldIdEditar(false);
                ventanaCita.setEnabledAfiliadoEditar(false);
                rellenarAfiliadosEditar(servicioMedicoUV.getAfiliados());
                rellenarServiciosEditar(servicioMedicoUV.getServicios());
                ventanaCita.vaciarBoxServicioEditar();
                rellenarServiciosEditar(servicioMedicoUV.getServicios());
                ventanaCita.setEnabledMedicoEditar(false);
                rellenarHorasEditar(servicioMedicoUV.getHorario());
                ventanaCita.activarControlesEditar();
                ventanaCita.setBoxAfiliadoEditar(auxCita.getAfiliado());
                ventanaCita.setBoxServicioEditar(auxCita.getServicio());
                ventanaCita.setBoxMedicoEditar(auxCita.getMedico());
                ventanaCita.setTxtFechaAnhoEditar(String.valueOf(auxFechaAnho));
                ventanaCita.setTxtFechaMesEditar(String.valueOf(auxFechaMes));
                ventanaCita.setTxtFechaDiaEditar(String.valueOf(auxFechaDia));
                ventanaCita.setBoxHoraEditar(auxCita.getHora());
                ventanaCita.addBtnHoraEditarListener(new EditarHoraListener());
                ventanaCita.manejarBtnCancelarEditar(true);
            }
            else
            {
                ventanaCita.mostrarMensaje("Cita no encontrada");
                ventanaCita.setIdEditar("");
                ventanaCita.limpiarDatosEditar();
                ventanaCita.manejarTextFieldIdEditar(true);
                ventanaCita.manejarBtnCancelarEditar(false);
            }
        }
        catch(Exception ex)
        {
            ventanaCita.mostrarMensaje("Ingrese un entero en el campo ID");
            ventanaCita.setIdEditar("");
            ventanaCita.limpiarDatosEditar();
            ventanaCita.desactivarControlesEditar();
            ventanaCita.manejarTextFieldIdEditar(true);
        }
    }
    
        class BuscarEditarCitaListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                buscarEditarCita();
            }
        } 
    }
    
    
    public void editarCita()
    {
        Cita auxCita;
        Afiliado auxAfiliado;
        Servicio auxServicio;
        Medico auxMedico;
        Consultorio auxConsultorio;
        int auxFechaAnho;
        int auxFechaMes;
        int auxFechaDia;
        Hora auxHora;
        Fecha auxFecha;
        
        auxCita = servicioMedicoUV.getCita((Integer.parseInt(ventanaCita.getIdEditar())));
        
        if(auxCita != null)
        {
            auxAfiliado = ventanaCita.getBoxAfiliadoEditar();
            auxServicio = ventanaCita.getBoxServicioEditar();
            auxMedico = ventanaCita.getBoxMedicoEditar();
            auxConsultorio = auxMedico.getConsultorio();
            
            try
            {
                auxFechaAnho = Integer.parseInt(ventanaCita.getTxtFechaAnhoEditar());
                auxFechaMes = Integer.parseInt(ventanaCita.getTxtFechaMesEditar());
                auxFechaDia = Integer.parseInt(ventanaCita.getTxtFechaDiaEditar());
                auxFecha = new Fecha(LocalDate.of(auxFechaAnho,auxFechaMes,auxFechaDia));
                auxHora = ventanaCita.getBoxHoraEditar();
                
                if(comprobarDatosCita(auxAfiliado, auxMedico, auxServicio, auxFecha, auxHora))
                {
                    auxCita.setAfiliado(auxAfiliado);
                    auxCita.setMedico(auxMedico);
                    auxCita.setServicio(auxServicio);
                    auxCita.setConsultorio(auxConsultorio);
                    auxCita.setFecha(auxFecha);
                    auxCita.setHora(auxHora);
                    //servicioMedicoUV.escribirCitas();
                    ventanaCita.mostrarMensaje("Cita editada con exito: "+mostrarDatos(auxCita));
                    ventanaCita.manejarTextFieldIdEditar(true);
                    ventanaCita.setIdEditar("");
                    ventanaCita.limpiarDatosEditar();
                    ventanaCita.desactivarControlesEditar();
                    ventanaCita.manejarBtnCancelarEditar(false);
                    servicioMedicoUV.restablecerDisponibilidad();
                }
                else
                {
                    ventanaCita.mostrarMensaje("No se puedo editar la cita");
                    ventanaCita.setIdEditar("");
                    ventanaCita.limpiarDatosEditar();
                    ventanaCita.manejarTextFieldIdEditar(true);
                    ventanaCita.manajerBtnEditar(false);
                    ventanaCita.manejarBtnCancelarEditar(false);
                }
            }
            catch(Exception ex)
            {
                ventanaCita.mostrarMensaje("Agregue una fecha correcta");
            }
        }
    }
    
    class EditarCitaListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equalsIgnoreCase("EDITAR"))
            {
                editarCita();
            }
        }  
    }
     
    private void editarHora()
    {
        int auxFechaAnho;
        int auxFechaMes;
        int auxFechaDia;
        Fecha auxFecha;
        Afiliado auxAfiliado;
        Medico auxMedico;
        Servicio auxServicio;

        try
        {
            auxAfiliado = ventanaCita.getBoxAfiliadoEditar();
            auxMedico = ventanaCita.getBoxMedicoEditar();
            auxServicio = ventanaCita.getBoxServicioEditar();
            auxFechaAnho = Integer.parseInt(ventanaCita.getTxtFechaAnhoEditar());
            auxFechaMes = Integer.parseInt(ventanaCita.getTxtFechaMesEditar());
            auxFechaDia = Integer.parseInt(ventanaCita.getTxtFechaDiaEditar());
            auxFecha = new Fecha(LocalDate.of(auxFechaAnho,auxFechaMes,auxFechaDia));

            if(!auxFecha.getFecha().isBefore(LocalDate.now())&&!auxFecha.getFecha().isEqual(LocalDate.now()))
            {
                if(auxFecha.getFecha().isBefore(LocalDate.of(2025, 1, 1)))
                {
                    if(auxAfiliado != null && auxMedico != null && auxServicio != null)
                    {
                        listarHorariosOcupados(auxAfiliado, auxMedico, auxFecha);
                        ventanaCita.vaciarBoxHoraEditar();
                        rellenarHorasEditar(servicioMedicoUV.getHorario(false));
                        ventanaCita.setEnabledHoraEditar(true);
                        ventanaCita.desactivarControlesEditar();
                        ventanaCita.manejarBtnCancelarEditar(true);
                        ventanaCita.manajerBtnEditar(true);
                    }
                    else
                    {
                        ventanaCita.mostrarMensaje("Rellene los campos anteriores");
                    }
                }
                else
                {
                    ventanaCita.mostrarMensaje("Solo se registran citas hasta 2025-1-1");
                }
            }
            else
            {
                ventanaCita.mostrarMensaje("Agregue una fecha posterior al día de hoy");
            }
        }
        catch(DateTimeException ex)
        {
            ventanaCita.mostrarMensaje("Agregue una fecha correcta");
        }
        catch(NumberFormatException ex)
        {
            ventanaCita.mostrarMensaje("Agregue una fecha");
        }
    }
    
    class EditarHoraListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equalsIgnoreCase("HORA"))
            {
                editarHora();
            }
        }       
    }
    
    private void cancelarEditarCita()
    {
        ventanaCita.manejarTextFieldIdEditar(true);
        ventanaCita.limpiarDatosEditar();
        ventanaCita.desactivarControlesEditar();
        ventanaCita.manejarBtnCancelarEditar(false);
        ventanaCita.manajerBtnEditar(false);
        ventanaCita.setEnabledHoraEditar(false);
    }
    
    class CancelarEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                cancelarEditarCita();
            }
        }        
    }
       
    private void eliminarCita()
    {
        Cita auxCita;
        int auxNumeroId;
        
        try
        {
            auxNumeroId = Integer.parseInt(ventanaCita.getIdEliminar());
            auxCita = servicioMedicoUV.getCita(auxNumeroId);
            
            if(auxCita != null)
            {
                if(servicioMedicoUV.eliminarCita(auxCita))
                {
                    ventanaCita.mostrarMensaje("Cita eliminada con exito");
                    //servicioMedicoUV.escribirCitas();
                    ventanaCita.limpiarDatosEliminar();
                    ventanaCita.setIdEliminar("");
                    ventanaCita.manejarTextFieldIdElimnar(true);
                    ventanaCita.manejarBtnCancelarEliminar(false); 
                    servicioMedicoUV.restablecerDisponibilidad();
                }
            }
        }
        catch(Exception ex)
        {
            ventanaCita.mostrarMensaje("Ingrese un entero en el campo ID");
            ventanaCita.setIdEliminar("");
        }
    }
    
    class EliminarCitaListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("ELIMINAR"))
            {
                eliminarCita();
            }
        }      
    }
    
    private void buscarEliminarCita()
    {
        Cita auxCita;
        int auxNumeroId;
        
        try
        {
            auxNumeroId = Integer.parseInt(ventanaCita.getIdEliminar());
            auxCita = servicioMedicoUV.getCita(auxNumeroId);

            if(auxCita!=null)
            {
                ventanaCita.manejarTextFieldIdElimnar(false);
                ventanaCita.activarControlesEliminar();
                ventanaCita.setTxtAfiliadoEliminar(String.valueOf(auxCita.getAfiliado()));
                ventanaCita.setTxtServicioEliminar(String.valueOf(auxCita.getServicio()));
                ventanaCita.setTxtMedicoEliminar(String.valueOf(auxCita.getMedico()));
                ventanaCita.setTxtFechaEliminar(String.valueOf(auxCita.getFecha()));
                ventanaCita.setTxtHoraEliminar(String.valueOf(auxCita.getHora()));
                ventanaCita.desactivarControlesEliminar();
                ventanaCita.manejarBtnCancelarEliminar(true);
                ventanaCita.manajerBtnEliminar(true);
            }
            else
            {
                ventanaCita.mostrarMensaje("Cita no encontrada");
                ventanaCita.setIdEliminar("");
                ventanaCita.manajerBtnEliminar(false);
                ventanaCita.manejarTextFieldIdElimnar(true);
                ventanaCita.limpiarDatosEliminar();
            }
        }
        catch(Exception ex)
        {
            ventanaCita.mostrarMensaje("Ingrese un entero en el campo ID");
            ventanaCita.setIdEliminar("");
            ventanaCita.manajerBtnEliminar(false);
            ventanaCita.manejarTextFieldIdElimnar(true);
            ventanaCita.limpiarDatosEliminar();
        }
    }
    
    class BuscarEliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                buscarEliminarCita();
            }
        }     
    }
    
    private void cancelarEliminarCita()
    {
        ventanaCita.manejarTextFieldIdElimnar(true);
        ventanaCita.limpiarDatosEliminar();
        ventanaCita.desactivarControlesEliminar();
        ventanaCita.manejarBtnCancelarEliminar(false);
        ventanaCita.manajerBtnEliminar(false);
    }
    
    class CancelarEliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                cancelarEliminarCita();
            }
        }        
    }

    //Volver al menú principal
    private void volverMenuPrincipal()
    {
        ventanaCita.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu();
        ControladorMenu controladorMenu = new ControladorMenu(servicioMedicoUV,ventanaMenu);
    }
    
    class AtrasCitaListener implements ActionListener
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
    
    class SeleccionarServicioAgregarListener implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent e)
        {   
            if(e.getStateChange()== ItemEvent.SELECTED)
            {
                Servicio auxServicio = (Servicio) e.getItem();
                if(auxServicio!=null)
                {
                    rellenarMedicosAgregar(servicioMedicoUV.getMedicos(auxServicio));
                    ventanaCita.setEnabledMedicoAgregar(true);
                    ventanaCita.setNullBoxMedicoAgregar();
                    ventanaCita.vaciarBoxMedicoAgregar();
                    rellenarMedicosAgregar(servicioMedicoUV.getMedicos(auxServicio));
                }
                else
                {
                    ventanaCita.vaciarBoxMedicoAgregar();
                }
            }
        } 
    }
    
    class SeleccionarServicioEditarListener implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent e)
        {   
            if(e.getStateChange()== ItemEvent.SELECTED)
            {
                Servicio auxServicio = (Servicio) e.getItem();
                if(auxServicio!=null)
                {
                    rellenarMedicosEditar(servicioMedicoUV.getMedicos(auxServicio));
                    ventanaCita.setEnabledMedicoEditar(true);
                    ventanaCita.setNullBoxMedicoEditar();
                    ventanaCita.vaciarBoxMedicoEditar();
                    rellenarMedicosEditar(servicioMedicoUV.getMedicos(auxServicio));
                }
                else
                {
                    ventanaCita.vaciarBoxMedicoEditar();
                }
            }
        } 
    }
    
   //Rellenar ComboBox Agregar
   
    public void rellenarAfiliadosAgregar(ArrayList<Afiliado> array)
    {
        for(int i = 0; i < array.size();i++)
        {
            ventanaCita.rellenarBoxAfiliadosAgregar(array.get(i));
        }
        ventanaCita.setNullBoxAfiliadoAgregar();
    }
    
    public void rellenarServiciosAgregar(ArrayList<Servicio> array)
    {
        for(int i = 0; i < array.size(); i++)
        {
            ventanaCita.rellenarBoxServiciosAgregar(array.get(i));
        }
        ventanaCita.setNullBoxServicioAgregar();
    }
    
    
    public void rellenarMedicosAgregar(ArrayList <Medico> array)
    {
        for(int i=0; i < array.size(); i++)
        {
            ventanaCita.rellenarBoxMedicosAgregar(array.get(i));
        }
        ventanaCita.setNullBoxMedicoAgregar();
    }
    
    public void rellenarHorasAgregar(ArrayList<Hora> array)
    {
        for(int i=0; i < array.size(); i++)
        {
            ventanaCita.rellenarBoxHorasAgregar(array.get(i));
        }
        ventanaCita.setNullBoxHoraAgregar();
    }
    
    //Rellenar ComboBox Editar
    
    public void rellenarAfiliadosEditar(ArrayList<Afiliado> array)
    {
        for(int i = 0; i < array.size();i++)
        {
            ventanaCita.rellenarBoxAfiliadosEditar(array.get(i));
        }
        ventanaCita.setNullBoxAfiliadoEditar();
    }
    
    public void rellenarServiciosEditar(ArrayList<Servicio> array)
    {
        for(int i = 0; i < array.size(); i++)
        {
            ventanaCita.rellenarBoxServiciosEditar(array.get(i));
        }
        ventanaCita.setNullBoxServicioEditar();
    }
    
    
    public void rellenarMedicosEditar(ArrayList <Medico> array)
    {
        for(int i=0; i < array.size(); i++)
        {
            ventanaCita.rellenarBoxMedicosEditar(array.get(i));
        }
        ventanaCita.setNullBoxMedicoEditar();
    }
    
    public void rellenarHorasEditar(ArrayList<Hora> array)
    {
        for(int i=0; i < array.size(); i++)
        {
            ventanaCita.rellenarBoxHorasEditar(array.get(i));
        }
        ventanaCita.setNullBoxHoraEditar();
    }
}
