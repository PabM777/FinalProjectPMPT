package com.example.finalproject_pmpt;

import java.util.ArrayList;

public class Trainer {

    private String name;
    private int trainerID;
    private Monster[] monster = new Monster[3];


    public Trainer (String name, Monster monster1, Monster monster2, Monster monster3)
    {
        this.name = name;
        this.monster[0] = monster1;
        this.monster[1] = monster2;
        this.monster[2] = monster3;
        trainerID++;
    }

    public String getName() {
        return name;
    }

    public int getTrainerID() {
        return trainerID;
    }

    public Monster[] getMonster() {
        return monster;
    }
}
