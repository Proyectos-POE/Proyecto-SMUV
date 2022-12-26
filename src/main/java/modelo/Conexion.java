package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Conexion implements Serializable
{
    private final File directorioArchivos;
    private File archivo;

    public Conexion(File auxDirectorioArchivos)
    {
        directorioArchivos = auxDirectorioArchivos;
        crearCarpetaArchivos();
        archivo = null;
    }

    public File getArchivo()
    {
        return archivo;
    }

    public void setArchivo(String auxNombreArchivo)
    {
        this.archivo = new File(directorioArchivos.getAbsolutePath() + File.separator + auxNombreArchivo);
    }

    public void escribirDatosTxt(ArrayList auxDatos)
    {
        try
        {
            FileWriter salida = new FileWriter(archivo);
            PrintWriter salidaBuffer = new PrintWriter(salida);
            Afiliado auxAfiliado;
            for (Object  auxDato : auxDatos)
            {
                auxAfiliado = (Afiliado) auxDato;
                salidaBuffer.println(auxAfiliado.toDatos());
            }
            salida.close();
        }
        catch (IOException e)
        {
            System.out.println("Error a cargar las datos" + e.getMessage());
        }
    }

    public void escribirDatosBinario(ArrayList auxDatos)
    {
        try
        {
            FileOutputStream salida = new FileOutputStream(archivo);
            ObjectOutputStream salidaObject = new ObjectOutputStream(salida);
            for (Object auxDato : auxDatos)
            {
                salidaObject.writeObject(auxDato);
            }
            salida.close();
        }
        catch (IOException e)
        {
            System.out.println("Error a cargar las datos" + e.getMessage());
        }
    }

    public ArrayList<Object> leerDatosBinario()
    {
        ArrayList<Object> auxDatos = new ArrayList<Object>();
        try
        {
            FileInputStream entrada = new FileInputStream (archivo);
            ObjectInputStream  entradaObjeto = new ObjectInputStream(entrada);
            Object auxObjeto;
            while (entrada.available() > 0)
            {
                auxObjeto = entradaObjeto.readObject();
                if(auxObjeto != null)
                {
                    auxDatos.add(auxObjeto);
                }
                ;           }
        }
        catch (IOException e)
        {
            System.out.println("Error a cargar los datos" + e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error a cargar las clases" + e.getMessage());
        }
        return auxDatos;
    }

    private void crearCarpetaArchivos()
    {
        if(!directorioArchivos.exists())
        {
            directorioArchivos.mkdirs();
        }
    }
}