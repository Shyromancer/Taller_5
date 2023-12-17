import BASES.Fabrica;
import BASES.FabricaImpl;

import javax.swing.*;

/**
 * Clase principal que inicia la interfaz gráfica del sistema.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> iniciarInterfazGrafica());
    }

    public static void iniciarInterfazGrafica() {
        JFrame ventana = new JFrame();
        ventana.setTitle("Sistema de Robots"); // Cambiado el título para que sea consistente con el propósito
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);
        ventana.setLocationRelativeTo(null);

        Fabrica fabrica = FabricaImpl.getInstance();

        MenuDelSistema menuPrincipal = new MenuDelSistema(fabrica);

        ventana.setContentPane(menuPrincipal.getPanel());
        ventana.setVisible(true);
    }
}