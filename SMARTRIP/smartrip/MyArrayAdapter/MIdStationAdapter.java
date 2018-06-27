package com.grv.vikash.smartrip.MyArrayAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.grv.vikash.smartrip.MyPojo.MidStationPojo;
import com.grv.vikash.smartrip.R;

import java.util.ArrayList;

/**
 * Created by vikash on 06-07-2017.
 */

public class MIdStationAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<MidStationPojo> midStationArray;
    private int layoutRes ;
    private LayoutInflater inflater;


    public MIdStationAdapter(Context context, int resource, ArrayList<MidStationPojo> midStationArray) {
        super(context, resource, midStationArray);

        this.context = context;
        this.layoutRes = resource;
        this.midStationArray = midStationArray;

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View  view = inflater.inflate(R.layout.midstation_list_design, null);

        TextView msname = (TextView) view.findViewById(R.id.midStationName);
        TextView msDistance = (TextView) view.findViewById(R.id.midStationDistance);
        TextView msTime = (TextView) view.findViewById(R.id.midStationTime);
        TextView TrainNo = (TextView) view.findViewById(R.id.trainNoinMid);

        MidStationPojo pojo = midStationArray.get(position);

        msname.setText(pojo.getMsName());
        msDistance.setText(pojo.getMsDistance());
        msTime.setText(pojo.getMsTime());
        TrainNo.setText(pojo.getTrainNO());

        return view;
    }
}
