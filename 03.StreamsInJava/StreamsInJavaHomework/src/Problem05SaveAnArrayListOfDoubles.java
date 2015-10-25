import java.io.*;
import java.util.ArrayList;

public class Problem05SaveAnArrayListOfDoubles {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        list.add(1.2786358);
        list.add(632653.133);
        list.add(131.31783);
        list.add(0.00000000000001);
        list.add(9999999.0);
        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("doubles.list"))) {
            output.writeObject(list);
            output.flush();
            try (ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream("doubles.list"))) {
                System.out.println(input.readObject());
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("File cannot be read!");
        }
    }
}
