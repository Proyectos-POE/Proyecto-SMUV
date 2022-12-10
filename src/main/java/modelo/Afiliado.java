package modelo;

public class Afiliado extends Persona
{
    private int id;
    private static int numero;

    public Afiliado(String auxNombre, Documento auxDocumento, String auxCorreo, long auxTelefono)
    {
        numero++;
        id = numero;
        this.nombre = auxNombre;
        this.documento = auxDocumento;
        this.correo = auxCorreo;
        this.telefono = auxTelefono;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int auxId)
    {
        this.id = auxId;
        this.numero = auxId;
    }

    public static int getNumero()
    {
        return numero;
    }

    public static void setNumero(int auxNumero)
    {
        Afiliado.numero = auxNumero;
    }

    public String toString()
    {
        String auxDatos;
        auxDatos = id + ";" + nombre + ";" + documento.getTipoDocumento() + ";" + documento.getNumeroDocumento() + ";" + correo + ";" + telefono;
        return auxDatos;
    }
}
