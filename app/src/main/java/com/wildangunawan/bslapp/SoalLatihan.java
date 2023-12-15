package com.wildangunawan.bslapp;

public class SoalLatihan {
    private String soalLatihan, jawaban_a, jawaban_b, jawaban_c, jawaban_d, jawaban_benar, videoUrl;

    public SoalLatihan(String soal,String jwbn_a,String jwbn_b,String jwbn_c,String jwbn_d,String jwbn_benar, String vidUrl){
        this.soalLatihan = soal;
        this.jawaban_a = jwbn_a;
        this.jawaban_b = jwbn_b;
        this.jawaban_c = jwbn_c;
        this.jawaban_d = jwbn_d;
        this.jawaban_benar = jwbn_benar;
        this.videoUrl = vidUrl;
    }

    public String getSoalLatihan() {
        return soalLatihan;
    }

    public void setSoalLatihan(String soalLatihan) {
        this.soalLatihan = soalLatihan;
    }

    public String getJawaban_a() {
        return jawaban_a;
    }

    public void setJawaban_a(String jawaban_a) {
        this.jawaban_a = jawaban_a;
    }

    public String getJawaban_b() {
        return jawaban_b;
    }

    public void setJawaban_b(String jawaban_b) {
        this.jawaban_b = jawaban_b;
    }

    public String getJawaban_c() {
        return jawaban_c;
    }

    public void setJawaban_c(String jawaban_c) {
        this.jawaban_c = jawaban_c;
    }

    public String getJawaban_d() {
        return jawaban_d;
    }

    public void setJawaban_d(String jawaban_d) {
        this.jawaban_d = jawaban_d;
    }

    public String getJawaban_benar() {
        return jawaban_benar;
    }

    public void setJawaban_benar(String jawaban_benar) {
        this.jawaban_benar = jawaban_benar;
    }

    public String getVidUrl() {
        return videoUrl;
    }

    public void setVidUrl(String vidUrl) {
        this.videoUrl = vidUrl;
    }
}
