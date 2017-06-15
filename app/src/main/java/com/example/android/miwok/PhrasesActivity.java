package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getResources().getString(R.string.phrase_where_are_you_going_eng), getResources().getString(R.string.phrase_where_are_you_going_miwok), R.raw.phrase_where_are_you_going));
        words.add(new Word(getResources().getString(R.string.phrase_what_is_your_name_eng), getResources().getString(R.string.phrase_what_is_your_name_miwok), R.raw.phrase_what_is_your_name));
        words.add(new Word(getResources().getString(R.string.phrase_my_name_is_eng), getResources().getString(R.string.phrase_my_name_is_miwok), R.raw.phrase_my_name_is));
        words.add(new Word(getResources().getString(R.string.phrase_how_are_you_feeling_eng), getResources().getString(R.string.phrase_how_are_you_feeling_miwok), R.raw.phrase_how_are_you_feeling));
        words.add(new Word(getResources().getString(R.string.phrase_im_feeling_good_eng), getResources().getString(R.string.phrase_im_feeling_good_miwok), R.raw.phrase_im_feeling_good));
        words.add(new Word(getResources().getString(R.string.phrase_are_you_coming_eng), getResources().getString(R.string.phrase_are_you_coming_miwok), R.raw.phrase_are_you_coming));
        words.add(new Word(getResources().getString(R.string.phrase_yes_im_coming_eng), getResources().getString(R.string.phrase_yes_im_coming_miwok), R.raw.phrase_yes_im_coming));
        words.add(new Word(getResources().getString(R.string.phrase_im_coming_eng), getResources().getString(R.string.phrase_im_coming_miwok), R.raw.phrase_im_coming));
        words.add(new Word(getResources().getString(R.string.phrase_lets_go_eng), getResources().getString(R.string.phrase_lets_go_miwok), R.raw.phrase_lets_go));
        words.add(new Word(getResources().getString(R.string.phrase_come_here_eng), getResources().getString(R.string.phrase_come_here_miwok), R.raw.phrase_come_here));

        WordAdapter wordsAdapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(wordsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);

                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}