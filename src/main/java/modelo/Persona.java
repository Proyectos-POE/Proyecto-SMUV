package modelo;

import java.io.Serializable;

public class Persona implements Serializable
{
    protected String nombre;
    protected Documento documento;
    protected String correo;
    protected long telefono;

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String auxNombre)
    {
        this.nombre = auxNombre;
    }

    public Documento getDocumento()
    {
        return documento;
    }

    public void setDocumento(Documento auxDocumento)
    {
        this.documento = auxDocumento;
    }

    public String getCorreo()
    {
        return correo;
    }

    public void setCorreo(String auxCorreo)
    {
        this.correo = auxCorreo;
    }

    public long getTelefono()
    {
        return telefono;
    }

    public void setTelefono(long auxTelefono)
    {
        this.telefono = auxTelefono;
    }
}
