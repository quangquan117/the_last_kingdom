package utils;

public class map {

    char[] position;
    char[] BunkerPosition;

    // T = base
    // s = Soldier (Player)
    // D = Death Corp (Player)
    // B = Bunker (Player)
    // S = Soldier (Enemy)
    // e = Enfant du chao (Enemy)
    // M = Space Marine du chao (Enemy)
    public map() {
        this.position = new char[22];
        this.BunkerPosition = new char[22];
        for (int i = 0; i < 22; i++) {
            position[i] = ' ';
        }
        position[0] = 'T';
        position[21] = 'T';
        for (int i = 0; i < 22; i++) {
            BunkerPosition[i] = ' ';
        }
    }

    private boolean isPositionEmpty(int position) {
        return this.position[position] == ' ';
    }

    public void addUnit(char unit, boolean isPlayer) {
        if (isPlayer) {
            if (isPositionEmpty(0)) {
                this.position[0] = unit;
            } else {
                System.out.println("No more space");
            }
        } else if (isPositionEmpty(19)) {
            this.position[19] = unit;
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
}
