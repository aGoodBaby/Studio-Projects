package com.example.fengdeyu.sharedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText passWord;
    private CheckBox saveUser;
    private Button login;
    private Button cancel;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        pref=getSharedPreferences("UserInfo",MODE_PRIVATE);
        editor=pref.edit();

        String name= pref.getString("userName","");

        if(name!=null){
            userName.setText(name);
        }



    }

    private void init(){
        userName= (EditText) findViewById(R.id.userName);
        passWord= (EditText) findViewById(R.id.passWord);
        saveUser= (CheckBox) findViewById(R.id.saveName);
        login= (Button) findViewById(R.id.btnLogin);
        cancel= (Button) findViewById(R.id.btnCancel);

    }

    public void doClick(View v){
        String name=userName.getText().toString();
        String pass=passWord.getText().toString();
        switch (v.getId()){
            case R.id.btnLogin:
                if(name.equals("admin")&&pass.equals("12345")){
                    if(saveUser.isChecked()){
                        editor.putString("userName",name);
                        editor.commit();
                    }else{
                        editor.remove("userName");
                        editor.commit();
                    }
                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnCancel:

                break;

        }
    }


}
