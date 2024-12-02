package model;

import java.util.ArrayList;

public class AllUnits {

    private final ArrayList<Unit> unitsAlly;
    private final ArrayList<Unit> unitsEnemy;

    public AllUnits() {
        unitsAlly = new ArrayList<>();
        unitsAlly.add(new Unit("Soldat", 100, 50, 2, 0, 10));
        unitsAlly.add(new Unit("Death Corp", 100, 100, 0, 0, 20));
        unitsAlly.add(new Unit("Bunker", 1000, 100, 5, 0, 100));
        unitsEnemy = new ArrayList<>();
        unitsEnemy.add(new Unit("Soldat corompu", 100, 34, 0, 0, 0));
        unitsEnemy.add(new Unit("Enfant du chao", 500, 50, 10, 0, 0));
        unitsEnemy.add(new Unit("Space Marine du chao", 1000, 100, 30, 0, 0));
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
