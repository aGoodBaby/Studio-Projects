package com.example.fengdeyu.filedemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/**
 * 使用File()构造器创建新文件
 */
//
//        File file =new File(this.getFilesDir(),"test");
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        Toast.makeText(this,getFilesDir().toString(),Toast.LENGTH_LONG).show();
//
/**
 * 执行openFileOutput() 获取一个 FileOutputStream 用于写文件到internal目录
  */
//        String filename="test";
//        String string="Hello world!";
//        FileOutputStream outputStream;
//
//        try {
//            outputStream=openFileOutput(filename,this.MODE_PRIVATE);
//            try {
//                outputStream.write(string.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                outputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
/**
 * 如果需要缓存一些文件，可以使用createTempFile()
  */
//        try {
//            File file=File.createTempFile("tempTest",null,this.getCacheDir());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
