package com.mofidx.myprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Splashsecreen extends AppCompatActivity {
ProgressBar progressBar2;
TextView textView2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashsecreen);

        progressBar2 =findViewById(R.id.progressBar2);
        textView2 =findViewById(R.id.txt2);


        progressBar2.setMax(100);
        progressBar2.setScaleY(2f);

        progressAnimaion();

// This method is used so that your splash activity can cover the entire screen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        setContentView(R.layout.activity_main); // this will bind your MainActivity.class file with activity_main.

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent is used to switch from one activity to another.
                Intent i = new Intent(Splashsecreen.this, MainActivity.class);
                startActivity(i); // invoke the SecondActivity.
                finish(); // the current activity will get finished.
            }
        }, 4700);



    }

    private void progressAnimaion() {
        ProgressBarAnimation progressBarAnimation = new ProgressBarAnimation(progressBar2 , textView2 , 0f,100f);
        progressBarAnimation.setDuration(2500);
        progressBar2.setAnimation(progressBarAnimation);

    }
}