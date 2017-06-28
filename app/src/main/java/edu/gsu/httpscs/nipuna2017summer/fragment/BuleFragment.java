package edu.gsu.httpscs.nipuna2017summer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.gsu.httpscs.nipuna2017summer.R;
import edu.gsu.httpscs.nipuna2017summer.util.UtilLog;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public BuleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BuleFragment newInstance(String param1, String param2) {
        BuleFragment fragment = new BuleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        UtilLog.d("Fragment","BlueOnStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        UtilLog.d("Fragment","BlueOnResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        UtilLog.d("Fragment","BlueOnPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        UtilLog.d("Fragment","BlueOnStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        UtilLog.d("Fragment","BlueOnDestroy");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        UtilLog.d("Fragment","BlueOnCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bule, container, false);
    }

}
