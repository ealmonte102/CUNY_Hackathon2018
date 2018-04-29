package com.qcconnect.vocalyze;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by qcconnect on 4/28/18.
 */

public class LoginActivity extends AppCompatActivity {

    private Button signIn;
    private TextView signUp;
    private EditText email, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signIn = (Button) findViewById(R.id.signIn);
        signUp = (TextView) findViewById(R.id.signUp);

        String emailQuery = "SELECT * from user WHERE email = " + email.getText().toString();




        signIn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent selectFeelingIntent = new Intent(LoginActivity.this, SelectingFeeling.class);
                startActivity(selectFeelingIntent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent signUpIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(signUpIntent);
            }
        });


    }


}
