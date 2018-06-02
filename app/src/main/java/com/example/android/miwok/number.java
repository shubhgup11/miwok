package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class number extends AppCompatActivity {
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

        final ArrayList<Image> words = new ArrayList<Image>();
        words.add(new Image("lutti", "one", R.drawable.number_one, R.raw.number_one));
        words.add(new Image("otiiko", "two", R.drawable.number_two, R.raw.number_two));
        words.add(new Image("tolookosu", "three", R.drawable.number_three, R.raw.number_three));
        words.add(new Image("oyiisa", "four", R.drawable.number_four, R.raw.number_four));
        words.add(new Image("massokka", "five", R.drawable.number_five, R.raw.number_five));
        words.add(new Image("temokka", "six", R.drawable.number_six, R.raw.number_six));
        words.add(new Image("kenekaku", "seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Image("kawinta", "eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Image("wo'e", "nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Image("na'aacha", "ten", R.drawable.number_ten, R.raw.number_ten));


        //  LinearLayout rootview =(LinearLayout)findViewById(R.id.root_view);

        final ImageAdapter adapt = new ImageAdapter(this, words,R.color.numberCategory);
        ListView listview = findViewById(R.id.list);
        listview.setAdapter(adapt);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Image currentImage = words.get(i);
                 mmediaplayer = MediaPlayer.create(number.this, currentImage.getAudio());
                mmediaplayer.start();
                mmediaplayer.setOnCompletionListener(mmediaplayerListener);
            }
        });

    }

}
