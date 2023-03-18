package com.mofidx.myprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePickerDialog datePickerDialog;
TextView txt1;
ProgressBar progressBar;

Button btndate;

int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btndate = findViewById(R.id.btndate);

        txt1 =findViewById(R.id.txt1);

        progressBar = findViewById(R.id.progressBar);
        ProgressBarAnimation anim = new ProgressBarAnimation(progressBar,txt1, 0, 90);
        anim.setDuration(1500);
        progressBar.startAnimation(anim);

        initDatepicker();


        btndate.setText(getbuguntarihi());


        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datePickerDialog.show();

            }
        });



    }

    private String getbuguntarihi() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        month = month+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return ""+day+"/"+month+"/"+year;
    }

    private void initDatepicker() {

        // دالة تخزن التاريخ اللذي تم اختياره
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1 ;
                String stringdate= ""+dayOfMonth+"/"+month+"/"+year;
                btndate.setText(stringdate);
            }
        };

        // هنا نأتي بتاريخ اليوم والشهر والسنة الحاليين
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this , style , dateSetListener , year , month , day);
       // لجعل اقصى تاريخ هو تاريخ اليوم نستعمل الدالة
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    }


}