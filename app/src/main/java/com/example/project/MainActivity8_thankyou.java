package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity8_thankyou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity8_thankyou);
    }
    public void openShopping(View view){
        Intent intent=new Intent(this, MainActivity4_shoppingcart.class);
        startActivity(intent);
    }
}