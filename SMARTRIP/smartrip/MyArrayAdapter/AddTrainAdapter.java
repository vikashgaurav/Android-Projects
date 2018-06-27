package com.grv.vikash.smartrip.MyArrayAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.grv.vikash.smartrip.ForAdmin.MidStationList;
import com.grv.vikash.smartrip.ForAdmin.Train_List;
import com.grv.vikash.smartrip.MyPojo.Add_TrainPojo;
import com.grv.vikash.smartrip.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by vikash on 01-07-2017.
 */

public class AddTrainAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Add_TrainPojo> tarinArray;
    private int layoutRes ;
    private LayoutInflater inflater;


    public AddTrainAdapter(Context context, int resource, ArrayList<Add_TrainPojo> tarinArray) {
        super(context, resource, tarinArray);

        this.context = context;
        this.tarinArray = tarinArray;
        this.layoutRes = resource;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.train_list_design, null);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add_TrainPojo pojo = tarinArray.get(position);

                Intent intent = new Intent(context, MidStationList.class);
                intent.putExtra("train_id", pojo.getNo());
                context.startActivity(intent);
            }
        });


        TextView no = (TextView) view.findViewById(R.id.train_no);
        TextView name = (TextView) view.findViewById(R.id.train_Name);
        TextView sun = (TextView) view.findViewById(R.id.sun);
        TextView mon = (TextView) view.findViewById(R.id.mon);
        TextView tue = (TextView) view.findViewById(R.id.tue);
        TextView wed = (TextView) view.findViewById(R.id.wed);
        TextView thu = (TextView) view.findViewById(R.id.thu);
        TextView fri = (TextView) view.findViewById(R.id.fri);
        TextView sat = (TextView) view.findViewById(R.id.sat);
        TextView start = (TextView) view.findViewById(R.id.Train_start_Time);
        TextView source = (TextView) view.findViewById(R.id.trainSource);
        TextView destination = (TextView) view.findViewById(R.id.trainDestination);
        TextView totalTime = (TextView) view.findViewById(R.id.Train_Total_Time);
        TextView totalKms = (TextView) view.findViewById(R.id.Train_kms);


        Add_TrainPojo pojo = tarinArray.get(position);

        no.setText(pojo.getNo());
        name.setText(pojo.getName());
        sun.setText(pojo.getSun());
        mon.setText(pojo.getMon());
        tue.setText(pojo.getTue());
        wed.setText(pojo.getWed());
        thu.setText(pojo.getThu());
        fri.setText(pojo.getFri());
        sat.setText(pojo.getSat());
        start.setText(pojo.getStart());
        source.setText(pojo.getSource());
        destination.setText(pojo.getDestination());
        totalTime.setText(pojo.getTotalTime());
        totalKms.setText(pojo.getTotalkms());


        return view;
    }
}
