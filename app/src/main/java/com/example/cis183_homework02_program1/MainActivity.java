package com.example.cis183_homework02_program1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    //Create Java variables [HERE]
    TextView tv_j_title;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Connect the Java variables to corresponding GUI variables [HERE]
        tv_j_title = findViewById(R.id.tv_v_am_title);

        //Set Title text & background color
        //tv_j_title.setTextColor(Color.BLACK);
        //tv_j_title.setBackgroundColor(Color.CYAN);
    }
}