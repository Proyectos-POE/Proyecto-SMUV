package modelo;

public class Consultorio
{
    private static int numero;
    private int id;
    private int numeroConsultorio;
    private boolean asignado;

    public Consultorio(int auxNumeroConsultorio)
    {
        numero++;
        this.id = numero;
        this.asignado = false;
        this.numeroConsultorio = auxNumeroConsultorio;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int auxId)
    {
        this.id = auxId;
    }

    public int getNumeroConsultorio()
    {
        return numeroConsultorio;
    }

    public void setNumeroConsultorio(int auxNumeroConsultorio)
    {
        this.numeroConsultorio = auxNumeroConsultorio;
    }

    public String toDatos()
    {
        String auxDatos;
        auxDatos = id + ";" + numeroConsultorio + ";" + getStringAsignado();
        return auxDatos;
    }

    public String toString()
    {
        return String.valueOf(numeroConsultorio);
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
}
