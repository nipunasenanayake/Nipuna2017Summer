package edu.gsu.httpscs.nipuna2017summer.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import edu.gsu.httpscs.nipuna2017summer.R;
import edu.gsu.httpscs.nipuna2017summer.adapter.ListNormalAdapter;
import edu.gsu.httpscs.nipuna2017summer.dialog.CustomDialogQ3;
import edu.gsu.httpscs.nipuna2017summer.util.UtilLog;

public class WorkFragment extends Fragment {


    private TextView textView;
    private Button btn;
    private Button btnQ1;
    private Button btnQ2;
    private Button btnQ3;
    private Button btnSubmit;

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
        UtilLog.d("Fragment","WorkFragment:onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_work,container,false);

        /*textView = (TextView) view.findViewById(R.id.freg_work_tv);
        btn = (Button) view.findViewById(R.id.freg_work_btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Text changed");
            }
        });*/

        btnQ1 = (Button) view.findViewById(R.id.fragment_work_btn_q1);
        btnQ2 = (Button) view.findViewById(R.id.fragment_work_btn_q2);
        btnQ3 = (Button) view.findViewById(R.id.fragment_work_btn_q3);
        btnSubmit = (Button) view.findViewById(R.id.fragment_work_btn_submit);

        btnQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Quiz1", Toast.LENGTH_SHORT).show();
            }
        });

        btnQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Quiz2", Toast.LENGTH_SHORT).show();
            }
        });

        btnQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Quiz3", Toast.LENGTH_SHORT).show();


                final CustomDialogQ3 customDialog = new CustomDialogQ3(getContext(), new CustomDialogQ3.ICustomDialogQ3Listener() {
                    @Override
                    public void onOKClicked(String msg) {
                        if (msg.equals("Yes") || msg.equals("No")) {
                            Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                        }else if (msg.equals("Exit")){
                            System.exit(0);
                        }
                    }

                    @Override
                    public void onCancelClicked(String msg) {
                        Toast.makeText(getContext(), "You clicked Cancel", Toast.LENGTH_SHORT).show();
                    }
                });

                customDialog.setCanceledOnTouchOutside(true);
                customDialog.show();

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Submitted", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
