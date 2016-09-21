package com.example.fengdeyu.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,ViewSwitcher.ViewFactory {

    private int[] res={
            R.drawable.item1,
            R.drawable.item2,
            R.drawable.item3,
            R.drawable.item4,
            R.drawable.item5,
            R.drawable.item6,
            R.drawable.item7,
            R.drawable.item8,
            R.drawable.item9,
            R.drawable.item10,
            R.drawable.item11,
            R.drawable.item12,
    };

    private Gallery gallery;

    private ImageAdapter adapter;

    private ImageSwitcher is;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        gallery= (Gallery) findViewById(R.id.gallery);
        is= (ImageSwitcher) findViewById(R.id.is);

        adapter=new ImageAdapter(res,this);
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(this);
        is.setFactory(this);
        is.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        is.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        is.setBackgroundResource(res[position%res.length]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public View makeView() {
        ImageView image=new ImageView(this);
        image.setScaleType(ImageView.ScaleType.CENTER);


        return image;
    }
}
