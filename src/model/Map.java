package model;

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

    public boolean addUnit(Unit unit, boolean isPlayer) {
        if (isPlayer) {
            if (isPositionEmpty(0)) {
                this.position[0] = switchUnitToChar(unit);
                unit.setPosition(0);
                return true;
            } else {
                System.out.println("No more space");
                return false;
            }
        } else {
            if (isPositionEmpty(19)) {
                this.position[19] = switchUnitToChar(unit);
                unit.setPosition(19);
                return true;
            } else {
                return false;
            }
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

    public void moveUnit() {
        for (int i = 0; i < 22; i++) {
            if (position[i] == 's' || position[i] == 'D' || position[i] == 'B') {
                if (isPositionEmpty(i + 1)) {
                    position[i + 1] = position[i];
                    position[i] = ' ';
                }
            } else if (position[i] == 'S' || position[i] == 'e' || position[i] == 'M') {
                if (isPositionEmpty(i)) {
                    position[i - 1] = position[i];
                    position[i] = ' ';
                }
            }
        }
    }
}
