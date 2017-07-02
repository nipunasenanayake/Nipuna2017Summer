package edu.gsu.httpscs.nipuna2017summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharedPreferenceActivity extends AppCompatActivity {
    @BindView(R.id.activity_sharedpref_email)
    EditText et_email;

    @BindView(R.id.activity_sharedpref_password)
    EditText et_password;

    @OnClick(R.id.activity_sharedpref_submit)
    public void login(View v){
        String email = et_email.getText().toString();
        String password = et_email.getText().toString();
        //check(email,password);
    }

    //private void check()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        ButterKnife.bind(this);
    }
}
