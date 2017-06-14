package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getResources().getString(R.string.color_red_eng), getResources().getString(R.string.color_red_miwok)));
        words.add(new Word(getResources().getString(R.string.color_green_eng), getResources().getString(R.string.color_green_miwok)));
        words.add(new Word(getResources().getString(R.string.color_brown_eng), getResources().getString(R.string.color_brown_miwok)));
        words.add(new Word(getResources().getString(R.string.color_gray_eng), getResources().getString(R.string.color_gray_miwok)));
        words.add(new Word(getResources().getString(R.string.color_black_eng), getResources().getString(R.string.color_black_miwok)));
        words.add(new Word(getResources().getString(R.string.color_white_eng), getResources().getString(R.string.color_white_miwok)));
        words.add(new Word(getResources().getString(R.string.color_dusty_yellow_eng), getResources().getString(R.string.color_dusty_yellow_miwok)));
        words.add(new Word(getResources().getString(R.string.color_mustard_yellow_eng), getResources().getString(R.string.color_mustard_yellow_miwok)));

        WordAdapter wordsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordsAdapter);
    }
}