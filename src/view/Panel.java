package view;

import rasterize.Raster;
import rasterize.ImageBuffer;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private final ImageBuffer imageBuffer;

    private static final int WIDTH = 1024, HEIGHT = 768;

    Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        imageBuffer = new ImageBuffer(WIDTH, HEIGHT);
        imageBuffer.setClearValue(Color.BLACK.getRGB());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        imageBuffer.repaint(g);
    }

    public Raster<Integer> getImageBuffer() {
        return imageBuffer;
    }
}
