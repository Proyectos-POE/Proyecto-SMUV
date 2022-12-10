package modelo;

public class Medico extends Persona
{
    private static int numero;
    private int id;
    private Servicio especialidad;
    private Consultorio consultorio;


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
        String auxDatos;
        auxDatos = id + ";" + nombre + ";" + documento.getTipoDocumento() + ";" + documento.getNumeroDocumento() + ";" + correo + ";" + telefono + ";" + especialidad.getId() + ";" + especialidad.getNombre() + ";" + consultorio.getId() + ";" + consultorio.getNumeroConsultorio();
        return auxDatos;
    }
}
