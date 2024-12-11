package metier;

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
            reponse = menus.demandeSaisie("--Acheter une unité--\n 1. Soldat : 10\n 2. Death Corp : 20\n 3. Bunker : 100\n 4. Space Marine : 500\n 5. Dreadnaute : 1000\n 6. Char Predator : 2000\n 7. Passer le tour\n 8. Quitter\n");
            // if buy unit
            if (reponse.equals("1") || reponse.equals("2") || reponse.equals("3") || reponse.equals("4") || reponse.equals("5") || reponse.equals("6")) {
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
                    case "4":
                        unit = allUnits.getNewUnitAlly("Space Marine");
                        break;
                    case "5":
                        unit = allUnits.getNewUnitAlly("Dreadnaute");
                        break;
                    case "6":
                        unit = allUnits.getNewUnitAlly("Char Predator");
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
            } else if (reponse.equals("8")) {
                return false;
            } else if (reponse.equals("7")) {
                actionValide = true;
            }
        } while (!actionValide);
        return true;
    }

    private static Unit createVague(int actual_vague, AllUnits allUnits) {
        int random;

        if (actual_vague > 6) {
            actual_vague = 6;
        }
        random = (int) (Math.random() * actual_vague);
        switch (random) {
            case 0:
                return allUnits.getNewUnitEnemy("Soldat corompu");
            case 1:
                return allUnits.getNewUnitEnemy("Enfant du chao");
            case 2:
                return allUnits.getNewUnitEnemy("Space Marine du chao");
            case 3:
                return allUnits.getNewUnitEnemy("demon du chao");
            case 4:
                return allUnits.getNewUnitEnemy("Dreadnaute du Chao");
            case 5:
                return allUnits.getNewUnitEnemy("Demon Majeur du Chao");
            default:
                return allUnits.getNewUnitEnemy("Soldat corompu");
        }
    }

    private static void game(int nbVague, int eachTrun) {
        int actual_vague = 0;
        AllUnits allUnits = new AllUnits();

        int turn = 0;
        Base PlayBase = new Base(1000, true, 1000);
        Base EnnemyBase = new Base(1000, false, 0);
        UnitList unitList = new UnitList();
        Map map = new Map();
        boolean switchOnOff;
        boolean listEnnemy;
        do {
            // display map
            menus.printMap(map.getPosition(), map.getBunkerPosition(), unitList, PlayBase, EnnemyBase);
            // player turn
            switchOnOff = shop(allUnits, unitList, PlayBase);
            // add enemy unit
            if (turn % eachTrun == 0 && actual_vague < nbVague) {
                unitList.addunitEnnemy(createVague(actual_vague, allUnits));
                actual_vague++;
            }
            // move units
            unitList.moveUnits(PlayBase, EnnemyBase);
            map.updatePosition(unitList);
            turn++;
            listEnnemy = unitList.isUnitEnnemy();
        } while (PlayBase.isAlive() && EnnemyBase.isAlive() && (actual_vague < nbVague || !listEnnemy) && switchOnOff);
        if (PlayBase.isAlive()) {
            System.out.println("Vous avez gagné!!!\n");
        } else {
            System.out.println("Vous avez perdu!!!\n");
        }
    }

    public static void gameSet(int difficulty) {
        int nbVague = 5;
        int eachTrun = 10;
        String theReturn;

        switch (difficulty) {
            case 1:
                nbVague = 5;
                eachTrun = 10;
                break;
            case 2:
                nbVague = 10;
                eachTrun = 9;
                break;
            case 3:
                nbVague = 15;
                eachTrun = 8;
                break;
            case 4:
                try {
                    theReturn = menus.demandeSaisie("choose number of wave");
                    nbVague = Integer.parseInt(theReturn);
                    theReturn = menus.demandeSaisie("choose number of turn between each wave");
                    eachTrun = Integer.parseInt(theReturn);
                } catch (NumberFormatException e) {
                    System.out.println("Erreur, vous avez saisi une valeur non valide");
                }
                break;
        }

        game(nbVague, eachTrun);
    }

    public static void main(String[] args) {
        menus.mainMenu1();
    }
}
