package Vista;

import java.awt.*;
import javax.swing.*;


public class VentanaCita extends Plantilla 
{
    public JLabel lblAfiliado;
    public JLabel lblMedico;
    public JLabel lblServicio;
    public JLabel lblSitio;
    public JLabel lblFecha;
    public JLabel lblHora;
    public JTextField txtAfiliadoAgregar;
    public JTextField txtMedicoAgregar;
    public JTextField txtServicioAgregar;
    public JTextField txtSitioAgregar;
    public JTextField txtFechaAgregar;
    public JTextField txtHoraAgregar;
    public JTextField txtAfiliadoEditar;
    public JTextField txtMedicoEditar;
    public JTextField txtServicioEditar;
    public JTextField txtSitioEditar;
    public JTextField txtFechaEditar;
    public JTextField txtHoraEditar;
    public JTextField txtAfiliadoEliminar;
    public JTextField txtMedicoEliminar;
    public JTextField txtServicioEliminar;
    public JTextField txtSitioEliminar;
    public JTextField txtFechaEliminar;
    public JTextField txtHoraEliminar;
    
    
    
    
    public VentanaCita()
    {
      inicializarComponentesPredeterminados();
      inicializarNuevosComponentes();
    }
    
    public void inicializarNuevosComponentes()
    {
        
       // Componentes de la ventana Agregar

       
       lblAfiliado = new JLabel("AFILIADO: ", SwingConstants.LEFT);
       lblAfiliado.setBounds(20, 60, 435, 20);
       lblAfiliado.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblAfiliado);
       
       txtAfiliadoAgregar = new JTextField("", SwingConstants.LEFT);
       txtAfiliadoAgregar.setBounds(165, 60, 200, 20);
       txtAfiliadoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(txtAfiliadoAgregar);
       
       lblMedico = new JLabel("MÉDICO: ", SwingConstants.LEFT);
       lblMedico.setBounds(20, 90, 435, 20);
       lblMedico.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblMedico);
       
       txtMedicoAgregar = new JTextField("",SwingConstants.LEFT);
       txtMedicoAgregar.setBounds(165, 90, 200, 20);
       txtMedicoAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(txtMedicoAgregar);
       
       lblServicio = new JLabel("SERVICIO: ",SwingConstants.LEFT);
       lblServicio.setBounds(20, 120, 435, 20);
       lblServicio.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblServicio);
       
       txtServicioAgregar = new JTextField("", SwingConstants.LEFT);
       txtServicioAgregar.setBounds(165, 120, 200, 20);
       txtServicioAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(txtServicioAgregar);
       
       lblSitio = new JLabel("SITIO: ", SwingConstants.LEFT);
       lblSitio.setBounds(20, 150, 435, 20);
       lblSitio.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblSitio);
       
       txtSitioAgregar = new JTextField("", SwingConstants.LEFT);
       txtSitioAgregar.setBounds(165, 150, 200, 20);
       txtSitioAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(txtSitioAgregar);
       
       lblFecha = new JLabel("FECHA: ", SwingConstants.LEFT);
       lblFecha.setBounds(20, 180, 435, 20);
       lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblFecha);
       
       txtFechaAgregar = new JTextField("", SwingConstants.LEFT);
       txtFechaAgregar.setBounds(165, 180, 200, 20);
       txtFechaAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(txtFechaAgregar);
       
       lblHora = new JLabel("HORA: ", SwingConstants.LEFT);
       lblHora.setBounds(20, 210, 435, 20);
       lblHora.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblHora);
       
       txtHoraAgregar = new JTextField("", SwingConstants.LEFT);
       txtHoraAgregar.setBounds(165, 210, 200, 20);
       txtHoraAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(txtHoraAgregar);
       
       // Componentes de la ventana Editar
       
       lblAfiliado = new JLabel("AFILIADO: ", SwingConstants.LEFT);
       lblAfiliado.setBounds(20, 120, 435, 20);
       lblAfiliado.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblAfiliado);
       
       txtAfiliadoEditar = new JTextField("", SwingConstants.LEFT);
       txtAfiliadoEditar.setBounds(165, 120, 200, 20);
       txtAfiliadoEditar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(txtAfiliadoEditar);
       
       lblMedico = new JLabel("MÉDICO: ", SwingConstants.LEFT);
       lblMedico.setBounds(20, 150, 435, 20);
       lblMedico.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblMedico);
       
       txtMedicoEditar = new JTextField("",SwingConstants.LEFT);
       txtMedicoEditar.setBounds(165, 150, 200, 20);
       txtMedicoEditar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(txtMedicoEditar);
       
       lblServicio = new JLabel("SERVICIO: ",SwingConstants.LEFT);
       lblServicio.setBounds(20, 180, 435, 20);
       lblServicio.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblServicio);
       
       txtServicioEditar = new JTextField("", SwingConstants.LEFT);
       txtServicioEditar.setBounds(165, 180, 200, 20);
       txtServicioEditar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(txtServicioEditar);
       
       lblSitio = new JLabel("SITIO: ", SwingConstants.LEFT);
       lblSitio.setBounds(20, 210, 435, 20);
       lblSitio.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblSitio);
       
       txtSitioEditar = new JTextField("", SwingConstants.LEFT);
       txtSitioEditar.setBounds(165, 210, 200, 20);
       txtSitioEditar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(txtSitioEditar);
       
       lblFecha = new JLabel("FECHA: ", SwingConstants.LEFT);
       lblFecha.setBounds(20, 240, 435, 20);
       lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblFecha);
       
       txtFechaEditar = new JTextField("", SwingConstants.LEFT);
       txtFechaEditar.setBounds(165, 240, 200, 20);
       txtFechaEditar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(txtFechaEditar);
       
       lblHora = new JLabel("HORA: ", SwingConstants.LEFT);
       lblHora.setBounds(20, 270, 435, 20);
       lblHora.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblHora);
       
       txtHoraEditar = new JTextField("", SwingConstants.LEFT);
       txtHoraEditar.setBounds(165, 270, 200, 20);
       txtHoraEditar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(txtHoraEditar);
       
       
       
       // Componentes de la ventana Eliminar
       
       lblAfiliado = new JLabel("AFILIADO: ", SwingConstants.LEFT);
       lblAfiliado.setBounds(20, 120, 435, 20);
       lblAfiliado.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblAfiliado);
       
       txtAfiliadoEliminar = new JTextField("", SwingConstants.LEFT);
       txtAfiliadoEliminar.setBounds(165, 120, 200, 20);
       txtAfiliadoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(txtAfiliadoEliminar);
       
       lblMedico = new JLabel("MÉDICO: ", SwingConstants.LEFT);
       lblMedico.setBounds(20, 150, 435, 20);
       lblMedico.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblMedico);
       
       txtMedicoEliminar = new JTextField("",SwingConstants.LEFT);
       txtMedicoEliminar.setBounds(165, 150, 200, 20);
       txtMedicoEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(txtMedicoEliminar);
       
       lblServicio = new JLabel("SERVICIO: ",SwingConstants.LEFT);
       lblServicio.setBounds(20, 180, 435, 20);
       lblServicio.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblServicio);
       
       txtServicioEliminar = new JTextField("", SwingConstants.LEFT);
       txtServicioEliminar.setBounds(165, 180, 200, 20);
       txtServicioEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(txtServicioEliminar);
       
       lblSitio = new JLabel("SITIO: ", SwingConstants.LEFT);
       lblSitio.setBounds(20, 210, 435, 20);
       lblSitio.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblSitio);
       
       txtSitioEliminar = new JTextField("", SwingConstants.LEFT);
       txtSitioEliminar.setBounds(165, 210, 200, 20);
       txtSitioEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(txtSitioEliminar);
       
       lblFecha = new JLabel("FECHA: ", SwingConstants.LEFT);
       lblFecha.setBounds(20, 240, 435, 20);
       lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblFecha);
       
       txtFechaEliminar = new JTextField("", SwingConstants.LEFT);
       txtFechaEliminar.setBounds(165, 240, 200, 20);
       txtFechaEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(txtFechaEliminar);
       
       lblHora = new JLabel("HORA: ", SwingConstants.LEFT);
       lblHora.setBounds(20, 270, 435, 20);
       lblHora.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(lblHora);
       
       txtHoraEliminar = new JTextField("", SwingConstants.LEFT);
       txtHoraEliminar.setBounds(165, 270, 200, 20);
       txtHoraEliminar.setFont(new Font("Arial", Font.BOLD, 16));
       jpEliminar.add(txtHoraEliminar);
       
       //Componentes de la ventana Archivo
       
       String[] nombresColumnas = {"ID", "AFILIADO","MÉDICO", "SERVICIO", "SITIO", "FECHA", "HORA"};
    }

    public JTextField getTxtAfiliadoAgregar() {
        return txtAfiliadoAgregar;
    }

    public JTextField getTxtMedicoAgregar() {
        return txtMedicoAgregar;
    }

    public JTextField getTxtServicioAgregar() {
        return txtServicioAgregar;
    }

    public JTextField getTxtSitioAgregar() {
        return txtSitioAgregar;
    }

    public JTextField getTxtFechaAgregar() {
        return txtFechaAgregar;
    }

    public JTextField getTxtHoraAgregar() {
        return txtHoraAgregar;
    }

    public JTextField getTxtAfiliadoEditar() {
        return txtAfiliadoEditar;
    }

    public void setTxtAfiliadoEditar(JTextField txtAfiliadoEditar) {
        this.txtAfiliadoEditar = txtAfiliadoEditar;
    }

    public JTextField getTxtMedicoEditar() {
        return txtMedicoEditar;
    }

    public void setTxtMedicoEditar(JTextField txtMedicoEditar) {
        this.txtMedicoEditar = txtMedicoEditar;
    }

    public JTextField getTxtServicioEditar() {
        return txtServicioEditar;
    }

    public void setTxtServicioEditar(JTextField txtServicioEditar) {
        this.txtServicioEditar = txtServicioEditar;
    }

    public JTextField getTxtSitioEditar() {
        return txtSitioEditar;
    }

    public void setTxtSitioEditar(JTextField txtSitioEditar) {
        this.txtSitioEditar = txtSitioEditar;
    }

    public JTextField getTxtFechaEditar() {
        return txtFechaEditar;
    }

    public void setTxtFechaEditar(JTextField txtFechaEditar) {
        this.txtFechaEditar = txtFechaEditar;
    }

    public JTextField getTxtHoraEditar() {
        return txtHoraEditar;
    }

    public void setTxtHoraEditar(JTextField txtHoraEditar) {
        this.txtHoraEditar = txtHoraEditar;
    }

    public void setTxtAfiliadoEliminar(JTextField txtAfiliadoEliminar) {
        this.txtAfiliadoEliminar = txtAfiliadoEliminar;
    }

    public void setTxtServicioEliminar(JTextField txtServicioEliminar) {
        this.txtServicioEliminar = txtServicioEliminar;
    }

    public void setTxtSitioEliminar(JTextField txtSitioEliminar) {
        this.txtSitioEliminar = txtSitioEliminar;
    }

    public void setTxtFechaEliminar(JTextField txtFechaEliminar) {
        this.txtFechaEliminar = txtFechaEliminar;
    }

    public void setTxtHoraEliminar(JTextField txtHoraEliminar) {
        this.txtHoraEliminar = txtHoraEliminar;
    }

    
}