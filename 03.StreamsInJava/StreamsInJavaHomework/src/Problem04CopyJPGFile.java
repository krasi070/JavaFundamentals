import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Problem04CopyJPGFile {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("Napstablook.jpg")) {
            try (FileOutputStream output = new FileOutputStream("my-copied-picture.jpg")) {
                byte[] buffer = new byte[1024];
                int currByte = input.read(buffer);
                while (currByte != -1) {
                    output.write(buffer);
                    currByte = input.read(buffer);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("File cannot be read!");
        }
    }
}
