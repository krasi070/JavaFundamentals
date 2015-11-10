import helpful.Vertex;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
    private List<Vertex> vertices;

    public Shape(Vertex... vertices) {
        this.vertices = new ArrayList<>();
        addVertex(vertices);
    }

    public List<Vertex> getVertices() {
        return this.vertices;
    }

    public void addVertex(Vertex[] vertices) {
        for (Vertex vertex : vertices) {
            this.vertices.add(vertex);
        }
    }

    public void addVertex(Vertex vertex) {
        this.vertices.add(vertex);
    }

    @Override
    public abstract String toString();
}
