import java.io.*;
import java.util.ArrayList;

public class Problem02AllCapitals {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("other-lines.txt"))) {
            ArrayList<String> list = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                list.add(line.toUpperCase());
                line = reader.readLine();
            }
            try (PrintWriter writer = new PrintWriter(
                    new FileWriter("other-lines.txt"))) {
                for (int i = 0; i < list.size(); i++) {
                    writer.println(list.get(i));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("File cannot be read!");
        }
    }
}
