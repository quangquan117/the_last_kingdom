package model;

public class Unit {

    private String Nom;
    private int PV;
    private int attaque;
    private int defense;
    private int position;
    private int prix;

    public Unit(String nom, int pV, int attaque, int defense, int position, int prix) {
        this.Nom = nom;
        this.PV = pV;
        this.attaque = attaque;
        this.defense = defense;
        this.position = position;
        this.prix = prix;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getPV() {
        return PV;
    }

    public void setPV(int pV) {
        PV = pV;
    }

    public void takeDamage(int damage) {
        this.PV -= damage;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
