package com.example.fengdeyu.handler_01;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    private Button button;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            textView.setText(""+msg);
            //textView.setText(""+msg.arg1);
        }
    };

    private ImageView imageView;

    private int image[]={
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
    };

    private int index;

    private MyRunnable myRunnable=new MyRunnable();

    @Override
    public void onClick(View v) {
        handler.removeCallbacks(myRunnable);
    }

    class MyRunnable implements Runnable{

        @Override
        public void run() {
            index++;
            index=index%4;
            imageView.setImageResource(image[index]);

            handler.postDelayed(myRunnable ,1000);
        }
    }

    class Person{
        public int age;
        public String name;

        @Override
        public String toString() {
            return "name="+name+"age="+age;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= (TextView) findViewById(R.id.textview);

        imageView= (ImageView) findViewById(R.id.imageView);

        button= (Button) findViewById(R.id.button);

        button.setOnClickListener(this);

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    //Message message=new Message();
                    Message message=handler.obtainMessage();
                    message.arg1=88;

                    Person person =new Person();
                    person.age=23;
                    person.name="nate";

                    message.obj=person;
                    handler.sendMessage(message);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


        handler.postDelayed(myRunnable ,1000);



//        new Thread(){
//            public void run(){
//                try {
//                    Thread.sleep(1000);
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            textView.setText("update thread");
//                        }
//                    });
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
    }
}
