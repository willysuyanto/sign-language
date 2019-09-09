package com.tikhanovesy.aplikasimarble;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class InputNamaActivity extends AppCompatActivity {
    private ImageButton mButtonOk, mButtonHint;
    private Button mButtonBisindo, mButtonSibi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nama);
        mButtonOk = findViewById(R.id.btn_simpan);
        mButtonBisindo = findViewById(R.id.btn_bisindo);
        mButtonSibi = findViewById(R.id.btn_sibi);
        mButtonHint = findViewById(R.id.btn_hint);

        mButtonBisindo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int white = Color.parseColor("#FFFFFF");
                int black = Color.parseColor("#111111");
                mButtonSibi.setBackgroundResource(R.drawable.custom_textedit);
                mButtonBisindo.setBackgroundResource(R.drawable.selected_item);
                mButtonSibi.setTextColor(black);
                mButtonBisindo.setTextColor(white);
            }
        });

        mButtonSibi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int white = Color.parseColor("#FFFFFF");
                int black = Color.parseColor("#111111");
                mButtonBisindo.setBackgroundResource(R.drawable.custom_textedit);
                mButtonSibi.setBackgroundResource(R.drawable.selected_item);
                mButtonBisindo.setTextColor(black);
                mButtonSibi.setTextColor(white);
            }
        });

        mButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InputNamaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        mButtonHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InputNamaActivity.this, PetunjukActivity.class);
                startActivity(intent);
            }
        });

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            makeExitDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void makeExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(InputNamaActivity.this);
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
