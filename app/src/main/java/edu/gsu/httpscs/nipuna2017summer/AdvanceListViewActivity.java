package edu.gsu.httpscs.nipuna2017summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.gsu.httpscs.nipuna2017summer.adapter.AdvanceListViewAdapter;

public class AdvanceListViewActivity extends AppCompatActivity {

    @BindView(R.id.activity_advance_list_view) ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance);
        ButterKnife.bind(this);

        ArrayList<String> list = new ArrayList<String>();
        list.add("AAAAA");

        AdvanceListViewAdapter adapter = new AdvanceListViewAdapter(this,list);
        lv.setAdapter(adapter);

        TextView tv = new TextView(this);
        tv.setText("HeaderView");
        tv.setTextSize(50);
        lv.addHeaderView(tv);

        TextView tv1 = new TextView(this);
        tv1.setText("HeaderView");
        tv1.setTextSize(50);
        lv.addHeaderView(tv1);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AdvanceListViewActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
