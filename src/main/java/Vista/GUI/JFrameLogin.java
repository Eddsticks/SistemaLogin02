package Vista.GUI;

import Controlador.Login;
import Controlador.SesionActiva;
import Modelo.Usuario;
import Modelo.DatosLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameLogin extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoClave;
    private JButton botonLogin;
    private JLabel tagMensaje;
    private DatosLogin datosLogin;
    private Login controladorLogin;

    public JFrameLogin() {
        setTitle("Organizador de Tareas - Iniciar sesión");
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        datosLogin = new DatosLogin();
        controladorLogin = new Login();

        //Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //componentes gui
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Usuario: "), gbc);

        //ct usuario
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        campoUsuario = new JTextField(15);
        panel.add(campoUsuario, gbc);

        //tag clave
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        campoClave = new JPasswordField();
        panel.add(campoClave, gbc);

        //btn iniciar sesión
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        botonLogin = new JButton("Iniciar Sesión");

        //tg msg
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        tagMensaje = new JLabel("");
        tagMensaje.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(tagMensaje, gbc);

        //otros
        add(panel);

        botonLogin.addActionListener(e -> manejarLogin());
    }

    /**
     * Lógica de inicio de sesión para el botón.
     */
    private void manejarLogin() {
        String nombreUsuario = campoUsuario.getText();
        String claveIngresada = new String(campoClave.getPassword());

        if (nombreUsuario.isEmpty() || claveIngresada.isEmpty()) {
            tagMensaje.setText("Por favor, ingrese usuario y clave.");
            tagMensaje.setForeground(Color.RED);
            return;
        }

        Usuario usuarioAutenticado = controladorLogin.autenticar(nombreUsuario, claveIngresada, datosLogin);

        if (usuarioAutenticado != null) {
            tagMensaje.setText("Inicio de sesión exitoso, Bienvenido: " + usuarioAutenticado.getNombre() + "!.");
            tagMensaje.setForeground(new Color(0,100,0));
            this.dispose();
            System.out.println("Debug: Sesión activa iniciada para: " + usuarioAutenticado.getNombre());

        } else {
            tagMensaje.setText("Credenciales incorrectas. Intentar de nuevo.");
            tagMensaje.setForeground(Color.RED);
            campoClave.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JFrameLogin().setVisible(true));
    }
}
