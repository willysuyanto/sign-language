package com.tikhanovesy.aplikasimarble;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BahasaIsyarat extends AppCompatActivity implements ListAdapter.OnTitleListener {
    public static final String EXTRA_TEXT = "com.tikhanovesy.aplikasimarble.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 = "com.tikhanovesy.aplikasimarble.EXTRA_TEXT2";
    public static final String EXTRA_TEXT3 = "com.tikhanovesy.aplikasimarble.EXTRA_TEXT3";
    private ImageButton mButtonBack;
    private TextView mTextview;
    private ArrayList<String> mTitle = new ArrayList<>();

    private RecyclerView mRecylerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bahasa_isyarat);

        Intent intent = getIntent();
        String text = intent.getStringExtra(BelajarActivity.EXTRA_TEXT);
        mTextview = findViewById(R.id.text_belajar);
        mTextview.setText(text);

        mButtonBack = findViewById(R.id.btn_kembali);
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initTitle(text);
        mRecylerView = findViewById(R.id.recycler_view);
        mRecylerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ListAdapter(mTitle, this);
        mRecylerView.setLayoutManager(mLayoutManager);
        mRecylerView.setAdapter(mAdapter);
    }

    private void initTitle(String text) {
        switch (text) {
            case "Huruf":
                mTitle.add("Aa");
                mTitle.add("Bb");
                mTitle.add("Cc");
                mTitle.add("Dd");
                mTitle.add("Ee");
                mTitle.add("Ff");
                mTitle.add("Gg");
                mTitle.add("Hh");
                mTitle.add("Ii");
                mTitle.add("Jj");
                mTitle.add("Kk");
                mTitle.add("Ll");
                mTitle.add("Mm");
                mTitle.add("Nn");
                mTitle.add("Oo");
                mTitle.add("Pp");
                mTitle.add("Qq");
                mTitle.add("Rr");
                mTitle.add("Ss");
                mTitle.add("Tt");
                mTitle.add("Uu");
                mTitle.add("Vv");
                mTitle.add("Ww");
                mTitle.add("Xx");
                mTitle.add("Yy");
                mTitle.add("Zz");
                break;
            case "Angka":
                mTitle.add("1");
                mTitle.add("2");
                mTitle.add("3");
                mTitle.add("4");
                mTitle.add("5");
                mTitle.add("6");
                mTitle.add("7");
                mTitle.add("8");
                mTitle.add("9");
                mTitle.add("10");
                mTitle.add("11");
                mTitle.add("20");
                mTitle.add("21");
                mTitle.add("50");
                mTitle.add("100");
                mTitle.add("201");
                mTitle.add("500");
                mTitle.add("1000");
                mTitle.add("2000");
                mTitle.add("10000");
                break;
            case "Keluarga":
                mTitle.add("Ayah");
                mTitle.add("Ibu");
                mTitle.add("Kakak");
                mTitle.add("Adik");
                mTitle.add("Kakek");
                mTitle.add("Nenek");
                break;
            case "Makanan":
                mTitle.add("Nasi");
                mTitle.add("Sayur");
                mTitle.add("Kue");
                mTitle.add("Permen");
                mTitle.add("Air");
                break;
            case "Ucapan":
                mTitle.add("Halo");
                mTitle.add("Terimakasih");
                mTitle.add("Selamat");
                mTitle.add("Maaf");
                mTitle.add("Ampun");
                mTitle.add("Sama-Sama");
                mTitle.add("Assalamualaikum");
                break;
            case "Tanya":
                mTitle.add("Apa");
                mTitle.add("Kapan");
                mTitle.add("Dimana");
                mTitle.add("Siapa");
                mTitle.add("Mengapa");
                mTitle.add("Bagaimana");
                break;
            case "Sebutan":
                mTitle.add("Aku");
                mTitle.add("Kamu");
                mTitle.add("Kami");
                mTitle.add("Kita");
                mTitle.add("Mereka");
                break;
            case "Perasaan":
                mTitle.add("Senang");
                mTitle.add("Sedih");
                mTitle.add("Marah");
                mTitle.add("Malu");
                mTitle.add("Sakit");
                mTitle.add("Malas");
                mTitle.add("Capek");
                break;
            case "Rasa":
                mTitle.add("Manis");
                mTitle.add("Asin");
                mTitle.add("Pedas");
                mTitle.add("Pahit");
                mTitle.add("Asam");
                break;
        }
    }

    @Override
    public void OnTitleClick(int position) {
        String videopath = Environment.getExternalStorageDirectory() + "/Video/" + mTextview.getText().toString() + "/" + mTitle.get(position) + ".mp4";
        Intent intent = new Intent(this, VideoPlayerActivity.class);
        intent.putExtra(EXTRA_TEXT, videopath);
        intent.putExtra(EXTRA_TEXT2, mTitle.get(position));
        intent.putExtra(EXTRA_TEXT3, mTextview.getText().toString());
        startActivity(intent);
    }
}
