package com.packtpub.packt_memorygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mNewGameButton;

    // Declarations for high scores
    SharedPreferences prefs;
    String dataName = "MyData";
    String intName = "MyInt";
    int defaultInt = 0;
    public static int hiScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializations for high scores
        prefs = getSharedPreferences(dataName, MODE_PRIVATE);
        hiScore = prefs.getInt(intName, defaultInt);
        TextView textHiScore = (TextView) findViewById(R.id.highScore);
        textHiScore.setText("High Score: " + hiScore);

        mNewGameButton = (Button)findViewById(R.id.newGameButton);
        mNewGameButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }
}
