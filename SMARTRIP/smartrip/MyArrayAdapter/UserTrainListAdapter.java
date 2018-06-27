package com.grv.vikash.smartrip.MyArrayAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.grv.vikash.smartrip.MyPojo.userTrainListPojo;
import com.grv.vikash.smartrip.R;

import java.util.ArrayList;

/**
 * Created by vikash on 13-07-2017.
 */

public class UserTrainListAdapter extends ArrayAdapter {

    Context context;
    ArrayList<userTrainListPojo> arrayList;
    int layRes;
    LayoutInflater  inflater;

    public UserTrainListAdapter(Context context, int resource, ArrayList<userTrainListPojo> arrayList) {
        super(context, resource, arrayList);

        this.context = context;
        this.arrayList = arrayList;
        this.layRes = resource;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.user_trainlistdesign, null);

        TextView no = (TextView) view.findViewById(R.id.usertrain_no);
        TextView name = (TextView) view.findViewById(R.id.usertrain_Name);
        TextView source = (TextView) view.findViewById(R.id.usertrainSource);
        TextView destination = (TextView) view.findViewById(R.id.usertrainDestination);
        TextView startTime = (TextView) view.findViewById(R.id.userTrain_start_Time);
        TextView endTime = (TextView) view.findViewById(R.id.usertrainEnd_time);
        TextView fare = (TextView) view.findViewById(R.id.userTrain_fare);
        TextView sun = (TextView) view.findViewById(R.id.usun);
        TextView mon = (TextView) view.findViewById(R.id.umon);
        TextView tue = (TextView) view.findViewById(R.id.utue);
        TextView wed = (TextView) view.findViewById(R.id.uwed);
        TextView thu = (TextView) view.findViewById(R.id.uthu);
        TextView fri = (TextView) view.findViewById(R.id.ufri);
        TextView sat = (TextView) view.findViewById(R.id.usat);


        userTrainListPojo pojo = arrayList.get(position);

        no.setText(pojo.getUserTrainno());
        name.setText(pojo.getUserTrainName());
        source.setText(pojo.getUserTrainSource());
        destination.setText(pojo.getUserTrainDestiantion());
        startTime.setText(pojo.getUserTrainStartTime());
        endTime.setText(pojo.getUserTrainendTime());
        fare.setText(pojo.getUserTrainfare());
        sun.setText(pojo.getS());
        mon.setText(pojo.getM());
        tue.setText(pojo.getT());
        wed.setText(pojo.getW());
        thu.setText(pojo.getTh());
        fri.setText(pojo.getF());
        sat.setText(pojo.getSa());

        return view;
    }
}
