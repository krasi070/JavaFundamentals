public class Barbarian extends Character{
    private static final int HIT_POINTS = 375;
    private static final int MAGIC_POINTS = 0;
    private static final int ATTACK_POWER = 50;
    private static final int MAGIC_POWER = 0;
    private static final int DEFENSE_POWER = 10;
    private static final String DEFAULT_NAME = "BARBARIAN";

    public Barbarian(int hitPoints, int magicPoints, int attackPower,int magicPower, int defensePower, String name) {
        super(hitPoints, magicPoints, attackPower, magicPower, defensePower, name);
    }

    public Barbarian(String name) {
        this(HIT_POINTS, MAGIC_POINTS, ATTACK_POWER, MAGIC_POWER, DEFENSE_POWER, name);
    }

    public Barbarian() {
        this(HIT_POINTS, MAGIC_POINTS, ATTACK_POWER, MAGIC_POWER, DEFENSE_POWER, DEFAULT_NAME);
    }

    @Override
    public void tellStory() {
        System.out.println("I'm a barbarian and I'm going to CRUSH everyone who stands in my way!!");
    }
}
