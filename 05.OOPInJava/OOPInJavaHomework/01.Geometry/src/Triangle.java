import helpful.Vertex2D;

import java.util.Locale;

public class Triangle extends PlaneShape {
    private Vertex2D a;
    private Vertex2D b;
    private Vertex2D c;

    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        super(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Vertex2D getA() {
        return this.a;
    }

    public void setA(Vertex2D a) {
        this.a = a;
    }

    public Vertex2D getB() {
        return this.b;
    }

    public void setB(Vertex2D b) {
        this.b = b;
    }

    public Vertex2D getC() {
        return this.c;
    }

    public void setC(Vertex2D c) {
        this.c = c;
    }

    @Override
    public double calculatePerimeter() {
        double sideA = Math.sqrt(Math.pow(this.c.getX() - this.b.getX(), 2) + Math.pow(this.c.getY() - this.b.getY(), 2));
        double sideB = Math.sqrt(Math.pow(this.a.getX() - this.c.getX(), 2) + Math.pow(this.a.getY() - this.c.getY(), 2));
        double sideC = Math.sqrt(Math.pow(this.a.getX() - this.b.getX(), 2) + Math.pow(this.a.getY() - this.b.getY(), 2));
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        return Math.abs((this.a.getX() * (this.b.getY() - this.c.getY()) +
                this.b.getX() * (this.c.getY() - this.a.getY()) +
                this.c.getX() * (this.a.getY() - this.b.getY())) / 2);
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "Shape Type: Triangle\nA(%d, %d)\nB(%d, %d)\nC(%d, %d)\nPerimeter: %.2f\nArea: %.2f",
                this.a.getX(), this.a.getY(), this.b.getX(), this.getB().getY(), this.c.getX(), this.c.getY(), this.calculatePerimeter(), this.calculateArea());
    }
}
