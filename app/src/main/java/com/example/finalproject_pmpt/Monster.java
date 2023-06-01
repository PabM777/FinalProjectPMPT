package com.example.finalproject_pmpt;

import java.io.Serializable;

public class Monster implements Serializable {

    private String name;
    private int hp;
    private int level;
    private String element;
    private String element2;
    private Attack[] attacks;



    public Monster(String name, int health, int level, String ele1, String ele2, Attack a1, Attack a2, Attack a3, Attack a4)
    {
        this.name = name;
        this.hp = health;
        this.level = level;
        this.element = ele1;
        this.element2 = ele2;
        this.attacks = new Attack[4];
        this.attacks[0] = a1;
        this.attacks[1] = a2;
        this.attacks[2] = a3;
        this.attacks[3] = a4;
    }

    public void takeDamage(int damage)
    {
        hp -= damage;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public String getElement() {
        return element;
    }

    public String getElement2() {
        return element2;
    }

    public Attack getAttack1() {
        return attacks[0];
    }

    public Attack getAttack2() {
        return attacks[1];
    }

    public Attack getAttack3() {
        return attacks[2];
    }

    public Attack getAttack4() {
        return attacks[3];
    }

    public Attack[] getAttacks() {
        return attacks;
    }
}
