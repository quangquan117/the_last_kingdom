package metier;

import java.util.ArrayList;
import model.AllUnits;
import model.Base;
import model.Map;
import model.Unit;
import utils.menus;

public class App {

    private static void game(int nbVague, int eachTrun) {
        int actual_vague = 0;
        AllUnits allUnits = new AllUnits();
        ArrayList<Unit> unitsPlayer = new ArrayList<>();
        ArrayList<Unit> unitsEnnemy = new ArrayList<>();
        int turn = 0;
        Base PlayBase = new Base(100, true, 1000);
        Base EnnemyBase = new Base(100, false, 1000);
        Map map = new Map();
        do {
            // player turn

            // move map
            map.moveUnit();
            // attack turn

            turn++;
        } while (PlayBase.isAlive() && EnnemyBase.isAlive() && actual_vague < nbVague);
    }

    public static void gameSet(int difficulty) {
        int nbVague;
        int eachTrun;

        switch (difficulty) {
            case 1:
                nbVague = 3;
                eachTrun = 10;
                break;
            case 2:
                nbVague = 5;
                eachTrun = 7;
                break;
            default:
                nbVague = 10;
                eachTrun = 5;
                break;
        }

        game(nbVague, eachTrun);
    }

    public static void main(String[] args) {
        menus.mainMenu1();
    }
}
