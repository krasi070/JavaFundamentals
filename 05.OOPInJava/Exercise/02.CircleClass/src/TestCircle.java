import java.util.Scanner;

public class TestCircle {
    public static void main(String args[]) {
        Circle defaultCircle = new Circle();
        Circle orangeCircle = new Circle(3.5, "orange");
        Circle inputCircle = new Circle();
        Scanner scan = new Scanner(System.in);
        System.out.print("Radius = ");
        double radius = Double.parseDouble(scan.nextLine());
        System.out.print("Color: ");
        String color = scan.nextLine();

        inputCircle.setRadius(radius);
        inputCircle.setColor(color);

        System.out.println("DEFAULT CIRCLE:");
        defaultCircle.printCircle();
        System.out.println("ORANGE CIRCLE:");
        orangeCircle.printCircle();
        System.out.println("INPUT CIRCLE: ");
        inputCircle.printCircle();
    }
}
