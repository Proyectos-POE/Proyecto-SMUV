package controlador;

import Vista.VentanaMedico;
import Vista.VentanaMenu;
import modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class ControladorMedico
{
    private final Empresa servicioMedicoUV;
    private final VentanaMedico ventanaMedico;

    public ControladorMedico(Empresa auxServicioMedicoUV, VentanaMedico auxVentanaMedico)
    {
        this.servicioMedicoUV = auxServicioMedicoUV;
        this.ventanaMedico = auxVentanaMedico;

        rellenarConsultorios(servicioMedicoUV.getConsultorios(false));
        rellenarEspecialidades(servicioMedicoUV.getServicios());
        ventanaMedico.setNullBoxTipoDocumentoAgregar();
        ventanaMedico.setNullBoxTipoDocumentoEditar();
        ventanaMedico.setVisible(true);
        ventanaMedico.setLocationRelativeTo(null);

        this.ventanaMedico.addBtnAgregarListener(new AgregarMedicoListener());
        this.ventanaMedico.addBtnAtrasListener(new AtrasListener());
        this.ventanaMedico.addBtnBuscarEditarListener(new BuscarEditarListener());
        this.ventanaMedico.addBtnCancelarEditarListener(new CancelarEditarListener());
        this.ventanaMedico.addBtnBuscarEliminarListener(new BuscarEliminarListener());
        this.ventanaMedico.addBtnCancelarEliminarListener(new CancelarEliminarListener());
        this.ventanaMedico.addBtnEditarListener(new EditarListener());
        this.ventanaMedico.addBtnEliminarListener(new EliminarListener());
        this.ventanaMedico.addBtnActualizarListener(new ListarMedicoListener());
    }

    private boolean comprobarAsignacionCita(Medico auxMedico)
    {
        boolean auxAsignado = false;
        ArrayList <Cita> auxCitas;
        auxCitas = servicioMedicoUV.getCitas();

        if (!auxCitas.isEmpty())
        {
            for(Cita cita: auxCitas)
            {
                if(cita.getMedico().getId() == auxMedico.getId())
                {
                    auxAsignado = true;
                    break;
                }
            }
        }
        return auxAsignado;
    }

    private Boolean comprobarDatosMedico(int auxId ,String auxNombre, String auxTipoDocumento, long auxNumeroDocumento, String auxCorreo, long auxTelefono, Servicio auxServicio, Consultorio auxConsultorio)
    {
        boolean auxDatosValidos = true;
        ArrayList<Medico> auxMedicos;
        auxMedicos = servicioMedicoUV.getMedicos();

        if(auxNombre.length() != 0)
        {
            if(auxCorreo.length() != 0)
            {
                if(auxNumeroDocumento >= 100000)
                {
                    if(auxTelefono >= 100000)
                    {
                        if(auxTipoDocumento != null)
                        {
                            if(auxServicio != null)
                            {
                                if(auxConsultorio != null)
                                {
                                    for(Medico medico : auxMedicos)
                                    {

                                        Documento aux = medico.getDocumento();
                                        System.out.println(aux);
                                        if(medico.getDocumento().getNumeroDocumento() == auxNumeroDocumento &&  medico.getId() != auxId)
                                        {
                                            ventanaMedico.mostrarMensaje("Ya existe un medico con este documento");
                                            auxDatosValidos = false;
                                            break;
                                        }
                                    }
                                }
                                else
                                {
                                    ventanaMedico.mostrarMensaje("Escoja un consultorio");
                                    auxDatosValidos = false;
                                }
                            }
                            else
                            {
                                ventanaMedico.mostrarMensaje("Escoja un servicio");
                                auxDatosValidos = false;
                            }
                        }
                        else
                        {
                            ventanaMedico.mostrarMensaje("Escoja un tipo de documento");
                            auxDatosValidos = false;
                        }
                    }
                    else
                    {
                        ventanaMedico.mostrarMensaje("Ingrese un telefono valido (minimo 6 numeros)");
                        auxDatosValidos = false;
                    }
                }
                else
                {
                    ventanaMedico.mostrarMensaje("Ingrese un numero de documento valido (minimo 6 numeros)");
                    auxDatosValidos = false;
                }
            }
            else
            {
                ventanaMedico.mostrarMensaje("No se puede agregar un correo vacio");
                auxDatosValidos = false;
            }
        }
        else
        {
            ventanaMedico.mostrarMensaje("No se puede agregar un nombre vacio");
            auxDatosValidos = false;
        }

        return auxDatosValidos;
    }

    private String mostrarDatos(Medico medico)
    {
        String datos;
        String auxId = String.valueOf(medico.getId());
        String auxNombre = medico.getNombre();
        String auxDocumento = String.valueOf(medico.getDocumento().getNumeroDocumento());
        String auxTipoDocu = medico.getDocumento().getTipoDocumento();
        String auxCorreo = medico.getCorreo();
        String auxTelefono = String.valueOf(medico.getTelefono());
        String auxConsultorio = String.valueOf(medico.getConsultorio().getNombreConsultorio());
        String auxEspecialidad = medico.getEspecialidad().getNombre();

        datos = "\n"+"ID: "+auxId+"\n"+"Nombre: "+auxNombre+"\n"+"# documento: "+auxDocumento+"\n"+"Tipo Documento: "+auxTipoDocu+"\n"+"Correo: "+auxCorreo+"\n"+"Telefono: "+auxTelefono+"\n"+"# consultorio: "+auxConsultorio+"\n"+"Especialidad: "+auxEspecialidad;

        return datos;
    }

    private Object[][] tablaObjectMedico(ArrayList<Medico> auxMedicos)
    {
        Object[][] dataMedicos;
        dataMedicos = new Object[auxMedicos.size()][8];

        int auxId;
        String auxNombre;
        String auxTipoDocumento;
        long auxNumeroDocumento;
        String auxCorreo;
        long auxTelefono;
        Servicio auxEspecialidad;
        Consultorio auxConsultorio;

        for(int fila = 0; fila < dataMedicos.length; fila++)
        {
            auxId = auxMedicos.get(fila).getId();
            auxNombre = auxMedicos.get(fila).getNombre();
            auxTipoDocumento = auxMedicos.get(fila).getDocumento().getTipoDocumento();
            auxNumeroDocumento = auxMedicos.get(fila).getDocumento().getNumeroDocumento();
            auxCorreo = auxMedicos.get(fila).getCorreo();
            auxTelefono = auxMedicos.get(fila).getTelefono();
            auxEspecialidad = auxMedicos.get(fila).getEspecialidad();
            auxConsultorio = auxMedicos.get(fila).getConsultorio();

            dataMedicos[fila][0] = auxId;
            dataMedicos[fila][1] = auxNombre;
            dataMedicos[fila][2] = auxTipoDocumento;
            dataMedicos[fila][3] = auxNumeroDocumento;
            dataMedicos[fila][4] = auxCorreo;
            dataMedicos[fila][5] = auxTelefono;
            dataMedicos[fila][6] = auxEspecialidad;
            dataMedicos[fila][7] = auxConsultorio;
        }

        return  dataMedicos;
    }

    private void rellenarEspecialidades(ArrayList<Servicio> auxServicios)
    {
        for (Servicio servicio : auxServicios)
        {
            ventanaMedico.rellenarBoxServicio(servicio);
        }
        ventanaMedico.setNullBoxEspecialidadAgregar();
        ventanaMedico.setNullBoxEspecialidadEditar();
    }

    private void rellenarConsultorios(ArrayList<Consultorio> auxConsultorios)
    {
        for (Consultorio consultorio : auxConsultorios)
        {
            ventanaMedico.rellenarBoxConsultorio(consultorio);
        }
        ventanaMedico.setNullBoxConsultorioAgregar();
        ventanaMedico.setNullBoxConsultorioEditar();
    }

    private void rellenarConsultoriosEditar(ArrayList<Consultorio> auxConsultorios)
    {
        for (Consultorio consultorio : auxConsultorios)
        {
            ventanaMedico.rellenarBoxConsultorioEditar(consultorio);
        }
    }

    private void listarMedicos()
    {
        ArrayList<Medico> auxMedicos;
        Object[][] auxDataMedicos;
        String[] nombresColumnas = {"ID","NOMBRE","T. DOCUMENTO","# DOCUMENTO", "CORREO", "TELEFONO", "ESPECIALIDAD", "CONSULTORIO"};
        auxMedicos = servicioMedicoUV.getMedicos();
        auxDataMedicos = tablaObjectMedico(auxMedicos);
        ventanaMedico.crearTabla(auxDataMedicos, nombresColumnas);
        if(auxMedicos.isEmpty())
        {
            ventanaMedico.mostrarMensaje("No hay medicos listados");
        }
    }

    class ListarMedicoListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("REFRESCAR"))
            {
                listarMedicos();
            }
        }
    }

    private void AgregarMedico()
    {
        String auxNombre;
        Documento auxDocumento;
        String auxTipoDocumento;
        long auxNumeroDocumento;
        String auxCorreo;
        long auxTelefono;
        Servicio auxServicio;
        Consultorio auxConsultorio;

        try
        {
            auxNombre = ventanaMedico.getTxtNombreAgregar();
            auxTipoDocumento = ventanaMedico.getBoxTipoDocumentoAgregar();
            auxNumeroDocumento = Long.parseLong(ventanaMedico.getTxtDocumentoAgregar());
            auxCorreo = ventanaMedico.getTxtCorreoAgregar();
            auxTelefono = Long.parseLong(ventanaMedico.getTxtTelefonoAgregar());
            auxServicio = ventanaMedico.getBoxEspecialidadAgregar();
            auxConsultorio = ventanaMedico.getBoxConsulAgregar();

            if (comprobarDatosMedico(0 ,auxNombre, auxTipoDocumento, auxNumeroDocumento, auxCorreo, auxTelefono, auxServicio, auxConsultorio))
            {
                auxDocumento = new Documento(auxTipoDocumento, auxNumeroDocumento);
                Medico auxMedico = new Medico(auxNombre, auxDocumento, auxCorreo, auxTelefono, auxServicio, auxConsultorio);

                if (servicioMedicoUV.agregarMedico(auxMedico))
                {
                    ventanaMedico.mostrarMensaje("Medico agregado con exito" + mostrarDatos(auxMedico));
                    servicioMedicoUV.escribirMedicos();
                    auxConsultorio.setAsignado(true);
                    servicioMedicoUV.escribirConsultorios();
                    ventanaMedico.vaciarBoxConsultorio();
                    rellenarConsultorios(servicioMedicoUV.getConsultorios(false));
                }
                else
                {
                    ventanaMedico.mostrarMensaje("No se pudo agregar el medico");
                }
            }
        }
        catch(NumberFormatException ex)
        {
            ventanaMedico.mostrarMensaje("Ingrese numeros enteros en los campos de documento y telefono");
        }
        ventanaMedico.limpiarDatosAgregar();
    }

    class AgregarMedicoListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("AGREGAR"))
            {
                AgregarMedico();
            }
        }
    }

    private void buscarEditarMedico()
    {
        Medico auxMedico;
        int auxId;
        String auxNombre;
        Documento auxDocumento;
        String auxNumeroDocumento;
        String auxCorreo;
        String auxTelefono;
        Servicio auxEspecialidad;
        Consultorio auxConsultorio;

        try
        {
            auxId = Integer.parseInt(ventanaMedico.getIdEditar());
            auxMedico = servicioMedicoUV.getMedico(auxId);

            if(auxMedico!=null)
            {
                auxNombre = auxMedico.getNombre();
                auxDocumento = auxMedico.getDocumento();
                auxNumeroDocumento = String.valueOf(auxDocumento.getNumeroDocumento());
                auxCorreo = auxMedico.getCorreo();
                auxTelefono = String.valueOf(auxMedico.getTelefono());
                auxEspecialidad = auxMedico.getEspecialidad();
                auxConsultorio = auxMedico.getConsultorio();

                ventanaMedico.setTxtNombreEditar(auxNombre);
                ventanaMedico.setTxtNumDocumentoEditar(auxNumeroDocumento);
                ventanaMedico.setBoxTipoDocumentoEditar(auxDocumento);
                ventanaMedico.setTxtTelefonoEditar(auxTelefono);
                ventanaMedico.setTxtCorreoEditar(auxCorreo);
                ventanaMedico.setBoxEspecialidadEditar(auxEspecialidad);
                ventanaMedico.setBoxConsultorioEditar(auxMedico.getConsultorio());

                ventanaMedico.manejarTextFieldIdEditar(false);
                ventanaMedico.manejarBtnCancelarEditar(true);
                ventanaMedico.manajerBtnEditar(true);
                ventanaMedico.activarControlesEditar();

                auxConsultorio.setAsignado(false);
                ventanaMedico.vaciarBoxConsultorioEditar();
                rellenarConsultoriosEditar(servicioMedicoUV.getConsultorios(false));
                ventanaMedico.setBoxConsultorioEditar(auxConsultorio);
                auxConsultorio.setAsignado(true);
            }
            else
            {
                ventanaMedico.mostrarMensaje("Medico no encontrado");
                ventanaMedico.setIdEditar("");
            }
        }
        catch (Exception ex)
        {
            ventanaMedico.mostrarMensaje("Ingrese un Entero en el campo ID");
            ventanaMedico.setIdEditar("");
        }
    }

    class BuscarEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                buscarEditarMedico();
            }
        }
    }

    private void editarMedico()
    {
        Medico auxMedico;
        int auxId;
        String auxNombre;
        Documento auxDocumento;
        String auxTipoDocumento;
        long auxNumDocumento;
        String auxCorreo;
        long auxTelefono;
        Servicio auxServicio;
        Consultorio auxConsultorio;

        auxId = Integer.parseInt(ventanaMedico.getIdEditar());
        auxMedico = servicioMedicoUV.getMedico(auxId);
        try
        {
            auxNombre = ventanaMedico.getTxtNombreEditar();
            auxTipoDocumento = ventanaMedico.getBoxTipoDocumentoEditar();
            auxNumDocumento  = Long.parseLong(ventanaMedico.getTxtDocumentoEditar());
            auxCorreo = ventanaMedico.getTxtCorreoEditar();
            auxTelefono = Long.parseLong(ventanaMedico.getTxtTelefonoEditar());
            auxConsultorio = ventanaMedico.getBoxConsulEditar();
            auxServicio = ventanaMedico.getBoxEspecialidadEditar();

            if(auxMedico != null)
            {
                if(!comprobarAsignacionCita(auxMedico))
                {
                    if(comprobarDatosMedico(auxId ,auxNombre, auxTipoDocumento, auxNumDocumento, auxCorreo, auxTelefono, auxServicio, auxConsultorio))
                    {
                        auxMedico.setNombre(auxNombre);
                        auxDocumento = auxMedico.getDocumento();
                        auxDocumento.setTipoDocumento(auxTipoDocumento);
                        auxDocumento.setNumeroDocumento(auxNumDocumento);
                        auxMedico.setDocumento(auxDocumento);
                        auxMedico.setCorreo(auxCorreo);
                        auxMedico.setTelefono(auxTelefono);
                        auxMedico.setEspecialidad(auxServicio);
                        auxMedico.getConsultorio().setAsignado(false);
                        auxConsultorio.setAsignado(true);
                        auxMedico.setConsultorio(auxConsultorio);

                        if(servicioMedicoUV.actualizarMedico(auxMedico))
                        {
                            ventanaMedico.mostrarMensaje("Medico editado con exito" + mostrarDatos(auxMedico));
                            servicioMedicoUV.escribirMedicos();
                            servicioMedicoUV.escribirConsultorios();
                            ventanaMedico.vaciarBoxConsultorio();
                            rellenarConsultorios(servicioMedicoUV.getConsultorios(false));
                        }
                        else
                        {
                            ventanaMedico.mostrarMensaje("No se pudo editar el medico");
                        }
                    }
                }
                else
                {
                    ventanaMedico.mostrarMensaje("No se puede editar un medico que tiene asignado una cita");
                }
            }
            else
            {
                ventanaMedico.mostrarMensaje("Medico no encontrado");
            }
        }
        catch(NumberFormatException ex)
        {
            ventanaMedico.mostrarMensaje("Ingrese numeros enteros en los campos de documento y telefono");
        }
        ventanaMedico.manejarTextFieldIdEditar(true);
        ventanaMedico.setIdEditar("");
        ventanaMedico.limpiarDatosEditar();
        ventanaMedico.desactivarControlesEditar();
        ventanaMedico.manejarBtnCancelarEditar(false);
        ventanaMedico.manajerBtnEditar(false);
    }

    class EditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("EDITAR"))
            {
                editarMedico();
            }
        }
    }

    private void cancelarEditarMedico()
    {
        Consultorio auxConsultorio;
        Medico auxMedico;

        auxMedico = servicioMedicoUV.getMedico(Integer.parseInt(ventanaMedico.getIdEditar()));
        auxConsultorio = auxMedico.getConsultorio();
        auxConsultorio.setAsignado(true);
        ventanaMedico.vaciarBoxConsultorioEditar();
        rellenarConsultoriosEditar(servicioMedicoUV.getConsultorios());
        ventanaMedico.manejarTextFieldIdEditar(true);
        ventanaMedico.limpiarDatosEditar();
        ventanaMedico.desactivarControlesEditar();
        ventanaMedico.manejarBtnCancelarEditar(false);
    }

    class CancelarEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                cancelarEditarMedico();
            }
        }
    }

    private void buscarEliminarMedico()
    {
        Medico auxMedico;
        int auxId;
        String auxNombre;
        Documento auxDocumento;
        String auxTipoDocumento;
        String auxNumeroDocumento;
        String auxCorreo;
        String auxTelefono;
        String auxEspecialidad;
        String auxConsultorio;

        try
        {
            auxId = Integer.parseInt(ventanaMedico.getIdEliminar());
            auxMedico = servicioMedicoUV.getMedico(auxId);
            auxNombre = auxMedico.getNombre();
            auxDocumento = auxMedico.getDocumento();
            auxTipoDocumento = auxDocumento.getTipoDocumento();
            auxNumeroDocumento = String.valueOf(auxDocumento.getNumeroDocumento());
            auxCorreo = auxMedico.getCorreo();
            auxTelefono = String.valueOf(auxMedico.getTelefono());
            auxEspecialidad = auxMedico.getEspecialidad().toString();
            auxConsultorio = auxMedico.getConsultorio().toString();

            if(auxMedico != null)
            {
                ventanaMedico.manejarTextFieldIdElimnar(false);
                ventanaMedico.activarControlesEliminar();
                ventanaMedico.setTxtNombreEliminar(auxNombre);
                ventanaMedico.setTxtNumDocumentoEliminar(auxNumeroDocumento);
                ventanaMedico.setTxtTipoDocumentoEliminar(auxTipoDocumento);
                ventanaMedico.setTxtTelefonoEliminar(auxTelefono);
                ventanaMedico.setTxtCorreoEliminar(auxCorreo);
                ventanaMedico.setTxtEspecialidadEliminar(auxEspecialidad);
                ventanaMedico.setTxtConsultorioEliminar(auxConsultorio);
                ventanaMedico.desactivarControlesEliminar();
                ventanaMedico.manejarBtnCancelarEliminar(true);
                ventanaMedico.manajerBtnEliminar(true);
            }
            else
            {
                ventanaMedico.mostrarMensaje("Medico no econtrado");
                ventanaMedico.setIdEliminar("");
            }
        }
        catch (Exception ex)
        {
            ventanaMedico.mostrarMensaje("Ingrese un Entero en el campo ID");
            ventanaMedico.setIdEliminar("");
        }

    }

    class BuscarEliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                buscarEliminarMedico();
            }
        }
    }

    private void eliminarMedico()
    {
        Medico auxMedico;
        int auxId;
        Consultorio auxConsultorio;

        auxId = Integer.parseInt(ventanaMedico.getIdEliminar());
        auxMedico = servicioMedicoUV.getMedico(auxId);

        if(auxMedico != null)
        {
            if(!comprobarAsignacionCita(auxMedico))
            {
                auxConsultorio = auxMedico.getConsultorio();
                if(servicioMedicoUV.eliminarMedico(auxMedico))
                {
                    ventanaMedico.mostrarMensaje("Medico eliminado con exito");
                    servicioMedicoUV.escribirMedicos();
                    auxConsultorio.setAsignado(false);
                    servicioMedicoUV.escribirConsultorios();
                    ventanaMedico.vaciarBoxConsultorio();
                    rellenarConsultorios(servicioMedicoUV.getConsultorios(false));
                }
                else
                {
                    ventanaMedico.mostrarMensaje("No se pudo eliminar el medico");
                }
            }
            else
            {
                ventanaMedico.mostrarMensaje("No se puede eliminar un medico que tiene asignado una cita");
            }
        }
        else
        {
            ventanaMedico.mostrarMensaje("Medico no encontrado");
        }

        ventanaMedico.limpiarDatosEliminar();
        ventanaMedico.setIdEliminar("");
        ventanaMedico.manejarTextFieldIdElimnar(true);
        ventanaMedico.manejarBtnCancelarEliminar(false);
        ventanaMedico.manajerBtnEliminar(false);
    }

    class EliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("ELIMINAR"))
            {
                eliminarMedico();
            }
        }
    }

    private void cancelarEliminarMedico()
    {
        ventanaMedico.manejarTextFieldIdElimnar(true);
        ventanaMedico.limpiarDatosEliminar();
        ventanaMedico.desactivarControlesEliminar();
        ventanaMedico.manejarBtnCancelarEliminar(false);
        ventanaMedico.manajerBtnEliminar(false);
    }

    class CancelarEliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

            if (e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                cancelarEliminarMedico();
            }
        }
    }

    private void volverMenuPrincipal()
    {
        ventanaMedico.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu();
        ControladorMenu controladorMenu = new ControladorMenu(servicioMedicoUV, ventanaMenu);
    }

    class AtrasListener implements ActionListener
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
