package com.packtpub.packt_memorygame;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Riku Pepponen on 20.6.2017.
 * (riku.pepponen@gmail.com)
 */

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    // UI declarations
    TextView mScoreTitle;
    TextView mDifficultyTitle;
    TextView mTextWatchGo;

    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    Button mReplayButton;

    // Sound declarations
    private SoundPool mSoundPool;
    int sample1, sample2, sample3, sample4 = -1;

    @Override
    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_game);

        // Sound Effects
        // Make the soundpool according to build version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mSoundPool = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .build();
        } else {
            mSoundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        }
    }


    @Override
    public void onClick(View v) {

    }
}