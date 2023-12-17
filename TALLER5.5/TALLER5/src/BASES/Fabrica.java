package BASES;

import Robots.Robot;

import java.util.List;

/**
 * Interfaz que define los métodos y operaciones que debe tener una fábrica de robots.
 */
public interface Fabrica {

    /**
     * Crea un nuevo robot con las partes especificadas.
     * @param materialCabeza Material de la cabeza del robot.
     * @param materialCuerpo Material del cuerpo del robot.
     * @param materialBrazos Material de los brazos del robot.
     * @param materialPiernas Material de las piernas del robot.
     * @return True si el robot se crea exitosamente, false en caso contrario.
     */
    boolean crearRobot(String materialCabeza, String materialCuerpo, String materialBrazos, String materialPiernas);

    /**
     * Edita un robot existente con las partes y número de serie especificados.
     * @param numeroSerie Número de serie único del robot a editar.
     * @param parteCabeza Nuevo material de la cabeza del robot.
     * @param parteCuerpo Nuevo material del cuerpo del robot.
     * @param parteBrazos Nuevo material de los brazos del robot.
     * @param partePiernas Nuevo material de las piernas del robot.
     * @return True si la edición se realiza exitosamente, false en caso contrario.
     */
    boolean editarRobot(String numeroSerie, String parteCabeza, String parteCuerpo, String parteBrazos, String partePiernas);

    boolean editarRobot();

    /**
     * Muestra la información de todos los robots creados en la fábrica.
     * @return Lista de cadenas con la información de los robots.
     */
    public List<String> mostrarRobots();

    /**
     * Elimina todos los robots y partes asociadas en la fábrica.
     */
    void destruirTodo();

    /**
     * Método no implementado para crear un robot sin especificar partes.
     * @return Siempre devuelve false.
     */
    boolean crearRobot();
}