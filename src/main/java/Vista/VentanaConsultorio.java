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
        lblNumero.setBounds(20, 60, 100, 20);
        lblNumero.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblNumero);

        txtNumeroAgregar = new JTextField("",SwingConstants.LEFT);
        txtNumeroAgregar.setBounds(165,60,200,20);
        txtNumeroAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtNumeroAgregar,3);
        jpAgregar.add(txtNumeroAgregar);

        //Panel Editar

        lblNumero = new JLabel("NÚMERO: ", SwingConstants.LEFT);
        lblNumero.setBounds(20, 120, 120, 20);
        lblNumero.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblNumero);

        txtNumeroEditar= new JTextField("",SwingConstants.LEFT);
        txtNumeroEditar.setBounds(165,120,200,20);
        txtNumeroEditar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtNumeroEditar,3);
        txtNumeroEditar.setEnabled(false);
        jpEditar.add(txtNumeroEditar);

        //Panel Eliminar

        lblNumero = new JLabel("NÚMERO: ", SwingConstants.LEFT);
        lblNumero.setBounds(20, 120, 100, 20);
        lblNumero.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblNumero);

        txtNumeroEliminar= new JTextField("",SwingConstants.LEFT);
        txtNumeroEliminar.setBounds(165,120,200,20);
        txtNumeroEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        limitarTxt(txtNumeroEliminar,3);
        txtNumeroEliminar.setEnabled(false);
        jpEliminar.add(txtNumeroEliminar);

        //Panel Archivo

        String[] nombresColumnas = {"ID","NUMERO","ESTADO"};
    }

    public int getNumeroAgregar()
    {
        return Integer.parseInt(txtNumeroAgregar.getText());
    }

    public int getNumeroEditar()
    {
        return Integer.parseInt(txtNumeroEditar.getText());
    }

    public void setTxtNumeroEditar(int numero)
    {
        //agregar
    }

    public void setTxtNumeroEliminar(JTextField txtNumeroEliminar)
    {
       //agregar
    }
}

