package com.example.finalproject_pmpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        monster1 = MonsterFactory.monster1();
        monster2 = MonsterFactory.monster2();

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
       checkIfWon();
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
                    Intent intent = new Intent(SinglePlayerActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
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
                    runBattle();
                }
            });
        }

    }





    
}