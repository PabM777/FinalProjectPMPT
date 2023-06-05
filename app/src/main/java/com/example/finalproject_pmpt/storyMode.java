package com.example.finalproject_pmpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class storyMode extends AppCompatActivity {
    private TextView tvChoosestart;
    private Button startMonst1, startMonst2, startMonst3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_mode);

        tvChoosestart = findViewById(R.id.tv_choose);
        startMonst1 = findViewById(R.id.btn_monster1);
        startMonst2 = findViewById(R.id.btn_monster2);
        startMonst3 = findViewById(R.id.btn_monster3);


        Intent gameIntent = new Intent(this, GameScreen.class);

        startMonst1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(gameIntent);
            }
        });

        startMonst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(gameIntent);
            }
        });

        startMonst3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(gameIntent);
            }
        });
    }
}