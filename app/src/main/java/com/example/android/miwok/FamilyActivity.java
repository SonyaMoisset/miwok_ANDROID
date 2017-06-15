package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getResources().getString(R.string.family_father_eng), getResources().getString(R.string.family_father_miwok), R.drawable.family_father, R.raw.family_father));
        words.add(new Word(getResources().getString(R.string.family_mother_eng), getResources().getString(R.string.family_mother_miwok), R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word(getResources().getString(R.string.family_son_eng), getResources().getString(R.string.family_son_miwok), R.drawable.family_son, R.raw.family_son));
        words.add(new Word(getResources().getString(R.string.family_daughter_eng), getResources().getString(R.string.family_daughter_miwok), R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word(getResources().getString(R.string.family_older_brother_eng), getResources().getString(R.string.family_older_brother_miwok), R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word(getResources().getString(R.string.family_younger_brother_eng), getResources().getString(R.string.family_younger_brother_miwok), R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word(getResources().getString(R.string.family_older_sister_eng), getResources().getString(R.string.family_older_sister_miwok), R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word(getResources().getString(R.string.family_younger_sister_eng), getResources().getString(R.string.family_younger_sister_miwok), R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word(getResources().getString(R.string.family_grandmother_eng), getResources().getString(R.string.family_grandmother_miwok), R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word(getResources().getString(R.string.family_grandfather_eng), getResources().getString(R.string.family_grandfather_miwok), R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter wordsAdapter = new WordAdapter(this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(wordsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);

                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}