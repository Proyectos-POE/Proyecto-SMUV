package Vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import modelo.Consultorio;
import modelo.Documento;
import modelo.Servicio;

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
    private JComboBox <Servicio> boxEspecialidadAgregar;
    private JComboBox <Servicio> boxEspecialidadEditar;
    private JTextField txtEspecialidadEliminar;
    private JLabel lblConsultorio;
    private JComboBox <Consultorio> boxConsulAgregar;
    private JComboBox <Consultorio> boxConsulEditar;
    private JTextField txtConsulEliminar;
    private JComboBox boxTipoDocumentoAgregar;
    private JComboBox boxTipoDocumentoEditar;
    private JTextField txtTipoDocumentoEliminar;
    private String[] tipoDocumento;


    public VentanaMedico()
    {
        inicializarComponentes();
    }

    public void inicializarComponentes()
    {
        setTitle("VENTANA-MEDICO");
        inicializarComponentesPredeterminados();
        lblTitulo.setText("GESTIÓN MEDICOS");

        String tipoDocumento[] = {"C.C","C.E"};


        //Panel Agregar

        lblNombre = new JLabel("NOMBRE: ",SwingConstants.LEFT);
        lblNombre.setBounds(200, 60, 130, 20);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblNombre);

        txtNombreAgregar = new JTextField("",SwingConstants.LEFT);
        txtNombreAgregar.setBounds(390,60,200,20);
        txtNombreAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(txtNombreAgregar);

        lblDocumento = new JLabel("# DOCUMENTO: ",SwingConstants.LEFT);
        lblDocumento.setBounds(200, 90, 130, 20);
        lblDocumento.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblDocumento);

        txtDocumentoAgregar = new JTextField("",SwingConstants.LEFT);
        txtDocumentoAgregar.setBounds(390,90,130,20);
        txtDocumentoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtDocumentoAgregar,10);
        jpAgregar.add(txtDocumentoAgregar);

        boxTipoDocumentoAgregar = new JComboBox();
        rellenarBoxTipoDocumento(boxTipoDocumentoAgregar,tipoDocumento);
        boxTipoDocumentoAgregar.setBounds(525,90,65,20);
        boxTipoDocumentoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        boxTipoDocumentoAgregar.setFocusable(false);
        ((JLabel)boxTipoDocumentoAgregar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpAgregar.add(boxTipoDocumentoAgregar);

        lblCorreo = new JLabel("CORREO: ",SwingConstants.LEFT);
        lblCorreo.setBounds(200, 120, 130, 20);
        lblCorreo.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblCorreo);

        txtCorreoAgregar = new JTextField("",SwingConstants.LEFT);
        txtCorreoAgregar.setBounds(390,120,200,20);
        txtCorreoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(txtCorreoAgregar);

        lblTelefono = new JLabel("TELEFONO: ",SwingConstants.LEFT);
        lblTelefono.setBounds(200, 150, 130, 20);
        lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblTelefono);

        txtTelefonoAgregar = new JTextField("",SwingConstants.LEFT);
        txtTelefonoAgregar.setBounds(390,150,200,20);
        txtTelefonoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtTelefonoAgregar,10);
        jpAgregar.add(txtTelefonoAgregar);

        lblEspecialidad = new JLabel("ESPECIALIDAD: ",SwingConstants.LEFT);
        lblEspecialidad.setBounds(200, 180, 130, 20);
        lblEspecialidad.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblEspecialidad);


        boxEspecialidadAgregar = new JComboBox();
        boxEspecialidadAgregar.setBounds(390,180,200,20);
        boxEspecialidadAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        boxEspecialidadAgregar.setFocusable(false);
        ((JLabel)boxEspecialidadAgregar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpAgregar.add(boxEspecialidadAgregar);

        lblConsultorio = new JLabel("CONSULTORIO: ",SwingConstants.LEFT);
        lblConsultorio.setBounds(200, 210, 130, 20);
        lblConsultorio.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblConsultorio);

        boxConsulAgregar = new JComboBox();
        boxConsulAgregar.setBounds(390,210,200,20);
        boxConsulAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        boxConsulAgregar.setFocusable(false);
        ((JLabel)boxConsulAgregar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpAgregar.add(boxConsulAgregar);

        //Panel editar

        lblNombre = new JLabel("NOMBRE: ",SwingConstants.LEFT);
        lblNombre.setBounds(200, 120, 130, 20);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblNombre);

        txtNombreEditar = new JTextField("",SwingConstants.LEFT);
        txtNombreEditar.setBounds(390,120,200,20);
        txtNombreEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtNombreEditar.setEnabled(false);
        jpEditar.add(txtNombreEditar);

        lblDocumento = new JLabel("# DOCUMENTO: ",SwingConstants.LEFT);
        lblDocumento.setBounds(200, 150, 130, 20);
        lblDocumento.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblDocumento);

        txtDocumentoEditar = new JTextField("",SwingConstants.LEFT);
        txtDocumentoEditar.setBounds(390,150,130,20);
        txtDocumentoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtDocumentoEditar,10);
        txtDocumentoEditar.setEnabled(false);
        jpEditar.add(txtDocumentoEditar);

        boxTipoDocumentoEditar = new JComboBox();
        rellenarBoxTipoDocumento(boxTipoDocumentoEditar,tipoDocumento);
        boxTipoDocumentoEditar.setBounds(525,150,65,20);
        boxTipoDocumentoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        boxTipoDocumentoEditar.setFocusable(false);
        boxTipoDocumentoEditar.setEnabled(false);
        ((JLabel)boxTipoDocumentoEditar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpEditar.add(boxTipoDocumentoEditar);

        lblCorreo = new JLabel("CORREO: ",SwingConstants.LEFT);
        lblCorreo.setBounds(200, 180, 130, 20);
        lblCorreo.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblCorreo);

        txtCorreoEditar = new JTextField("",SwingConstants.LEFT);
        txtCorreoEditar.setBounds(390,180,200,20);
        txtCorreoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtCorreoEditar.setEnabled(false);
        jpEditar.add(txtCorreoEditar);

        lblTelefono = new JLabel("TELEFONO: ",SwingConstants.LEFT);
        lblTelefono.setBounds(200, 210, 130, 20);
        lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblTelefono);

        txtTelefonoEditar = new JTextField("",SwingConstants.LEFT);
        txtTelefonoEditar.setBounds(390,210,200,20);
        txtTelefonoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtTelefonoEditar.setEnabled(false);
        limitarTxt(txtTelefonoEditar,10);
        jpEditar.add(txtTelefonoEditar);

        lblEspecialidad = new JLabel("ESPECIALIDAD: ",SwingConstants.LEFT);
        lblEspecialidad.setBounds(200, 240, 130, 20);
        lblEspecialidad.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblEspecialidad);

        boxEspecialidadEditar = new JComboBox();
        boxEspecialidadEditar.setBounds(390,240,200,20);
        boxEspecialidadEditar.setFont(new Font("Arial", Font.BOLD, 16));
        boxEspecialidadEditar.setFocusable(false);
        boxEspecialidadEditar.setEnabled(false);
        ((JLabel)boxEspecialidadEditar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpEditar.add(boxEspecialidadEditar);

        lblConsultorio = new JLabel("CONSULTORIO: ",SwingConstants.LEFT);
        lblConsultorio.setBounds(200, 270, 130, 20);
        lblConsultorio.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblConsultorio);

        boxConsulEditar = new JComboBox();
        boxConsulEditar.setBounds(390,270,200,20);
        boxConsulEditar.setFont(new Font("Arial", Font.BOLD, 16));
        boxConsulEditar.setFocusable(false);
        boxConsulEditar.setEnabled(false);
        ((JLabel)boxConsulEditar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpEditar.add(boxConsulEditar);

        //panel Eliminar

        lblNombre = new JLabel("NOMBRE: ",SwingConstants.LEFT);
        lblNombre.setBounds(200, 120, 130, 20);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblNombre);

        txtNombreEliminar = new JTextField("",SwingConstants.LEFT);
        txtNombreEliminar.setBounds(390,120,200,20);
        txtNombreEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtNombreEliminar.setEnabled(false);
        jpEliminar.add(txtNombreEliminar);

        lblDocumento = new JLabel("# DOCUMENTO: ",SwingConstants.LEFT);
        lblDocumento.setBounds(200, 150, 130, 20);
        lblDocumento.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblDocumento);

        txtDocumentoEliminar = new JTextField("",SwingConstants.LEFT);
        txtDocumentoEliminar.setBounds(390,150,130,20);
        txtDocumentoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtDocumentoEliminar.setEnabled(false);
        jpEliminar.add(txtDocumentoEliminar);

        txtTipoDocumentoEliminar = new JTextField("",SwingConstants.LEFT);
        txtTipoDocumentoEliminar.setBounds(525,150,65,20);
        txtTipoDocumentoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtTipoDocumentoEliminar.setEnabled(false);
        jpEliminar.add(txtTipoDocumentoEliminar);


        lblCorreo = new JLabel("CORREO: ",SwingConstants.LEFT);
        lblCorreo.setBounds(200, 180, 130, 20);
        lblCorreo.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblCorreo);

        txtCorreoEliminar = new JTextField("",SwingConstants.LEFT);
        txtCorreoEliminar.setBounds(390,180,200,20);
        txtCorreoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtCorreoEliminar.setEnabled(false);
        jpEliminar.add(txtCorreoEliminar);

        lblTelefono = new JLabel("TELEFONO: ",SwingConstants.LEFT);
        lblTelefono.setBounds(200, 210, 130, 20);
        lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblTelefono);

        txtTelefonoEliminar = new JTextField("",SwingConstants.LEFT);
        txtTelefonoEliminar.setBounds(390,210,200,20);
        txtTelefonoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtTelefonoEliminar.setEnabled(false);
        jpEliminar.add(txtTelefonoEliminar);

        lblEspecialidad = new JLabel("ESPECIALIDAD: ",SwingConstants.LEFT);
        lblEspecialidad.setBounds(200, 240, 130, 20);
        lblEspecialidad.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblEspecialidad);

        txtEspecialidadEliminar = new JTextField("",SwingConstants.LEFT);
        txtEspecialidadEliminar.setBounds(390,240,200,20);
        txtEspecialidadEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtEspecialidadEliminar.setFocusable(false);
        txtEspecialidadEliminar.setEnabled(false);
        jpEliminar.add(txtEspecialidadEliminar);

        lblConsultorio = new JLabel("CONSULTORIO: ",SwingConstants.LEFT);
        lblConsultorio.setBounds(200, 270, 130, 20);
        lblConsultorio.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblConsultorio);

        txtConsulEliminar = new JTextField("",SwingConstants.LEFT);
        txtConsulEliminar.setBounds(390,270,200,20);
        txtConsulEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtConsulEliminar.setFocusable(false);
        txtConsulEliminar.setEnabled(false);
        jpEliminar.add(txtConsulEliminar);

    }

    public void activarControlesEditar()
    {
        txtNombreEditar.setEnabled(true);
        txtDocumentoEditar.setEnabled(true);
        txtCorreoEditar.setEnabled(true);
        txtTelefonoEditar.setEnabled(true);
        boxTipoDocumentoEditar.setEnabled(true);
        boxEspecialidadEditar.setEnabled(true);
        boxConsulEditar.setEnabled(true);
    }

    public void desactivarControlesEditar()
    {
        txtNombreEditar.setEnabled(false);
        txtDocumentoEditar.setEnabled(false);
        txtCorreoEditar.setEnabled(false);
        txtTelefonoEditar.setEnabled(false);
        boxTipoDocumentoEditar.setEnabled(false);
        boxEspecialidadEditar.setEnabled(false);
        boxConsulEditar.setEnabled(false);
    }

    public void activarControlesEliminar()
    {
        txtNombreEliminar.setEnabled(true);
        txtDocumentoEliminar.setEnabled(true);
        txtCorreoEliminar.setEnabled(true);
        txtTelefonoEliminar.setEnabled(true);
        txtEspecialidadEliminar.setEnabled(true);
        txtConsulEliminar.setEnabled(true);
    }

    public void desactivarControlesEliminar()
    {
        txtNombreEliminar.setEnabled(false);
        txtDocumentoEliminar.setEnabled(false);
        txtCorreoEliminar.setEnabled(false);
        txtTelefonoEliminar.setEnabled(false);
        txtEspecialidadEliminar.setEnabled(false);
        txtConsulEliminar.setEnabled(false);
    }

    public void rellenarBoxConsultorio(Consultorio item)
    {
        boxConsulAgregar.addItem(item);
        boxConsulEditar.addItem(item);
    }
    public void rellenarBoxConsultorioEditar(Consultorio item)
    {
        boxConsulEditar.addItem(item);
    }
    public void vaciarBoxConsultorio()
    {
        boxConsulAgregar.removeAllItems();
        boxConsulEditar.removeAllItems();
    }

    public void vaciarBoxConsultorioEditar()
    {
        boxConsulEditar.removeAllItems();
    }


    public void rellenarBoxServicio(Servicio item)
    {
        boxEspecialidadAgregar.addItem(item);
        boxEspecialidadEditar.addItem(item);
    }

    public void vaciarBoxServicio()
    {
        boxEspecialidadAgregar.removeAllItems();
        boxEspecialidadEditar.removeAllItems();
    }

    public void limpiarDatosAgregar()
    {
        setTxtNombreAgregar("");
        setTxtNumDocumentoAgregar("");
        setNullBoxTipoDocumentoAgregar();
        setTxtCorreoAgregar("");
        setTxtTelefonoAgregar("");
        setNullBoxEspecialidadAgregar();
        setNullBoxConsultorioAgregar();
    }

    public void limpiarDatosEditar()
    {
        setIdEditar("");
        setTxtNombreEditar("");
        setTxtNumDocumentoEditar("");
        setNullBoxTipoDocumentoEditar();
        setTxtCorreoEditar("");
        setTxtTelefonoEditar("");
        setNullBoxEspecialidadEditar();
        setNullBoxConsultorioEditar();
    }

    public void limpiarDatosEliminar()
    {
        setIdEliminar("");
        setTxtNombreEliminar("");
        setTxtNumDocumentoEliminar("");
        setTxtTipoDocumentoEliminar("");
        setTxtCorreoEliminar("");
        setTxtTelefonoEliminar("");
        setTxtEspecialidadEliminar("");
        setTxtConsultorioEliminar("");
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

    public String getTxtDocumentoAgregar()
    {
        return txtDocumentoAgregar.getText();
    }

    public String getTxtDocumentoEditar()
    {
        return  txtDocumentoEditar.getText();
    }

    public String getBoxTipoDocumentoAgregar()
    {
        return (String) boxTipoDocumentoAgregar.getSelectedItem();
    }

    public String getBoxTipoDocumentoEditar()
    {
        return  (String) boxTipoDocumentoEditar.getSelectedItem();
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

    public Servicio getBoxEspecialidadAgregar()
    {
        return (Servicio) boxEspecialidadAgregar.getSelectedItem();
    }

    public Servicio getBoxEspecialidadEditar()
    {
        return (Servicio) boxEspecialidadEditar.getSelectedItem();
    }

    public Consultorio getBoxConsulAgregar()
    {
        return (Consultorio) boxConsulAgregar.getSelectedItem();
    }

    public Consultorio getBoxConsulEditar()
    {
        return (Consultorio) boxConsulEditar.getSelectedItem();
    }

    //setters

    public void setTxtNombreAgregar(String texto)
    {
        txtNombreAgregar.setText(texto);
    }

    public void setTxtNombreEditar(String texto)
    {
        txtNombreEditar.setText(texto);
    }

    public void setTxtNombreEliminar(String texto)
    {
        txtNombreEliminar.setText(texto);
    }

    public void setTxtNumDocumentoAgregar(String texto)
    {
        txtDocumentoAgregar.setText(texto);
    }

    public void setTxtNumDocumentoEditar(String texto)
    {
        txtDocumentoEditar.setText(texto);
    }

    public void setTxtNumDocumentoEliminar(String texto)
    {
        txtDocumentoEliminar.setText(texto);
    }

    public void setNullBoxTipoDocumentoAgregar()
    {
        boxTipoDocumentoAgregar.setSelectedItem(null);
    }

    public void setNullBoxTipoDocumentoEditar()
    {
        boxTipoDocumentoEditar.setSelectedItem(null);
    }

    public void setBoxTipoDocumentoEditar(Documento documento)
    {
        boxTipoDocumentoEditar.setSelectedItem(documento.getTipoDocumento());
    }

    public void setTxtTipoDocumentoEliminar(String texto)
    {
        txtTipoDocumentoEliminar.setText(texto);
    }

    public void setTxtCorreoAgregar(String texto)
    {
        txtCorreoAgregar.setText(texto);
    }

    public void setTxtCorreoEditar(String texto)
    {
        txtCorreoEditar.setText(texto);
    }

    public void setTxtCorreoEliminar(String texto)
    {
        txtCorreoEliminar.setText(texto);
    }

    public void setTxtTelefonoAgregar(String texto)
    {
        txtTelefonoAgregar.setText(texto);
    }

    public void setTxtTelefonoEditar(String texto)
    {
        txtTelefonoEditar.setText(texto);
    }

    public void setTxtTelefonoEliminar(String texto)
    {
        txtTelefonoEliminar.setText(texto);
    }

    public void setNullBoxEspecialidadAgregar()
    {
        boxEspecialidadAgregar.setSelectedItem(null);
    }

    public void setNullBoxEspecialidadEditar()
    {
        boxEspecialidadEditar.setSelectedItem(null);
    }

    public void setBoxEspecialidadEditar(Servicio servicio)
    {
        boxEspecialidadEditar.setSelectedItem(servicio);
    }

    public void setTxtEspecialidadEliminar(String texto)
    {
        txtEspecialidadEliminar.setText(texto);
    }

    public void setNullBoxConsultorioAgregar()
    {
       boxConsulAgregar.setSelectedItem(null);
    }

    public void setNullBoxConsultorioEditar()
    {
        boxConsulEditar.setSelectedItem(null);
    }

    public void setBoxConsultorioEditar(Consultorio consultorio)
    {
        boxConsulEditar.setSelectedItem(consultorio);
    }

    public void setTxtConsultorioEliminar(String texto)
    {
       txtConsulEliminar.setText(texto);
    }
}