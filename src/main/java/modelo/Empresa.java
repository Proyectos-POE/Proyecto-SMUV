package modelo;

import dao.*;

import java.io.File;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

import static modelo.Afiliado.setNumeroAfiliado;
import static modelo.Consultorio.setNumeroConsultorio;
import static modelo.Medico.setNumeroMedico;
import static modelo.Servicio.setNumeroServicio;

public class Empresa implements Serializable
{
    private final String nombre;
    private final AfiliadoDao afiliadoDao;
    private final MedicoDao medicoDao;
    private final ServicioDao servicioDao;
    private final ConsultorioDao consultorioDao;
    private final CitaDao citaDao;
    private final Horario horario;
    private final BackUp backup;
    private final Conexion conexion;

    public Empresa(String auxNombre)
    {
        this.nombre = auxNombre;
        this.afiliadoDao = new AfiliadoDao();
        this.medicoDao = new MedicoDao();
        this.servicioDao = new ServicioDao();
        this.consultorioDao = new ConsultorioDao();
        this.citaDao = new CitaDao();
        this.horario = new Horario(LocalTime.of(7,0,0), Duration.ofMinutes(30));
        this.backup = new BackUp(new File("src/main/java/archivos/"), new File("src/main/java/backup/"));
        this.conexion = new Conexion(new File("src/main/java/archivos/"));
    }

    //----------|Afiliados|----------//
    public boolean agregarAfiliado(Afiliado auxAfiliado)
    {
        return this.afiliadoDao.anhadirAfiliado(auxAfiliado);
    }

    public boolean actualizarAfiliado(Afiliado auxAfiliado)
    {
        return this.afiliadoDao.actualizarAfiliado(auxAfiliado);
    }

    public boolean eliminarAfiliado(Afiliado auxAfiliado)
    {
        return this.afiliadoDao.eliminarAfiliado(auxAfiliado);
    }

    public ArrayList<Afiliado> getAfiliados()
    {
        return this.afiliadoDao.getAfiliados();
    }

    public Afiliado getAfiliado(int auxId)
    {
        return this.afiliadoDao.getAfiliado(auxId);
    }

    //----------|Medicos|----------//
    public boolean agregarMedico(Medico auxMedico)
    {
        return this.medicoDao.anhadirMedico(auxMedico);
    }

    public boolean actualizarMedico(Medico auxMedico)
    {
        return this.medicoDao.actualizarMedico(auxMedico);
    }

    public boolean eliminarMedico(Medico auxMedico)
    {
        return this.medicoDao.eliminarMedico(auxMedico);
    }

    public ArrayList<Medico> getMedicos()
    {
        return this.medicoDao.getMedicos();
    }

    public ArrayList<Medico> getMedicos(Servicio auxMedico)
    {
        return this.medicoDao.getMedicos(auxMedico);
    }

    public Medico getMedico(int auxId)
    {
        return this.medicoDao.getMedico(auxId);
    }

    public Medico getMedico(int auxId, Servicio auxServicio)
    {
        return this.medicoDao.getMedico(auxId, auxServicio);
    }

    //----------|Servicios|----------//
    public boolean agregarServicio(Servicio auxServicio)
    {
        return this.servicioDao.anhadirServicio(auxServicio);
    }

    public boolean actualizarServicio(Servicio auxServicio)
    {
        return this.servicioDao.actualizarServicio(auxServicio);
    }

    public boolean eliminarServicio(Servicio auxServicio)
    {
        return this.servicioDao.eliminarServicio(auxServicio);
    }

    public ArrayList<Servicio> getServicios()
    {
        return this.servicioDao.getServicios();
    }

    public Servicio getServicio(int auxId)
    {
        return this.servicioDao.getServicio(auxId);
    }

    //----------|Consultorios|----------//
    public boolean agregarConsultorio(Consultorio auxConsultorio)
    {
        return this.consultorioDao.anhadirConsultorio(auxConsultorio);
    }

    public boolean actualizarConsultorio(Consultorio auxConsultorio)
    {
        return this.consultorioDao.actualizarConsultorio(auxConsultorio);
    }

    public boolean eliminarConsultorio(Consultorio auxConsultorio)
    {
        return this.consultorioDao.eliminarConsultorio(auxConsultorio);
    }

    public ArrayList<Consultorio> getConsultorios()
    {
        return this.consultorioDao.getConsultorios();
    }
    public ArrayList<Consultorio> getConsultorios(boolean auxAsignado)
    {
        return this.consultorioDao.getConsultorios(auxAsignado);
    }

    public Consultorio getConsultorio(int auxId)
    {
        return this.consultorioDao.getConsultorio(auxId);
    }
    public Consultorio getConsultorio(int auxId, boolean auxAsignado)
    {
        return this.consultorioDao.getConsultorio(auxId, auxAsignado);
    }

    //----------|Citas|----------//
    public boolean agregarCita(Cita auxCita)
    {
        return this.citaDao.agregarCita(auxCita);
    }

    public boolean actualizarCita(Cita auxCita)
    {
        return this.citaDao.actualizarCita(auxCita);
    }

    public boolean eliminarCita(Cita auxCita)
    {
        return this.citaDao.eliminarCita(auxCita);
    }

    public ArrayList<Cita> getCitas()
    {
        return this.citaDao.getCitas();
    }
    public Cita getCita(Afiliado auxAfiliado)
    {
        return citaDao.getCita(auxAfiliado);
    }

    public Cita getCita(int auxId)
    {
        return this.citaDao.getCita(auxId);
    }

    /*public ArrayList<Hora> getHorariosNoDisponibles(Medico auxMedico, Afiliado auxAfiliado, Fecha auxFecha)
    {
        return this.citaDao.getHorariosNoDisponibles(auxMedico, auxAfiliado, auxFecha);
    }*/

    //----------|Backup|----------//
    public boolean crearBackup(Fecha auxFecha, Hora auxHora)
    {
        return backup.crearBackup(auxFecha, auxHora);
    }

    public boolean cargarBackup(File auxArchivoZip)
    {
        return backup.cargarBackup(auxArchivoZip);
    }

    //----------|Horario|----------//
    public Hora getHora(int auxId)
    {
        return horario.getHora(auxId);
    }

    public Hora getHora(int auxId, boolean auxAsignado)
    {
        return horario.getHora(auxId,auxAsignado);
    }

    public ArrayList<Hora> getHorario()
    {
        return horario.getHorario();
    }

    public ArrayList<Hora> getHorario(boolean auxAsignado)
    {
        return horario.getHorario(auxAsignado);
    }

    public void comprobarHorariosDisponibles(ArrayList<Hora> horariosNoDisponibles)
    {
        horario.comprobarHorariosDisponibles(horariosNoDisponibles);
    }

    public void restablecerDisponibilidad()
    {
        horario.restablecerDisponibilidad();
    }

    //Parte de Archivos

    public void escribirMedicos()
    {
        ArrayList auxMedicos;
        auxMedicos = getMedicos();
        conexion.setArchivo("medicos.bin");
        conexion.escribirDatosBinario(auxMedicos);
    }

    public void escribirAfiliados()
    {
        ArrayList auxAfiliados;
        auxAfiliados = getAfiliados();
        conexion.setArchivo("afiliados.bin");
        conexion.escribirDatosBinario(auxAfiliados);
        conexion.setArchivo("afiliados.txt");
        conexion.escribirDatosTxt(auxAfiliados);
    }

    public void escribirConsultorios()
    {
        ArrayList auxConsultorios;
        auxConsultorios = getConsultorios();
        conexion.setArchivo("consultorios.bin");
        conexion.escribirDatosBinario(auxConsultorios);
    }

    public void escribirServicios()
    {
        ArrayList auxServicios;
        auxServicios = getServicios();
        conexion.setArchivo("servicios.bin");
        conexion.escribirDatosBinario(auxServicios);
    }

    public boolean recuperarDatos()
    {
        boolean datosValidos;
        datosValidos = true;

        ArrayList<Object> auxDatos;
        conexion.setArchivo("afiliados.bin");
        auxDatos = conexion.leerDatosBinario();
        Afiliado auxAfiliado;
        for(Object objeto : auxDatos)
        {
            auxAfiliado = (Afiliado) objeto;
            agregarAfiliado(auxAfiliado);
            setNumeroAfiliado(auxAfiliado.getId());
        }

        conexion.setArchivo("servicios.bin");
        auxDatos = conexion.leerDatosBinario();
        Servicio auxServicio;
        for(Object objeto : auxDatos)
        {
            auxServicio = (Servicio) objeto;
            agregarServicio(auxServicio);
            setNumeroServicio(auxServicio.getId());
        }

        conexion.setArchivo("consultorios.bin");
        auxDatos = conexion.leerDatosBinario();
        Consultorio auxConsultorio;
        for(Object objeto : auxDatos)
        {
            auxConsultorio = (Consultorio) objeto;
            agregarConsultorio(auxConsultorio);
            setNumeroConsultorio(auxConsultorio.getId());
        }

        conexion.setArchivo("medicos.bin");
        auxDatos = conexion.leerDatosBinario();
        Medico auxMedico;
        for(Object objeto : auxDatos)
        {
            auxMedico = (Medico) objeto;
            auxServicio = getServicio(auxMedico.getEspecialidad().getId());
            auxConsultorio = getConsultorio(auxMedico.getConsultorio().getId());
            if(auxServicio == null || auxConsultorio == null)
            {
                datosValidos = false;
                escribirMedicos();
                break;
            }
            auxMedico.setEspecialidad(auxServicio);
            auxMedico.setConsultorio(auxConsultorio);
            agregarMedico(auxMedico);
            setNumeroMedico(auxMedico.getId());
        }

        return datosValidos;
    }
}

