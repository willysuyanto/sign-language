package com.wildangunawan.bslapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayerActivity extends AppCompatActivity {
    private TextView textView;
    private VideoView vView;
    private ImageButton mButtonBack, mButtonUlang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        Intent intent = getIntent();
        String Judul;
        textView = findViewById(R.id.TextTitle);
        vView = findViewById(R.id.vidplayer);
        mButtonBack = findViewById(R.id.btn_kembali);
        mButtonUlang = findViewById(R.id.btn_ulang);

        if (intent.getStringExtra(BahasaIsyarat.EXTRA_TEXT3).equals("Angka")) {
            Judul = "Angka " + intent.getStringExtra(BahasaIsyarat.EXTRA_TEXT2);
        } else if (intent.getStringExtra(BahasaIsyarat.EXTRA_TEXT3).equals("Huruf")) {
            Judul = "Huruf " + intent.getStringExtra(BahasaIsyarat.EXTRA_TEXT2);
        } else {
            Judul = intent.getStringExtra(BahasaIsyarat.EXTRA_TEXT2);
        }
        Uri uri = Uri.parse(intent.getStringExtra(BahasaIsyarat.EXTRA_TEXT));
        textView.setText(Judul);
        vView.setVideoURI(uri);
        vView.start();

        vView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mButtonUlang.setVisibility(View.VISIBLE);
            }
        });

        mButtonUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vView.start();
                mButtonUlang.setVisibility(View.INVISIBLE);
            }
        });

        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
