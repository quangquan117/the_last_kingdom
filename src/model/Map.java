package model;

public class Map {

    char[] position;
    char[] BunkerPosition;

    // B = base
    private char switchUnitToChar(Unit unit) {
        switch (unit.getNom()) {
            case "Soldat":
                return 's';
            case "Death Corp":
                return 'd';
            case "Bunker":
                return 'b';
            case "Space Marine":
                return 'S';
            case "Dreadnaute":
                return 'D';
            case "Char Predator":
                return 'C';
            case "Soldat corompu":
                return 'c';
            case "Enfant du chao":
                return 'e';
            case "Space Marine du chao":
                return 'm';
            case "demon du chao":
                return 'A';
            case "Dreadnaute du Chao":
                return 'R';
            case "Demon Majeur du Chao":
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
        position[0] = 'B';
        position[21] = 'B';
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
        for (int i = 1; i < 21; i++) {
            this.position[i] = ' ';
        }
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
