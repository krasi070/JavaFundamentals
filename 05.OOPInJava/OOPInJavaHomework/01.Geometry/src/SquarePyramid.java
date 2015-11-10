import helpful.Vertex3D;

import java.util.Locale;

public class SquarePyramid extends SpaceShape{
    private Vertex3D baseCenter;
    private double baseWidth;
    private double pyramidHeight;

    public SquarePyramid(Vertex3D baseCenter, double baseWidth, double pyramidHeight) {
        super(baseCenter);
        this.baseCenter = baseCenter;
        this.baseWidth = baseWidth;
        this.pyramidHeight = pyramidHeight;
    }

    public Vertex3D getBaseCenter() {
        return this.baseCenter;
    }

    public void setBaseCenter(Vertex3D baseCenter) {
        this.baseCenter = baseCenter;
    }

    public double getBaseWidth() {
        return this.baseWidth;
    }

    public void setBaseWidth(double baseWidth) {
        this.baseWidth = baseWidth;
    }

    public double getPyramidHeight() {
        return this.pyramidHeight;
    }

    public void setPyramidHeight(double pyramidHeight) {
        this.pyramidHeight = pyramidHeight;
    }

    @Override
    public double calculateArea() {
        return this.baseWidth * this.baseWidth +
                2 * this.baseWidth * Math.sqrt((this.baseWidth * this.baseWidth / 4) + this.pyramidHeight * this.pyramidHeight);
    }

    @Override
    public double calculateVolume() {
        return this.baseWidth * this.baseWidth * this.pyramidHeight / 3;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "Shape Type: Square Pyramid\nBase Center(%d, %d, %d)\nArea: %.2f\nVolume: %.2f",
                this.baseCenter.getX(), this.baseCenter.getY(), this.baseCenter.getZ(), this.calculateArea(), this.calculateVolume());
    }
}
