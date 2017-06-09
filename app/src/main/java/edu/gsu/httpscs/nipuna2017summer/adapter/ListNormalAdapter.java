package edu.gsu.httpscs.nipuna2017summer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.gsu.httpscs.nipuna2017summer.R;
import edu.gsu.httpscs.nipuna2017summer.fragment.DemoFragment;

/**
 * Created by nipunasenanayake on 6/7/17.
 */

public class ListNormalAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ArrayList<String> list;
    private Context context;



    public ListNormalAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list=list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_normal_item,parent,false);
        TextView tv = (TextView) convertView.findViewById(R.id.item_normal_tv);
        return tv;
    }
}
