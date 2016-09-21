package com.example.fengdeyu.servicedemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent1;
    Intent intent2;
    MyBindService service;

    ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            service=((MyBindService.MyBinder)binder).getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void doClick(View v){

        switch (v.getId()){
            case R.id.start:
                intent1=new Intent(MainActivity.this,MyStartService.class);
                startService(intent1);
                break;
            case R.id.stop:
                stopService(intent1);

                break;
            case R.id.bind:
                intent2=new Intent(MainActivity.this,MyBindService.class);

                bindService(intent2,conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(conn);
                service=null;
                break;
            case R.id.play:
                service.Play();
                break;
            case R.id.pause:
                service.Pause();
                break;
            case R.id.next:
                service.Next();
                break;
            case R.id.previous:
                service.Previous();
                break;
        }


    }

}
