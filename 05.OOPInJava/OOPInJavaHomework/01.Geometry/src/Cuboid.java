import helpful.Vertex3D;

import java.util.Locale;

public class Cuboid extends SpaceShape{
    private Vertex3D vertex;
    private double width;
    private double height;
    private double depth;

    public Cuboid(Vertex3D vertex, double width, double height, double depth) {
        super(vertex);
        this.vertex = vertex;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Vertex3D getVertex() {
        return this.vertex;
    }

    public void setVertex(Vertex3D vertex) {
        this.vertex = vertex;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDepth() {
        return this.depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    @Override
    public double calculateArea() {
        return 2 * (this.width + this.height + this.depth);
    }

    @Override
    public double calculateVolume() {
        return this.width * this.height * this.depth;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "Shape Type: Cuboid\nA(%d, %d, %d)\nArea: %.2f\nVolume: %.2f",
                this.vertex.getX(), this.vertex.getY(), this.vertex.getZ(), this.calculateArea(), this.calculateVolume());
    }
}
