package model;

import java.util.ArrayList;

public class Map {

    char[] position;
    char[] BunkerPosition;

    // b = base
    // s = Soldier (Player)
    // D = Death Corp (Player)
    // B = Bunker (Player)
    // S = Soldier (Enemy)
    // e = Enfant du chao (Enemy)
    // M = Space Marine du chao (Enemy)
    private char switchUnitToChar(Unit unit) {
        switch (unit.getNom()) {
            case "Soldat":
                return 's';
            case "Death Corp":
                return 'D';
            case "Bunker":
                return 'B';
            case "Soldat corompu":
                return 'S';
            case "Enfant du chao":
                return 'e';
            case "Space Marine du chao":
                return 'M';
            default:
                return ' ';
        }
    }

    public Map() {
        this.position = new char[22];
        this.BunkerPosition = new char[22];

        for (int i = 0; i < 22; i++) {
            position[i] = ' ';
        }
        position[0] = 'b';
        position[21] = 'b';
        for (int i = 0; i < 22; i++) {
            this.BunkerPosition[i] = ' ';
        }
    }

    public char[] getPosition() {
        return position;
    }

    public char[] getBunkerPosition() {
        return BunkerPosition;
    }

    private boolean isPositionEmpty(int position) {
        return this.position[position] == ' ';
    }

    public void addUnit(Unit unit, boolean isPlayer) {
        if (isPlayer) {
            if (isPositionEmpty(1)) {
this.position[0] = switchUnitToChar(unit);
            } else {
                System.out.println("No more space");
            }
        } else if (isPositionEmpty(19)) {
            this.position[19] = switchUnitToChar(unit);
        }
    }

    public void addBunker() {
        boolean isBunker = false;
        for (int i = 1; i < 22; i += 2) {
            if (BunkerPosition[i] == ' ') {
                BunkerPosition[i] = 'B';
                isBunker = true;
                break;
            }
        }
        if (!isBunker) {
            System.out.println("No more space");
        }
    }

    public void moveUnit(ArrayList<Unit> unitsPlayer, ArrayList<Unit> unitsEnemy, Base basePlayer, Base baseEnemy) {
        for (int i = 0; i < 22; i++) {
            if (position[i] == 's' || position[i] == 'D' || position[i] == 'B') {
                if (isPositionEmpty(i + 1)) {
                    position[i + 1] = position[i];
                    position[i] = ' ';
                } else if (position[i + 1] == 'S' || position[i + 1] == 'e' || position[i + 1] == 'M') {
                    unitsEnemy.get(0).takeDamage(unitsPlayer.get(0).getAttaque());
                    if (unitsEnemy.get(0).getPV() <= 0) {
                        position[i + 1] = position[i];
                        position[i] = ' ';
                        unitsEnemy.remove(0);
                    }
                } else if (position[i + 1] == 'b') {
                    baseEnemy.takeDamage(unitsPlayer.get(0).getAttaque());
                }
            } else if (position[i] == 'S' || position[i] == 'e' || position[i] == 'M') {
                if (isPositionEmpty(i)) {
                    position[i - 1] = position[i];
                    position[i] = ' ';
                } else if (position[i - 1] == 's' || position[i - 1] == 'D' || position[i - 1] == 'B') {
                    unitsPlayer.get(0).takeDamage(unitsEnemy.get(0).getAttaque());
                    if (unitsPlayer.get(0).getPV() <= 0) {
                        position[i - 1] = position[i];
                        position[i] = ' ';
                        unitsPlayer.remove(0);
                    }
                } else if (position[i - 1] == 'b') {
                    basePlayer.takeDamage(unitsEnemy.get(0).getAttaque());
                }
            }
        }
    }
}
