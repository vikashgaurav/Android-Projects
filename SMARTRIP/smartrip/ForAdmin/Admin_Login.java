package com.grv.vikash.smartrip.ForAdmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.grv.vikash.smartrip.R;

public class Admin_Login extends AppCompatActivity {


    Button loginBtn;
    EditText editTextEmail, editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__login);

        loginBtn = (Button) findViewById(R.id.adminloginbtn);
        editTextEmail = (EditText) findViewById(R.id.adminemail);
        editTextPass = (EditText)  findViewById(R.id.adminpass);

        methodlistner();
    }

    private void methodlistner() {

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String enteredEmail = editTextEmail.getText().toString();
                String enteredPass = editTextPass.getText().toString();

                if (enteredEmail.equals("") || enteredPass.equals("")) {
                    Toast.makeText(Admin_Login.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (enteredEmail.equals("admin@admin") && enteredPass.equals("admin"))
                    {
                        Toast.makeText(Admin_Login.this, "login Success", Toast.LENGTH_SHORT).show();

                        Intent i =  new Intent(Admin_Login.this, Admin.class);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(Admin_Login.this, "email/pass incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
