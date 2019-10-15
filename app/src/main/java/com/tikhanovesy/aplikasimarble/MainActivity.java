package com.tikhanovesy.aplikasimarble;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button mButtonBelajar;
    private Button mButtonBermain;
    private Button mButtonKeluar;
    private Button mButtonLatihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonBelajar = findViewById(R.id.btn_belajar);
        mButtonBermain = findViewById(R.id.btn_bermain);
        mButtonKeluar = findViewById(R.id.btn_keluar);
        mButtonLatihan = findViewById(R.id.btn_kuis);

        mButtonBelajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BelajarActivity.class);
                startActivity(intent);
            }
        });

        mButtonLatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, KuisActivity.class);
                startActivity(intent);
            }
        });

        mButtonBermain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BermainActivity.class);
                startActivity(intent);
            }
        });

        mButtonKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExitDialog();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            makeExitDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void makeExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Apakah kamu yakin ingin keluar?");

        // Set the alert dialog yes button click listener
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when user clicked the Yes button
                finish();
            }
        });

        // Set the alert dialog no button click listener
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when No button clicked
                Toast.makeText(getApplicationContext(),
                        "No Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        // Display the alert dialog on interface
        dialog.show();
    }

}
