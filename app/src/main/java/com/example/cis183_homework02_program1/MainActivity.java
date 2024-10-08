package com.example.cis183_homework02_program1;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //Creating Java variables for passing
    String redValHex;
    String greenValHex;
    String blueValHex;
    int redValInt;
    int greenValInt;
    int blueValInt;
    String hexVal;

    //Creating Java variables for GUI
    View main_j;
    View cc_j;
    TextView tv_j_am_redNumVal;
    TextView tv_j_am_greenNumVal;
    TextView tv_j_am_blueNumVal;
    SeekBar sb_j_am_redSlider;
    SeekBar sb_j_am_greenSlider;
    SeekBar sb_j_am_blueSlider;
    TextView tv_j_am_hexVal;
    //Labels
    TextView tv_j_am_redLabel;
    TextView tv_j_am_greenLabel;
    TextView tv_j_am_blueLabel;
    TextView tv_j_am_hexLabel;

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
        //Main
        main_j = findViewById(R.id.main);
        //Custom_Cell
        cc_j = findViewById(R.id.cc);
        //Red
        tv_j_am_redLabel = findViewById(R.id.tv_v_am_redLabel);
        tv_j_am_redNumVal = findViewById(R.id.tv_v_am_redNumVal);
        sb_j_am_redSlider = findViewById(R.id.sb_v_am_redSlider);
        //Green
        tv_j_am_greenLabel = findViewById(R.id.tv_v_am_greenLabel);
        tv_j_am_greenNumVal = findViewById(R.id.tv_v_am_greenNumVal);
        sb_j_am_greenSlider = findViewById(R.id.sb_v_am_greenSlider);
        //Blue
        tv_j_am_blueLabel = findViewById(R.id.tv_v_am_blueLabel);
        tv_j_am_blueNumVal = findViewById(R.id.tv_v_am_blueNumVal);
        sb_j_am_blueSlider = findViewById(R.id.sb_v_am_blueSlider);
        //Hex
        tv_j_am_hexLabel = findViewById(R.id.tv_v_am_hexLabel);
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
        registerCcListener();

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
                //Keep int val for passing to ArrayList
                redValInt = sb_j_am_redSlider.getProgress();
                //Convert the int value of red to hex
                redValHex = Integer.toHexString(i);
                //Add 0 to redVal if length is 1
                if (redValHex.length() == 1)
                {
                    redValHex = "0" + redValHex;
                }
                //Keep int val for passing to ArrayList
                greenValInt = sb_j_am_greenSlider.getProgress();
                //Convert the int value of green to hex
                greenValHex = Integer.toHexString(sb_j_am_greenSlider.getProgress());
                //Add 0 to greenValHex if length is 1
                if (greenValHex.length() == 1)
                {
                    greenValHex = "0" + greenValHex;
                }
                //Keep int val for passing to ArrayList
                blueValInt = sb_j_am_blueSlider.getProgress();
                //Convert the int value of blue to hex
                blueValHex = Integer.toHexString(sb_j_am_blueSlider.getProgress());
                //Add 0 to blueVal if length is 1
                if (blueValHex.length() == 1)
                {
                    blueValHex = "0" + blueValHex;
                }
                //Concatenate the current hex values of rgb into a single string value
                hexVal = redValHex + greenValHex + blueValHex;
                //Set the text of the text view for hexVal & capitalize
                tv_j_am_hexVal.setText(hexVal.toUpperCase());

                //Change the background color
                main_j.setBackgroundColor(Color.rgb(redValInt,greenValInt,blueValInt));

                //Change text color
                changeTextColor();

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
                //Keep int val for passing to ArrayList
                redValInt = sb_j_am_redSlider.getProgress();
                //Convert the int value of red to hex
                redValHex = Integer.toHexString(sb_j_am_redSlider.getProgress());
                //Add 0 to redVal if length is 1
                if (redValHex.length() == 1)
                {
                    redValHex = "0" + redValHex;
                }
                //Keep int val for passing to ArrayList
                greenValInt = sb_j_am_greenSlider.getProgress();
                //Pull the value of green from the current slider listener
                tv_j_am_greenNumVal.setText(String.valueOf(i));
                //Convert the int value of green to hex
                greenValHex = Integer.toHexString(i);
                //Add 0 to greenValHex if length is 1
                if (greenValHex.length() == 1)
                {
                    greenValHex = "0" + greenValHex;
                }
                //Keep int val for passing to ArrayList
                blueValInt = sb_j_am_blueSlider.getProgress();
                //Convert the int value of blue to hex
                blueValHex = Integer.toHexString(sb_j_am_blueSlider.getProgress());
                //Add 0 to blueVal if length is 1
                if (blueValHex.length() == 1)
                {
                    blueValHex = "0" + blueValHex;
                }
                //Concatenate the current hex values of rgb into a single string value
                hexVal = redValHex + greenValHex + blueValHex;
                //Set the text of the text view for hexVal & capitalize
                tv_j_am_hexVal.setText(hexVal.toUpperCase());
                //Change the background color
                main_j.setBackgroundColor(Color.rgb(redValInt,greenValInt,blueValInt));

                //Change text color
                changeTextColor();
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
                //Keep int val for passing to ArrayList
                redValInt = sb_j_am_redSlider.getProgress();
                //Convert the int value of red to hex
                redValHex = Integer.toHexString(sb_j_am_redSlider.getProgress());
                //Add 0 to redVal if length is 1
                if (redValHex.length() == 1)
                {
                    redValHex = "0" + redValHex;
                }
                //Keep int val for passing to ArrayList
                greenValInt = sb_j_am_greenSlider.getProgress();
                //Convert the int value of green to hex
                greenValHex = Integer.toHexString(sb_j_am_greenSlider.getProgress());
                //Add 0 to greenValHex if length is 1
                if (greenValHex.length() == 1)
                {
                    greenValHex = "0" + greenValHex;
                }
                //Pull the value of blue from the current slider listener
                tv_j_am_blueNumVal.setText(String.valueOf(i));
                //Keep int val for passing to ArrayList
                blueValInt = sb_j_am_blueSlider.getProgress();
                //Convert the int value of blue to hex
                blueValHex = Integer.toHexString(i);
                //Add 0 to blueVal if length is 1
                if (blueValHex.length() == 1)
                {
                    blueValHex = "0" + blueValHex;
                }
                //Concatenate the current hex values of rgb into a single string value
                hexVal = redValHex + greenValHex + blueValHex;
                //Set the text of the text view for hexVal & capitalize
                tv_j_am_hexVal.setText(hexVal.toUpperCase());
                //Change the background color
                main_j.setBackgroundColor(Color.rgb(redValInt,greenValInt,blueValInt));

                //Change text color
                changeTextColor();
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
                resetGUI();
            }
        });
    }

    private void resetGUI()
    {
        //Reset red
        sb_j_am_redSlider.setProgress(255);

        //Reset green
        sb_j_am_greenSlider.setProgress(255);

        //Reset blue
        sb_j_am_blueSlider.setProgress(255);
    }

    private void registerCcListener()
    {
        lv_j_am_colorList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                ColorInfo thisColor = listOfColors.get(i);

                //Set the red value of tv and sb
                tv_j_am_redNumVal.setText(String.valueOf(thisColor.getRedVal()));
                sb_j_am_redSlider.setProgress(thisColor.getRedVal());

                //Set the green value of tv and sb
                tv_j_am_greenNumVal.setText(String.valueOf(thisColor.getGreenVal()));
                sb_j_am_greenSlider.setProgress(thisColor.getGreenVal());

                //Set the blue value of tv and sb
                tv_j_am_blueNumVal.setText(String.valueOf(thisColor.getBlueVal()));
                sb_j_am_blueSlider.setProgress(thisColor.getBlueVal());

                //Set the hex value
                tv_j_am_hexVal.setText(thisColor.getHexVal());

                //Set the background color
                main_j.setBackgroundColor(Color.rgb(thisColor.getRedVal(), thisColor.getGreenVal(), thisColor.getBlueVal()));
            }
        });
    }

    private void addColorToList()
    {
        //Create a place in memory to store info
        ColorInfo colorToAdd = new ColorInfo();

        //Fill that memory chunk with data
        //Add Red color int value to array
        colorToAdd.setRedVal(redValInt);
        //Add Green color int value to array
        colorToAdd.setGreenVal(greenValInt);
        //Add Blue color int value to array
        colorToAdd.setBlueVal(blueValInt);
        //Add Hex value to array
        colorToAdd.setHexVal(hexVal.toUpperCase());
        //Add Brightness value to array
        colorToAdd.setBrightness(changeTextColor());

        //Add the memory chunk to the list
        listOfColors.add(colorToAdd);

        //Tell the program that the data set has been added to
        adapter.notifyDataSetChanged();

/*        //TEST
        Log.d("Color added ", "The color was added to the list");
        //red output
        Log.d("redValHex was added to the list ", "redValHex is: " + redValHex.toUpperCase());
        Log.d("redValInt was added to the list ", "redValINT is: " + redValInt);
        //green output
        Log.d("greenValHex was added to the list ", "greenValHex is: " + greenValHex.toUpperCase());
        Log.d("greenValInt was added to the list ", "greenValInt is: " + greenValInt);
        //blue output
        Log.d("blueValHex was added to the list ", "blueValHex is: " + blueValHex.toUpperCase());
        Log.d("blueValInt was added to the list ", "blueValInt is: " + blueValInt);
        //Array looks like this:
        Log.d("Did the Red get added? ", "Red: " + colorToAdd.getRedVal());
        Log.d("Did the Green get added? ", "Green: " + colorToAdd.getGreenVal());
        Log.d("Did the Blue get added? ", "Blue: " + colorToAdd.getBlueVal());
        Log.d("Did the Hex get added? ", "Hex: " + colorToAdd.getHexVal());*/

    }

    private void fillListView()
    {
        adapter = new ColorListAdapter(this, listOfColors);
        //Set the list view adapter
        lv_j_am_colorList.setAdapter(adapter);
    }

    private double changeTextColor()
    {
        double brightness = (0.299 * redValInt + 0.587 * greenValInt + 0.114 * blueValInt)/255;

        if (brightness < .5)
        {
            //Set red text to white
            tv_j_am_redLabel.setTextColor(Color.rgb(255,255,255));
            tv_j_am_redNumVal.setTextColor(Color.rgb(255,255,255));

            //Set green text to white
            tv_j_am_greenLabel.setTextColor(Color.rgb(255,255,255));
            tv_j_am_greenNumVal.setTextColor(Color.rgb(255,255,255));

            //Set blue text to white
            tv_j_am_blueLabel.setTextColor(Color.rgb(255,255,255));
            tv_j_am_blueNumVal.setTextColor(Color.rgb(255,255,255));

            //Set hex text to white
            tv_j_am_hexLabel.setTextColor(Color.rgb(255,255,255));
            tv_j_am_hexVal.setTextColor(Color.rgb(255,255,255));
        }
        else
        {
            //Set red text to black
            tv_j_am_redLabel.setTextColor(Color.rgb(000,000,000));
            tv_j_am_redNumVal.setTextColor(Color.rgb(000,000,000));

            //Set green text to black
            tv_j_am_greenLabel.setTextColor(Color.rgb(000,000,000));
            tv_j_am_greenNumVal.setTextColor(Color.rgb(000,000,000));

            //Set blue text to black
            tv_j_am_blueLabel.setTextColor(Color.rgb(000,000,000));
            tv_j_am_blueNumVal.setTextColor(Color.rgb(000,000,000));

            //Set hex text to black
            tv_j_am_hexLabel.setTextColor(Color.rgb(000,000,000));
            tv_j_am_hexVal.setTextColor(Color.rgb(000,000,000));
        }
        return brightness;
    }

}