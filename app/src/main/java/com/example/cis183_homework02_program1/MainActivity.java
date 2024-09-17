package com.example.cis183_homework02_program1;

import android.os.Bundle;
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
    TextView tv_j_am_redNumVal;
    SeekBar sb_j_am_redSlider;

    TextView tv_j_am_greenNumVal;
    SeekBar sb_j_am_greenSlider;

    TextView tv_j_am_blueNumVal;
    SeekBar sb_j_am_blueSlider;

    TextView tv_j_am_hexVal;

    Button btn_j_am_save;

    ListView lv_j_am_listOfColors;

    //ArrayList class here
    ArrayList<RGB> listOfColors;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Connect the Java variables to corresponding GUI variables [HERE]
        tv_j_am_redNumVal = findViewById(R.id.tv_v_am_redNumVal);
        sb_j_am_redSlider = findViewById(R.id.sb_v_am_redSlider);

        tv_j_am_greenNumVal = findViewById(R.id.tv_v_am_greenNumVal);
        sb_j_am_greenSlider = findViewById(R.id.sb_v_am_greenSlider);

        tv_j_am_blueNumVal = findViewById(R.id.tv_v_am_blueNumVal);
        sb_j_am_blueSlider = findViewById(R.id.sb_v_am_blueSlider);

        tv_j_am_hexVal = findViewById(R.id.tv_v_am_hexVal);

        btn_j_am_save = findViewById(R.id.btn_v_am_save);

        lv_j_am_listOfColors = findViewById(R.id.lv_v_am_listOfColors);

        //Event listener function for red slider

        //Event listener function for green slider

        //Event listener function for blue slider

        //Function for save button
        saveButtonClickEvent();

        //new ArrayList
        listOfColors = new ArrayList<RGB>();

        //Function to fill list

    }

    //Function for button click here
    private void saveButtonClickEvent()
    {
        btn_j_am_save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Function for adding the color to the list
                addColorToList();
            }
        });
    }

    //Function for saving the color to the lv
    private void addColorToList()
    {
        //
    }

}