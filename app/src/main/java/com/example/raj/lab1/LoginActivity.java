package com.example.raj.lab1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    protected void	onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME , "in onResume");
    }

    protected void	onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME , "in onStart");
        final TextView email = (TextView)findViewById(R.id.editText2);
        final TextView password = (TextView)findViewById(R.id.editText4);
        SharedPreferences pref = getSharedPreferences("file" , MODE_PRIVATE);
        final SharedPreferences.Editor editer = pref.edit();
        final String email1 =  pref.getString("email" , "abc@xyz.com");
        final String password1 = pref.getString("password" , "");
        email.setText(email1);
        Button login = (Button)findViewById(R.id.button);
        login.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        editer.putString("email" ,email1);
                        editer.putString("password" , password1);
                        editer.apply();
                        Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                        startActivity(intent);

                    }
                }
        );
    }

    protected void	onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME , "in onPause");
    }

    protected void	onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME , "in onStop");
    }

    protected void	onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME , "in onDestroy");
    }
}
