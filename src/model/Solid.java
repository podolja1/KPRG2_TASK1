package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Solid {

    protected final ArrayList<Vertex> vertexBuffer = new ArrayList<>();
    protected final ArrayList<Integer> indexBuffer = new ArrayList<>();
    protected final ArrayList<Part> partBuffer = new ArrayList<>();

    public List<Vertex> getVertexBuffer() {
        return vertexBuffer;
    }
    public List<Integer> getIndexBuffer() {
        return indexBuffer;
    }
    public List<Part> getPartBuffer() {
        return partBuffer;
    }
}
