public class Circle {

    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    public double getRadius() {
        if (this.radius > 0) {
            return this.radius;
        } else {
            return 0.0;
        }
    }
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 0.0;
        }
    }

    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(double radius) {
        return radius * radius * Math.PI;
    }

    public void printCircle() {
        System.out.printf("Radius: %.2f\nColor: %s\nArea: %.2f\n",
                this.getRadius(), this.getColor(), this.getArea(this.getRadius()));
    }
}
