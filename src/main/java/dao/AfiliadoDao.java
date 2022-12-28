package dao;

import modelo.Afiliado;

import java.util.ArrayList;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class AfiliadoDao
{
    private final ArrayList<Afiliado> afiliados;

    public AfiliadoDao()
    {
        afiliados = new ArrayList<Afiliado>();
    }

    public Afiliado getAfiliado(int auxId)
    {
        Afiliado auxAfiliado = null;
        for(Afiliado afiliado: afiliados)
        {
            if(afiliado.getId() == auxId)
            {
                auxAfiliado = afiliado;
                break;
            }
        }
        return auxAfiliado;
    }

    public boolean anhadirAfiliado(Afiliado auxAfiliado)
    {
        afiliados.add(auxAfiliado);
        return true;
    }

    public boolean eliminarAfiliado(Afiliado auxAfiliado)
    {
        afiliados.remove(auxAfiliado);
        return true;
    }

    public boolean actualizarAfiliado(Afiliado auxAfiliado)
    {
        if(afiliados.contains(auxAfiliado))
        {
            int pos = afiliados.indexOf(auxAfiliado);
            afiliados.set(pos, auxAfiliado);
            return true;
        }
        return false;
    }

    public ArrayList<Afiliado> getAfiliados()
    {
        return afiliados;
    }
}
