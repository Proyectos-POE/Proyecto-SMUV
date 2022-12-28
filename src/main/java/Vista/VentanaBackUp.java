package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/* 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Julian Rendon <julian.david.rendon@correounivalle.edu.co>
 */

public class VentanaBackUp extends Plantilla
{

    private JPanel jpContenido;
    private JLabel lblTitulo;
    private JButton btnBackUp;
    private JButton btnRestaurar;
    private JButton btnAtras;
    private Color gris;
    private Color rojo;
    private Color verde;
    private Color azul;

    public VentanaBackUp()
    {
        inicializarComponentes();
    }

    public void inicializarComponentes()
    {
        setTitle("VENTANA-MENU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        gris = new Color(208, 207, 207, 255);
        rojo = new Color(178, 2, 2);
        verde = new Color(77, 153, 0);
        azul = new Color(7, 185, 234, 255);

        jpContenido = new JPanel();
        jpContenido.setLayout(null);
        jpContenido.setBackground(gris);
        jpContenido.setBounds(0,0,1000,600);

        lblTitulo = new JLabel("BACKUP Y RESTAURAR", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 15, 1000, 40);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
        jpContenido.add(lblTitulo);

        btnBackUp = new JButton();
        btnBackUp.setBorder(null);
        btnBackUp.setBackground(rojo);
        btnBackUp.setBounds(250,225,180,70);
        btnBackUp.setText("<html><p style=\"text-align:center\">REALIZAR</p><p style=\"text-align:center\">BACK UP</p></html>");
        btnBackUp.setFont(new Font("Arial", Font.BOLD, 20));
        btnBackUp.setForeground(Color.white);
        btnBackUp.setFocusable(false);
        jpContenido.add(btnBackUp);

        btnRestaurar = new JButton();
        btnRestaurar.setBorder(null);
        btnRestaurar.setBackground(verde);
        btnRestaurar.setBounds(560,225,180,70);
        btnRestaurar.setText("<html><p style=\"text-align:center\">REALIZAR</p><p style=\"text-align:center\">RESTAURACIÓN</p></html>");
        btnRestaurar.setFont(new Font("Arial", Font.BOLD, 20));
        btnRestaurar.setForeground(Color.white);
        btnRestaurar.setFocusable(false);
        jpContenido.add(btnRestaurar);

        btnAtras = new JButton("ATRAS");
        btnAtras.setBounds(418, 480, 155, 55);
        btnAtras.setBackground(azul);
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setFocusable(false);
        btnAtras.setBorder(null);
        btnAtras.setFont(new Font("Arial", Font.BOLD, 16));
        jpContenido.add(btnAtras);
        this.getContentPane().add(jpContenido);
        setVisible(true);
    }

    public void addBtnBackUpListener(ActionListener listenControles)
    {
        btnBackUp.addActionListener(listenControles);
    }

    public void addBtnRestaurarListener(ActionListener listenControles)
    {
        btnRestaurar.addActionListener(listenControles);
    }

    public void addBtnAtrasListener(ActionListener listenControles)
    {
        btnAtras.addActionListener(listenControles);
    }
}
