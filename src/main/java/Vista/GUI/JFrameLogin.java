package Vista.GUI;

import Controlador.Login;
import Controlador.SesionActiva;
import Modelo.DatosLogin;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameLogin extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoClave;
    private JButton botonLogin;
    private JLabel etiquetaMensaje; // Renombrado a 'etiquetaMensaje' para consistencia
    private DatosLogin datosLogin;
    private Login controladorLogin;

    public JFrameLogin() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("No se pudo aplicar el Look and Feel Nimbus: " + e.getMessage());
        }

        // --- Configuración básica de la ventana ---
        setTitle("Organizador de Tareas - Iniciar sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // --- Inicializar componentes de lógica ---
        datosLogin = new DatosLogin();
        controladorLogin = new Login();

        // --- Panel principal ---
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- Componentes GUI ---

        // Etiqueta Usuario
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 0;
        panel.add(new JLabel("Usuario:"), gbc);

        // Campo de texto para Usuario
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        campoUsuario = new JTextField(15);
        panel.add(campoUsuario, gbc);

        // Etiqueta Clave
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 0;
        panel.add(new JLabel("Clave:"), gbc);

        // Campo de texto para Clave (JPasswordField)
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        campoClave = new JPasswordField(15);
        panel.add(campoClave, gbc);

        // Botón Iniciar Sesión
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 5, 10, 5);
        botonLogin = new JButton("Iniciar Sesión");
        panel.add(botonLogin, gbc);

        // Etiqueta para mensajes (inicialmente vacía)
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);
        etiquetaMensaje = new JLabel(""); // Renombrado
        etiquetaMensaje.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(etiquetaMensaje, gbc);

        add(panel);

        pack();
        setLocationRelativeTo(null);

        botonLogin.addActionListener(e -> manejarLogin());
    }

    /**
     * Lógica de inicio de sesión para el botón.
     */
    private void manejarLogin() {
        String nombreUsuario = campoUsuario.getText();
        String claveIngresada = new String(campoClave.getPassword());

        if (nombreUsuario.isEmpty() || claveIngresada.isEmpty()) {
            etiquetaMensaje.setText("Por favor, ingrese usuario y clave.");
            etiquetaMensaje.setForeground(Color.RED);
            return;
        }

        Usuario usuarioAutenticado = controladorLogin.autenticar(nombreUsuario, claveIngresada, datosLogin);

        if (usuarioAutenticado != null) {
            etiquetaMensaje.setText("Inicio de sesión exitoso, Bienvenido: " + usuarioAutenticado.getNombre() + "!");
            etiquetaMensaje.setForeground(new Color(0,100,0));
            this.dispose(); // Cierra esta ventana de login
            System.out.println("Debug: Sesión activa iniciada para: " + usuarioAutenticado.getNombre());

        } else {
            etiquetaMensaje.setText("Credenciales incorrectas. Intentar de nuevo.");
            etiquetaMensaje.setForeground(Color.RED);
            campoClave.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JFrameLogin().setVisible(true));
    }
}