package edu.gsu.httpscs.nipuna2017summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckBoxActivity extends BaseActivity {
    private HashMap<String,Boolean> list = new HashMap<String,Boolean>();

    @BindView(R.id.activity_check_box1)
    CheckBox checkBox1;

    @BindView(R.id.activity_check_box2)
    CheckBox checkBox2;

    @BindView(R.id.activity_check_box3)
    CheckBox checkBox3;

    @OnClick(R.id.activity_check_submit)
    public void submit(){
        String s = "You checked ";
        for (Map.Entry<String,Boolean> entry : list.entrySet()){
            if (entry.getValue()){
                s=s+" "+entry.getKey();
            }
        }
        showToast(s);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        ButterKnife.bind(this);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);

            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);

            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);

            }
        });
    }
}
