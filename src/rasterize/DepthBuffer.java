package rasterize;

import java.util.Arrays;
import java.util.Optional;

public class DepthBuffer implements Raster<Double> {

    private final double[][] zData;
    private double clearValue;

    public DepthBuffer(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new RuntimeException("Zero or negative width or height");
        }
        zData = new double[width][height];

        setClearValue(1d);
        clear();
    }

    @Override
    public void clear() {
        for (double[] z : zData) {
            Arrays.fill(z, clearValue);
        }
    }

    @Override
    public void setClearValue(Double clearValue) {
        this.clearValue = clearValue;
    }

    @Override
    public int getWidth() {
        return zData.length;
    }

    @Override
    public int getHeight() {
        return zData[0].length;
    }

    @Override
    public Optional<Double> getElement(int x, int y) {
        if (isInsideBounds(x, y)) {
            return Optional.of(zData[x][y]);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void setElement(int x, int y, Double value) {
        if (isInsideBounds(x, y)) {
            zData[x][y] = value;
        }
    }
}
