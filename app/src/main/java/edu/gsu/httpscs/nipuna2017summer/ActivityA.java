package edu.gsu.httpscs.nipuna2017summer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

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
        showToast("onCreate");
        ButterKnife.bind(this);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        showToast("onNewIntent");

    }
}
