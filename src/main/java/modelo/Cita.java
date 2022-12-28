package modelo;

import java.io.Serializable;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class Cita implements Serializable
{
    private static int numero;
    private int id;
    private Afiliado afiliado;
    private Medico medico;
    private Consultorio consultorio;
    private Servicio servicio;
    private Hora hora;
    private Fecha fecha;
    private static final long serialVersionUID = 1L;

    public Cita(Afiliado auxAfiliado, Medico auxMedico, Consultorio auxConsultorio, Servicio auxServicio, Fecha fecha, Hora auxHora)
    {
        numero++;
        id = numero;
        this.afiliado = auxAfiliado;
        this.medico = auxMedico;
        this.consultorio = auxConsultorio;
        this.servicio = auxServicio;
        this.fecha = fecha;
        this.hora = auxHora;
    }

    public static int getNumero()
    {
        return numero;
    }

    public static void setNumeroCita(int auxNumero)
    {
        Cita.numero = auxNumero;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int auxId)
    {
        this.id = auxId;
    }

    public Afiliado getAfiliado()
    {
        return afiliado;
    }

    public void setAfiliado(Afiliado auxAfiliado)
    {
        this.afiliado = auxAfiliado;
    }

    public Medico getMedico()
    {
        return medico;
    }

    public void setMedico(Medico auxMedico)
    {
        this.medico = auxMedico;
    }

    public Consultorio getConsultorio()
    {
        return consultorio;
    }

    public void setConsultorio(Consultorio auxConsultorio)
    {
        this.consultorio = auxConsultorio;
    }

    public Servicio getServicio()
    {
        return servicio;
    }

    public void setServicio(Servicio auxServicio)
    {
        this.servicio = auxServicio;
    }

    public Hora getHora()
    {
        return hora;
    }

    public void setHora(Hora auxHora)
    {
        this.hora = auxHora;
    }

    public Fecha getFecha()
    {
        return fecha;
    }

    public void setFecha(Fecha auxFecha)
    {
        this.fecha = auxFecha;
    }

    public String toString()
    {
        String auxDatos;
        auxDatos = id + ";" + afiliado.getId() + ";" + afiliado.getNombre() + ";" + medico.getId() + ";" + medico.getNombre() + ";" + servicio.getId() + ";" + servicio.getNombre() + ";" + consultorio.getId() + ";" + consultorio.getNombreConsultorio() + ";" + fecha.getFecha() + ";" + hora.toString();
        return auxDatos;
    }
}
