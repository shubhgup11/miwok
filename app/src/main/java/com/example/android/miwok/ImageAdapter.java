package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter<Image> {
     int mBgColor;

    public ImageAdapter(Activity context, ArrayList<Image> images,int colorid)
    {
        super(context,0,images);
        mBgColor=colorid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listImageview=convertView;
        if(convertView==null)
            listImageview= LayoutInflater.from(getContext()).inflate(R.layout.view2,parent,false);
        Image currentImage=getItem(position);
        ImageView img = listImageview.findViewById(R.id.image);
        if(currentImage.hasImage()) {
            img.setImageResource(currentImage.getImg_id());
            img.setVisibility(View.VISIBLE);
        }
        else
            img.setVisibility(View.GONE);
        TextView mwk=listImageview.findViewById(R.id.miwok);
        mwk.setText(currentImage.getMwk());
        TextView eng=listImageview.findViewById(R.id.english);
        eng.setText(currentImage.getEng());
        View container= listImageview.findViewById(R.id.list);
        int color= ContextCompat.getColor(getContext(),mBgColor);
        container.setBackgroundColor(color);
        return listImageview;
    }
}
