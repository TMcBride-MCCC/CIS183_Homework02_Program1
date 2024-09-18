package com.example.cis183_homework02_program1;

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

    Button btn_j_am_save;

    ListView lv_j_am_colorList;

    //ArrayList class call
    ArrayList<ColorInfo> listOfColors;
    //Adapter
    ColorListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Connect the Java variables to corresponding GUI variables [HERE]
        //Red
        tv_j_am_redNumVal = findViewById(R.id.tv_v_am_redNumVal);
        sb_j_am_redSlider = findViewById(R.id.sb_v_am_redSlider);
        //Green
        tv_j_am_greenNumVal = findViewById(R.id.tv_v_am_greenNumVal);
        sb_j_am_greenSlider = findViewById(R.id.sb_v_am_greenSlider);
        //Blue
        tv_j_am_blueNumVal = findViewById(R.id.tv_v_am_blueNumVal);
        sb_j_am_blueSlider = findViewById(R.id.sb_v_am_blueSlider);
        //Hex
        tv_j_am_hexVal = findViewById(R.id.tv_v_am_hexVal);
        //Save button
        btn_j_am_save = findViewById(R.id.btn_v_am_save);
        //List
        lv_j_am_colorList = findViewById(R.id.lv_v_am_colorList);

        //Call event listeners for seek bars
        numValEventListener();
        //Call button click event listener
        registerButtonClickEvent();

        //Initialize ArrayList
        listOfColors = new ArrayList<ColorInfo>();
        //Call function to fill the list view with the ArrayList
        fillListView();

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
                //Add 0 to redVal if length is 1
                if (redVal.length() == 1)
                {
                    redVal = "0" + redVal;
                }
                //Convert the int value of green to hex
                greenVal = Integer.toHexString(sb_j_am_greenSlider.getProgress());
                //Add 0 to greenVal if length is 1
                if (greenVal.length() == 1)
                {
                    greenVal = "0" + greenVal;
                }
                //Convert the int value of blue to hex
                blueVal = Integer.toHexString(sb_j_am_blueSlider.getProgress());
                //Add 0 to blueVal if length is 1
                if (blueVal.length() == 1)
                {
                    blueVal = "0" + blueVal;
                }
                //Concatenate the current hex values of rgb into a single string value
                hexVal = "#" + redVal + " | " + greenVal + " | " + blueVal + " | ";
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
                //Add 0 to redVal if length is 1
                if (redVal.length() == 1)
                {
                    redVal = "0" + redVal;
                }
                //Convert the int value of green to hex
                greenVal = Integer.toHexString(i);
                //Add 0 to greenVal if length is 1
                if (greenVal.length() == 1)
                {
                    greenVal = "0" + greenVal;
                }
                //Convert the int value of blue to hex
                blueVal = Integer.toHexString(sb_j_am_blueSlider.getProgress());
                //Add 0 to blueVal if length is 1
                if (blueVal.length() == 1)
                {
                    blueVal = "0" + blueVal;
                }
                //Concatenate the current hex values of rgb into a single string value
                hexVal = "#" + redVal + " | " + greenVal + " | " + blueVal + " | ";
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
                //Add 0 to redVal if length is 1
                if (redVal.length() == 1)
                {
                    redVal = "0" + redVal;
                }
                //Convert the int value of green to hex
                greenVal = Integer.toHexString(sb_j_am_greenSlider.getProgress());
                //Add 0 to greenVal if length is 1
                if (greenVal.length() == 1)
                {
                    greenVal = "0" + greenVal;
                }
                //Convert the int value of blue to hex
                blueVal = Integer.toHexString(i);
                //Add 0 to blueVal if length is 1
                if (blueVal.length() == 1)
                {
                    blueVal = "0" + blueVal;
                }
                //Concatenate the current hex values of rgb into a single string value
                hexVal = "#" + redVal + " | " + greenVal + " | " + blueVal + " | ";
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
    private void registerButtonClickEvent()
    {
        btn_j_am_save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addColorToList();
            }
        });
    }

    private void addColorToList()
    {
        //Create a place in memory to store info
        ColorInfo colorToAdd = new ColorInfo();
        //Fill that memory chunk with data
        colorToAdd.setRedVal(
        colorToAdd.setGreenVal(Integer.parseInt(tv_j_am_greenNumVal.toString()));
        colorToAdd.setBlueVal(Integer.parseInt(tv_j_am_blueNumVal.toString()));
        colorToAdd.setHexVal(tv_j_am_hexVal.getText().toString());

        //TEST
        Log.d("Color added ", "The color was added to the list");
    }

    private void fillListView()
    {
        adapter = new ColorListAdapter(this, listOfColors);
        //Set the list view adapter
        lv_j_am_colorList.setAdapter(adapter);
    }

}