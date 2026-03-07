package src;

public class Character {
    private String name;
    private int age;
    private double health;
    private double mana;
    private Weapon weapon;
 private Race race;
    private double strength;
    private double dexterity;
    private double constitution;
    private double intelligence;
    private double wisdom;
    private double charisma;

    public Character(String name, int age, Race race, double strength, double dexterity,
            double constitution, double intelligence, double wisdom, double charisma) {
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

   public void setRace(Race race) { this.race = race; }
public Race getRace() { return this.race; }

    public double getHealth() {
        return this.health;
    }

    public double getMana() {
        return this.mana;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public double getStrength() {
        return this.strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getDexterity() {
        return this.dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getConstitution() {
        return this.constitution;
    }

    public void setConstitution(double constitution) {
        this.constitution = constitution;
    }

    public double getIntelligence() {
        return this.intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getWisdom() {
        return this.wisdom;
    }

    public void setWisdom(double wisdom) {
        this.wisdom = wisdom;
    }

    public double getCharisma() {
        return this.charisma;
    }

    public void setCharisma(double charisma) {
        this.charisma = charisma;
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