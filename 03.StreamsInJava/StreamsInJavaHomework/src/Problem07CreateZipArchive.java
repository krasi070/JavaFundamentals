import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Problem07CreateZipArchive {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("words.txt");
        list.add("count-chars.txt");
        list.add("lines.txt");
        try (ZipOutputStream zipOutput = new ZipOutputStream(
                new FileOutputStream("files.zip"))) {
            for (int i = 0; i < list.size(); i++) {
                try (FileInputStream input = new FileInputStream(list.get(i))) {
                    zipOutput.putNextEntry(new ZipEntry(list.get(i)));
                    byte[] buffer = new byte[1024];
                    int currByte = input.read(buffer);
                    while (currByte != -1) {
                        zipOutput.write(buffer);
                        currByte = input.read(buffer);
                    }
                    zipOutput.closeEntry();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("File cannot be read!");
        }
    }
}
