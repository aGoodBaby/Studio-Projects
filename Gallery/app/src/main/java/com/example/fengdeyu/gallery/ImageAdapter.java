package com.example.fengdeyu.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by fengdeyu on 2016/9/20.
 */
public class ImageAdapter extends BaseAdapter {

    private int[]res;
    private Context context;

    public ImageAdapter(int[] res, Context context) {
        this.res = res;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return res[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView image=new ImageView(context);
        image.setBackgroundResource(res[position%res.length]);
        image.setLayoutParams(new Gallery.LayoutParams(200,150));
        image.setScaleType(ImageView.ScaleType.FIT_XY);

        return image;
    }
}
