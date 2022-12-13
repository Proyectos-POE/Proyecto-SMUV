package dao;

import modelo.*;

import java.util.ArrayList;

public class MedicoDao
{
    private final ArrayList<Medico> medicos;

    public MedicoDao()
    {
        medicos = new ArrayList<Medico>();;
    }

    public Medico getMedico(int auxId)
    {
        Medico auxMedico = null;
        for(Medico medico: medicos)
        {
            if(medico.getId() == auxId)
            {
                auxMedico = medico;
                break;
            }
        }
        return auxMedico;
    }

    public Medico getMedico(int auxId, Servicio auxServicio)
    {
        Medico auxMedico = null;
        for(Medico medico: medicos)
        {
            if(medico.getId() == auxId && medico.getEspecialidad().equals(auxServicio))
            {
                auxMedico = medico;
                break;
            }
        }
        return auxMedico;
    }

    public boolean anhadirMedico(Medico auxMedico)
    {
        medicos.add(auxMedico);
        return true;
    }

    public boolean eliminarMedico(Medico auxMedico)
    {
        medicos.remove(auxMedico);
        return true;
    }

    public boolean actualizarMedico(Medico auxMedico)
    {
        if(medicos.contains(auxMedico))
        {
            int pos = medicos.indexOf(auxMedico);
            medicos.set(pos, auxMedico);
            return true;
        }
        return false;
    }

    public ArrayList<Medico> getMedicos()
    {
        return medicos;
    }

    public ArrayList<Medico> getMedicos(Servicio auxServicio)
    {
        ArrayList<Medico> auxMedicos;
        auxMedicos = new ArrayList<Medico>();
        for(Medico medico: medicos)
        {
            if(medico.getEspecialidad().equals(auxServicio))
            {
                auxMedicos.add(medico);
            }
        }
        return auxMedicos;
    }
}
