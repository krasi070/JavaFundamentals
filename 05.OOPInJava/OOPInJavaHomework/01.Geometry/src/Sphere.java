import helpful.Vertex3D;

import java.util.Locale;

public class Sphere extends SpaceShape {
    private Vertex3D vertex;
    private double radius;

    public Sphere(Vertex3D vertex, double radius) {
        super(vertex);
        this.vertex = vertex;
        this.radius = radius;
    }

    public Vertex3D getVertex() {
        return this.vertex;
    }

    public void setVertex(Vertex3D vertex) {
        this.vertex = vertex;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 4 * Math.PI * this.radius * this.radius;
    }

    @Override
    public double calculateVolume() {
        return 4 * Math.PI * this.radius * this.radius * this.radius / 3;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "Shape Type: Sphere\nO(%d, %d, %d)\nArea: %.2f\nVolume: %.2f",
                this.vertex.getX(), this.vertex.getY(), this.vertex.getZ(), this.calculateArea(), this.calculateVolume());
    }
}