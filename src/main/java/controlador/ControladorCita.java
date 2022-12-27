package controlador;

import modelo.Afiliado;
import modelo.Empresa;
import Vista.VentanaCita;
import Vista.VentanaMenu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.*;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
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
        this.ventanaCita.addBtnHoraAgregarListener(new HoraAgregarListener());
    }
    
    public boolean comprobarDatosCita(Afiliado auxAfiliado, Medico auxMedico, Servicio auxServicio, Fecha auxFecha, Hora auxHora)
    {
        Boolean DatosValidos = true;
        
        if(auxAfiliado != null)
        {
            if(auxServicio != null)
            {
                if(auxMedico != null)
                {
                    if(auxFecha != null)
                    {
                        if(auxHora != null)
                        {
                            if(auxHora.isAsignado())
                            {
                                ventanaCita.mostrarMensaje("Ya existe una cita con este horario");
                                DatosValidos = false;
                            }
                        }
                        else
                        {
                            ventanaCita.mostrarMensaje("Escoja una hora");
                            DatosValidos = false;
                        }
                    }
                    else
                    {
                        ventanaCita.mostrarMensaje("Agregue una fecha");
                        DatosValidos = false;
                    }
                }
                else
                {
                    ventanaCita.mostrarMensaje("Escoja un medico");
                    DatosValidos = false;
                }
            }
            else
            {
                ventanaCita.mostrarMensaje("Escoja un servicio");
                DatosValidos = false;
            }
        }
        else
        {
            ventanaCita.mostrarMensaje("Escoja un afiliado");
            DatosValidos = false;
        }
        return DatosValidos;
    }

    public boolean comprobarDatosHora(Afiliado auxAfiliado, Medico auxMedico, Servicio auxServicio, Fecha auxFecha)
    {
        Boolean DatosValidos;

        if(auxAfiliado != null)
        {
            if(auxServicio != null)
            {
                if(auxMedico != null)
                {
                    if(auxFecha != null)
                    {
                        if(!auxFecha.getFecha().isBefore(LocalDate.now()) && !auxFecha.getFecha().isEqual(LocalDate.now()))
                        {
                            if(auxFecha.getFecha().isBefore(LocalDate.of(2025, 1, 1)))
                            {
                                DatosValidos = true;
                            }
                            else
                            {
                                ventanaCita.mostrarMensaje("Solo se registran citas hasta 2025-1-1");
                                DatosValidos = false;
                            }
                        }
                        else
                        {
                            ventanaCita.mostrarMensaje("Agregue una fecha posterior al día de hoy");
                            DatosValidos = false;
                        }
                    }
                    else
                    {
                        ventanaCita.mostrarMensaje("Agregue una fecha");
                        DatosValidos = false;
                    }
                }
                else
                {
                    ventanaCita.mostrarMensaje("Escoja un medico");
                    DatosValidos = false;
                }
            }
            else
            {
                ventanaCita.mostrarMensaje("Escoja un servicio");
                DatosValidos = false;
            }
        }
        else
        {
            ventanaCita.mostrarMensaje("Escoja un afiliado");
            DatosValidos = false;
        }
        return DatosValidos;
    }
    
    public String mostrarDatos(Cita auxCita)
    {
        String datos;
        String auxId = String.valueOf(auxCita.getId());
        String auxAfiliado = String.valueOf(auxCita.getAfiliado());
        String auxServicio = String.valueOf(auxCita.getServicio());
        String auxMedico = String.valueOf(auxCita.getMedico());
        String auxFecha = auxCita.getFecha().getFecha().toString();
        String auxHora = auxCita.getHora().toString();
        
        datos = "\n"+"ID: "+auxId+"\n"+"Afiliado: "+auxAfiliado+"\n"+"Medico: "+auxMedico+"\n"+"Servicio: "+auxServicio+"\n"+"Fecha: "+auxFecha+"\n"+"Hora: "+auxHora;
        
        return datos;
    }
    
    public Object[][] tablaObjectCitas(ArrayList<Cita> auxCitas)
    {
        Object[][] dataCitas;
        dataCitas = new Object[auxCitas.size()][7];

        int auxId;
        Afiliado auxAfiliado;
        Medico auxMedico;
        Servicio auxServicio;
        Consultorio auxConsultorio;
        Fecha auxFecha;
        Hora auxHora;

        
        for(int fila=0; fila < dataCitas.length; fila++)
        {
            auxId = auxCitas.get(fila).getId();
            auxAfiliado = auxCitas.get(fila).getAfiliado();
            auxMedico = auxCitas.get(fila).getMedico();
            auxServicio = auxCitas.get(fila).getServicio();
            auxConsultorio = auxCitas.get(fila).getConsultorio();
            auxFecha = auxCitas.get(fila).getFecha();
            auxHora = auxCitas.get(fila).getHora();
            
            dataCitas[fila][0] = auxId;
            dataCitas[fila][1] = auxAfiliado;
            dataCitas[fila][2] = auxMedico;
            dataCitas[fila][3] = auxServicio;
            dataCitas[fila][4] = auxConsultorio;
            dataCitas[fila][5] = auxFecha.getFecha().toString();
            dataCitas[fila][6] = auxHora;
        }

        return dataCitas;
    }

    public void rellenarAfiliadosAgregar(ArrayList<Afiliado> auxAfiliados)
    {
        for (Afiliado afiliado : auxAfiliados)
        {
            ventanaCita.rellenarBoxAfiliadosAgregar(afiliado);
        }
        ventanaCita.setNullBoxAfiliadoAgregar();
    }

    public void rellenarServiciosAgregar(ArrayList<Servicio> auxServicios)
    {
        for (Servicio servicio : auxServicios)
        {
            ventanaCita.rellenarBoxServiciosAgregar(servicio);
        }
        ventanaCita.setNullBoxServicioAgregar();
    }

    public void rellenarMedicosAgregar(ArrayList <Medico> auxMedicos)
    {
        for (Medico medico : auxMedicos)
        {
            ventanaCita.rellenarBoxMedicosAgregar(medico);
        }
        ventanaCita.setNullBoxMedicoAgregar();
    }

    public void rellenarHorasAgregar(ArrayList<Hora> auxHoras)
    {
        for (Hora hora : auxHoras) {

            ventanaCita.rellenarBoxHorasAgregar(hora);
        }
        ventanaCita.setNullBoxHoraAgregar();
    }

    public void rellenarAfiliadosEditar(ArrayList<Afiliado> auxAfiliados)
    {
        for (Afiliado afiliado : auxAfiliados)
        {
            ventanaCita.rellenarBoxAfiliadosEditar(afiliado);
        }
        ventanaCita.setNullBoxAfiliadoEditar();
    }

    public void rellenarServiciosEditar(ArrayList<Servicio> auxServicios)
    {
        for (Servicio servicio : auxServicios)
        {
            ventanaCita.rellenarBoxServiciosEditar(servicio);
        }
        ventanaCita.setNullBoxServicioEditar();
    }

    public void rellenarMedicosEditar(ArrayList <Medico> auxMedicos)
    {
        for (Medico medico : auxMedicos)
        {
            ventanaCita.rellenarBoxMedicosEditar(medico);
        }
        ventanaCita.setNullBoxMedicoEditar();
    }

    public void rellenarHorasEditar(ArrayList<Hora> auxHoras)
    {
        for (Hora hora : auxHoras)
        {
            ventanaCita.rellenarBoxHorasEditar(hora);
        }
        ventanaCita.setNullBoxHoraEditar();
    }

    public void listarHorariosOcupados(Afiliado auxAfiliado, Medico auxMedico, Fecha auxFecha)
    {
        ArrayList<Cita> citas = servicioMedicoUV.getCitas();
        for(int i = 0; i < citas.size(); i++)
        {
            if (citas.get(i).getFecha().getFecha().isEqual(auxFecha.getFecha()) && (citas.get(i).getAfiliado().getId() == auxAfiliado.getId() || citas.get(i).getMedico().getId() == auxMedico.getId()))
            {
                servicioMedicoUV.setAsignado(citas.get(i).getHora());
            }
        }
    }
    
    private void listarCitas()
    {
        ArrayList<Cita> auxCitas;
        Object[][] auxDataCitas;
        String[] nombresColumnas = {"ID", "AFILIADO", "MEDICO", "SERVICIO", "CONSULTORIO", "FECHA", "HORA"};
        auxCitas = servicioMedicoUV.getCitas();
        auxDataCitas = tablaObjectCitas(auxCitas);
        ventanaCita.crearTabla(auxDataCitas, nombresColumnas);

        if(auxCitas.isEmpty())
        {
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

    private void horaAgregarCita()
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

            if(comprobarDatosHora(auxAfiliado, auxMedico, auxServicio, auxFecha))
            {
                listarHorariosOcupados(auxAfiliado, auxMedico, auxFecha);
                rellenarHorasAgregar(servicioMedicoUV.getHorario(false));
                servicioMedicoUV.restablecerDisponibilidad();
                ventanaCita.setEnabledHoraAgregar(true);
                ventanaCita.desactivarControlesAgregar();
                ventanaCita.manejarBtnAgregar(true);
            }
        }
        catch(DateTimeException ex)
        {
            ventanaCita.mostrarMensaje("Agregue una fecha correcta");
            ventanaCita.setTxtFechaAnhoEditar("");
            ventanaCita.setTxtFechaMesAgregar("");
            ventanaCita.setTxtFechaDiaAgregar("");
        }
        catch(NumberFormatException ex)
        {
            ventanaCita.mostrarMensaje("Agregue numeros enteros en los campos de Fecha");
            ventanaCita.setTxtFechaAnhoEditar("");
            ventanaCita.setTxtFechaMesAgregar("");
            ventanaCita.setTxtFechaDiaAgregar("");
        }
    }

    class HoraAgregarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("HORA"))
            {
                horaAgregarCita();
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
        auxFechaAnho = Integer.parseInt(ventanaCita.getTxtFechaAnhoAgregar());
        auxFechaMes = Integer.parseInt(ventanaCita.getTxtFechaMesAgregar());
        auxFechaDia = Integer.parseInt(ventanaCita.getTxtFechaDiaAgregar());
        auxFecha = new Fecha(LocalDate.of(auxFechaAnho,auxFechaMes,auxFechaDia));
        auxHora = ventanaCita.getBoxHoraAgregar();

        if(comprobarDatosCita(auxAfiliado, auxMedico, auxServicio, auxFecha, auxHora))
        {
            auxConsultorio = auxMedico.getConsultorio();
            auxCita = new Cita(auxAfiliado,auxMedico,auxConsultorio,auxServicio,auxFecha,auxHora);

            if(servicioMedicoUV.agregarCita(auxCita))
            {
                ventanaCita.mostrarMensaje("Cita agregada con exito:" + mostrarDatos(auxCita));
                servicioMedicoUV.escribirCitas();
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
                //servicioMedicoUV.restablecerDisponibilidad();
            }
            else
            {
                ventanaCita.mostrarMensaje("No se pudo agregar la cita");
                ventanaCita.limpiarDatosAgregar();
            }
        }
        ventanaCita.manejarBtnAgregar(false);
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

    private void buscarEditarCita()
    {
        Cita auxCita;
        int auxId;
        Afiliado auxAfiliado;
        Servicio auxServicio;
        Medico auxMedico;
        Fecha auxFecha;
        String auxFechaAnho;
        String auxFechaMes;
        String auxFechaDia;
        Hora auxHora;

        try
        {
            auxId = Integer.parseInt(ventanaCita.getIdEditar());
            auxCita = servicioMedicoUV.getCita(auxId);

            if(auxCita != null)
            {
                auxAfiliado = auxCita.getAfiliado();
                auxServicio = auxCita.getServicio();
                auxMedico = auxCita.getMedico();
                auxFecha = auxCita.getFecha();
                auxFechaAnho = String.valueOf(auxFecha.getFecha().getYear());
                auxFechaMes = String.valueOf(auxFecha.getFecha().getMonthValue());
                auxFechaDia = String.valueOf(auxFecha.getFecha().getDayOfMonth());
                auxHora = auxCita.getHora();

                ventanaCita.manejarTextFieldIdEditar(false);
                ventanaCita.setEnabledAfiliadoEditar(false);
                ventanaCita.setEnabledMedicoEditar(false);
                ventanaCita.vaciarBoxServicioEditar();
                ventanaCita.vaciarBoxAfiliadoEditar();
                ventanaCita.vaciarBoxHoraEditar();
                rellenarAfiliadosEditar(servicioMedicoUV.getAfiliados());
                rellenarServiciosEditar(servicioMedicoUV.getServicios());
                rellenarHorasEditar(servicioMedicoUV.getHorario());
                ventanaCita.activarControlesEditar();

                ventanaCita.setBoxAfiliadoEditar(auxAfiliado);
                ventanaCita.setBoxServicioEditar(auxServicio);
                ventanaCita.setBoxMedicoEditar(auxMedico);
                ventanaCita.setTxtFechaAnhoEditar(auxFechaAnho);
                ventanaCita.setTxtFechaMesEditar(auxFechaMes);
                ventanaCita.setTxtFechaDiaEditar(auxFechaDia);
                ventanaCita.setBoxHoraEditar(auxHora);

                ventanaCita.addBtnHoraEditarListener(new HoraEditarListener());
                ventanaCita.manejarBtnCancelarEditar(true);
            }
            else
            {
                ventanaCita.mostrarMensaje("Cita no encontrada");
                ventanaCita.setIdEditar("");
            }
        }
        catch(Exception ex)
        {
            ventanaCita.mostrarMensaje("Ingrese un entero en el campo ID");
            ventanaCita.setIdEditar("");
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
    private void horaEditarCita()
    {
        int auxId;
        Cita auxCita;
        Afiliado auxAfiliado;
        Medico auxMedico;
        Servicio auxServicio;
        Fecha auxFecha;
        int auxFechaAnho;
        int auxFechaMes;
        int auxFechaDia;

        try
        {
            auxAfiliado = ventanaCita.getBoxAfiliadoEditar();
            auxMedico = ventanaCita.getBoxMedicoEditar();
            auxServicio = ventanaCita.getBoxServicioEditar();
            auxFechaAnho = Integer.parseInt(ventanaCita.getTxtFechaAnhoEditar());
            auxFechaMes = Integer.parseInt(ventanaCita.getTxtFechaMesEditar());
            auxFechaDia = Integer.parseInt(ventanaCita.getTxtFechaDiaEditar());
            auxFecha = new Fecha(LocalDate.of(auxFechaAnho,auxFechaMes,auxFechaDia));
            auxId = Integer.parseInt(ventanaCita.getIdEditar());
            auxCita = servicioMedicoUV.getCita(auxId);

            if(comprobarDatosHora(auxAfiliado, auxMedico, auxServicio, auxFecha))
            {
                listarHorariosOcupados(auxAfiliado, auxMedico, auxFecha);
                if(auxCita != null && auxCita.getMedico().equals(auxMedico))
                {
                    auxCita.getHora().setAsignado(false);
                }
                ventanaCita.vaciarBoxHoraEditar();
                rellenarHorasEditar(servicioMedicoUV.getHorario(false));
                servicioMedicoUV.restablecerDisponibilidad();
                ventanaCita.setEnabledHoraEditar(true);
                ventanaCita.desactivarControlesEditar();
                ventanaCita.manejarBtnCancelarEditar(true);
                ventanaCita.manajerBtnEditar(true);
            }
        }
        catch(DateTimeException ex)
        {
            ventanaCita.mostrarMensaje("Agregue una fecha correcta");
            ventanaCita.setTxtFechaAnhoEditar("");
            ventanaCita.setTxtFechaMesEditar("");
            ventanaCita.setTxtFechaDiaEditar("");
        }
        catch(NumberFormatException ex)
        {
            ventanaCita.mostrarMensaje("Agregue numeros enteros en los campos de Fecha");
            ventanaCita.setTxtFechaAnhoEditar("");
            ventanaCita.setTxtFechaMesEditar("");
            ventanaCita.setTxtFechaDiaEditar("");
        }
    }

    class HoraEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("HORA"))
            {
                horaEditarCita();
            }
        }
    }

    public void editarCita()
    {
        Cita auxCita;
        int auxId;
        Afiliado auxAfiliado;
        Servicio auxServicio;
        Medico auxMedico;
        Consultorio auxConsultorio;
        Fecha auxFecha;
        int auxFechaAnho;
        int auxFechaMes;
        int auxFechaDia;
        Hora auxHora;

        auxId = Integer.parseInt(ventanaCita.getIdEditar());
        auxCita = servicioMedicoUV.getCita(auxId);

        if(auxCita != null)
        {
            auxAfiliado = ventanaCita.getBoxAfiliadoEditar();
            auxServicio = ventanaCita.getBoxServicioEditar();
            auxMedico = ventanaCita.getBoxMedicoEditar();
            auxFechaAnho = Integer.parseInt(ventanaCita.getTxtFechaAnhoEditar());
            auxFechaMes = Integer.parseInt(ventanaCita.getTxtFechaMesEditar());
            auxFechaDia = Integer.parseInt(ventanaCita.getTxtFechaDiaEditar());
            auxFecha = new Fecha(LocalDate.of(auxFechaAnho, auxFechaMes, auxFechaDia));
            auxHora = ventanaCita.getBoxHoraEditar();
            if(comprobarDatosCita(auxAfiliado, auxMedico, auxServicio, auxFecha, auxHora))
            {
                auxConsultorio = auxMedico.getConsultorio();
                auxCita.setAfiliado(auxAfiliado);
                auxCita.setServicio(auxServicio);
                auxCita.setMedico(auxMedico);
                auxCita.setConsultorio(auxConsultorio);
                auxCita.setFecha(auxFecha);
                auxCita.setHora(auxHora);
                if(servicioMedicoUV.actualizarCita(auxCita))
                {
                    ventanaCita.mostrarMensaje("Cita editada con exito: " + mostrarDatos(auxCita));
                    servicioMedicoUV.escribirCitas();
                    servicioMedicoUV.restablecerDisponibilidad();
                }
                else
                {
                    ventanaCita.mostrarMensaje("No se pudo editar la cita");
                }
            }
        }
        else
        {
            ventanaCita.mostrarMensaje("Cita no encontrada");
        }
        ventanaCita.manejarTextFieldIdEditar(true);
        ventanaCita.setIdEditar("");
        ventanaCita.limpiarDatosEditar();
        ventanaCita.desactivarControlesEditar();
        ventanaCita.manejarBtnCancelarEditar(false);
        ventanaCita.manajerBtnEditar(false);
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
    
    private void cancelarEditarCita()
    {
        ventanaCita.manejarTextFieldIdEditar(true);
        ventanaCita.setIdEditar("");
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

    private void buscarEliminarCita()
    {
        Cita auxCita;
        int auxId;
        Afiliado auxAfiliado;
        Servicio auxServicio;
        Medico auxMedico;
        Fecha auxFecha;
        Hora auxHora;

        try
        {
            auxId = Integer.parseInt(ventanaCita.getIdEliminar());
            auxCita = servicioMedicoUV.getCita(auxId);

            if(auxCita!=null)
            {
                auxAfiliado = auxCita.getAfiliado();
                auxServicio = auxCita.getServicio();
                auxMedico = auxCita.getMedico();
                auxFecha = auxCita.getFecha();
                auxHora = auxCita.getHora();

                ventanaCita.setTxtAfiliadoEliminar(auxAfiliado.toString());
                ventanaCita.setTxtServicioEliminar(auxServicio.toString());
                ventanaCita.setTxtMedicoEliminar(auxMedico.toString());
                ventanaCita.setTxtFechaEliminar(auxFecha.toString());
                ventanaCita.setTxtHoraEliminar(auxHora.toString());

                ventanaCita.desactivarControlesEliminar();
                ventanaCita.manejarTextFieldIdElimnar(false);
                ventanaCita.activarControlesEliminar();
                ventanaCita.manejarBtnCancelarEliminar(true);
                ventanaCita.manajerBtnEliminar(true);
            }
            else
            {
                ventanaCita.mostrarMensaje("Cita no encontrada");
                ventanaCita.setIdEliminar("");
            }
        }
        catch(Exception ex)
        {
            ventanaCita.mostrarMensaje("Ingrese un entero en el campo ID");
            ventanaCita.setIdEliminar("");
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
       
    private void eliminarCita()
    {
        Cita auxCita;
        int auxNumeroId;

        auxNumeroId = Integer.parseInt(ventanaCita.getIdEliminar());
        auxCita = servicioMedicoUV.getCita(auxNumeroId);

        if(auxCita != null)
        {
            if(servicioMedicoUV.eliminarCita(auxCita))
            {
                ventanaCita.mostrarMensaje("Cita eliminada con exito");
                servicioMedicoUV.escribirCitas();
            }
            else
            {
                ventanaCita.mostrarMensaje("No se pudo eliminar la cita");
            }
        }
        else
        {
            ventanaCita.mostrarMensaje("Cita no encontrada");
        }
        ventanaCita.limpiarDatosEliminar();
        ventanaCita.setIdEliminar("");
        ventanaCita.manejarTextFieldIdElimnar(true);
        ventanaCita.manejarBtnCancelarEliminar(false);
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

    private void cancelarEliminarCita()
    {
        ventanaCita.manejarTextFieldIdElimnar(true);
        ventanaCita.setIdEliminar("");
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
}