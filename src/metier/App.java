package metier;

import utils.menus;

public class App {

    public static void game(int difficulty) {
        int nbVague;

        if (difficulty == 1) {
            nbVague = 3;
        } else if (difficulty == 2) {
            nbVague = 5;
        } else {
            nbVague = 10;
        }

        System.out.println("Nombre de vagues : " + nbVague);

    }

    public static void main(String[] args) {
        menus.mainMenu1();
    }
}
