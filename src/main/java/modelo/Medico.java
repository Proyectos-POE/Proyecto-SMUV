package modelo;

import java.io.Serializable;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class Medico extends Persona implements Serializable
{
    private static int numero;
    private int id;
    private Servicio especialidad;
    private Consultorio consultorio;
    private static final long serialVersionUID = 1L;

    public Medico(String auxNombre, Documento auxDocumento, String auxCorreo, long auxTelefono, Servicio auxEspecialidad, Consultorio auxConsultorio)
    {
        numero++;
        id = numero;
        this.nombre = auxNombre;
        this.documento = auxDocumento;
        this.correo = auxCorreo;
        this.telefono = auxTelefono;
        this.especialidad = auxEspecialidad;
        this.consultorio = auxConsultorio;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int auxId)
    {
        this.id = auxId;
    }

    public Servicio getEspecialidad()
    {
        return especialidad;
    }

    public void setEspecialidad(Servicio auxEspecialidad)
    {
        this.especialidad = auxEspecialidad;
    }

    public Consultorio getConsultorio()
    {
        return consultorio;
    }

    public void setConsultorio(Consultorio auxConsultorio)
    {
        this.consultorio = auxConsultorio;
    }

    public String toString()
    {
        return nombre;
    }

    public static void setNumeroMedico(int auxNumero)
    {
        Medico.numero = auxNumero;
    }
}
