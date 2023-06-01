package com.example.finalproject_pmpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTitle;

    private TextView tvDescMons;

    private TextView tvDescCoop;

    private TextView tvDescStory;

    private TextView tvDescSingle;

    private Button btnCoop;
    private Button btnMonsters;
    private Button btnSingle;
    private Button btnStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tv_title);
        btnCoop = findViewById(R.id.btn_battle);
        btnMonsters =findViewById(R.id.btn_monsters);
        btnSingle = findViewById(R.id.btn_single);
        btnStory = findViewById(R.id.btn_story);


        Intent intentCoop = new Intent( this , CoopScreen.class);
        Intent intentSinglePlayer = new Intent(this, SinglePlayerActivity.class);

        //screen for co-op based gameplay
        btnCoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        //screen for checking/setting monsters
        btnMonsters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Intent intent2 = new Intent(this, SinglePlayerActivity.class );

        //screen for single player mode
        btnSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentSinglePlayer);
            }
        });

        //button for story mode of the game...
        Intent intent4 = new Intent(this, storyMode.class)
        btnStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent4);

            }
        });



    }
}