import helpful.Vertex2D;

import java.util.Locale;

public class Rectangle extends PlaneShape{
    private Vertex2D a;
    private double width;
    private double height;

    public Rectangle(Vertex2D a, double width, double height) {
        super(a);
        this.a = a;
        this.width = width;
        this.height = height;
    }

    public Vertex2D getA() {
        return this.a;
    }

    public void setA(Vertex2D a) {
        this.a = a;
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

    @Override
    public double calculatePerimeter() {
        return this.width * 2 + this.height * 2;
    }

    @Override
    public double calculateArea() {
        return this.width * this.height;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "Shape Type: Rectangle\nA(%d, %d)\nPerimeter: %.2f\nArea: %.2f",
                this.a.getX(), this.a.getY(), this.calculatePerimeter(), this.calculateArea());
    }
}
