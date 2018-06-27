package com.grv.vikash.smartrip.ForAdmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.grv.vikash.smartrip.R;

public class UserFeedback extends AppCompatActivity {

    TextView userEmail, userIssue, userfeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_feedback);

        getSupportActionBar().setTitle("User feedback");
        init();
        getdata();
    }

    private void init() {
        userEmail =  (TextView) findViewById(R.id.userEnteredEmailTextView);
        userIssue = (TextView) findViewById(R.id.userIssuestextView);
        userfeedback = (TextView) findViewById(R.id.userEnteredFeedbackText);
    }

    private void getdata() {
        Intent i = getIntent();
        String email =  i.getStringExtra("email");
        String issue  = i.getStringExtra("issue");
        String feed  = i.getStringExtra("feedback");

        userEmail.setText(email);
        userIssue.setText(issue);
        userfeedback.setText(feed);
    }
}
