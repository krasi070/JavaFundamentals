import helpful.Vertex2D;

public abstract class PlaneShape extends Shape implements AreaMesurable, PerimeterMesurable{
    public PlaneShape(Vertex2D... vertices) {
        super(vertices);
    }

    public abstract double calculatePerimeter();
    public abstract double calculateArea();
    
    public double getPerimeter() {
        return calculatePerimeter();
    }
    public double getArea() {
        return calculateArea();
    }

    public abstract String toString();
}
