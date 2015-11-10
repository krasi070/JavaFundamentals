import helpful.Vertex2D;

import java.util.Locale;

public class Circle extends PlaneShape{
    private Vertex2D o;
    private double radius;

    public Circle(Vertex2D o, double radius) {
        super(o);
        this.o = o;
        this.radius = radius;
    }

    public Vertex2D getA() {
        return this.o;
    }

    public void setA(Vertex2D o) {
        this.o = o;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return this.getRadius() * 2 * Math.PI;
    }

    @Override
    public double calculateArea() {
        return this.getRadius() * this.getRadius() * Math.PI;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "Shape Type: Circle\nO(%d, %d)\nPerimeter: %.2f\nArea: %.2f",
                this.o.getX(), this.o.getY(), this.calculatePerimeter(), this.calculateArea());
    }
}
