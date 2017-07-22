package org.hillel.ykuzub;

/**
 * Created by geo on 22.07.2017.
 */
public class MainClass {
    public static void main(String[] args) {
        Player player1 = new Player("Yura", 10);
        Player player2 = new Player("Olya", 15);

        Fight fight = new Fight(player1, player2);
        fight.start();
    }
}
