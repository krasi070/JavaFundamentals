public class Druid extends Character{
    private static final int HIT_POINTS = 200;
    private static final int MAGIC_POINTS = 110;
    private static final int ATTACK_POWER = 20;
    private static final int MAGIC_POWER = 40;
    private static final int DEFENSE_POWER = 10;
    private static final String DEFAULT_NAME = "DRUID";

    public Druid(int hitPoints, int magicPoints, int attackPower,int magicPower, int defensePower, String name) {
        super(hitPoints, magicPoints, attackPower, magicPower, defensePower, name);
    }

    public Druid(String name) {
        this(HIT_POINTS, MAGIC_POINTS, ATTACK_POWER, MAGIC_POWER, DEFENSE_POWER, name);
    }

    public Druid() {
        this(HIT_POINTS, MAGIC_POINTS, ATTACK_POWER, MAGIC_POWER, DEFENSE_POWER, DEFAULT_NAME);
    }

    @Override
    public void tellStory() {
        System.out.println("I am a druid and I will protect nature from anyone who destroys it!");
    }
}
