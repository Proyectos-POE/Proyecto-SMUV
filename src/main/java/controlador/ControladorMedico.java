package controlador;

import Vista.VentanaMedico;
import Vista.VentanaMenu;
import modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorMedico
{
    private Empresa servicioMedicoUV;
    private VentanaMedico ventanaMedico;

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


    class AgregarMedicoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("AGREGAR")) {
                AgregarMedico();
            }
        }
    }

    private void AgregarMedico() {
        String auxNombre;
        //Documento auxDocu;
        String auxCorreo;
        long auxTelefono;
        Servicio auxServicio;
        Consultorio auxConsultorio;

        auxNombre = ventanaMedico.getTxtNombreAgregar();
        auxCorreo = ventanaMedico.getTxtCorreoAgregar();
        auxServicio = ventanaMedico.getBoxEspecialidadAgregar();
        auxConsultorio = ventanaMedico.getBoxConsulAgregar();
        try {

            Documento auxDocu = new Documento(ventanaMedico.getBoxTipoDocumentoAgregar(), Long.parseLong(ventanaMedico.getTxtDocumentoAgregar()));
            auxTelefono = Integer.parseInt(ventanaMedico.getTxtTelefonoAgregar());

            if (comprobarDatosMedico(auxNombre, auxDocu, auxCorreo, auxTelefono, auxServicio, auxConsultorio))
            {
                Medico auxMedico = new Medico(auxNombre,auxDocu,auxCorreo,auxTelefono,auxServicio,auxConsultorio);
                if (servicioMedicoUV.agregarMedico(auxMedico))
                {
                    ventanaMedico.mostrarMensaje("Medico agregado con exito"+mostrarDatos(auxMedico));
                    auxConsultorio.setAsignado(true);
                    ventanaMedico.limpiarDatosAgregar();
                    ventanaMedico.vaciarBoxConsultorio();
                    rellenarConsultorios(servicioMedicoUV.getConsultorios(false));
                }
                else
                {
                    ventanaMedico.mostrarMensaje("Medico agregado sin exito");
                    ventanaMedico.limpiarDatosAgregar();
                }
            }

        }catch(NumberFormatException ex)
        {
            ventanaMedico.mostrarMensaje("Por favor ingrese el numero de documento y telefono");
        }
    }

    class AtrasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("ATRAS")) {
                volverMenuPrincipal();
            }
        }
    }

    private void volverMenuPrincipal() {
        ventanaMedico.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu();
        ControladorMenu controladorMenu = new ControladorMenu(servicioMedicoUV, ventanaMenu);
    }

    class BuscarEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Medico auxMedico;
            int auxNumeroId;
            Consultorio auxConsultorio;

            if (e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {

                try
                {
                    auxNumeroId = Integer.parseInt(ventanaMedico.getIdEditar());
                    auxMedico = servicioMedicoUV.getMedico(auxNumeroId);

                    if(auxMedico!=null)
                    {
                        auxConsultorio = auxMedico.getConsultorio();
                        ventanaMedico.manejarTextFieldIdEditar(false);
                        ventanaMedico.activarControlesEditar();
                        ventanaMedico.setTxtNombreEditar(auxMedico.getNombre());
                        ventanaMedico.setTxtNumDocumentoEditar(String.valueOf(auxMedico.getDocumento().getNumeroDocumento()));
                        ventanaMedico.setBoxTipoDocumentoEditar(auxMedico.getDocumento());
                        ventanaMedico.setTxtTelefonoEditar(String.valueOf(auxMedico.getTelefono()));
                        ventanaMedico.setTxtCorreoEditar(auxMedico.getCorreo());
                        ventanaMedico.setBoxEspecialidadEditar(auxMedico.getEspecialidad());
                        ventanaMedico.setBoxConsultorioEditar(auxMedico.getConsultorio());
                        ventanaMedico.manejarBtnCancelarEditar(true);
                        auxConsultorio.setAsignado(false);
                        ventanaMedico.vaciarBoxConsultorioEditar();
                        rellenarConsultoriosEditar(servicioMedicoUV.getConsultorios());
                        auxConsultorio.setAsignado(true);
                    }
                    else
                    {
                        ventanaMedico.mostrarMensaje("Medico no encontrado");
                        ventanaMedico.setIdEditar("");
                        ventanaMedico.limpiarDatosEditar();
                        ventanaMedico.manejarTextFieldIdEditar(true);
                        ventanaMedico.manejarBtnCancelarEditar(false);
                    }
                }
                catch (Exception ex)
                {
                    ventanaMedico.mostrarMensaje("Ingrese enteros en el campo ID");
                }
            }
        }
    }

    class CancelarEditarListener implements ActionListener
    {
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Consultorio auxConsultorio;
        Medico auxMedico;
        if (e.getActionCommand().equalsIgnoreCase("CANCELAR"))
        {
            auxMedico = servicioMedicoUV.getMedico(Integer.parseInt(ventanaMedico.getIdEditar()));
            auxConsultorio = auxMedico.getConsultorio();
            if(auxMedico!=null)
            {
                auxConsultorio.setAsignado(true);
                ventanaMedico.vaciarBoxConsultorioEditar();
                rellenarConsultoriosEditar(servicioMedicoUV.getConsultorios());
                ventanaMedico.manejarTextFieldIdEditar(true);
                ventanaMedico.limpiarDatosEditar();
                ventanaMedico.desactivarControlesEditar();
                ventanaMedico.manejarBtnCancelarEditar(false);
            }
            else
            {
                ventanaMedico.mostrarMensaje("No existe la id seleccionada");
                ventanaMedico.limpiarDatosEditar();
            }
        }
    }
}

    class EditarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("EDITAR")) {
                editarMedico();
            }
        }
    }

    private void editarMedico()
    {
        String auxNombre;
        Medico auxMedico;
        Documento auxDocumento;
        String auxTipoDocumento;
        long auxNumDocumento;
        String auxCorreo;
        long auxTelefono;
        Servicio auxServicio;
        Consultorio auxConsultorio;

        auxMedico = servicioMedicoUV.getMedico(Integer.parseInt(ventanaMedico.getIdEditar()));
        if(auxMedico!=null)
        {
            auxMedico.getConsultorio().setAsignado(false);
            auxNombre = ventanaMedico.getTxtNombreEditar();
            auxServicio = ventanaMedico.getBoxEspecialidadEditar();
            auxConsultorio = ventanaMedico.getBoxConsulEditar();
            auxCorreo = ventanaMedico.getTxtCorreoEditar();
            auxMedico.setDocumento(null);
            auxTipoDocumento = ventanaMedico.getBoxTipoDocumentoEditar();

            try {
                auxNumDocumento = Long.parseLong(ventanaMedico.getTxtDocumentoEditar());
                auxTelefono = Integer.parseInt(ventanaMedico.getTxtTelefonoEditar());
                auxDocumento = new Documento(auxTipoDocumento, auxNumDocumento);

                if (comprobarDatosMedico(auxNombre, auxDocumento, auxCorreo, auxTelefono, auxServicio, auxConsultorio)) {
                    auxMedico.setDocumento(auxDocumento);
                    if (servicioMedicoUV.actualizarMedico(auxMedico)) {
                        auxMedico.setNombre(auxNombre);
                        auxMedico.setCorreo(auxCorreo);
                        auxMedico.setTelefono(auxTelefono);
                        auxMedico.setConsultorio(auxConsultorio);
                        auxMedico.setEspecialidad(auxServicio);
                        auxConsultorio.setAsignado(true);
                        ventanaMedico.manejarTextFieldIdEditar(true);
                        ventanaMedico.mostrarMensaje("Medico editado con exito" + mostrarDatos(auxMedico));
                        ventanaMedico.setIdEditar("");
                        ventanaMedico.limpiarDatosEditar();
                        ventanaMedico.desactivarControlesEditar();
                        ventanaMedico.vaciarBoxConsultorio();
                        rellenarConsultorios(servicioMedicoUV.getConsultorios(false));
                        ventanaMedico.manejarBtnCancelarEditar(false);
                    } else {
                        ventanaMedico.mostrarMensaje("Medico Editado sin exito");
                        ventanaMedico.limpiarDatosEditar();
                        ventanaMedico.setIdEditar("");
                    }
                }

            } catch (NumberFormatException ex) {
                ventanaMedico.mostrarMensaje("Por favor ingrese el numero de documento y telefono");
            }
        }
        else
        {
            ventanaMedico.mostrarMensaje("Medico no encontrado");
            ventanaMedico.activarControlesEditar();
            ventanaMedico.limpiarDatosEditar();
            ventanaMedico.setIdEditar("");
            ventanaMedico.manejarTextFieldIdEditar(true);
            ventanaMedico.desactivarControlesEditar();
            ventanaMedico.manejarBtnCancelarEditar(false);
        }
    }

    class BuscarEliminarListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Medico auxMedico;
                int auxNumeroId;

                if (e.getActionCommand().equalsIgnoreCase("BUSCAR"))
                {
                    try
                    {
                        auxNumeroId = Integer.parseInt(ventanaMedico.getIdEliminar());
                        auxMedico = servicioMedicoUV.getMedico(auxNumeroId);
                        if(auxMedico!=null)
                        {
                            ventanaMedico.manejarTextFieldIdElimnar(false);
                            ventanaMedico.activarControlesEliminar();
                            ventanaMedico.setTxtNombreEliminar(auxMedico.getNombre());
                            ventanaMedico.setTxtNumDocumentoEliminar(String.valueOf(auxMedico.getDocumento().getNumeroDocumento()));
                            ventanaMedico.setTxtTipoDocumentoEliminar(auxMedico.getDocumento().getTipoDocumento());
                            ventanaMedico.setTxtTelefonoEliminar(String.valueOf(auxMedico.getTelefono()));
                            ventanaMedico.setTxtCorreoEliminar(auxMedico.getCorreo());
                            ventanaMedico.setTxtEspecialidadEliminar(auxMedico.getEspecialidad().toString());
                            ventanaMedico.setTxtConsultorioEliminar(auxMedico.getConsultorio().toString());
                            ventanaMedico.desactivarControlesEliminar();
                            ventanaMedico.manejarBtnCancelarEliminar(true);

                        }
                        else
                        {
                            ventanaMedico.mostrarMensaje("Medico no econtrado");
                            ventanaMedico.setIdEditar("");
                        }
                    }
                    catch (Exception ex)
                    {
                        ventanaMedico.mostrarMensaje("Ingrese enteros en el campo ID");
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
                ventanaMedico.manejarTextFieldIdElimnar(true);
                ventanaMedico.limpiarDatosEliminar();
                ventanaMedico.desactivarControlesEliminar();
                ventanaMedico.manejarBtnCancelarEliminar(false);
            }
        }
    }

    class EliminarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("ELIMINAR"))
            {
                eliminarMedico();
            }
        }
    }

    private void eliminarMedico()
    {
        Medico auxMedico;
        int auxIdMedico;
        Consultorio auxConsultorio;

        try
        {
            auxIdMedico = Integer.parseInt(ventanaMedico.getIdEliminar());
            auxMedico = servicioMedicoUV.getMedico(auxIdMedico);
            auxConsultorio = auxMedico.getConsultorio();
            if(auxMedico != null)
            {
                if(servicioMedicoUV.eliminarMedico(auxMedico))
                {
                    ventanaMedico.mostrarMensaje("Medico eliminado");
                    ventanaMedico.limpiarDatosEliminar();
                    ventanaMedico.setIdEliminar("");
                    auxConsultorio.setAsignado(false);
                    ventanaMedico.vaciarBoxConsultorio();
                    rellenarConsultorios(servicioMedicoUV.getConsultorios());
                    ventanaMedico.manejarTextFieldIdElimnar(true);
                    ventanaMedico.manejarBtnCancelarEliminar(false);
                }
            }
        }
        catch (Exception ex)
        {
            ventanaMedico.mostrarMensaje("Ingrese un Entero en el campo ID");
            ventanaMedico.setIdEliminar("");
        }
    }

    class ListarMedicoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("REFRESCAR")) {
                listarMedicos();
            }
        }
    }

    public Object[][] dataMedicos(ArrayList<Medico> auxMedicos)
    {
        Object[][] dataMedicos;
        dataMedicos = new Object[auxMedicos.size()][8];
        for(int fila = 0; fila <dataMedicos.length; fila++)
        {
            int auxId;
            auxId = auxMedicos.get(fila).getId();

            String auxNombre;
            auxNombre = auxMedicos.get(fila).getNombre();

            String auxTipoDocu;
            auxTipoDocu = auxMedicos.get(fila).getDocumento().getTipoDocumento();

            Long auxNumDocu;
            auxNumDocu = auxMedicos.get(fila).getDocumento().getNumeroDocumento();

            String auxCorreo;
            auxCorreo = auxMedicos.get(fila).getCorreo();

            Long auxTelefono;
            auxTelefono = auxMedicos.get(fila).getTelefono();

            Servicio auxEspecialidad;
            auxEspecialidad = auxMedicos.get(fila).getEspecialidad();

            Consultorio auxConsultorio;
            auxConsultorio = auxMedicos.get(fila).getConsultorio();

            dataMedicos[fila][0] = auxId;
            dataMedicos[fila][1] = auxNombre;
            dataMedicos[fila][2] = auxTipoDocu;
            dataMedicos[fila][3] = auxNumDocu;
            dataMedicos[fila][4] = auxCorreo;
            dataMedicos[fila][5] = auxTelefono;
            dataMedicos[fila][6] = auxEspecialidad;
            dataMedicos[fila][7] = auxConsultorio;
        }

        return  dataMedicos;
    }

    private void listarMedicos()
    {
        ArrayList<Medico> auxMedicos;
        Object[][] auxDataMedico;
        String[] nombresColumnas = {"ID","NOMBRE","T. DOCUMENTO","# DOCUMENTO", "CORREO", "TELEFONO", "ESPECIALIDAD", "CONSULTORIO"};
        auxMedicos = servicioMedicoUV.getMedicos();
        if(!auxMedicos.isEmpty())
        {
            ventanaMedico.crearTabla(dataMedicos(auxMedicos), nombresColumnas);
        }
        else
        {
            ventanaMedico.crearTabla(dataMedicos(auxMedicos), nombresColumnas);
            ventanaMedico.mostrarMensaje("No hay medicos listados");
        }

    }


    public void rellenarConsultorios(ArrayList<Consultorio> array) {
        //String auxNombre;
        for (int i = 0; i < array.size(); i++) {
            //auxNombre = String.valueOf(array.get(i).getNumeroConsultorio());
            ventanaMedico.activarControlesEditar();
            ventanaMedico.rellenarBoxConsultorio(array.get(i));
            ventanaMedico.desactivarControlesEditar();
            ventanaMedico.setNullBoxConsultorioAgregar();
            ventanaMedico.setNullBoxConsultorioEditar();
        }
    }

    public void rellenarConsultoriosEditar(ArrayList<Consultorio> array) {
        //String auxNombre;
        for (int i = 0; i < array.size(); i++) {
            //auxNombre = String.valueOf(array.get(i).getNumeroConsultorio());
            //ventanaMedico.activarControlesEditar();
            ventanaMedico.rellenarBoxConsultorioEditar(array.get(i));
            //ventanaMedico.desactivarControlesEditar();
            //ventanaMedico.setNullBoxConsultorioEditar();
        }
    }



    public void rellenarEspecialidades(ArrayList<Servicio> array)
    {
        for (int i = 0; i < array.size(); i++)
        {
            ventanaMedico.activarControlesEditar();
            ventanaMedico.rellenarBoxServicio(array.get(i));
            ventanaMedico.desactivarControlesEditar();
            ventanaMedico.setNullBoxEspecialidadAgregar();
            ventanaMedico.setNullBoxEspecialidadEditar();
        }
    }


    public Boolean comprobarDatosMedico(String nombre, Documento documento, String correo, Long telefono, Servicio servicio,  Consultorio consultorio)
    {
        Boolean DatosValidos = false;
        ArrayList<Medico> auxMedicos;
        auxMedicos = servicioMedicoUV.getMedicos();
            if (nombre.length() != 0 && String.valueOf(documento.getNumeroDocumento()).length() != 0 && documento.getTipoDocumento()!=null && correo.length() != 0 && servicio != null && consultorio != null && String.valueOf(telefono).length()!=0)
            {
                DatosValidos = true;
                for (Medico medico : auxMedicos)
                {
                    if (medico.getDocumento()!=null && medico.getDocumento().getNumeroDocumento() == documento.getNumeroDocumento()) {
                        ventanaMedico.mostrarMensaje("Ya existe un medico con este documento");
                        DatosValidos = false;
                        break;
                    }
                }
            } else {
                ventanaMedico.mostrarMensaje("Rellene todos los campos");
            }
            return DatosValidos;
    }
    public String mostrarDatos(Medico medico)
    {
        String datos;
        String auxId = String.valueOf(medico.getId());
        String auxNombre = medico.getNombre();
        String auxDocumento = String.valueOf(medico.getDocumento().getNumeroDocumento());
        String auxTipoDocu = medico.getDocumento().getTipoDocumento();
        String auxCorreo = medico.getCorreo();
        String auxTelefono = String.valueOf(medico.getTelefono());
        String auxConsultorio = String.valueOf(medico.getConsultorio().getNumeroConsultorio());
        String auxEspecialidad = medico.getEspecialidad().getNombre();

        datos = "\n"+"ID: "+auxId+"\n"+"Nombre: "+auxNombre+"\n"+"# documento: "+auxDocumento+"\n"+"Tipo Documento: "+auxTipoDocu+"\n"+"Correo: "+auxCorreo+"\n"+"Telefono: "+auxTelefono+"\n"+"# consultorio: "+auxConsultorio+"\n"+"Especialidad: "+auxEspecialidad;

        return datos;
    }
}
