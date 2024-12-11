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

    public static void instructions() {
        System.out.println("--Lore--\nDans l'univers sombre de *Warhammer 40,000*, l'humanité est engagée dans une lutte éternelle contre le Chaos,\nune force maléfique issue de l’Immaterium, alimentée par les émotions négatives et les ambitions démesurées. Les dieux du Chaos cherchent à corrompre les âmes et\ndominer la galaxie. L’Imperium de l’Humanité, dirigé par l’Empereur immortel, lutte désespérément pour maintenir son existence face aux légions démoniaques\net aux cultes renégats. Les Space Marines, guerriers surhumains de l’Adeptus Astartes, sont en première ligne pour protéger l’humanité.\nMais même eux ne sont pas à l’abri de la corruption du Chaos, certains Chapitres ayant trahi pour servir leurs sombres maîtres.\nLa guerre est totale, opposant machines titanesques, flottes spatiales colossales, et hordes démoniaques.\nLes batailles se déroulent sur des mondes-ruche dévastés, dans le vide spatial, et à travers les dimensions distordues de l’Immaterium.\nLa victoire n'est jamais assurée, et chaque affrontement pourrait sceller le destin de la galaxie.\nDans cet univers, seule la foi ou la folie permet de continuer à se battre. Pour l'Imperium, la guerre contre le Chaos est sans fin,\nmais abandonner équivaudrait à l'anéantissement total.");
        System.out.println("\n--Instruction--\n");
        System.out.println("Le but du jeu est de protéger votre base contre les vagues ennemies.\nVous avez la possibilité d'acheter des unités pour défendre votre base.\nChaque unité a un coût et des caractéristiques qui lui sont propres.\nVous pouvez acheter une unité ou passer votre tour.\nLes ennemis avance pour attaquer votre base à chaque tour.\nSi votre base tombe à 0 PV, vous avez perdu.\nSi vous survivez à toutes les vagues ennemies, vous avez gagné.");
        System.out.println("\n--Unités--\n");
        // afficher les unités (le prix est le cout)
        /* 
         * 
         */

        System.out.println("1. s = Soldat : 100 PV, 50 Attaque, 2 Defense, 10 Prix");
        System.out.println("2. d = Death Corp : 100 PV, 100 Attaque, 0 Defense, 20 Prix");
        System.out.println("3. b = Bunker : 1000 PV, 100 Attaque, 5 Defense, 100 Prix");
        System.out.println("4. S = Space Marine : 1000 PV, 500 Attaque, 50 Defense, 500 Prix");
        System.out.println("5. D = Dreadnaute : 2000 PV, 1000 Attaque, 1000 Defense, 1000 Prix");
        System.out.println("6. C = Char Predator : 5000 PV, 2000 Attaque, 1500 Defense, 2000 Prix");

        System.out.println("\n--Vagues ennemies--\n");
        // afficher les vagues ennemies (le prix est la recompense)
        System.out.println("1. c = Soldat corompu : 100 PV, 34 Attaque, 0 Defense, 5 gain");
        System.out.println("2. e = Enfant du chao : 500 PV, 50 Attaque, 10 Defense, 10 gain");
        System.out.println("3. m = Space Marine du chao : 1000 PV, 100 Attaque, 30 Defense, 50 gain");
        System.out.println("4. A = demon du chao : 2000 PV, 1000 Attaque, 0 Defense, 250 gain");
        System.out.println("5. R = Dreadnaute du Chao : 2000 PV, 1000 Attaque, 500 Defense, 500 gain");
        System.out.println("6. M = Demon Majeur du Chao : 5000 PV, 15000 Attaque, 1000 Defense, 1000 gain");
        System.out.println("");
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
                    instructions();
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
