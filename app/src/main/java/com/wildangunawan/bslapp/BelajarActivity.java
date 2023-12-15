package com.wildangunawan.bslapp;

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
                            openMenu("Alphabet");
                            break;
                        case 1:
                            openMenu("Number");
                            break;
                        case 2:
                            openMenu("Family");
                            break;
                        case 3:
                            openMenu("Food");
                            break;
                        case 4:
                            openMenu("Expressions");
                            break;
                        case 5:
                            openMenu("Question");
                            break;
                        case 6:
                            openMenu("Pronoun");
                            break;
                        case 7:
                            openMenu("Feeling");
                            break;
                        case 8:
                            openMenu("Taste");
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
