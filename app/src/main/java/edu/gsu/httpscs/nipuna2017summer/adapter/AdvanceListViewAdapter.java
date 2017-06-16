package edu.gsu.httpscs.nipuna2017summer.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

import edu.gsu.httpscs.nipuna2017summer.R;



/**
 * Created by nipunasenanayake on 6/14/17.
 */

public class AdvanceListViewAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private ArrayList<String> list;

    public AdvanceListViewAdapter(Context context, ArrayList<String> list) {
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
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
        Log.d("ViewHolder","getView");

        ViewHolder viewHolder;
        if (convertView==null){
            convertView = inflater.inflate(R.layout.list_normal_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.rl_odd =(RelativeLayout) convertView.findViewById(R.id.odd);
            viewHolder.rl_even = (RelativeLayout) convertView.findViewById(R.id.odd);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.activity_advance_list_view);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

viewHolder.tv.setText(list.get(position));
        //viewHolder.lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT)

        if(position%2==0){
            //msg from you
            viewHolder.rl_odd.setVisibility(View.INVISIBLE);
            viewHolder.rl_even.setVisibility(View.VISIBLE);
            viewHolder.tv.setBackgroundResource(R.drawable.chatfrom_bg_focused);
        }
        else{
            viewHolder.rl_even.setVisibility(View.INVISIBLE);
            viewHolder.rl_odd.setVisibility(View.VISIBLE);
            viewHolder.tv.setBackgroundResource(R.drawable.chatto_bg_focused);
        }

        return convertView;
    }

    private class ViewHolder{
        RelativeLayout rl_odd;
        RelativeLayout rl_even;
        TextView tv;

    }
}
