package com.example.finalproject_pmpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SinglePlayer extends AppCompatActivity {

    private Button[] btnAttack = new Button[4];
    private Button btnNext;
    private TextView tvmoveChat, tvhealthbar1, tvhealthbar2;
    private ImageView ivPlayer, ivEnemy;
    private int turnCounter = (int) (Math.random() *2);
    private Monster player;
    private Monster enemy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        player = MonsterFactory.monster1();
        enemy = MonsterFactory.monster2();

        ivPlayer = findViewById(R.id.iv_player);
        ivEnemy = findViewById(R.id.iv_enemy);

        tvmoveChat = findViewById(R.id.tv_move_chat);
        tvhealthbar1 = findViewById(R.id.tv_health_bar_one);
        tvhealthbar2 = findViewById(R.id.tv_health_bar_two);

        btnAttack[0] = findViewById(R.id.btn_move1);
        btnAttack[1] = findViewById(R.id.btn_move2);
        btnAttack[2] = findViewById(R.id.btn_move3);
        btnAttack[3] = findViewById(R.id.btn_move4);

        btnNext = findViewById(R.id.btn_next);
        btnNext.setVisibility(View.INVISIBLE);

        ivPlayer.setImageResource(player.getImageResNormal());
        ivEnemy.setImageResource(enemy.getImageResNormal());

        runBattle();

    }

    public void runBattle()
    {
        checkIfWon();
        setTurnText(turnCounter);

        if (turnCounter % 2 == 0)
        {
            tvmoveChat.setText("It is " + player.getName() + "'s Turn");
            attack(player, enemy);
        }
        else
        {
            tvmoveChat.setText("It is " +  enemy.getName() + "'s Turn\n" );
            opponentAttack(enemy, player);
        }

    }

    private void checkIfWon() {
        if (player.getHp() <= 0 || enemy.getHp() <= 0)
        {
            Monster winner;
            Monster loser;
            if (player.getHp() > 0 ) {
                winner = player;
                loser = enemy;

            } else {
                winner = enemy;
                loser = player;
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
        tvhealthbar1.setText(player.getName() + "'s HP: " + player.getHp());
        tvhealthbar2.setText(enemy.getName() + "'s HP: " + enemy.getHp());
        Monster currentMonster;
        if (turnCounter %2 == 0) {
            currentMonster = player;
        }
        else {
            currentMonster = enemy;
        }
        for (int i=0; i<btnAttack.length; i++) {
            btnAttack[i].setText(currentMonster.getAttacks()[i].getName());
        }
    }


    private void attack(Monster attacker, Monster defender){
        for(int i=0; i<btnAttack.length; i++) {
            final int k = i;

            ivPlayer.setImageResource(player.getImageResFight());
            ivEnemy.setImageResource(enemy.getImageResNormal());

            for (Button btn:btnAttack) {
                btn.setVisibility(View.VISIBLE);
            }
            btnAttack[k].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    defender.takeDamage(attacker.getAttacks()[k].getDamage());
                    turnCounter++;

                    for (Button btn:btnAttack) {
                        btn.setVisibility(View.INVISIBLE);
                    }
                    runBattle();
                }
            });
        }

    }

    private void opponentAttack(Monster attacker, Monster defender)
    {

        ivPlayer.setImageResource(player.getImageResNormal());
        ivEnemy.setImageResource(enemy.getImageResFight());

        int randMove = (int) (Math.random() * btnAttack.length);

        defender.takeDamage(attacker.getAttacks()[randMove].getDamage());

        turnCounter++;


        btnNext.setVisibility(View.VISIBLE);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNext.setVisibility(View.INVISIBLE);
                runBattle();
            }
        });

    }

}