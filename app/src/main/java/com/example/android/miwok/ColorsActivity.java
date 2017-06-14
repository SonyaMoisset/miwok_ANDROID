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

        ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word(getResources().getString(R.string.color_red_eng), getResources().getString(R.string.color_red_miwok)));
        colors.add(new Word(getResources().getString(R.string.color_green_eng), getResources().getString(R.string.color_green_miwok)));
        colors.add(new Word(getResources().getString(R.string.color_brown_eng), getResources().getString(R.string.color_brown_miwok)));
        colors.add(new Word(getResources().getString(R.string.color_gray_eng), getResources().getString(R.string.color_gray_miwok)));
        colors.add(new Word(getResources().getString(R.string.color_black_eng), getResources().getString(R.string.color_black_miwok)));
        colors.add(new Word(getResources().getString(R.string.color_white_eng), getResources().getString(R.string.color_white_miwok)));
        colors.add(new Word(getResources().getString(R.string.color_dusty_yellow_eng), getResources().getString(R.string.color_dusty_yellow_miwok)));
        colors.add(new Word(getResources().getString(R.string.color_mustard_yellow_eng), getResources().getString(R.string.color_mustard_yellow_miwok)));

        WordAdapter wordsAdapter = new WordAdapter(this, colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordsAdapter);
    }
}
