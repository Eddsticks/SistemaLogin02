package Controlador;

import Modelo.Usuario;
import Modelo.DatosSesion;
import Modelo.GestorUsuarios;

import java.util.Scanner;

/**
 * Representa la sesión de un usuario autenticado.
 */
public class SesionActiva {
    private final Usuario usuario;
    private final Scanner scanner = new Scanner(System.in);
    private final DatosSesion datosSesion;
    private final GestorUsuarios gestorUsuarios = new GestorUsuarios();

    /**
     * Constructor que inicializa el usuario y sus datos de sesión.
     *
     * @param usuario usuario autenticado
     */
    public SesionActiva(Usuario usuario) {
        // TODO: Inicializar usuario y datos de sesión
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario.getNombre());
    }

    /**
     * Muestra el menú interactivo de la sesión.
     */
    public void menuSesion() {
        // TODO: Mostrar menú interactivo según el tipo de usuario
    }

    /**
     * Permite ingresar una nueva tarea.
     */
    private void escribirTarea() {
        // TODO: Permitir escribir y guardar una tarea
    }

    /**
     * Muestra todas las tareas del usuario.
     */
    private void mostrarTareas() {
        // TODO: Mostrar todas las tareas disponibles
    }

    /**
     * Registra un nuevo usuario en el archivo login.txt.
     *
     * @param nombre nombre del usuario
     * @param clave contraseña del usuario
     * @return true si fue exitoso, false si hubo error
     */
    private void registrarUsuario() {
        // TODO: Registrar nuevo usuario (solo si es admin)
    }
}
