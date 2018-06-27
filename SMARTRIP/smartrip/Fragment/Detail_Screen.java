package com.grv.vikash.smartrip.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grv.vikash.smartrip.R;

/**
 * Created by vikash on 27-06-2017.
 */

public class Detail_Screen extends Fragment {

    TextView userName, userEmail;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.after_signin, null);

        userName = (TextView) view.findViewById(R.id.user_Name);
        userEmail = (TextView) view.findViewById(R.id.user_Email);

        return view;
    }
}
