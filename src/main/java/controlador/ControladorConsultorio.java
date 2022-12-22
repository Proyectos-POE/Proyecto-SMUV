package controlador;

import Vista.VentanaMenu;
import modelo.Consultorio;
import modelo.Empresa;
import Vista.VentanaConsultorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorConsultorio
{
    private Empresa servicioMedicoUV;
    private VentanaConsultorio ventanaConsultorio;

    public ControladorConsultorio(Empresa auxServicioMedicoUV, VentanaConsultorio auxVentanaConsultorio)
    {
        this.servicioMedicoUV = auxServicioMedicoUV;
        this.ventanaConsultorio = auxVentanaConsultorio;

        ventanaConsultorio.setVisible(true);
        ventanaConsultorio.setLocationRelativeTo(null);

        this.ventanaConsultorio.addBtnAgregarListener(new AgregarConsultorioListener());
        this.ventanaConsultorio.addBtnAtrasListener(new AtrasConsultorioListener());
        this.ventanaConsultorio.addBtnBuscarEditarListener(new BuscarEditarConsultorioListener());
        this.ventanaConsultorio.addBtnCancelarEditarListener(new CancelarEditarListener());
        this.ventanaConsultorio.addBtnBuscarEliminarListener(new BuscarEliminarConsultorioListener());
        this.ventanaConsultorio.addBtnCancelarEliminarListener(new CancelarEliminarListener());
        this.ventanaConsultorio.addBtnEditarListener(new EditarConsultorioListener());
        this.ventanaConsultorio.addBtnEliminarListener(new EliminarConsultorioListener());
        this.ventanaConsultorio.addBtnActualizarListener(new ListarConsultorioListener());
    }

    private Object[][] dataConsultorios(ArrayList<Consultorio> auxConsultorios)
    {
        Object[][] dataConsultorios;
        dataConsultorios = new Object[auxConsultorios.size()][3];
        for(int fila = 0; fila < dataConsultorios.length; fila++)
        {
            int auxId;
            auxId = auxConsultorios.get(fila).getId();

            int auxNumeroConsultorio;
            auxNumeroConsultorio = auxConsultorios.get(fila).getNombreConsultorio();

            String auxEstado;
            auxEstado = auxConsultorios.get(fila).getStringAsignado();

            dataConsultorios[fila][0] = auxId;
            dataConsultorios[fila][1] = auxNumeroConsultorio;
            dataConsultorios[fila][2] = auxEstado;
        }
        return dataConsultorios;
    }

    private void listarConsultorios()
    {
        ArrayList<Consultorio> auxConsultorios;
        Object[] auxDataConsultorio;
        String[] nombresColumnas = {"ID","NUMERO","ESTADO"};
        auxConsultorios = servicioMedicoUV.getConsultorios();
        if(!auxConsultorios.isEmpty())
        {
            ventanaConsultorio.crearTabla(dataConsultorios(auxConsultorios), nombresColumnas);
        }
        else
        {
            ventanaConsultorio.crearTabla(dataConsultorios(auxConsultorios), nombresColumnas);
            ventanaConsultorio.mostrarMensaje("No hay consultorios listados");
        }

    }

    class ListarConsultorioListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("REFRESCAR"))
            {
                listarConsultorios();
            }
        }
    }

    private void agregarConsultorio()
    {
        String auxNumeroConsultorio;
        int intAuxNumeroConsultorio;
        try
        {

            auxNumeroConsultorio = ventanaConsultorio.getNumeroAgregar();
            intAuxNumeroConsultorio = Integer.parseInt(auxNumeroConsultorio);

            if(intAuxNumeroConsultorio>=100)
            {
                if (comprobarNumeroConsultorio(intAuxNumeroConsultorio))
                {
                    Consultorio auxConsultorio = new Consultorio(intAuxNumeroConsultorio);
                    if (servicioMedicoUV.agregarConsultorio(auxConsultorio))
                    {
                        ventanaConsultorio.mostrarMensaje("Consultorio agregado con exito" + mostrarDatos(auxConsultorio));
                        servicioMedicoUV.escribirConsultorios();
                        ventanaConsultorio.setTxtNumeroAgregar("");
                    }
                    else
                    {
                        ventanaConsultorio.mostrarMensaje("No se pudo agregar el consultorio");
                        ventanaConsultorio.setTxtNumeroAgregar("");
                    }
                }
                else
                {
                    ventanaConsultorio.setTxtNumeroAgregar("");
                }
            }
            else
            {
                ventanaConsultorio.mostrarMensaje("Ingrese un Consultorio de 3 numeros");
            }
        }
        catch (NumberFormatException ex)
        {
            ventanaConsultorio.mostrarMensaje("Porfavor ingrese un numero entero en el campo Numero");
            ventanaConsultorio.setTxtNumeroAgregar("");
        }
    }

    class AgregarConsultorioListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("AGREGAR"))
            {
                agregarConsultorio();
            }
        }
    }

    class AtrasConsultorioListener implements ActionListener
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

    private void volverMenuPrincipal()
    {
        ventanaConsultorio.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu();
        ControladorMenu controladorMenu = new ControladorMenu(servicioMedicoUV,ventanaMenu);
    }
    private void eliminarConsultorio()
    {
        Consultorio auxConsultorio;
        String auxNumeroId;
        int intAuxNumeroId;

        try
        {
            auxNumeroId = ventanaConsultorio.getIdEliminar();
            intAuxNumeroId = Integer.parseInt(auxNumeroId);
            auxConsultorio = servicioMedicoUV.getConsultorio(intAuxNumeroId);
            if(auxConsultorio != null )
            {
                if(!auxConsultorio.isAsignado())
                {
                    if (servicioMedicoUV.eliminarConsultorio(auxConsultorio))
                    {
                        ventanaConsultorio.mostrarMensaje("Consultorio eliminado con exito");
                        servicioMedicoUV.escribirConsultorios();
                        ventanaConsultorio.setTxtNumeroEliminar("");
                        ventanaConsultorio.setIdEliminar("");
                        ventanaConsultorio.manejarTextFieldIdElimnar(true);
                        ventanaConsultorio.manejarBtnCancelarEliminar(false);
                    }
                    else
                    {
                        ventanaConsultorio.mostrarMensaje("No se pudo eliminar el consultorio");
                        ventanaConsultorio.setTxtNumeroEliminar("");
                        ventanaConsultorio.setIdEliminar("");
                        ventanaConsultorio.manejarTextFieldIdElimnar(true);
                    }
                }
                else
                {
                    ventanaConsultorio.mostrarMensaje("No puede eliminar un consultorio asignado");
                }
            }
        }
        catch (Exception ex)
        {
            ventanaConsultorio.mostrarMensaje("Porfavor ingrese los datos correctamente");
            ventanaConsultorio.setIdEliminar("");
        }
    }

    class EliminarConsultorioListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("ELIMINAR"))
            {
                eliminarConsultorio();
            }
        }
    }

    private void editarConsultorio()
    {
        Consultorio auxConsultorio;
        String auxNumeroId;
        int intAuxNumeroId;
        String auxNumeroConsultorio;
        int intAuxNumeroConsultorio;

        try
        {
            auxNumeroId = ventanaConsultorio.getIdEditar();
            intAuxNumeroId = Integer.parseInt(auxNumeroId);
            auxConsultorio = servicioMedicoUV.getConsultorio(intAuxNumeroId);

            if(Long.parseLong(ventanaConsultorio.getNumeroEditar())>=100)
            {
                if (auxConsultorio != null)
                {
                    auxNumeroConsultorio = ventanaConsultorio.getNumeroEditar();
                    intAuxNumeroConsultorio = Integer.parseInt(auxNumeroConsultorio);
                    if (comprobarNumeroConsultorio(intAuxNumeroConsultorio))
                    {
                        auxConsultorio.setNombreConsultorio(intAuxNumeroConsultorio);

                        if (servicioMedicoUV.actualizarConsultorio(auxConsultorio))
                        {
                            ventanaConsultorio.mostrarMensaje("Consultorio editado con exito" + mostrarDatos(auxConsultorio));
                            ventanaConsultorio.setTxtNumeroEditar("");
                            servicioMedicoUV.escribirConsultorios();
                            ventanaConsultorio.setIdEditar("");
                            ventanaConsultorio.desactivarControlesEditar();
                            ventanaConsultorio.manejarTextFieldIdEditar(true);
                            ventanaConsultorio.manejarBtnCancelarEditar(false);
                            if(auxConsultorio.isAsignado())
                            {
                                servicioMedicoUV.escribirMedicos();
                                //espacio para citas.
                            }
                        }
                        else
                        {
                            ventanaConsultorio.mostrarMensaje("No se pudo editar el consultorio");
                            ventanaConsultorio.setTxtNumeroEditar("");
                            ventanaConsultorio.setIdEditar("");
                            ventanaConsultorio.desactivarControlesEditar();
                            ventanaConsultorio.manejarTextFieldIdEditar(true);
                            ventanaConsultorio.manejarBtnCancelarEditar(false);
                        }
                    }
                }
                else
                {
                    ventanaConsultorio.mostrarMensaje("Consultorio no encontrado");
                    ventanaConsultorio.setTxtNumeroEditar("");
                    ventanaConsultorio.desactivarControlesEditar();
                    ventanaConsultorio.manejarTextFieldIdEditar(true);
                    ventanaConsultorio.setIdEditar("");
                    ventanaConsultorio.manejarBtnCancelarEditar(false);
                }
            }
            else
            {
                ventanaConsultorio.mostrarMensaje("Ingrese un numero de Consultorio de 3 digitos");
            }
        }
        catch (Exception ex)
        {
            ventanaConsultorio.mostrarMensaje("Porfavor ingrese los datos correctamente");
            ventanaConsultorio.setTxtNumeroEditar("");
        }
    }
    class EditarConsultorioListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand().equalsIgnoreCase("EDITAR"))
            {
                editarConsultorio();
            }
        }
    }

    class BuscarEditarConsultorioListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Consultorio auxConsultorio;
            String auxNumeroId;
            int intAuxNumeroId;

            if(e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                try
                {
                    auxNumeroId = ventanaConsultorio.getIdEditar();
                    intAuxNumeroId = Integer.parseInt(auxNumeroId);
                    auxConsultorio = servicioMedicoUV.getConsultorio(intAuxNumeroId);
                    if(auxConsultorio != null)
                    {
                        ventanaConsultorio.setTxtNumeroEditar(Integer.toString(auxConsultorio.getNombreConsultorio()));
                        ventanaConsultorio.activarControlesEditar();
                        ventanaConsultorio.manejarTextFieldIdEditar(false);
                        ventanaConsultorio.manejarBtnCancelarEditar(true);
                    }
                    else
                    {
                        ventanaConsultorio.mostrarMensaje("Consultorio no encontrado");
                        ventanaConsultorio.setIdEditar("");
                        ventanaConsultorio.setTxtNumeroEditar("");
                        ventanaConsultorio.desactivarControlesEditar();
                        ventanaConsultorio.manejarTextFieldIdEditar(true);
                        ventanaConsultorio.manejarBtnCancelarEditar(false);
                    }
                }
                catch (Exception ex)
                {
                    ventanaConsultorio.mostrarMensaje("Porfavor ingrese un numero entero en el campo ID");
                    ventanaConsultorio.setIdEditar("");
                }
            }

        }
    }

    class CancelarEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                ventanaConsultorio.setIdEditar("");
                ventanaConsultorio.setTxtNumeroEditar("");
                ventanaConsultorio.manejarTextFieldIdEditar(true);
                ventanaConsultorio.desactivarControlesEditar();
                ventanaConsultorio.manejarBtnCancelarEditar(false);
            }
        }
    }

    class BuscarEliminarConsultorioListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Consultorio auxConsultorio;
            String auxNumeroId;
            int intAuxNumeroId;

            if(e.getActionCommand().equalsIgnoreCase("BUSCAR"))
            {
                try
                {
                    auxNumeroId = ventanaConsultorio.getIdEliminar();
                    intAuxNumeroId = Integer.parseInt(auxNumeroId);
                    auxConsultorio = servicioMedicoUV.getConsultorio(intAuxNumeroId);
                    if(auxConsultorio != null)
                    {
                        ventanaConsultorio.setTxtNumeroEliminar(Integer.toString(auxConsultorio.getNombreConsultorio()));
                        ventanaConsultorio.manejarTextFieldIdElimnar(false);
                        ventanaConsultorio.manejarBtnCancelarEliminar(true);
                        ventanaConsultorio.activarControlesEliminar();
                        ventanaConsultorio.desactivarControlesEliminar();
                    }
                    else
                    {
                        ventanaConsultorio.mostrarMensaje("Consultorio no encontrado");
                        ventanaConsultorio.setIdEliminar("");
                    }
                }
                catch (Exception ex)
                {
                    ventanaConsultorio.mostrarMensaje("Porfavor ingrese un numero entero en el campo ID");
                    ventanaConsultorio.setIdEliminar("");
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
                ventanaConsultorio.setIdEliminar("");
                ventanaConsultorio.setTxtNumeroEliminar("");
                ventanaConsultorio.manejarTextFieldIdEliminar(true);
                ventanaConsultorio.manejarBtnCancelarEliminar(false);
            }
        }
    }

    private boolean comprobarNumeroConsultorio(int auxNumeroConsultorio)
    {
        ArrayList<Consultorio> auxConsultorios;
        auxConsultorios = servicioMedicoUV.getConsultorios();
        boolean auxValido;
        auxValido = true;
        if(!auxConsultorios.isEmpty())
        {
            for(Consultorio consultorio: auxConsultorios)
            {
                if(consultorio.getNombreConsultorio() == auxNumeroConsultorio)
                {
                    ventanaConsultorio.mostrarMensaje("El numero de consultorio ya fue agregado. Por favor digite otro numero");
                    auxValido = false;
                    break;
                }
            }
        }
        return auxValido;
    }

    /*
    private void escribirConsultorios()
    {
        ArrayList<Consultorio> auxConsultorios;
        auxConsultorios = servicioMedicoUV.getConsultorios();
        ArrayList<String> auxDatos;
        auxDatos = new ArrayList<String>();
        if(!auxConsultorios.isEmpty())
        {
            for(Consultorio consultorio: auxConsultorios)
            {
                String auxDatosFila;
                auxDatosFila = consultorio.toString();
                auxDatos.add(auxDatosFila);
            }
            conexionConsultorio.setArchivo(new File("src/main/java/archivos/consultorios.txt"));
            conexionConsultorio.escribirDatos(auxDatos);
        }
        else
        {
            conexionConsultorio.setArchivo(new File("src/main/java/archivos/consultorios.txt"));
            conexionConsultorio.escribirDatos(auxDatos);
        }
    }
    */

    public String mostrarDatos(Consultorio consultorio)
    {
        String idConsul = String.valueOf(consultorio.getId());
        String nConsul = String.valueOf(consultorio.getNombreConsultorio());

        String datos = "\nId: " + idConsul+"\nNumero: "+ nConsul;
        return datos;
    }
}
