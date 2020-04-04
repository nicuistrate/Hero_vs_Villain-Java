public class Characters {
    private float attack;
    private String description;
    private float health;
    private int id;
    private Boolean isVillain;
    private String name;

    public Boolean getVillain() {
        return isVillain;
    }

    public void setVillain(Boolean villain) {
        isVillain = villain;
    }

    public float getAttack() {
        return attack;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "\n Character: \n id=" + id + "\n description=" + description+" \n name= "+name+" \n Attack= "+ attack+"\n Health= "+health+"\n isvillain= "+isVillain+"\n";
    }
}
