package com.tikhanovesy.aplikasimarble;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GameRumahActivity extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener {

    private static final String TAG = GameRumahActivity.class.getSimpleName();
    private RelativeLayout LayoutPilihan,LayoutJawaban;
    private static final String IMAGE_VIEW_TAG_AYAH = "Ayah";
    private static final String IMAGE_VIEW_TAG_IBU = "Ibu";
    private static final String IMAGE_VIEW_TAG_KAKAK = "Kakak";
    private static final String IMAGE_VIEW_TAG_ADIK = "Adik";
    private static final String IMAGE_VIEW_TAG_KAKEK = "Kakek";
    private static final String IMAGE_VIEW_TAG_NENEK = "Nenek";
    private ImageView imgAyah,imgIbu,imgAdik,imgKakak,imgKakek,imgNenek,imgAyahPutih,imgIbuPutih,imgKakakPutih,imgAdikPutih,imgKakekPutih,imgNenekPutih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_rumah);
        InisiasiView();
        ImplementasiEventListerner();
    }

    public void InisiasiView(){
        LayoutPilihan = findViewById(R.id.layout_pilihan);
        imgAyah = findViewById(R.id.img_ayah);
        imgAyah.setTag(IMAGE_VIEW_TAG_AYAH);
        imgIbu = findViewById(R.id.img_ibu);
        imgIbu.setTag(IMAGE_VIEW_TAG_IBU);
        imgKakak = findViewById(R.id.img_kakak);
        imgKakak.setTag(IMAGE_VIEW_TAG_KAKAK);
        imgAdik = findViewById(R.id.img_adik);
        imgAdik.setTag(IMAGE_VIEW_TAG_ADIK);
        imgNenek = findViewById(R.id.img_nenek);
        imgNenek.setTag(IMAGE_VIEW_TAG_NENEK);
        imgKakek = findViewById(R.id.img_kakek);
        imgKakek.setTag(IMAGE_VIEW_TAG_KAKEK);
        imgAyahPutih = findViewById(R.id.img_ayah_putih);
        imgIbuPutih = findViewById(R.id.img_ibu_putih);
        imgAdikPutih = findViewById(R.id.img_adik_putih);
        imgKakakPutih = findViewById(R.id.img_kakak_putih);
        imgKakekPutih = findViewById(R.id.img_kakek_putih);
        imgNenekPutih = findViewById(R.id.img_nenek_putih);

    }

    public void ImplementasiEventListerner(){
        //Memilih View yang bisa di drag and drop
        imgAyah.setOnTouchListener(this);
        imgIbu.setOnTouchListener(this);
        imgAdik.setOnTouchListener(this);
        imgKakak.setOnTouchListener(this);
        imgNenek.setOnTouchListener(this);
        imgKakek.setOnTouchListener(this);
        LayoutPilihan.setOnDragListener(this);

    }

    //last coordinates
    float lastX;
    float lastY;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                view.bringToFront();
                lastX = motionEvent.getRawX();
                lastY = motionEvent.getRawY();
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(null, shadowBuilder, view, 0);
                return true;
            }

            case MotionEvent.ACTION_MOVE: {

                //motion difference
                float deltaX = motionEvent.getRawX() - lastX;
                float deltaY = motionEvent.getRawY() - lastY;

                //set new last coordinates
                lastX = motionEvent.getRawX();
                lastY = motionEvent.getRawY();

                view.setX(view.getX() + deltaX);
                view.setY(view.getY() + deltaY);
            }
        }

        return false;
    }

    public boolean CheckCollision(View v1,View v2) {
        Rect R1=new Rect(v1.getLeft(), v1.getTop(), v1.getRight(), v1.getBottom());
        Rect R2=new Rect(v2.getLeft(), v2.getTop(), v2.getRight(), v2.getBottom());
        return R1.intersect(R2);
    }

    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {

        int action = dragEvent.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                // do nothing
            case DragEvent.ACTION_DRAG_ENTERED:

            case DragEvent.ACTION_DRAG_EXITED:

            case DragEvent.ACTION_DROP:
                imgAyah.setVisibility(View.INVISIBLE);
            case DragEvent.ACTION_DRAG_ENDED:
        }
        return true;
    }
}
