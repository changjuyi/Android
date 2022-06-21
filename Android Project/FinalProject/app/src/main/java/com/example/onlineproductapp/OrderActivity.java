package com.example.onlineproductapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ImageView back = findViewById(R.id.back_order);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(OrderActivity.this, Productdetails.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String message = intent.getStringExtra(Productdetails.EXTRA_MESSAGE);
        TextView comment = findViewById(R.id.order_textview);
        comment.setText(message);
    }
}