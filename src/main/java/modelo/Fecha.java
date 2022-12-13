package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha
{
    private LocalDate fecha;

    public Fecha(LocalDate auxFecha)
    {
        this.fecha = auxFecha;
        formatearFecha();
    }

    public void formatearFecha()
    {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        fecha.format(formato);
    }

    public LocalDate getFecha()
    {
        return fecha;
    }

    public void setFecha(LocalDate auxFecha)
    {
        this.fecha = auxFecha;
    }
}