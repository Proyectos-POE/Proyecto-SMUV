package modelo;

import dao.*;

import java.io.File;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class Empresa
{
    private final String nombre;
    private final AfiliadoDao afiliadoDao;
    private final MedicoDao medicoDao;
    private final ServicioDao servicioDao;
    private final ConsultorioDao consultorioDao;
    private final CitaDao citaDao;
    private final Horario horario;
    //private final Backup backup;
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
        //this.backup = new Backup("src/main/java/archivos/", "src/main/java/backup/");
        this.conexion = new Conexion();
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
    /*public void crearBackup(Fecha auxFecha, Hora auxHora)
    {
        backup.crearBackup(auxFecha, auxHora);
    }

    public void cargarBackup(File auxArchivoZip)
    {
        backup.cargarBackup(auxArchivoZip);
    }*/

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

    //----------Coenxion----------//
    public File getArchivo()
    {
        return conexion.getArchivo();
    }

    public void setArchivo(File auxArchivo)
    {
        conexion.setArchivo(auxArchivo);
    }

    public ArrayList<ArrayList<String>> leerDatos()
    {
        return conexion.leerDatos();
    }

    public void escribirDatos(ArrayList<String> auxDatos)
    {
        conexion.escribirDatos(auxDatos);
    }

    public void escribirDatosBinario(ArrayList<Object> auxDatos)
    {
        conexion.escribirDatosBinario(auxDatos);
    }

    public ArrayList<Object> leerDatosBinario()
    {
        return  conexion.leerDatosBinario();
    }
}
