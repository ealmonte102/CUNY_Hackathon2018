package com.qcconnect.vocalyze;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.*;
import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qcconnect.vocalyze.session.MyDatabaseHelper;

/**
 * Created by RJ on 4/28/2018.
 */

public class SignupActivity extends AppCompatActivity
{
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase userDB;

    public final static String USER_TABLE = "MyUsers";

    public static String USER_EMAIL;
    public static String USER_NAME;
    public static String USER_PASSWORD;

    private static final String TAG = "SignupActivity";

    private Button signup_button;
    EditText username, email, password;

    private static String user_regex = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        dbHelper = new MyDatabaseHelper(this);
        userDB = dbHelper.getWritableDatabase();

        signup_button=findViewById(R.id.btn_signup);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

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
            Toast message = Toast.makeText(getBaseContext(), "Invalid",Toast.LENGTH_SHORT);
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


            new android.os.Handler().postDelayed(
                    new Runnable()
                    {
                        public void run()
                        {
                            onSignupSuccess();
                            insertUser(email.getText().toString(), username.getText().toString(), password.getText().toString().hashCode());
                            progressDialog.dismiss();

                            Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(login);
                            finish();
                        }
                    }, 3000);
        }

    }

    public void onSignupSuccess()
    {
        signup_button.setEnabled(true);
        setResult(RESULT_OK, null);
    }

    public boolean valid()
    {
        if (!username.getText().toString().matches(user_regex) || username.getText().toString().isEmpty()) {
            username.setError("Username must be between 8 - 20 characters!");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches() || email.getText().toString().isEmpty()) {
            email.setError("Email is not invalid!");
            return false;
        } else if (password.getText().toString().isEmpty() || password.getText().toString().length() < 8) {
            password.setError("Password must be greater than 4 characters");
            return false;
        }


        return true;
    }

    public long insertUser(String user_email, String user_name, int user_pass)
    {
        ContentValues values = new ContentValues();
        values.put(USER_EMAIL, user_email);
        values.put(USER_NAME, user_name);
        values.put(USER_PASSWORD, user_pass);
        return userDB.insert(USER_TABLE, null, values);

    }
}
