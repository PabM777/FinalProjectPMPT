package com.example.finalproject_pmpt;

public class Monsters {

    private String name;
    private int health;
    private int level;
    private String element;
    private String element2;
    private Attack attack1;
    private Attack attack2;
    private Attack attack3;
    private Attack attack4;



    public Monsters(int health, int level, String ele1, String ele2, Attack a1, Attack a2, Attack a3, Attack a4)
    {
        this.health = health;
        this.level = level;
        this.element = ele1;
        this.element2 = ele2;
        this.attack1 = a1;
        this.attack2 = a2;
        this.attack3 = a3;
        this.attack4 = a4;
    }

    public void takeDamage(int damage)
    {
        health -= damage;
    }

}
