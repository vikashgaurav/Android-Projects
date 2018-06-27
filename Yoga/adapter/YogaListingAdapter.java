package com.cdac.yogalisting.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cdac.yogalisting.R;
import com.cdac.yogalisting.pojo.YogaPojo;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by lenovo1 on 6/29/2017.
 */

public class YogaListingAdapter extends ArrayAdapter {

    private Context context;
    private int res;
    private ArrayList<YogaPojo> arrayList;

    private LayoutInflater inflater;

    public YogaListingAdapter(Context context, int resource, ArrayList<YogaPojo> arrayList) {
        super(context, resource, arrayList);

        this.context = context;
        this.res = resource;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.list_item, null);

        CircleImageView imageView = (CircleImageView) view.findViewById(R.id.circleImageView);
        TextView textView = (TextView) view.findViewById(R.id.textViewTitle);

        YogaPojo pojo = arrayList.get(position);

        textView.setText(pojo.getCategory());

        Glide.with(context)
                .load(pojo.getImg())
                .crossFade()
                .placeholder(R.drawable.logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

        return view;
    }
}
