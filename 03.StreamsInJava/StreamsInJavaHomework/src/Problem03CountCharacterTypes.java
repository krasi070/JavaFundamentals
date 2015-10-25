import java.io.*;

public class Problem03CountCharacterTypes {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("words.txt"))) {
            try (PrintWriter writer = new PrintWriter(
                    new FileWriter("count-chars.txt"))){
                String line = reader.readLine().toLowerCase();
                int vowels = 0;
                int consonants = 0;
                int punctuation = 0;
                while (line != null) {
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) >= 97 && line.charAt(i) <= 122) {
                            if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'o' ||
                                    line.charAt(i) == 'i' || line.charAt(i) == 'u') {
                                vowels++;
                            } else {
                                consonants++;
                            }
                        } else if (line.charAt(i) == '.' || line.charAt(i) == '!' ||
                                line.charAt(i) == '?' || line.charAt(i) == ',') {
                            punctuation++;
                        }
                    }
                    line = reader.readLine();
                }
                writer.println("vowels: " + vowels);
                writer.println("consonants: " + consonants);
                writer.println("punctuation: " + punctuation);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("File cannot be read!");
        }
    }
}
