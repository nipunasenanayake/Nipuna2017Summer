package edu.gsu.httpscs.nipuna2017summer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.ButterKnife;
import edu.gsu.httpscs.nipuna2017summer.R;
import edu.gsu.httpscs.nipuna2017summer.adapter.ListNormalAdapter;

public class WorkFragment extends Fragment {


    private TextView textView;
    private Button btn;

    public WorkFragment() {
        // Required empty public constructor
    }


    public static WorkFragment newInstance(String param1, String param2) {
        WorkFragment fragment = new WorkFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_work,container,false);
        textView = (TextView) view.findViewById(R.id.freg_work_tv);
        btn = (Button) view.findViewById(R.id.freg_work_btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Text changed");
            }
        });

        return view;
    }

}
