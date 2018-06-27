package com.grv.vikash.smartrip.MyArrayAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.grv.vikash.smartrip.MyPojo.Add_Flight_Pojo;
import com.grv.vikash.smartrip.MyPojo.Add_TrainPojo;
import com.grv.vikash.smartrip.R;

import java.util.ArrayList;

/**
 * Created by vikash on 03-07-2017.
 */

public class AddFlightAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Add_Flight_Pojo> flightarray;
    private int layoutRes ;
    private LayoutInflater inflater;

    public AddFlightAdapter(Context context, int resource, ArrayList<Add_Flight_Pojo> flightarray) {
        super(context, resource, flightarray );

        this.context = context;
        this.layoutRes = resource;
        this.flightarray = flightarray;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =  inflater.inflate(R.layout.flight_list_design, null);

        TextView flight = (TextView) view.findViewById(R.id.flightName);
        TextView nof = (TextView) view.findViewById(R.id.flightNo);
        TextView sourcef = (TextView) view.findViewById(R.id.sourceFlight);
        TextView destinationf = (TextView) view.findViewById(R.id.destinationFlight);
        TextView startTimef = (TextView) view.findViewById(R.id.sourceFlightTime);
        TextView endTimef = (TextView) view.findViewById(R.id.destinationFlightTime);
        TextView sunF =  (TextView) view.findViewById(R.id.sunF);
        TextView monF =  (TextView) view.findViewById(R.id.monF);
        TextView tueF =  (TextView) view.findViewById(R.id.tueF);
        TextView wedF =  (TextView) view.findViewById(R.id.wedF);
        TextView thuF =  (TextView) view.findViewById(R.id.thuF);
        TextView friF =  (TextView) view.findViewById(R.id.friF);
        TextView satF =  (TextView) view.findViewById(R.id.satF);
        TextView fareF = (TextView) view.findViewById(R.id.fareFlight);

        Add_Flight_Pojo pojof = flightarray.get(position);

        flight.setText(pojof.getFlight());
        nof.setText(pojof.getNo());
        sourcef.setText(pojof.getSource());
        destinationf.setText(pojof.getDestination());
        startTimef.setText(pojof.getStartTime());
        endTimef.setText(pojof.getEndTime());
        sunF.setText(pojof.getSun());
        monF.setText(pojof.getMon());
        tueF.setText(pojof.getTue());
        wedF.setText(pojof.getWed());
        thuF.setText(pojof.getThu());
        friF.setText(pojof.getFri());
        satF.setText(pojof.getSat());
        fareF.setText(pojof.getFare());

        return view;
    }
}
