package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Conexion implements Serializable
{
    private File archivo;

    public Conexion(File auxArchivo)
    {
        this.archivo = auxArchivo;
    }

    public Conexion()
    {
        archivo = null;
    }

    public File getArchivo()
    {
        return archivo;
    }

    public void setArchivo(File archivo)
    {
        this.archivo = archivo;
    }

    public ArrayList<ArrayList<String>> leerDatos()
    {
        ArrayList<ArrayList<String>> auxDatos = new ArrayList<ArrayList<String>>();
        try
        {
            FileReader entrada = new FileReader(archivo);
            BufferedReader entradaBuffer = new BufferedReader(entrada);
            String linea;
            while( (linea = entradaBuffer.readLine()) != null)
            {
                ArrayList<String> auxDatosFila = new ArrayList<String>();
                StringTokenizer st = new StringTokenizer(linea, ";");
                String auxToken;
                while (st.hasMoreTokens())
                {
                    auxToken = st.nextToken();
                    auxDatosFila.add(auxToken);
                }
                auxDatos.add(auxDatosFila);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
        return auxDatos;
    }

    public void escribirDatos(ArrayList<String> auxDatos)
    {
        try
        {
            FileWriter salida = new FileWriter(archivo);
            PrintWriter salidaBuffer = new PrintWriter(salida);
            for(int i = 0; i < auxDatos.size(); i++)
            {
               salidaBuffer.println(auxDatos.get(i));
            }
            if ( salida != null)
            {
                salida.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
