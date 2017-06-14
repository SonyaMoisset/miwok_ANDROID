package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getResources().getString(R.string.number_one_eng), getResources().getString(R.string.number_one_miwok)));
        words.add(new Word(getResources().getString(R.string.number_two_eng), getResources().getString(R.string.number_two_miwok)));
        words.add(new Word(getResources().getString(R.string.number_three_eng), getResources().getString(R.string.number_three_miwok)));
        words.add(new Word(getResources().getString(R.string.number_four_eng), getResources().getString(R.string.number_four_miwok)));
        words.add(new Word(getResources().getString(R.string.number_five_eng), getResources().getString(R.string.number_five_miwok)));
        words.add(new Word(getResources().getString(R.string.number_six_eng), getResources().getString(R.string.number_six_miwok)));
        words.add(new Word(getResources().getString(R.string.number_seven_eng), getResources().getString(R.string.number_seven_miwok)));
        words.add(new Word(getResources().getString(R.string.number_eight_eng), getResources().getString(R.string.number_eight_miwok)));
        words.add(new Word(getResources().getString(R.string.number_nine_eng), getResources().getString(R.string.number_nine_miwok)));
        words.add(new Word(getResources().getString(R.string.number_ten_eng), getResources().getString(R.string.number_ten_miwok)));

        WordAdapter wordsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordsAdapter);
    }
}
