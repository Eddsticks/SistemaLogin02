package Modelo;

import java.util.ArrayList;

/**
 * Clase encargada de manejar las tareas de un usuario autenticado.
 */
public class DatosSesion {
    private final String archivo;
    private final ArrayList<Tarea> tareas = new ArrayList<>();

    /**
     * Constructor que carga las tareas desde archivo.
     *
     * @param usuario nombre del usuario
     */
    public DatosSesion(String usuario) {
        // TODO: Cargar tareas desde archivo <usuario>_todo.txt
        this.archivo = usuario + "_todo.txt";
    }

    /**
     * Agrega una nueva tarea al archivo del usuario.
     *
     * @param descripcion texto de la tarea
     */
    public void agregarTarea(String descripcion) {
        // TODO: Agregar tarea a la lista y guardarla en el archivo
    }

    /**
     * Devuelve la lista de tareas.
     *
     * @return lista de tareas
     */
    public ArrayList<Tarea> getTareas() {
        return tareas;
    }
}
