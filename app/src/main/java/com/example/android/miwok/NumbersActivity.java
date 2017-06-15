package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getResources().getString(R.string.number_one_eng), getResources().getString(R.string.number_one_miwok), R.drawable.number_one, R.raw.number_one));
        words.add(new Word(getResources().getString(R.string.number_two_eng), getResources().getString(R.string.number_two_miwok), R.drawable.number_two, R.raw.number_two));
        words.add(new Word(getResources().getString(R.string.number_three_eng), getResources().getString(R.string.number_three_miwok), R.drawable.number_three, R.raw.number_three));
        words.add(new Word(getResources().getString(R.string.number_four_eng), getResources().getString(R.string.number_four_miwok), R.drawable.number_four, R.raw.number_four));
        words.add(new Word(getResources().getString(R.string.number_five_eng), getResources().getString(R.string.number_five_miwok), R.drawable.number_five, R.raw.number_five));
        words.add(new Word(getResources().getString(R.string.number_six_eng), getResources().getString(R.string.number_six_miwok), R.drawable.number_six, R.raw.number_six));
        words.add(new Word(getResources().getString(R.string.number_seven_eng), getResources().getString(R.string.number_seven_miwok), R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word(getResources().getString(R.string.number_eight_eng), getResources().getString(R.string.number_eight_miwok), R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word(getResources().getString(R.string.number_nine_eng), getResources().getString(R.string.number_nine_miwok), R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word(getResources().getString(R.string.number_ten_eng), getResources().getString(R.string.number_ten_miwok), R.drawable.number_ten, R.raw.number_ten));

        WordAdapter wordsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(wordsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}