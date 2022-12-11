package Vista;

import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;

public class VentanaMedico extends Plantilla
{
    private JLabel lblNombre;
    private JTextField txtNombreAgregar;
    private JTextField txtNombreEditar;
    private JTextField txtNombreEliminar;
    private JLabel lblDocumento;
    private JTextField txtDocumentoAgregar;
    private JTextField txtDocumentoEditar;
    private JTextField txtDocumentoEliminar;
    private JLabel lblCorreo;
    private JTextField txtCorreoAgregar;
    private JTextField txtCorreoEditar;
    private JTextField txtCorreoEliminar;
    private JLabel lblTelefono;
    private JTextField txtTelefonoAgregar;
    private JTextField txtTelefonoEditar;
    private JTextField txtTelefonoEliminar;
    private JLabel lblEspecialidad;
    private JComboBox boxEspecialidadAgregar;
    private JComboBox boxEspecialidadEditar;
    private JTextField txtEspecialidadEliminar;
    private JLabel lblConsultorio;
    private JComboBox boxConsulAgregar;
    private JComboBox boxConsulEditar;
    private JTextField txtConsulEliminar;
    private String[] especialidades;


    public VentanaMedico()
    {
        inicializarComponentes();
    }

    public void inicializarComponentes()
    {
        setTitle("VENTANA-MEDICO");
        inicializarComponentesPredeterminados();
        lblTitulo.setText("MEDICOS");

        //String[] especialidades = {"1"};
        //listRenderer = new DefaultListCellRenderer();
        //listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        //Panel Agregar

        lblNombre = new JLabel("NOMBRE: ",SwingConstants.LEFT);
        lblNombre.setBounds(20, 60, 130, 20);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblNombre);

        txtNombreAgregar = new JTextField("",SwingConstants.LEFT);
        txtNombreAgregar.setBounds(165,60,200,20);
        txtNombreAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(txtNombreAgregar);

        lblDocumento = new JLabel("# DOCUMENTO: ",SwingConstants.LEFT);
        lblDocumento.setBounds(20, 90, 130, 20);
        lblDocumento.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblDocumento);

        txtDocumentoAgregar = new JTextField("",SwingConstants.LEFT);
        txtDocumentoAgregar.setBounds(165,90,200,20);
        txtDocumentoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtDocumentoAgregar,10);
        jpAgregar.add(txtDocumentoAgregar);

        lblCorreo = new JLabel("CORREO: ",SwingConstants.LEFT);
        lblCorreo.setBounds(20, 120, 130, 20);
        lblCorreo.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblCorreo);

        txtCorreoAgregar = new JTextField("",SwingConstants.LEFT);
        txtCorreoAgregar.setBounds(165,120,200,20);
        txtCorreoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(txtCorreoAgregar);

        lblTelefono = new JLabel("TELEFONO: ",SwingConstants.LEFT);
        lblTelefono.setBounds(20, 150, 130, 20);
        lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblTelefono);

        txtTelefonoAgregar = new JTextField("",SwingConstants.LEFT);
        txtTelefonoAgregar.setBounds(165,150,200,20);
        txtTelefonoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtTelefonoAgregar,10);
        jpAgregar.add(txtTelefonoAgregar);

        lblEspecialidad = new JLabel("ESPECIALIDAD: ",SwingConstants.LEFT);
        lblEspecialidad.setBounds(20, 180, 130, 20);
        lblEspecialidad.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblEspecialidad);

        boxEspecialidadAgregar = new JComboBox();
        boxEspecialidadAgregar.setBounds(165,180,200,20);
        boxEspecialidadAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        boxEspecialidadAgregar.setFocusable(false);
        ((JLabel)boxEspecialidadAgregar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpAgregar.add(boxEspecialidadAgregar);

        lblConsultorio = new JLabel("CONSULTORIO: ",SwingConstants.LEFT);
        lblConsultorio.setBounds(20, 210, 130, 20);
        lblConsultorio.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblConsultorio);

        boxConsulAgregar = new JComboBox();
        boxConsulAgregar.setBounds(165,210,200,20);
        boxConsulAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        boxConsulAgregar.setFocusable(false);
        ((JLabel)boxConsulAgregar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpAgregar.add(boxConsulAgregar);

        //Panel editar

        lblNombre = new JLabel("NOMBRE: ",SwingConstants.LEFT);
        lblNombre.setBounds(20, 120, 130, 20);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblNombre);

        txtNombreEditar = new JTextField("",SwingConstants.LEFT);
        txtNombreEditar.setBounds(165,120,200,20);
        txtNombreEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtNombreEditar.setEnabled(false);
        jpEditar.add(txtNombreEditar);

        lblDocumento = new JLabel("# DOCUMENTO: ",SwingConstants.LEFT);
        lblDocumento.setBounds(20, 150, 130, 20);
        lblDocumento.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblDocumento);

        txtDocumentoEditar = new JTextField("",SwingConstants.LEFT);
        txtDocumentoEditar.setBounds(165,150,200,20);
        txtDocumentoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtDocumentoEditar,10);
        txtDocumentoEditar.setEnabled(false);
        jpEditar.add(txtDocumentoEditar);

        lblCorreo = new JLabel("CORREO: ",SwingConstants.LEFT);
        lblCorreo.setBounds(20, 180, 130, 20);
        lblCorreo.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblCorreo);

        txtCorreoEditar = new JTextField("",SwingConstants.LEFT);
        txtCorreoEditar.setBounds(165,180,200,20);
        txtCorreoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtCorreoEditar.setEnabled(false);
        jpEditar.add(txtCorreoEditar);

        lblTelefono = new JLabel("TELEFONO: ",SwingConstants.LEFT);
        lblTelefono.setBounds(20, 210, 130, 20);
        lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblTelefono);

        txtTelefonoEditar = new JTextField("",SwingConstants.LEFT);
        txtTelefonoEditar.setBounds(165,210,200,20);
        txtTelefonoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtTelefonoEditar.setEnabled(false);
        limitarTxt(txtTelefonoEditar,10);
        jpEditar.add(txtTelefonoEditar);

        lblEspecialidad = new JLabel("ESPECIALIDAD: ",SwingConstants.LEFT);
        lblEspecialidad.setBounds(20, 240, 130, 20);
        lblEspecialidad.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblEspecialidad);

        boxEspecialidadEditar = new JComboBox();
        boxEspecialidadEditar.setBounds(165,240,200,20);
        boxEspecialidadEditar.setFont(new Font("Arial", Font.BOLD, 16));
        boxEspecialidadEditar.setFocusable(false);
        boxEspecialidadEditar.setEnabled(false);
        ((JLabel)boxEspecialidadEditar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpEditar.add(boxEspecialidadEditar);

        lblConsultorio = new JLabel("CONSULTORIO: ",SwingConstants.LEFT);
        lblConsultorio.setBounds(20, 270, 130, 20);
        lblConsultorio.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblConsultorio);

        boxConsulEditar = new JComboBox();
        boxConsulEditar.setBounds(165,270,200,20);
        boxConsulEditar.setFont(new Font("Arial", Font.BOLD, 16));
        boxConsulEditar.setFocusable(false);
        boxConsulEditar.setEnabled(false);
        ((JLabel)boxConsulEditar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpEditar.add(boxConsulEditar);

        //panel Eliminar

        lblNombre = new JLabel("NOMBRE: ",SwingConstants.LEFT);
        lblNombre.setBounds(20, 120, 130, 20);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblNombre);

        txtNombreEliminar = new JTextField("",SwingConstants.LEFT);
        txtNombreEliminar.setBounds(165,120,200,20);
        txtNombreEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtNombreEliminar.setEnabled(false);
        jpEliminar.add(txtNombreEliminar);

        lblDocumento = new JLabel("# DOCUMENTO: ",SwingConstants.LEFT);
        lblDocumento.setBounds(20, 150, 130, 20);
        lblDocumento.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblDocumento);

        txtDocumentoEliminar = new JTextField("",SwingConstants.LEFT);
        txtDocumentoEliminar.setBounds(165,150,200,20);
        txtDocumentoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtDocumentoEliminar.setEnabled(false);
        jpEliminar.add(txtDocumentoEliminar);

        lblCorreo = new JLabel("CORREO: ",SwingConstants.LEFT);
        lblCorreo.setBounds(20, 180, 130, 20);
        lblCorreo.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblCorreo);

        txtCorreoEliminar = new JTextField("",SwingConstants.LEFT);
        txtCorreoEliminar.setBounds(165,180,200,20);
        txtCorreoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtCorreoEliminar.setEnabled(false);
        jpEliminar.add(txtCorreoEliminar);

        lblTelefono = new JLabel("TELEFONO: ",SwingConstants.LEFT);
        lblTelefono.setBounds(20, 210, 130, 20);
        lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblTelefono);

        txtTelefonoEliminar = new JTextField("",SwingConstants.LEFT);
        txtTelefonoEliminar.setBounds(165,210,200,20);
        txtTelefonoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtTelefonoEliminar.setEnabled(false);
        jpEliminar.add(txtTelefonoEliminar);

        lblEspecialidad = new JLabel("ESPECIALIDAD: ",SwingConstants.LEFT);
        lblEspecialidad.setBounds(20, 240, 130, 20);
        lblEspecialidad.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblEspecialidad);

        txtEspecialidadEliminar = new JTextField("",SwingConstants.LEFT);
        txtEspecialidadEliminar.setBounds(165,240,200,20);
        txtEspecialidadEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtEspecialidadEliminar.setFocusable(false);
        txtEspecialidadEliminar.setEnabled(false);
        jpEliminar.add(txtEspecialidadEliminar);

        lblConsultorio = new JLabel("CONSULTORIO: ",SwingConstants.LEFT);
        lblConsultorio.setBounds(20, 270, 130, 20);
        lblConsultorio.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblConsultorio);

        txtConsulEliminar = new JTextField("",SwingConstants.LEFT);
        txtConsulEliminar.setBounds(165,270,200,20);
        txtConsulEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtConsulEliminar.setFocusable(false);
        txtConsulEliminar.setEnabled(false);
        jpEliminar.add(txtConsulEliminar);

        //Panel Archivo

        String[] nombresColumnas = {"ID","NOMBRE","DOCUMENTO", "CORREO", "TELEFONO", "ESPECIALIDAD", "CONSULTORIO"};


    }

    //getters
    public String getTxtNombreAgregar()
    {
        return txtNombreAgregar.getText();
    }

    public String  getTxtNombreEditar()
    {
        return txtNombreEditar.getText();
    }

    public int getTxtDocumentoAgregar()
    {
        return Integer.parseInt(txtDocumentoAgregar.getText());
    }

    public int getTxtDocumentoEditar()
    {
        return  Integer.parseInt(txtDocumentoEditar.getText());
    }

    public String getTxtCorreoAgregar()
    {
        return txtCorreoAgregar.getText();
    }

    public String getTxtCorreoEditar()
    {
        return txtCorreoEditar.getText();
    }

    public int getTxtTelefonoAgregar()
    {
        return Integer.parseInt(txtTelefonoAgregar.getText());
    }

    public int getTxtTelefonoEditar()
    {
        return Integer.parseInt(txtTelefonoEditar.getText());
    }

    public Object getBoxEspecialidadAgregar()
    {
        return boxEspecialidadAgregar.getSelectedItem();
    }

    public Object getBoxEspecialidadEditar()
    {
        return boxEspecialidadEditar.getSelectedItem();
    }

    public Object getBoxConsulAgregar()
    {
        return boxConsulAgregar.getSelectedItem();
    }

    public Object getBoxConsulEditar()
    {
        return boxConsulEditar.getSelectedItem();
    }

    //setters


    public void setTxtNombreEditar()
    {

    }

    public void setTxtNombreEliminar()
    {

    }

    public void setTxtDocumentoEditar()
    {

    }

    public void setTxtDocumentoEliminar()
    {

    }

    public void setTxtCorreoEditar()
    {

    }

    public void setTxtCorreoEliminar()
    {

    }

    public void setTxtTelefonoEditar()
    {

    }

    public void setTxtTelefonoEliminar()
    {

    }

    public void setBoxEspecialidadEditar()
    {

    }

    public void setTxtEspecialidadEliminar()
    {

    }

    public void setBoxConsulEditar(JComboBox boxConsulEditar)
    {

    }

    public void setTxtConsulEliminar()
    {

    }
}
