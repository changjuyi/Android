package com.example.onlineproductapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Productdetails extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.onlinrproductapp.extra.MESSAGE";
    private String mOrderMessage;
    private TextView productName;
    private TextView productPrice;

    private int num;
    private TextView number;
    private int price;
    private String[] prices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);

        ImageView back = findViewById(R.id.back);//回上一頁
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Productdetails.this, MainActivity.class);
                startActivity(intent);
            }
        });

        number = findViewById(R.id.number);

        Button check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Productdetails.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
            }
        });

        productName = findViewById(R.id.product_name);

        productPrice = findViewById(R.id.product_price);
        //price = productPrice.getText().toString();
        prices = productPrice.getText().toString().split("\\s+");
        price = Integer.valueOf(prices[1]);
    }

    public void increaseNum(View view) {
        num++;
        number.setText(String.valueOf(num));
        mOrderMessage = productName.getText().toString()+ " : "+num+"\n Total:" + price*num;
    }

    public void decreaseNum(View view) {
        if(num <= 1){
            num = 1;
            number.setText(String.valueOf(num));
        }else{
            num--;
            number.setText(String.valueOf(num));
        }
        mOrderMessage = productName.getText().toString()+ " : "+num+"\n Total:"+ price*num;
    }


}