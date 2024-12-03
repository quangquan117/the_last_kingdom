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

    public void updatePosition(UnitList unitList) {
        for (Unit unit : unitList.getUnitsPlayer()) {
            if (isPositionEmpty(unit.getPosition())) {
                this.position[unit.getPosition()] = switchUnitToChar(unit);
            }
        }
        for (Unit unit : unitList.getUnitsBunker()) {
            if (isPositionEmpty(unit.getPosition())) {
                this.BunkerPosition[unit.getPosition()] = switchUnitToChar(unit);
            }
        }
        for (Unit unit : unitList.getUnitsEnnemy()) {
            if (isPositionEmpty(unit.getPosition())) {
                this.position[unit.getPosition()] = switchUnitToChar(unit);
            }
        }
    }
}
