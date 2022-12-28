package modelo;

import java.io.Serializable;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class Documento implements Serializable
{
    private String tipoDocumento;
    private long numeroDocumento;
    private static final long serialVersionUID = 1L;

    public Documento(String auxTipoDocumento, long auxNumeroDocumento)
    {
        this.tipoDocumento = auxTipoDocumento;
        this.numeroDocumento = auxNumeroDocumento;
    }

    public String getTipoDocumento()
    {
        return tipoDocumento;
    }

    public void setTipoDocumento(String auxTipoDocumento)
    {
        this.tipoDocumento = auxTipoDocumento;
    }

    public long getNumeroDocumento()
    {
        return numeroDocumento;
    }

    public void setNumeroDocumento(long auxNumeroDocumento)
    {
        this.numeroDocumento = auxNumeroDocumento;
    }
}
