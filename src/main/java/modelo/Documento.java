package modelo;

import java.io.Serializable;

public class Documento implements Serializable
{
    private String tipoDocumento;
    private long numeroDocumento;

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
