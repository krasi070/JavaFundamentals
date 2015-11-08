public class Mage extends Character{
    private static final int HIT_POINTS = 180;
    private static final int MAGIC_POINTS = 150;
    private static final int ATTACK_POWER = 15;
    private static final int MAGIC_POWER = 50;
    private static final int DEFENSE_POWER = 5;
    private static final String DEFAULT_NAME = "MAGE";

    public Mage(int hitPoints, int magicPoints, int attackPower,int magicPower, int defensePower, String name) {
        super(hitPoints, magicPoints, attackPower, magicPower, defensePower, name);
    }

    public Mage(String name) {
        this(HIT_POINTS, MAGIC_POINTS, ATTACK_POWER, MAGIC_POWER, DEFENSE_POWER, name);
    }

    public Mage() {
        this(HIT_POINTS, MAGIC_POINTS, ATTACK_POWER, MAGIC_POWER, DEFENSE_POWER, DEFAULT_NAME);
    }

    @Override
    public void tellStory() {
        System.out.println("I am a mage and I want to learn every magic spell in the world!");
    }
}
