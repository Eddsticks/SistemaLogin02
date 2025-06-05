package Vista;

import Controlador.Login;
import Controlador.SesionActiva;
import Modelo.DatosLogin;
import Modelo.Usuario;

import java.util.Scanner;

/**
 * Vista principal del sistema.
 */
public class ConsolaLogin {
    private final Scanner scanner = new Scanner(System.in);
    private final DatosLogin datos = new DatosLogin();
    private final Login login = new Login();

    /**
     * Muestra el menú principal del sistema.
     */
    public void menu() {
        // TODO: Mostrar mensaje de bienvenida y manejar login
    }

    /**
     * Solicita usuario y clave, autentica, y lanza la sesión si corresponde.
     */
    private void manejarLogin() {
        // TODO: Solicitar usuario y clave, autenticar, y lanzar sesión si procede
    }
}
