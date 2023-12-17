package BASES;

import Robots.Material;
import Robots.Robot;

import java.util.*;


/**
 * Implementación de la interfaz Fabrica que permite la creación, edición, visualización y destrucción de robots.
 */
public class FabricaImpl implements Fabrica {


    /**
     * Única instancia de la clase FabricaImpl (Singleton).
     */
    private static FabricaImpl instance;

    /**
     * Lista que almacena los robots creados en la fábrica.
     */
    private List<Robot> robots;

    /**
     * Conjunto que registra las partes aleatorias utilizadas para generar números de serie.
     */
    private Set<String> usedRandomParts;


    /**
     * Constructor privado de FabricaImpl para asegurar el patrón de diseño Singleton.
     * Inicializa la lista de robots y el conjunto de partes aleatorias utilizadas.
     */

    private FabricaImpl() {///tiene que swer siempre privado al ser singleton
        robots = new ArrayList<>(); // Inicializar la lista de robots
        usedRandomParts = new HashSet<>(); // Inicializar el conjunto de partes aleatorias
    }



    /**
     * Método estático que devuelve la única instancia de FabricaImpl (Singleton).
     * @return La instancia de FabricaImpl.
     */
    public static FabricaImpl getInstance() {
        if (instance == null) {
            instance = new FabricaImpl();
        }
        return instance;
    }

    /**
     * Crea un nuevo robot con las partes especificadas y un número de serie aleatorio.
     * @param materialCabeza Parte de la cabeza del robot.
     * @param materialCuerpo Parte del cuerpo del robot.
     * @param materialBrazos Parte de los brazos del robot.
     * @param materialPiernas Parte de las piernas del robot.
     * @return True si el robot se crea exitosamente, false en caso contrario.
     */
    @Override
    public boolean crearRobot(String materialCabeza, String materialCuerpo, String materialBrazos, String materialPiernas) {
        //Lógica para ensamblar el robot y asignar número de serie aleatorio
        String numeroSerie = generarNumeroSerieAleatorio();

        // Validar que los materiales no sean null antes de crear el robot
        if (materialCabeza != null && materialCuerpo != null && materialBrazos != null && materialPiernas != null) {
            Robot robot = new Robot(numeroSerie, Material.valueOf(materialCabeza.toUpperCase()),
                    Material.valueOf(materialCuerpo.toUpperCase()), Material.valueOf(materialBrazos.toUpperCase()),
                    Material.valueOf(materialPiernas.toUpperCase()));

            // Agregar el robot a la lista de robots
            robots.add(robot);
            return true;
        } else {
            System.out.println("Error: Materiales no válidos para crear el robot.");
            return false;
        }
    }

    /**
     * Método no implementado para crear un robot sin especificar partes.
     * @return Siempre devuelve false.
     */
    @Override
    public boolean crearRobot() {
        return false;
    }


    /**
     * Edita un robot existente con las partes y número de serie especificados.
     * @param numeroSerie Número de serie del robot a editar.
     * @param parteCabeza Nueva parte de la cabeza para el robot.
     * @param parteCuerpo Nueva parte del cuerpo para el robot.
     * @param parteBrazos Nuevas partes de los brazos para el robot.
     * @param partePiernas Nuevas partes de las piernas para el robot.
     * @return True si la edición se realiza exitosamente, false en caso contrario.
     */
    @Override
    public boolean editarRobot(String numeroSerie, String parteCabeza, String parteCuerpo, String parteBrazos, String partePiernas) {
        // Buscar el robot en la lista por número de serie
        for (Robot robot : robots) {
            if (robot.getNumeroSerie().equals(numeroSerie)) {
                // Validar si las partes del cuerpo son válidas
                if (parteCuerpoValida(parteCabeza) && parteCuerpoValida(parteCuerpo) &&
                        parteCuerpoValida(parteBrazos) && parteCuerpoValida(partePiernas)) {
                    // Actualizar las partes del robot
                    robot.setParteCabeza(Material.valueOf(parteCabeza.toUpperCase()));
                    robot.setParteCuerpo(Material.valueOf(parteCuerpo.toUpperCase()));
                    robot.setParteBrazos(Material.valueOf(parteBrazos.toUpperCase()));
                    robot.setPartePiernas(Material.valueOf(partePiernas.toUpperCase()));
                    return true; // Edición exitosa
                } else {
                    System.out.println("Error: Partes del cuerpo no válidas.");
                    return false; // Partes del cuerpo no válidas
                }
            }
        }
        System.out.println("Error: Robot no encontrado.");
        return false; // Robot no encontrado
    }

    /**
     * Método auxiliar para validar si una parte del cuerpo es válida.
     * @param parteCuerpo Parte del cuerpo a validar.
     * @return True si la parte del cuerpo es válida, false en caso contrario.
     */
    private boolean parteCuerpoValida(String parteCuerpo) {
        try {
            Material.valueOf(parteCuerpo.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public boolean editarRobot() {
        return false;
    }




    /**
     * Muestra la información de todos los robots creados en la fábrica.
     * @return Lista de cadenas con la información de los robots.
     */
    @Override
    public List<String> mostrarRobots() {
        List<String> infoRobots = new ArrayList<>();
        for (Robot robot : robots) {
            // Construir la cadena de información del robot
            StringBuilder robotInfo = new StringBuilder();
            robotInfo.append("*********************************************************************\n");
            robotInfo.append("[Serial]: ").append(robot.getNumeroSerie()).append("\n");
            robotInfo.append("Cabeza: ").append(robot.getParteCabeza()).append("\n");
            robotInfo.append("Cuerpo: ").append(robot.getParteCuerpo()).append("\n");
            robotInfo.append("Brazos: ").append(robot.getParteBrazos()).append("\n");
            robotInfo.append("Piernas: ").append(robot.getPartePiernas()).append("\n");
            robotInfo.append("[Estadísticas]:\n");
            robotInfo.append("Defensa: ").append(calcularEstadistica(robot.getParteCabeza(), robot.getParteCuerpo(),
                    robot.getParteBrazos(), robot.getPartePiernas(), "defensa")).append("\n");
            robotInfo.append("Ataque: ").append(calcularEstadistica(robot.getParteCabeza(), robot.getParteCuerpo(),
                    robot.getParteBrazos(), robot.getPartePiernas(), "ataque")).append("\n");
            robotInfo.append("Vida: ").append(calcularEstadistica(robot.getParteCabeza(), robot.getParteCuerpo(),
                    robot.getParteBrazos(), robot.getPartePiernas(), "vida")).append("\n");
            robotInfo.append("*********************************************************************\n");

            // Agregar la cadena de información a la lista
            infoRobots.add(robotInfo.toString());
        }
        return infoRobots;
    }
    /**
     * Calcula la estadística (defensa, ataque o vida) total de un robot a partir de sus partes.
     * @param parteCabeza Parte de la cabeza del robot.
     * @param parteCuerpo Parte del cuerpo del robot.
     * @param parteBrazos Parte de los brazos del robot.
     * @param partePiernas Parte de las piernas del robot.
     * @param estadistica Tipo de estadística a calcular (defensa, ataque o vida).
     * @return Valor total de la estadística calculada.
     */
    private int calcularEstadistica(Material parteCabeza, Material parteCuerpo, Material parteBrazos, Material partePiernas, String estadistica) {
        int estadisticaTotal = 0;
        switch (estadistica.toLowerCase()) {
            case "defensa":
                estadisticaTotal = obtenerValorSeguro(parteCabeza) + obtenerValorSeguro(parteCuerpo)
                        + obtenerValorSeguro(parteBrazos) + obtenerValorSeguro(partePiernas);
                break;
            case "ataque":
                estadisticaTotal = obtenerValorSeguro(parteCabeza) + obtenerValorSeguro(parteCuerpo)
                        + obtenerValorSeguro(parteBrazos) + obtenerValorSeguro(partePiernas);
                break;
            case "vida":
                estadisticaTotal = obtenerValorSeguro(parteCabeza) + obtenerValorSeguro(parteCuerpo)
                        + obtenerValorSeguro(parteBrazos) + obtenerValorSeguro(partePiernas);
                break;
            default:
                // Manejar el caso de estadística no reconocida
                break;
        }
        return estadisticaTotal;
    }

    private int obtenerValorSeguro(Material material) {
        return (material != null) ? material.getDefensa() : 0;
    }


    /**
     * Elimina todos los robots y partes aleatorias registradas en la fábrica.
     */
    @Override
    public void destruirTodo() {
        robots.clear(); // Limpiar la lista de robots
        usedRandomParts.clear(); // Limpiar el conjunto de partes aleatorias

    }



    /**
     * Genera un número de serie aleatorio para un robot.
     * @return El número de serie generado.
     */
    private String generarNumeroSerieAleatorio() {
        Random random = new Random();
        String basePart = "BOT.V"; // Parte fija del número de serie

        // Generar la parte aleatoria de 4 dígitos hasta que sea única
        String randomPart;
        do {
            randomPart = String.format("%04d", random.nextInt(10000)); // Parte aleatoria de 4 dígitos
        } while (usedRandomParts.contains(randomPart));

        // Combinar las partes fija y aleatoria
        String serialNumber = basePart + randomPart;

        // Marcar la parte aleatoria como usada
        usedRandomParts.add(randomPart);

        return serialNumber;
    }
}
