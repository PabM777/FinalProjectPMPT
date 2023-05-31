package com.example.finalproject_pmpt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SinglePlayerActivity extends AppCompatActivity {

    private TextView tvMoveChat, tvHealthBar1, tvHealthBar2, tvBattle;
    private Button[] btnsAttack = new Button[4];

    private int turnCounter = (int) (Math.random() *2);

    private Monster monster1;
    private Monster monster2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        //monster1 = MonsterFactory.monster1();
        //monster1 = MonsterFactory.monster2();

        tvMoveChat = findViewById(R.id.tv_move_chat);
        tvHealthBar1 = findViewById(R.id.tv_health_bar_one);
        tvHealthBar2 = findViewById(R.id.tv_health_bar_two);
        tvBattle = findViewById(R.id.tv_battletext);

        btnsAttack[0] = findViewById(R.id.btn_move1);
        btnsAttack[1] = findViewById(R.id.btn_move2);
        btnsAttack[2] = findViewById(R.id.btn_move3);
        btnsAttack[3] = findViewById(R.id.btn_move4);

        runBattle();

    }

    public void runBattle()
    {

        while( !(monster1.getHp() <= 0 || monster2.getHp() <= 0) )
        {
            setTurnText(turnCounter);

            if (turnCounter % 2 == 0)
            {
                tvBattle.setText("It is " + monster1.getName() + "'s Turn");
                attack(monster1, monster2);
            }
            else
            {
                tvBattle.setText("It is " +  monster2.getName() + "'s Turn\n" );
                attack(monster2, monster1);
            }
        }
    }


    private void setTurnText(int turnCounter)
    {
       tvHealthBar1.setText(monster1.getName() + "'s HP: " + monster1.getHp());
       tvHealthBar2.setText(monster2.getName() + "'s HP: " + monster2.getHp());
       Monster currentMonster;
       if (turnCounter %2 == 0) {
           currentMonster = monster1;
       }
       else {
           currentMonster = monster2;
       }
       for (int i=0; i<btnsAttack.length; i++) {
           btnsAttack[i].setText(currentMonster.getAttacks()[i].getName());
       }
    }

    private void attack(Monster attacker, Monster defender){
        for(int i=0; i<btnsAttack.length; i++) {
            final int k = i;
            btnsAttack[k].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    defender.takeDamage(attacker.getAttacks()[k].getDamage());
                    turnCounter++;
                }
            });
        }

    }

    /*
    private void displayWinner()
    {
        //the challenger prompt if the challenger won
        if (challenger.getHP() > 0)
        {
            System.out.println( opponent.getName() + " Fainted!" + '\n' +
                    challenger.getName() + "is the winner!!!");

        }
        //the opponent prompt if the opponent won
        else if (opponent.getHP() > 0 )
        {
            System.out.println( challenger.getName() + " Fainted!" +  '\n' +
                    opponent.getName() + " " + "won...");
        }

    }

     */
    
}