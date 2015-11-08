public abstract class Character {
    private int hitPoints;
    private int magicPoints;
    private int attackPower;
    private int magicPower;
    private int defensePower;
    private String name;

    public Character(int hitPoints, int magicPoints, int attackPower,int magicPower, int defensePower, String name) {
        this.hitPoints = hitPoints;
        this.magicPoints = magicPoints;
        this.attackPower = attackPower;
        this.magicPower = magicPower;
        this.defensePower = defensePower;
        this.name = name;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getMagicPoints() {
        return this.magicPoints;
    }
    public void setMagicPoints(int magicPoints) {
        this.magicPoints = magicPoints;
    }

    public int getAttackPower() {
        return this.attackPower;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getMagicPower() {
        return  this.magicPower;
    }
    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public int getDefensePower() {
        return this.defensePower;
    }
    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void printStats() {
        System.out.printf("%s:\nHP: %d\nMP: %d\nAttack: %d\nMagic: %d\nDefense: %d\n",
                this.getName().toUpperCase(), this.getHitPoints(), this.getMagicPoints(),
                this.getAttackPower(),this.getMagicPower(), getDefensePower());
    }
    public abstract void tellStory();
}
