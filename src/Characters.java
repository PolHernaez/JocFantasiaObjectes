package src;

public class Characters {
    private String name;
    private int age;
    private double health;
    private int mana;
    private Weapons weapon;
    private String race;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public Characters(String name, int age, String race, int strength, int dexterity,
            int constitution, int intelligence, int wisdom, int charisma) {
        this.name = name;
        this.age = age;
        this.race = race;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.health = constitution * 50;
        this.mana = intelligence * 30;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRace() {
        return this.race;
    }

    public double getHealth() {
        return this.health;
    }

    public int getMana() {
        return this.mana;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Weapons getWeapon() {
        return this.weapon;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getConstitution() {
        return this.constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getWisdom() {
        return this.wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getCharisma() {
        return this.charisma;
    }

    public String toString() {
        String info = "Nom: " + this.name + " Edat: " + this.age + " Raça: " + this.race +
                " Salut: " + this.health + " Manà: " + this.mana +
                " Arma: " + this.weapon + " Força: " + this.strength +
                " Destresa: " + this.dexterity + " Constitució: " + this.constitution +
                " Intel·ligència: " + this.intelligence + " Saviesa: " + this.wisdom +
                " Carisma: " + this.charisma;
        return info;
    }
}