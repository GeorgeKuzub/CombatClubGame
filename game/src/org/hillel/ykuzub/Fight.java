package org.hillel.ykuzub;

import java.util.Scanner;

/**
 * Created by geo on 22.07.2017.
 */
public class Fight {
    private Player mPlayer1, mPlayer2;

    public Fight(Player plr1, Player plr2) {
        mPlayer1 = plr1;
        mPlayer2 = plr2;
    }

    public boolean isGameOver() {
        return mPlayer1.isDead() || mPlayer2.isDead();
    }

    public void start() {
        while (!isGameOver()) {
            initPlayer(mPlayer1);
            initPlayer(mPlayer2);
            calcDamage();
            printCurrentState();
        }

        finish();
    }

    private void finish() {
        System.out.println("==================================================");

        if (mPlayer1.isDead() && mPlayer2.isDead()) {
            System.out.println("All are dead!");
        } else if (mPlayer1.isDead()) {
            System.out.println(mPlayer2.getName() + " has won!");
        } else {
            System.out.println(mPlayer1.getName() + " has won!");
        }

        System.out.println("==================================================");
    }

    private void calcDamage() {
        int damPlayer1 = mPlayer1.makeDamage(mPlayer2.getStrength(), mPlayer2.getAtttackBodyPart());
        int damPlayer2 = mPlayer2.makeDamage(mPlayer1.getStrength(), mPlayer1.getAtttackBodyPart());
        System.out.println(mPlayer2.getName() + " hit " + mPlayer1.getName() + " on " + damPlayer1);
        System.out.println(mPlayer1.getName() + " hit " + mPlayer2.getName() + " on " + damPlayer2);
    }

    private void initPlayer(Player pl) {
        System.out.println("Preparing phase:");
        Scanner sc = new Scanner(System.in);
        // init attack
        System.out.println(pl.getName() + " input attack:");
        printAllBodyParts();
        int attackIndex = sc.nextInt();
        pl.setAttack(BodyParts.values()[attackIndex]);

        // init def1
        System.out.println(pl.getName() + " input defence #1:");
        printAllBodyParts();
        int def1Index = sc.nextInt();

        // init def2
        System.out.println(pl.getName() + " input defence #2:");
        printAllBodyParts();
        int def2Index = sc.nextInt();

        pl.setDefence(BodyParts.values()[def1Index], BodyParts.values()[def2Index]);

    }

    private void printAllBodyParts() {
        BodyParts[] arr = BodyParts.values();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " - " + arr[i]);
        }
    }

    private void printCurrentState() {
        System.out.println("Health status:");
        System.out.println(mPlayer1.getName() + " health is " + mPlayer1.getCurrHealth());
        System.out.println(mPlayer2.getName() + " health is " + mPlayer2.getCurrHealth());
    }
}
