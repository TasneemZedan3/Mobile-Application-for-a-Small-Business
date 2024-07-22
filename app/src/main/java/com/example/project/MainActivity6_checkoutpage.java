package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity6_checkoutpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity6_checkoutpage);

    }
    public void openShopping(View view){
        Intent intent=new Intent(this, MainActivity4_shoppingcart.class);
        startActivity(intent);
    }
    public void openThankyou(View view){
        Intent intent=new Intent(this, MainActivity8_thankyou.class);
        startActivity(intent);
    }
}