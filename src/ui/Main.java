package ui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            System.out.println(
                    "No fue posible aplicar el estilo del sistema."
            );
        }

        SwingUtilities.invokeLater(() -> {

            InterfazGrafica interfaz = new InterfazGrafica();
            interfaz.setVisible(true);
        });
    }
}