package com.grv.vikash.smartrip.MyArrayAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.grv.vikash.smartrip.MyPojo.AddBusPojo;
import com.grv.vikash.smartrip.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by vikash on 12-07-2017.
 */

public class AddBusAdapter extends ArrayAdapter {
    private Context context;
    int layRes;
    ArrayList <AddBusPojo> busArray;
    LayoutInflater inflater;

    public AddBusAdapter(Context context, int resource,  ArrayList <AddBusPojo> busArray) {
        super(context, resource, busArray);

        this.context = context;
        this.layRes = resource;
        this.busArray = busArray;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.buslistdesign, null);

        TextView agencyName = (TextView) view.findViewById(R.id.busAgency);
        TextView busType = (TextView) view.findViewById(R.id.busType);
        TextView busSource = (TextView) view.findViewById(R.id.busSource);
        TextView busDestination = (TextView) view.findViewById(R.id.busDestination);
        TextView busStartTime = (TextView) view.findViewById(R.id.busStartTime);
        TextView busEndTime = (TextView) view.findViewById(R.id.busEndTime);
        TextView busToatltime = (TextView) view.findViewById(R.id.bus_Total_Time);
        TextView busSeat = (TextView) view.findViewById(R.id.busSeatAvailable);
        TextView busFAre = (TextView) view.findViewById(R.id.busFare);


         AddBusPojo pojo = busArray.get(position);

        agencyName.setText(pojo.getBusAgency());
        busType.setText(pojo.getBusType());
        busSource.setText(pojo.getBusSource());
        busDestination.setText(pojo.getBusDestination());
        busStartTime.setText(pojo.getBusStartTime());
        busEndTime.setText(pojo.getBusEndTime());
        busToatltime.setText(pojo.getTotalBusTime());
        busSeat.setText(pojo.getBusSeat());
        busFAre.setText(pojo.getBusFare());

        return  view;
    }
}
