package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaConsultorio extends Plantilla
{
    private JLabel lblNumero;
    private JTextField txtNumeroAgregar;
    private JTextField txtNumeroEditar;
    private JTextField txtNumeroEliminar;

    public VentanaConsultorio()
    {
        inicializarComponentes();
    }

    public void inicializarComponentes()
    {
        setTitle("VENTANA-CONSULTORIO");
        inicializarComponentesPredeterminados();

        lblTitulo.setText("GESTION CONSULTORIOS");

        //Panel Agregar

        lblNumero = new JLabel("NÚMERO: ", SwingConstants.LEFT);
        lblNumero.setBounds(200, 60, 100, 20);
        lblNumero.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblNumero);

        txtNumeroAgregar = new JTextField("",SwingConstants.LEFT);
        txtNumeroAgregar.setBounds(390,60,200,20);
        txtNumeroAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtNumeroAgregar,3);
        jpAgregar.add(txtNumeroAgregar);

        //Panel Editar

        lblNumero = new JLabel("NÚMERO: ", SwingConstants.LEFT);
        lblNumero.setBounds(200, 120, 120, 20);
        lblNumero.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblNumero);

        txtNumeroEditar= new JTextField("",SwingConstants.LEFT);
        txtNumeroEditar.setBounds(390,120,200,20);
        txtNumeroEditar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtNumeroEditar,3);
        txtNumeroEditar.setEnabled(false);
        jpEditar.add(txtNumeroEditar);

        //Panel Eliminar

        lblNumero = new JLabel("NÚMERO: ", SwingConstants.LEFT);
        lblNumero.setBounds(200, 120, 100, 20);
        lblNumero.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblNumero);

        txtNumeroEliminar= new JTextField("",SwingConstants.LEFT);
        txtNumeroEliminar.setBounds(390,120,200,20);
        txtNumeroEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtNumeroEliminar,3);
        txtNumeroEliminar.setEnabled(false);
        jpEliminar.add(txtNumeroEliminar);
    }

    public void activarControlesEditar()
    {
        txtNumeroEditar.setEnabled(true);
    }

    public void desactivarControlesEditar()
    {
        txtNumeroEditar.setEnabled(false);
    }

    //getters
    public String getNumeroAgregar()
    {
        return txtNumeroAgregar.getText();
    }

    public String getNumeroEditar()
    {
        return txtNumeroEditar.getText();
    }

    //setters
    public void setTxtNumeroAgregar(String txt)
    {
        txtNumeroAgregar.setText(txt);
    }
    public void setTxtNumeroEditar(String txt)
    {
        txtNumeroEditar.setText(txt);
    }

    public void setTxtNumeroEliminar(String txt)
    {
        txtNumeroEliminar.setText(txt);
    }

}

