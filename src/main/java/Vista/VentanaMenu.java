package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaMenu extends JFrame
{
    private JPanel jpContenido;
    private JLabel lblTitulo;
    private JButton btnConsultorio;
    private JButton btnAfiliado;
    private JButton btnCitas;
    private JButton btnServicios;
    private JButton btnMedicos;
    private JButton btnBackUp;
    private Color gris;
    private Color rojo;

    public VentanaMenu()
    {
        inicializarComponentes();
    }

    public void inicializarComponentes()
    {
        setTitle("VENTANA-MENU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(625, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        gris = new Color(208, 207, 207, 255);
        rojo = new Color(178, 2, 2);

        jpContenido = new JPanel();
        jpContenido.setLayout(null);
        jpContenido.setBackground(gris);
        jpContenido.setBounds(0,0,625,600);

        lblTitulo = new JLabel("SERVICIO DE SALUD UV", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 15, 625, 40);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
        jpContenido.add(lblTitulo);

        btnConsultorio = new JButton();
        btnConsultorio.setBorder(null);
        btnConsultorio.setBackground(Color.gray.darker());
        btnConsultorio.setBounds(60,125,180,70);
        btnConsultorio.setText("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">CONSULTORIO</p></html>");
        btnConsultorio.setFont(new Font("Arial", Font.BOLD, 20));
        btnConsultorio.setForeground(Color.white);
        btnConsultorio.setFocusable(false);
        jpContenido.add(btnConsultorio);

        btnAfiliado = new JButton();
        btnAfiliado.setBorder(null);
        btnAfiliado.setBackground(Color.gray.darker());
        btnAfiliado.setBounds(375,125,180,70);
        btnAfiliado.setText("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">AFILIADO</p></html>");
        btnAfiliado.setFont(new Font("Arial", Font.BOLD, 20));
        btnAfiliado.setForeground(Color.white);
        btnAfiliado.setFocusable(false);
        jpContenido.add(btnAfiliado);

        btnCitas = new JButton();
        btnCitas.setBorder(null);
        btnCitas.setBackground(Color.gray.darker());
        btnCitas.setBounds(60,325,180,70);
        btnCitas.setText("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">CITAS</p></html>");
        btnCitas.setFont(new Font("Arial", Font.BOLD, 20));
        btnCitas.setForeground(Color.white);
        btnCitas.setFocusable(false);
        jpContenido.add(btnCitas);

        btnMedicos = new JButton();
        btnMedicos.setBorder(null);
        btnMedicos.setBackground(Color.gray.darker());
        btnMedicos.setBounds(375,325,180,70);
        btnMedicos.setText("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">MEDICOS</p></html>");
        btnMedicos.setFont(new Font("Arial", Font.BOLD, 20));
        btnMedicos.setForeground(Color.white);
        btnMedicos.setFocusable(false);
        jpContenido.add(btnMedicos);

        btnServicios = new JButton();
        btnServicios.setBorder(null);
        btnServicios.setBackground(Color.gray.darker());
        btnServicios.setBounds(215,225,180,70);
        btnServicios.setText("<html><p style=\"text-align:center\">GESTIONAR</p><p style=\"text-align:center\">SERVICIOS</p></html>");
        btnServicios.setFont(new Font("Arial", Font.BOLD, 20));
        btnServicios.setForeground(Color.white);
        btnServicios.setFocusable(false);
        jpContenido.add(btnServicios);

        btnBackUp = new JButton();
        btnBackUp.setBorder(null);
        btnBackUp.setBackground(rojo);
        btnBackUp.setBounds(215,425,180,70);
        btnBackUp.setText("<html><p style=\"text-align:center\">BACKUP Y</p><p style=\"text-align:center\">RESTAURAR</p></html>");
        btnBackUp.setFont(new Font("Arial", Font.BOLD, 20));
        btnBackUp.setForeground(Color.white);
        btnBackUp.setFocusable(false);
        jpContenido.add(btnBackUp);

        this.getContentPane().add(jpContenido);
        setVisible(true);
    }

    public void addBtnAfiliadoListener(ActionListener listenControles)
    {
        btnAfiliado.addActionListener(listenControles);
    }

    public void addBtnBackUp(ActionListener listenControles)
    {
        btnBackUp.addActionListener(listenControles);
    }

    public void addBtnConsultorioListener(ActionListener listenControles)
    {
        btnConsultorio.addActionListener(listenControles);
    }

    public void addBtnCitasListener(ActionListener listenControles)
    {
        btnCitas.addActionListener(listenControles);
    }

    public void addBtnMedicosListener(ActionListener listenControles)
    {
        btnMedicos.addActionListener(listenControles);
    }
}
