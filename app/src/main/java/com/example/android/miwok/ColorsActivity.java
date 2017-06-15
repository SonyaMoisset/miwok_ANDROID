package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getResources().getString(R.string.color_red_eng), getResources().getString(R.string.color_red_miwok), R.drawable.color_red, R.raw.color_red));
        words.add(new Word(getResources().getString(R.string.color_green_eng), getResources().getString(R.string.color_green_miwok), R.drawable.color_green, R.raw.color_green));
        words.add(new Word(getResources().getString(R.string.color_brown_eng), getResources().getString(R.string.color_brown_miwok), R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word(getResources().getString(R.string.color_gray_eng), getResources().getString(R.string.color_gray_miwok), R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word(getResources().getString(R.string.color_black_eng), getResources().getString(R.string.color_black_miwok), R.drawable.color_black, R.raw.color_black));
        words.add(new Word(getResources().getString(R.string.color_white_eng), getResources().getString(R.string.color_white_miwok), R.drawable.color_white, R.raw.color_white));
        words.add(new Word(getResources().getString(R.string.color_dusty_yellow_eng), getResources().getString(R.string.color_dusty_yellow_miwok), R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word(getResources().getString(R.string.color_mustard_yellow_eng), getResources().getString(R.string.color_mustard_yellow_miwok), R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter wordsAdapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(wordsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);

                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}