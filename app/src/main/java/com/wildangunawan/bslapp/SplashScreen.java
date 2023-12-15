package com.wildangunawan.bslapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar mProgresbar;
    private LinearLayout mLayoutMulai;
    private LinearLayout mLayoutLoad;
    private ImageButton mButton;
    private String Identitas = "Adaa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mButton = findViewById(R.id.btn_mulai);
        mProgresbar = findViewById(R.id.progBar);
        mLayoutMulai = findViewById(R.id.mulai);
        mLayoutLoad = findViewById(R.id.loads);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Identitas.equals("Ada")) {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    finish();
                } else {
                    Intent intent = new Intent(SplashScreen.this, InputNamaActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    finish();
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                loadProgres();
                tampilButton();
            }
        }).start();
    }

    public void loadProgres() {
        int SplashInterval = 2000;//Lama Splash Screen
        for (int Progres = 0; Progres < 100; Progres++) {
            try {
                Thread.sleep(SplashInterval / 100);
                mProgresbar.setProgress(Progres);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void tampilButton() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mLayoutMulai.setVisibility(View.VISIBLE);
                mLayoutLoad.setVisibility(View.INVISIBLE);
            }
        });
    }
}
