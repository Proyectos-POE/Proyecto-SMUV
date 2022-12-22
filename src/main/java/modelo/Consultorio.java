package modelo;

import java.io.Serializable;

public class Consultorio implements Serializable
{
    private static int numero;
    private int id;
    private int nombreConsultorio;
    private boolean asignado;

    public Consultorio(int auxNumeroConsultorio)
    {
        numero++;
        this.id = numero;
        this.asignado = false;
        this.nombreConsultorio = auxNumeroConsultorio;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int auxId)
    {
        this.id = auxId;
    }

    public int getNombreConsultorio()
    {
        return nombreConsultorio;
    }

    public void setNombreConsultorio(int auxNumeroConsultorio)
    {
        this.nombreConsultorio = auxNumeroConsultorio;
    }

    public String toDatos()
    {
        String auxDatos;
        auxDatos = id + ";" + nombreConsultorio + ";" + getStringAsignado();
        return auxDatos;
    }

    public String toString()
    {
        return String.valueOf(nombreConsultorio);
    }

    public String getStringAsignado()
    {
        if(asignado)
        {
            return "Asignado";
        }
        else
        {
            return "No Asignado";
        }
    }

    public boolean isAsignado()
    {
        return asignado;
    }

    public void setAsignado(boolean auxAsignado)
    {
        this.asignado = auxAsignado;
    }

    public static void setNumeroConsultorio(int auxNumero)
    {
        Consultorio.numero = auxNumero;
    }
}
