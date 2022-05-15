package rasterize;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class ImageBuffer implements Raster<Integer> {

    private final BufferedImage img;
    private int clearColor;

    public ImageBuffer(int width, int height) {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void repaint(Graphics graphics) {
        graphics.drawImage(img, 0, 0, null);
    }

    public BufferedImage getImg() {
        return img;
    }

    public Graphics getGraphics() {
        return img.getGraphics();
    }

    @Override
    public Optional<Integer> getElement(int x, int y) {
        if (isInsideBounds(x, y)) {
            return Optional.of(img.getRGB(x, y));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void setElement(int x, int y, Integer color) {
        if (isInsideBounds(x, y)) {
            img.setRGB(x, y, color);
        }
    }

    @Override
    public void clear() {
        Graphics g = getGraphics();
        g.setColor(new Color(clearColor));
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void setClearValue(Integer clearColor) {
        this.clearColor = clearColor;
    }

    @Override
    public int getWidth() {
        return img.getWidth();
    }

    @Override
    public int getHeight() {
        return img.getHeight();
    }

}
