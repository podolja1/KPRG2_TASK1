package model;

import transforms.Bicubic;
import transforms.Col;
import transforms.Cubic;
import transforms.Point3D;

import java.util.Random;

public class BicubicForm extends Solid {
    // barva
    private Random rgb = new Random();
    private Col color() {
        return new Col(rgb.nextInt(255), rgb.nextInt(255), rgb.nextInt(255));
    }

    public BicubicForm() {
        super();

        Bicubic bicubic = new Bicubic(Cubic.COONS,  // muzes pouzit taky BEZIER nebo FERGUSON
                new Point3D(3,3,0),
                new Point3D(1.5,1.5,1.5),
                new Point3D(0.5,0.5,0.5),
                new Point3D(2,2,0),
                new Point3D(3.5,3.5,2.5),
                new Point3D(0.5,0.5,1.5),
                new Point3D(3,0,1),
                new Point3D(3.5,4.5,2.5),
                new Point3D(1,2,0),
                new Point3D(0,3,1),
                new Point3D(4.5,4.5,2.5),
                new Point3D(2,2,2),
                new Point3D(3,3,0),
                new Point3D(1,3,2),
                new Point3D(5,5,2),
                new Point3D(2,2,1));

        int startIndex = 0;
        for(double i = 0; i <= 2; i += 0.2) {
            for(double j = 0; j <= 1; j += 0.5){
                vertexBuffer.add(new Vertex(bicubic.compute(i,j),new Col(color())));
                indexBuffer.add(startIndex);
                startIndex++;
            }
        }
        partBuffer.add(new Part(TopologyType.TRIANGLESTRIP, 0, startIndex));    // spojeni bodu do trojuhelniku
    }
}
