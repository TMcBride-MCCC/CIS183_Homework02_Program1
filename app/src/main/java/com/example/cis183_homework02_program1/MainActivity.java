package com.example.cis183_homework02_program1;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //Creating Java variables for GUI
    String redVal;
    String greenVal;
    String blueVal;
    String hexVal;
    TextView tv_j_am_redNumVal;
    TextView tv_j_am_greenNumVal;
    TextView tv_j_am_blueNumVal;
    SeekBar sb_j_am_redSlider;
    SeekBar sb_j_am_greenSlider;
    SeekBar sb_j_am_blueSlider;
    TextView tv_j_am_hexVal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Connect the Java variables to corresponding GUI variables [HERE]
        //red
        tv_j_am_redNumVal = findViewById(R.id.tv_v_am_redNumVal);
        sb_j_am_redSlider = findViewById(R.id.sb_v_am_redSlider);
        //green
        tv_j_am_greenNumVal = findViewById(R.id.tv_v_am_greenNumVal);
        sb_j_am_greenSlider = findViewById(R.id.sb_v_am_greenSlider);
        //blue
        tv_j_am_blueNumVal = findViewById(R.id.tv_v_am_blueNumVal);
        sb_j_am_blueSlider = findViewById(R.id.sb_v_am_blueSlider);
        //hex
        tv_j_am_hexVal = findViewById(R.id.tv_v_am_hexVal);

        //Call event listeners for seek bars
        numValEventListener();

    }

    //Event listener functions for seek bars
    private void numValEventListener()
    {
        //Listener for red
        sb_j_am_redSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //Pull the value of red from the current slider listener
                tv_j_am_redNumVal.setText(String.valueOf(i));
                //Convert the int value of red to hex
                redVal = Integer.toHexString(i);
                //Convert the int value of green to hex
                greenVal = Integer.toHexString(sb_j_am_greenSlider.getProgress());
                //Convert the int value of blue to hex
                blueVal = Integer.toHexString(sb_j_am_blueSlider.getProgress());
                //Concatenate the current hex values of rgb into a single string value
                hexVal = "#" + redVal + greenVal + blueVal;
                //Set the text of the text view for hexVal & capitalize
                tv_j_am_hexVal.setText(hexVal.toUpperCase());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        //Listener for green
        sb_j_am_greenSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //Pull the value of green from the current slider listener
                tv_j_am_greenNumVal.setText(String.valueOf(i));
                //Convert the int value of red to hex
                redVal = Integer.toHexString(sb_j_am_redSlider.getProgress());
                //Convert the int value of green to hex
                greenVal = Integer.toHexString(i);
                //Convert the int value of blue to hex
                blueVal = Integer.toHexString(sb_j_am_blueSlider.getProgress());
                //Concatenate the current hex values of rgb into a single string value
                hexVal = "#" + redVal + greenVal + blueVal;
                //Set the text of the text view for hexVal & capitalize
                tv_j_am_hexVal.setText(hexVal.toUpperCase());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        //Listener for blue
        sb_j_am_blueSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_am_blueNumVal.setText(String.valueOf(i));
                //Convert the int value of red to hex
                redVal = Integer.toHexString(sb_j_am_redSlider.getProgress());
                //Convert the int value of green to hex
                greenVal = Integer.toHexString(sb_j_am_greenSlider.getProgress());
                //Convert the int value of blue to hex
                blueVal = Integer.toHexString(i);
                //Concatenate the current hex values of rgb into a single string value
                hexVal = "#" + redVal + greenVal + blueVal;
                //Set the text of the text view for hexVal & capitalize
                tv_j_am_hexVal.setText(hexVal.toUpperCase());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }
}