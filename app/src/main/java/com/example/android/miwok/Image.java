package com.example.android.miwok;

public class Image {
    String mwk,eng;
    private final int NOIMAGE=-1;
    int img_id=NOIMAGE;
    int audio;
    public Image(String miwok,String english,int audio_id)
    {
        mwk=miwok;
        eng=english;
        audio=audio_id;
    }
    public Image(int audio_id,String miwok,String english)
    {
        mwk=miwok;
        eng=english;
        audio=audio_id;
    }
    public Image(String miwok,String english,int img_id,int audio_id)
    {
        mwk=miwok;
        eng=english;
        this.img_id=img_id;
        audio=audio_id;
    }
    public String getMwk()
    {
        return mwk;
    }
    public int getImg_id()
    {
        return this.img_id;
    }
    public boolean hasImage()
    {
        return img_id!=NOIMAGE;
    }

    public String getEng() {
        return eng;
    }

    public int getAudio() {
        return audio;
    }

    @Override
    public String toString() {
        return "Image{" +
                "mwk='" + mwk + '\'' +
                ", eng='" + eng + '\'' +
                ", NOIMAGE=" + NOIMAGE +
                ", img_id=" + img_id +
                ", audio=" + audio +
                '}';
    }
}
