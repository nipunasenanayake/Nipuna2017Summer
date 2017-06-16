package edu.gsu.httpscs.nipuna2017summer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.onClick;

public class NotificationActivity extends BaseActivity {

    private NotificationManager manager;


    @OnClick(R.id.activity_notification_small)
    public void smallNotification(View v) {
        showToast("SmallNotification");
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Title")
                .setContentText("Text")
                .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL))
                .setNumber(10);
        manager.notify(0,mBuilder.build());
    }

    private PendingIntent getDefaultIntent(int flagAutoCancel) {
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,new Intent(),flagAutoCancel);
        return pendingIntent;
    }

    @OnClick(R.id.activity_notification_big)
    public void bigNotification(View v) {
        showToast("BigNotification");
    }

    @OnClick(R.id.activity_notification_pic)
    public void picNotification(View v) {
        showToast("PicNotification");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
}
