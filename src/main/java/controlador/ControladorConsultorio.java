package controlador;

import Vista.VentanaMenu;
import modelo.Cita;
import modelo.Consultorio;
import modelo.Empresa;
import Vista.VentanaConsultorio;
import modelo.Medico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class ControladorConsultorio
{
    private final Empresa servicioMedicoUV;
    private final VentanaConsultorio ventanaConsultorio;

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

    private boolean comprobarAsignacionCita(Consultorio auxConsultorio)
    {
        boolean auxAsignado = false;
        ArrayList <Cita> auxCitas;
        auxCitas = servicioMedicoUV.getCitas();

        if (!auxCitas.isEmpty())
        {
            for(Cita cita: auxCitas)
            {
                if(cita.getConsultorio().getId() == auxConsultorio.getId())
                {
                    auxAsignado = true;
                    break;
                }
            }
        }
        return auxAsignado;
    }

    private boolean comprobarNumeroConsultorio(int auxNumeroConsultorio)
    {
        boolean auxNumeroValido;
        auxNumeroValido = true;
        ArrayList<Consultorio> auxConsultorios;
        auxConsultorios = servicioMedicoUV.getConsultorios();

        if(!auxConsultorios.isEmpty())
        {
            for(Consultorio consultorio: auxConsultorios)
            {
                if(consultorio.getNombreConsultorio() == auxNumeroConsultorio)
                {
                    ventanaConsultorio.mostrarMensaje("El numero de consultorio ya fue agregado. Por favor digite otro numero");
                    auxNumeroValido = false;
                    break;
                }
            }
        }
        return auxNumeroValido;
    }

    private String mostrarDatos(Consultorio consultorio)
    {
        String datos;
        String idConsul = String.valueOf(consultorio.getId());
        String nConsul = String.valueOf(consultorio.getNombreConsultorio());

        datos = "\nId: " + idConsul+"\nNumero: "+ nConsul;

        return datos;
    }

    private Object[][] tablaObjectConsultorio(ArrayList<Consultorio> auxConsultorios)
    {
        Object[][] dataConsultorios;
        dataConsultorios = new Object[auxConsultorios.size()][3];

        int auxId;
        int auxNumeroConsultorio;
        String auxEstado;

        for(int fila = 0; fila < dataConsultorios.length; fila++)
        {
            auxId = auxConsultorios.get(fila).getId();
            auxNumeroConsultorio = auxConsultorios.get(fila).getNombreConsultorio();
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
        Object[][] auxDataConsultorio;
        String[] nombresColumnas = {"ID","NUMERO","ESTADO"};
        auxConsultorios = servicioMedicoUV.getConsultorios();
        auxDataConsultorio = tablaObjectConsultorio(auxConsultorios);
        ventanaConsultorio.crearTabla(auxDataConsultorio, nombresColumnas);
        if(auxConsultorios.isEmpty())
        {
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
        Consultorio auxConsultorio;
        int auxNumeroConsultorio;

        try
        {
            auxNumeroConsultorio = Integer.parseInt(ventanaConsultorio.getNumeroAgregar());
            if(auxNumeroConsultorio>=100)
            {
                if(comprobarNumeroConsultorio(auxNumeroConsultorio))
                {
                    auxConsultorio = new Consultorio(auxNumeroConsultorio);
                    if (servicioMedicoUV.agregarConsultorio(auxConsultorio))
                    {
                        ventanaConsultorio.mostrarMensaje("Consultorio agregado con exito" + mostrarDatos(auxConsultorio));
                        servicioMedicoUV.escribirConsultorios();
                    }
                    else
                    {
                        ventanaConsultorio.mostrarMensaje("No se pudo agregar el consultorio");
                    }
                }
            }
            else
            {
                ventanaConsultorio.mostrarMensaje("Ingrese un Consultorio de 3 numeros");
            }
        }
        catch (NumberFormatException ex)
        {
            ventanaConsultorio.mostrarMensaje("Ingrese un numero entero en el campo Numero");
        }
        ventanaConsultorio.setTxtNumeroAgregar("");
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

    private void buscarEditarConsultorio()
    {
        Consultorio auxConsultorio;
        int auxId;
        String auxNumeroConsultorio;

        try
        {
            auxId = Integer.parseInt(ventanaConsultorio.getIdEditar());
            auxConsultorio = servicioMedicoUV.getConsultorio(auxId);

            if(auxConsultorio != null)
            {
                auxNumeroConsultorio = String.valueOf(auxConsultorio.getNombreConsultorio());
                ventanaConsultorio.setTxtNumeroEditar(auxNumeroConsultorio);
                ventanaConsultorio.activarControlesEditar();
                ventanaConsultorio.manejarTextFieldIdEditar(false);
                ventanaConsultorio.manejarBtnCancelarEditar(true);
                ventanaConsultorio.manajerBtnEditar(true);
            }
            else
            {
                ventanaConsultorio.mostrarMensaje("Consultorio no encontrado");
                ventanaConsultorio.setIdEditar("");
            }
        }
        catch (Exception ex)
        {
            ventanaConsultorio.mostrarMensaje("Porfavor ingrese un numero entero en el campo ID");
            ventanaConsultorio.setIdEditar("");
        }
    }

    class BuscarEditarConsultorioListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            buscarEditarConsultorio();
        }
    }

    private void editarConsultorio()
    {
        Consultorio auxConsultorio;
        int auxId;
        int auxNumeroConsultorio;

        try
        {
            auxId = Integer.parseInt(ventanaConsultorio.getIdEditar());
            auxConsultorio = servicioMedicoUV.getConsultorio(auxId);
            auxNumeroConsultorio = Integer.parseInt(ventanaConsultorio.getNumeroEditar());

            if(auxConsultorio != null)
            {
                if(auxNumeroConsultorio >= 100)
                {
                    if(comprobarNumeroConsultorio(auxNumeroConsultorio))
                    {
                        auxConsultorio.setNombreConsultorio(auxNumeroConsultorio);
                        if (servicioMedicoUV.actualizarConsultorio(auxConsultorio))
                        {
                            ventanaConsultorio.mostrarMensaje("Consultorio editado con exito" + mostrarDatos(auxConsultorio));
                            servicioMedicoUV.escribirConsultorios();

                            if(auxConsultorio.isAsignado())
                            {
                                servicioMedicoUV.escribirMedicos();
                                if(comprobarAsignacionCita(auxConsultorio))
                                {
                                    servicioMedicoUV.escribirCitas();
                                }
                            }
                        }
                        else
                        {
                            ventanaConsultorio.mostrarMensaje("No se pudo editar el consultorio");
                        }
                    }
                }
                else
                {
                    ventanaConsultorio.mostrarMensaje("Ingrese un numero de Consultorio de 3 digitos");
                }
            }
            else
            {
                ventanaConsultorio.mostrarMensaje("Consultorio no encontrado");
            }
        }
        catch (Exception ex)
        {
            ventanaConsultorio.mostrarMensaje("Ingrese un numero entero en el campo Numero");
        }
        ventanaConsultorio.setTxtNumeroEditar("");
        ventanaConsultorio.setIdEditar("");
        ventanaConsultorio.desactivarControlesEditar();
        ventanaConsultorio.manejarTextFieldIdEditar(true);
        ventanaConsultorio.manejarBtnCancelarEditar(false);
        ventanaConsultorio.manajerBtnEditar(false);
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

    private void cancelarEditarConsultorio()
    {
        ventanaConsultorio.setTxtNumeroEditar("");
        ventanaConsultorio.setIdEditar("");
        ventanaConsultorio.desactivarControlesEditar();
        ventanaConsultorio.manejarTextFieldIdEditar(true);
        ventanaConsultorio.manejarBtnCancelarEditar(false);
        ventanaConsultorio.manajerBtnEditar(false);
    }

    class CancelarEditarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                cancelarEditarConsultorio();
            }
        }
    }

    private void buscarEliminarConsultorio()
    {
        Consultorio auxConsultorio;
        int auxId;
        String auxNumeroConsultorio;

        try
        {
            auxId = Integer.parseInt(ventanaConsultorio.getIdEliminar());
            auxConsultorio = servicioMedicoUV.getConsultorio(auxId);

            if(auxConsultorio != null)
            {
                auxNumeroConsultorio = String.valueOf(auxConsultorio.getNombreConsultorio());

                ventanaConsultorio.setTxtNumeroEliminar(auxNumeroConsultorio);
                ventanaConsultorio.manejarTextFieldIdElimnar(false);
                ventanaConsultorio.manejarBtnCancelarEliminar(true);
                ventanaConsultorio.activarControlesEliminar();
                ventanaConsultorio.desactivarControlesEliminar();
                ventanaConsultorio.manajerBtnEliminar(true);
            }
            else
            {
                ventanaConsultorio.mostrarMensaje("Consultorio no encontrado");
                ventanaConsultorio.setIdEliminar("");
            }
        }
        catch(Exception ex)
        {
            ventanaConsultorio.mostrarMensaje("Porfavor ingrese un numero entero en el campo ID");
            ventanaConsultorio.setIdEliminar("");
        }
    }

    class BuscarEliminarConsultorioListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            buscarEliminarConsultorio();
        }
    }

    private void eliminarConsultorio()
    {
        Consultorio auxConsultorio;
        int auxId;

        auxId = Integer.parseInt(ventanaConsultorio.getIdEliminar());
        auxConsultorio = servicioMedicoUV.getConsultorio(auxId);

        if(auxConsultorio != null)
        {
            if(!auxConsultorio.isAsignado())
            {
                if (servicioMedicoUV.eliminarConsultorio(auxConsultorio))
                {
                    ventanaConsultorio.mostrarMensaje("Consultorio eliminado con exito");
                    servicioMedicoUV.escribirConsultorios();
                }
                else
                {
                    ventanaConsultorio.mostrarMensaje("No se pudo eliminar el consultorio");
                }
            }
            else
            {
                ventanaConsultorio.mostrarMensaje("No se puede eliminar un consultorio asignado");
            }
        }
        ventanaConsultorio.setTxtNumeroEliminar("");
        ventanaConsultorio.setIdEliminar("");
        ventanaConsultorio.manejarTextFieldIdElimnar(true);
        ventanaConsultorio.manejarBtnCancelarEliminar(false);
        ventanaConsultorio.manajerBtnEliminar(false);
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

    public void cancelarEliminarConsultorio()
    {
        ventanaConsultorio.setTxtNumeroEliminar("");
        ventanaConsultorio.setIdEliminar("");
        ventanaConsultorio.manejarTextFieldIdElimnar(true);
        ventanaConsultorio.manejarBtnCancelarEliminar(false);
        ventanaConsultorio.manajerBtnEliminar(false);
    }

    class CancelarEliminarListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("CANCELAR"))
            {
                cancelarEliminarConsultorio();
            }
        }
    }

    private void volverMenuPrincipal()
    {
        ventanaConsultorio.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu();
        ControladorMenu controladorMenu = new ControladorMenu(servicioMedicoUV,ventanaMenu);
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

}