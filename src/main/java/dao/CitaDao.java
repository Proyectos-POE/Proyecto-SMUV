package dao;

import modelo.*;

import java.util.ArrayList;

public class CitaDao
{
    private final ArrayList<Cita> citas;

    public CitaDao()
    {
        citas = new ArrayList<Cita>();;
    }

    public Cita getCita(int auxId)
    {
        Cita auxCita = null;
        for(Cita cita: citas)
        {
            if(cita.getId() == auxId)
            {
                auxCita = cita;
                break;
            }
        }
        return auxCita;
    }

    public Cita getCita(Afiliado auxAfiliado)
    {
        Cita auxCita = null;
        for(Cita cita: citas)
        {
            if(cita.getAfiliado().getId() == auxAfiliado.getId())
            {
                auxCita = cita;
                break;
            }
        }
        return auxCita;
    }

    public boolean agregarCita(Cita cita)
    {
        citas.add(cita);
        return true;
    }

    public boolean eliminarCita(Cita auxCita)
    {
        citas.remove(auxCita);
        return true;
    }

    public boolean actualizarCita(Cita auxCita)
    {
        if(citas.contains(auxCita))
        {
            int pos = citas.indexOf(auxCita);
            citas.set(pos, auxCita);
            return true;
        }
        return false;
    }

    public ArrayList<Cita> getCitas()
    {
        return citas;
    }
}
