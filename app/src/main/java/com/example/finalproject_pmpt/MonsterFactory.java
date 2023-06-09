package com.example.finalproject_pmpt;

public class MonsterFactory {

    //add monsters to the game...

    public static Monster monster1()
    {
        Attack a1 = new Attack("Shadow Ball", 80, 15, 1.3);
        Attack a2 = new Attack("Dazzling Gleam", 80, 25, 1.5);
        Attack a3 = new Attack("Sludge Bomb", 90, 10, 1.0);
        Attack a4 = new Attack("Psychic", 90, 15, 1.9);
        int imageResNormal = R.drawable.im_monster_1;
        int imageResFight = R.drawable.im_monster_1_fight;
        Monster quierriot = new Monster("Quierriot",230 , 226 , "", "", a1,a2,a3,a4, imageResNormal, imageResFight);
        return quierriot;
    }


    public static Monster monster2()
    {
        Attack a1 = new Attack("Limtless heal", 5, 15, 1.2);
        Attack a2 = new Attack("Internal Drain", 70, 10, 0.8);
        Attack a3 = new Attack("Thrasing Rage", 85, 5, 1.0);
        Attack a4 = new Attack("Titanium Punch", 90, 5, 0.4);
        int imageResNormal = R.drawable.im_monster_2;
        int imageResFight = R.drawable.im_monster_2_fight;
        Monster gyroginga = new Monster("Gyoginga", 230, 200, "", "", a1, a2, a3, a4, imageResNormal, imageResFight);
        return gyroginga;

    }

    public static Monster monster3()
    {
        Attack a1 = new Attack("Limtless heal", 5, 15, 1.2);
        Attack a2 = new Attack("Internal Drain", 70, 10, 0.8);
        Attack a3 = new Attack("Thrasing Rage", 85, 5, 1.0);
        Attack a4 = new Attack("Titanium Punch", 90, 5, 0.4);
        int imageResNormal = R.drawable.im_monster_1;
        int imageResFight = R.drawable.im_monster_1_fight;
        Monster gyroginga = new Monster("Gyoginga", 230, 200, "", "", a1, a2, a3, a4, imageResNormal, imageResFight);
        return gyroginga;

    }

    public static Monster monster4()
    {
        Attack a1 = new Attack("Limtless heal", 5, 15, 1.2);
        Attack a2 = new Attack("Internal Drain", 70, 10, 0.8);
        Attack a3 = new Attack("Thrasing Rage", 85, 5, 1.0);
        Attack a4 = new Attack("Titanium Punch", 90, 5, 0.4);
        int imageResNormal = R.drawable.im_monster_2;
        int imageResFight = R.drawable.im_monster_2_fight;
        Monster gyroginga = new Monster("Gyoginga", 230, 200, "", "", a1, a2, a3, a4, imageResNormal, imageResFight);
        return gyroginga;

    }

    public static Monster monster5()
    {
        Attack a1 = new Attack("Limtless heal", 5, 15, 1.2);
        Attack a2 = new Attack("Internal Drain", 70, 10, 0.8);
        Attack a3 = new Attack("Thrasing Rage", 85, 5, 1.0);
        Attack a4 = new Attack("Titanium Punch", 90, 5, 0.4);
        int imageResNormal = R.drawable.im_monster_1;
        int imageResFight = R.drawable.im_monster_1_fight;
        Monster gyroginga = new Monster("Gyoginga", 230, 200, "", "", a1, a2, a3, a4, imageResNormal, imageResFight);
        return gyroginga;

    }




}
