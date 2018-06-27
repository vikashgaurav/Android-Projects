package com.grv.vikash.smartrip.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.grv.vikash.smartrip.DataBase.MySQLiteOpenHelper;
import com.grv.vikash.smartrip.R;
import com.grv.vikash.smartrip.Table.RegisterTable;

/**
 * Created by vikash on 25-06-2017.
 */

public class Sign_In extends Fragment {
    private Button login;
    EditText emailSignin, passSignIn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_in, null);

        init(view);
        methodListner();

        return view;
    }


    private void init(View view) {
        login = (Button) view.findViewById(R.id.loginFragmentBtn);

        emailSignin = (EditText) view.findViewById(R.id.emaiSignIn);
        passSignIn = (EditText) view.findViewById(R.id.passSignIn);

    }

    private void methodListner() {

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }

    private void signIn() {

        String enteredEmail = emailSignin.getText().toString();
        String enteredPass = passSignIn.getText().toString();

        if (enteredEmail.equals("") || enteredPass.equals("")) {
            Toast.makeText(getActivity(), "Enter all fields", Toast.LENGTH_SHORT).show();
        } else {

            MySQLiteOpenHelper mysql = new MySQLiteOpenHelper(getActivity());
            SQLiteDatabase db = mysql.getReadableDatabase();

            String Selection = RegisterTable.EMAIL + "= '" + enteredEmail + "' AND " + RegisterTable.PASSWORD + " = '" + enteredPass + "'";

            Cursor cursor = RegisterTable.select(db, Selection);

            if (cursor != null) {
                if (cursor.getCount() == 1) {

                    String FName=null,LNAME,Email=null,Mobile,Password;

                    while (cursor.moveToNext()) {
                        int id = cursor.getInt(0);
                         FName = cursor.getString(1);
                         LNAME = cursor.getString(2);
                         Email = cursor.getString(3);
                         Mobile = cursor.getString(4);
                         Password = cursor.getString(5);

                        Log.d("abc", "login: " + id + FName + LNAME + Email + Mobile + Password);
                    }
                    Toast.makeText(getActivity(), "Login Successfull", Toast.LENGTH_SHORT).show();
                    emailSignin.setText("");
                    passSignIn.setText("");

                  /*  Intent i = new Intent(getActivity(), Detail_Screen.class );
                    getActivity().startActivity(i);*/

                } else {
                    Toast.makeText(getActivity(), "Email/Pass Incorrect", Toast.LENGTH_SHORT).show();
                    emailSignin.setText("");
                    passSignIn.setText("");
                }
            }
        }
    }
}
