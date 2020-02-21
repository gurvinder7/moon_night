package com.example.moon_night;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {


    ImageView imageView ;
    RelativeLayout relativeLayout ;
    Handler handler;
    Runnable runnable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        imageView = findViewById(R.id.imageview1);

        relativeLayout = findViewById(R.id.relativelayout1);

DayThemeMode();

        final Handler ha=new Handler();
        ha.postDelayed(new Runnable() {

            @Override
            public void run() {
                NightThemeMode();

                ha.postDelayed(this, 10000);
            }
        }, 4000);



    }

    public void DayThemeMode(){

        handler = new Handler();

        imageView.setImageResource(R.drawable.sun);
        //imageView = (ImageView) findViewById(R.id.imageview1);

// Load the animation like this
        Animation animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide);

// Start the animation like this
        imageView.startAnimation(animSlide);

        imageView.setVisibility(View.VISIBLE);

        //relativeLayout.setBackgroundColor(getResources().getColor(R.color.dayBackground));

        Resources res = getResources(); //resource handle
        Drawable drawable = res.getDrawable(R.drawable.day); //new Image that was added to the res folder

        relativeLayout.setBackgroundDrawable(drawable);

        runnable = new Runnable() {

            @Override
            public void run() {

                //Hiding image after 4 seconds

                imageView.setVisibility(View.INVISIBLE);

            }
        };
        handler.postDelayed(runnable, 4000);

    }

    public void NightThemeMode(){

        handler = new Handler();

        imageView.setImageResource(R.drawable.moon);
        Animation animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide);

// Start the animation like this
        imageView.startAnimation(animSlide);

        imageView.setVisibility(View.VISIBLE);

        //relativeLayout.setBackgroundColor(getResources().getColor(R.color.nightBackground));
        Resources res = getResources(); //resource handle
        Drawable drawable = res.getDrawable(R.drawable.night); //new Image that was added to the res folder

        relativeLayout.setBackgroundDrawable(drawable);

        runnable = new Runnable() {

            @Override
            public void run() {

                //Hiding image after 4 seconds

                imageView.setVisibility(View.INVISIBLE);

                DayThemeMode();


            }
        };
        handler.postDelayed(runnable, 4000);

    }
}
