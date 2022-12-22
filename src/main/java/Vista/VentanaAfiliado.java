package Vista;

import java.awt.*;
import javax.swing.*;
import modelo.Documento;


public class VentanaAfiliado extends Plantilla 
{
    private JLabel lblDocumento;
    private JLabel lblNombre;
    private JLabel lblTelefono;
    private JLabel lblCorreo;
    private JComboBox boxTipoDocumentoAgregar;
    private JComboBox boxTipoDocumentoEditar;
    private JTextField txtTipoDocumentoEliminar;
    private JTextField txtDocumentoAgregar;
    private JTextField txtNombreAgregar;
    private JTextField txtTelefonoAgregar;
    private JTextField txtCorreoAgregar;
    private JTextField txtDocumentoEditar;
    private JTextField txtNombreEditar;
    private JTextField txtTelefonoEditar;
    private JTextField txtCorreoEditar;
    private JTextField txtDocumentoEliminar;
    private JTextField txtNombreEliminar;
    private JTextField txtTelefonoEliminar;
    private JTextField txtCorreoEliminar;
    private String[] tipoDocumento;
    
    
    
    
    public VentanaAfiliado()
    {
      inicializarNuevosComponentes();
    }
    
    public void inicializarNuevosComponentes()
    {
        setTitle("VENTANA-AFILIADO");
        inicializarComponentesPredeterminados();
        lblTitulo.setText("GESTIÓN AFILIADOS");

        String tipoDocumento[] = {"C.C", "C:E", "T.I"};

        // Componentes de la ventana Agregar

        lblNombre = new JLabel("NOMBRE: ", SwingConstants.LEFT);
        lblNombre.setBounds(200, 60, 130, 20);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblNombre);

        txtNombreAgregar = new JTextField("",SwingConstants.LEFT);
        txtNombreAgregar.setBounds(390, 60, 200, 20);
        txtNombreAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(txtNombreAgregar);

        boxTipoDocumentoAgregar = new JComboBox();
        rellenarBoxTipoDocumento(boxTipoDocumentoAgregar, tipoDocumento);
        boxTipoDocumentoAgregar.setBounds(525, 90, 65, 20);
        boxTipoDocumentoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        boxTipoDocumentoAgregar.setFocusable(false);
        ((JLabel)boxTipoDocumentoAgregar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
         jpAgregar.add(boxTipoDocumentoAgregar);

        lblDocumento = new JLabel("DOCUMENTO: ", SwingConstants.LEFT);
        lblDocumento.setBounds(200, 90, 130, 20);
        lblDocumento.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblDocumento);

        txtDocumentoAgregar = new JTextField("", SwingConstants.LEFT);
        txtDocumentoAgregar.setBounds(390, 90, 130, 20);
        txtDocumentoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtDocumentoAgregar, 10);
        jpAgregar.add(txtDocumentoAgregar);

        lblCorreo = new JLabel("CORREO: ", SwingConstants.LEFT);
        lblCorreo.setBounds(200, 120, 130, 20);
        lblCorreo.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblCorreo);

        txtCorreoAgregar = new JTextField("", SwingConstants.LEFT);
        txtCorreoAgregar.setBounds(390, 120, 200, 20);
        txtCorreoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(txtCorreoAgregar);

        lblTelefono = new JLabel("TELÉFONO: ",SwingConstants.LEFT);
        lblTelefono.setBounds(200, 150, 130, 20);
        lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblTelefono);

        txtTelefonoAgregar = new JTextField("", SwingConstants.LEFT);
        txtTelefonoAgregar.setBounds(390, 150, 200, 20);
        txtTelefonoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtTelefonoAgregar,10);
        jpAgregar.add(txtTelefonoAgregar);

        // Componentes de la ventana Editar

        lblNombre = new JLabel("NOMBRE: ", SwingConstants.LEFT);
        lblNombre.setBounds(200, 120, 130, 20);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblNombre);

        txtNombreEditar = new JTextField("",SwingConstants.LEFT);
        txtNombreEditar.setBounds(390, 120, 200, 20);
        txtNombreEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtNombreEditar.setEnabled(false);
        jpEditar.add(txtNombreEditar);

        boxTipoDocumentoEditar = new JComboBox();
        rellenarBoxTipoDocumento(boxTipoDocumentoEditar, tipoDocumento);
        boxTipoDocumentoEditar.setBounds(525, 150, 65, 20);
        boxTipoDocumentoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        boxTipoDocumentoEditar.setFocusable(false);
        boxTipoDocumentoEditar.setEnabled(false);
        ((JLabel)boxTipoDocumentoEditar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpEditar.add(boxTipoDocumentoEditar);

        lblDocumento = new JLabel("DOCUMENTO: ", SwingConstants.LEFT);
        lblDocumento.setBounds(200, 150, 130, 20);
        lblDocumento.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblDocumento);

        txtDocumentoEditar = new JTextField("", SwingConstants.LEFT);
        txtDocumentoEditar.setBounds(390, 150, 130, 20);
        txtDocumentoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtDocumentoEditar.setEnabled(false);
        limitarTxt(txtDocumentoEditar, 10);
        jpEditar.add(txtDocumentoEditar);

        lblCorreo = new JLabel("CORREO: ", SwingConstants.LEFT);
        lblCorreo.setBounds(200, 180, 130, 20);
        lblCorreo.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblCorreo);

        txtCorreoEditar = new JTextField("", SwingConstants.LEFT);
        txtCorreoEditar.setBounds(390, 180, 200, 20);
        txtCorreoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtCorreoEditar.setEnabled(false);
        jpEditar.add(txtCorreoEditar);

        lblTelefono = new JLabel("TELÉFONO: ",SwingConstants.LEFT);
        lblTelefono.setBounds(200, 210, 130, 20);
        lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblTelefono);

        txtTelefonoEditar = new JTextField("", SwingConstants.LEFT);
        txtTelefonoEditar.setBounds(390, 210, 200, 20);
        txtTelefonoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtTelefonoEditar.setEnabled(false);
        limitarTxt(txtTelefonoEditar, 10);
        jpEditar.add(txtTelefonoEditar);
       
       // Componentes de la ventana Eliminar
       
       lblNombre = new JLabel("NOMBRE: ", SwingConstants.LEFT);
       lblNombre.setBounds(200, 120, 130, 20);
       lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblNombre);
       
       txtNombreEliminar = new JTextField("",SwingConstants.LEFT);
       txtNombreEliminar.setBounds(390, 120, 200, 20);
       txtNombreEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       txtNombreEliminar.setEnabled(false);
       jpEliminar.add(txtNombreEliminar);
       
       txtTipoDocumentoEliminar = new JTextField("", SwingConstants.LEFT);
       txtTipoDocumentoEliminar.setBounds(525, 150, 65, 20);
       txtTipoDocumentoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       txtTipoDocumentoEliminar.setEnabled(false);
        jpEliminar.add(txtTipoDocumentoEliminar);
       
       lblDocumento = new JLabel("DOCUMENTO: ", SwingConstants.LEFT);
       lblDocumento.setBounds(200, 150, 130, 20);
       lblDocumento.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblDocumento);
       
       txtDocumentoEliminar = new JTextField("", SwingConstants.LEFT);
       txtDocumentoEliminar.setBounds(390, 150, 130, 20);
       txtDocumentoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       txtDocumentoEliminar.setEnabled(false);
       limitarTxt(txtDocumentoEliminar, 10);
       jpEliminar.add(txtDocumentoEliminar);
       
       lblCorreo = new JLabel("CORREO: ", SwingConstants.LEFT);
       lblCorreo.setBounds(200, 180, 130, 20);
       lblCorreo.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblCorreo);
       
       txtCorreoEliminar = new JTextField("", SwingConstants.LEFT);
       txtCorreoEliminar.setBounds(390, 180, 200, 20);
       txtCorreoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       txtCorreoEliminar.setEnabled(false);
       jpEliminar.add(txtCorreoEliminar);
       
       lblTelefono = new JLabel("TELÉFONO: ",SwingConstants.LEFT);
       lblTelefono.setBounds(200, 210, 130, 20);
       lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblTelefono);
       
       txtTelefonoEliminar = new JTextField("", SwingConstants.LEFT);
       txtTelefonoEliminar.setBounds(390, 210, 200, 20);
       txtTelefonoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       txtTelefonoEliminar.setEnabled(false);
       limitarTxt(txtTelefonoEliminar, 10);
       jpEliminar.add(txtTelefonoEliminar);
       
    }
    
    public void activarControlesEditar()
    {
        txtNombreEditar.setEnabled(true);
        txtDocumentoEditar.setEnabled(true);
        boxTipoDocumentoEditar.setEnabled(true);
        txtCorreoEditar.setEnabled(true);
        txtTelefonoEditar.setEnabled(true);
    }
    
    public void desactivarControlesEditar()
    {
        txtNombreEditar.setEnabled(false);
        txtDocumentoEditar.setEnabled(false);
        boxTipoDocumentoEditar.setEnabled(false);
        txtCorreoEditar.setEnabled(false);
        txtTelefonoEditar.setEnabled(false);
    }
    
    public void activarControlesEliminar()
    {
        txtNombreEliminar.setEnabled(true);
        txtDocumentoEliminar.setEnabled(true);
        txtTipoDocumentoEliminar.setEnabled(true);
        txtCorreoEliminar.setEnabled(true);
        txtTelefonoEliminar.setEnabled(true);
    }
    
    public void desactivarControlesEliminar()
    {
        txtNombreEliminar.setEditable(false);
        txtDocumentoEliminar.setEditable(false);
        txtTipoDocumentoEliminar.setEditable(false);
        txtCorreoEliminar.setEditable(false);
        txtTelefonoEliminar.setEditable(false);
    }
    
    public void limpiarDatosAgregar()
    {
        setTxtNombreAgregar("");
        setTxtDocumentoAgregar("");
        setNullBoxTipoDocumentoAgregar();
        setTxtCorreoAgregar("");
        setTxtTelefonoAgregar("");
    }

    public void limpiarDatosEditar()
    {
        setTxtNombreEditar("");
        setTxtDocumentoEditar("");
        setNullBoxTipoDocumentoEditar();
        setTxtCorreoEditar("");
        setTxtTelefonoEditar("");
    }
    
    public void limpiarDatosEliminar()
    {
        setTxtNombreEliminar("");
        setTxtDocumentoEliminar("");
        setTxtTipoDocumentoEliminar("");
        setTxtCorreoEliminar("");
        setTxtTelefonoEliminar("");
    }
    
    //Getters
    
    public String getTxtNombreAgregar()
    {
        return txtNombreAgregar.getText();
    }
    
    public String getTxtNombreEditar()
    {
        return txtNombreEditar.getText();
    }
    
    public String getTxtDocumentoAgregar()
    {
        return txtDocumentoAgregar.getText();
    }
    
    public String getTxtDocumentoEditar()
    {
        return txtDocumentoEditar.getText();
    }
    
    public String getBoxTipoDocumentoAgregar()
    {
        return (String) boxTipoDocumentoAgregar.getSelectedItem();
    }
    
    public String getBoxTipoDocumentoEditar()
    {
        return (String) boxTipoDocumentoEditar.getSelectedItem();
    }
    
    public String getTxtCorreoAgregar()
    {
        return txtCorreoAgregar.getText();
    }
    
    public String getTxtCorreoEditar()
    {
        return txtCorreoEditar.getText();
    }
    
    public String getTxtTelefonoAgregar()
    {
        return txtTelefonoAgregar.getText();
    }
    
    public String getTxtTelefonoEditar()
    {
        return txtTelefonoEditar.getText();
    }
    
    //Setters
    
    public void setTxtNombreAgregar(String txt)
    {
        txtNombreAgregar.setText(txt);
    }
    
    public void setTxtNombreEditar(String txt)
    {
        txtNombreEditar.setText(txt);
    }
    
    public void setTxtNombreEliminar(String txt)
    {
        txtNombreEliminar.setText(txt);
    }
    
    public void setTxtDocumentoAgregar(String txt)
    {
        txtDocumentoAgregar.setText(txt);
    }
    
    public void setTxtDocumentoEditar(String txt)
    {
        txtDocumentoEditar.setText(txt);
    }
    
    public void setTxtDocumentoEliminar(String txt)
    {
        txtDocumentoEliminar.setText(txt);
    }
    
    public void setNullBoxTipoDocumentoAgregar()
    {
        boxTipoDocumentoAgregar.setSelectedItem(null);
    }
    
    public void setNullBoxTipoDocumentoEditar()
    {
        boxTipoDocumentoEditar.setSelectedItem(null);
    }
    
    public void setTxtTipoDocumentoEliminar(String txt)
    {
        txtTipoDocumentoEliminar.setText(txt);
    }
    
    public void setBoxTipoDocumentoEditar(Documento doc)
    {
       boxTipoDocumentoEditar.setSelectedItem(doc.getTipoDocumento());
    }
    
    public void setTxtCorreoAgregar(String txt)
    {
        txtCorreoAgregar.setText(txt);
    }
    
    public void setTxtCorreoEditar(String txt)
    {
        txtCorreoEditar.setText(txt);
    }
    
    public void setTxtCorreoEliminar(String txt)
    {
        txtCorreoEliminar.setText(txt);
    }
    
    public void setTxtTelefonoAgregar(String txt)
    {
        txtTelefonoAgregar.setText(txt);
    }
    
    public void setTxtTelefonoEditar(String txt)
    {
        txtTelefonoEditar.setText(txt);
    }
    
    public void setTxtTelefonoEliminar(String txt)
    {
        txtTelefonoEliminar.setText(txt);
    }
}
