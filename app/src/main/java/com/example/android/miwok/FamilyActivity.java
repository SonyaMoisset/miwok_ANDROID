package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getResources().getString(R.string.family_father_eng), getResources().getString(R.string.family_father_miwok)));
        words.add(new Word(getResources().getString(R.string.family_mother_eng), getResources().getString(R.string.family_mother_miwok)));
        words.add(new Word(getResources().getString(R.string.family_son_eng), getResources().getString(R.string.family_son_miwok)));
        words.add(new Word(getResources().getString(R.string.family_daughter_eng), getResources().getString(R.string.family_daughter_miwok)));
        words.add(new Word(getResources().getString(R.string.family_older_brother_eng), getResources().getString(R.string.family_older_brother_miwok)));
        words.add(new Word(getResources().getString(R.string.family_younger_brother_eng), getResources().getString(R.string.family_younger_brother_miwok)));
        words.add(new Word(getResources().getString(R.string.family_older_sister_eng), getResources().getString(R.string.family_older_sister_miwok)));
        words.add(new Word(getResources().getString(R.string.family_younger_sister_eng), getResources().getString(R.string.family_younger_sister_miwok)));
        words.add(new Word(getResources().getString(R.string.family_grandmother_eng), getResources().getString(R.string.family_grandmother_miwok)));
        words.add(new Word(getResources().getString(R.string.family_grandfather_eng), getResources().getString(R.string.family_grandfather_miwok)));

        WordAdapter wordsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordsAdapter);
    }
}