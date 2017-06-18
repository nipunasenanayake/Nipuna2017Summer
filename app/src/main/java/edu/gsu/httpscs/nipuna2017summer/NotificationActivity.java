package edu.gsu.httpscs.nipuna2017summer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.onClick;

public class NotificationActivity extends BaseActivity {

    private NotificationManager manager;
    private int notifyId=100;


    @OnClick(R.id.activity_notification_small)
    public void smallNotification(View v) {
        showToast("SmallNotification");
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Title")
                .setContentText("Text")
                .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL))
                .setNumber(10)
                .setTicker("Ticker")
                .setWhen(System.currentTimeMillis())
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setOngoing(false)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSmallIcon(R.mipmap.ic_launcher);
        manager.notify(notifyId,mBuilder.build());
    }

    private PendingIntent getDefaultIntent(int flags) {
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,new Intent(),flags);
        return pendingIntent;
    }

    @OnClick(R.id.activity_notification_big)
    public void bigNotification(View v) {
        showToast("BigNotification");

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Title")
                .setContentText("Text")
                .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL))
                .setNumber(10)
                .setTicker("Ticker")
                .setWhen(System.currentTimeMillis())
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setOngoing(false)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSmallIcon(R.mipmap.ic_launcher);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] events = new String[] {"Line1","Line2","Line3","Line4","Line5"};
        inboxStyle.setBigContentTitle("BigContentTitle");

        for (String event:events){
            inboxStyle.addLine(event);
        }

        inboxStyle.setBuilder(mBuilder);
        mBuilder.setStyle(inboxStyle);

        manager.notify(notifyId,mBuilder.build());

    }

    @OnClick(R.id.activity_notification_pic)
    public void picNotification(View v) {
        showToast("PicNotification");

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Title")
                .setContentText("Text")
                .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL))
                .setNumber(10)
                .setTicker("Ticker")
                .setWhen(System.currentTimeMillis())
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setOngoing(false)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSmallIcon(R.mipmap.ic_launcher);

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        mBuilder.setStyle(bigPictureStyle);
        bigPictureStyle.setBuilder(mBuilder);
        bigPictureStyle.setBigContentTitle("BigContentTitle");
        bigPictureStyle.setSummaryText("SummaryText");

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.mipmap.ship);
        bigPictureStyle.bigPicture(bitmap1);
        mBuilder.setStyle(bigPictureStyle);

        manager.notify(notifyId,mBuilder.build());

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
}
