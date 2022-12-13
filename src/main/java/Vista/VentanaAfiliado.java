package Vista;

import java.awt.*;
import javax.swing.*;


public class VentanaAfiliado extends Plantilla 
{
    public JLabel lblNIT;
    public JLabel lblID;
    public JLabel lblNombre;
    public JLabel lblTelefono;
    public JLabel lblCorreo;
    public JComboBox cbTipo;
    public JTextField txtDocumentoAgregar;
    public JTextField txtIDAgregar;
    public JTextField txtNombreAgregar;
    public JTextField txtTelefonoAgregar;
    public JTextField txtCorreoAgregar;
    public JTextField txtDocumentoEditar;
    public JTextField txtIDEditar;
    public JTextField txtNombreEditar;
    public JTextField txtTelefonoEditar;
    public JTextField txtCorreoEditar;
    public JTextField txtDocumentoEliminar;
    public JTextField txtIDEliminar;
    public JTextField txtNombreEliminar;
    public JTextField txtTelefonoEliminar;
    public JTextField txtCorreoEliminar;
    
    
    
    
    public VentanaAfiliado()
    {
      inicializarComponentesPredeterminados();
      inicializarNuevosComponentes();
    }
    
    public void inicializarNuevosComponentes()
    {
        
       // Componentes de la ventana Agregar

       
       lblNIT = new JLabel("Documento: ", SwingConstants.LEFT);
       lblNIT.setBounds(60, 90, 435, 20);
       lblNIT.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblNIT);
       
       txtDocumentoAgregar = new JTextField("", SwingConstants.LEFT);
       txtDocumentoAgregar.setBounds(165, 90, 200, 20);
       txtDocumentoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       limitarTxt(txtDocumentoAgregar, 10);
       jpAgregar.add(txtDocumentoAgregar);
       
       lblNombre = new JLabel("Nombre: ", SwingConstants.LEFT);
       lblNombre.setBounds(60, 120, 435, 20);
       lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblNombre);
       
       txtNombreAgregar = new JTextField("",SwingConstants.LEFT);
       txtNombreAgregar.setBounds(165, 120, 200, 20);
       txtNombreAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(txtNombreAgregar);
       
       lblTelefono = new JLabel("Teléfono: ",SwingConstants.LEFT);
       lblTelefono.setBounds(60, 150, 435, 20);
       lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblTelefono);
       
       txtTelefonoAgregar = new JTextField("", SwingConstants.LEFT);
       txtTelefonoAgregar.setBounds(165, 150, 200, 20);
       txtTelefonoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       limitarTxt(txtTelefonoAgregar,10);
       jpAgregar.add(txtTelefonoAgregar);
       
       lblCorreo = new JLabel("Correo: ", SwingConstants.LEFT);
       lblCorreo.setBounds(60, 180, 435, 20);
       lblCorreo.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblCorreo);
       
       txtCorreoAgregar = new JTextField("", SwingConstants.LEFT);
       txtCorreoAgregar.setBounds(165, 180, 200, 20);
       txtCorreoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(txtCorreoAgregar);
       
       // Componentes de la ventana Editar
       
       lblNIT = new JLabel("Documento: ", SwingConstants.LEFT);
       lblNIT.setBounds(60, 120, 435, 20);
       lblNIT.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblNIT);
       
       txtDocumentoEditar = new JTextField("", SwingConstants.LEFT);
       txtDocumentoEditar.setBounds(165, 120, 200, 20);
       txtDocumentoEditar.setFont(new Font("Arial", Font.BOLD, 16));
       limitarTxt(txtDocumentoEditar, 10);
       jpEditar.add(txtDocumentoEditar);
       
       lblNombre = new JLabel("Nombre: ", SwingConstants.LEFT);
       lblNombre.setBounds(60, 150, 435, 20);
       lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblNombre);
       
       txtNombreEditar = new JTextField("",SwingConstants.LEFT);
       txtNombreEditar.setBounds(165, 150, 200, 20);
       txtNombreEditar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(txtNombreEditar);
       
       lblTelefono = new JLabel("Teléfono: ",SwingConstants.LEFT);
       lblTelefono.setBounds(60, 180, 435, 20);
       lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblTelefono);
       
       txtTelefonoEditar = new JTextField("", SwingConstants.LEFT);
       txtTelefonoEditar.setBounds(165, 180, 200, 20);
       txtTelefonoEditar.setFont(new Font("Arial", Font.BOLD, 16));
       limitarTxt(txtTelefonoEditar, 10);
       jpEditar.add(txtTelefonoEditar);
       
       lblCorreo = new JLabel("Correo: ", SwingConstants.LEFT);
       lblCorreo.setBounds(60, 210, 435, 20);
       lblCorreo.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblCorreo);
       
       txtCorreoEditar = new JTextField("", SwingConstants.LEFT);
       txtCorreoEditar.setBounds(165, 210, 200, 20);
       txtCorreoEditar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(txtCorreoEditar);
       
       // Componentes de la ventana Eliminar
       
       lblNIT = new JLabel("Documento: ", SwingConstants.LEFT);
       lblNIT.setBounds(60, 120, 435, 20);
       lblNIT.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblNIT);
       
       txtDocumentoEliminar = new JTextField("", SwingConstants.LEFT);
       txtDocumentoEliminar.setBounds(165, 120, 200, 20);
       txtDocumentoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       limitarTxt(txtDocumentoEliminar, 10);
       jpEliminar.add(txtDocumentoEliminar);
       
       lblNombre = new JLabel("Nombre: ", SwingConstants.LEFT);
       lblNombre.setBounds(60, 150, 435, 20);
       lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblNombre);
       
       txtNombreEliminar = new JTextField("",SwingConstants.LEFT);
       txtNombreEliminar.setBounds(165, 150, 200, 20);
       txtNombreEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(txtNombreEliminar);
       
       lblTelefono = new JLabel("Teléfono: ",SwingConstants.LEFT);
       lblTelefono.setBounds(60, 180, 435, 20);
       lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblTelefono);
       
       txtTelefonoEliminar = new JTextField("", SwingConstants.LEFT);
       txtTelefonoEliminar.setBounds(165, 180, 200, 20);
       txtTelefonoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       limitarTxt(txtTelefonoEliminar, 10);
       jpEliminar.add(txtTelefonoEliminar);
       
       lblCorreo = new JLabel("Correo: ", SwingConstants.LEFT);
       lblCorreo.setBounds(60, 210, 435, 20);
       lblCorreo.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblCorreo);
       
       txtCorreoEliminar = new JTextField("", SwingConstants.LEFT);
       txtCorreoEliminar.setBounds(165, 210, 200, 20);
       txtCorreoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(txtCorreoEliminar);
       
       //Componentes de la ventana Archivo
       
       String[] nombresColumnas = {"ID", "DOCUMENTO", "NOMBRE", "TELÉFONO", "CORREO"};
    }

    public int getTxtDocumentoAgregar() 
    {
        return Integer.parseInt(txtDocumentoAgregar.getText());
    }

    public int getTxtIDAgregar() 
    {
        return Integer.parseInt(txtIDAgregar.getText());
    }

    public String getTxtNombreAgregar() 
    {
        return String.valueOf(txtNombreAgregar);
    }

    public int getTxtTelefonoAgregar() 
    {
        return Integer.parseInt(txtTelefonoAgregar.getText());
    }

    public String getTxtCorreoAgregar() 
    {
        return String.valueOf(txtCorreoAgregar);
    }

    public int getTxtIDEditar() 
    {
        return Integer.parseInt(txtIDEditar.getText());
    }

    public int getTxtIDEliminar() 
    {
        return Integer.parseInt(txtIDEliminar.getText());
    }

    public int getTxtDocumentoEditar() 
    {
        return Integer.parseInt(txtDocumentoEditar.getText());
    }

    public void setTxtDocumentoEditar(int txtDocumentoEditar) 
    {
        this.txtDocumentoEditar.setText(String.valueOf(txtDocumentoEditar));
    }

    public String getTxtNombreEditar() 
    {
        return String.valueOf(txtNombreEditar);
    }

    public void setTxtNombreEditar(String txtNombreEditar) 
    {
        this.txtNombreEditar.setText(txtNombreEditar);
    }

    public int getTxtTelefonoEditar() 
    {
        return Integer.parseInt(txtTelefonoEditar.getText());
    }

    public void setTxtTelefonoEditar(int txtTelefonoEditar) 
    {
        this.txtTelefonoEditar.setText(String.valueOf(txtTelefonoEditar));
    }

    public String getTxtCorreoEditar() 
    {
        return String.valueOf(txtCorreoEditar);
    }

    public void setTxtCorreoEditar(String txtCorreoEditar) 
    {
        this.txtCorreoEditar.setText(txtCorreoEditar);
    }

    public void setTxtDocumentoEliminar(int txtDocumentoEliminar) 
    {
        this.txtDocumentoEliminar.setText(String.valueOf(txtDocumentoEliminar));
    }

    public void setTxtNombreEliminar(String txtNombreEliminar) 
    {
        this.txtNombreEliminar.setText(txtNombreEliminar);
    }

    public void setTxtTelefonoEliminar(int txtTelefonoEliminar) 
    {
        this.txtTelefonoEliminar.setText(String.valueOf(txtTelefonoEliminar));
    }

    public void setTxtCorreoEliminar(String txtCorreoEliminar) 
    {
        this.txtCorreoEliminar.setText(txtCorreoEliminar);
    }
    
}
