import BASES.Fabrica;
import BASES.FabricaImpl;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa el menú del sistema para gestionar la fabricación y edición de robots.
 */
public class MenuDelSistema {

    /**
     * Instancia de la interfaz Fabrica para realizar operaciones con robots.
     */
    private final Fabrica fabrica;

    /**
     * Botón para ensamblar un robot.
     */
    private JButton botonEnsamblarRobot;

    /**
     * Botón para editar un robot.
     */
    private JButton botonEditarRobot;

    /**
     * Botón para mostrar información de los robots.
     */
    private JButton botonMostrarRobot;

    /**
     * Botón para salir del sistema.
     */
    private JButton botonSalir;

    /**
     * Panel principal del menú.
     */
    private JPanel panel1;

    /**
     * Etiqueta de texto principal en el menú.
     */
    private JLabel textoPrincipal;

    /**
     * Constructor de la clase MenuDelSistema.
     * @param fabrica Instancia de la interfaz Fabrica para realizar operaciones con robots.
     */
    public MenuDelSistema(Fabrica fabrica) {
        this.fabrica = FabricaImpl.getInstance();

        botonEnsamblarRobot.addActionListener(e -> {
            System.out.println("Usted ha elegido la opción de ensamblar robots");

            System.out.println("Seleccione el material que utilizará en la cabeza (Metal común, Grafeno, Acero, Vibranium):");
            Scanner n = new Scanner(System.in);
            String materialCabeza = n.nextLine();

            System.out.println("Seleccione el material que utilizará en el cuerpo (Metal común, Grafeno, Acero, Vibranium):");
            Scanner m = new Scanner(System.in);
            String materialCuerpo = m.nextLine();

            System.out.println("Seleccione el material que utilizará en los brazos (Metal común, Grafeno, Acero, Vibranium):");
            Scanner a = new Scanner(System.in);
            String materialBrazos = a.nextLine();

            System.out.println("Seleccione el material que utilizará en las piernas (Metal común, Grafeno, Acero, Vibranium):");
            Scanner z = new Scanner(System.in);
            String materialPiernas = z.nextLine();

            fabrica.crearRobot(materialCabeza, materialCuerpo, materialBrazos, materialPiernas);

            System.out.println("Ha creado su robot exitosamente");
        });

        botonEditarRobot.addActionListener(e -> {
            System.out.println("Usted ha elegido la opción de editar robots");

            // Obtener los datos del usuario para la edición
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el número de serie del robot a editar:");
            String numeroSerie = scanner.nextLine();

            System.out.println("Ingrese la nueva parte de la cabeza:");
            String nuevaParteCabeza = scanner.nextLine();

            System.out.println("Ingrese la nueva parte del cuerpo:");
            String nuevaParteCuerpo = scanner.nextLine();

            System.out.println("Ingrese la nueva parte de los brazos:");
            String nuevaParteBrazos = scanner.nextLine();

            System.out.println("Ingrese la nueva parte de las piernas:");
            String nuevaPartePiernas = scanner.nextLine();

            // Llamar al método de la fábrica para editar el robot
            boolean edicionExitosa = fabrica.editarRobot(numeroSerie, nuevaParteCabeza, nuevaParteCuerpo, nuevaParteBrazos, nuevaPartePiernas);

            // Imprimir el resultado de la edición
            if (edicionExitosa) {
                System.out.println("Edición exitosa.");
            } else {
                System.out.println("Error en la edición. Verifique los datos proporcionados.");
            }
        });

        botonMostrarRobot.addActionListener(e -> {
            System.out.println("Usted ha elegido la opción de mostrar robots");

            // Obtener la información de los robots
            List<String> infoRobots = fabrica.mostrarRobots();

            // Mostrar la información en la consola
            for (String infoRobot : infoRobots) {
                System.out.println(infoRobot);
            }
        });

        botonSalir.addActionListener(e -> {
            fabrica.destruirTodo();
            System.exit(-1);
            System.out.println("Ha salido del sistema exitosamente");
        });
    }

    /**
     * Obtiene el panel principal del menú.
     * @return Panel principal del menú.
     */
    public JPanel getPanel() {
        return panel1;
    }
}

