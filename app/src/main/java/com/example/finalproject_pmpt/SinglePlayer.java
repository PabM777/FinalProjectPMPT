package com.example.finalproject_pmpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SinglePlayer extends AppCompatActivity {

    private Button[] btnAttack = new Button[4];
    private TextView tvmoveChat, tvhealthbar1, tvhealthbar2;
    private int turnCounter = (int) (Math.random() *2);
    private Monster monster1;
    private Monster monster2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coop_screen);
        monster1 = MonsterFactory.monster1();
        monster2 = MonsterFactory.monster2();

        tvmoveChat = findViewById(R.id.tv_move_chat);
        tvhealthbar1 = findViewById(R.id.tv_health_bar_one);
        tvhealthbar2 = findViewById(R.id.tv_health_bar_two);

        btnAttack[0] = findViewById(R.id.btn_move_one);
        btnAttack[1] = findViewById(R.id.btn_move_two);
        btnAttack[2] = findViewById(R.id.btn_move_three);
        btnAttack[3] = findViewById(R.id.btn_move_four);

        runBattle();

    }

    public void runBattle()
    {
        checkIfWon();
        setTurnText(turnCounter);

        if (turnCounter % 2 == 0)
        {
            tvmoveChat.setText("It is " + monster1.getName() + "'s Turn");
            attack(monster1, monster2);
        }
        else
        {
            tvmoveChat.setText("It is " +  monster2.getName() + "'s Turn\n" );
            attack(monster2, monster1);
        }

    }

    private void checkIfWon() {
        if (monster1.getHp() <= 0 || monster2.getHp() <= 0)
        {
            Monster winner;
            Monster loser;
            if (monster1.getHp() > 0 ) {
                winner = monster1;
                loser = monster2;

            } else {
                winner = monster2;
                loser = monster1;
            }

            setContentView(R.layout.victoryscreen);
            Button btnMenu = findViewById(R.id.btn_main_screen);
            TextView tvWinner = findViewById(R.id.tv_winner_text);
            tvWinner.setText(winner.getName() + " Won!!!");
            btnMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SinglePlayer.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    private void setTurnText(int turnCounter)
    {
        tvhealthbar1.setText(monster1.getName() + "'s HP: " + monster1.getHp());
        tvhealthbar2.setText(monster2.getName() + "'s HP: " + monster2.getHp());
        Monster currentMonster;
        if (turnCounter %2 == 0) {
            currentMonster = monster1;
        }
        else {
            currentMonster = monster2;
        }
        for (int i=0; i<btnAttack.length; i++) {
            btnAttack[i].setText(currentMonster.getAttacks()[i].getName());
        }
    }


    private void attack(Monster attacker, Monster defender){
        for(int i=0; i<btnAttack.length; i++) {
            final int k = i;
            btnAttack[k].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    defender.takeDamage(attacker.getAttacks()[k].getDamage());
                    turnCounter++;
                    runBattle();
                }
            });
        }

    }

    private void opponentAttack(Monster attacker, Monster defender)
    {

            int randMove = (int) (Math.random() * btnAttack.length);
             btnAttack[randMove].setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     defender.takeDamage(attacker.getAttacks()[randMove].getDamage());
                     turnCounter++;
                     runBattle();

                 }
             });

    }

}