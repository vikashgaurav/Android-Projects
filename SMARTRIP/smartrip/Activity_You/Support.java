package com.grv.vikash.smartrip.Activity_You;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.grv.vikash.smartrip.ForAdmin.UserFeedback;
import com.grv.vikash.smartrip.R;

public class Support extends AppCompatActivity {


    EditText email, feed;
    Spinner issues;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        getSupportActionBar().setTitle("Support");
        init();
        methodListner();
    }

    private void init() {

        email = (EditText) findViewById(R.id.supportEmail);
        feed = (EditText) findViewById(R.id.supportFeedBack);

        issues =  (Spinner) findViewById(R.id.supportSpinnerIssues);

        submit = (Button) findViewById(R.id.supportSubmitbtn);
    }

    private void methodListner() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = email.getText().toString();
                String enteresIssues = (String) issues.getSelectedItem();
                String enteredFeeback = feed.getText().toString();

                if(enteredEmail.equals("") || enteresIssues.equals("Select Issues") || enteredFeeback.equals("")){
                    Toast.makeText(Support.this, "Enter all the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(Support.this, UserFeedback.class);
                    i.putExtra("email", enteredEmail);
                    i.putExtra("issue", enteresIssues);
                    i.putExtra("feedback", enteredFeeback);

                    Toast.makeText(Support.this, "Thanks for your feedback", Toast.LENGTH_SHORT).show();
                    feed.setText("");
                }
            }
        });
    }
}
