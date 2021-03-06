package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
        }
        mMediaPlayer = null;
        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
    }

    public PhrasesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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

        WordAdapter wordsAdapter = new WordAdapter(getActivity(), words, R.color.category_phrases);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(wordsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                releaseMediaPlayer();

                Word word = words.get(position);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }
}
