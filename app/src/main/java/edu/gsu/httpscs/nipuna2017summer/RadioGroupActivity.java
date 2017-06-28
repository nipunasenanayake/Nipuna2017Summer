package edu.gsu.httpscs.nipuna2017summer;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static edu.gsu.httpscs.nipuna2017summer.R.id.activity_radio_group;

public class RadioGroupActivity extends BaseActivity {
    private int checkID;

    @BindView(activity_radio_group)
    RadioGroup radioGroup;

    @OnClick(R.id.activity_radio_button)
    public void submit(View v){
        showToast("You chose RadioButton"+checkID);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rado_group);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkID = checkedId;
            }
        });
        
//        radioGroup.setOnClickListener(new RadioGroup.OnCheckedChangeListener(){
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//                checkedId=checkedId;
//            }
//        });


    }
}
