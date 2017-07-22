package org.hillel.ykuzub;

/**
 * Created by geo on 22.07.2017.
 */
public class Player {
    private final int mMaxHealth = 25;
    private int mCurrHealth = mMaxHealth;
    private int mStrength;
    private String mName;

    private BodyParts mAttack, mDefence1, mDefence2;

    public Player(String name, int strength) {
        mName = name;
        mStrength = strength;
    }

    public void setAttack(BodyParts attack) {
        mAttack = attack;
    }

    public void setDefence(BodyParts def1, BodyParts def2) {
        mDefence1 = def1;
        mDefence2 = def2;
    }

    public boolean isDead() {
        return mCurrHealth <= 0;
    }

    public String getName() {
        return mName;
    }

    public int getCurrHealth() {
        return mCurrHealth;
    }

    public int makeDamage(int strength, BodyParts bPart) {
        if (bPart != mDefence1 && bPart != mDefence2) {
            mCurrHealth -= strength;
            return strength;
        }
        return 0;
    }

    public int getStrength() {
        return mStrength;
    }

    public BodyParts getAtttackBodyPart() {
        return mAttack;
    }
}
