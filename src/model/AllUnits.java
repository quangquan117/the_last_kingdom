package model;

import java.util.ArrayList;

public class AllUnits {

    private final ArrayList<Unit> unitsAlly;
    private final ArrayList<Unit> unitsEnemy;

    public AllUnits() {
        unitsAlly = new ArrayList<>();
        unitsAlly.add(new Unit("Soldat", 100, 50, 2, 0, 10));
        unitsAlly.add(new Unit("Death Corp", 100, 100, 0, 0, 20));
        unitsAlly.add(new Unit("Bunker", 1000, 100, 5, 2, 100));
        unitsAlly.add(new Unit("Space Marine", 1000, 500, 50, 0, 500));
        unitsAlly.add(new Unit("Dreadnaute", 2000, 1000, 1000, 0, 1000));
        unitsAlly.add(new Unit("Char Predator", 5000, 2000, 1500, 0, 2000));
        unitsEnemy = new ArrayList<>();
        unitsEnemy.add(new Unit("Soldat corompu", 100, 34, 0, 21, 5));
        unitsEnemy.add(new Unit("Enfant du chao", 500, 50, 10, 21, 10));
        unitsEnemy.add(new Unit("Space Marine du chao", 1000, 100, 30, 21, 50));
        unitsEnemy.add(new Unit("demon du chao", 2000, 1000, 0, 21, 250));
        unitsEnemy.add(new Unit("Dreadnaute du Chao", 2000, 1000, 500, 21, 500));
        unitsEnemy.add(new Unit("Demon Majeur du Chao", 5000, 15000, 1000, 21, 1000));
    }

    public Unit getNewUnitAlly(String name) {
        for (Unit unit : unitsAlly) {
            if (unit.getNom().equals(name)) {
                return new Unit(unit.getNom(), unit.getPV(), unit.getAttaque(), unit.getDefense(), unit.getPosition(), unit.getPrix());
            }
        }
        return null;
    }

    public Unit getNewUnitEnemy(String name) {
        for (Unit unit : unitsEnemy) {
            if (unit.getNom().equals(name)) {
                return new Unit(unit.getNom(), unit.getPV(), unit.getAttaque(), unit.getDefense(), unit.getPosition(), unit.getPrix());
            }
        }
        return null;
    }
}
