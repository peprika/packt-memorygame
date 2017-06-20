package com.packtpub.packt_memorygame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Riku Pepponen on 20.6.2017.
 * (riku.pepponen@gmail.com)
 */

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_game);
    }

    @Override
    public void onClick(View v) {

    }
}