package com.example.macbook.theapp;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;

import java.util.Random;

/**
 * Created by macbook on 10/28/14.
 */
public class ClassicSingleton {


        private static ClassicSingleton instance = null;
        private Sex sex;
        private int order;

        private enum Sex{
            MAN,WOMAN,NONE
        }


        protected ClassicSingleton() {
            // Exists only to defeat instantiation.
        }
        public static ClassicSingleton getInstance() {
            if(instance == null) {
                instance = new ClassicSingleton();
                instance.setWoman();
            }
            return instance;
        }

        static int[] RAW_FILES_IDS_FEMALE = new int[]{
                R.raw.female1ahhhh,
                R.raw.female2bigboy,
                R.raw.female3stud,
                R.raw.female4button,

        };

        static int[] RAW_FILES_IDS_MALE = new int[]{
                R.raw.male1babygirl,
                R.raw.male2hot,
                R.raw.male3hottie
        };

        public void playSound(Context context) {

            if( this.sex== Sex.WOMAN){
                Random index = new Random();
                final MediaPlayer mp = MediaPlayer.create(context, RAW_FILES_IDS_FEMALE[index.nextInt(4)]);
                mp.start();
            }

            else if (this.sex== Sex.MAN) {
                Random index = new Random();
                final MediaPlayer mp = MediaPlayer.create(context, RAW_FILES_IDS_MALE[index.nextInt(3)]);
                mp.start();

            }


    }


        public boolean isMan(){
            return sex == Sex.MAN;
        }

        public void setMan(){
            sex = Sex.MAN;
        }

        public boolean isWoman() {
            return sex == Sex.WOMAN;
        }

        public void setWoman() {
            sex = Sex.WOMAN;
        }

        public void setNone (){
            sex = Sex.NONE;
        }





    }

