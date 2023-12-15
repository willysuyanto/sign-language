package com.wildangunawan.bslapp;

import android.app.Dialog;
import android.content.ClipData;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class GameRumahActivity extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener {

    private static final String TAG = GameRumahActivity.class.getSimpleName();
    private static final String IMAGE_VIEW_TAG_AYAH = "Ayah";
    private static final String IMAGE_VIEW_TAG_IBU = "Ibu";
    private static final String IMAGE_VIEW_TAG_KAKAK = "Kakak";
    private static final String IMAGE_VIEW_TAG_ADIK = "Adik";
    private static final String IMAGE_VIEW_TAG_KAKEK = "Kakek";
    private static final String IMAGE_VIEW_TAG_NENEK = "Nenek";
    private ImageView imgAyah,imgIbu,imgAdik,imgKakak,imgKakek,imgNenek,imgAyahPutih,imgIbuPutih,imgKakakPutih,imgAdikPutih,imgKakekPutih,imgNenekPutih;
    private int draggedItem;
    private Dialog popupDialog,popupVideo;
    private ImageButton buttonUlang;
    private Button buttonClose;
    private VideoView VideoPlayer;
    private ImageView imageBenar;
    private TextView TextJudul;
    private int Benar;
    private RelativeLayout layoutPilihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_rumah);
        popupDialog = new Dialog(this);
        popupVideo = new Dialog(this);
        InisiasiView();
        ImplementasiEventListerner();
    }

    public void InisiasiView(){
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
        layoutPilihan = findViewById(R.id.layout_pilihan);

    }

    public void ImplementasiEventListerner(){
        //Memilih View yang bisa di drag and drop
        imgAyah.setOnTouchListener(this);
        imgIbu.setOnTouchListener(this);
        imgAdik.setOnTouchListener(this);
        imgKakak.setOnTouchListener(this);
        imgNenek.setOnTouchListener(this);
        imgKakek.setOnTouchListener(this);
        imgAyahPutih.setOnDragListener(this);
        imgNenekPutih.setOnDragListener(this);
        imgKakekPutih.setOnDragListener(this);
        imgIbuPutih.setOnDragListener(this);
        imgAdikPutih.setOnDragListener(this);
        imgKakakPutih.setOnDragListener(this);
        layoutPilihan.setOnDragListener(this);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ClipData clipData = ClipData.newPlainText("","");
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        view.startDrag(clipData,shadowBuilder,view,0);
        view.setVisibility(View.INVISIBLE);
        draggedItem = view.getId();
        return true;
    }

    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        int action = dragEvent.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_ENTERED:
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DROP:
                if(view.getId()==R.id.img_ayah_putih && draggedItem==R.id.img_ayah ){
                    Benar++;
                    Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();
                    imgAyahPutih.setImageResource(R.drawable.img_ayah);
                    showPopupBenar("/storage/emulated/0/Video/Keluarga/Ayah.mp4","Ayah");
                }
                else if(view.getId()==R.id.img_ibu_putih && draggedItem==R.id.img_ibu){
                    Benar++;
                    Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();
                    imgIbuPutih.setImageResource(R.drawable.img_ibu);
                    showPopupBenar("/storage/emulated/0/Video/Keluarga/Ibu.mp4","Ibu");
                }
                else if(view.getId()==R.id.img_adik_putih && draggedItem==R.id.img_adik){
                    Benar++;
                    Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();
                    imgAdikPutih.setImageResource(R.drawable.img_adik);
                    showPopupBenar("/storage/emulated/0/Video/Keluarga/Adik.mp4","Adik");
                }
                else if(view.getId()==R.id.img_kakak_putih && draggedItem==R.id.img_kakak){
                    Benar++;
                    Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();
                    imgKakakPutih.setImageResource(R.drawable.img_kakak);
                    showPopupBenar("/storage/emulated/0/Video/Keluarga/Kakak.mp4","Kakak");
                }
                else if(view.getId()==R.id.img_kakek_putih && draggedItem==R.id.img_kakek){
                    Benar++;
                    Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();
                    imgKakekPutih.setImageResource(R.drawable.img_kakek);
                    showPopupBenar("/storage/emulated/0/Video/Keluarga/Kakek.mp4","Kakek");
                }
                else if(view.getId()==R.id.img_nenek_putih && draggedItem==R.id.img_nenek){
                    Benar++;
                    Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();
                    imgNenekPutih.setImageResource(R.drawable.img_nenek);
                    showPopupBenar("/storage/emulated/0/Video/Keluarga/Nenek.mp4","Nenek");
                }
                else if(view.getId()!=R.id.img_ayah_putih && draggedItem == imgAyah.getId()){
                    imgAyah.setVisibility(View.VISIBLE);
                }
                else if(view.getId()!=R.id.img_ibu_putih && draggedItem == imgIbu.getId()){
                    imgIbu.setVisibility(View.VISIBLE);
                }
                else if(view.getId()!=R.id.img_kakak_putih && draggedItem == imgKakak.getId()){
                    imgKakak.setVisibility(View.VISIBLE);
                }
                else if(view.getId()!=R.id.img_adik_putih && draggedItem == imgAdik.getId()){
                    imgAdik.setVisibility(View.VISIBLE);
                }
                else if(view.getId()!=R.id.img_kakek_putih && draggedItem == imgKakek.getId()){
                    imgKakek.setVisibility(View.VISIBLE);
                }
                else if(view.getId()!=R.id.img_nenek_putih && draggedItem == imgNenek.getId()){
                    imgNenek.setVisibility(View.VISIBLE);
                } else if(view.getId()==R.id.layout_pilihan){
                    if(draggedItem == R.id.img_ayah){
                        imgAyah.setVisibility(View.VISIBLE);
                    } else if (draggedItem == R.id.img_ibu){
                        imgIbu.setVisibility(View.VISIBLE);
                    }else if (draggedItem == R.id.img_adik){
                        imgAdik.setVisibility(View.VISIBLE);
                    }else if (draggedItem == R.id.img_kakak){
                        imgKakak.setVisibility(View.VISIBLE);
                    }else if (draggedItem == R.id.img_nenek){
                        imgNenek.setVisibility(View.VISIBLE);
                    }else if (draggedItem == R.id.img_kakek){
                        imgKakek.setVisibility(View.VISIBLE);
                    }
                }
                break;
        }
        return true;
    }

    public void showPopupBenar(final String UrlVideo, final String judul){
        popupDialog.setContentView(R.layout.popup_benar_game);
        imageBenar = popupDialog.findViewById(R.id.ImageBenar);
        popupDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                popupDialog.dismiss();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ShowVideo(UrlVideo,judul);
                    }
                });
            }
        }).start();


    }

    public void ShowVideo(String Url, String judul){
        popupVideo.setContentView(R.layout.popup_video);
        buttonClose = popupVideo.findViewById(R.id.buttonClose);
        buttonUlang = popupVideo.findViewById(R.id.ulangVideo);
        VideoPlayer = popupVideo.findViewById(R.id.videopopup);
        TextJudul = popupVideo.findViewById(R.id.juduls);


        Uri uri = Uri.parse(Url);
        VideoPlayer.setVideoURI(uri);

        popupVideo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupVideo.show();

        VideoPlayer.start();
        TextJudul.setText(judul);

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Benar==6){
                    Toast.makeText(GameRumahActivity.this, "Selamat, level telah selesai", Toast.LENGTH_SHORT).show();
                    finish();
                }
                popupVideo.dismiss();
            }
        });

        buttonUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoPlayer.start();
            }
        });


    }

}
