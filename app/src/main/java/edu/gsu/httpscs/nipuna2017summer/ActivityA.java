package edu.gsu.httpscs.nipuna2017summer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpscs.nipuna2017summer.audio.BaseBean;

public class ActivityA extends BaseActivity {

    @OnClick (R.id.activity_a_a)
    public void toA(View v){
        Intent intent = new Intent(getApplicationContext(), ActivityA.class);
        startActivity(intent);
    }

    @OnClick (R.id.activity_a_b)
    public void toB(View v){
        Intent intent = new Intent(getApplicationContext(), ActivityB.class);
        startActivity(intent);
    }

    @OnClick (R.id.activity_a_c)
    public void toC(View v){
        Intent intent = new Intent(getApplicationContext(), ActivityC.class);
        startActivity(intent);
    }

    @OnClick (R.id.activity_a_d)
    public void toD(View v){
        Intent intent = new Intent(getApplicationContext(), ActivityD.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        showToast("onCreateA");
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String s = intent.getStringExtra("StringInfo");
        int i = intent.getIntExtra("IntInfo",0);
//        showToast(s);
//        showToast("Integer is "+i);
//        showToast(String.valueOf(i));
//        showToast(i+"");//easy way

        Bundle bundle = intent.getBundleExtra("bundle");
        String s2 = bundle.getString("StringBundle");
        int i2 = bundle.getInt("IntBundle");

        showToast(s2);
        showToast(i2+"");

        BaseBean bean = (BaseBean) bundle.getSerializable("Object");
        showToast(bean.getName());




    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        showToast("onNewIntentA");

    }
}
