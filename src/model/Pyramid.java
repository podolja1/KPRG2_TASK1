package model;

import transforms.Point3D;
import transforms.Col;
import java.util.Arrays;
import java.util.Random;

/**
 * Vytvoreni jehlanu
 */
public class Pyramid extends Solid {
    private Random rgb = new Random();
    private Col color() {
        return new Col(rgb.nextInt(255), rgb.nextInt(255), rgb.nextInt(255));
    }

    public Pyramid() {
        vertexBuffer.add(new Vertex(new Point3D(0,0,0), color()));  // 0
        vertexBuffer.add(new Vertex(new Point3D(2,0,0), color()));  // 1
        vertexBuffer.add(new Vertex(new Point3D(2,0,2), color()));  // 2
        vertexBuffer.add(new Vertex(new Point3D(0,0,2), color()));  // 3
        vertexBuffer.add(new Vertex(new Point3D(1,2,1), color()));  // 4

        partBuffer.add(new Part(TopologyType.TRIANGLESTRIP, 0, 8 + 2)); // spojeni bodu do trojuhelniku
        indexBuffer.addAll(Arrays.asList(0,1,2,0,3,4,2,1,0,4));

        /*
                   4
                 * * *
               *   *   *
              3  *  *  * 2
            *       *  *
          *          *
        0  *  *  *  1

        */
    }
}

