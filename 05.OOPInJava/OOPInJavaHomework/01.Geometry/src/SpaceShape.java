import helpful.Vertex3D;

public abstract class SpaceShape extends Shape implements AreaMesurable, VolumeMesurable {
    public SpaceShape(Vertex3D... vertices) {
        super(vertices);
    }

    public abstract double calculateArea();
    public abstract double calculateVolume();

    public double getArea() {
        return calculateArea();
    }

    public double getVolume() {
        return calculateVolume();
    }

    public abstract String toString();
}
