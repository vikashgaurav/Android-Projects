package com.grv.vikash.smartrip.Activity_You;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.grv.vikash.smartrip.Fragment.Register;
import com.grv.vikash.smartrip.Fragment.Sign_In;
import com.grv.vikash.smartrip.R;

public class SignIn_Register extends AppCompatActivity {
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in__register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        init();
        methodListner();

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()== android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }



    private void init() {

        login = (Button) findViewById(R.id.loginBtb);
        register = (Button) findViewById(R.id.registerBtn);
    }

    private void methodListner() {

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Sign_In());
                login.setTextColor(Color.parseColor("#ffffff"));
                register.setTextColor(Color.parseColor("#eededcdc"));
            }

        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Register());
                register.setTextColor(Color.parseColor("#ffffff"));
                login.setTextColor(Color.parseColor("#eededcdc"));
            }
        });
    }

    private void changeFragment(Fragment fragment) {

        FragmentManager fragmentManger =  getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManger.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(R.id.Fragment_container, fragment);
        transaction.commit();
    }

    }

