package com.tikhanovesy.aplikasimarble;

public class ObjekBahasaIsyarat {
    private String Title;
    private String Subtitle;
    private int Image;

    public ObjekBahasaIsyarat(String subtitle,String title, int image) {
        Title = title;
        Subtitle = subtitle;
        Image = image;
    }

    public String getSubtitle() {
        return Subtitle;
    }

    public void setSubtitle(String subtitle) {
        Subtitle = subtitle;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
