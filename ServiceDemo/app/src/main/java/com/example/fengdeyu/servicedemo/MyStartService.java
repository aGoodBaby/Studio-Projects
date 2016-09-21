package com.example.fengdeyu.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by fengdeyu on 2016/9/20.
 */
public class MyStartService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.i("info","onBind");
        return null;
    }

    @Override
    public void onCreate() {

        Log.i("info","onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i("info","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("info","onDestroy");
        super.onDestroy();
    }
}
