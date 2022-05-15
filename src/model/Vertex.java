package model;

import transforms.Col;
import transforms.Point3D;
import transforms.Vec3D;

import java.util.Optional;

public class Vertex {

    private final Point3D point;
    private final Col color;

    public Vertex(Point3D point, Col color) {
        this.point = point;
        this.color = color;
    }

    public Vertex mul(double t) {
        return new Vertex(point.mul(t), color.mul(t));
    }

    public Vertex add(Vertex v) {
        return new Vertex(point.add(v.getPoint()), color.add(v.getColor()));
    }

    public Optional<Vertex> dehomog() {
        Optional<Vec3D> optional = point.dehomog();
        return optional.map(vec3D -> new Vertex(new Point3D(vec3D), color));
    }

    public Point3D getPoint() {
        return point;
    }

    public double getX() {
        return getPoint().getX();
    }

    public double getY() {
        return getPoint().getY();
    }

    public double getZ() {
        return getPoint().getZ();
    }

    public double getW() {
        return getPoint().getW();
    }

    public Col getColor() {
        return color;
    }
}