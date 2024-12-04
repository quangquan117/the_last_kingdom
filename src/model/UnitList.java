package model;

import java.util.ArrayList;

public class UnitList {

    ArrayList<Unit> unitsPlayer;
    ArrayList<Unit> unitsBunker;
    ArrayList<Unit> unitsEnnemy;

    public UnitList() {
        unitsPlayer = new ArrayList<>();
        unitsBunker = new ArrayList<>();
        unitsEnnemy = new ArrayList<>();
    }

    public ArrayList<Unit> getUnitsPlayer() {
        return unitsPlayer;
    }

    public void addunitPlayer(Unit unit) {
        unitsPlayer.add(unit);
    }

    public void removeUnitPlayer(Unit unit) {
        unitsPlayer.remove(unit);
    }

    public ArrayList<Unit> getUnitsBunker() {
        return unitsBunker;
    }

    public void addunitBunker(Unit unit) {
        unitsBunker.add(unit);
    }

    public void removeUnitBunker(Unit unit) {
        unitsBunker.remove(unit);
    }

    public ArrayList<Unit> getUnitsEnnemy() {
        return unitsEnnemy;
    }

    public void addunitEnnemy(Unit unit) {
        unitsEnnemy.add(unit);
    }

    public void removeUnitEnnemy(Unit unit) {
        unitsEnnemy.remove(unit);
    }

    public boolean isUnitEnnemy() {
        return unitsEnnemy.isEmpty();
    }

    public void moveUnits(Base basePlayer, Base baseEnnemy) {
        int tempostion = 0;
        for (Unit unit : unitsPlayer) {
            if (!unitsEnnemy.isEmpty() && unit.getPosition() + 1 == unitsEnnemy.get(0).getPosition()) {
                unitsEnnemy.get(0).takeDamage(unit.getAttaque());
                if (unitsEnnemy.get(0).getPV() <= 0) {
                    unitsEnnemy.remove(0);
                    basePlayer.setMoney(basePlayer.getMoney() + unitsEnnemy.get(0).getPrix());
                }
            } else if (unit.getPosition() + 1 == 22) {
                baseEnnemy.takeDamage(unit.getAttaque());
                unitsPlayer.remove(0);
            } else if (unit.getPosition() + 1 == tempostion) {
                unit.setPosition(unit.getPosition());
            } else {
                unit.setPosition(unit.getPosition() + 1);
            }
            if (unitsPlayer.isEmpty()) {
                break;
            }
        }
        tempostion = 22;
        for (Unit unit : unitsEnnemy) {
            if (!unitsPlayer.isEmpty() && unit.getPosition() - 1 == unitsPlayer.get(0).getPosition()) {
                unitsPlayer.get(0).takeDamage(unit.getAttaque());
                if (unitsPlayer.get(0).getPV() <= 0) {
                    unitsPlayer.remove(0);
                }
            } else if (unit.getPosition() - 1 == 0) {
                basePlayer.takeDamage(unit.getAttaque());
                unitsEnnemy.remove(0);
            } else if (unit.getPosition() - 1 == tempostion) {
                unit.setPosition(unit.getPosition());
            } else {
                unit.setPosition(unit.getPosition() - 1);
            }
            if (unitsEnnemy.isEmpty()) {
                break;
            }
        }
    }
}
