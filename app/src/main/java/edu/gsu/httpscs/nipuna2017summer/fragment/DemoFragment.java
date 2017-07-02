package edu.gsu.httpscs.nipuna2017summer.fragment;


import android.app.Dialog;
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
import edu.gsu.httpscs.nipuna2017summer.AdvanceViewPagerActivity;
import edu.gsu.httpscs.nipuna2017summer.AnimationActivity;
import edu.gsu.httpscs.nipuna2017summer.AnimatorActivity;
import edu.gsu.httpscs.nipuna2017summer.CheckBoxActivity;
import edu.gsu.httpscs.nipuna2017summer.DialogActivity;
import edu.gsu.httpscs.nipuna2017summer.GestureActivity;
import edu.gsu.httpscs.nipuna2017summer.HandlerActivity;
import edu.gsu.httpscs.nipuna2017summer.NotificationActivity;
import edu.gsu.httpscs.nipuna2017summer.Patch9Activity;
import edu.gsu.httpscs.nipuna2017summer.R;
import edu.gsu.httpscs.nipuna2017summer.RadioGroupActivity;
import edu.gsu.httpscs.nipuna2017summer.ResultActivity;
import edu.gsu.httpscs.nipuna2017summer.RunablehandlerActivity;
import edu.gsu.httpscs.nipuna2017summer.ScaleTypeActivity;
import edu.gsu.httpscs.nipuna2017summer.SharedPreferenceActivity;
import edu.gsu.httpscs.nipuna2017summer.ViewPagerActivity;
import edu.gsu.httpscs.nipuna2017summer.adapter.ListNormalAdapter;
import edu.gsu.httpscs.nipuna2017summer.audio.BaseBean;


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
        contentList.add("AdvanceViewPager");
        contentList.add("LaunchMode");
        contentList.add("ResultsActivity");
        contentList.add("RadioGroupActivity");
        contentList.add("CheckBoxActivity");
        contentList.add("Dialog");
        contentList.add("HandlerActivity");
        contentList.add("RunableHandler");
        contentList.add("AnimationActivity");
        contentList.add("AnimatorActivity");
        contentList.add("Gesture");
        contentList.add("SharedPreferences");
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
                    case 5:
                        Intent intent5 = new Intent(getActivity(), AdvanceViewPagerActivity.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getActivity(), ActivityA.class);
                        intent6.putExtra("StringInfo","fromDemoFragment");
                        intent6.putExtra("IntInfo",10);

                        Bundle bundle = new Bundle();
                        bundle.putString("StringBundle","FromBundleDemo");
                        bundle.putInt("IntBundle",100);

                        BaseBean bean = new BaseBean();
                        bean.setName("bean-Nipuna");
                        bundle.putSerializable("Object",bean);

                        intent6.putExtra("bundle",bundle);

                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(getActivity(), ResultActivity.class);
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(getActivity(), RadioGroupActivity.class);
                        startActivity(intent8);
                        break;
                    case 9:
                        Intent intent9 = new Intent(getActivity(), CheckBoxActivity.class);
                        startActivity(intent9);
                        break;
                    case 10:
                        Intent intent10 = new Intent(getActivity(), DialogActivity.class);
                        startActivity(intent10);
                        break;
                    case 11:
                        Intent intent11 = new Intent(getActivity(), HandlerActivity.class);
                        startActivity(intent11);
                        break;
                    case 12:
                        Intent intent12 = new Intent(getActivity(), RunablehandlerActivity.class);
                        startActivity(intent12);
                        break;
                    case 13:
                        Intent intent13 = new Intent(getActivity(), AnimationActivity.class);
                        startActivity(intent13);
                        break;
                    case 14:
                        Intent intent14 = new Intent(getActivity(), AnimatorActivity.class);
                        startActivity(intent14);
                        break;
                    case 15:
                        Intent intent15 = new Intent(getActivity(), GestureActivity.class);
                        startActivity(intent15);
                        break;
                    case 16:
                        Intent intent16 = new Intent(getActivity(), SharedPreferenceActivity.class);
                        startActivity(intent16);
                        break;
                    default:
                }
            }
        });

        return view;
    }

}
