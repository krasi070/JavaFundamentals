public class Warrior extends Character {
    private static final int HIT_POINTS = 300;
    private static final int MAGIC_POINTS = 0;
    private static final int ATTACK_POWER = 40;
    private static final int MAGIC_POWER = 0;
    private static final int DEFENSE_POWER = 20;
    private static final String DEFAULT_NAME = "WARRIOR";

    public Warrior(int hitPoints, int magicPoints, int attackPower,int magicPower, int defensePower, String name) {
        super(hitPoints, magicPoints, attackPower, magicPower, defensePower, name);
    }

    public Warrior(String name) {
        this(HIT_POINTS, MAGIC_POINTS, ATTACK_POWER, MAGIC_POWER, DEFENSE_POWER, name);
    }

    public Warrior() {
        this(HIT_POINTS, MAGIC_POINTS, ATTACK_POWER, MAGIC_POWER, DEFENSE_POWER, DEFAULT_NAME);
    }

    @Override
    public void tellStory() {
        System.out.println("I am a warrior who seeks fame and riches!");
    }
}
