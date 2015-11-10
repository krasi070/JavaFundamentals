package helpful;

public class Vertex3D extends helpful.Vertex{
    private int z;
    public Vertex3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return this.z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
