package com.qcconnect.vocalyze;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by qcconnect on 4/28/18.
 */

public class LoginActivity extends AppCompatActivity {

    private Button signIn;
    private TextView signUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signIn = (Button) findViewById(R.id.signIn);
        signUp = (TextView) findViewById(R.id.signUp);

//        signIn.setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View v)
//            {
//                Intent selectFeelingIntent = new Intent(this, SelectingFeeling.class);
//                startActivity(selectFeelingIntent);
//        });

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
