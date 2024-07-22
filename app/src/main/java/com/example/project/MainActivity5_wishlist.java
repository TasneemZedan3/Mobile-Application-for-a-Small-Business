package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity5_wishlist extends AppCompatActivity {
    private DataBase dbHelper;
    private EditText editTextProductName;
    private TextView textViewProductPrice;
    private Button buttonAddToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity5_wishlist);

        dbHelper = new DataBase(this);
        editTextProductName = findViewById(R.id.editTextText);
        textViewProductPrice = findViewById(R.id.textView3);
        buttonAddToCart = findViewById(R.id.button2);

        buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = editTextProductName.getText().toString();
                String productPriceString = textViewProductPrice.getText().toString();
                if (!productName.isEmpty() && !productPriceString.isEmpty()) {
                    double productPrice = Double.parseDouble(productPriceString.replace("LE ", ""));
                    dbHelper.insertProductData(productName, productPrice);

                    // Open shopping cart activity
                    Intent intent = new Intent(MainActivity5_wishlist.this, MainActivity4_shoppingcart.class);
                    startActivity(intent);
                }
            }
        });

        ImageView p = findViewById(R.id.imageView);
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
    public void openShopping(View view){
        Intent intent=new Intent(this, MainActivity4_shoppingcart.class);
        startActivity(intent);
    }
}