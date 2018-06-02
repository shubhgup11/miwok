package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class colors extends AppCompatActivity {

    private MediaPlayer mmediaplayer;

    private MediaPlayer.OnCompletionListener mMediaplayerListener= new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    private void releaseMediaPlayer() {
        if (mmediaplayer != null) {
            mmediaplayer.release();
            mmediaplayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

         final ArrayList<Image> color_names=new ArrayList<Image>();
        color_names.add(new Image("weṭeṭṭi","red",R.drawable.color_red,R.raw.color_red));
        color_names.add(new Image("chokokki","green",R.drawable.color_green,R.raw.color_green));
        color_names.add(new Image("ṭakaakki","brown",R.drawable.color_brown,R.raw.color_brown));
        color_names.add(new Image(" ṭopoppi"," gray",R.drawable.color_gray,R.raw.color_gray));
        color_names.add(new Image("kululli","black",R.drawable.color_black,R.raw.color_black));
        color_names.add(new Image("kelelli"," white",R.drawable.color_white,R.raw.color_white));
        color_names.add(new Image("ṭopiisә","dusty yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        color_names.add(new Image("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
     //   color_names.add(new Image("",""),R.mipmap.ic_launcher);
      //  color_names.add(new Image("",""),R.mipmap.ic_launcher);


        final ImageAdapter colorAdapt=new ImageAdapter(this,color_names,R.color.colorsCategory);
        ListView listview=findViewById(R.id.list);
        listview.setAdapter(colorAdapt);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Image currentImage=color_names.get(i);
                mmediaplayer=MediaPlayer.create(colors.this,currentImage.getAudio());
                mmediaplayer.start();
                mmediaplayer.setOnCompletionListener(mMediaplayerListener);
            }
        });
        //
    }
}
