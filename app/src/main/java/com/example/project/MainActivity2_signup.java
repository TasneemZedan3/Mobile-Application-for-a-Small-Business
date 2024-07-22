package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2_signup extends AppCompatActivity {
//Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_signup);

//        btn2=findViewById(R.id.btnSignUp2);
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2= new Intent(getBaseContext(),MyService.class);
//                startService(intent2);
//            }
//        });

    }

    public void openHome(View view){
        Intent intent=new Intent(this, MainActivity3_homepage.class);
        startActivity(intent);
    }
}