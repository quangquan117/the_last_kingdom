package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import metier.App;
import model.Base;
import model.Unit;
import model.UnitList;

public class menus {

    public static void printMap(char[] position, char[] BunkerPosition, UnitList unitList, Base basePlayer, Base baseEnnemy) {
        ArrayList<Unit> units;
        System.out.println("Map\n");
        // if bunker print B else print position
        for (int i = 0; i < 22; i++) {
            if (BunkerPosition[i] != ' ') {
                System.out.print(BunkerPosition[i]);
            } else {
                System.out.print(position[i]);
            }
        }
        System.out.println("\n----------------------");
        // print unit
        System.out.println("--Player--");
        units = unitList.getUnitsPlayer();
        for (Unit unit : units) {
            System.out.println(unit.getNom() + " : " + unit.getPV() + " PV");
        }
        System.out.println("Money : " + basePlayer.getMoney());
        System.out.println("Base Player : " + basePlayer.getPV() + " PV");
        System.out.println("----------------------");
        System.out.println("--Ennemy--");
        units = unitList.getUnitsEnnemy();
        for (Unit unit : units) {
            System.out.println(unit.getNom() + " : " + unit.getPV() + " PV");
        }
        System.out.println("Base Ennemy : " + baseEnnemy.getPV() + " PV");
        System.out.println("----------------------");
    }

    public static String demandeSaisie(String message) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String saisie = "";
        do {
            try {
                do {
                    System.out.println(message);
                    saisie = br.readLine();
                } while (saisie.isEmpty());
                return saisie;
            } catch (Exception e) {
                System.out.println("Erreur lors de la saisie : \n" + e);
            }
        } while (true);
    }

    public static void menusGameSet() {
        int difficulty = 0;
        boolean interupt = true;
        do {
            String theReturn = demandeSaisie("1. Easy\n2. Medium\n3. Hard");
            try {
                difficulty = Integer.parseInt(theReturn);
            } catch (NumberFormatException e) {
                System.out.println("Erreur, vous avez saisi une valeur non valide");
            } catch (Exception e) {
                System.out.println("Erreur,\n" + e);
            }

            switch (difficulty) {
                case 1:
                    App.gameSet(1);
                    interupt = false;
                    break;
                case 2:
                    App.gameSet(2);
                    interupt = false;
                    break;
                case 3:
                    App.gameSet(3);
                    interupt = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (interupt);
    }

    public static void mainMenu1() {
        int choice = 0;
        boolean interupt = true;
        do {
            String theReturn = demandeSaisie("1. Play\n2. Instructions\n3. Exit");
            try {
                choice = Integer.parseInt(theReturn);
            } catch (NumberFormatException e) {
                System.out.println("Erreur, vous avez saisi une valeur non valide");
            } catch (Exception e) {
                System.out.println("Erreur,\n" + e);
            }

            switch (choice) {
                case 1:
                    menusGameSet();
                    break;
                case 2:
                    System.out.println("Instructions");
                    break;
                case 3:
                    System.out.println("Exit");
                    interupt = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (interupt);
    }
}
