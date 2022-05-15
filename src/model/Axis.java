package model;

import transforms.Col;
import transforms.Point3D;

import java.util.Arrays;

/**
 * Vykresleni osi
 */
public class Axis extends Solid {
        public Axis(double x, double y, double z, int color) {
        super();

        vertexBuffer.add(new Vertex(new Point3D(0, 0, 0), new Col(color)));     // pocatecni bod, 0
        vertexBuffer.add(new Vertex(new Point3D(x, y, z), new Col(color)));             // koncovy bod, 1

        indexBuffer.addAll(Arrays.asList(0, 1));
        partBuffer.add(new Part(TopologyType.LINE, 0, 1));
    }
}