package com.tikhanovesy.aplikasimarble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class BelajarActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.tikhanovesy.aplikasimarble.EXTRA_TEXT";
    private ImageButton mButtonBack;
    private androidx.gridlayout.widget.GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_belajar);
        mButtonBack = findViewById(R.id.btn_kembali);
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mainGrid = findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
    }

    private void setSingleEvent(androidx.gridlayout.widget.GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int FinalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (FinalI) {
                        case 0:
                            openMenu("Huruf");
                            break;
                        case 1:
                            openMenu("Angka");
                            break;
                        case 2:
                            openMenu("Keluarga");
                            break;
                        case 3:
                            openMenu("Makanan");
                            break;
                        case 4:
                            openMenu("Ucapan");
                            break;
                        case 5:
                            openMenu("Tanya");
                            break;
                        case 6:
                            openMenu("Sebutan");
                            break;
                        case 7:
                            openMenu("Perasaan");
                            break;
                        case 8:
                            openMenu("Rasa");
                            break;
                    }
                }
            });
        }
    }

    public void openMenu(String MenuText) {
        String text = MenuText;
        Intent intent = new Intent(BelajarActivity.this, BahasaIsyarat.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
}
