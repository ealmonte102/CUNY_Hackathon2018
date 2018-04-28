package com.qcconnect.vocalyze;


    import android.util.*;

    import android.app.ProgressDialog;
    import android.util.Log;

    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;

    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;

    import android.widget.Toast;

/**
 * Created by RJ on 4/28/2018.
 */

public class SignupActivity extends AppCompatActivity
{
    private static final String TAG = "SignupActivity";

    private Button signup_button;
    EditText username, email, password;

    private static String user_regex = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {   signup();   }
        });
    }

    public void signup()
    {
        Log.i(TAG, "Signup");

        if(valid() == false) {
            Toast message = Toast.makeText(getBaseContext(), "Illegal key entered",Toast.LENGTH_SHORT);
            message.show();
            return;
        }
        else
        {
            signup_button.setEnabled(false);

            final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this, R.style.AppTheme);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Account being created!!!");
            progressDialog.show();


        }

    }


    public boolean valid()
    {
        boolean valid = false;

        if(!username.getText().toString().matches(user_regex) || username.getText().toString().isEmpty()) {
            username.setError("Username must be between 8 - 20 characters!");
            return valid;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches() || email.getText().toString().isEmpty() ){
            email.setError("Email is not invalid!");
            return valid;
        }
        if(password.getText().toString().isEmpty() || password.getText().toString().length() < 8){
            password.setError("Password must be greater than 4 characters");
            return valid;
        }

        valid = true;
        return valid;
    }





}
