package dao;

import modelo.Consultorio;

import java.util.ArrayList;

public class ConsultorioDao
{
    private ArrayList<Consultorio> consultorios;

    public ConsultorioDao()
    {
        consultorios = new ArrayList<Consultorio>();;
    }

    public Consultorio getConsultorio(int auxId)
    {
        Consultorio auxConsultorio = null;
        for(Consultorio consultorio: consultorios)
        {
            if(consultorio.getId() == auxId)
            {
                auxConsultorio = consultorio;
                break;
            }
        }
        return auxConsultorio;
    }

    public Consultorio getConsultorio(int auxId, boolean auxAsignado)
    {
        Consultorio auxConsultorio = null;
        for(Consultorio consultorio: consultorios)
        {
            if(consultorio.getId() == auxId && consultorio.isAsignado() == auxAsignado)
            {
                auxConsultorio = consultorio;
                break;
            }
        }
        return auxConsultorio;
    }

    public boolean anhadirConsultorio(Consultorio auxConsultorio)
    {
        consultorios.add(auxConsultorio);
        return true;
    }

    public boolean eliminarConsultorio(Consultorio auxConsultorio)
    {
        consultorios.remove(auxConsultorio);
        return true;
    }

    public boolean actualizarConsultorio(Consultorio auxConsultorio)
    {
        if(consultorios.contains(auxConsultorio))
        {
            int pos = consultorios.indexOf(auxConsultorio);
            consultorios.set(pos, auxConsultorio);
            return true;
        }
        return false;
    }

    public ArrayList<Consultorio> getConsultorios()
    {
        return consultorios;
    }
    public ArrayList<Consultorio> getConsultorios(boolean auxAsignado)
    {
        ArrayList<Consultorio> auxConsultorios;
        auxConsultorios = new ArrayList<Consultorio>();
        for(Consultorio consultorio: consultorios)
        {
            if(consultorio.isAsignado() == auxAsignado)
            {
                auxConsultorios.add(consultorio);
            }
        }
        return auxConsultorios;
    }
}

