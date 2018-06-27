package com.grv.vikash.smartrip.Fragment;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class Register extends Fragment {
    private Button register;
    EditText Fname, Lname, emailRegister, mobRegister, passRegister;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.register, null);

        init(view);
        methodListner();

        return view;
    }


    private void init(View view) {
        register = (Button) view.findViewById(R.id.registerFragmentBtn);

        Fname = (EditText) view.findViewById(R.id.firstNameRegister);
        Lname = (EditText) view.findViewById(R.id.lasNameRegister);
        emailRegister = (EditText) view.findViewById(R.id.emailRegister);
        mobRegister = (EditText) view.findViewById(R.id.mobRegister);
        passRegister = (EditText) view.findViewById(R.id.passRegister);

    }

    private void methodListner() {

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Registerin();
            }
        });
    }

    private void Registerin() {

        String FNAME = Fname.getText().toString();
        String LNAME = Lname.getText().toString();
        String EMAIL = emailRegister.getText().toString();
        String MOB = mobRegister.getText().toString();
        String PASS = passRegister.getText().toString();

        String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String NamePattern = "[a-zA-Z]+";

        if(FNAME.equals("") || LNAME.equals("") || EMAIL.equals("") || MOB.equals("") || PASS.equals("")){
            Toast.makeText(getActivity(), "Enter all the feilds", Toast.LENGTH_SHORT).show();
        }
        else if(!FNAME.matches(NamePattern)){
            Fname.setError("Enter Correct Name");
        }
        else if(!LNAME.matches(NamePattern)){
            Lname.setError("Enter Correct Name");
        }
        else if(!EMAIL.matches(EmailPattern)){
            emailRegister.setError("Enter Correct Email Address");
        }
        else if(MOB.length() < 10){
            mobRegister.setError("Mobile No must be of 10 digits");
        }
        else if(PASS.length() < 6){
            passRegister.setError("Password must of 6 characters");
        }
        else {

            MySQLiteOpenHelper mySQL = new MySQLiteOpenHelper(getActivity());
            SQLiteDatabase db = mySQL.getWritableDatabase();

            ContentValues cv = new ContentValues();
            
            cv.put(RegisterTable.FNAME, FNAME);
            cv.put(RegisterTable.LNAME, LNAME);
            cv.put(RegisterTable.EMAIL, EMAIL);
            cv.put(RegisterTable.MOBILE, MOB);
            cv.put(RegisterTable.PASSWORD, PASS);

            long l = RegisterTable.insert(db, cv);
            if(l>0){
                Toast.makeText(getActivity(), "Registeration Successfull", Toast.LENGTH_SHORT).show();
                Fname.setText("");
                Lname.setText("");
                emailRegister.setText("");
                mobRegister.setText("");
                passRegister.setText("");
            }
            else{
                Toast.makeText(getActivity(), "Email Already Registered", Toast.LENGTH_SHORT).show();
                emailRegister.setText("");
            }
            db.close();
        }
    }
}
