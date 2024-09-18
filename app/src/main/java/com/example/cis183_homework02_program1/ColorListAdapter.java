package com.example.cis183_homework02_program1;

import android.content.Context;
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

        //get the color info from the color list
        ColorInfo col = listOfColors.get(i);

        //set the GUI for the custom_cell
        redVal.setText(col.getRedVal());
        greenVal.setText(col.getGreenVal());
        blueVal.setText(col.getBlueVal());
        hexVal.setText(col.getHexVal());

        return view;
    }
}
