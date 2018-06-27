package com.grv.vikash.smartrip.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Activity_You.SignIn_Register;

/**
 * Created by vikash on 27-06-2017.
 */

public class Main_SignIn_Screen extends Fragment {

    Button SignInBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.you_signin, null);


        init(view);
        methodListner();

        return view;
    }


    private void init(View view) {

        SignInBtn =  (Button) view.findViewById(R.id.signInButton);
    }

    private void methodListner() {

        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SignIn_Register.class);
                startActivity(i);
            }
        });
    }
}
