package com.example.finalproject_pmpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CoopScreen extends AppCompatActivity {

    private TextView MoveChat;
    private TextView healthbarone;
    private TextView healthBarTwo;
    private Button btnMove1;
    private Button btnMove2;
    private Button btnMove3;
    private Button btnMove4;

    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coop_screen);

        MoveChat = findViewById(R.id.tv_move_chat);
        healthbarone = findViewById(R.id.tv_health_bar_one);
        healthBarTwo = findViewById(R.id.tv_health_bar_two);
        btnMove1 = findViewById(R.id.btn_move1);
        btnMove2 = findViewById(R.id.btn_move2);
        btnMove3 = findViewById(R.id.btn_move3);
        btnMove4 = findViewById(R.id.btn_move4);

    }
}