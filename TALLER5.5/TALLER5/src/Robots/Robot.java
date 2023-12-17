package Robots;


/**
 * Clase que representa un robot con partes fabricadas de diferentes materiales.
 */
public class Robot {

    /**
     * Número de serie único del robot.
     */
    private String numeroSerie;

    /**
     * Material de la cabeza del robot.
     */
    private Material parteCabeza;

    /**
     * Material del cuerpo del robot.
     */
    private Material parteCuerpo;

    /**
     * Material de los brazos del robot.
     */
    private Material parteBrazos;

    /**
     * Material de las piernas del robot.
     */
    private Material partePiernas;


    /**
     * Constructor de la clase objeto robot
     * @param numeroSerie
     * @param parteCabeza
     * @param parteCuerpo
     * @param parteBrazos
     * @param partePiernas
     */


    /**
     * Constructor de la clase Robot que inicializa sus partes con materiales específicos.
     * @param numeroSerie Número de serie único del robot.
     * @param parteCabeza Material de la cabeza del robot.
     * @param parteCuerpo Material del cuerpo del robot.
     * @param parteBrazos Material de los brazos del robot.
     * @param partePiernas Material de las piernas del robot.
     */
    public Robot(String numeroSerie, Material parteCabeza, Material parteCuerpo, Material parteBrazos, Material partePiernas) {
        this.numeroSerie = numeroSerie;
        this.parteCabeza = parteCabeza;
        this.parteCuerpo = parteCuerpo;
        this.parteBrazos = parteBrazos;
        this.partePiernas = partePiernas;
    }


    /**
     * Constructor de la clase Robot que acepta materiales representados como cadenas de texto.
     * Este constructor puede ser modificado o eliminado según las necesidades del sistema.
     * @param numeroSerie Número de serie único del robot.
     * @param parteCabeza Material de la cabeza del robot representado como cadena de texto.
     * @param parteCuerpo Material del cuerpo del robot representado como cadena de texto.
     * @param parteBrazos Material de los brazos del robot representado como cadena de texto.
     * @param partePiernas Material de las piernas del robot representado como cadena de texto.
     */
    public Robot(String numeroSerie, String parteCabeza, String parteCuerpo, String parteBrazos, String partePiernas) {
        // Implementar la lógica para asignar los materiales a partir de las cadenas de texto, si es necesario.
    }


    /**
     * Obtiene el número de serie del robot.
     * @return Número de serie del robot.
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Obtiene el material de la cabeza del robot.
     * @return Material de la cabeza del robot.
     */
    public Material getParteCabeza() {
        return parteCabeza;
    }

    /**
     * Establece el material de la cabeza del robot.
     * @param parteCabeza Nuevo material de la cabeza del robot.
     */
    public void setParteCabeza(Material parteCabeza) {
        this.parteCabeza = parteCabeza;
    }

    /**
     * Obtiene el material del cuerpo del robot.
     * @return Material del cuerpo del robot.
     */
    public Material getParteCuerpo() {
        return parteCuerpo;
    }

    /**
     * Establece el material del cuerpo del robot.
     * @param parteCuerpo Nuevo material del cuerpo del robot.
     */
    public void setParteCuerpo(Material parteCuerpo) {
        this.parteCuerpo = parteCuerpo;
    }

    /**
     * Obtiene el material de los brazos del robot.
     * @return Material de los brazos del robot.
     */
    public Material getParteBrazos() {
        return parteBrazos;
    }

    /**
     * Establece el material de los brazos del robot.
     * @param parteBrazos Nuevo material de los brazos del robot.
     */
    public void setParteBrazos(Material parteBrazos) {
        this.parteBrazos = parteBrazos;
    }

    /**
     * Obtiene el material de las piernas del robot.
     * @return Material de las piernas del robot.
     */
    public Material getPartePiernas() {
        return partePiernas;
    }

    /**
     * Establece el material de las piernas del robot.
     * @param partePiernas Nuevo material de las piernas del robot.
     */
    public void setPartePiernas(Material partePiernas) {
        this.partePiernas = partePiernas;
    }
}
