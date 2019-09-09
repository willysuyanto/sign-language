package com.tikhanovesy.aplikasimarble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class BermainActivity extends AppCompatActivity {

    private ImageButton mButtonRumah;
    private ImageButton mButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bermain);

        mButtonRumah = findViewById(R.id.btn_rumah);
        mButtonBack = findViewById(R.id.btn_kembali);
        mButtonRumah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BermainActivity.this, GameRumahActivity.class);
                startActivity(intent);
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
