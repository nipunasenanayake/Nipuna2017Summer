package edu.gsu.httpscs.nipuna2017summer;

import android.app.Dialog;
import android.app.Notification;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpscs.nipuna2017summer.dialog.CustomDialog;

public class DialogActivity extends BaseActivity {

    private final int DIALOG=1234;

Handler mHandler = new Handler(){
    @Override
    public void handleMessage(Message msg) {
        switch(msg.what){
            case DIALOG:
                Bundle bundle = msg.getData();
                String s = bundle.getString("msg");
                shortToast("Dialog msg"+s);
                break;
            default:
        }

        super.handleMessage(msg);
    }
};



    private int checkedID=0;

    @BindView(R.id.activity_dialog_radiogroup)
    RadioGroup radioGroup;
    @OnClick(R.id.activity_dialog_ok_button)
    public void ok(View v){
        switch(checkedID){
            case R.id.activity_dialog_normaldialog:
                normalDialog();
                break;
            case R.id.activity_dialog_listdialog:
                listDialog();
                break;
            case R.id.activity_dialog_singlechoicedialog:
                singleChoiceDialog();
                break;
            case R.id.activity_dialog_multichoicedialog:
                multiChoiceDialog();
                break;
            case R.id.activity_dialog_waitingdialog:
                waitingDialog();
                break;
            case R.id.activity_dialog_progressdialog:
                progressDialog();
                break;
            case R.id.activity_dialog_inputldialog:
                inputDialog();
                break;
            case R.id.activity_dialog_customdialog:
                CustomDialog customDialog = new CustomDialog(this, new CustomDialog.ICustomDialogListener() {
                    @Override
                    public void onOKClicked(String msg) {
                        showToast(msg);
                    }
                });

                customDialog.setCanceledOnTouchOutside(true);
                customDialog.show();
                break;


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID = checkedId;
            }
        });

    }

    private void normalDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("AlertTitle");
        builder.setMessage("This is a normal dialog");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("You clicked Yes");
            }
        });
        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("You clicked Neutral");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("You clicked No");
            }
        });
        builder.show();


    }

    private void listDialog(){
        final String[] items ={"item1","item2","item3","item4","item5","item6"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("List Dialog");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast(items[which]);
            }
        });
        builder.show();
     }

     ProgressDialog waitingDialog;

    private void waitingDialog(){
        waitingDialog=new ProgressDialog(this);
        waitingDialog.setTitle("Downloading");
        waitingDialog.setMessage("Waiting...");
        waitingDialog.show();
        waitingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                shortToast("Dialog was cancelled");
            }
        });
    }


    //issue here
    ArrayList <Integer> choices = new ArrayList<>();
    private void multiChoiceDialog(){


        final String[] items ={"item1","item2","item3","item4"};
        final boolean initChoicesSet[]={true,false,true,true};
        choices.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Multi-dialog list");
        builder.setMultiChoiceItems(items, initChoicesSet, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    choices.add(which);
                }else {
                    choices.remove(which);
                }
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size = choices.size();
                String str="";
                for(int i=0; i<size;i++){
                    str+=items[choices.get(i)]+" ";
                }
                shortToast("You chose"+str);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                shortToast("Cancel clicked");
            }
        });
        builder.show();

    }

    int choice=2;

    private void singleChoiceDialog(){
        final String[] items ={"item1","item2","item3","item4","item5","item6"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Multi-dialog list");
        builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              choice=which;
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You selected: "+choice);
            }
        });
        builder.show();

    }

    //issue here
    private void progressDialog(){
        final int MAX_PROGRESS=100;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Downloading");
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress=0;
                while (progress<MAX_PROGRESS){
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    }catch (InterruptedException in){
                        in.printStackTrace();;
                    }
                }

                Bundle bundle = new Bundle();
                bundle.putString("msg","Download success");
                Message msg = Message.obtain();
                msg.what= DIALOG;
                msg.setData(bundle);
                mHandler.sendMessage(msg);
                progressDialog.cancel();
            }

        }).start();
    }

    private void inputDialog(){
        final EditText editText = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Input Dialog").setView(editText);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               shortToast(editText.getText().toString());
            }
        });
        builder.setNegativeButton("Cancel",null).show();
    }


}
