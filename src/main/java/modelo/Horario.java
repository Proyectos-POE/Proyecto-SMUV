package modelo;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class Horario implements Serializable
{
    private final ArrayList<Hora> horario;
    private final LocalTime horaInicial;
    private final Duration duracion;

    public Horario(LocalTime auxHoraInicial, Duration auxDuracion)
    {
        this.horario = new ArrayList<Hora>();
        this.horaInicial = auxHoraInicial;
        this.duracion = auxDuracion;
        generarHorarios();
    }

    public Hora getHora(int auxId)
    {
        Hora auxHora = null;
        for(Hora hora : horario)
        {
            if(hora.getId() == auxId)
            {
                auxHora = hora;
                break;
            }
        }
        return auxHora;
    }

    public Hora getHora(int auxId, boolean auxAsignado)
    {
        Hora auxHora = null;
        for(Hora hora : horario)
        {
            if(hora.getId() == auxId && hora.isAsignado() == auxAsignado)
            {
                auxHora = hora;
                break;
            }
        }
        return auxHora;
    }

    public void generarHorarios()
    {
        LocalTime auxHoraInicial;
        int auxId;
        auxHoraInicial = horaInicial;
        for(int i = 0; i < 20; i++)
        {
            auxId = i + 1;
            Hora hora = new Hora(auxId ,auxHoraInicial, duracion);
            horario.add(hora);
            auxHoraInicial = hora.getFin();
        }
    }

    public ArrayList<Hora> getHorario()
    {
        return horario;
    }

    public ArrayList<Hora> getHorario(boolean auxAsignado)
    {
        ArrayList<Hora> auxHorario;
        auxHorario = new ArrayList<Hora>();
        for(Hora hora: horario)
        {
            if(hora.isAsignado() == auxAsignado)
            {
                auxHorario.add(hora);
            }
        }
        return auxHorario;
    }

    public void comprobarHorariosDisponibles(ArrayList<Hora> horariosNoDisponibles)
    {
        if(!horariosNoDisponibles.isEmpty())
        {
            for(int i = 0; i < horario.size(); i++)
            {
                for(int j = 0; j < horariosNoDisponibles.size(); j++)
                {
                    if(horario.get(i).getInicio().equals(horariosNoDisponibles.get(j).getInicio()))
                    {
                        horario.get(i).setAsignado(true);
                    }
                }
            }
        }
    }

    public void restablecerDisponibilidad()
    {
        for(Hora hora : horario)
        {
            hora.setAsignado(false);
        }
    }
    public void setAsignado(Hora auxHora)
    {
        if(horario.contains(auxHora))
        {
            horario.get(horario.indexOf(auxHora)).setAsignado(true);
        }
    }
}
