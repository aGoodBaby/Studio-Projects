package com.example.fengdeyu.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by fengdeyu on 2016/9/20.
 */
public class MyBindService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("info","onBind");
        return new MyBinder();
    }
    public class MyBinder extends Binder{
        public MyBindService getService(){
            return MyBindService.this;
        }
    }

    @Override
    public void onCreate() {

        super.onCreate();
        Log.i("info","onCreate");
    }

    @Override
    public void unbindService(ServiceConnection conn) {

        super.unbindService(conn);
        Log.i("info","unbindService");
    }

    @Override
    public void onDestroy() {

        super.onDestroy();

        Log.i("info","onDestroy");
    }

    public void Play(){
        Log.i("info","播放");
    }
    public void Pause(){
        Log.i("info","暂停");
    }
    public void Next(){
        Log.i("info","下一首");
    }
    public void Previous(){
        Log.i("info","上一首");
    }

}
