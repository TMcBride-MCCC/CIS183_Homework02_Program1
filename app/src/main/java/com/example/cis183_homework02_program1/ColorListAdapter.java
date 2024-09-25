package com.example.cis183_homework02_program1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> listOfColors;
    public ColorListAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context = c;
        listOfColors = ls;
    }
    @Override
    public int getCount()
    {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if (view == null)
        {
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflator.inflate(R.layout.custom_cell, null);
        }

        //find the Gui elements in my custom_cell
        TextView redVal = view.findViewById(R.id.tv_v_cc_redNumVal);
        TextView greenVal = view.findViewById(R.id.tv_v_cc_greenNumVal);
        TextView blueVal = view.findViewById(R.id.tv_v_cc_blueNumVal);
        TextView hexVal = view.findViewById(R.id.tv_v_cc_hexVal);
        View background = view.findViewById(R.id.cc);

        //get the color info from the color list
        ColorInfo col = listOfColors.get(i);

        //set the GUI for the custom_cell
        redVal.setText(String.valueOf(col.getRedVal()));
        greenVal.setText(String.valueOf(col.getGreenVal()));
        blueVal.setText(String.valueOf(col.getBlueVal()));
        hexVal.setText(col.getHexVal());
        background.setBackgroundColor(Color.rgb(col.getRedVal(),col.getGreenVal(), col.getBlueVal()));

        return view;
    }
}
