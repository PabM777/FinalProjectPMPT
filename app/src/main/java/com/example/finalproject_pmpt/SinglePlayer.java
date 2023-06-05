package com.example.finalproject_pmpt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SinglePlayer extends AppCompatActivity {

    private Button[] btnAttack = new Button[4];
    private TextView moveChat, healthbar1, healthbar2;
    private int turnCounter = (int) (Math.random() *2);
    private Monster monster1;
    private Monster monster2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coop_screen);
        monster1 = MonsterFactory.monster1();
        monster2 = MonsterFactory.monster2();

        moveChat = findViewById(R.id.tv_move_chat);
        healthbar1 = findViewById(R.id.tv_health_bar_one);
        healthbar2 = findViewById(R.id.tv_health_bar_two);

        btnAttack[0] = findViewById(R.id.btn_move_one);
        btnAttack[1] = findViewById(R.id.btn_move_two);
        btnAttack[2] = findViewById(R.id.btn_move_three);
        btnAttack[3] = findViewById(R.id.btn_move_four);



    }
}