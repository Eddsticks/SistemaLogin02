package Launcher;

import Vista.GUI.JFrameLogin;

import javax.swing.*;

/**
 * Clase principal del sistema.
 */
public class Inicio {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrameLogin loginFrame = new JFrameLogin();
                loginFrame.setVisible(true);
            }
        });
    }
}
