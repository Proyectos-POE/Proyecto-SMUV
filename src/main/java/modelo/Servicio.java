package modelo;

public class Servicio
{
    private static int numero;
    private int id;
    private String nombre;

    public Servicio(String nombre)
    {
        numero++;
        id = numero;
        this.nombre = nombre;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int auxId)
    {
        this.id = auxId;
        this.numero = auxId;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String auxNombre)
    {
        this.nombre = auxNombre;
    }

    public String toString()
    {
        String auxDatos;
        auxDatos = id + ";" + nombre;
        return auxDatos;
    }
}
