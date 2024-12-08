package metier;

import java.util.ArrayList;
import model.AllUnits;
import model.Base;
import model.Map;
import model.Unit;
import model.UnitList;
import utils.menus;

public class App {

    private static boolean shop(AllUnits allUnits, UnitList unitList, Base basePlayer) {
        boolean actionValide = false;
        String reponse;
        do {
            // display shop
            reponse = menus.demandeSaisie("--Acheter une unité--\n 1. Soldat : 10\n 2. Death Corp : 20\n 3. Bunker : 100\n --Menus--\n 4. passer le tour\n 5. Quitter");
            // if buy unit
            if (reponse.equals("1") || reponse.equals("2") || reponse.equals("3")) {
                Unit unit = null;
                switch (reponse) {
                    case "1":
                        unit = allUnits.getNewUnitAlly("Soldat");
                        break;
                    case "2":
                        unit = allUnits.getNewUnitAlly("Death Corp");
                        break;
                    case "3":
                        unit = allUnits.getNewUnitAlly("Bunker");
                        break;
                }
                if (unit != null) {
                    if (unit.getPrix() <= basePlayer.getMoney()) {
                        basePlayer.setMoney(basePlayer.getMoney() - unit.getPrix());
                        unitList.addunitPlayer(unit);
                        actionValide = true;
                    } else {
                        System.out.println("Vous n'avez pas assez d'argent");
                    }
                }
            } else if (reponse.equals("5")) {
                return false;
            } else if (reponse.equals("4")) {
                actionValide = true;
            }
        } while (!actionValide);
        return true;
    }

    private static ArrayList<Unit> createVague(int nbVague, AllUnits allUnits) {
        ArrayList<Unit> Vague = new ArrayList<>();
        for (int i = 0; i < nbVague; i++) {
            int random = (int) (Math.random() * 3);
            switch (random) {
                case 0:
                    Vague.add(allUnits.getNewUnitEnemy("Soldat corompu"));
                    break;
                case 1:
                    Vague.add(allUnits.getNewUnitEnemy("Enfant du chao"));
                    break;
                case 2:
                    Vague.add(allUnits.getNewUnitEnemy("Space Marine du chao"));
                    break;
            }
        }
        return Vague;
    }

    private static void game(int nbVague, int eachTrun) {
        int actual_vague = 0;
        AllUnits allUnits = new AllUnits();

        int turn = 0;
        Base PlayBase = new Base(100, true, 1000);
        Base EnnemyBase = new Base(100, false, 0);
        UnitList unitList = new UnitList();
        Map map = new Map();
        boolean switchOnOff;
        ArrayList<Unit> Vague = createVague(nbVague, allUnits);
        do {
            // display map
            menus.printMap(map.getPosition(), map.getBunkerPosition(), unitList, PlayBase, EnnemyBase);
            // player turn
            switchOnOff = shop(allUnits, unitList, PlayBase);
            // add enemy unit
            if (turn % eachTrun == 0 && actual_vague < nbVague) {
                unitList.addunitEnnemy(Vague.get(actual_vague));
                actual_vague++;
            }
            // move units
            map.updatePosition(unitList);
            unitList.moveUnits(PlayBase, EnnemyBase);
            turn++;
        } while (PlayBase.isAlive() && EnnemyBase.isAlive() && (actual_vague < nbVague && !unitList.isUnitEnnemy()) && switchOnOff);
        if (PlayBase.isAlive()) {
            System.out.println("Vous avez gagné!!!\n");
        } else {
            System.out.println("Vous avez perdu!!!\n");
        }
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
