package com.example.finalproject_pmpt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SinglePlayer extends AppCompatActivity {

    private TextView MoveChat;
    private TextView healthbarone;
    private TextView healthBarTwo;
    private Button btnMove1;
    private Button btnMove2;
    private Button btnMove3;
    private Button btnMove4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
    }
}