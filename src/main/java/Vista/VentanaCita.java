package Vista;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.*;
import modelo.*;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class VentanaCita extends Plantilla
{
    public JLabel lblAfiliado;
    public JLabel lblMedico;
    public JLabel lblServicio;
    public JLabel lblConsultorio;
    public JLabel lblFecha;
    public JLabel lblHora;
    public JComboBox boxAfiliadoAgregar;
    public JComboBox boxMedicoAgregar;
    public JComboBox boxServicioAgregar;
    public JTextField txtFechaAnhoAgregar;
    public JTextField txtFechaMesAgregar;
    public JTextField txtFechaDiaAgregar;
    public JComboBox boxHoraAgregar;
    public JComboBox boxAfiliadoEditar;
    public JComboBox boxMedicoEditar;
    public JComboBox boxServicioEditar;
    public JTextField txtFechaAnhoEditar;
    public JTextField txtFechaMesEditar;
    public JTextField txtFechaDiaEditar;
    public JComboBox boxHoraEditar;
    public JTextField txtAfiliadoEliminar;
    public JTextField txtMedicoEliminar;
    public JTextField txtServicioEliminar;
    public JTextField txtFechaEliminar;
    public JTextField txtHoraEliminar;
    public JButton btnCancelarAgregar;
    public JButton btnHoraAgregar;
    public JButton btnHoraEditar;




    public VentanaCita()
    {
        inicializarNuevosComponentes();
    }

    public void inicializarNuevosComponentes()
    {
        setTitle("VENTANA-CITAS");
        inicializarComponentesPredeterminados();
        lblTitulo.setText("GESTIÓN CITAS");

        // Componentes de la ventana Agregar


        lblAfiliado = new JLabel("AFILIADO: ", SwingConstants.LEFT);
        lblAfiliado.setBounds(200, 60, 135, 20);
        lblAfiliado.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblAfiliado);

        boxAfiliadoAgregar = new JComboBox();
        boxAfiliadoAgregar.setBounds(390, 60, 200, 20);
        boxAfiliadoAgregar.setFocusable(false);
        ((JLabel)boxAfiliadoAgregar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        boxAfiliadoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(boxAfiliadoAgregar);

        lblServicio = new JLabel("SERVICIO: ",SwingConstants.LEFT);
        lblServicio.setBounds(200, 90, 130, 20);
        lblServicio.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblServicio);

        boxServicioAgregar = new JComboBox();
        boxServicioAgregar.setBounds(390, 90, 200, 20);
        boxServicioAgregar.setFocusable(false);
        boxServicioAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        ((JLabel)boxServicioAgregar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpAgregar.add(boxServicioAgregar);

        lblMedico = new JLabel("MÉDICO: ", SwingConstants.LEFT);
        lblMedico.setBounds(200, 120, 130, 20);
        lblMedico.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblMedico);

        boxMedicoAgregar = new JComboBox();
        boxMedicoAgregar.setBounds(390, 120, 200, 20);
        boxMedicoAgregar.setFocusable(false);
        ((JLabel)boxMedicoAgregar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        boxMedicoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(boxMedicoAgregar);

        lblFecha = new JLabel("FECHA[A/M/D]: ", SwingConstants.LEFT);
        lblFecha.setBounds(200, 150, 130, 20);
        lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblFecha);

        txtFechaAnhoAgregar = new JTextField("", SwingConstants.LEFT);
        txtFechaAnhoAgregar.setBounds(390, 150, 40, 20);
        txtFechaAnhoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtFechaAnhoAgregar,4);
        jpAgregar.add(txtFechaAnhoAgregar);

        txtFechaMesAgregar = new JTextField("", SwingConstants.LEFT);
        txtFechaMesAgregar.setBounds(435, 150, 40, 20);
        txtFechaMesAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtFechaMesAgregar,2);
        jpAgregar.add(txtFechaMesAgregar);

        txtFechaDiaAgregar = new JTextField("", SwingConstants.LEFT);
        txtFechaDiaAgregar.setBounds(480, 150, 40, 20);
        txtFechaDiaAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtFechaDiaAgregar,2);
        jpAgregar.add(txtFechaDiaAgregar);

        lblHora = new JLabel("HORA: ", SwingConstants.LEFT);
        lblHora.setBounds(200, 180, 130, 20);
        lblHora.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblHora);

        boxHoraAgregar = new JComboBox();
        boxHoraAgregar.setBounds(390, 180, 200, 20);
        boxHoraAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        boxHoraAgregar.setFocusable(false);
        ((JLabel)boxHoraAgregar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpAgregar.add(boxHoraAgregar);

        btnCancelarAgregar = new JButton("CANCELAR");
        btnCancelarAgregar.setBounds(337, 255, 125, 35);
        btnCancelarAgregar.setBackground(morado);
        btnCancelarAgregar.setForeground(Color.WHITE);
        btnCancelarAgregar.setFocusable(false);
        btnCancelarAgregar.setBorder(null);
        btnCancelarAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(btnCancelarAgregar);

        btnHoraAgregar = new JButton("HORA");
        btnHoraAgregar.setBounds(525, 150, 65, 20);
        btnHoraAgregar.setBackground(Color.WHITE);
        btnHoraAgregar.setForeground(Color.BLACK);
        btnHoraAgregar.setFocusable(false);
        btnHoraAgregar.setBorder(null);
        btnHoraAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(btnHoraAgregar);


        // Componentes de la ventana Editar

        lblAfiliado = new JLabel("AFILIADO: ", SwingConstants.LEFT);
        lblAfiliado.setBounds(200, 120, 130, 20);
        lblAfiliado.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblAfiliado);

        boxAfiliadoEditar = new JComboBox();
        boxAfiliadoEditar.setBounds(390, 120, 200, 20);
        boxAfiliadoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        ((JLabel)boxAfiliadoEditar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        boxAfiliadoEditar.setFocusable(false);
        boxAfiliadoEditar.setEnabled(false);
        jpEditar.add(boxAfiliadoEditar);

        lblServicio = new JLabel("SERVICIO: ",SwingConstants.LEFT);
        lblServicio.setBounds(200, 150, 130, 20);
        lblServicio.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblServicio);

        boxServicioEditar = new JComboBox();
        boxServicioEditar.setBounds(390, 150, 200, 20);
        boxServicioEditar.setFont(new Font("Arial", Font.BOLD, 16));
        boxServicioEditar.setFocusable(false);
        ((JLabel)boxServicioEditar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        boxServicioEditar.setEnabled(false);
        jpEditar.add(boxServicioEditar);

        lblMedico = new JLabel("MÉDICO: ", SwingConstants.LEFT);
        lblMedico.setBounds(200, 180, 130, 20);
        lblMedico.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblMedico);

        boxMedicoEditar = new JComboBox();
        boxMedicoEditar.setBounds(390, 180, 200, 20);
        boxMedicoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        ((JLabel)boxMedicoEditar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        boxMedicoEditar.setFocusable(false);
        boxMedicoEditar.setEnabled(false);
        jpEditar.add(boxMedicoEditar);

        lblFecha = new JLabel("FECHA[A/M/D]: ", SwingConstants.LEFT);
        lblFecha.setBounds(200, 210, 130, 20);
        lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblFecha);

        txtFechaAnhoEditar = new JTextField("", SwingConstants.LEFT);
        txtFechaAnhoEditar.setBounds(390, 210, 40, 20);
        txtFechaAnhoEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtFechaAnhoEditar.setEnabled(false);
        limitarTxt(txtFechaAnhoEditar, 4);
        jpEditar.add(txtFechaAnhoEditar);

        txtFechaMesEditar = new JTextField("", SwingConstants.LEFT);
        txtFechaMesEditar.setBounds(435, 210, 40, 20);
        txtFechaMesEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtFechaMesEditar.setEnabled(false);
        limitarTxt(txtFechaMesEditar, 2);
        jpEditar.add(txtFechaMesEditar);

        txtFechaDiaEditar = new JTextField("", SwingConstants.LEFT);
        txtFechaDiaEditar.setBounds(480, 210, 40, 20);
        txtFechaDiaEditar.setFont(new Font("Arial", Font.BOLD, 16));
        txtFechaDiaEditar.setEnabled(false);
        limitarTxt(txtFechaDiaEditar, 2);
        jpEditar.add(txtFechaDiaEditar);

        lblHora = new JLabel("HORA: ", SwingConstants.LEFT);
        lblHora.setBounds(200, 240, 130, 20);
        lblHora.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblHora);

        boxHoraEditar = new JComboBox();
        boxHoraEditar.setBounds(390, 240, 200, 20);
        boxHoraEditar.setFont(new Font("Arial", Font.BOLD, 16));
        boxHoraEditar.setEnabled(false);
        boxHoraEditar.setFocusable(false);
        ((JLabel)boxHoraEditar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jpEditar.add(boxHoraEditar);

        btnHoraEditar = new JButton("HORA");
        btnHoraEditar.setBounds(525, 210, 65, 20);
        btnHoraEditar.setBackground(Color.WHITE);
        btnHoraEditar.setForeground(Color.BLACK);
        btnHoraEditar.setFocusable(false);
        btnHoraEditar.setEnabled(false);
        btnHoraEditar.setBorder(null);
        btnHoraEditar.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(btnHoraEditar);

        // Componentes de la ventana Eliminar

        lblAfiliado = new JLabel("AFILIADO: ", SwingConstants.LEFT);
        lblAfiliado.setBounds(200, 120, 130, 20);
        lblAfiliado.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblAfiliado);

        txtAfiliadoEliminar = new JTextField("", SwingConstants.LEFT);
        txtAfiliadoEliminar.setBounds(390, 120, 200, 20);
        txtAfiliadoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtAfiliadoEliminar.setEnabled(false);
        jpEliminar.add(txtAfiliadoEliminar);

        lblServicio = new JLabel("SERVICIO: ",SwingConstants.LEFT);
        lblServicio.setBounds(200, 150, 130, 20);
        lblServicio.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblServicio);

        txtServicioEliminar = new JTextField("", SwingConstants.LEFT);
        txtServicioEliminar.setBounds(390, 150, 200, 20);
        txtServicioEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtServicioEliminar.setEnabled(false);
        jpEliminar.add(txtServicioEliminar);

        lblMedico = new JLabel("MÉDICO: ", SwingConstants.LEFT);
        lblMedico.setBounds(200, 180, 130, 20);
        lblMedico.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblMedico);

        txtMedicoEliminar = new JTextField("",SwingConstants.LEFT);
        txtMedicoEliminar.setBounds(390, 180, 200, 20);
        txtMedicoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtMedicoEliminar.setEnabled(false);
        jpEliminar.add(txtMedicoEliminar);

        lblFecha = new JLabel("FECHA[A/M/D]: ", SwingConstants.LEFT);
        lblFecha.setBounds(200, 210, 130, 20);
        lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblFecha);

        txtFechaEliminar = new JTextField("", SwingConstants.LEFT);
        txtFechaEliminar.setBounds(390, 210, 200, 20);
        txtFechaEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtFechaEliminar.setEnabled(false);
        jpEliminar.add(txtFechaEliminar);

        lblHora = new JLabel("HORA: ", SwingConstants.LEFT);
        lblHora.setBounds(200, 240, 130, 20);
        lblHora.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblHora);

        txtHoraEliminar = new JTextField("", SwingConstants.LEFT);
        txtHoraEliminar.setBounds(390, 240, 200, 20);
        txtHoraEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        txtHoraEliminar.setEnabled(false);
        jpEliminar.add(txtHoraEliminar);

        btnAgregar.setEnabled(false);
    }

    //ACTIVAR Y DESACTIVAR PANEL AGREGAR
    public void setEnabledAfiliadoAgregar(boolean a)
    {
        boxAfiliadoAgregar.setEnabled(a);
    }

    public void setEnabledServicioAgregar(boolean a)
    {
        boxServicioAgregar.setEnabled(a);
    }

    public void setEnabledMedicoAgregar(boolean a)
    {
        boxMedicoAgregar.setEnabled(a);
    }

    public void setEnabledFechaAnhoAgregar(boolean a)
    {
        txtFechaAnhoAgregar.setEnabled(a);
    }

    public void setEnabledFechaMesAgregar(boolean a)
    {
        txtFechaMesAgregar.setEnabled(a);
    }

    public void setEnabledFechaDiaAgregar(boolean a)
    {
        txtFechaDiaAgregar.setEnabled(a);
    }

    public void setEnabledHoraAgregar(boolean a)
    {
        boxHoraAgregar.setEnabled(a);
    }

    //ACTIVAR Y DESACTIVAR PANEL EDITAR
    public void setEnabledAfiliadoEditar(boolean a)
    {
        boxAfiliadoEditar.setEnabled(a);
    }

    public void setEnabledServicioEditar(boolean a)
    {
        boxServicioEditar.setEnabled(a);
    }

    public void setEnabledMedicoEditar(boolean a)
    {
        boxMedicoEditar.setEnabled(a);
    }

    public void setEnabledFechaAnhoEditar(boolean a)
    {
        txtFechaAnhoEditar.setEnabled(a);
    }

    public void setEnabledFechaMesEditar(boolean a)
    {
        txtFechaMesEditar.setEnabled(a);
    }

    public void setEnabledFechaDiaEditar(boolean a)
    {
        txtFechaDiaEditar.setEnabled(a);
    }

    public void setEnabledHoraEditar(boolean a)
    {
        boxHoraEditar.setEnabled(a);
    }

    public void desactivarControlesAgregar()
    {
        boxAfiliadoAgregar.setEnabled(false);
        boxServicioAgregar.setEnabled(false);
        boxMedicoAgregar.setEnabled(false);
        txtFechaAnhoAgregar.setEnabled(false);
        txtFechaMesAgregar.setEnabled(false);
        txtFechaDiaAgregar.setEnabled(false);
    }

    public void activarControlesEditar()
    {
        boxMedicoEditar.setEnabled(true);
        boxServicioEditar.setEnabled(true);
        txtFechaAnhoEditar.setEnabled(true);
        txtFechaMesEditar.setEnabled(true);
        txtFechaDiaEditar.setEnabled(true);
        btnCancelarEditar.setEnabled(true);
        btnHoraEditar.setEnabled(true);
    }

    public void desactivarControlesEditar()
    {
        boxAfiliadoEditar.setEnabled(false);
        boxMedicoEditar.setEnabled(false);
        boxServicioEditar.setEnabled(false);
        txtFechaAnhoEditar.setEnabled(false);
        txtFechaMesEditar.setEnabled(false);
        txtFechaDiaEditar.setEnabled(false);
        btnCancelarEditar.setEnabled(false);
        btnHoraEditar.setEnabled(false);
    }

    public void activarControlesEliminar()
    {
        txtAfiliadoEliminar.setEnabled(true);
        txtMedicoEliminar.setEnabled(true);
        txtServicioEliminar.setEnabled(true);
        txtFechaEliminar.setEnabled(true);
        txtHoraEliminar.setEnabled(true);
    }

    public void desactivarControlesEliminar()
    {
        txtAfiliadoEliminar.setEditable(false);
        txtMedicoEliminar.setEditable(false);
        txtServicioEliminar.setEditable(false);
        txtFechaEliminar.setEditable(false);
        txtHoraEliminar.setEditable(false);
    }

    public void limpiarDatosAgregar()
    {
        setNullBoxAfiliadoAgregar();
        setNullBoxMedicoAgregar();
        setNullBoxServicioAgregar();
        setTxtFechaAnhoAgregar("");
        setTxtFechaMesAgregar("");
        setTxtFechaDiaAgregar("");
        setNullBoxHoraAgregar();
    }

    public void limpiarDatosEditar()
    {
        setNullBoxAfiliadoEditar();
        setNullBoxMedicoEditar();
        setNullBoxServicioEditar();
        setTxtFechaAnhoEditar("");
        setTxtFechaMesEditar("");
        setTxtFechaDiaEditar("");
        setNullBoxHoraEditar();
    }

    public void limpiarDatosEliminar()
    {
        setTxtAfiliadoEliminar("");
        setTxtMedicoEliminar("");
        setTxtServicioEliminar("");
        setTxtFechaEliminar("");
        setTxtHoraEliminar("");
    }

    //Getters

    public Afiliado getBoxAfiliadoAgregar()
    {
        return (Afiliado) boxAfiliadoAgregar.getSelectedItem();
    }

    public Afiliado getBoxAfiliadoEditar()
    {
        return (Afiliado) boxAfiliadoEditar.getSelectedItem();
    }

    public Medico getBoxMedicoAgregar()
    {
        return (Medico) boxMedicoAgregar.getSelectedItem();
    }

    public Medico getBoxMedicoEditar()
    {
        return (Medico) boxMedicoEditar.getSelectedItem();
    }

    public Servicio getBoxServicioAgregar()
    {
        return (Servicio) boxServicioAgregar.getSelectedItem();
    }

    public Servicio getBoxServicioEditar()
    {
        return (Servicio) boxServicioEditar.getSelectedItem();
    }

    public String getTxtFechaAnhoAgregar()
    {
        return txtFechaAnhoAgregar.getText();
    }
    public String getTxtFechaMesAgregar()
    {
        return txtFechaMesAgregar.getText();
    }

    public String getTxtFechaDiaAgregar()
    {
        return txtFechaDiaAgregar.getText();
    }

    public String getTxtFechaAnhoEditar()
    {
        return txtFechaAnhoEditar.getText();
    }

    public String getTxtFechaMesEditar()
    {
        return txtFechaMesEditar.getText();
    }

    public String getTxtFechaDiaEditar()
    {
        return txtFechaDiaEditar.getText();
    }

    public Hora getBoxHoraAgregar()
    {
        return (Hora) boxHoraAgregar.getSelectedItem();
    }

    public Hora getBoxHoraEditar()
    {
        return (Hora) boxHoraEditar.getSelectedItem();
    }

    //Setters

    public void setBoxAfiliadoAgregar(Afiliado afiliado)
    {
        boxAfiliadoAgregar.setSelectedItem(afiliado);
    }

    public void setNullBoxAfiliadoAgregar()
    {
        boxAfiliadoAgregar.setSelectedItem(null);
    }

    public void setBoxMedicoAgregar(Medico medico)
    {
        boxMedicoAgregar.setSelectedItem(medico);
    }

    public void setNullBoxMedicoAgregar()
    {
        boxMedicoAgregar.setSelectedItem(null);
    }

    public void setBoxServicioAgregar(Servicio servicio)
    {
        boxServicioAgregar.setSelectedItem(servicio);
    }

    public void setNullBoxServicioAgregar()
    {
        boxServicioAgregar.setSelectedItem(null);
    }

    public void setTxtFechaAnhoAgregar(String txt)
    {
        txtFechaAnhoAgregar.setText(txt);
    }

    public void setTxtFechaMesAgregar(String txt)
    {
        txtFechaMesAgregar.setText(txt);
    }

    public void setTxtFechaDiaAgregar(String txt)
    {
        txtFechaDiaAgregar.setText(txt);
    }

    public void setBoxHoraAgregar(Hora hora)
    {
        boxHoraAgregar.setSelectedItem(hora);
    }

    public void setBoxNullHoraAgregar()
    {
        boxHoraAgregar.setSelectedItem(null);
    }

    public void setNullBoxHoraAgregar()
    {
        boxHoraAgregar.setSelectedItem(null);
    }

    public void setBoxAfiliadoEditar(Afiliado afiliado)
    {
        boxAfiliadoEditar.setSelectedItem(afiliado);
    }

    public void setNullBoxAfiliadoEditar()
    {
        boxAfiliadoEditar.setSelectedItem(null);
    }

    public void setBoxMedicoEditar(Medico medico)
    {
        boxMedicoEditar.setSelectedItem(medico);
    }

    public void setNullBoxMedicoEditar()
    {
        boxMedicoEditar.setSelectedItem(null);
    }

    public void setBoxServicioEditar(Servicio servicio)
    {
        boxServicioEditar.setSelectedItem(servicio);
    }

    public void setNullBoxServicioEditar()
    {
        boxServicioEditar.setSelectedItem(null);
    }

    public void setTxtFechaAnhoEditar(String anho)
    {
        txtFechaAnhoEditar.setText(anho);
    }

    public void setTxtFechaMesEditar(String mes)
    {
        txtFechaMesEditar.setText(mes);
    }

    public void setTxtFechaDiaEditar(String dia)
    {
        txtFechaDiaEditar.setText(dia);
    }

    public void setBoxHoraEditar(Hora hora)
    {
        boxHoraEditar.setSelectedItem(hora);
    }

    public void setNullBoxHoraEditar()
    {
        boxHoraEditar.setSelectedItem(null);
    }

    public void setTxtAfiliadoEliminar(String txt)
    {
        txtAfiliadoEliminar.setText(txt);
    }

    public void setTxtMedicoEliminar(String txt)
    {
        txtMedicoEliminar.setText(txt);
    }

    public void setTxtServicioEliminar(String txt)
    {
        txtServicioEliminar.setText(txt);
    }

    public void setTxtFechaEliminar(String txt)
    {
        txtFechaEliminar.setText(txt);
    }

    public void setTxtHoraEliminar(String txt)
    {
        txtHoraEliminar.setText(txt);
    }

    //PANEL AGREGAR

    public void addBoxServicioAgregarListener(ItemListener listenerBox)
    {
        boxServicioAgregar.addItemListener(listenerBox);
    }

    public void addBtnCancelarAgregarListener(ActionListener listenControles)
    {
        btnCancelarAgregar.addActionListener(listenControles);
    }

    public void addBtnHoraAgregarListener(ActionListener listenControles)
    {
        btnHoraAgregar.addActionListener(listenControles);
    }

    public void rellenarBoxAfiliadosAgregar(Afiliado item)
    {
        boxAfiliadoAgregar.addItem(item);
    }

    public void rellenarBoxServiciosAgregar(Servicio item)
    {
        boxServicioAgregar.addItem(item);
    }

    public void rellenarBoxMedicosAgregar(Medico item)
    {
        boxMedicoAgregar.addItem(item);
    }

    public void rellenarBoxHorasAgregar(Hora item)
    {
        boxHoraAgregar.addItem(item);
    }

    public void vaciarBoxesAgregar()
    {
        boxAfiliadoAgregar.removeAllItems();
        boxServicioAgregar.removeAllItems();
        boxMedicoAgregar.removeAllItems();
        boxHoraAgregar.removeAllItems();
    }

    public void vaciarBoxAfiliadoAgregar()
    {
        boxAfiliadoAgregar.removeAllItems();
    }

    public void vaciarBoxServicioAgregar()
    {
        boxServicioAgregar.removeAllItems();
    }

    public void vaciarBoxMedicoAgregar()
    {
        boxMedicoAgregar.removeAllItems();
    }

    public void vaciarBoxHoraAgregar()
    {
        boxHoraAgregar.removeAllItems();
    }

    //PANEL EDITAR

    public void addBoxServicioEditarListener(ItemListener listenerBox)
    {
        boxServicioEditar.addItemListener(listenerBox);
    }

    public void addBtnHoraEditarListener(ActionListener listenControles)
    {
        btnHoraEditar.addActionListener(listenControles);
    }

    public void rellenarBoxAfiliadosEditar(Afiliado item)
    {
        boxAfiliadoEditar.addItem(item);
    }

    public void rellenarBoxServiciosEditar(Servicio item)
    {
        boxServicioEditar.addItem(item);
    }

    public void rellenarBoxMedicosEditar(Medico item)
    {
        boxMedicoEditar.addItem(item);
    }

    public void rellenarBoxHorasEditar(Hora item)
    {
        boxHoraEditar.addItem(item);
    }

    public void vaciarBoxesEditar()
    {
        boxAfiliadoEditar.removeAllItems();
        boxServicioEditar.removeAllItems();
        boxMedicoEditar.removeAllItems();
        boxHoraEditar.removeAllItems();
    }

    public void vaciarBoxAfiliadoEditar()
    {
        boxAfiliadoEditar.removeAllItems();
    }

    public void vaciarBoxServicioEditar()
    {
        boxServicioEditar.removeAllItems();
    }

    public void vaciarBoxMedicoEditar()
    {
        boxMedicoEditar.removeAllItems();
    }

    public void vaciarBoxHoraEditar()
    {
        boxHoraEditar.removeAllItems();
    }

    public void manejarBtnAgregar(boolean auxAsigando)
    {
        btnAgregar.setEnabled(auxAsigando);
    }
}