package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class family extends AppCompatActivity {
    private MediaPlayer mmediaplayer;
    MediaPlayer.OnCompletionListener mmediaplayerListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    private void releaseMediaPlayer()
    {
        if(mmediaplayer!=null)
            mmediaplayer.release();
        mmediaplayer=null;
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

        final ArrayList<Image> family_names =new ArrayList<Image>();

        family_names.add(new Image("әpә","father",R.drawable.family_father,R.raw.family_father));
        family_names.add(new Image("әṭa","mother",R.drawable.family_mother,R.raw.family_mother));
        family_names.add(new Image("angsi","son",R.drawable.family_son,R.raw.family_son));
        family_names.add(new Image(" tune","daughter",R.drawable.family_daughter,R.raw.family_daughter));
        family_names.add(new Image("taachi","older brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        family_names.add(new Image("chalitti","younger brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        family_names.add(new Image("teṭe","older sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        family_names.add(new Image("kolliti","younger sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        family_names.add(new Image("ama","grandmother",R.drawable.family_grandmother,R.raw.family_grandmother));
        family_names.add(new Image("paapa","grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));

        final ImageAdapter familyAdapt= new ImageAdapter(this,family_names,R.color.familyCategory);
        ListView listview=findViewById(R.id.list);
        listview.setAdapter(familyAdapt);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Image currentImage=family_names.get(i);
                mmediaplayer=MediaPlayer.create(family.this,currentImage.getAudio());
                mmediaplayer.start();
                mmediaplayer.setOnCompletionListener(mmediaplayerListener);
            }
        });
        //
    }

}
