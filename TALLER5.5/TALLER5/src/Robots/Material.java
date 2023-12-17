package Robots;


/**
 * Enumeración que representa diferentes materiales para la construcción de partes de robots.
 */
public enum Material {

    /**
     * Material de metal común.
     */
    METAL_COMUN(25, 30, 400),

    /**
     * Material de acero.
     */
    ACERO(50, 60, 150),

    /**
     * Material de grafeno.
     */
    GRAFENO(10, 120, 500),

    /**
     * Material de vibranium.
     */

    VIBRANIUM(100, 20, 250);

    private int defensa;
    private int ataque;
    private int vida;


    /**
     * Constructor de Material que asigna los valores de defensa, ataque y vida.
     * @param defensa Valor de defensa asociado al material.
     * @param ataque Valor de ataque asociado al material.
     * @param vida Valor de vida asociado al material.
     */
    Material(int defensa, int ataque, int vida) {
        this.defensa = defensa;
        this.ataque = ataque;
        this.vida = vida;
    }
    /**
     * Obtiene el valor de defensa del material.
     * @return Valor de defensa.
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * Obtiene el valor de ataque del material.
     * @return Valor de ataque.
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Obtiene el valor de vida del material.
     * @return Valor de vida.
     */
    public int getVida() {
        return vida;
    }
}
