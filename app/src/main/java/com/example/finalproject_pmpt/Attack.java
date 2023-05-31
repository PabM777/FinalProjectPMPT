package com.example.finalproject_pmpt;

public class Attack {

    private String name;
    private int damage;
    private int powerpoint;
    private double accuracy;

    public Attack (String attack, int damage, int powerpoint, double accuracy)
    {
        this.name = attack;
        this.damage = damage;
        this.powerpoint = powerpoint;
        this.accuracy = accuracy;
    }




    public void use(Monster opponent)
    {
        double chance = Math.random();
        if (this.powerpoint > 0 && this.accuracy > chance) {
            opponent.takeDamage(this.damage);

            this.powerpoint--;
        }
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getPowerpoint() {
        return powerpoint;
    }

    public double getAccuracy() {
        return accuracy;
    }
}