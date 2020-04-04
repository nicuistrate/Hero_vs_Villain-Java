public class Planets {
    private String description;
    private int id;
    private float heroAttackModifier;
    private float heroHealthModifier;
    private float villainAttackModifier;
    private float villainHealthModifier;
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getHeroAttackModifier() {
        return heroAttackModifier;
    }

    public void setHeroAttackModifier(float heroAttackModifier) {
        this.heroAttackModifier = heroAttackModifier;
    }

    public float getHeroHealthModifier() {
        return heroHealthModifier;
    }

    public void setHeroHealthModifier(float heroHealthModifier) {
        this.heroHealthModifier = heroHealthModifier;
    }

    public float getVillainAttackModifier() {
        return villainAttackModifier;
    }

    public void setVillainAttackModifier(float villainAttackModifier) {
        this.villainAttackModifier = villainAttackModifier;
    }

    public float getVillainHealthModifier() {
        return villainHealthModifier;
    }

    public void setVillainHealthModifier(float villainHealthModifier) {
        this.villainHealthModifier = villainHealthModifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "\n Planet: \n id=" + id + "\n description=" + description+" \n name= "+name+" \n heroAttackModifier= "+heroAttackModifier+"\n heroHealthModifier= "+heroHealthModifier+"\n villainAttackModifier= "+villainAttackModifier+"\n villainHealthModifier= "+villainHealthModifier+"\n";
    }
}