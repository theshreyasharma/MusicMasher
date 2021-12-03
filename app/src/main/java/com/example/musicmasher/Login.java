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

    TextInputLayout email, password;
    String username;
    RelativeLayout progressbar;
    TextInputEditText phoneNumberEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        progressbar = findViewById(R.id.login_progress_bar);
        phoneNumberEditText = findViewById(R.id.login_email_editText);
        passwordEditText = findViewById(R.id.login_password_editText);

    }

    public void logUserIn(View view) {
        username = email.getEditText().getText().toString();
        Intent intent = new Intent(view.getContext(), PFPActivity.class);
        intent.putExtra("USERNAME", username);
        startActivity(intent);
    }

    public void callSignUpFromLogin(View view) {
        startActivity(new Intent(getApplicationContext(), PFPActivity.class));
    }
}
