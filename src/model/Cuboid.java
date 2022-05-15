package model;

import transforms.Point3D;
import transforms.Col;
import java.util.Arrays;
import java.util.Random;

/**
 * Vytvoreni kvadru
 */
public class Cuboid extends Solid {
    // barva
    private Random rgb = new Random();
    private Col color() {
        return new Col(rgb.nextInt(255), rgb.nextInt(255), rgb.nextInt(255));
    }

    public Cuboid() {
        vertexBuffer.add(new Vertex(new Point3D(0.5,0.5,0), color()));  // 0
        vertexBuffer.add(new Vertex(new Point3D(1.5,0.5,0), color()));  // 1
        vertexBuffer.add(new Vertex(new Point3D(1.5,0.5,2), color()));  // 2
        vertexBuffer.add(new Vertex(new Point3D(0.5,0.5,2), color()));  // 3
        vertexBuffer.add(new Vertex(new Point3D(0.5,1.5,0), color()));  // 4
        vertexBuffer.add(new Vertex(new Point3D(1.5,1.5,0), color()));  // 5
        vertexBuffer.add(new Vertex(new Point3D(1.5,1.5,2), color()));  // 6
        vertexBuffer.add(new Vertex(new Point3D(0.5,1.5,2), color()));  // 7


        partBuffer.add(new Part(TopologyType.TRIANGLESTRIP, 0, 12 + 2));    // spojeni bodu do trojuhelniku
        indexBuffer.addAll(Arrays.asList(4,5,7,6,2,5,1,0,2,3,7,0,4,5,7));

        /*
                 7  *  *   6
               * *       * *
             *   *     *   *
          *      *   *     *
        4  *  *  3  5   *  2
        *       *   *     *
        *     *     *   *
        *  *        * *
        0  *  *  *  1

        */
    }
}
