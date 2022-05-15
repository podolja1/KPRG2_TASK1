package app;

import javax.swing.*;

import control.Controller3D;
import view.Window;

/**
 * Sposteci trida
 */
public class AppStart {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Window window = new Window();
            new Controller3D(window.getPanel());
            window.setVisible(true);
        });
    }
}