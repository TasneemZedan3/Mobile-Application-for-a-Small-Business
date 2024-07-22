package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonSignIn, buttonForgotPassword, buttonSignUp;
    private EditText editTextEmail, editTextPassword;
    private DataBase dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DataBase(this);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonForgotPassword = findViewById(R.id.buttonForgotPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        buttonForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showForgotPasswordMessage();
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()) {
                    dbHelper.insertLoginData(email, password);
                    Log.d("MainActivity", "Inserted: " + email);
                    Toast.makeText(MainActivity.this, "Login data inserted successfully", Toast.LENGTH_SHORT).show();

                    // Start background song service
                    Intent intent = new Intent(getBaseContext(), MyService.class);
                    Intent homeIntent = new Intent(MainActivity.this, MainActivity3_homepage.class);
                    startActivity(homeIntent);
                    startService(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Email or password is empty", Toast.LENGTH_SHORT).show();
                    Log.d("MainActivity", "Email or password is empty");
                }
            }
        });
    }

    public void openSignUp(View view){
        Intent intent = new Intent(this, MainActivity2_signup.class);
        startActivity(intent);
    }

    private void showForgotPasswordMessage() {
        Toast.makeText(this, "Confirmation email has been sent", Toast.LENGTH_SHORT).show();
    }
}