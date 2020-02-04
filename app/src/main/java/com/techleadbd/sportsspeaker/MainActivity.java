package com.techleadbd.sportsspeaker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class MainActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {

    private boolean isPlaying = false;
    private MediaPlayer sportPlayer;
    private Toast toast;

    //for components
    private ImageButton imgBoxing, imgKickboxing, imgJudo,
            imgKarate, imgAikido, imgTaekwondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBoxing = findViewById(R.id.imgBoxing);
        imgKickboxing = findViewById(R.id.imgKickboxing);
        imgJudo = findViewById(R.id.imgJudo);
        imgKarate = findViewById(R.id.imgKarate);
        imgAikido = findViewById(R.id.imgAikido);
        imgTaekwondo = findViewById(R.id.imgTaekwondo);

        imgBoxing.setOnClickListener(MainActivity.this);
        imgKickboxing.setOnClickListener(MainActivity.this);
        imgJudo.setOnClickListener(MainActivity.this);
        imgKarate.setOnClickListener(MainActivity.this);
        imgAikido.setOnClickListener(MainActivity.this);
        imgTaekwondo.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View imageButtonView) {

        switch (imageButtonView.getId()) {
            case R.id.imgBoxing:
                playSportName(imgBoxing.getTag().toString());
                break;

            case R.id.imgKickboxing:
                playSportName(imgKickboxing.getTag().toString());
                break;

            case R.id.imgJudo:
                playSportName(imgJudo.getTag().toString());
                break;

            case R.id.imgKarate:
                playSportName(imgKarate.getTag().toString());
                break;

            case R.id.imgAikido:
                playSportName(imgAikido.getTag().toString());
                break;

            case R.id.imgTaekwondo:
                playSportName(imgTaekwondo.getTag().toString());
                break;
        }
    }

    private void playSportName(String sportName) {
        cancelToast();
        if (isPlaying) {
            showToast();
            return;
        }
        isPlaying = true;
        sportPlayer = MediaPlayer.create(this, getResources()
                .getIdentifier(sportName, "raw", getPackageName()));
        sportPlayer.setOnCompletionListener(this);
        sportPlayer.start();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
        isPlaying = false;
    }

    private void showToast() {
        toast = Toast.makeText(this, "Already playing", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void cancelToast() {
        if (toast != null)
            toast.cancel();
    }
}
