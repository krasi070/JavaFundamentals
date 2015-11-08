public class Thief extends Character {
    private static final int HIT_POINTS = 220;
    private static final int MAGIC_POINTS = 50;
    private static final int ATTACK_POWER = 25;
    private static final int MAGIC_POWER = 30;
    private static final int DEFENSE_POWER = 10;
    private static final String DEFAULT_NAME = "THIEF";

    public Thief(int hitPoints, int magicPoints, int attackPower,int magicPower, int defensePower, String name) {
        super(hitPoints, magicPoints, attackPower, magicPower, defensePower, name);
    }

    public Thief(String name) {
        this(HIT_POINTS, MAGIC_POINTS, ATTACK_POWER, MAGIC_POWER, DEFENSE_POWER, name);
    }

    public Thief() {
        this(HIT_POINTS, MAGIC_POINTS, ATTACK_POWER, MAGIC_POWER, DEFENSE_POWER, DEFAULT_NAME);
    }

    @Override
    public void tellStory() {
        System.out.println("I am a thief and I want to steal this village's riches!");
    }
}
