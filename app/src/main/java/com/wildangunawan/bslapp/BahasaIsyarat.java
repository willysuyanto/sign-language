package com.wildangunawan.bslapp;

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
    private ArrayList<ObjekBahasaIsyarat> mTitle = new ArrayList<>();

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
            case "Alphabet":
                mTitle.add(new ObjekBahasaIsyarat(text,"Aa",R.drawable.img_a));
                mTitle.add(new ObjekBahasaIsyarat(text,"Bb",R.drawable.img_b));
                mTitle.add(new ObjekBahasaIsyarat(text,"Cc",R.drawable.img_c));
                mTitle.add(new ObjekBahasaIsyarat(text,"Dd",R.drawable.img_d));
                mTitle.add(new ObjekBahasaIsyarat(text,"Ee",R.drawable.img_e));
                mTitle.add(new ObjekBahasaIsyarat(text,"Ff",R.drawable.img_f));
                mTitle.add(new ObjekBahasaIsyarat(text,"Gg",R.drawable.img_g));
                mTitle.add(new ObjekBahasaIsyarat(text,"Hh",R.drawable.img_h));
                mTitle.add(new ObjekBahasaIsyarat(text,"Ii",R.drawable.img_i));
                mTitle.add(new ObjekBahasaIsyarat(text,"Jj",R.drawable.img_j));
                mTitle.add(new ObjekBahasaIsyarat(text,"Kk",R.drawable.img_k));
                mTitle.add(new ObjekBahasaIsyarat(text,"Ll",R.drawable.img_m));
                mTitle.add(new ObjekBahasaIsyarat(text,"Mm",R.drawable.img_m));
                mTitle.add(new ObjekBahasaIsyarat(text,"Nn",R.drawable.img_n));
                mTitle.add(new ObjekBahasaIsyarat(text,"Oo",R.drawable.img_o));
                mTitle.add(new ObjekBahasaIsyarat(text,"Pp",R.drawable.img_p));
                mTitle.add(new ObjekBahasaIsyarat(text,"Qq",R.drawable.img_q));
                mTitle.add(new ObjekBahasaIsyarat(text,"Rr",R.drawable.img_r));
                mTitle.add(new ObjekBahasaIsyarat(text,"Ss",R.drawable.img_s));
                mTitle.add(new ObjekBahasaIsyarat(text,"Tt",R.drawable.img_t));
                mTitle.add(new ObjekBahasaIsyarat(text,"Uu",R.drawable.img_u));
                mTitle.add(new ObjekBahasaIsyarat(text,"Vv",R.drawable.img_v));
                mTitle.add(new ObjekBahasaIsyarat(text,"Ww",R.drawable.img_w));
                mTitle.add(new ObjekBahasaIsyarat(text,"Xx",R.drawable.img_x));
                mTitle.add(new ObjekBahasaIsyarat(text,"Yy",R.drawable.img_y));
                mTitle.add(new ObjekBahasaIsyarat(text,"Zz",R.drawable.img_z));
                break;
            case "Number":
                mTitle.add(new ObjekBahasaIsyarat(text,"1",R.drawable.img_1));
                mTitle.add(new ObjekBahasaIsyarat(text,"2",R.drawable.img_2));
                mTitle.add(new ObjekBahasaIsyarat(text,"3",R.drawable.img_3));
                mTitle.add(new ObjekBahasaIsyarat(text,"4",R.drawable.img_4));
                mTitle.add(new ObjekBahasaIsyarat(text,"5",R.drawable.img_5));
                mTitle.add(new ObjekBahasaIsyarat(text,"6",R.drawable.img_6));
                mTitle.add(new ObjekBahasaIsyarat(text,"7",R.drawable.img_7));
                mTitle.add(new ObjekBahasaIsyarat(text,"8",R.drawable.img_8));
                mTitle.add(new ObjekBahasaIsyarat(text,"9",R.drawable.img_9));
                mTitle.add(new ObjekBahasaIsyarat(text,"10",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"11",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"20",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"21",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"50",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"100",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"201",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"500",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"1000",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"2000",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"10000",R.drawable.img_0));
                break;
            case "Family":
                mTitle.add(new ObjekBahasaIsyarat(text,"Dad",R.drawable.img_ayahs));
                mTitle.add(new ObjekBahasaIsyarat(text,"Mom",R.drawable.img_ibus));
                mTitle.add(new ObjekBahasaIsyarat(text,"Brother",R.drawable.img_kakaks));
                mTitle.add(new ObjekBahasaIsyarat(text,"Sister",R.drawable.img_adiks));
                mTitle.add(new ObjekBahasaIsyarat(text,"Grandpa",R.drawable.img_kakeks));
                mTitle.add(new ObjekBahasaIsyarat(text,"Grandma",R.drawable.img_neneks));
                break;
            case "Food":
                mTitle.add(new ObjekBahasaIsyarat(text,"Rice",R.drawable.img_nasi));
                mTitle.add(new ObjekBahasaIsyarat(text,"Vegetable",R.drawable.img_sayur));
                mTitle.add(new ObjekBahasaIsyarat(text,"Cake",R.drawable.img_kueh));
                mTitle.add(new ObjekBahasaIsyarat(text,"Candy",R.drawable.img_permen));
                mTitle.add(new ObjekBahasaIsyarat(text,"Water",R.drawable.img_airs));
                break;
            case "Expressions":
                mTitle.add(new ObjekBahasaIsyarat(text,"Halo",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"Thanks",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"Congratulation",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"Sorry",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"Forgive",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"You're Welcome",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"Assalamualaikum",R.drawable.img_0));
                break;
            case "Question":
                mTitle.add(new ObjekBahasaIsyarat(text,"What",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"When",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"Where",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"Who",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"Why",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"How",R.drawable.img_0));
                break;
            case "Pronoun":
                mTitle.add(new ObjekBahasaIsyarat(text,"Me",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"You",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"Us",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"We",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"They",R.drawable.img_0));
                break;
            case "Feelings":
                mTitle.add(new ObjekBahasaIsyarat(text,"Happy",R.drawable.img_senang));
                mTitle.add(new ObjekBahasaIsyarat(text,"Sad",R.drawable.img_sedih));
                mTitle.add(new ObjekBahasaIsyarat(text,"Angry",R.drawable.img_marah));
                mTitle.add(new ObjekBahasaIsyarat(text,"Shy",R.drawable.img_malu));
                mTitle.add(new ObjekBahasaIsyarat(text,"Hurt",R.drawable.img_sakit));
                mTitle.add(new ObjekBahasaIsyarat(text,"Lazy",R.drawable.img_males));
                mTitle.add(new ObjekBahasaIsyarat(text,"Tired",R.drawable.img_capek));
                break;
            case "Rasa":
                mTitle.add(new ObjekBahasaIsyarat(text,"Sweet",R.drawable.img_manis));
                mTitle.add(new ObjekBahasaIsyarat(text,"Salty",R.drawable.img_asin));
                mTitle.add(new ObjekBahasaIsyarat(text,"Spicy",R.drawable.img_pedas));
                mTitle.add(new ObjekBahasaIsyarat(text,"Bitter",R.drawable.img_0));
                mTitle.add(new ObjekBahasaIsyarat(text,"Sour",R.drawable.img_0));
                break;
        }
    }

    @Override
    public void OnTitleClick(int position) {
        String videopath = Environment.getExternalStorageDirectory() + "/Video/" + mTextview.getText().toString() + "/" + mTitle.get(position).getTitle() + ".mp4";
        Intent intent = new Intent(this, VideoPlayerActivity.class);
        intent.putExtra(EXTRA_TEXT, videopath);
        intent.putExtra(EXTRA_TEXT2, mTitle.get(position).getTitle());
        intent.putExtra(EXTRA_TEXT3, mTextview.getText().toString());
        startActivity(intent);
    }
}
