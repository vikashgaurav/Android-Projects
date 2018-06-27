package com.grv.vikash.smartrip.MyArrayAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.grv.vikash.smartrip.MyPojo.Add_Flight_Pojo;
import com.grv.vikash.smartrip.MyPojo.userFlightListPojo;
import com.grv.vikash.smartrip.R;

import java.util.ArrayList;

/**
 * Created by vikash on 14-07-2017.
 */

public class UserFlightListAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<userFlightListPojo> userflightarray;
    private int layoutRes ;
    private LayoutInflater inflater;

    public UserFlightListAdapter(Context context, int resource, ArrayList<userFlightListPojo> userflightarray) {
        super(context, resource, userflightarray );

        this.context = context;
        this.layoutRes = resource;
        this.userflightarray = userflightarray;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =  inflater.inflate(R.layout.user_flightlstdesign, null);

        TextView flight = (TextView) view.findViewById(R.id.userflightName);
        TextView nof = (TextView) view.findViewById(R.id.userflightNo);
        TextView sourcef = (TextView) view.findViewById(R.id.usersourceFlight);
        TextView destinationf = (TextView) view.findViewById(R.id.userdestinationFlight);
        TextView startTimef = (TextView) view.findViewById(R.id.usersourceFlightTime);
        TextView endTimef = (TextView) view.findViewById(R.id.userdestinationFlightTime);
        TextView sunF =  (TextView) view.findViewById(R.id.usunF);
        TextView monF =  (TextView) view.findViewById(R.id.umonF);
        TextView tueF =  (TextView) view.findViewById(R.id.utueF);
        TextView wedF =  (TextView) view.findViewById(R.id.uwedF);
        TextView thuF =  (TextView) view.findViewById(R.id.uthuF);
        TextView friF =  (TextView) view.findViewById(R.id.ufriF);
        TextView satF =  (TextView) view.findViewById(R.id.usatF);
        TextView fareF = (TextView) view.findViewById(R.id.userfareFlight);

        userFlightListPojo pojof = userflightarray.get(position);

        flight.setText(pojof.getUserflightname());
        nof.setText(pojof.getUserflightno());
        sourcef.setText(pojof.getUserflightsource());
        destinationf.setText(pojof.getUserflightdestination());
        startTimef.setText(pojof.getUserflightstartTime());
        endTimef.setText(pojof.getUserflightendTime());
        sunF.setText(pojof.getUserflightsun());
        monF.setText(pojof.getUserflightmon());
        tueF.setText(pojof.getUserflighttue());
        wedF.setText(pojof.getUserflightwed());
        thuF.setText(pojof.getUserflightthu());
        friF.setText(pojof.getUserflightfri());
        satF.setText(pojof.getUserflightsat());
        fareF.setText(pojof.getUserflightfare());

        return view;
    }
}
