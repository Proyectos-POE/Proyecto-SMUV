package Vista;

import java.awt.*;
import javax.swing.*;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class VentanaServicio extends Plantilla 
{
    private JLabel lblServicio;
    private JTextField txtServicioAgregar;
    private JTextField txtServicioEditar;
    private JTextField txtServicioEliminar;




    public VentanaServicio()
    {
      inicializarNuevosComponentes();
    }

    public void inicializarNuevosComponentes()
    {
       setTitle("VENTANA-SERVICIO"); 
       inicializarComponentesPredeterminados();
       
       lblTitulo.setText("GESTIÓN DE SERVICIOS");
       
       // Componentes de la ventana Agregar


       lblServicio = new JLabel("SERVICIO: ", SwingConstants.LEFT);
       lblServicio.setBounds(200, 60, 100, 20);
       lblServicio.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblServicio);

       txtServicioAgregar = new JTextField("", SwingConstants.LEFT);
       txtServicioAgregar.setBounds(390, 60, 200, 20);
       txtServicioAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(txtServicioAgregar);


       // Componentes de la ventana Editar

       lblServicio = new JLabel("SERVICIO: ", SwingConstants.LEFT);
       lblServicio.setBounds(200, 120, 120, 20);
       lblServicio.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblServicio);

       txtServicioEditar = new JTextField("", SwingConstants.LEFT);
       txtServicioEditar.setBounds(390, 120, 200, 20);
       txtServicioEditar.setFont(new Font("Arial", Font.BOLD, 16));
       txtServicioEditar.setEnabled(false);
       jpEditar.add(txtServicioEditar);


       // Componentes de la ventana Eliminar

       lblServicio = new JLabel("SERVICIO: ", SwingConstants.LEFT);
       lblServicio.setBounds(200, 120, 100, 20);
       lblServicio.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblServicio);

       txtServicioEliminar = new JTextField("", SwingConstants.LEFT);
       txtServicioEliminar.setBounds(390, 120, 200, 20);
       txtServicioEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       txtServicioEliminar.setEnabled(false);
       jpEliminar.add(txtServicioEliminar);

    }
    
    public void activarControlesEditar()
    {
        txtServicioEditar.setEnabled(true);
    }
    
    public void desactivarControlesEditar()
    {
        txtServicioEditar.setEnabled(false);
    }
    
    public void activarControlesEliminar()
    {
        txtServicioEliminar.setEnabled(true);
    }
    
    public void desactivarControlesEliminar()
    {
        txtServicioEliminar.setEditable(false);
    }
    //Getters
    
    public String getTxtServicioAgregar() 
    {
        return txtServicioAgregar.getText();
    }

    public String getTxtServicioEditar() 
    {
        return txtServicioEditar.getText();
    }
    
    //Setters
    
    public void setTxtServicioAgregar(String txt)
    {
       txtServicioAgregar.setText(txt);
    }
    public void setTxtServicioEditar(String txt) 
    {
        txtServicioEditar.setText(txt);
    }

    public void setTxtServicioEliminar(String txt) 
    {
        txtServicioEliminar.setText(txt);
    }

}