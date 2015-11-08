import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select a character class:\n1.Warrior\n2.Mage\n3.Thief\n4.Barbarian\n5.Assassin\n6.Druid");
        System.out.print("Enter class name or number: ");
        String input = scan.nextLine().toLowerCase();
        if (input.equals("one") || input.equals("1") || input.equals("warrior")) {
            Character character = new Warrior();
            nameCharacter(character);
            character.printStats();
            character.tellStory();
        } else if (input.equals("two") || input.equals("2") || input.equals("mage")) {
            Character character = new Mage();
            nameCharacter(character);
            character.printStats();
            character.tellStory();
        } else if (input.equals("three") || input.equals("3") || input.equals("thief")) {
            Character character = new Thief();
            nameCharacter(character);
            character.printStats();
            character.tellStory();
        } else if (input.equals("four") || input.equals("4") || input.equals("barbarian")) {
            Character character = new Barbarian();
            nameCharacter(character);
            character.printStats();
            character.tellStory();
        } else if (input.equals("five") || input.equals("5") || input.equals("assassin")) {
            Character character = new Assassin();
            nameCharacter(character);
            character.printStats();
            character.tellStory();
        } else if (input.equals("six") || input.equals("6") || input.equals("druid")) {
            Character character = new Druid();
            nameCharacter(character);
            character.printStats();
            character.tellStory();
        } else {
            System.out.println("You didn't choose a character class!");
        }
    }
    public static void nameCharacter(Character character) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scan.nextLine();
        character.setName(name);
    }
}
