package edu.gsu.httpscs.nipuna2017summer;

import android.app.Application;

import edu.gsu.httpscs.nipuna2017summer.util.UtilLog;

/**
 * Created by nipunasenanayake on 6/19/17.
 */

public class NipunaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setIsLog(true);
    }
}
