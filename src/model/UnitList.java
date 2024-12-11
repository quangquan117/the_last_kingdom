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

    private int attaque(int attaque, ArrayList<Unit> units, Base base) {
        int argent = 0;
        int unitsSize = units.size();
        int random = (int) (Math.random() * (unitsSize < 3 ? unitsSize : 3));
        int degats;
        degats = attaque - units.get(random).getDefense();
        units.get(random).takeDamage(degats < 10 ? 10 : degats);
        if (units.get(random).getPV() <= 0) {
            argent = units.get(random).getPrix();
            units.remove(random);
        }
        return argent;
    }

    public void moveUnits(Base basePlayer, Base baseEnnemy) {
        int tempostion = 0;
        for (int i = 0; i < unitsPlayer.size(); i++) {
            if (!unitsEnnemy.isEmpty() && unitsPlayer.get(i).getPosition() + 1 == unitsEnnemy.get(0).getPosition()) {
                basePlayer.addMoney(attaque(unitsPlayer.get(i).getAttaque(), unitsEnnemy, baseEnnemy));
            } else if (unitsPlayer.get(i).getPosition() + 1 == 22) {
                baseEnnemy.takeDamage(unitsPlayer.get(i).getAttaque());
                unitsPlayer.remove(i);
                i--;
            } else if (unitsPlayer.get(i).getPosition() + 1 == tempostion) {
                unitsPlayer.get(i).setPosition(unitsPlayer.get(i).getPosition());
            } else if (!unitsPlayer.get(i).getNom().equals("Bunker")) {
                unitsPlayer.get(i).setPosition(unitsPlayer.get(i).getPosition() + 1);
            }
            if (unitsPlayer.isEmpty()) {
                break;
            }
        }
        tempostion = 22;
        for (int i = 0; i < unitsEnnemy.size(); i++) {
            if (!unitsPlayer.isEmpty() && unitsEnnemy.get(i).getPosition() - 1 == unitsPlayer.get(0).getPosition()) {
                attaque(unitsEnnemy.get(i).getAttaque(), unitsPlayer, basePlayer);
            } else if (unitsEnnemy.get(i).getPosition() - 1 == 0) {
                basePlayer.takeDamage(unitsEnnemy.get(i).getAttaque());
                unitsEnnemy.remove(i);
                i--;
            } else {
                unitsEnnemy.get(i).setPosition(unitsEnnemy.get(i).getPosition() - 1);
            }
            if (unitsEnnemy.isEmpty()) {
                break;
            }
        }
    }
}
