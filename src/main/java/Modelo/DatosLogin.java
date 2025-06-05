package Modelo;

import java.util.ArrayList;

/**
 * Clase encargada de gestionar el acceso a los datos de login.
 */
public class DatosLogin {
    private final ArrayList<Usuario> usuarios = new ArrayList<>();

    /**
     * Constructor que carga los usuarios desde login.txt
     */
    public DatosLogin() {
        // TODO: Leer login.txt y cargar usuarios a la lista
    }

    /**
     * Devuelve la lista de usuarios cargados.
     *
     * @return lista de usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
