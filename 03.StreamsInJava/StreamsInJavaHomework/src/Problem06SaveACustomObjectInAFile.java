import java.io.*;

public class Problem06SaveACustomObjectInAFile {
    public static void main(String[] args) {
        class Course implements Serializable {
            public String name;
            public int numberOfStudents;
            public Course (String name, int numberOfStudents) {
                this.name = name;
                this.numberOfStudents = numberOfStudents;
            }
            public void printInfo() {
                System.out.println(name + " " + numberOfStudents);
            }
        }
        try (ObjectOutputStream output = new ObjectOutputStream(
                        new FileOutputStream("course.save"))) {
            output.writeObject(new Course("How to cook?", 13));
            try (ObjectInputStream input = new ObjectInputStream(
                            new FileInputStream("course.save"))) {
                Course printOutput = (Course)input.readObject();
                printOutput.printInfo();
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
