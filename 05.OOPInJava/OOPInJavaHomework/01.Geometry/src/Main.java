import helpful.Vertex2D;
import helpful.Vertex3D;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[6];
        shapes[0] = new Triangle(new Vertex2D(-5, 10), new Vertex2D(25, 30), new Vertex2D(60, 15));
        shapes[1] = new Rectangle(new Vertex2D(1, 1), 15, 20);
        shapes[2] = new Circle(new Vertex2D(10, -12), 10);
        shapes[3] = new SquarePyramid(new Vertex3D(1, 1, 1), 16, 10);
        shapes[4] = new Cuboid(new Vertex3D(0, 0, 0), 1, 2, 2);
        shapes[5] = new Sphere(new Vertex3D(2, 5, -10), 10);

        for (Shape shape : shapes) {
            System.out.println(shape.toString() + "\n");
        }

        System.out.println("SHAPES WITH VOLUME OVER 40:\n");
        Arrays.stream(shapes).
                filter(s -> s instanceof SpaceShape).
                map(s -> (SpaceShape) s).
                filter(s -> s.getVolume() >= 40).
                forEach(s -> System.out.println(s.toString() + "\n"));

        System.out.println("PLANE SHAPES SORTED IN ASCENDING ORDER BY PERIMETER:\n");
        Arrays.stream(shapes).
                filter(s -> s instanceof PlaneShape).
                map(s -> (PlaneShape)s).
                sorted((s1, s2) -> Double.compare(s1.getPerimeter(), s2.getPerimeter())).
                forEach(s -> System.out.println(s.toString() + "\n"));
    }
}
