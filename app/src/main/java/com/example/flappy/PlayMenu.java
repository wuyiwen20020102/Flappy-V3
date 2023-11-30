package com.example.flappy;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class PlayMenu extends AppCompatActivity implements OnClickListener{
    private Button touchButton;
    private Button voiceButton;
    private ImageButton hutaoButton;
    private ImageButton paimonButton;
    private int gameState;
    private int character_up, character_down, character_normal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_menu);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        touchButton = (Button) findViewById(R.id.touch);
        voiceButton = (Button) findViewById(R.id.voice);
        hutaoButton = (ImageButton) findViewById(R.id.hutao);
        paimonButton = (ImageButton) findViewById(R.id.paimon);

        touchButton.setOnClickListener(this);
        voiceButton.setOnClickListener(this);
        hutaoButton.setOnClickListener(this);
        paimonButton.setOnClickListener(this);

        //By default character
        character_up = GameProperty.PAIMON_UP;
        character_down = GameProperty.PAIMON_DOWN;
        character_normal = GameProperty.PAIMON_NORMAL;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.touch) {
            gameState = GameProperty.GAME_TOUCH;
            openGame(gameState);
        }
        else if(v.getId() == R.id.voice){
            gameState = GameProperty.GAME_VOICE;
            openGame(gameState);
        }
        else if(v.getId() == R.id.hutao){
            character_up = GameProperty.HUTAO_UP;
            character_down = GameProperty.HUTAO_DOWN;
            character_normal = GameProperty.HUTAO_NORMAL;
        }
        else if(v.getId() == R.id.paimon){
            character_up = GameProperty.PAIMON_UP;
            character_down = GameProperty.PAIMON_DOWN;
            character_normal = GameProperty.PAIMON_NORMAL;
        }
    }

    public void openGame(int gameState){
        if(gameState == GameProperty.GAME_TOUCH) {
            GameView_Touch gameView = new GameView_Touch(this, character_up, character_down, character_normal);
            setContentView(gameView);
        }
        else if(gameState == GameProperty.GAME_VOICE){
            GameView_Voice gameView = new GameView_Voice(this, character_up, character_down, character_normal);
            setContentView(gameView);
        }
    }
}
