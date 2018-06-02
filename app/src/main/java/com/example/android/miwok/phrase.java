package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class phrase extends AppCompatActivity {
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

        final ArrayList<Image> phrases = new ArrayList<Image>();

        phrases.add(new Image(R.raw.phrase_where_are_you_going,"minto wuksus", "Where are you going?"));
        phrases.add(new Image(R.raw.phrase_what_is_your_name,"tinnә oyaase'nә", "What is your name?"));
        phrases.add(new Image(R.raw.phrase_my_name_is,"oyaaset...", "My name is..."));
        phrases.add(new Image(R.raw.phrase_how_are_you_feeling,"michәksәs?", "How are you feeling?"));
        phrases.add(new Image(R.raw.phrase_im_feeling_good," kuchi achit", " I’m feeling good."));
        phrases.add(new Image(R.raw.phrase_are_you_coming,"әәnәs'aa?", "Are you coming?"));
        phrases.add(new Image(R.raw.phrase_yes_im_coming,"hәә’ әәnәm", "Yes, I’m coming."));
        phrases.add(new Image(R.raw.phrase_im_coming,"әәnәm", " I’m coming."));
        phrases.add(new Image(R.raw.phrase_lets_go,"yoowutis", "Let’s go."));
        phrases.add(new Image(R.raw.phrase_come_here,"әnni'nem", "Come here."));

        final ImageAdapter phraseAdapt = new ImageAdapter(this, phrases,R.color.phraseCategory);
        ListView listview=findViewById(R.id.list);
        listview.setAdapter(phraseAdapt);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Image currentImage=phrases.get(i);
                releaseMediaPlayer();

                    mmediaplayer = MediaPlayer.create(phrase.this, currentImage.getAudio());

                    mmediaplayer.start();
                    mmediaplayer.setOnCompletionListener(mMediaplayerListener);


            }
        });


    }
}
