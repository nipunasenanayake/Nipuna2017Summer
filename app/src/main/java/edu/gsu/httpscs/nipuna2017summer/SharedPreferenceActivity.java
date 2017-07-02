package edu.gsu.httpscs.nipuna2017summer;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharedPreferenceActivity extends BaseActivity {
    private final String EMAIL ="email";
    private final String PASSWORD="password";
    private final String USER="user";

    @BindView(R.id.activity_sharedpref_email)
    EditText et_email;

    @BindView(R.id.activity_sharedpref_password)
    EditText et_password;

    @OnClick(R.id.activity_sharedpref_clear)
    public void clear(View v){
        SharedPreferences sp = getSharedPreferences(USER,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
//        editor.remove(EMAIL);
//        editor.remove(PASSWORD);
        editor.commit();
        et_email.setText("");
        et_password.setText("");
        shortToast("You cleared all the content!");
    }

    @OnClick(R.id.activity_sharedpref_login)
    public void login(View v){
        String email = et_email.getText().toString();
        String password = et_email.getText().toString();
        if (check(email,password)){
            shortToast("Login Success");
        }
    }

    private boolean check(String email, String password) {
        //ignore the check
        boolean isPasswordCorrect = true;
        if (isPasswordCorrect){
            SharedPreferences sp = getSharedPreferences(USER,MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(EMAIL,email);
            editor.putString(PASSWORD,password);
            editor.commit();
            return true;

        } else {
            return false;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        ButterKnife.bind(this);
        retriveLoginInfo();
        
    }

    private void retriveLoginInfo() {
        SharedPreferences sp = getSharedPreferences(USER,MODE_PRIVATE);
        String email= sp.getString(EMAIL,"null");
        String password= sp.getString(PASSWORD,"null");

        if (!email.equals("null")){
            et_email.setText(email);
            et_password.setText(password);
        }


    }
}
