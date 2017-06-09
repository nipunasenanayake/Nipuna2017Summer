package edu.gsu.httpscs.nipuna2017summer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import edu.gsu.httpscs.nipuna2017summer.fragment.DemoFragment;
import edu.gsu.httpscs.nipuna2017summer.fragment.WorkFragment;

public class MainActivity extends AppCompatActivity {

    private TextView tv_demo;
    private TextView tv_work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        setListener();
    }



    private void initialView() {
        tv_demo = (TextView) findViewById(R.id.activity_tool_demo);
        tv_work = (TextView) findViewById(R.id.activity_tool_work);
    }

    private void setListener() {
        final WorkFragment workFragment = new WorkFragment();
        final DemoFragment demoFragment = new DemoFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_work,demoFragment).commit();

        tv_demo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Toast.makeText(MainActivity.this,"You clicked Demo",Toast.LENGTH_SHORT).show();
                tv_work.setTextColor(Color.BLACK);
                tv_demo.setTextColor(Color.RED);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_work,demoFragment).commit();
            }

        });

        View.OnClickListener listener = new View.OnClickListener(){
            public void onClick(View v){
                //Toast.makeText(MainActivity.this,"You clicked Work",Toast.LENGTH_SHORT).show();
                tv_work.setTextColor(Color.RED);
                tv_demo.setTextColor(Color.BLACK);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_work,workFragment).commit();
            }
        };
        tv_work.setOnClickListener(listener);


    }

    public void login (View v){
        Toast.makeText(MainActivity.this,"You clicked login",Toast.LENGTH_SHORT).show();

    }
}
