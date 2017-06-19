package edu.gsu.httpscs.nipuna2017summer.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.gsu.httpscs.nipuna2017summer.ActivityA;
import edu.gsu.httpscs.nipuna2017summer.AdvanceListViewActivity;
import edu.gsu.httpscs.nipuna2017summer.NotificationActivity;
import edu.gsu.httpscs.nipuna2017summer.Patch9Activity;
import edu.gsu.httpscs.nipuna2017summer.R;
import edu.gsu.httpscs.nipuna2017summer.ScaleTypeActivity;
import edu.gsu.httpscs.nipuna2017summer.ViewPagerActivity;
import edu.gsu.httpscs.nipuna2017summer.adapter.ListNormalAdapter;


public class DemoFragment extends Fragment {

    private final ArrayList<String> contentList;
    private final Context context;
    private ListView listView;

    public DemoFragment() {

        context = getContext();

contentList = new ArrayList<String>();
        contentList.add("ViewPager");
        contentList.add("ImageScaleType");
        contentList.add("9Patch");
        contentList.add("Notification");
        contentList.add("AdvanceListView");
        contentList.add("C");
        contentList.add("A");
        contentList.add("B");
        contentList.add("LaunchMode");
        contentList.add("A");
        contentList.add("B");
        contentList.add("C");

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_demo,container,false);
        listView = (ListView) view.findViewById(R.id.freg_demo);

        ListNormalAdapter adapter = new ListNormalAdapter(this.getContext(),contentList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getActivity(),ViewPagerActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), ScaleTypeActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), Patch9Activity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), NotificationActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(), AdvanceListViewActivity.class);
                        startActivity(intent4);
                        break;
                    case 8:
                        Intent intent8 = new Intent(getActivity(), ActivityA.class);
                        startActivity(intent8);
                        break;
                    default:
                }
            }
        });

        return view;
    }

}
