package com.example.macbook.theapp.media;

import android.app.Activity;
import android.media.MediaPlayer;

import com.example.macbook.theapp.R;

/**
 * Created by owner on 10/28/2014.
 */
public class SoundPlayer {
    static int[] RAW_FILES_IDS = new int[] {
            R.raw.female1ahhhh,
            R.raw.female2bigboy,
            R.raw.female3stud,
            R.raw.female4button,
            R.raw.male1babygirl,
            R.raw.male2hot,
            R.raw.male3hottie
};

    static void playSound(Activity activity, int index) {

        final MediaPlayer mp = MediaPlayer.create(activity, RAW_FILES_IDS[index]);
        mp.start();

    }
}
