package Vista;

import java.awt.*;
import javax.swing.*;


public class VentanaServicio extends Plantilla 
{
    public JLabel lblServicio;
    public JTextField txtServicioAgregar;
    public JTextField txtServicioEditar;
    public JTextField txtServicioEliminar;




    public VentanaServicio()
    {
      inicializarComponentesPredeterminados();
      inicializarNuevosComponentes();
    }

    public void inicializarNuevosComponentes()
    {

       // Componentes de la ventana Agregar


       lblServicio = new JLabel("SERVICIO: ", SwingConstants.LEFT);
       lblServicio.setBounds(20, 60, 435, 20);
       lblServicio.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblServicio);

       txtServicioAgregar = new JTextField("", SwingConstants.LEFT);
       txtServicioAgregar.setBounds(165, 60, 200, 20);
       txtServicioAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(txtServicioAgregar);


       // Componentes de la ventana Editar

       lblServicio = new JLabel("SERVICIO: ", SwingConstants.LEFT);
       lblServicio.setBounds(20, 120, 435, 20);
       lblServicio.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblServicio);

       txtServicioEditar = new JTextField("", SwingConstants.LEFT);
       txtServicioEditar.setBounds(165, 120, 200, 20);
       txtServicioEditar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(txtServicioEditar);


       // Componentes de la ventana Eliminar

       lblServicio = new JLabel("SERVICIO: ", SwingConstants.LEFT);
       lblServicio.setBounds(20, 120, 435, 20);
       lblServicio.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblServicio);

       txtServicioEliminar = new JTextField("", SwingConstants.LEFT);
       txtServicioEliminar.setBounds(165, 120, 200, 20);
       txtServicioEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(txtServicioEliminar);



       //Componentes de la ventana Archivo

       String[] nombresColumnas = {"ID", "SERVICIO"};
    }

    public int getTxtServicioAgregar() 
    {
        return Integer.parseInt(txtServicioAgregar.getText());
    }

    public int getTxtServicioEditar() 
    {
        return Integer.parseInt(txtServicioEditar.getText());
    }

    public void setTxtServicioEditar(int txtServicioEditar) 
    {

    }

    public void setTxtServicioEliminar(int txtServicioEliminar) 
    {

    }

}