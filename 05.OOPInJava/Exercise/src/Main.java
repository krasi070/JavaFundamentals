public class Main {
    public static void main(String[] args) {

        GameCharacter lesserDog = new Warrior("Lesser Dog");
        GameCharacter madjick = new Mage("Madjick");

        int roundCount = 1;

        while (true) {
            System.out.println("ROUND: " + roundCount);
            try {
                if (roundCount % 2 == 1) {
                    lesserDog.attack(madjick);
                    madjick.attack(lesserDog);
                } else {
                    madjick.attack(lesserDog);
                    lesserDog.attack(madjick);
                }
            } catch (OutOfEnergyException e) {
                System.out.println(e.getMessage());
                break;
            }
            System.out.println();
            roundCount++;
        }

        if (lesserDog.getHealth() > madjick.getHealth()) {
            System.out.println(lesserDog.getName().toUpperCase() + " HAS WON THE BATTLE!");
        } else {
            System.out.println(madjick.getName().toUpperCase() + " HAS WON THE BATTLE!");
        }
    }
}
