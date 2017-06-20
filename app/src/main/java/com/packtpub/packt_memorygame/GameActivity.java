package com.packtpub.packt_memorygame;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;

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


    // Game logic variable declarations
    private Handler mHandler;
    int difficultyLevel = 1;
    int [] sequenceToCopy = new int[100];
    boolean playSequence = false;
    int elementToPlay = 0;
    int playerResponses;
    int playerScore;
    boolean isResponding;

    @Override
    protected void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_game);

        // Set the UI elements
        mScoreTitle = (TextView)findViewById(R.id.scoreTitle);
        mDifficultyTitle = (TextView)findViewById(R.id.difficultyTitle);

        mButton1 = (Button)findViewById(R.id.button1);
        mButton2 = (Button)findViewById(R.id.button2);
        mButton3 = (Button)findViewById(R.id.button3);
        mButton4 = (Button)findViewById(R.id.button4);
        mReplayButton = (Button)findViewById(R.id.replayButton);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mReplayButton.setOnClickListener(this);

        // Sound Effects
        // Make the soundpool according to build version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mSoundPool = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .build();
        } else {
            mSoundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        }

        // Load the sound files
        try {
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;

            descriptor = assetManager.openFd("buttonbeep1.ogg");
            sample1 = mSoundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("buttonbeep2.ogg");
            sample2 = mSoundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("buttonbeep3.ogg");
            sample3 = mSoundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("buttonbeep4.ogg");
            sample4 = mSoundPool.load(descriptor, 0);
        } catch(IOException e) {
            // Catch exception here
        }

        // Thread code
        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if (playSequence) {
                    // Thread action will go here
                }

                mHandler.sendEmptyMessageDelayed(0, 900);
            }
        };
        mHandler.sendEmptyMessage(0);
    }

    @Override
    public void onClick(View v) {

    }

    // Create a sequence the user has to copy
    public void createSequence() {
        Random randInt = new Random();
        int ourRandom;
        for(int i = 0; i < difficultyLevel; i++) {
            ourRandom = randInt.nextInt(4);
            ourRandom++;
            sequenceToCopy[i] = ourRandom;
        }
    }

    // For starting the thread
    public void playASequence() {
        createSequence();
        isResponding = false;
        elementToPlay = 0;
        playerResponses = 0;
        playSequence = true;
    }

    // For finishing the thread
    public void sequenceFinish() {
        playSequence = false;
        mButton1.setVisibility(View.VISIBLE);
        mButton2.setVisibility(View.VISIBLE);
        mButton3.setVisibility(View.VISIBLE);
        mButton4.setVisibility(View.VISIBLE);
        isResponding = true;
    }
}