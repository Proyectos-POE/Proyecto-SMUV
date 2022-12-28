package modelo;

import java.io.Serializable;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class Servicio implements Serializable
{
    private static int numero;
    private int id;
    private String nombre;
    private static final long serialVersionUID = 1L;

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
        auxDatos = nombre;
        return auxDatos;
    }

    public static void setNumeroServicio(int auxNumero)
    {
        Servicio.numero = auxNumero;
    }
}