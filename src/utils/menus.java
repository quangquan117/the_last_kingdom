package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class menus {

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
                    System.out.println("Easy");
                    break;
                case 2:
                    System.out.println("Medium");
                    break;
                case 3:
                    System.out.println("Hard");
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
                    System.out.println("Play");
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
