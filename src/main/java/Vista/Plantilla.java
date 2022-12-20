package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Plantilla extends  JFrame {
    protected JLabel lblTitulo;
    protected JTabbedPane jtab;
    protected JPanel jpAgregar;
    protected JPanel jpEditar;
    protected JPanel jpEliminar;
    protected JPanel jpArchivo;
    protected JLabel lblInstrucciones;
    protected JLabel lblId;
    protected JTextField txtIdEditar;
    protected JButton btnAgregar;
    protected JButton btnEditar;
    protected  JButton btnCancelarEditar;
    protected JTextField txtIdEliminar;
    protected JButton btnBuscarEditar;
    protected JButton btnBuscarEliminar;
    protected JButton btnEliminar;
    protected JButton btnCancelarEliminar;
    protected JScrollPane jsTabla;
    protected JTable tabla;
    protected JButton btnActualizar;
    protected JButton btnAtras;
    protected Color azul;
    protected Color gris;
    protected Color verde;
    protected Color amarillo;
    protected Color rojo;
    protected Color morado;
    //protected String tipoDocumento[];
    protected Object datosMatriz[][];

    public Plantilla()
    {

    }

    public void inicializarComponentesPredeterminados()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        gris = new Color(208, 207, 207, 255);
        azul = new Color(7, 185, 234, 255);
        verde = new Color(77, 153, 0);
        amarillo = new Color(234, 186, 3);
        rojo = new Color(178, 2, 2);
        morado = new Color(108,70,117);

        lblTitulo = new JLabel("", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 15, 1000, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));

        jtab = new JTabbedPane();
        jtab.setBounds(95, 70, 800, 380);

        //Panel para agregar objetos.

        jpAgregar = new JPanel();
        jpAgregar.setLayout(null);
        jpAgregar.setBackground(gris);

        lblInstrucciones = new JLabel("RELLENE LOS CAMPOS: ", SwingConstants.CENTER);
        lblInstrucciones.setBounds(0, 20, 800, 25);
        lblInstrucciones.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(lblInstrucciones);

        btnAgregar = new JButton("AGREGAR");
        btnAgregar.setBounds(337, 300, 125, 35);
        btnAgregar.setBackground(verde);
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFocusable(false);
        btnAgregar.setBorder(null);
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        jpAgregar.add(btnAgregar);

        //Panel para editar objetos.

        jpEditar = new JPanel();
        jpEditar.setLayout(null);
        jpEditar.setBackground(gris);

        lblInstrucciones = new JLabel("ESCRIBA EL ID EN CUESTION:", SwingConstants.CENTER);
        lblInstrucciones.setBounds(0, 20, 800, 25);
        lblInstrucciones.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblInstrucciones);

        lblId = new JLabel("ID:", SwingConstants.LEFT);
        lblId.setBounds(200, 60, 100, 20);
        lblId.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(lblId);

        txtIdEditar = new JTextField("",SwingConstants.LEFT);
        txtIdEditar.setBounds(390,60,200,20);
        txtIdEditar.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(txtIdEditar);

        btnBuscarEditar = new JButton("BUSCAR");
        btnBuscarEditar.setBounds(365,90,80,20);
        btnBuscarEditar.setFont(new Font("Arial", Font.BOLD, 12));
        btnBuscarEditar.setBackground(Color.white);
        btnBuscarEditar.setFocusable(false);
        btnBuscarEditar.setBorder(null);
        jpEditar.add(btnBuscarEditar);

        btnEditar = new JButton("EDITAR");
        btnEditar.setBounds(212, 300, 125, 35);
        btnEditar.setBackground(amarillo);
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setFocusable(false);
        btnEditar.setBorder(null);
        btnEditar.setFont(new Font("Arial", Font.BOLD, 16));
        jpEditar.add(btnEditar);

        btnCancelarEditar = new JButton("CANCELAR");
        btnCancelarEditar.setBounds(462, 300, 125, 35);
        btnCancelarEditar.setBackground(morado);
        btnCancelarEditar.setForeground(Color.WHITE);
        btnCancelarEditar.setFocusable(false);
        btnCancelarEditar.setBorder(null);
        btnCancelarEditar.setFont(new Font("Arial", Font.BOLD, 16));
        btnCancelarEditar.setEnabled(false);
        jpEditar.add(btnCancelarEditar);

        //Panel para eliminar objetos.

        jpEliminar = new JPanel();
        jpEliminar.setLayout(null);
        jpEliminar.setBackground(gris);

        lblInstrucciones = new JLabel("ESCRIBA EL ID A ELIMINAR:", SwingConstants.CENTER);
        lblInstrucciones.setBounds(0, 20, 800, 25);
        lblInstrucciones.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblInstrucciones);

        lblId = new JLabel("ID:", SwingConstants.LEFT);
        lblId.setBounds(200, 60, 100, 20);
        lblId.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(lblId);

        txtIdEliminar = new JTextField("",SwingConstants.LEFT);
        txtIdEliminar.setBounds(390,60,200,20);
        txtIdEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(txtIdEliminar);

        btnBuscarEliminar = new JButton("BUSCAR");
        btnBuscarEliminar.setBounds(365,90,80,20);
        btnBuscarEliminar.setFont(new Font("Arial", Font.BOLD, 12));
        btnBuscarEliminar.setBackground(Color.white);
        btnBuscarEliminar.setFocusable(false);
        btnBuscarEliminar.setBorder(null);
        jpEliminar.add(btnBuscarEliminar);

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(212, 300, 125, 35);
        btnEliminar.setBackground(rojo);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusable(false);
        btnEliminar.setBorder(null);
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        jpEliminar.add(btnEliminar);

        btnCancelarEliminar = new JButton("CANCELAR");
        btnCancelarEliminar.setBounds(462, 300, 125, 35);
        btnCancelarEliminar.setBackground(morado);
        btnCancelarEliminar.setForeground(Color.WHITE);
        btnCancelarEliminar.setFocusable(false);
        btnCancelarEliminar.setBorder(null);
        btnCancelarEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        btnCancelarEliminar.setEnabled(false);
        jpEliminar.add(btnCancelarEliminar);

        //Panel Archivo.

        jpArchivo = new JPanel();
        jpArchivo.setLayout(null);
        jpArchivo.setBackground(gris);

        lblInstrucciones = new JLabel("TABLA DE DATOS:", SwingConstants.CENTER);
        lblInstrucciones.setBounds(0, 20, 800, 25);
        lblInstrucciones.setFont(new Font("Arial", Font.BOLD, 16));
        jpArchivo.add(lblInstrucciones);

        jsTabla = new JScrollPane();
        jsTabla.setBounds(20,50,760,240);
        jpArchivo.add(jsTabla);

        btnActualizar = new JButton("REFRESCAR");
        btnActualizar.setBounds(337,300,125,35);
        btnActualizar.setBackground(Color.blue);
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFocusable(false);
        btnActualizar.setBorder(null);
        btnActualizar.setFont(new Font("Arial", Font.BOLD, 16));
        jpArchivo.add(btnActualizar);

        //agrega los paneles al Jtabbed.

        jtab.addTab("Agregar", jpAgregar);
        jtab.addTab("Editar", jpEditar);
        jtab.addTab("Eliminar",jpEliminar);
        jtab.addTab("Archivo",jpArchivo);

        btnAtras = new JButton("ATRAS");
        btnAtras.setBounds(418, 480, 155, 55);
        btnAtras.setBackground(azul);
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setFocusable(false);
        btnAtras.setBorder(null);
        btnAtras.setFont(new Font("Arial", Font.BOLD, 16));


        this.getContentPane().setBackground(gris);
        this.getContentPane().add(jtab);
        this.getContentPane().add(lblTitulo);
        this.getContentPane().add(btnAtras);
        setVisible(true);
    }


    public String getIdEditar()
    {
        return txtIdEditar.getText();
    }

    public String getIdEliminar()
    {
        return txtIdEliminar.getText();
    }

    public void setIdEditar(String txt)
    {
        txtIdEditar.setText(txt);
    }

    public void setIdEliminar(String txt)
    {
        txtIdEliminar.setText(txt);
    }

    public void addBtnAgregarListener(ActionListener listenControles)
    {
        btnAgregar.addActionListener(listenControles);
    }

    public void addBtnEditarListener(ActionListener listenControles)
    {
        btnEditar.addActionListener(listenControles);
    }
    public void addBtnCancelarEditarListener(ActionListener listeControles)
    {
        btnCancelarEditar.addActionListener(listeControles);
    }

    public void manejarBtnCancelarEditar(Boolean estado)
    {
        btnCancelarEditar.setEnabled(estado);
    }

    public void manejarBtnCancelarEliminar(Boolean estado)
    {
        btnCancelarEliminar.setEnabled(estado);
    }

    public void manejarTextFieldIdEditar(Boolean estado)
    {
        txtIdEditar.setEnabled(estado);
    }

    public void manejarTextFieldIdElimnar(Boolean estado)
    {
        txtIdEliminar.setEnabled(estado);
    }

    public void addBtnBuscarEditarListener(ActionListener listenControles)
    {
        btnBuscarEditar.addActionListener(listenControles);
    }

    public void addBtnBuscarEliminarListener(ActionListener listenControles)
    {
        btnBuscarEliminar.addActionListener(listenControles);
    }

    public void addBtnEliminarListener(ActionListener listenControles)
    {
        btnEliminar.addActionListener(listenControles);
    }

    public void addBtnCancelarEliminarListener(ActionListener listeControles)
    {
        btnCancelarEliminar.addActionListener(listeControles);
    }

    public void addBtnAtrasListener(ActionListener listenControles)
    {
        btnAtras.addActionListener(listenControles);
    }

    public void addBtnActualizarListener(ActionListener listenControles)
    {
        btnActualizar.addActionListener(listenControles);
    }

    public void crearTabla(Object[][] datosMatriz, String[]nombresColumnas)
    {
        tabla = new JTable(datosMatriz,nombresColumnas);
        tabla.setEnabled(false);
        jsTabla.getViewport().add(tabla);
        jsTabla.setVisible(true);
        jpArchivo.add(jsTabla);
    }

    public void limitarTxt(JTextField txt, int x)
    {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(txt.getText().length()==x)
                {
                    e.consume();
                }
            }
        });
    }

    public void rellenarBoxTipoDocumento(JComboBox box,String[] arrayTipoDocu)
    {
        for (int i =0; i<arrayTipoDocu.length;i++)
        {
            box.addItem(arrayTipoDocu[i]);
        }
    }

    public void mostrarMensaje(String erroMessage){
        JOptionPane.showMessageDialog(this, erroMessage);
    }
}
