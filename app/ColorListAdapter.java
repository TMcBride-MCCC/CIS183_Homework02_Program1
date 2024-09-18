import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<ColorInfo> listOfColors;

    public ColorListAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context = c;
        listOfColors = ls;
    }


    @Override
    public int getCount()
    {
        eturn 0;
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        return null;
    }
}
