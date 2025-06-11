package Modelo;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Clase que permite registrar nuevos usuarios.
 */
public class GestorUsuarios {
    private static final String NOMBRE_ARCHIVO = "login.txt";

    /**
     * Constructor por defecto. Verifica la existencia del archivo de usuarios.
     */
    public GestorUsuarios() {
        File archivoLogin = new File(NOMBRE_ARCHIVO);

        if (!archivoLogin.exists()) {
            try {
                if (archivoLogin.createNewFile()) {
                    System.out.println("Archivo ´login.txt´ creado con éxito");
                } else {
                    System.err.println("Error: No se pudo crear el archivo");
                }
            } catch (IOException e) {
                System.err.println("Error de I/O al crear ´login.txt´: " + e.getMessage());
            }
        }
    }

    /**
     * Registra un nuevo usuario en el archivo login.txt.
     *
     * @param nombre nombre del usuario
     * @param clave contraseña del usuario
     * @return true si fue exitoso, false si hubo error
     */
    public boolean registrar(String nombre, String clave) {
        try (FileWriter fileWriter = new FileWriter(NOMBRE_ARCHIVO, true); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println("\n" + nombre + ";" + clave);
            System.out.println("Usuario '" + nombre + "' registrado exitosamente");
            return true;

        } catch (IOException e) {
            System.err.println("Error al registrar usuario");
            return false;
        }
    }
}