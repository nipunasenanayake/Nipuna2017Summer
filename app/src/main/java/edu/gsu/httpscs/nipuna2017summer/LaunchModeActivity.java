package edu.gsu.httpscs.nipuna2017summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LaunchModeActivity extends AppCompatActivity {

  /*  @BindView(R.id.test)
    TextView test;
    private TextView tv;*/

    @OnClick(R.id.test)
public void click(View v){
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);
        ButterKnife.bind(this);

        /*tv = (TextView) findViewById(R.id.test);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LaunchModeActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
