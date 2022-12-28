package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class BackUp
{
    private final File directorioArchivos;
    private final File directorioBackup;
    byte[] buffer = new byte[4096];

    public BackUp(File auxDirectorioArchivos, File auxDirectorioBackup)
    {
        this.directorioArchivos = auxDirectorioArchivos;
        this.directorioBackup = auxDirectorioBackup;
        crearDirectorioBackup();
    }

    public boolean crearBackup(Fecha auxFecha, Hora auxHora)
    {
        try
        {
            String[] archivos = directorioArchivos.list();
            if(archivos.length != 0)
            {
                FileOutputStream salidaArchivo = new FileOutputStream(directorioBackup.getAbsolutePath() + File.separator + "backup_" + auxFecha.getFecha() + "_" + auxHora.getInicio().format(DateTimeFormatter.ofPattern("HH-mm-ss")) + ".zip");
                ZipOutputStream salidaZip = new ZipOutputStream(salidaArchivo);
                for(String archvio : archivos)
                {
                    FileInputStream entradaArchivo = new FileInputStream(directorioArchivos.getAbsolutePath() + File.separator + archvio);
                    ZipEntry entradaZip = new ZipEntry(archvio);
                    salidaZip.putNextEntry(entradaZip);
                    int len;
                    while ((len = entradaArchivo.read(buffer)) > 0)
                    {
                        salidaZip.write(buffer, 0, len);
                    }
                    entradaArchivo.close();
                }
                salidaZip.flush();
                salidaZip.closeEntry();
                salidaZip.close();
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean cargarBackup(File auxArchivoZip)
    {
        try
        {
            eliminarArchivos();
            ZipInputStream entradaArchivo = new ZipInputStream(new FileInputStream(auxArchivoZip));
            ZipEntry entradaZip = entradaArchivo.getNextEntry();
            while (entradaZip != null)
            {
                String nombreArchivo = entradaZip.getName();
                File archivoNuevo = new File(directorioArchivos + File.separator + nombreArchivo);
                new File(archivoNuevo.getParent()).mkdirs();
                FileOutputStream salidaArchivo = new FileOutputStream(archivoNuevo);
                int len;
                while ((len = entradaArchivo.read(buffer)) > 0)
                {
                    salidaArchivo.write(buffer, 0, len);
                }
                salidaArchivo.close();
                entradaZip = entradaArchivo.getNextEntry();
            }
            entradaArchivo.closeEntry();
            entradaArchivo.close();
            return true;
        }
        catch (IOException ex)
        {
            System.out.println("Porfavor elija un archivo zip");
            ex.printStackTrace();
            return false;
        }
    }

    private void crearDirectorioBackup()
    {
        if (!directorioBackup.exists())
        {
            directorioBackup.mkdirs();
        }
    }

    private void eliminarArchivos()
    {
        File[] archivos = directorioArchivos.listFiles();
        for(File archivo : archivos)
        {
            archivo.delete();
        }
    }
}

