package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3_homepage extends AppCompatActivity {
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_homepage);

        btnLogout = findViewById(R.id.logoutbtn);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3_homepage.this);
                builder.setMessage("Are you sure you want to logout?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                confirmLogout();
                            }
                        })
                        .setNegativeButton("Cancel", null);
                builder.create().show();
            }
        });
    }

    public void openShopping(View view) {
        Intent intent = new Intent(this, MainActivity4_shoppingcart.class);
        startActivity(intent);
    }

    public void openWishList(View view) {
        Intent intent = new Intent(this, MainActivity5_wishlist.class);
        startActivity(intent);
    }

    public void openProduct(View view) {
        Intent intent = new Intent(this, MainActivity7_productpage.class);
        startActivity(intent);
    }

    public void openSignIn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void BackGroundSongEnd(View view) {
        Intent intent = new Intent(getBaseContext(), MyService.class);
        Intent intt = new Intent(this, MainActivity.class);
        startActivity(intt);
        stopService(intent);
    }

    private void confirmLogout() {
        BackGroundSongEnd(null);
    }
}
