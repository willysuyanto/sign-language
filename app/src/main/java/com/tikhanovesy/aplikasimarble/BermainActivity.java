package com.tikhanovesy.aplikasimarble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BermainActivity extends AppCompatActivity {

    private ImageButton mButtonRumah;
    private ImageButton mButtonBack;
    private ImageButton mButtonCafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bermain);
        final Boolean islocked = true;

        mButtonRumah = findViewById(R.id.btn_rumah);
        mButtonBack = findViewById(R.id.btn_kembali);
        mButtonCafe = findViewById(R.id.btn_cafe);
        mButtonRumah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( mButtonRumah.getBackground().getConstantState()==getResources().getDrawable(R.drawable.btn_locked).getConstantState())
                {
                    Toast.makeText(getApplicationContext(),
                            "Level Locked", Toast.LENGTH_SHORT).show();
                } else{
                    Intent intent = new Intent(BermainActivity.this, GameRumahActivity.class);
                    startActivity(intent);
                }
            }
        });

        mButtonCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( mButtonCafe.getBackground().getConstantState()==getResources().getDrawable(R.drawable.btn_locked).getConstantState()){
                    Toast.makeText(getApplicationContext(),
                            "Level Terkunci, Selesaikan Level Sebelumnya", Toast.LENGTH_SHORT).show();
                } else{
                    Intent intent = new Intent(BermainActivity.this, GameCafeActivity.class);
                    startActivity(intent);
                }
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
