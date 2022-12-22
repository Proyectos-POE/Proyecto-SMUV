package Vista;

import java.awt.*;
import java.awt.event.ItemListener;
import javax.swing.*;
import modelo.Afiliado;
import modelo.Hora;
import modelo.Horario;
import modelo.Medico;
import modelo.Servicio;


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
    public JTextField txtFechaAgregar;
    public JComboBox boxHoraAgregar;
    public JComboBox boxAfiliadoEditar;
    public JComboBox boxMedicoEditar;
    public JComboBox boxServicioEditar;
    public JTextField txtFechaEditar;
    public JComboBox boxHoraEditar;
    public JTextField txtAfiliadoEliminar;
    public JTextField txtMedicoEliminar;
    public JTextField txtServicioEliminar;
    public JTextField txtFechaEliminar;
    public JTextField txtHoraEliminar;
    public JButton btnReiniciarAgregar;
    
    
    
    
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
       
       lblFecha = new JLabel("FECHA: ", SwingConstants.LEFT);
       lblFecha.setBounds(200, 150, 130, 20);
       lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(lblFecha);
       
       txtFechaAgregar = new JTextField("", SwingConstants.LEFT);
       txtFechaAgregar.setBounds(390, 150, 200, 20);
       txtFechaAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(txtFechaAgregar);
       
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
       
       btnReiniciarAgregar = new JButton("REINICIAR");
       btnReiniciarAgregar.setBounds(337, 255, 125, 35);
       btnReiniciarAgregar.setBackground(morado);
       btnReiniciarAgregar.setForeground(Color.WHITE);
       btnReiniciarAgregar.setFocusable(false);
       btnReiniciarAgregar.setBorder(null);
       btnReiniciarAgregar.setFont(new Font("Arial", Font.BOLD, 16));
       jpAgregar.add(btnReiniciarAgregar);
       
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
       
       lblFecha = new JLabel("FECHA: ", SwingConstants.LEFT);
       lblFecha.setBounds(200, 210, 130, 20);
       lblFecha.setFont(new Font("Arial", Font.BOLD, 16));
       jpEditar.add(lblFecha);
       
       txtFechaEditar = new JTextField("", SwingConstants.LEFT);
       txtFechaEditar.setBounds(390, 210, 200, 20);
       txtFechaEditar.setFont(new Font("Arial", Font.BOLD, 16));
       txtFechaEditar.setEnabled(false);
       jpEditar.add(txtFechaEditar);
       
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
       
       lblFecha = new JLabel("FECHA: ", SwingConstants.LEFT);
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
    
    public void setEnabledFechaAgregar(boolean a)
    {
        txtFechaAgregar.setEnabled(a);
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
 
    public void setEnabledFechaEditar(boolean a)
    {
        txtFechaEditar.setEnabled(a);
    }
 
    public void setEnabledHoraEditar(boolean a)
    {
        boxHoraEditar.setEnabled(a);
    }
    
    public void activarControlesEditar()
    {
        boxAfiliadoEditar.setEnabled(true);
        boxMedicoEditar.setEnabled(true);
        boxServicioEditar.setEnabled(true);
        txtFechaEditar.setEnabled(true);
        boxHoraEditar.setEnabled(true);
    }
    
    public void desactivarControlesEditar()
    {
        boxAfiliadoEditar.setEnabled(false);
        boxMedicoEditar.setEnabled(false);
        boxServicioEditar.setEnabled(false);
        txtFechaEditar.setEnabled(false);
        boxHoraEditar.setEnabled(false);
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
        setTxtFechaAgregar("");
        setNullBoxHoraAgregar();
    }

    public void limpiarDatosEditar()
    {
        setNullBoxAfiliadoEditar();
        setNullBoxMedicoEditar();
        setNullBoxServicioEditar();
        setTxtFechaEditar("");
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
    
    public String getBoxAfiliadoAgregar()
    {
        return (String) boxAfiliadoAgregar.getSelectedItem();
    }
    
    public String getBoxAfiliadoEditar()
    {
        return (String) boxAfiliadoEditar.getSelectedItem();
    }
    
    public String getBoxMedicoAgregar()
    {
        return (String) boxMedicoAgregar.getSelectedItem();
    }
    
    public String getBoxMedicoEditar()
    {
        return (String) boxMedicoEditar.getSelectedItem();
    }
    
    public String getBoxServicioAgregar()
    {
         return (String) boxServicioAgregar.getSelectedItem();
    }
    
    public String getTxtServicioEditar()
    {
        return (String) boxServicioEditar.getSelectedItem();
    }
    
    public String getTxtFechaAgregar()
    {
        return txtFechaAgregar.getText();
    }
    
    public String getTxtFechaEditar()
    {
        return txtFechaEditar.getText();
    }
    
    public String getBoxHoraAgregar()
    {
        return (String) boxHoraAgregar.getSelectedItem();
    }
    
    public String getTxtHoraEditar()
    {
        return (String) boxHoraEditar.getSelectedItem();
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

    public void setTxtFechaAgregar(String txt) 
    {
        txtFechaAgregar.setText(txt);
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
    
    public void setTxtFechaEditar(String txt) 
    {
        txtFechaEditar.setText(txt);
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
    public void addBoxAfiliadoAgregarListener(ItemListener listenerBox)
    {
        boxAfiliadoAgregar.addItemListener(listenerBox);
    }
    
    public void addBoxServicioAgregarListener(ItemListener listenerBox)
    {
        boxServicioAgregar.addItemListener(listenerBox);
    }
    
    public void addBoxMedicoAgregarListener(ItemListener listenerBox)
    {
        boxMedicoAgregar.addItemListener(listenerBox);
    }
    
    public void addBoxHoraAgregarListener(ItemListener listenerBox)
    {
        boxHoraAgregar.addItemListener(listenerBox);
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
    
    public void vaciarBoxAfiliadosAgregar()
    {
        boxAfiliadoAgregar.removeAllItems();
    }
    
    public void vaciarBoxServiciosAgregar()
    {
        boxServicioAgregar.removeAllItems();
    }
    
    public void vaciarBoxMedicosAgregar()
    {
        boxMedicoAgregar.removeAllItems();
    }
    
    public void vaciarBoxHorasAgregar()
    {
        boxHoraAgregar.removeAllItems();
    }
    
    //PANEL EDITAR
    
    public void addBoxAfiliadoEditarListener(ItemListener listenerBox)
    {
        boxAfiliadoEditar.addItemListener(listenerBox);
    }
    
    public void addBoxServicioEditarListener(ItemListener listenerBox)
    {
        boxServicioEditar.addItemListener(listenerBox);
    }
    
    public void addBoxMedicoEditarListener(ItemListener listenerBox)
    {
        boxMedicoEditar.addItemListener(listenerBox);
    }
    
    public void addBoxHoraEditarListener(ItemListener listenerBox)
    {
        boxHoraAgregar.addItemListener(listenerBox);
    }
    
    public void rellenarBoxAfiliadosEditar(Afiliado item)
    {
        boxAfiliadoAgregar.addItem(item);
    }
    
    public void rellenarBoxServiciosEditar(Servicio item)
    {
        boxServicioAgregar.addItem(item);
    }
    
    public void rellenarBoxMedicosEditar(Medico item)
    {
        boxMedicoAgregar.addItem(item);
    }
    
    public void rellenarBoxHorasEditar(Hora item)
    {
        boxHoraAgregar.addItem(item);
    }
    
    public void vaciarBoxAfiliadosEditar()
    {
        boxAfiliadoEditar.removeAllItems();
    }
    
    public void vaciarBoxServiciosEditar()
    {
        boxServicioEditar.removeAllItems();
    }
    
    public void vaciarBoxMedicosEditar()
    {
        boxMedicoEditar.removeAllItems();
    }
    
    public void vaciarBoxHorasEditar()
    {
        boxHoraEditar.removeAllItems();
    }
}