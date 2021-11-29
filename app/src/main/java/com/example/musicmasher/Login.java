package com.example.musicmasher;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RelativeLayout;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextInputLayout phoneNumber, password;
    RelativeLayout progressbar;
    CheckBox rememberMe;
    TextInputEditText phoneNumberEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.welcome);

        phoneNumber = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        progressbar = findViewById(R.id.login_progress_bar);
        phoneNumberEditText = findViewById(R.id.login_email_editText);
        passwordEditText = findViewById(R.id.login_password_editText);

    }

    /*
    Login the
    user in
    app!
     */
    public void logUserIn(View view) {
        startActivity(new Intent(getApplicationContext(), PFPActivity.class));
    }


    public void callForgetPassword(View view) {
        startActivity(new Intent(getApplicationContext(), PFPActivity.class));
    }


    public void callSignUpFromLogin(View view) {
        startActivity(new Intent(getApplicationContext(), PFPActivity.class));
    }
}
