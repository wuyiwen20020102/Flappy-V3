package com.example.flappy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {
    TextView points;
    TextView highestPoints;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        points = findViewById(R.id.points);
        highestPoints = findViewById(R.id.highest_points);
        int score = getIntent().getExtras().getInt("Score");
        points.setText("" + score);
        sharedPreferences = getSharedPreferences("my_pref",0);
        int highest_points = sharedPreferences.getInt("highest", 0);
        highestPoints.setText(""+highest_points);
    }

    public void restart(View view){
        Intent intent = new Intent(GameOver.this, PlayMenu.class);
        startActivity(intent);
        finish();
    }

    public void back(View view){
        finish();
    }

}
