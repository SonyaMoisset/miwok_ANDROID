package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getResources().getString(R.string.phrase_where_are_you_going_eng), getResources().getString(R.string.phrase_where_are_you_going_miwok)));
        words.add(new Word(getResources().getString(R.string.phrase_what_is_your_name_eng), getResources().getString(R.string.phrase_what_is_your_name_miwok)));
        words.add(new Word(getResources().getString(R.string.phrase_my_name_is_eng), getResources().getString(R.string.phrase_my_name_is_miwok)));
        words.add(new Word(getResources().getString(R.string.phrase_how_are_you_feeling_eng), getResources().getString(R.string.phrase_how_are_you_feeling_miwok)));
        words.add(new Word(getResources().getString(R.string.phrase_im_feeling_good_eng), getResources().getString(R.string.phrase_im_feeling_good_miwok)));
        words.add(new Word(getResources().getString(R.string.phrase_are_you_coming_eng), getResources().getString(R.string.phrase_are_you_coming_miwok)));
        words.add(new Word(getResources().getString(R.string.phrase_yes_im_coming_eng), getResources().getString(R.string.phrase_yes_im_coming_miwok)));
        words.add(new Word(getResources().getString(R.string.phrase_im_coming_eng), getResources().getString(R.string.phrase_im_coming_miwok)));
        words.add(new Word(getResources().getString(R.string.phrase_lets_go_eng), getResources().getString(R.string.phrase_lets_go_miwok)));
        words.add(new Word(getResources().getString(R.string.phrase_come_here_eng), getResources().getString(R.string.phrase_come_here_miwok)));

        WordAdapter wordsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordsAdapter);
    }
}