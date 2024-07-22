package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity4_shoppingcart extends AppCompatActivity {
   // Button btnstop;
   private int counter1 = 0;
    private int counter3 = 0;
    private int counter2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_shoppingcart);

        //btnstop=findViewById(R.id.checkoutbtn);

//        btnstop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(getBaseContext(),MyService.class);
//                stopService(intent);
//            }
//        });

        LinearLayout removeLayout1 = findViewById(R.id.layoutToremove1);
        LinearLayout removeLayout2 = findViewById(R.id.layoutToremove2);
        LinearLayout removeLayout3 = findViewById(R.id.layoutToremove3);

        ImageButton delete1 = findViewById(R.id.imageButton13);
        ImageButton delete2 = findViewById(R.id.imageButton6);
        ImageButton delete3 = findViewById(R.id.imageButton4);

        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLayout1.setVisibility(View.GONE);
            }
        });

        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLayout2.setVisibility(View.GONE);
            }
        });

        delete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLayout3.setVisibility(View.GONE);
            }
        });

        TextView quantitiy2= findViewById(R.id.textView22);
        TextView quantitiy1= findViewById(R.id.textView20);
        TextView quantitiy3= findViewById(R.id.textView25);
        ImageButton addBTN2=findViewById(R.id.imageButton11);
        ImageButton addBTN1=findViewById(R.id.imageButton9);
        ImageButton addBTN3=findViewById(R.id.imageButton15);

        ImageView p = findViewById(R.id.imageView18);

        addBTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                quantitiy2.setText(String.valueOf(counter2));
            }
        });
        addBTN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1++;
                quantitiy1.setText(String.valueOf(counter1));
            }
        });
        addBTN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter3++;
                quantitiy3.setText(String.valueOf(counter3));
            }
        });

        PopupMenu pop =new PopupMenu(this,p);
        pop.getMenuInflater().inflate(R.menu.menu_popup,pop.getMenu());
        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.msearch){
                    //handle search click
                }else
                if(id==R.id.mdelete){
                    //handle delete click
                }else if(id==R.id.mfav){
                    //handle fav click
                }else if(id==R.id.mexit){
                    //handle exit click
                }
                return false;
            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.show();
            }
        });
    }


    public void openCheckOut(View view){
        Intent intent= new Intent(this, MainActivity6_checkoutpage.class);
        startActivity(intent);

    }
    public void openHome(View view){
        Intent intent=new Intent(this, MainActivity3_homepage.class);
        startActivity(intent);
    }

}